package com.mycompany.shelter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.shelter.entity.Favorite;
import com.mycompany.shelter.entity.OrderGoods;
import com.mycompany.shelter.service.FavoriteService;
import com.mycompany.shelter.service.OrderService;
import com.mycompany.shelter.service.SampleService;
import com.mycompany.shelter.service.WishService;

import javassist.tools.reflect.Sample;

@Controller
@RequestMapping(value = "/personal/favorite")
public class FavoriteController {
	private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private WishService wishService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String favorite (HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		List<Object[]> materials = favoriteService.findMaterialsByCustomerId(customerId);
		List<Object[]> wishes = wishService.findWishByCustomerId(customerId);

		model.addAttribute("materials", materials);
		model.addAttribute("wishes", wishes);
		model.addAttribute("session", customerId);

		return "personal/personal_favorite";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addToFavorite(HttpServletRequest request, Locale locale, Model model,
			String materialId) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");

		int result = 0;
		if (favoriteService.ifExisted(customerId, materialId) == 0) {
			Favorite favorite = new Favorite();
			favorite.setCustomerId(customerId);
			favorite.setMaterialId(materialId);

			favoriteService.save(favorite);
			result = 200;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", result);
		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteFavorite(HttpServletRequest request, Locale locale, Model model,
			String materialId) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");

		int result = favoriteService.deleteByCustomerIdAndMaterialId(customerId, materialId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value = "/chooseWish/{materialId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> chooseWish(Locale locale, Model model,
			@PathVariable String materialId) {
		List<String> colors = sampleService.findColorByMaterialIdFromSampleMaterial(materialId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("colors", colors);
		return map;
	}
	
	@RequestMapping(value = "/addMaterialToWish", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addMaterialToWish(Locale locale, Model model,
			String materialId, String color, String wishId) {
		OrderGoods orderGoods = new OrderGoods();
		orderGoods.setMaterialId(materialId);
		orderGoods.setColor(color);
		orderGoods.setWishId(wishId);
		orderGoods.setNum("1");
		
		boolean flag = false;
//		If this kind of material has been saved into table(order_goods), don't save again.
		if (orderService.findOrderGoodsIdByWishIdAndMaterialIdAndColor(wishId, materialId, color).equals("0")) {
			orderService.save(orderGoods);
		} else {
			flag = true;
		}
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 200);
		map.put("isExisted", flag);
		return map;
	}
	
}
