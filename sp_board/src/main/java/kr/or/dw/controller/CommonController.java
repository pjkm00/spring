package kr.or.dw.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

//	@RequestMapping("/common/loginForm")
	@GetMapping("/common/loginForm")
//	@PostMapping("/common/loginForm")
	public String loginForm(HttpServletResponse res) throws Exception{
		String url = "/common/loginForm";
		
		return url;
		
	}
}
