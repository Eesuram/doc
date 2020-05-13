<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<h2>Refresh products</h2>

<h3>Total No. of Products: ${productCount}</h3>

<form name="refreshProducts" method="post" action="refreshproductscs.htm">
	<table>
		<tr>
			<td>Category:</td>
			<td><select name="category">
					<option value="">---- Select ----</option>
					<c:if test="${not empty appData.categories}">
						<c:forEach var="category" items="${appData.categories}">
							<option value="${category.catId}">${category.catName}</option>
						</c:forEach>
					</c:if>
			</select>
		</tr>
		<tr>
			<td>Site:</td>
			<td><select name="site">
					<option value="">---- Select ----</option>
					<c:if test="${not empty appData.sites}">
						<c:forEach var="site" items="${appData.sites}">
							<option value="${site.siteId}">${site.siteName}</option>
						</c:forEach>
					</c:if>
			</select>
		</tr>
	</table>
	<button type="submit" value="Refresh">Refresh</button>
</form>

<form name="refreshProducts" method="post" action="refreshproducts.htm">
	<button type="submit" value="Refresh All Products">Refresh All Products</button>
</form>
