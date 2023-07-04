package kr.or.dw.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.or.dw.vo.RefundPayVO;

public class PayServiceImpl implements PayService{
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public String getToken() {
		
		//서버로 요청할 Header
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
	    
	    Map<String, Object> map = new HashMap<>();
	    map.put("imp_key", "0488517382654157");
	    map.put("imp_secret", "2KkMRgP1zhtrhqZnWWY3deZBg4pxsgJLb3VJhRGm9y3dkWvqulOdt9Vcmy4Zolgge8OkauqJJdY1MkpU");
	    
	   
	    Gson gson = new Gson();
	    String json=gson.toJson(map);
		//서버로 요청할 Body
	   
	    HttpEntity<String> entity = new HttpEntity<>(json,headers);
		return restTemplate.postForObject("https://api.iamport.kr/users/getToken", entity, String.class);
	}

	@Override
	public String refund(String imp_uid) {
		String result = "";
		try {
			String token = this.getToken();
			if(token == null) {
				throw new Exception();
			}
			String[] tokenList = token.split("\"");
			token = tokenList[9];
			System.out.println(token);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", token);
			
			Map<String, Object> map = new HashMap<>();
			map.put("imp_uid", imp_uid);
			
			Gson gson = new Gson();
		    String json=gson.toJson(map);
		     
			HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
			String refund = restTemplate.postForObject("http://api.iamport.kr/payments/cancel", entity, String.class);
			

			System.out.println(refund);
			result = refund;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("환불에 실패했습니다.");
			result = "환불에 실패했습니다.";
		}
		
		return result;
		
	}

	
}
