<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<h2> Manage categories form</h2>

<table>
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td></td>
	</tr>
	<c:if test="${not empty appData.categories}">
		<c:forEach var="category" items="${appData.categories}">
			<tr>
				<td>${category.catId}</td>
				<td>${category.catName}</td>
				<td>
					<form method="post">
						<button formaction="removecategory.htm?category=${category.catId}"
							type="submit">Remove</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<form method="post">
		<tr>
			<td><input type="text" name="catId" /></td>
			<td><input type="text" name="catName" /></td>
			<td>
				<button formaction="addcategory.htm" type="submit">Add</button>
			</td>
		</tr>
	</form>
</table>
