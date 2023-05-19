<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JsonTest2</title>
<link href="${path1 }/source/bulma.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>
#sidebar { width:200px; float:left;}
#dataform { width:900px; float:right;}
</style>
</head>
<body>
<aside class="menu">
  <p class="menu-label">
    General
  </p>
  <ul class="menu-list">
    <li><a>Dashboard</a></li>
    <li><a>Customers</a></li>
  </ul>
  <p class="menu-label">
    Administration
  </p>
  <ul class="menu-list">
    <li><a>Team Settings</a></li>
    <li>
      <a class="is-active">Manage Your Team</a>
      <ul>
        <li><a>Members</a></li>
        <li><a>Plugins</a></li>
        <li><a>Add a member</a></li>
      </ul>
    </li>
    <li><a>Invitations</a></li>
    <li><a>Cloud Storage Environment Settings</a></li>
    <li><a>Authentication</a></li>
  </ul>
  <p class="menu-label">
    Transactions
  </p>
  <ul class="menu-list">
    <li><a>Payments</a></li>
    <li><a>Transfers</a></li>
    <li><a>Balance</a></li>
  </ul>
</aside>
<div class="container">
	<h2>JSON 형태의 일반 객체 출력</h2>
	<br><hr><br>
	<div id="msg">
		<ul id="lst">
		
		</ul>	
	</div>
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
	$(document).ready(function(){
		var params = { item1:"heojun"};
		$("#reqBtn").click(function(){
			$.ajax({	
				url:"${path1 }/JSONTest2.do",
				type:"post",
				dataType:"json",
				data:params,
				success:function(obj){
				//console.log(obj);
				var sam = obj;
				$("#lst").append("<li>아이디: "+sam.name+"</li>");
				$("#lst").append("<li>포인트: "+sam.point+"</li>");
				$("#lst").append("<li>가입일: "+sam.resdate+"</li>");
				}
			});
		});
	});
	</script>
</div>
</body>
</html>