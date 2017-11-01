package www.sts.attrait;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import www.model.cart.CartService;
import www.model.product.ProductService; 

@Controller
public class CartController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Transactional
	@RequestMapping(value="/cart/createCart", method=RequestMethod.GET)
	public ModelAndView createCart(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String productCode = request.getParameter("productCode");
		String cartPrice = request.getParameter("cartPrice");
		String cartCount = request.getParameter("cartCount");

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> cartParam = new HashMap<String, String>();
		Map<String, String> productParam = new HashMap<String, String>();

		cartParam.put("productCode", productCode);
		cartParam.put("userCode", userCode);
		cartParam.put("cartPrice", cartPrice);
		cartParam.put("cartCount", cartCount);

		//��ٱ��� ���̺� ����
		cartService.createCart(cartParam);

		productParam.put("productCode", productCode);
		productParam.put("productCount", cartCount);

		productService.updateProductCountMinus(productParam);

//		productService.updateProductCountMinus(productParam);

		mv.setViewName("redirect:/cart/retrieveCartList");

		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/cart/deleteCart", method=RequestMethod.GET)
	public ModelAndView deleteCart(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> cartParam = new HashMap<String, String>();
		Map<String, String> productParam = new HashMap<String, String>();

		String cartCode = request.getParameter("cartCode");
		String productCode = request.getParameter("productCode");
		String productCount = request.getParameter("productCount");

		cartParam.put("cartCode", cartCode);

		cartService.deleteCart(cartParam);

		productParam.put("productCode", productCode);
		productParam.put("productCount", productCount);

		productService.updateProductCountPlus(productParam);

		mv.setViewName("redirect:/cart/retrieveCartList");

		return mv;
	}

	@RequestMapping(value="/cart/retrieveCartConfirm", method=RequestMethod.GET)
	public ModelAndView retrieveCartConfirm(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String productCode = request.getParameter("productCode");

		mv.addObject("productCode", productCode);

		mv.setViewName("/cart/cartConfirmR");

		return mv;
	}


	@RequestMapping(value="/cart/retrieveCartList", method=RequestMethod.GET)
	public ModelAndView retrieveCartList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");

		Map<String, String> cartParam = new HashMap<String, String>();

		cartParam.put("userCode", userCode);

		List<Map<String, String>> dsCartList = cartService.retrieveCartList(cartParam);

		mv.addObject("dsCartList", dsCartList);

		mv.setViewName("/cart/cartListR");

		return mv;
	}

}
