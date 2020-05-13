<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<c:set var="criteria" value="${welcomeBean.filterCriteria}" />

<c:choose>
	<c:when test="${not empty criteria}">
		<c:set var="searchKey" value="${criteria.searchKey}" />
	</c:when>
	<c:otherwise>
		<c:set var="searchKey" value="" />
	</c:otherwise>
</c:choose>

<div class="navbar-top">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-sm-6 col-xs-6 col-md-6">

				<div class="pull-left ">
					<ul class="userMenu ">
						<li><a href="#"> <span class="hidden-xs">HELP</span><i
								class="glyphicon glyphicon-info-sign hide visible-xs "></i>
						</a></li>
						<li class="phone-number"><a href="callto:+8801680531352">
								<span> <i class="glyphicon glyphicon-phone-alt "></i></span> <span
								class="hidden-xs" style="margin-left: 5px"> 88 01680 53
									1352 </span>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-6 col-sm-6 col-xs-6 col-md-6 no-margin no-padding">
				<div class="pull-right">
					<ul class="userMenu">
						<!--               <li> <a href="account-1.html"><span class="hidden-xs"> My Account</span> <i class="glyphicon glyphicon-user hide visible-xs "></i></a> </li>
 -->
						<c:choose>
							<c:when test="${not empty bean && bean.signedIn == true}">
								<c:set var="userName" value="${bean.userName}" />
								<li><span class="hidden-xs">Welcome ${userName}! </span></li>
								<li><a href="signout.htm"> <span class="hidden-xs">Sign
											Out</span> <i class="glyphicon glyphicon-log-in hide visible-xs "></i>
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="#" data-toggle="modal"
									data-target="#ModalLogin"> <span class="hidden-xs">Sign
											In</span> <i class="glyphicon glyphicon-log-in hide visible-xs "></i>
								</a></li>
							</c:otherwise>
						</c:choose>
						<!--               <li class="hidden-xs"> <a href="#"  data-toggle="modal" data-target="#ModalSignup"> Create Account </a> </li>
 -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<!--/.navbar-top-->

<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only"> Toggle navigation </span> <span
				class="icon-bar"> </span> <span class="icon-bar"> </span> <span
				class="icon-bar"> </span>
		</button>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-cart">
			<i class="fa fa-shopping-cart colorWhite"> </i> <span
				class="cartRespons colorWhite"> Cart ($210.00) </span>
		</button>
		<a class="navbar-brand " href="index.html"> D on C </a>

		<!-- this part for mobile -->
		<div class="search-box pull-right hidden-lg hidden-md hidden-sm">
			<div class="input-group">
				<button class="btn btn-nobg" type="button">
					<i class="fa fa-search"> </i>
				</button>
			</div>
			<!-- /input-group -->

		</div>
	</div>

	<!-- this part is duplicate from cartMenu  keep it for mobile -->
	<div class="navbar-cart  collapse">
		<div class="cartMenu  col-lg-4 col-xs-12 col-md-4 ">
			<div class="w100 miniCartTable scroll-pane">
				<table>
					<tbody>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/3.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/2.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/5.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/3.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/3.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
						<tr class="miniCartProduct">
							<td style="" class="miniCartProductThumb"><div>
									<a href="product-details.html"> <img
										src="images/product/4.jpg" alt="img">
									</a>
								</div></td>
							<td style=""><div class="miniCartDescription">
									<h4>
										<a href="product-details.html"> TSHOP T shirt Black </a>
									</h4>
									<span class="size"> 12 x 1.5 L </span>
									<div class="price">
										<span> $8.80 </span>
									</div>
								</div></td>
							<td style="" class="miniCartQuantity"><a> X 1 </a></td>
							<td style="" class="miniCartSubtotal"><span> $8.80 </span></td>
							<td style="" class="delete"><a> x </a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--/.miniCartTable-->

			<div class="miniCartFooter  miniCartFooterInMobile text-right">
				<h3 class="text-right subtotal">Subtotal: $210</h3>
				<a class="btn btn-sm btn-danger"> <i class="fa fa-shopping-cart">
				</i> VIEW CART
				</a> <a class="btn btn-sm btn-primary"> CHECKOUT </a>
			</div>
			<!--/.miniCartFooter-->

		</div>
		<!--/.cartMenu-->
	</div>
	<!--/.navbar-cart-->

	<div class="navbar-collapse collapse">


		<!--- this part will be hidden for mobile version -->
		<div class="nav navbar-nav navbar-right hidden-xs">
			<div class="search-box">
				<div class="input-group">
					<button class="btn btn-nobg" type="button">
						<i class="fa fa-search"> </i>
					</button>
				</div>
				<!-- /input-group -->

			</div>
			<!--/.search-box -->
		</div>
		<!--/.navbar-nav hidden-xs-->
	</div>
	<!--/.nav-collapse -->

</div>
<!--/.container -->

<div class="search-full text-right">
	<a class="pull-right search-close"> <i class=" fa fa-times-circle">
	</i>
	</a>
	<div class="searchInputBox pull-right">
		<form id="searchForm" name="searchForm" method="GET"
			action="welcome.htm">
			<input type="search" data-searchurl="search?=" name="searchKey"
				placeholder="start typing and hit enter to search"
				class="search-input" value="${searchKey}">
			<button class="btn-nobg search-btn" type="submit">
				<i class="fa fa-search"> </i>
			</button>
		</form>
	</div>
</div>
<!--/.search-full-->

<!--form id="searchForm" name="searchForm" method="GET"
	action="welcome.htm">
	<h2>
		Deals On Clearance <span class="right"> <input type="text"
			name="searchKey" id="searchKey" class="search" value="${searchKey}" /> <a
			href="#" onClick="document.getElementById('searchForm').submit();">
				<img style="width: 30px;height:30px;" src="assets/images/search.jpg" class="searchBtn" />
		</a>
		</span>
	</h2>
</form-->