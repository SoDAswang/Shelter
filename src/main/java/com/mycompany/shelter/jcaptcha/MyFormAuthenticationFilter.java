package com.mycompany.shelter.jcaptcha;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyFormAuthenticationFilter extends FormAuthenticationFilter {



    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	
        if(request.getAttribute(getFailureKeyAttribute()) != null) {
        	
            return true;//true ��¼ʧ��
        }
        boolean flag = super.onAccessDenied(request, response, mappedValue);
        return flag;
    }
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
 
        return false;
    }
    
    
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,Subject subject,ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.redirectToSavedRequest(request, response, request.getParameter("url"));
    	
    	return false;
    }
}