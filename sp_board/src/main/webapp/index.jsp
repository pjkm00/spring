<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- <script> -->
<!-- //     location.href="/common/loginForm.do"; -->
<!-- </script> -->

<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>    
    <div class="card text-center">
    <div class="card-header">
        결제하기
    </div>
    <div class="card-body">
        <h5 class="card-title mb-4">결제하려는 금액을 선택하세요😎😎</h5>
        <div><input value="kakaopay" class="btn btn-primary mb-2" onclick="requestPay('kakaopay')"></div>
        <div><input value="html5_inicis" class="btn btn-primary mb-2" onclick="requestPay('html5_inicis')"></div>
      <button type="button" onclick="cancel()">취소</button>
      <button type="button" onclick="token()">토큰</button>
    </div>

</div>
<div class="portone-ui-container" data-portone-ui-type="">
  <!-- 여기에 PG사 전용 버튼이 그려집니다 -->
</div> 
<script>



const IMP = window.IMP;
IMP.init("imp04352208");
let pay_info = null;
function requestPay(method) { 
	
    IMP.request_pay({
        pg: method,
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '금액 충전',
        amount: 100,
        buyer_email: '',
        buyer_name: '김민경',
        buyer_tel: '010-8771-4407',
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
			pay_info = rsp;
        } else {
            console.log(rsp);
            pay_info = rsp;
            alert('결제가 실패 되었습니다.');

        }
    });
}

function token(){
	console.log(pay_info);
	
	$.ajax({
		url : "/pay/confirmPay.do",
		method : "post",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify({
	        merchant_uid : "123" }),
		success : function(res){
			console.log(res);
			console.log(res.response);
			console.log(res.response.access_token);
		},
		error : function(err){
			alert(err.status);
		}
	})
}

function cancel(){
	$.ajax({
		url : "/pay/refund.do", 
	    type : "POST",
	    contentType : "application/json",
	    data : JSON.stringify({
	        merchant_uid : "{결제건의 주문번호}",
	        reason: "테스트 결제 환불"
	      }),
	    dataType : "json",
	    success : function(res){
	    	console.log(res);
	    },
	    error : function(err){
	    	alert(err.status);
	    }
	})
}



</script>