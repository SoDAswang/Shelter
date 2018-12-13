package com.mycompany.shelter.jcaptcha;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;


public class KickoutSessionControlFilter extends AccessControlFilter {
	
	static String k=null;
    private String kickoutUrl; //�߳��󵽵ĵ�ַ
    private boolean kickoutAfter = false; //�߳�֮ǰ��¼��/֮���¼���û� Ĭ���߳�֮ǰ��¼���û�
    private int maxSession = 1; //ͬһ���ʺ����Ự�� Ĭ��1

    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if(!subject.isAuthenticated() && !subject.isRemembered()) {
            //���û�е�¼��ֱ�ӽ���֮�������
            return true;
        }

        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        Serializable sessionId = session.getId();

        //TODO ͬ������
        Deque<Serializable> deque = cache.get(username);
        if(deque == null) {
            deque = new LinkedList<Serializable>();
            cache.put(username, deque);
        }

        //���������û�д�sessionId�����û�û�б��߳����������
        if(!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }

        //����������sessionId���������Ự������ʼ����
        while(deque.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if(kickoutAfter) { //����߳�����
                kickoutSessionId = deque.removeFirst();
            } else { //�����߳�ǰ��
                kickoutSessionId = deque.removeLast();
            }
            try {
                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                if(kickoutSession != null) {
                    //���ûỰ��kickout���Ա�ʾ�߳���
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (Exception e) {
            	
            }
        }

        //������߳��ˣ�ֱ���˳����ض����߳���ĵ�ַ
        if (session.getAttribute("kickout") != null) {
            //�Ự���߳���
            try {
                subject.logout();
            } catch (Exception e) { //ignore
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoutUrl);
            String kickout="kickout";
            HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
            httpServletRequest.getSession().setAttribute("kickout", kickout);           
            return false;
        }
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        httpServletRequest.getSession().setAttribute("customerId", username);
        return true;
    }
}
