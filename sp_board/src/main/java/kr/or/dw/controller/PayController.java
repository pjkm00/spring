package kr.or.dw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.or.dw.command.PdsModifyCommand;
import kr.or.dw.command.PdsRegistCommand;
import kr.or.dw.command.SearchCriteria;
import kr.or.dw.dao.AttachDAO;
import kr.or.dw.service.BoardService;
import kr.or.dw.service.MemberService;
import kr.or.dw.service.PayService;
import kr.or.dw.service.PdsService;
import kr.or.dw.vo.AttachVO;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.vo.MemberVO;
import kr.or.dw.vo.PdsVO;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	private PayService payService;
	
	@RequestMapping("/confirmPay")
	public ResponseEntity<String> getToken() {
		ResponseEntity<String> entity = null;
		
		entity = new ResponseEntity<>(payService.getToken(), HttpStatus.OK);
		
		return entity;

	}
	
	@RequestMapping("/refund")
	public ResponseEntity<String> refund(){
		ResponseEntity<String> entity = null;
		
		String refund = payService.refund("imp_954111735349");
		
		entity = new ResponseEntity<String>(refund, HttpStatus.OK);
		return entity;
	}
	
	
}
