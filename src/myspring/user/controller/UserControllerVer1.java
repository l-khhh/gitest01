package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

//@Controller
public class UserControllerVer1 {
	@Autowired
	private UserService userService;

	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		
		
//		List<UserVO> userList = userService.getUserList();
//		model.addAttribute("userList", userList);
//		return "userList";
		
		
		List<UserVO> userList = userService.getUserList();
		
		JSONObject jsonObject = new JSONObject();	//최종 완성될 jsonobject 선언
		JSONArray personArray = new JSONArray();	//json 정보를 담을 array 선언
				
		for (UserVO userVO : userList) {
			JSONObject personInfo = new JSONObject();
			personInfo.put("id", userVO.getId());
			personInfo.put("name", userVO.getName());
			personArray.add(personInfo);
		}
		
		//jsonObject.put("person", personArray);
		String json = personArray.toJSONString();
		System.out.println("자바 : "+json);

		
		model.addAttribute("json", json);
		return "userList";
	}

	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam String id) {
		UserVO user = userService.getUser(id);
		return new ModelAndView("userInfo","user",user);
	}
	
	@RequestMapping("/insertUserForm.do")
	public ModelAndView insertUserForm() {	
		List<String> sexList = new ArrayList<String>();
		sexList.add("남");
		sexList.add("여");

		List<String> positionList = new ArrayList<String>();
		positionList.add("사원");
		positionList.add("주임");
		positionList.add("대리");
		positionList.add("과장");
		positionList.add("차장");
		positionList.add("부장");

		Map<String, List<String>> map = new HashMap<>();
		map.put("sexList", sexList);
		map.put("positionList", positionList);
		
		return new ModelAndView("userInsert", "map", map);
	}
	
	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user) {		
		if (user != null)
			userService.insertUser(user);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping("/updateUserForm.do")
	public ModelAndView updateUserForm(@RequestParam String id) {
		UserVO user = userService.getUser(id);	
		List<String> sexList = new ArrayList<String>();
		sexList.add("남");
		sexList.add("여");

		List<String> positionList = new ArrayList<String>();
		positionList.add("사원");
		positionList.add("주임");
		positionList.add("대리");
		positionList.add("과장");
		positionList.add("차장");
		positionList.add("부장");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sexList", sexList);
		map.put("positionList", positionList);
		map.put("user", user);
		return new ModelAndView("userUpdate", "map", map);
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(@ModelAttribute UserVO user) {
		System.out.println(user.getId());
		userService.updateUser(user);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping(value="/deleteUser.do/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return "redirect:/getUserList.do";
	}
	
	@ExceptionHandler
	public String handleException(Exception e) {
		return "viewError";
	}
	
//	@RequestMapping(value="/users", method=RequestMethod.GET)
//	@ResponseBody
//	public Map getUserList(){
//		List<UserVO> userList = userService.getUserList();
//		Map result = new HashMap();
//		result.put("result", Boolean.TRUE);
//		result.put("data", userList);
//		return result;
//	}
//	
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public Map getUser(@PathVariable String id) {
//		UserVO user = userService.getUser(id);
//		Map result = new HashMap();
//		result.put("result", Boolean.TRUE);
//		result.put("data", user);
//		return result;
//	}
//	
//	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = { "Content-type=application/json" })
//	@ResponseBody
//	public Map insertUser(@RequestBody UserVO user) {
//		if (user != null)
//			userService.insertUser(user);
//		Map result = new HashMap();
//		result.put("result", Boolean.TRUE);
//		return result;
//	}
//	
//	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
//	@ResponseBody
//	public Map updateUser(@RequestBody UserVO user) {
//		if (user != null)
//			userService.updateUser(user);
//		Map result = new HashMap();
//		result.put("result", Boolean.TRUE);
//		return result;
//	}
//	
//	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public Map deleteUser(@PathVariable String id) {
//		userService.deleteUser(id);
//		Map result = new HashMap();
//		result.put("result", Boolean.TRUE);
//		return result;
//	}
}
