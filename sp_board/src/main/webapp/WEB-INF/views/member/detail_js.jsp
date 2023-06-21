<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

window.onload = function(){
	//프로필 이미지 불러오기
	
	if(${member.enabled} == 1){
		$('button#stopBtn').text("정지");
	}else{
		$('button#stopBtn').text("해제");
	}
	
	let imageURL = "getPicture.do?picture=${member.picture}";	//이미지명 가지고 와서 셋팅
	$('div#pictureView').css({
								 'background-image' : 'url(' + imageURL + ')',
								 'background-position' : 'center',
								 'background-size' : 'cover',
								 'background-repeat' : 'no-repeat'
							});
	
	//수정버튼 클릭
	$('button#modifyBtn').on('click', function(){
		location.href="<%=request.getContextPath()%>/member/modifyForm.do?id=${member.id}";
	});
	
	//삭제버튼 클릭
	$('button#deleteBtn').on('click', function(){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href="<%=request.getContextPath()%>/member/remove.do?id=${member.id}";
		};
	});
	
	//정지버튼 클릭
	$('button#stopBtn').on('click', function(){
		if(${member.enabled} == 1){
			location.href="<%=request.getContextPath()%>/member/stop.do?id=${member.id}";
		}else{
			location.href="<%=request.getContextPath()%>/member/stopCancel.do?id=${member.id}";
			
		}
	})
}
	
	
	

</script>