<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Muzix Application</title>
<style type="text/css">
div{
	box-shadow: 4px 4px 10px 10px rgba(0,0,0,0.2);
	background-image: linear-gradient(to right, #3f3789 , #C0B9FA);
	font-family: 'Maiden Orange', cursive;
	font-size: 60px;
	margin-bottom: 5%;
	color: #eff4f4;
	text-align: center;
}
div:hover{
font-weight: bolder;
}
input[type=text], select,input[type=submit] {
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
ul{

	padding: 0px;
	position: absolute;
	margin: 0px;
}
ul li{
    box-shadow: 0px 0px 4px 4px rgba(0,0,0,0.1);
	background-color: #f8ebd8;
	border-style: solid;
    border-color: #7264B7;
    padding: 25px 20px 25px 20px;
	font-style: italic;
    list-style: none;
	list-style: inline;
    float: left;
    padding-right: 30px;
    color: #7264B7;
    font-size: 20px;
    }
ul li:hover{
    font-style: italic;
    background-color: #7264B7;
    color: #eff4f4;
    font-weight: bolder;
    }
label{
	font-family: sans-serif;
	padding-left: 5px;
}

body{
    background-color: #f8ebd8;
 	width: 100%;
	margin: 0px;


</style>
</head>
<body>
	<div class="TrackList">Track List</div>

	<ul class="ulNew">
	<c:forEach var="track" items="${tracks}">
			<li>
				<label>Track Id: <label>
				<label>${track.getTrackId()}</label>
			</li>
			<li>
				<label>Name: </label>
				<label>${track.getTrackName()}</label>
			</li>
			<li>
				<label>Comments: </label>
				<label>${track.getComments()}</label>
			</li><br>
			</c:forEach>
	</ul>

</body>
</html>