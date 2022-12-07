<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	html {height: 90vh; display: flex; align-items: center;}
	body {width: 700px; margin: 0 auto;}
	header {display: flex; justify-content: center;}
	section {display: flex; justify-content: center;}
	tr,th,td {height: 23.5px!important; width: 60px;}
	#infotablebox {width: 600px; height: 400px; display: flex;}
	#nametable {width: 250px; display: flex; justify-content: center; align-items: center;}
	#infotable {width: 350px;}
	#edit_box,#add_box {display: flex; align-items: center;}
	#edit_box {display: none;}
	#add_box {display: none;}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	
	$("#namefom").keypress(function (e){
		if (e.keyCode === 13) {
			document.namefom.submit();
		}
	})
	
	function info_fn(ch_no){
		$('#edit_box').css("display","flex");
		
		$.ajax({
			url: "/name?no=" + ch_no,
			type: "GET",
			success: function(data) {
				$('input[name="edit_no"]').attr('value',data[0].no);
				$('input[name="edit_name"]').attr('value',data[0].name);
				$('input[name="edit_education"]').attr('value',data[0].education);
				$('input[name="edit_address"]').attr('value',data[0].address);
			}
		})
		
		
	}
	
	function save_fn(){
		document.edit_frm.submit();
	}
	
	function delete_fn(){
		var no = document.getElementById("edit_no").value;
		
		$.ajax({
			url: "/delete?no=" + no,
			type: "GET",
			success: function(data) {
				if(data == 1){
					alert("정상적으로 삭제되었습니다.")
					location.href = "/";
				}else{
					alert("삭제되지 않았습니다.")
				}
			}
		})
		
	}
	
	function add_btn(){
		$('#add_box').css("display","flex");
		$('#edit_box').css("display","none");
	}
	
</script>
</head>
<body>
	<header>
		<h2>학원생 관리 웹 프로그램</h2>
	</header>
	<section>
		<div id=infotablebox>
			<table id=nametable>
				<tr>
					<th>이름 : </th>
					<td>
						<form action="/" name="namefom" id="namefom">
							<input name="name" value="${name}">
						</form>
					</td>
				</tr>
				<tr>
					<th>No</th>
					<th>이름</th>
				</tr>
				<c:if test="${not empty list}">
					<c:forEach var="list" items="${list }" varStatus="st">
						<tr style="cursor: pointer;" onclick="info_fn('${list.no }')">
							<td style="text-align: center;">00${list.no }</td>
							<td style="text-align: center;">${list.name }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="2">찾으시는 이름이 없습니다.</br> 등록하시겠습니까? <input type="button" value="등록" id="add_btn" onclick="add_btn()"></td>
					</tr>
				</c:if>
			</table>
			<div id="edit_box">
				<form action="/edit" name="edit_frm" id="edit" method="post">
					<input type="hidden" name="edit_no" id="edit_no" value="">
					<table id=infotable>
						<tr>
							<th>이름</th>
							<td style="text-align: center;"><input name="edit_name" id="edit_name" value=""></td>
						</tr>
						<tr>
							<th>학교</th>
							<td style="text-align: center;"><input name="edit_education" id="edit_education" value=""></td>
						</tr>
						<tr>
							<th>주소</th>
							<td style="text-align: center;"><input name="edit_address" id="edit_address" value=""></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="저장" onclick="save_fn()">
								<input type="button" value="삭제" onclick="delete_fn()">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="add_box">
				<form action="/add" name="add_frm" id="add" method="post">
					<table id=infotable>
						<tr>
							<th>이름</th>
							<td style="text-align: center;"><input name="add_name"></td>
						</tr>
						<tr>
							<th>학교</th>
							<td style="text-align: center;"><input name="add_education"></td>
						</tr>
						<tr>
							<th>주소</th>
							<td style="text-align: center;"><input name="add_address"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button>등록</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</section>
</body>
</html>