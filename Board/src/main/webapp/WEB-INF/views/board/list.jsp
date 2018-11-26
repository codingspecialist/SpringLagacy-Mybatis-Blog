<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp" %>

<div class="container">
  <a href="/board/writeForm" class="btn btn-success">글쓰기</a>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>bNum</th>
        <th>bTitle</th>
        <th>bReadCount</th>
        <th>userID</th>
        <th>bWriteDate</th>
        <th>delete</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${list}">
	      <tr>
	        <td>${item.bNum}</td>
	        <td><a href="/board/detail?bNum=${item.bNum}">${item.bTitle}</a></td>
	        <td>${item.bReadCount}</td>
	        <td>${item.userID}</td>
	        <td>${item.bWriteDate}</td>
	        <td><a href="/admin/board/delete?bNum=${item.bNum}"><i class="material-icons">delete</i></a></td>
	      </tr>
      </c:forEach>

    </tbody>
  </table>
  <ul class="pagination">
    <c:if test="${page != 1}">
    	<li class="page-item"><a class="page-link"href="/board/list?page=${page -1}">Previous</a></li>
    </c:if>
    <c:if test="${list.size() == 5}">
    	<li class="page-item"><a class="page-link" href="/board/list?page=${page +1}">Next</a></li>
    </c:if>
  </ul>
</div>

<%@include file="../footer.jsp" %>

