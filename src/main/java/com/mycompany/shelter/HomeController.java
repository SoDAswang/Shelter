package com.mycompany.shelter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mycompany.shelter.entity.Login;
import com.mycompany.shelter.entity.Sample;
import com.mycompany.shelter.entity.iUser;
import com.mycompany.shelter.service.LoginService;
import com.mycompany.shelter.service.MaterialService;
import com.mycompany.shelter.service.SampleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private MaterialService materialService;

	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private LoginService loginService;

	@Autowired
	HttpServletRequest request;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		// List<iUser> l=iuservice.findall();
		// System.out.println(l);

		// List l=materialService.findDetails();
		// System.out.println(l);
		String hashAlgorithmName = "MD5";
		String credentials = "111";
		int hashIterations = 1024;
		ByteSource credentialsSalt = ByteSource.Util.bytes("18211111111");
		Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
		System.out.println(obj);

		HttpSession session = request.getSession();
//		session.setAttribute("customerId", "1");
		model.addAttribute("session", session.getAttribute("customerId"));

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = "/material", method = RequestMethod.GET)
	public String material(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();

		model.addAttribute("session", session.getAttribute("customerId"));
		return "material/material";
	}

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String estimate(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();

		List samples = sampleService.findTop4();

		model.addAttribute("samples", samples);
		model.addAttribute("session", session.getAttribute("customerId"));

		return "sample/sample";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String gteat(Locale locale, Model model) {
		logger.info("Welcome test! The client locale is {}.", locale);

		return "test";
	}

	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			 RedirectAttributes attr) {

/*		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				currentUser.login(token);
			} catch (Exception e) {
				System.out.println("登录失败：" + e.getMessage());
			}
		}*/


		ModelAndView mv = new ModelAndView();
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String error = null;

		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名不存在";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if ("jCaptcha.error".equals(exceptionClassName)) {
			error = "验证码错误";
		} else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
			error = "失败次数过多，请60秒后再试";
		} else if (exceptionClassName != null) {
			error = "其他错误：" + exceptionClassName;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("customerId", username);

		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("session", session.getAttribute("customerId"));	*/	
		mv.setView(new RedirectView(request.getParameter("url"), true, true, false));
		attr.addFlashAttribute("error", error);
		return mv;
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(String username, String password,
			Model model) {
		boolean isExisted = false;

		if (loginService.findPasswordByUsername(username).size() < 1) {
//			Encrypt the password.
			String hashAlgorithmName = "MD5";
		    String credentials = password;
		    int hashIterations = 1024;  // Encryption time is 1024.
		    ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		    Object encryptedPassword = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations); // 'encryptedPassword' is encrypted password.
			
	        Login login = new Login();
	        login.setUsername(username);
	        login.setPassword(encryptedPassword.toString());
	        login.setRole("1"); // Role 1 is customer.
			
			loginService.save(login);
		} else {
			isExisted = true;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("isExisted", isExisted);
		
		return map;
	}
}
