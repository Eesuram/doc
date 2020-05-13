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

			<fmt:formatNumber var="variance" value="${(currentPage - 1) / 5}" maxFractionDigits="0"/>
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
			<c:set var="endNumber" value="${endNumber}" />
		</c:if>

		<p>Showing ${startNumber} - ${endNumber} of ${welcomeBean.productCount}
			results</p>
	</div>
</div>
<!-- Pagination End -->
