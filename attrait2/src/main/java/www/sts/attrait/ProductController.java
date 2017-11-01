package www.sts.attrait;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import www.model.code.CodeDTO;
import www.model.code.CodeService;
import www.model.product.ProductDTO;
import www.model.product.ProductService;
import www.model.reply.ReplyService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ReplyService replyService;

	@Autowired
	private CodeService codeService;

	@Transactional
	@RequestMapping(value="/product/createProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createProduct(@ModelAttribute ProductDTO product, HttpServletRequest request){
		List<CodeDTO> dsCode1 = null; 
		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> productParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); 

		mv.addObject("dsCode1", dsCode1);

		String flag = product.getProductName(); //ProductBean ���翩��

		if(flag == null){
			mv.setViewName("/stockmanage/stockRegisterC");
		}else if(flag != null){
			//��ǰ ����
			productService.createProduct(product);

			mv.addObject("dsProductList", productService.retrieveProductList(productParam));
			mv.setViewName("redirect:/product/retrieveProductListForManage");
		}

		return mv;
	}

	@Transactional
	@RequestMapping(value="/product/updateProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateProduct(@ModelAttribute ProductDTO product, HttpServletRequest request){
		String productCode = null;
		Map<String, String> dsProduct = null;
		List<CodeDTO> dsCode1 = null; //�з�

		ModelAndView mv = new ModelAndView();
		Map<String, String> codeParam = new HashMap<String, String>();
		Map<String, String> productParam = new HashMap<String, String>();

		codeParam.put("commTyCd", "CODE0101");
		dsCode1 = codeService.retrieveCodeList(codeParam); //�з�

		mv.addObject("dsCode1", dsCode1);

		String flag = product.getProductName(); //ProductBean ���翩��

		if(flag == null){
			HttpSession session = request.getSession();
			String userCode = (String)session.getAttribute("userCode");
			productCode = request.getParameter("productCode");

			productParam.put("productCode", productCode);
			productParam.put("userCode", userCode);

			dsProduct = productService.retrieveProduct(productParam);

			mv.addObject("dsProduct", dsProduct);

			mv.setViewName("/stockmanage/stockRegisterU");
		}else if(flag != null){
			//��ǰ ����
			productService.updateProduct(product);

			mv.addObject("dsProductList", productService.retrieveProductList(productParam));
			mv.setViewName("redirect:/product/retrieveProductListForManage");
		}

		return mv;
	}

	@RequestMapping(value="/product/goMain", method=RequestMethod.GET)
	public ModelAndView goMain(){
		ModelAndView mv = new ModelAndView();

		List<Map<String, String>> dsProductList = productService.retrieveProductListForMain();

		List<Map<String, String>> dsBinderList = productService.retrieveProductListForBinder();
		List<Map<String, String>> dsDesignList = productService.retrieveProductListForDesign();
		List<Map<String, String>> dsOfficeList = productService.retrieveProductListForOffice();
		List<Map<String, String>> dsPenList = productService.retrieveProductListForPen();
		List<Map<String, String>> dsStorageList = productService.retrieveProductListForStorage();

		mv.addObject("dsProductList", dsProductList);

		mv.addObject("dsDesignList", dsDesignList);
		mv.addObject("dsBinderList", dsBinderList);
		mv.addObject("dsOfficeList", dsOfficeList);
		mv.addObject("dsPenList", dsPenList);
		mv.addObject("dsStorageList", dsStorageList);

		mv.setViewName("/product/main");
		return mv;
	}

	@RequestMapping(value="/product/retrieveProductList", method=RequestMethod.GET)
	public ModelAndView retrieveProductList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String category = request.getParameter("category");

		Map<String, String> productParam = new HashMap<String, String>();

		productParam.put("category", category);

		List<Map<String, String>> dsProductList = productService.retrieveProductList(productParam);

		mv.addObject("dsProductList", dsProductList);
		mv.setViewName("/product/productListR");
		return mv;
	}

	@RequestMapping(value="/product/saveFile", method=RequestMethod.POST)
	@ResponseBody
	public String saveFile(HttpServletRequest request) throws IOException {
		String imageFolder = request.getParameter("imageFolder");
		String imgFolder ="\\" + imageFolder + "\\"; //������ ���
		@SuppressWarnings("deprecation")
		String realFolder = request.getRealPath("/") + imgFolder; 
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest)request;
		MultipartFile file = multipartRequest.getFile("imageFile"); //���� ���� ���ε�
		String filename = file.getOriginalFilename();

		File ufile = new File(realFolder + file.getOriginalFilename());
		file.transferTo((ufile));

		return filename;
	}

    @Transactional		
	@RequestMapping(value="/product/retrieveProduct", method=RequestMethod.GET)
	public ModelAndView retrieveProduct(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		String userCode = (String)session.getAttribute("userCode");
		String productCode = request.getParameter("productCode");

		Map<String, String> productParam = new HashMap<String, String>();
		Map<String, String> replyParam = new HashMap<String, String>();

		productParam.put("productCode", productCode);
		productParam.put("userCode", userCode);

		replyParam.put("productCode", productCode);

		Map<String, String> dsProduct = productService.retrieveProduct(productParam);

		List<Map<String, String>> dsReplyList = replyService.retrieveReplyList(replyParam);

		mv.addObject("dsProduct", dsProduct);
		mv.addObject("dsReplyList", dsReplyList);

		mv.setViewName("/product/productR");
		return mv;
	}

	@RequestMapping(value="/product/retrieveProductListForManage", method=RequestMethod.GET)
	public ModelAndView retrieveProductListForManage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> productParam = new HashMap<String, String>();

		List<Map<String, String>> dsProductList = productService.retrieveProductList(productParam);

		mv.addObject("dsProductList", dsProductList);
		mv.setViewName("/stockmanage/stockListR");
		return mv;
	}

	@RequestMapping(value="/product/retrieveStatisticsForStock",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForStock(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		Map<String, String> productParam = new HashMap<String, String>();

		String sort = request.getParameter("sort");
		String productCategoryCd = request.getParameter("productCategoryCd");

		productParam.put("productCategoryCd", productCategoryCd);

		JsonArray jsonDonutArr = new JsonArray();
		JsonArray jsonBarArr = new JsonArray();

		List<Map<String, String>> dsStock = productService.retrieveStatisticsForStock(productParam);
		JsonObject jsonObj = null;

		for(int i = 0; i < dsStock.size(); i++){
			jsonObj = new JsonObject();
			String productName = dsStock.get(i).get("PRODUCT_NAME");
			String productCount = String.valueOf(dsStock.get(i).get("PRODUCT_COUNT"));

			jsonObj.addProperty("label", productName);
			jsonObj.addProperty("value", productCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JsonObject();
			
			jsonObj.addProperty("y", productName);
			jsonObj.addProperty("a", productCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsForStock");

		return mv;
	}

	@RequestMapping(value="/product/retrieveStatisticsForSell",method=RequestMethod.GET)
	public ModelAndView retrieveStatisticsForSell(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		String sort = request.getParameter("sort");

		JsonArray jsonDonutArr = new JsonArray();
		JsonArray jsonBarArr = new JsonArray();

		List<Map<String, String>> dsSell = productService.retrieveStatisticsForSell();
		JsonObject jsonObj = null;

		for(int i = 0; i < dsSell.size(); i++){
			jsonObj = new JsonObject();
			String productName = dsSell.get(i).get("PRODUCT_NAME");
			String sellCount = String.valueOf(dsSell.get(i).get("SELL_COUNT"));
			
			jsonObj.addProperty("label", productName);
			jsonObj.addProperty("value", sellCount);

			jsonDonutArr.add(jsonObj);

			jsonObj = new JsonObject();
			
			jsonObj.addProperty("y", productName);
			jsonObj.addProperty("a", sellCount);

			jsonBarArr.add(jsonObj);
		}

		mv.addObject("objDonut", jsonDonutArr);
		mv.addObject("objBar", jsonBarArr);

		if(sort != null) mv.addObject("sort", sort);

		mv.setViewName("/statistics/statisticsForStock");

		return mv;
	}
}
