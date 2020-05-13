<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<h2>Manage category sites form</h2>

<table>
	<tr>
		<td>Category</td>
		<td>Site</td>
		<td>Browse Link</td>
		<td></td>
	</tr>
	<c:if test="${not empty categorySiteBean.allCategorySites}">
		<c:forEach var="categorySite"
			items="${categorySiteBean.allCategorySites}">
			<tr>
				<td>${categorySite.catName}</td>
				<td>${categorySite.siteName}</td>
				<td>${categorySite.browseLink}</td>
				<td>
					<form method="post">
						<button
							formaction="removecss.htm?category=${categorySite.catId}&site=${categorySite.siteId}"
							type="submit">Remove</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<h3>Add New Category &and; Site Details</h3>

<form method="post">
	<table>
		<tr>
			<td>Category: <select name="newCategorySite.catId">
					<c:if test="${not empty appData.categories}">
						<c:forEach var="category" items="${appData.categories}">
							<option value="${category.catId}">${category.catName}</option>
						</c:forEach>
					</c:if>
			</select>
			</td>
			<td>Site: <select name="newCategorySite.siteId">
					<c:if test="${not empty appData.sites}">
						<c:forEach var="site" items="${appData.sites}">
							<option value="${site.siteId}">${site.siteName}</option>
						</c:forEach>
					</c:if>
			</select>
			</td>
		</tr>
		<tr>
			<td>Browse Link: <input type="text" name="newCategorySite.browseLink" /></td>
			<td>Product Keyword: <input type="text" name="newCategorySite.productKeyword" /></td>
		</tr>
		<tr>
			<td>Image Keyword: <input type="text" name="newCategorySite.imageKeyword" /></td>
			<td>Redirection Keyword: <input type="text" name="newCategorySite.redirectionKeyword" /></td>
		</tr>
		<tr>
			<td>Original Price Keyword: <input type="text" name="newCategorySite.orgPriceKeyword" /></td>
			<td>Sale Price Keyword: <input type="text" name="newCategorySite.salePriceKeyword" /></td>
		</tr>
		<tr>
			<td>Description Keyword: <input type="text" name="newCategorySite.descriptionKeyword" /></td>
			<td>Item Count Keyword: <input type="text" name="newCategorySite.itemCountKeyword" /></td>
		</tr>
		<tr>
			<td>Pagination URL: <input type="text" name="newCategorySite.paginationUrl" /></td>
			<td>Products Per Page: <input type="text" name="newCategorySite.itemsPerPage" /></td>
		</tr>
	</table>

	<button formaction="addcss.htm" type="submit">Add</button>
</form>

