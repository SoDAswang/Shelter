package com.mycompany.shelter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.shelter.entity.Material;
import com.mycompany.shelter.service.MaterialService;

@Controller
@RequestMapping(value = "/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String category(HttpServletRequest request, Locale locale, Model model){
	    HttpSession session = request.getSession();

		List categories=materialService.findAllAndFavor((String) session.getAttribute("customerId"));
		
		model.addAttribute("categories", categories);
		model.addAttribute("session", session.getAttribute("customerId"));
		
		return "material/material_category";
	}
	
	@RequestMapping(value = "/categoryByClass", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> filterCategoryByClass (String style, String texture, String fit, String price){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Material> categories = materialService.findByClass(style, texture, fit, price);
		map.put("categories", categories);		
		return map;
	}
}
