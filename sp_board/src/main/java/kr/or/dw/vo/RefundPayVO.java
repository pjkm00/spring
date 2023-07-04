package kr.or.dw.vo;

import org.json.JSONObject;

import lombok.Data;

@Data
public class RefundPayVO {

	private String code;
	private String message;
	private JSONObject response = new JSONObject();
}
