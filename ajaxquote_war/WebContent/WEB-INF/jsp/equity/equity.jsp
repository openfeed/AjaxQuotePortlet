<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page session="false" %>
<h1>Equity</h1>
<portlet:defineObjects/>
<link rel="stylesheet" type="text/css" href="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/css/ajaxquote.css"%>" />
<script src="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/js/ajaxquote.js"%>"></script>
<script>
(function(){
	$(document).ready(function() {
		var dataTable = $('#<portlet:namespace/>stock_table').dataTable( {
			"bJQueryUI": false,
			"bProcessing": false,
			"bJQueryUI":true,
			"bStateSave": true
		} );
		var of_<portlet:namespace/> = (window.of_<portlet:namespace/> = (window.of_<portlet:namespace/> || new of_ajaxquote('<portlet:namespace/>',"googleScriptId","scriptContainer",'<c:out value="${stocks}" />',dataTable,true)));
		of_<portlet:namespace/>.ajaxUpdateTable();
		setInterval( 'of_<portlet:namespace/>.ajaxUpdateTable()', 5000 );
	});
})();
</script>
<div id="<portlet:namespace/>scriptContainer"></div>
<table id="<portlet:namespace/>stock_table" cellpadding="0" cellspacing="0" border="0" class="display">
	<thead>
		<tr>
			<th>Ticker</th>
			<th>Exchange</th>
			<th>Last Price</th>
			<th>Last Current Price</th>
			<th>Change</th>
			<th>Change (%)</th>
			<th>Last Trade Time</th>
			<th>Last Trade Date/Time</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>