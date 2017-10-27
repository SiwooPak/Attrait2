package www.sts.attrait;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import www.model.cart.CartService;
import www.model.product.ProductService;
import www.model.sell.SellService;
import www.model.user.UserService;

@Controller
public class SellController {
	@Autowired
	private ProductService productService;

	@Autowired
	private SellService sellService;

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;


	@RequestMapping(value="/sell/createSell", method=RequestMethod.GET)
	public ModelAndView createSell(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String productCode = request.getParameter("productCode");
		String sellPrice = request.getParameter("sellPrice");
		String sellCount = request.getParameter("sellCount");

		String fromCart = request.getParameter("fromCart");

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> sellParam = new HashMap<String, String>();

		sellParam.put("productCode", productCode);
		sellParam.put("userCode", userCode);
		sellParam.put("sellPrice", sellPrice);
		sellParam.put("sellCount", sellCount);

		//판매테이블에 저장
		sellService.createSell(sellParam);

		if(fromCart != null){
			Map<String, String> cartParam = new HashMap<String, String>();
			Map<String, String> productParam = new HashMap<String, String>();
			sellParam = new HashMap<String, String>();

			String cartCode = request.getParameter("cartCode");
			String sellCode = sellService.retrieveMaxSellCode();

			cartParam.put("cartCode", cartCode);
			sellParam.put("sellCode", sellCode);

			cartService.deleteCart(cartParam);
			sellService.updateSellYn(sellParam);

			mv.setViewName("redirect:/sell/retrieveSellConfirm?productCode=" + productCode);

		}else{
			mv.setViewName("redirect:/sell/retrieveSellList");
		}

		return mv;
	}

	@RequestMapping(value="/sell/updateFinalBuy", method=RequestMethod.GET)
	public ModelAndView updateFinalBuy(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> productParam = new HashMap<String, String>();
		Map<String, String> sellParam = new HashMap<String, String>();

		String productCode = request.getParameter("productCode");
		String sellCode = request.getParameter("sellCode");
		String sellCount = request.getParameter("sellCount");

		sellParam.put("sellCode", sellCode);

		productParam.put("productCode", productCode);
		productParam.put("productCount", sellCount);

		productService.updateProductCountMinus(productParam);

		sellService.updateSellYn(sellParam);

		mv.setViewName("redirect:/sell/retrieveSellConfirm?productCode=" + productCode);

		return mv;
	}

	@RequestMapping(value="/sell/retrieveSellConfirm", method=RequestMethod.GET)
	public ModelAndView retrieveSellConfirm(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String productCode = request.getParameter("productCode");

		mv.addObject("productCode", productCode);

		mv.setViewName("/sell/sellConfirmR");

		return mv;
	}


	@RequestMapping(value="/sell/retrieveSellList", method=RequestMethod.GET)
	public ModelAndView retrieveSellList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> sellParam = new HashMap<String, String>();

		sellParam.put("userCode", userCode);

		List<Map<String, String>> dsSellList = sellService.retrieveSellList(sellParam);

		mv.addObject("dsSellList", dsSellList);

		mv.setViewName("/sell/sellListR");

		return mv;
	}

	@RequestMapping(value="/sell/retrieveBuyList", method=RequestMethod.GET)
	public ModelAndView retrieveBuyList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> sellParam = new HashMap<String, String>();

		sellParam.put("userCode", userCode);

		List<Map<String, String>> dsBuyList = sellService.retrieveBuyList(sellParam);

		mv.addObject("dsBuyList", dsBuyList);

		mv.setViewName("/sell/sellBuyListR");

		return mv;
	}

	@RequestMapping(value="/sell/retrieveStatisticsForProduct",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForProduct(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");

		JsonArray jsonDonutArr = new JsonArray();
		JsonArray jsonBarArr = new JsonArray();

		List<Map<String, String>> dsProduct = sellService.retrieveStatisticsForProduct();
		JsonObject jsonObj = null;

		for(int i = 0; i < dsProduct.size(); i++){
			jsonObj = new JsonObject();
			String productname = dsProduct.get(i).get("PRODUCT_NAME");
			String sellPrice = String.valueOf(dsProduct.get(i).get("SELL_PRICE"));
			
			
			jsonObj.addProperty("label", productname);
			jsonObj.addProperty("value", sellPrice);
			

			jsonDonutArr.add(jsonObj);

			jsonObj = new JsonObject();

			jsonObj.addProperty("y", productname);
			jsonObj.addProperty("a", sellPrice);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsForSell");

		return mv;
	}

	@RequestMapping(value="/sell/retrieveStatisticsForCategory",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForCategory(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");

		JsonArray jsonDonutArr = new JsonArray();
		JsonArray jsonBarArr = new JsonArray();

		List<Map<String, String>> dsCategory = sellService.retrieveStatisticsForCategory();
		JsonObject jsonObj = null;

		for(int i = 0; i < dsCategory.size(); i++){
			jsonObj = new JsonObject();
			String productCategoryCd = dsCategory.get(i).get("PRODUCT_CATEGORY_CD");
			String sellPrice = String.valueOf(dsCategory.get(i).get("SELL_PRICE"));

			jsonObj.addProperty("label", productCategoryCd);
			jsonObj.addProperty("value", sellPrice);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JsonObject();

			jsonObj.addProperty("y", productCategoryCd);
			jsonObj.addProperty("a", sellPrice);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsForSell");

		return mv;
	}

}
