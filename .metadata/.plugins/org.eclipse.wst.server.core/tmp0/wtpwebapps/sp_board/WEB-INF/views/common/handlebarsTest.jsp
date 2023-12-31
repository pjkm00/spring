<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<body>

	<ul id="commentUl">
		
	</ul>

	<!--
		 1. 템플레이팅할 html을 세팅한다. 이때 데이터 바인딩 시킬 부분은 {{바인딩시킬 데이터의 프로퍼티명}}의 형태로 적는다. 
	-->
	<script type="template" id="commentTemplate">
	{{#each .}}
		<li class="list_item">
			<div>
				<div class="review_area">
					<p class="review">{{comment}}</p>
				</div>
				<div class="">
					<div class="review_info">
						<span>{{name}}</span>
					</div>
				</div>
			</div>
		</li>
	{{/each}}
	</script>
	<script>
		//데이터 세팅
		let list = [];
		
		let data = {
				comment : '굿',
				name : '초보'
		}
		let data2 = {
				comment : '굿2',
				name : '초보2'
		}
		list.push(data);
		list.push(data2);
		console.log(list);
		//2. html Template을 가져온 후 Handlebars로 compile 한다.			
		let commentTemplate = $('#commentTemplate').html();
		let commentBindTemplate = Handlebars.compile(commentTemplate);
		
		//3. 컴파일한 템플릿에 데이터를 집어넣는다. 이때 리턴값은 html로 나온다.
		let resultHtml = '';
		resultHtml += commentBindTemplate(list);
		
		//4. 리턴받은 html을 target에 html()로 세팅한다.
		$('#commentUl').html(resultHtml);
	</script>
</body>
</html>