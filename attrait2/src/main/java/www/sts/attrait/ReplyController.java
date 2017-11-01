package www.sts.attrait;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import www.model.mark.MarkService;
import www.model.reply.ReplyService;



@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@Autowired
	private MarkService markService;

	@Transactional	
	@RequestMapping(value="/reply/createReply", method=RequestMethod.POST)
	public ModelAndView createReply
	(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		Map<String, String> replyParam = new HashMap<String, String>();
		Map<String, String> markParam = new HashMap<String, String>();

		String userCode = (String)session.getAttribute("userCode");
		String productCode = request.getParameter("productCode");
		String userReply = request.getParameter("userReply");
		String markYn = request.getParameter("markYn");
		String markRating = request.getParameter("markRating");

		replyParam.put("userCode", userCode);
		replyParam.put("productCode", productCode);
		replyParam.put("userReply", userReply);
		
		//별점
		if("N".equals(markYn)){
			markParam.put("productCode", productCode);
			markParam.put("userCode", userCode);
			markParam.put("markRating", markRating);

			markService.createMark(markParam);
		}

		//상품평 등록
		replyService.createReply(replyParam);

		mv.setViewName("redirect:/product/retrieveProduct?productCode=" + productCode);

		return mv;
	}

	@RequestMapping(value="/reply/deleteReply", method=RequestMethod.GET)
	public ModelAndView deleteReply(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		Map<String, String> replyParam = new HashMap<String, String>();

		String userCode = (String)session.getAttribute("userCode");
		String productCode = request.getParameter("productCode");
		String userReplyNo = request.getParameter("userReplyNo");

		replyParam.put("userCode", userCode);
		replyParam.put("productCode", productCode);
		replyParam.put("userReplyNo", userReplyNo);

		//�뙎湲� �궘�젣
		replyService.deleteReply(replyParam);

		mv.setViewName("redirect:/product/retrieveProduct?productCode=" + productCode);

		return mv;
	}

}
