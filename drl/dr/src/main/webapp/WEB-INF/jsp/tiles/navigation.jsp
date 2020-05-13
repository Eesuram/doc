<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<div class="panel-group" id="accordionNo">
	<!-- Admin Panel-->
	<c:if test="${not empty bean && bean.admin}">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapseAdmin"
						class="collapseWill"> <span class="pull-left"> <i
							class="fa fa-caret-right"></i></span> Admin Activities
					</a>
				</h4>
			</div>

			<div id="collapseAdmin" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="adminMenu">
						<ul>
							<li><a href="refreshproducts.htm">Refresh Products</a></li>
							<li><a href="managesites.htm">Manage Sites</a></li>
							<li><a href="managecategories.htm">Manage Categories</a></li>
							<li><a href="managecss.htm">Manage Category Sites</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--/Admin Panel end-->
	</c:if>

	<!--Category-->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" href="#collapseCategory"
					class="collapseWill"> <span class="pull-left"> <i
						class="fa fa-caret-right"></i></span> Categories
				</a>
			</h4>
		</div>

		<div id="collapseCategory" class="panel-collapse collapse in">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked tree">
					<c:forEach var="category" items="${appData.categories}">
						<li><a href="welcome.htm?categoryId=${category.catId}"><c:out
									value="${category.catName}" /></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<!--/Category menu end-->

	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a class="collapseWill" data-toggle="collapse" href="#collapsePrice">
					Price Range<span class="pull-left"> <i
						class="fa fa-caret-right"></i></span>
				</a> <span class="pull-right clearFilter  label-danger"> Clear </span>
			</h4>
		</div>
		<div id="collapsePrice" class="panel-collapse collapse in">
			<div class="panel-body priceFilterBody">
				<li><a href="welcome.htm?priceRange=0-100">0 - 100</a></li>
				<li><a href="welcome.htm?priceRange=101-200">101 - 200</a></li>
				<li><a href="welcome.htm?priceRange=201-300">201 - 300</a></li>
				<li><a href="welcome.htm?priceRange=301-400">301 - 400</a></li>
				<li><a href="welcome.htm?priceRange=401-500">401 - 500</a></li>
				<li><a href="welcome.htm?priceRange=501-Above">501 - Above</a></li>
				<hr>
				<p>Enter a Price range</p>
				<form class="form-inline " role="form">
					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputEmail2"
							placeholder="2000 $">
					</div>
					<div class="form-group sp">-</div>
					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputPassword2"
							placeholder="3000 $">
					</div>
					<button type="submit" class="btn btn-default pull-right">check</button>
				</form>
			</div>
		</div>
	</div>
	<!--/price panel end-->

	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" href="#collapseThree" class="collapseWill">
					Discount <span class="pull-left"> <i
						class="fa fa-caret-right"></i></span>
				</a>
			</h4>
		</div>

		<div id="collapseThree" class="panel-collapse collapse in">
			<div class="panel-body">
				<ul>
					<c:choose>
						<c:when test="${welcomeBean.signedIn}">
							<li><a href="welcome.htm?savings=20">&gt;= 20%</a></li>
							<li><a href="welcome.htm?savings=40">&gt;= 40%</a></li>
							<li><a href="welcome.htm?savings=50">&gt;= 50%</a></li>
							<li><a href="welcome.htm?savings=60">&gt;= 60%</a></li>
							<li><a href="welcome.htm?savings=80">&gt;= 80%</a></li>
							<li><a href="welcome.htm?savings=90">&gt;= 90%</a></li>
						</c:when>
						<c:otherwise>
							<li>&gt;= 20%</li>
							<li>&gt;= 40%</li>
							<li>&gt;= 50%</li>
							<li>&gt;= 60%</li>
							<li>&gt;= 80%</li>
							<li>&gt;= 90%</li>
							<li id="becomeMember"><a href="#" data-toggle="modal"
								data-target="#ModalSignup">Become a Member</a> <br />to access more
								discounts and discount links</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!--/discount  panel end-->
</div>