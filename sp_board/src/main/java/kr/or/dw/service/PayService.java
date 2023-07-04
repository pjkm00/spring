package kr.or.dw.service;

public interface PayService {

	String getToken();
	
	String refund(String imp_uid);
}
