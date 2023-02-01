<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" href="images/shorcut.jpg">
	<title>Register Form</title>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">

	<link rel="stylesheet" type="text/scss" href="css/styles.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	<link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Passion+One'>
	<link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Oxygen'>
	<Style>
        <%@include file="/resources/css/style.css" %>
    </Style>

</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Add Product</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
			  <mvc:form modelAttribute="product" action="update">
				<form class="form-horizontal" method="get" action="">
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Name(*)</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
							    <mvc:input path="name" type="text" class="form-control" placeholder="Name"
                                                                    required="true" />
							</div>
							<div class="message" id="message_name">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Price (*)</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa-lg" aria-hidden="true"></i></span>
								<mvc:input path="price" type="text" class="form-control" placeholder="Price"
                                                                        required="true" />
							</div>
							<div class="message" id="message_mail">
							</div>
						</div>
					</div>
					<div class="form-group">
                    	<label for="confirm" class="cols-sm-2 control-label">Description (*)</label>
                    	<div class="cols-sm-10">
                    		<div class="input-group">
                    			 <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                    			<mvc:input path="productDescription" type="text" class="form-control" placeholder="Description"                                                                                             required="true" />
                    		</div>
                    		<div class="message" id="message_conf_password">
                    		</div>
                    	</div>
                    </div>


					<div class="form-group ">
						<input type="submit" value="Submit"/>
					</div>
				</form>
			  </mvc:form>
			</div>
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h3 class="title">Design by Ty </h3>
					<hr />
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/js.js"></script>
</body>
</html>