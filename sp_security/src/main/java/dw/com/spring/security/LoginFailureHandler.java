package dw.com.spring.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		//redirect할 때
		//super.onAuthenticationFailure(request, response, exception);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('아이디 혹은 패스워드가 일치하지 않습니다.')");
		out.print("history.go(-1)");
		out.print("</script>");
	}
	
}
