package com.mycompany.shelter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.shelter.entity.Material;
import com.mycompany.shelter.entity.Sample;
import com.mycompany.shelter.entity.SampleMaterial;
import com.mycompany.shelter.entity.Wish;
import com.mycompany.shelter.entity.iUser;
import com.mycompany.shelter.service.OrderService;
import com.mycompany.shelter.service.SampleService;
import com.mycompany.shelter.service.WishService;
import com.mycompany.shelter.service.iUserService;

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private WishService wishService;
	
	@Autowired
	private iUserService iUserService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/{sampleId}", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Locale locale, Model model, @PathVariable String sampleId) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		Sample sample = sampleService.findById(sampleId);
		model.addAttribute("sample", sample);
		
		@SuppressWarnings("rawtypes")
		List sdLists = new ArrayList();
		
		List<String> subjects = sampleService.findAllSubjects(sampleId);
		
		for (String sub : subjects) {
			
			List<Object[]> materialList =  sampleService.findMaterilBySampleIdAndSubject(sampleId, sub);
			List<Object[]> furnitureList =  sampleService.findFurnitureBySampleIdAndSubject(sampleId, sub);
			
			Map<String, Object> sdList= new HashMap<String, Object>();
			sdList.put("subjectTitle", sub);
			sdList.put("materialList", materialList);
			sdList.put("furnitureList", furnitureList);
			sdLists.add(sdList);
					
		}
		
		model.addAttribute("sdLists", sdLists);
		model.addAttribute("sampleId", sampleId);
		model.addAttribute("session", customerId);

		return "sample/sample_detail";
	}
	
	@RequestMapping(value = "/addToWish", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addToWish (HttpServletRequest request, String sampleId, String subject){
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;

		int ifExistsCount = wishService.ifExistsWish(customerId, sampleId, subject);
		if (ifExistsCount == 0) {
			Wish wish = new Wish();
			wish.setCustomerId(customerId);
			wish.setSampleId(sampleId);
			wish.setSubject(subject);
			
			orderService.saveOrderGoods(wishService.saveWish(wish)+"");	
			status = 200;
		}		
		
		map.put("status", status);		
		return map;
	}

}
