package com.mycompany.shelter.jcaptcha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.entity.Login;
import com.mycompany.shelter.service.LoginService;




@Service("jdbcRealm")
public class TestRealm extends AuthorizingRealm{
	@Autowired
	private LoginService LoginService;
	@Autowired
	private HttpServletRequest httpRequest;
	 static String userrole;
	
    @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
       String username = (String)principals.getPrimaryPrincipal();  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        Set<String> roles = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        permissions.add("all");
       /* Customer customer=customerService.findByUsername(username);
        if(customer != null ){
        if("已认证".equals(customer.getState())){
        roles.add("1");}}*/
        roles.add("1");
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;  
    }  

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken)paramAuthenticationToken;
		List<Login> user=new ArrayList<Login>();
		Object principal = token.getUsername();
		Object credentials = token.getPassword();	
		user=LoginService.findPasswordByUsername(principal.toString());
	 ByteSource credentialsSalt = ByteSource.Util.bytes(principal);  
	   if (user.isEmpty()) {  
           // �׳� �ʺ��Ҳ����쳣  
           throw new UnknownAccountException();  
       }  
	  
	 /*  try {
		httpRequest.getSession().setAttribute("uuu", userrole);
		System.out.println(httpRequest.getSession().getAttribute("uuu"));
	} catch (Exception e) {
		e.printStackTrace();
	}*/
		SimpleAuthenticationInfo info = 
					new SimpleAuthenticationInfo(principal, user.get(0).getPassword(), credentialsSalt,getName()); //�˴�shiro�Լ����Զ���������ĶԱ�
		return info;
	
	}

	

}
