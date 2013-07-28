<%@ include file="/WEB-INF/jsp/include.jsp"%>
<portlet:defineObjects />
<link rel="stylesheet" type="text/css" href="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/css/ajaxquote.css"%>" />
<script src="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/js/ajaxquote.js"%>"></script>
<script>
$(document).ready(function() {
            $(".<portlet:namespace/>input #symbol").autocomplete({
                source: "<portlet:resourceURL id="js" escapeXml="false" />",
                minLength: 2,
                select: function(event, ui) {
                    $('.<portlet:namespace/>input #symbol').val(ui.item.symbol);
                    $('.<portlet:namespace/>input #companyName').val(ui.item.companyName);
                    $('.<portlet:namespace/>input #exchange').val(ui.item.exchange);
                    $('.<portlet:namespace/>input #industry').val(ui.item.industry);
                }
            });
});
</script>

<h1>Equity/Edit</h1>
<portlet:actionURL var="actionUrl">
	<portlet:param name="action" value="addSubmit" />
</portlet:actionURL>
<form:form id="stockForm" commandName="stock" action="${actionUrl}">
		<table>
			<tr class="field">
				<td class="label">
					<label for="symbol">Symbol:</label>
				</td>
				<td class="<portlet:namespace/>input">
					<form:input id="symbol" path="symbol" maxlength="40" size="40"/>
					<span class="form_error"><form:errors path="symbol" /></span>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="companyName">Company Name:&nbsp;</label>
				</td>
				<td class="<portlet:namespace/>input">
					<form:input id="companyName" path="companyName" maxlength="40" size="40"/>
					<span class="form_error"><form:errors path="companyName" /></span>
					<form:hidden id="exchange" path="exchange"/>
				</td>
			</tr>
			<tr class="field">
				<td class="label">
					<label for="industry">Industry:</label>
				</td>
				<td class="<portlet:namespace/>input">
					<form:input id="industry" path="industry" maxlength="40" size="40"/>
					<span class="form_error"><form:errors path="industry" /></span>
				</td>
			</tr>
			<tr class="field">
				<td colspan="2" class="buttonGroup">
					<input type="submit" name="submit" value="Submit"/>
				</td>
			</tr>
		</table>
</form:form> 
