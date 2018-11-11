<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("<b>Hello, " + name + "</b>");
			} else {
				response.sendRedirect("login-signup.html");
			}
		}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>My Sofa Maker</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="" />
	<!-- css -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
	<link href="css/jcarousel.css" rel="stylesheet" />
	<link href="css/flexslider.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />

	<!-- Theme skin -->
	<link href="skins/default.css" rel="stylesheet" />

</head>

<body>
	<div id="wrapper">
		<!-- start header -->
		<header>
			<div class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
						<a style="font-style:oblique;font-size: 20px;font-variant:normal;font-family: "Times New Roman", Times, serif;" class="navbar-brand" href="home.jsp">MySofaMaker.com</a>
					</div>
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li><a href="home.jsp">Home</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Features <b class=" icon-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li class="active"><a href="book.jsp">Book</a></li>
									<li><a href="components.jsp">Components</a></li>
									<li><a href="pricingbox.jsp">Pricing box</a></li>
								</ul>
							</li>
							<li><a href="portfolio.jsp">Portfolio</a></li>
							<li><a href="userblog.jsp">Blog</a></li>
							<li><a href="usercontact.jsp">Contact</a></li>
							<li><a href="http://localhost:8585/MySofaMaker.com/LogoutServlet">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<!-- end header -->

		
		<%
		
		
		
		
		%>