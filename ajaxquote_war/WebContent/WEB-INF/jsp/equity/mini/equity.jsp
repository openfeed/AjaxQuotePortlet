<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page session="false" %>
<%-- <h1>Equity</h1> --%>
<portlet:defineObjects/>
<link rel="stylesheet" type="text/css" href="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/css/ajaxquote.css"%>" />
<script src="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/js/ajaxquote.js"%>"></script>
<script>
(function(){
	$(document).ready(function() {
		var of_<portlet:namespace/> = (window.of_<portlet:namespace/> = (window.of_<portlet:namespace/> || new of_ajaxquote('<portlet:namespace/>',"googleScriptId","scriptContainer",'<c:out value="${stocks}" />'))),
			dataTable = $('#<portlet:namespace/>stock_table').dataTable( {
			"bJQueryUI": false,
			"bProcessing": false,
			"bJQueryUI":true,
			"bStateSave": true,
			"aoColumns": [
            	{ "mData": "t" },
            	{ "mData": "e" },
            	{ "mData": "l" },
            	{ "mData": "l_cur" },
            	{ "mData": "c","sClass":"pr" },
            	{ "mData": "cp","sClass":"pr" }
        	],
        	"fnRowCallback":of_<portlet:namespace/>.rowCallback
		} );
		of_<portlet:namespace/>.setTable(dataTable);
		of_<portlet:namespace/>.ajaxUpdateTable();
		$('#<portlet:namespace/>stock_table').removeClass("hidden");
		setInterval( 'of_<portlet:namespace/>.ajaxUpdateTable()', 5000 );
	});
})();
</script>
<div id="<portlet:namespace/>scriptContainer"></div>
<table id="<portlet:namespace/>stock_table" cellpadding="0" cellspacing="0" border="0" class="hidden">
	<thead>
		<tr>
			<th>Ticker</th>
			<th>Exchange</th>
			<th>Last Price</th>
			<th>Last Current Price</th>
			<th>Change</th>
			<th>Change (%)</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>