<%@ include file="/WEB-INF/jsp/include.jsp"%>

<h1>Equity</h1>

<table class="of_edit_tbl" border="0">
	<tr>
		<th>Symbol</th>
		<th>Exchange</th>
		<th>Company Name</th>
		<td><a
			href="<portlet:renderURL>
                         <portlet:param name="action" value="add"/>
                      </portlet:renderURL>">Add Equity Stock </a></td>
	</tr>
	<c:forEach items="${stocks}" var="stock">
		<tr>
			<td><c:out value="${stock.symbol}" /></td>
			<td><c:out value="${stock.exchange}" /></td>
			<td><c:out value="${stock.companyName}" /></td>
			<td><a
				href="<portlet:actionURL>
                         <portlet:param name="action" value="delete"/>
                         <portlet:param name="id">
                             <jsp:attribute name="value">
                                 <c:out value="${stock.entityId}"/>
                             </jsp:attribute>
                         </portlet:param>
                      </portlet:actionURL>">
			Remove </a></td>
		</tr>
	</c:forEach>
</table>
