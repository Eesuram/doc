<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<c:set var="criteria" value="${welcomeBean.filterCriteria}" />
<c:set var="products" value="${welcomeBean.products}" />


<c:choose>
	<c:when test="${not empty criteria}">
		<c:set var="sortBy" value="${criteria.sortBy}" />
	</c:when>
	<c:otherwise>
		<c:set var="sortBy" value="-1" />
	</c:otherwise>
</c:choose>

<div class="w100 clearfix category-top">
	<h2>Best Deals for YOU!</h2>
	
	<c:if test="${not empty welcomeBean.filterCriteria.searchKey}">
		<h4>
			Products related to the search pattern "<I>${welcomeBean.filterCriteria.searchKey}</I>"
		</h4> You can search with empty string to see all the products.
    </c:if>
        
     <c:if test="${welcomeBean.signedIn == false}">
     	<h4>
     	<a href="#" data-toggle="modal" data-target="#ModalSignup">
     	<u>Become a Member</u></a> to get more discounts. Guest user can see discounts &lt; 40% only.
     	</h4>
     </c:if>

</div>
<!--/.category-top-->
<div class="w100 productFilter clearfix">
	<p class="pull-left">
		Showing <strong>${welcomeBean.productCount}</strong> products
	</p>
	<div id="searchAndSort" class="pull-right ">
		<div class="change-order pull-right">
			<form id="sortForm" name="searchForm" method="GET"
				action="welcome.htm">
				<select class="form-control" name="sortBy" value="${sortBy}"
					onchange="document.getElementById('sortForm').submit();">
					<option selected="selected" value="-1">--- Sort By ---</option>
					<option value="price">Price Low to High</option>
					<option value="savings">Savings</option>
				</select>
			</form>
		</div>
		<div class="change-view pull-right">
			<a href="#" title="Grid" class="grid-view"> <i
				class="fa fa-th-large"></i>
			</a> <a href="#" title="List" class="list-view "><i
				class="fa fa-th-list"></i></a>
		</div>
		<div class="searchQueries pull-right">
			<c:if test="${not empty criteria}">
				<c:if test="${not empty criteria.category}">
					<span class="searchType"> ${criteria.category} <a
						href="welcome.htm?removeCookie=categoryId"> <img
							class="closeBtn" src="images/close.jpg" />
					</a>
					</span>
				</c:if>
				<c:if test="${not empty criteria.priceRange}">
					<span class="searchType"> ${criteria.priceRange} <a
						href="welcome.htm?removeCookie=priceRange"> <img
							class="closeBtn" src="images/close.jpg" />
					</a>
					</span>
				</c:if>
				<c:if test="${not empty criteria.savings}">
					<span class="searchType"> ${criteria.savings} <a
						href="welcome.htm?removeCookie=savings"> <img class="closeBtn"
							src="images/close.jpg" />
					</a>
					</span>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
<!--/.productFilter-->


<c:forEach var="product" items="${products}">
	<c:if test="${product.salePrice > 0}">
		<div class="item col-sm-4 col-lg-4 col-md-4 col-xs-6">
			<div class="product">
				<div class="image">
					<a class="newWindow" href="redirect.htm?productId=${product.productId}"><img
						src="${product.imageLink}" alt="img"
						class="img-responsive"></a>
					<div class="promotion">
						<span class="new-product"> Savings</span> <span class="discount">${product.savings}%
							OFF</span>
					</div>
				</div>
				<div class="description">
					<h4>
						<a class="newWindow"
							href="redirect.htm?productId=${product.productId}">${product.productName}</a>
					</h4>
					<!--p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p-->
					<span class="size">XL / XXL / S </span>
				</div>
				<div class="price">
					<span>Org. Price $ ${product.orgPrice}</span><br /> <span
						class="salePriceColor">Sale Price $ ${product.salePrice}</span><br />
					<!--span>Total Savings ${product.savings} %</span-->
				</div>
				<div class="action-control">
					<a class="btn btn-primary newWindow"
						href="redirect.htm?productId=${product.productId}"> <span
						class="add2cart"><i
							class="glyphicon glyphicon-shopping-cart"> </i> Go To Site </span>
					</a>
				</div>
			</div>
		</div>
		<!--/.item-->
	</c:if>
</c:forEach>

<!-- Dynamic Pagination Start -->
<div class="w100 categoryFooter">
	<div class="pagination pull-left no-margin-top">
		<c:set var="pageCount" value="${welcomeBean.productCount / 18}" />
		<c:if test="${welcomeBean.productCount % 18 > 0}">
			<c:set var="pageCount" value="${pageCount + 1}" />
		</c:if>

		<c:set var="currentPage" value="${welcomeBean.currentPage}" />

		<ul class="pagination no-margin-top">
			<c:if test="${currentPage > 1 }">
				<li><a href="welcome.htm?pageIndex=${currentPage - 1}">&lt;&lt;</a></li>
			</c:if>

			<fmt:formatNumber var="variance" value="${((currentPage - 1) / 5) - 0.5}" pattern="0"/>
			<c:set var="startPage" value="${variance * 5 + 1}" />
			
			<c:set var="endPage" value="${startPage + 4}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:forEach var="index" begin="${startPage}" end="${endPage}">

				<c:choose>
					<c:when test="${index == currentPage }">
						<li class="active"><a href="welcome.htm?pageIndex=${index}">${index}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="welcome.htm?pageIndex=${index}">${index}</a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>

			<c:if test="${currentPage < pageCount}">
				<li><a href="welcome.htm?pageIndex=${currentPage + 1}">&gt;&gt;</a></li>
			</c:if>
		</ul>
	</div>

	<div
		class="pull-right pull-right col-sm-4 col-xs-12 no-padding text-right text-left-xs">
		<c:set var="startNumber" value="${((currentPage - 1) * 18) + 1}" />

		<c:set var="endNumber" value="${startNumber + 17}" />
		<c:if test="${startNumber + 17 > welcomeBean.productCount}">
			<c:set var="endNumber" value="${welcomeBean.productCount}" />
		</c:if>

		<p>Showing ${startNumber} - ${endNumber} of ${welcomeBean.productCount}
			results</p>
	</div>
</div>
<!-- Pagination End -->
