<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="member list Navigation">
	<ul class="pagination justify-content-center m-0">
		<c:if test="${pageMaker.prev}">
			<li class="page-item">
				<a class="page-link" href="javascript:searchList_go(1)">
					<i class="fas fa-angle-double-left"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:searchList_go(${pageMaker.cri.page - 1})">
					<i class="fas fa-angle-left"></i>
				</a>
			</li>
		</c:if>
		<c:forEach var="pageNum" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
			<li class="page-item ${pageNum == pageMaker.cri.page ? 'active' : '' }">
				<a class="page-link" href="javascript:searchList_go(${pageNum})">${pageNum}</a>
			</li>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<li class="page-item">
				<a class="page-link" href="javascript:searchList_go(${pageMaker.cri.page + 1})">
					<i class="fas fa-angle-right"></i>
				</a>
			</li>
			<li class="page-item">
				<a class="page-link" href="javascript:searchList_go(${pageMaker.realEndPage })">
					<i class="fas fa-angle-double-right"></i>
				</a>
			</li>
		</c:if>
	</ul>
</nav>


<form id="searchForm">
	<input type="hidden" name="searchType">
	<input type="hidden" name="keyword">
	<input type="hidden" name="page">
	<input type="hidden" name="perPageNum">
</form>


<script>
	function searchList_go(page, url){
		if(page < 1){
			return;
		}
		
		let perPageNum = 10;
		if($('select[name="perPageNum"]').val()){
			perPageNum = $('select[name="perPageNum"]').val()
		}
		
		let searchForm = $('#searchForm');
		searchForm.find('[name="page"]').val(page);
		searchForm.find('[name="perPageNum"]').val(perPageNum);
		searchForm.find('[name="searchType"]').val($('select[name="searchType"]').val());
		searchForm.find('[name="keyword"]').val($('div.input-group > input[name="keyword"]').val());
		searchForm.attr("method", "post");
		
		
		if(url){
			searchForm.attr("action", url);
		}else{
			searchForm.attr("action", "list.do");
		}
		searchForm.submit();
	}

</script>