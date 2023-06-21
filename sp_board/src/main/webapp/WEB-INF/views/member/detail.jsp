<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="content-wrapper">
	
	<section class="content register-page">
		<div class="register-box">
			<!-- 콘텐츠 헤더 -->
			<div class="login-logo">
				<a href="<%=request.getContextPath()%>/member/registForm.do"><b>회원정보</b></a>
			</div>
			
			<!-- 콘텐츠 -->
			<div class="card">
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">
						<input type="hidden" name="picture">
						<!-- 프로필 사진 선택 부분 -->
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center; margin: 0 auto;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">아이디
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.id}" readonly>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">비밀번호
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.pwd}" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">이름
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.name}" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">권한
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.authority}" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">이메일
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.email}" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">전화번호
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.phone}" readonly>
							</div>
						</div>
<!-- 						<div class="form-group row"> -->
<!-- 							<label for="id" class="col-sm-3" style="font-size: 0.9em;">주소 -->
<!-- 							</label> -->
<!-- 							<div class="col-sm-9 input-group input-group-sm"> -->
<%-- 								<input name="id" type="text" id="id" class="form-control" value="${member.address}" readonly> --%>
<!-- 							</div> -->
<!-- 						</div> -->
						
						<div class="card-footer">
							<div class="row">
								<c:set var="visible" value="none"/>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<c:set var="visible" value="visible"/>
				    	  		</sec:authorize>
								<div class="col-sm-3">
									<button type="button" id="modifyBtn" class="btn btn-info" style="display: ${visible};">수정</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="deleteBtn" class="btn btn-danger" style="display: ${visible};">삭제</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="stopBtn" class="btn btn-warning" style="display: ${visible};">정지</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="listBtn" class="btn btn-default" onclick="CloseWindow();">닫기</button>
								</div>
								
							</div>
						</div>
					</form>
				</div>
			</div>
		
		</div>
	</section>
	
</div>
<%@ include file="detail_js.jsp" %>





