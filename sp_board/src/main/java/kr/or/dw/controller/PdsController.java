package kr.or.dw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.service.MemberService;
import kr.or.dw.service.PdsService;
import kr.or.dw.vo.MemberVO;

@Controller
@RequestMapping("/pds")
public class PdsController {
	
	private static final Logger logger = LoggerFactory.getLogger(PdsController.class);
	
	@Autowired
	private PdsService pdsService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "/pds/main.open";
		return url;
	}
	

}