<jsp:directive.include file="/WEB-INF/jsp/tiles/taglibs.jsp" />

<h2>Manage sites form</h2>

<table>
	<tr>
		<td>Site ID</td>
		<td>Site Name</td>
		<td>Site Link</td>
		<td>Site Description</td>
		<td></td>
	</tr>
	<c:if test="${not empty appData.sites}">
		<c:forEach var="site" items="${appData.sites}">
			<tr>
				<td>${site.siteId}</td>
				<td>${site.siteName}</td>
				<td>${site.siteLink}</td>
				<td>${site.siteDescription}</td>
				<td>
					<form method="post">
						<button formaction="removesite.htm?site=${site.siteId}"
							type="submit">Remove</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
	<form method="post">
		<tr>
			<td><input type="text" name="siteId" /></td>
			<td><input type="text" name="siteName" /></td>
			<td><input type="text" name="siteLink" /></td>
			<td><input type="text" name="siteDescription" /></td>
			<td>
				<button formaction="addsite.htm" type="submit">Add</button>
			</td>
		</tr>
	</form>
</table>
