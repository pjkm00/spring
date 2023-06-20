<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form role="imageForm" action="upload/picture.do" method="post" enctype="multipart/form-data">
	<input type="file" id="inputFile" style="display: none;" name="pictureFile" class="form-control" onchange="imageChange_go()">
	<input type="hidden" value="" id="oldFile" name="oldPicture">
	<input type="hidden" name="checkUpload" value="0">
</form>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>

	
	let picture = $('input[name="picture"]').val();
	function detailPictureView(){
		$.ajax({
			url : "<%=request.getContextPath()%>/member/detailPictureView.do",
			data : picture,
			type : "post",
			success : function(res){
				console.log(res);
			},
			error : function(error){
				alert(error.status);
			}
		})
	}

	//사진이 변경됐을 때 
	function imageChange_go(){
		$('input[name="checkUpload"]').val(0);
		preViewPicture($('input#inputFile')[0], $('div#pictureView'));
	};
	
	//업로드 버튼을 눌렀을 때 
	function upload_go(){
		if($('#inputFileName').val() == ""){
			alert("이미지를 선택하세요.");
			$('#inputFile').click();
			return;
		};
		
		//form 태그 양식을 객체화
		//[0] 을 붙여주지 않으면 모든 데이터를 다 가져오는 거라 form에 있는 데이터만 가져오려면 [0]을 꼭 붙여줘야한다.
		let form = new FormData($('form[role="imageForm"]')[0]);
		console.log(form);
		//서버와 통신
		$.ajax({
			url : "<%=request.getContextPath()%>/member/picture.do",
			data : form,
			type : "post",
			processData : false,
			contentType : false,
			success : function(data){
				//업로드 확인 변수 셋팅
				$('input[name="checkUpload"]').val(1);
				
				//저장된 파일명 저장
				$('input#oldFile').val(data);	//이미지 변경시 이것과 비교해서 다르다면 삭제될 파일명(전파일)
				$('form[role="form"] input[name="picture"]').val(data);
				
				alert("이미지가 업로드 되었습니다.");
			},
			error : function(error){
				console.log(error);
				alert("현재 이미지 업로드가 불가합니다. \n관리자에게 연락바랍니다.");
			}
		});
		
	};

	//아이디 중복확인으로 확인된 아아디가 저장될 곳
	let checkedID = "";
	
	function idCheck_go(){
		let input_ID = $('#id');
		
		if(input_ID.val() == ""){
			alert("아이디를 입력하세요.");
			input_ID.focus();
			return;
		}else{
			// 아이디는 4~13글자의 영문자와 숫자로만 입력
			let reqID = /^[a-z]{1}[a-zA-Z0-9]{3,12}$/;
			if(!reqID.test(input_ID.val())){
				alert("아이디 첫 글자는 영소문자이며, \n4~13자리의 영문자와 숫자로만 입력해야 합니다.");
				input_ID.focus();
				return;
			};
		};
		
		//중복확인
		let data = {id : input_ID.val().trim()};
		
		$.ajax({
			url : "<%=request.getContextPath()%>/member/idCheck.do",
			data : data,
			type : 'post',
			success : function(result){
				if(result){	//빈 스트링은 false 처리됨
					checkedID = result;
					$('input[name="id"]').val(checkedID);
					alert("사용가능한 아이디 입니다.");
				}else{
					alert("중복된 아이디 입니다.");
					input_ID.focus();
				}
			},
			error : function(error){
				alert(error.status);
			}
		});
		
	};
	
	function submit_go(){
		let uploadCheck = $('input[name="checkUpload"]').val();
		
		if(!(uploadCheck > 0)){
			alert("이미지 업로드는 필수입니다.");
			return;
		};
		
		if($('input[name="id"]').val() == ""){
			alert("아이디는 필수입니다.");
			return;
		};
		
		if($('input[name="id"]').val() != checkedID){
			alert("아이디 중복확인이 필요합니다.");
			return;
		};
		
		if($('input[name="pwd"]').val() == ""){
			alert("비밀번호는 필수입니다.");
			return;
		};
		
		if($('input[name="name"]').val() == ""){
			alert("이름은 필수입니다.");
			return;
		};
		
		$('form[role="form"]').submit();
	};
	
</script>