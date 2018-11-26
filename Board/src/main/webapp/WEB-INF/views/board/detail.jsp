<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<section id="about">
  <div class="container">
	<a href="/board/updateForm?bNum=${boardVO.bNum}" class="btn btn-primary">수정</a>
	<a href="/board/delete?bNum=${boardVO.bNum}" class="btn btn-danger">삭제</a>
	<div class="row">
		<div class="col-lg-8 mx-auto">
			<h2 class="text-center"><b>${boardVO.bTitle}</b></h2>
			<hr>
			<p class="lead">${boardVO.bContent}</p>
			<hr>
		</div>
		<hr>
		<!-- 댓글 디자인하기 -->
		<div class="col-lg-8 mx-auto">
			<div class="card my-4">
				<h5 class="card-header">댓글</h5>
				<div class="card-body">
					<textarea class="form-control" rows="3" id="rContent_textarea"></textarea>
					<input type="button" class="btn btn-primary" value="작성완료" onclick="sendReply()"/>
				</div>
			</div>
		</div>
		<hr>
		
		<div id="reply" class="col-lg-8 mx-auto">
			<c:forEach var="item" items="${list}">
				<div>
					<b>${item.userID}</b> 
					<a href='/reply/delete?rNum=${item.rNum}&bNum=${item.bNum}'>
						<i class='material-icons'>cancel</i>
					</a><br>
					${item.rContent}
				</div>
			</c:forEach>
		</div>
		
		
		<!-- END -->
	</div>
  </div>
</section>

<%@include file="../footer.jsp" %>

<!-- Ajax 요청 -->
<script>

	function addDiv(rNum, bNum, userID, rContent){
		var newDiv = document.createElement("Div");
		newDiv.innerHTML = "<b>"+userID+"</b> <a href='/reply/delete?rNum="+rNum+"&bNum="+bNum+"'><i class='material-icons'>cancel</i></a><br>"+rContent;
		document.querySelector('#reply').prepend(newDiv);
	}

	function sendReply(){
		var rContent_textarea = document.querySelector('#rContent_textarea');
		var rContent = rContent_textarea.value;
		//alert(rContent);
		//console.log(rContent);
		if(rContent == ''){
			alert('글을 입력하세요');
			return false;
		}
		
		//rContent, bNum, userID 세개를 전송
		var rJson = {
				"rContent":rContent,
				"bNum":'${boardVO.bNum}',
				"userID":'admin'
		};
		//console.log(rJson);
		rJson = JSON.stringify(rJson);
		//console.log(rJson);
		
		/* dataType은 호출되는 서버쪽 함수의 리턴타입 */
		/* contentType은 내가 보내는 데이터 타입 */
		/* data는 내가 전송할 데이터 */
		$.ajax({
			type:"post",
			url:"/reply/write",
			dataType:"text",
			contentType:"application/json; charset=utf-8",
			data:rJson,
			success:function(rNum){
				//alert("통신 성공");
				//밑에 뿌려줘야 함.
				//alert(rNum);
				addDiv(rNum, '${boardVO.bNum}', 'admin', rContent);
				rContent_textarea.value = '';
			},
			error:function(){
				alert("통신 실패");
			}
		});
		
	}
</script>

