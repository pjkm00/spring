<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="min-width: 420px; min-height: 800px; margin: 0 auto;">

	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자유게시판" name="subject"/>
		<jsp:param value="상세보기" name="item"/>
	</jsp:include>

	<section class="content container-fluid">
		<div class="row"> <!-- row start -->
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
					</div>
					<div class="card-body">
						<div class="form-group col-md-12">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="title" value="${board.title }" readonly>
						</div>
						<div class="row">
							<div class="form-group col-md-4">
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" value="${board.writer }" readonly>
							</div>
							<div class="form-group col-md-4">
								<label for="regdate">작성일</label>
								<input type="text" class="form-control" id="regdate" value="<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" type="date"/>" readonly>
							</div>
							<div class="form-group col-md-4">
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" value="${board.viewcnt }" readonly>
							</div>
						</div>
						<div class="form-group col-md-12">
							<label for="content">내용</label>
							<div id="content">${board.content }</div>
						</div>
					</div> <!-- card body End -->
					<div class="card-footer">
						<button type="button" id="modifyBtn" class="btn btn-warning">수정</button>
						<button type="button" id="removeBtn" class="btn btn-danger">삭제</button>
						<button type="button" id="listBtn" class="btn btn-primary">닫기</button>
					</div> <!-- card footer End -->
				</div>
			</div>
		</div> <!-- row End -->
		
		<div class="row"> <!-- reply component start -->
			<div class="col-md-12">
				<div class="card card-info">
					<div class="card-body"> <!-- card body start -->
						<div class="timeline"> <!-- timeline start -->
							<div class="time-label" id="repliesDiv">
								<span class="bg-green">Reply List</span>
							</div>
						</div> <!-- timeline End -->
						<div class="text-center">
							<ul id="pagination" class="pagination justify-content-center m-0">
								
							</ul>
						</div>
					</div> <!-- card body End -->
					<div class="card-footer">
						<label for="newReplyWriter">Writer</label>
						<input class="form-control" type="hidden" id="newReplyWriter" readonly value="${loginUser.id }">
						<label for="newReplyText">Reply Text</label>
						<input class="form-control" type="text" placeholder="Reply Text" id="newReplyText">
						<br>
						<button type="button" class="btn btn-primary" id="replyAddBtn">작성</button>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<form role="form">
	<input type="hidden" name="bno" value="${board.bno }">
</form>

<!-- Modal -->
<div id="modifyModal" class="modal modal-default fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" style="display:none;"></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body" data-rno>
				<p><input type="text" id="replytext" class="form-control"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" id="replyModBtn">MODIFY</button>
				<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
				<button type="button" class="btn btn-default" id="cancelBtn">CLOSE</button>
			</div>
		</div>
	</div>
</div>

<script>
	window.onload = function(){
		
		ShowReply();

		let formObj = $('form[role="form"]');
		
		$('button#modifyBtn').on('click', function(){
			formObj.attr({
				'action' : 'modifyForm.do',
				'method' : 'post'
			});
			formObj.submit();
		});
		
		$('button#removeBtn').on('click', function(){
			if(confirm("정말 삭제하시겠습니까?")){
				formObj.attr({
					'action' : 'remove.do',
					'method' : 'post'
				});
				formObj.submit();
			};
		});
		
		$('button#listBtn').on('click', function(){
			window.opener.location.reload(true);
			window.close();
		});
		
	}
	
</script>

<%@ include file="reply_js.jsp"%>