<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Muzix Application</title>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<style type="text/css">
div{
	box-shadow: 0px 0px 10px 10px rgba(0,0,0,0.4);
	background-image: linear-gradient(to right, red , orange);
	font-family: 'Maiden Orange', cursive;
	font-size: 60px;
	margin-bottom: 40px;
	color: #F8F8FF;
	text-align: center;


}
input[type=text], select,input[type=submit] {
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  cursor: pointer;
}
ul{

	padding: 0px;
	position: absolute;
	margin: 0px;
	}
ul li{
    font-size: 20px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	border-style: solid;
    border-color: #F64F71;
    padding: 25px 20px 25px 20px;
	font-style: italic;
    list-style: none;
	list-style: inline;
    float: left;
    padding-right: 30px;
    color: #f2bcc7;
    }

ul li:hover{
    font-style: italic;
    color: orange;
    font-weight: bolder;
    }

 .addform{
 	margin-bottom: 120px;
 }
.delTrackform, .findform{
font-family: sans-serif;
font-size: 20px;
font-style: italic;
}
.findform{
float: left;
margin-left: 20%;
margin-top: 8%;
}
.findform input[type=submit]{
	border-radius: 2px;
  	box-sizing: 8px;
	background-color: #2B50B3;
	padding: 20px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    border-color: #F64F71;
	font-size: 25px;
	font-style: italic;
	font-family: sans-serif;
	color: #f2bcc7;
	height: 100%;
	cursor: pointer;
}
.findform input[type=submit]:hover{
    font-style: italic;
    text-decoration: underline;
    color: #FFA425;
    font-weight: bolder;
}

.findTrackForm{
float: right;
margin-right: 20%;
}
p{
	color: #f2bcc7;
	padding:5px 0px;
    border-style:solid;
    border-radius: 20px;
    border-color: #F64F71;
    font-family: sans-serif;
    font-size: 25px;
    font-style: italic;
    width: 14%;
    text-align: center;
}
p:hover, ul li:hover{
    background-color: #F64F71;
    color: #eff4f4;
}
.deleteTrack{

}
.trackList{
	margin-top: 100px;
}
label{
	font-family: sans-serif;
	padding-left: 5px;
}

body{

    background-color: #2B50B3;
 	width: 100%;
	margin: 0px;
}
</style>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send
		 button. Handle errors like empty fields -->
	<div>Muzix DB</div>
	<p class="addTrack">Add Track</p>
	<form class="addform" name="TrackForm" action="addTrack" method="post">
		<ul>
	    <li>TrackID: <input type="text" name="id" /></li>
		<li>Name: <input type="text" name="name" /></li>
		<li>Comments: <input type="text" name="comments" /></li>
		<li><input type="submit" value="Add"/></li></ul>
	</form><br>
    <p class="deleteTrack">Delete Track</p>
	<form class="delTrackform" name="TrackDel" action="deleteTrack" method="post">
    		<ul>
    	    <li>TrackID: <input type="text" name="id" /></li>
    		<li><input type="submit" value="Delete"/></li></ul>
    	</form><br>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
    <form class="findform" name="FindTrack" action="getAll" method="post">
                      	<input type="submit" value="GET ALL TRACKS  "/>
        </form>
        <form class="findform findTrackForm" name="FindTrack" action="findTrack" method="post">
                  	<input type="submit" value="FIND TRACK BY NAME"/>
        </form>

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