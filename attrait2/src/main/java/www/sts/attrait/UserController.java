package www.sts.attrait;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import www.model.code.CodeDTO;
import www.model.code.CodeService;
import www.model.user.UserDTO;
import www.model.user.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private CodeService codeService;

	@RequestMapping(value="/user/idCheck", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> idCheck(HttpServletRequest request){
		String id = request.getParameter("id");
		UserDTO bean = userService.retrieveUser(id);
		String checkMsg = "<font color='green' size='3px;'><i class='fa fa-check'>&nbsp;사용가능한 아이디 입니다.</i></font>@true";

		if(bean != null){
			checkMsg = "<font color='red' size='3px;'><i class='fa fa-times'>&nbsp;동일한 아이디가 존재합니다.</i></font>@false";
		}
		
		if(id==null || id.equals("")){
			checkMsg = "<font color='red' size='3px;'><i class='fa fa-times'>&nbsp;아이디를 입력하세요.</i></font>@false";
		}

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<String>(checkMsg, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/user/ajaxLoginCheck")
	@ResponseBody
	public Map<String, String> ajaxLogincheck(HttpServletRequest request
											, @RequestParam(value="id", required=false) String id
											, @RequestParam(value="pw", required=false) String pw){
		Map<String, String> loginYnMap = new HashMap<String, String>();

		boolean check = false;
		check = userService.logincheck(id, pw);

		if(check){
			loginYnMap.put("loginYn", "success");
		}else{
			loginYnMap.put("loginYn", "fail");
		}

		return loginYnMap;
	}

	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String login(){
		return "/user/login";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String login(@ModelAttribute UserDTO bean, HttpServletRequest request){
		HttpSession session = request.getSession();

		UserDTO userBean = userService.retrieveSessionInfo(bean.getId());

		String userCode = userBean.getUserCode();
		String id = userBean.getId();
		String grade = userBean.getGrade();

		session.setAttribute("userCode", userCode);
		session.setAttribute("grade", grade);
		session.setAttribute("id", id);

		session.setMaxInactiveInterval(-1); //���� ���Ѵ�
		return "redirect:/product/goMain";
	}

	@RequestMapping(value="/user/retrieveUserId", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> retrieveUserId(HttpServletRequest request){
		String checkMsg = "";
		String email = request.getParameter("email");
		String id = userService.retrieveUserId(email);

		Map<String, String> idMap = new HashMap<String, String>();

		if(id == null){
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>�ش��ϴ� ID�� �������� �ʽ��ϴ�</p>"
					+ "</div>";
		}else{
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>ȸ������ ID�� <font color='red'><strong>" + id + "</strong></font>�Դϴ�."
					+ " <a href='login.jsp'>�α��� �������� �̵�</a>|<a href='pwFind.jsp'>PWã��</a></p>"
					+ "</div>";
		}

		idMap.put("checkMsg", checkMsg);

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<Map<String, String>>(idMap, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/user/retrieveUserPw", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> retrieveUserPw(HttpServletRequest request){
		String checkMsg = "";
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String pw = userService.retrieveUserPw(id, email);

		Map<String, String> idMap = new HashMap<String, String>();

		if(pw == null){
			checkMsg = "<div class='col-md-5 col-md-offset-2'>"
					+ "<p>패스워드를 입력하시오</p>"
					+ "</div>";
		}else{
			checkMsg = "<div class='col-md-4 col-md-offset-2'>"
					+ "<p>ȸ������ PW�� <font color='blue'><strong>" + pw + "</strong></font>�Դϴ�."
					+ " <a href='login.jsp'>�α��� �������� �̵�</a></p>"
					+ "</div>";
		}

		idMap.put("checkMsg", checkMsg);

		HttpHeaders resHeader = new HttpHeaders();
		resHeader.add("Content-Type","text/html;charset=UTF-8");
		ResponseEntity resultMsg = new ResponseEntity<Map<String, String>>(idMap, resHeader, HttpStatus.OK);
		return resultMsg;
	}

	@RequestMapping(value="/user/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.removeAttribute("userCode");
		session.invalidate();
		return "redirect:/product/goMain";

	}

	@RequestMapping(value="/user/createUser", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView createUser(@ModelAttribute UserDTO dto){
		ModelAndView mv = new ModelAndView();
        String id = dto.getId(); 
		Map<String, String> codeParam = new HashMap<String, String>();

		if(id == null){
			codeParam.put("commTyCd", "CODE0100");
			List<CodeDTO> dsCode1 = codeService.retrieveCodeList(codeParam);
			mv.addObject("dsCode1", dsCode1);
			mv.setViewName("/user/userC");
		}else{
			dto.toString();
			userService.createUser(dto);
			mv.setViewName("/user/login");
		}
		return mv;
	}

	@RequestMapping(value="/user/updateUser", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateUser(HttpServletRequest request, @ModelAttribute UserDTO dto){
		HttpSession session = request.getSession();

		ModelAndView mv = new ModelAndView();
        String id = (String) session.getAttribute("id"); //������ GET(create����), ������ POST(create)
        String flag = dto.getName();
		Map<String, String> codeParam = new HashMap<String, String>();

		UserDTO dsUser = userService.retrieveUser(id);

		if(flag == null){
			codeParam.put("commTyCd", "CODE0100");

			List<CodeDTO> dsCode1 = codeService.retrieveCodeList(codeParam);

			mv.addObject("dsUser", dsUser);
			mv.addObject("dsCode1", dsCode1);
			mv.setViewName("/user/userU");
		}else{
			String userCode = dsUser.getUserCode();
			dto.setUserCode(userCode);
			userService.updateUser(dto);
			mv.setViewName("redirect:/product/goMain");
		}
		return mv;
	}

	
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		session.removeAttribute("id");
		session.removeAttribute("userCode");
		session.invalidate();
	}

	
	@RequestMapping(value="/user/idFind", method = {RequestMethod.GET, RequestMethod.POST})
	public String idFind(){
		return "/user/idFind";
	}
	
	@RequestMapping(value="/user/pwFind", method = {RequestMethod.GET, RequestMethod.POST})
	public String pwFind(){
		return "/user/pwFind";
	}
}
