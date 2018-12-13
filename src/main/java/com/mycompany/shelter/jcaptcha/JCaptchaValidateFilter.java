package com.mycompany.shelter.jcaptcha;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JCaptchaValidateFilter extends AccessControlFilter {

    private boolean jcaptchaEbabled = true;//�Ƿ�����֤��֧��

    private String jcaptchaParam = "jcaptchaCode";//ǰ̨�ύ����֤�������

    private String failureKeyAttribute = "shiroLoginFailure"; //��֤����֤ʧ�ܺ�洢����������

    public void setJcaptchaEbabled(boolean jcaptchaEbabled) {
        this.jcaptchaEbabled = jcaptchaEbabled;
    }
    public void setJcaptchaParam(String jcaptchaParam) {
        this.jcaptchaParam = jcaptchaParam;
    }
    public void setFailureKeyAttribute(String failureKeyAttribute) {
        this.failureKeyAttribute = failureKeyAttribute;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //1��������֤���Ƿ������ԣ�ҳ����Ը��ݸ������������Ƿ���ʾ��֤��
        request.setAttribute("jcaptchaEbabled", jcaptchaEbabled);

        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        //2���ж���֤���Ƿ���� ���Ǳ��ύ��������ʣ�
        if (jcaptchaEbabled == false || !"post".equalsIgnoreCase(httpServletRequest.getMethod())) {
            return true;
        } 
        boolean flag=JCaptcha.validateResponse(httpServletRequest, httpServletRequest.getParameter(jcaptchaParam));
        //3����ʱ�Ǳ��ύ����֤��֤���Ƿ���ȷ
        return flag;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //�����֤��ʧ���ˣ��洢ʧ��key����
        request.setAttribute(failureKeyAttribute, "jCaptcha.error");
        return true;
    }
}