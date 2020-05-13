<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
		<tiles:insertAttribute name="css" />
		
		<!-- include pace script for automatic web page progress bar  -->
		<script>
            paceOptions = {
              elements: true
            };
        </script>
        <script src="assets/js/pace.min.js"></script>
		<!-- <style type="text/css">
			body {
				margin: 0;
				padding: 0;
				font-family: arial;
				font-size: 12px !important;
			}
			.left {
				float: left;
			}
			.right {
				float: right;
			}
			.menu-div {
				float: left;
				display: block; 
				min-height: 700px; 
				width: 205px;
				padding: 0 0 0 10px;
			}
			.body-div {
				margin: 0 15px;
				float: left;
				padding: 0 10px;
				display: block; 
				min-height: 685px; 
				width:66%;
			}
			.body-div h2{
				margin: 0 0 20px 0;
				border-bottom: solid 1px #ccc;
				padding: 0 0 10px 0;
			}

			.header-div {
				background: #e8e8e8;
				margin: 0 0 20px 0;
				display: block; 
				height: 60px;
				line-height: 60px; 
				width:auto;
			}
			.header-div h2 { 
				margin: 0;
				padding: 0 0 0 10px;
			}
			.header-div .search {
				float: left;
				border: solid 1px #ccc;
				padding: 6px;
				width: 200px;
				margin: 12px 0 0 0;
			}
			.searchBtn {
				float: left;
				background: #666;
				border: solid;
				cursor: pointer;
				margin: 13px 10px 0 0;
				color: #fff;
				width: 24px;
				height: 22px;
			}
			.footer-div {
				display: block; 
				height: 15%; 
				width:98.1%;
				clear: both;
				background: #000;
				color: #fff;
				padding: 5px 10px;
			}
			.feeds-div {
				float: left;
				margin-right: 8px;
				display: block;
				min-height: 700px; 
				width: 150px;
				
			}
		.container {
				
				margin-right: 8px;
			}
			
			table, th, td
			{
				border: 1px solid black;
				border-collapse:collapse;
				width: 100%;
			}
			.productList {
				background: #f5f5f5;
				padding: 10px;
				float: left;
				overflow: hidden;
				margin: 0 12px 20px 8px;
				border: dotted 1px #999;
			}
			.productList a {
				padding: 0;
			}
			.productList a img.productIcon{
				width: 160px;
				min-height: 160px;
			}
			.scroll {
				overflow: scroll;
				height: 620px;
				overflow-x: hidden; 
			}
			.categoryList h3, .priceRange h3, .discounts h3, .adminMenu h3 {
				font-size: 14px;
				font-weight: normal;
				margin: 0 0 5px 0;
				border-bottom: solid 3px #666666;
				padding: 6px 5px;
				background: #ccc;
			} 
			.categoryList, .adminMenu {
				margin: 0 0 30px 0;
			}
			.categoryList ul, .adminMenu ul {
				margin: 0;
				padding: 0;				
			}
			.categoryList ul li, .adminMenu ul li {
				list-style: none;
				margin: 0 0 1px 0;
			}
			.categoryList ul li a, .adminMenu ul li a {
				list-style: none;
				padding: 8px 0 8px 5px;
				background: #f8f8f8;
				margin: 0 0 2px 0;
				color: #000;
				text-decoration: none;
				font-weight: bold;
				display: block;
			}
			.categoryList ul li a:hover, .adminMenu ul li a:hover {
				background: #e5e5e5;
			}
			.priceRange ul {
				margin: 0 0 30px 0;
				padding: 0;
			}
			.priceRange ul li{
				list-style: none;
				margin: 0 0 2px 0;
			}
			.priceRange ul li a {
				list-style: none;
				padding: 8px 0 8px 5px;
				background: #f8f8f8;
				margin: 0 0 1px 0;
				color: #000;
				text-decoration: none;
				font-weight: bold;
				display: block;
			}
			.priceRange ul li a:hover {
				background: #e5e5e5;
			}
			.discounts ul {
				margin: 0;
				padding: 0;
			}
			.discounts ul li{
				list-style: none;
				margin: 0 0 2px 0;
			}
			.discounts ul li a {
				list-style: none;
				padding: 8px 0 8px 5px;
				background: #f8f8f8;
				margin: 0 0 1px 0;
				color: #000;
				text-decoration: none;
				font-weight: bold;
				display: block;
			}
			.discounts ul li a:hover {
				background: #e5e5e5;
			}
			.price{
				padding: 10px 0 0 0;
				text-align: center;
			}
			.productName {
				width: 160px;
				padding: 10px 0 0 0;
				text-align: center;
			}
			.filter {
				background: #f8f8f8;
				font-size: 12px;
			}
			.filter span {
				font-weight: normal;
				border: 1px solid #ccc;
			   float: right; 
			    line-height: 23px;
			    margin: 0 0 0 20px;
			    padding: 3px 4px;
			}	
			.filter span a img{
				float: right;
				padding: 0 0 0 10px;
			}	
			.closeBtn {
				width: 25px;
				height: 25px;
			}
		</style> -->
		
		<!-- <script type="text/javascript">
			function updateCategory(category) {
				document.getElementById('categoryId').setAttribute('value', category);
				alert(category);
			}
			
			function updatePrice(priceRange) {
				document.getElementById('priceRange').setAttribute('value', priceRange);
				alert(priceRange);
			}
			
			function updateDiscount(savings) {
				document.getElementById('savings').setAttribute('value', savings);
				alert(savings);
			}
		
			function searchByProduct() {
				alert(document.getElementById('searchKey').getAttribute('value'));
			}
			function removeCookie(cookieName) {
				alert("1");
				var date = new Date();
			    date.setTime(date.getTime() - (60 * 1000));
				document.cookie = cookieName + "= ; expires= " + date.toGMTString();
				alert("2");
			}
			function refreshPage(page) {
				alert("3");
				document.getElementById(page).submit();
			}
		</script> -->
    </head>

    <body>
		<!-- Modal Login start -->
		<form name="loginForm" method="POST" action="signin.htm">
		<div class="modal signUpContent fade" id="ModalLogin" tabindex="-1" role="dialog" >
		  <div class="modal-dialog ">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
		        <h3 class="modal-title-site text-center" > Login  to TSHOP </h3>
		      </div>
		      <div class="modal-body">
		        <div class="form-group login-username">
		          <div >
		            <input name="email" id="login-user" class="form-control input"  size="20" placeholder="Enter Username" type="text">
		          </div>
		        </div>
		        <div class="form-group login-password">
		          <div >
		            <input name="password" id="login-password" class="form-control input"  size="20" placeholder="Password" type="password">
		          </div>
		        </div>
		        <div class="form-group">
		          <div >
		            <div class="checkbox login-remember">
		              <label>
		                <input name="rememberme"  value="forever" checked="checked" type="checkbox">
		                Remember Me </label>
		            </div>
		          </div>
		        </div>
		        <div >
		          <div >
		            <input name="submit" class="btn  btn-block btn-lg btn-primary" value="LOGIN" type="submit">
		          </div>
		        </div>
		        <!--userForm--> 
		        
		      </div>
		      <div class="modal-footer">
		        <p class="text-center"> Not here before? <a data-toggle="modal"  data-dismiss="modal" href="#ModalSignup"> Sign Up. </a> <br>
		          <a href="forgot-password.html" > Lost your password? </a> </p>
		      </div>
		    </div>
		    <!-- /.modal-content --> 
		    
		  </div>
		  <!-- /.modal-dialog --> 
		  
		</div>
		<!-- /.Modal Login --> 
		      </form>
		
		<!-- Modal Signup start -->
		<div class="modal signUpContent fade" id="ModalSignup" tabindex="-1" role="dialog" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
		        <h3 class="modal-title-site text-center" > REGISTER </h3>
		      </div>
		      <div class="modal-body">
		      	<div id="errorContainer" class="hide" style="border: 2px solid red;margin-bottom:20px "></div>
		        <div class="control-group"> <a class="fb_button btn  btn-block btn-lg " href="#"> SIGNUP WITH FACEBOOK </a> </div>
		        <h5 style="padding:10px 0 10px 0;" class="text-center"> OR </h5>
<!-- 		        <div class="form-group reg-username">
		          <div >
		            <input name="login"  class="form-control input"  size="20" placeholder="Enter Username" type="text">
		          </div>
		        </div>
 -->		    
 			<form id="registrationForm" name="registrationForm">
 				<div class="form-group reg-email">
		          <div >
		            <input name="firstName" id="firstName" class="form-control input"  size="20" placeholder="Enter First Name" type="text"/>
		          </div>
		        </div>
 				<div class="form-group reg-email">
		          <div >
		            <input name="lastName"  id="lastName"  class="form-control input"  size="20" placeholder="Enter Last Name" type="text"/>
		          </div>
		        </div>
 				<div class="form-group reg-email">
		          <div >
		            <input name="email"  id="email"  class="form-control input"  size="20" placeholder="Enter Email" type="text"/>
		          </div>
		        </div>
		        <div class="form-group reg-password">
		          <div >
		            <input name="password"  id="password"  class="form-control input"  size="20" placeholder="Password" type="password"/>
		          </div>
		        </div>
		        <div class="form-group">
		          <div >
		            <div class="checkbox login-remember">
		              <label>
		                <input name="rememberme" id="rememberme" value="forever" checked="checked" type="checkbox"/>
		                Remember Me </label>
		            </div>
		          </div>
		        </div>
		        <div >
		          <div >
		            <input name="submit" class="btn  btn-block btn-lg btn-primary" id="registerBtn" value="REGISTER" type="button">
		          </div>
		        </div>
			</form>
		        <!--userForm--> 
		        
		      </div>
		      <div class="modal-footer">
		        <p class="text-center"> Already member? <a data-toggle="modal"  data-dismiss="modal" href="#ModalLogin"> Sign in </a> </p>
		      </div>
		    </div>
		    <!-- /.modal-content --> 
		    
		  </div>
		  <!-- /.modal-dialog --> 
		  
		</div>
		<!-- /.ModalSignup End -->
		
		<!-- Header Start -->
		<div class="navbar navbar-tshop navbar-fixed-top megamenu" role="navigation">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- Header End -->
		
		<!-- Main Container Start -->
		<div class="container main-container headerOffset"> 
			<!-- Breadcrumb Start -->
			<div class="row">
				<tiles:insertAttribute name="breadCrumb" />
			</div>
			<!-- Breadcrumb End -->
			<!-- Body Container Start -->
			<div class="row">
				<!-- Left Navigation Start -->
				<div class="col-lg-3 col-md-3 col-sm-12">
					<tiles:insertAttribute name="navigation" />	
				</div>
				<!-- Left Navigation End -->
				<!-- Main Body Start -->
				<div class="col-lg-9 col-md-9 col-sm-12">
					<tiles:insertAttribute name="body" />
				</div>
				<!-- Main Body Start -->
			</div>
			<!-- Body Container End -->
		</div>
		<!-- Main Container End -->
		<div class="gap"> </div>
		<!-- Footer Start -->
			<tiles:insertAttribute name="footer" />
		<!-- Footer End -->
		
		<tiles:insertAttribute name="script" ignore="true" />
		
		<%-- <div class="header-div"> <tiles:insertAttribute name="header" /> </div>         
		
		<div class="menu-div">  <tiles:insertAttribute name="navigation" /> </div>
		   
		<div class="body-div"> <tiles:insertAttribute name="body" /> </div>
		
		<div class="feeds-div"> <tiles:insertAttribute name="feeds" /> </div>
					
		<div class="footer-div"> <tiles:insertAttribute name="footer" /> </div>--%>

					
    </body>
</html>