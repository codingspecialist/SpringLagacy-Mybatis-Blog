<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../header.jsp" %>

<div class="container">
  <form action="/user/login" method="POST">
    <div class="form-group">
      <input name="userEmail" type="email" class="form-control" placeholder="Enter userEmail" required="true" />
    </div>
    <div class="form-group">
      <input name="userPassword" type="password" class="form-control" placeholder="Enter userPassword" required="true" />
    </div>       
    <input type="submit" class="btn btn-primary" value="로그인" />
  </form>
</div>

<%@include file="../footer.jsp" %>

