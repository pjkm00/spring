<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<%-- 								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; background-image: url('/picturePath/${member.picture}'); background-position : center; background-size : cover; background-repeat : no-repeat;"></div> --%>
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; background-position : center; background-size : cover; background-repeat : no-repeat;" onclick="detailPictureView();"></div>
								<input type="hidden" name="picture" value="${member.picture}">
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
						
						<div class="card-footer">
							<div class="row">
								<div class="col-sm-3">
									<button type="button" id="registBtn" class="btn btn-info" onclick="">수정</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="registBtn" class="btn btn-danger" onclick="">삭제</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="registBtn" class="btn btn-warning" onclick="">정지</button>
								</div>
								<div class="col-sm-3">
									<button type="button" id="registBtn" class="btn btn-default" onclick="CloseWindow();">닫기</button>
								</div>
								
							</div>
						</div>
					</form>
				</div>
			</div>
		
		</div>
	</section>
	
</div>
<%@ include file="regist_js.jsp" %>





