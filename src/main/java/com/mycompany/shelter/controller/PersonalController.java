package com.mycompany.shelter.controller;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.shelter.entity.OrderGoods;
import com.mycompany.shelter.service.CalculateService;
import com.mycompany.shelter.service.SampleService;
import com.mycompany.shelter.service.WishService;
import com.mycompany.shelter.service.MaterialService;
import com.mycompany.shelter.service.OrderService;
import com.mycompany.shelter.util.*;

@Controller
@RequestMapping(value = "/personal")
public class PersonalController {
	private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

	@Autowired
	private WishService wishService;
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private CalculateService calculateService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String information(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
//		String customerId = (String) session.getAttribute("customerId");
		
		model.addAttribute("session", session.getAttribute("customerId"));
		
		return "personal/personal_info";
	}
	
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public String wish(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("customerId");
		
		List<Object[]> wishes = wishService.findWishByCustomerId(customerId);
		
		model.addAttribute("wishes", wishes);
		model.addAttribute("session", customerId);

		return "personal/personal_wish";
	}
	
	@RequestMapping(value = "/wish/{wishId}", method = RequestMethod.GET)
	public String wishDetail(HttpServletRequest request, Locale locale, Model model, @PathVariable String wishId) {
		HttpSession session = request.getSession();
		
		List<Object[]> materialList = orderService.findMaterialByWishId(wishId);
		String sampleId = wishService.findByWishId(Integer.parseInt(wishId)).getSampleId();
        String subject = wishService.findByWishId(Integer.parseInt(wishId)).getSubject();
        String title = sampleService.findById(sampleId).getTitle();
//		下行需要改动
//		List<Object[]> furnitureList = sampleService.findFurnitureBySampleIdAndSubject(sampleId, subject);
		
		List<Object[]> distinctWallList = orderService.findDistinctMaterialByWishIdAndLocation(wishId, "墙面");
		
		model.addAttribute("materialList", materialList);
//		下行完整代码后需要
//		model.addAttribute("furnitureList", furnitureList);
		
		model.addAttribute("subject", subject);
		model.addAttribute("title", title);
		model.addAttribute("wishId", wishId);
		model.addAttribute("distinctWallList", distinctWallList);
		model.addAttribute("session", session.getAttribute("customerId"));

		return "personal/personal_wish_detail";
	}
	
	// restore Wish Detail page.
	@RequestMapping(value = "/wish/restore/{wishId}", method = RequestMethod.GET)
	public String restoreWishDetail(Locale locale, Model model, @PathVariable String wishId) {
		orderService.restoreOrderGoodsByWishId(wishId);
		
		return "redirect:/personal/wish/{wishId}";
	}
	
	@RequestMapping(value = "/wish/color/{wishId}/{materialId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> specification (@PathVariable String wishId, @PathVariable String materialId){		
		Map<String, Object> map = new HashMap<String, Object>();		
		List<String> color = orderService.findColorByWishIdAndMaterialId(wishId, materialId);
		String title = materialService.findByMaterialId(materialId).getTitle();
		map.put("statusCode", 200);
		map.put("color", color);
		map.put("title", title);
		
		return map;
	}
	
	@RequestMapping(value = "/wish/wallMaterial/{wishId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> wallMaterial(@PathVariable String wishId) {		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> distinctWallList = wishService.findDistinctMaterialByWishIdAndLocation(Integer.parseInt(wishId), "墙面");
		map.put("statusCode", 200);
		map.put("distinctWallList", distinctWallList);
		
		return map;
	}	
	
	@RequestMapping(value = "/wish/deleteWish/{wishId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteWish (String wishId){
		Map<String, Object> map = new HashMap<String, Object>();		
		wishService.deleteById(Integer.parseInt(wishId));
		orderService.deleteByWishId(wishId);
		map.put("result", 1);
		return map;
	}
	
	// not used?
	@RequestMapping(value = "/{customerId}/wish/{wishId}/deleteMaterial/{orderGoodsId}", method = RequestMethod.GET)
	public String deleteMaterial(@PathVariable String customerId, @PathVariable String orderGoodsId) {
		orderService.deleteByOrderGoodsId(orderGoodsId);
		return "redirect:/personal/{customerId}/wish/{wishId}";
	}

	@RequestMapping(value = "/wish/calculate/{wishId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> calcualte(@PathVariable String wishId, String floor_s, String wallInfo) {
		Map<String, Object> map = new HashMap<String, Object>();	

		String[][] resolvedWallAccount = ResolveStringToArray.StringToDyadicArray(wallInfo, 3);
		String[][] wallAccount = calculateService.calculateWallAmount(resolvedWallAccount, wishId);

		String floor_amount_id = "amount_" + orderService.findMaterialByWishIdAndLocation(wishId, "地面").get(0)[17];
		String floor_amount = calculateService.calculateFloorAmount(floor_s, wishId) + "";

		map.put("statusCode", 200);
		map.put("floor_amount_id", floor_amount_id);
		map.put("floor_amount", floor_amount);
		map.put("wallAccount", wallAccount);
		return map;
	}
	
	@RequestMapping(value = "/wish/{wishId}/removeSelected", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> calcualte(@PathVariable String wishId, String orderGoodsIds) {
		
		Map<String, Object> map = new HashMap<String, Object>();	
		String[] resolvedOrderGoodsIds = ResolveStringToArray.StringToArray(orderGoodsIds);
		String[] colorByDeletedGoods = new String[resolvedOrderGoodsIds.length];
		int i = 0;
		
		for (String ogId : resolvedOrderGoodsIds) {
			colorByDeletedGoods[i] = orderService.findByOrderGoodsId(ogId).getColor();
			i++;
			orderService.deleteByOrderGoodsId(ogId);
		}
		
		map.put("statusCode", 200);
		map.put("colorByDeletedGoods", colorByDeletedGoods);

		return map;
	}
	
	@RequestMapping(value = "/wish/removeMaterial", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removeMaterial(String orderGoodsId) {
		Map<String, Object> map = new HashMap<String, Object>();	
		OrderGoods orderGoods = orderService.findByOrderGoodsId(orderGoodsId);
		orderService.deleteByOrderGoodsId(orderGoodsId);

		map.put("statusCode", 200);
		map.put("orderGoods", orderGoods);

		return map;
	}
	
	@RequestMapping(value = "/wish/color", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> color (String materialId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> colors = sampleService.findColorByMaterialIdFromSampleMaterial(materialId);
		
		map.put("statusCode", 200);
		map.put("colors", colors);
		
		return map;
	}
	
	@RequestMapping(value = "/wish/findOrderGoodsId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findOrderGoodsId (String materialId, String color, String wishId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderGoodsId = orderService.findOrderGoodsIdByWishIdAndMaterialIdAndColor(wishId, materialId, color);

		map.put("statusCode", 200);
		map.put("orderGoodsId", orderGoodsId);
		
		return map;
	}
	
	@RequestMapping(value = "/wish/orderGoods/{orderGoodsId}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findColorByOrderGoodsId (@PathVariable String orderGoodsId) {
		Map<String, Object> map = new HashMap<String, Object>();
		OrderGoods orderGoods = orderService.findByOrderGoodsId(orderGoodsId);

		map.put("statusCode", 200);
		map.put("orderGoods", orderGoods);
		
		return map;
	}
	
	@RequestMapping(value = "/wish/editColor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editColor (String orderGoodsId, String color) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String materialId = orderService.findByOrderGoodsId(orderGoodsId).getMaterialId();
		String wishId = orderService.findByOrderGoodsId(orderGoodsId).getWishId();
		String orderGoodsIdConflicted = orderService.findOrderGoodsIdByWishIdAndMaterialIdAndColor(wishId, materialId, color);
		
//		Not find orderGoodsId.
		if (!orderGoodsIdConflicted.equals("0")) {
			orderService.deleteByOrderGoodsId(orderGoodsIdConflicted);
		}
		
		orderService.updateColorByOrderGoodsId(orderGoodsId, color);

		map.put("statusCode", 200);
		map.put("orderGoodsIdConflicted", orderGoodsIdConflicted);
		
		return map;
	}	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
//		String customerId = (String) session.getAttribute("customerId");
		
		model.addAttribute("session", session.getAttribute("customerId"));

		return "personal/personal_order";
	}
}
