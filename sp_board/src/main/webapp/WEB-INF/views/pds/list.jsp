<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<<c:set var="cri" value="${pageMaker.cri }"/>

<div class="content-wrapper">

	<jsp:include page="../content_header.jsp">
		<jsp:param value="자료실 리스트" name="subject"/>
		<jsp:param value="목록" name="item"/>
	</jsp:include>

	<section>
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="" onclick="OpenWindow('registForm.do', '자료등록', 800, 700);">자료등록</button>
				<div class="card-tools" style="width: 350px;">
					<div class="input-group row">
						<select class="form-control col-md-4" name="searchType" id="searchType">
							<option value="tcw" ${cri.searchType == 'tcw' ? 'selected' : '' }>전 체</option>
							<option value="t" ${cri.searchType == 't' ? 'selected' : '' }>제 목</option>
							<option value="w" ${cri.searchType == 'w' ? 'selected' : '' }>작성자</option>
							<option value="c" ${cri.searchType == 'c' ? 'selected' : '' }>내 용</option>
							<option value="tc" ${cri.searchType == 'tc' ? 'selected' : '' }>제목+내용</option>
							<option value="cw" ${cri.searchType == 'cw' ? 'selected' : '' }>작성자+내용</option>
						</select>
						<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="">
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="searchList_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<table class="table table-borderd text-center">
					<tr style="font-size: 0.95em;">
						<th>번 호</th>
						<th style="width: 50%;">제 목</th>
						<th>작성자</th>
						<th>첨부파일</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
					<c:if test="${empty pdsList }">
						<tr>
							<td colspan="6">
								<strong>해당 내용이 없습니다.</strong>
							</td>
						</tr>
					</c:if>
					<c:forEach var="pds" items="${pdsList }">
						<tr style="font-size: 0.85em;">
							<td>${pds.pno }</td>
							<td style="text-align:left;">
								<a href="#" onclick="OpenWindow('detail.do?pno=${pds.pno}', '글상세보기',800, 700);">
									<span class="col-sm-12">${pds.title }</span>
								</a>
							</td>
							<td>${pds.writer }</td>
							<td>${pds.attachList.size() }</td>
							<td><fmt:formatDate value="${pds.regdate}" pattern="yyyy-MM-dd" type="date"/></td>
							<td><span class="badge bg-red">${pds.viewcnt }</span></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="card-footer">
				<nav aria-label="pds list Navigation">
					<ul class="">
						<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
					</ul>
				</nav>
			</div>
		</div>
	</section>
</div>


	