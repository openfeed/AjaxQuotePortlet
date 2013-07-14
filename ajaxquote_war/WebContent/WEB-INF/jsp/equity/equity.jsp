<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page session="false" %>
<h1>Equity</h1>
<portlet:defineObjects/>
<link rel="stylesheet" type="text/css" href="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/css/ajaxquote.css"%>" />
<script src="<%=renderResponse.encodeURL(renderRequest.getContextPath())+"/resources/js/ajaxquote.js"%>"></script>
<script>
(function(){
	var of_<portlet:namespace/> = (window.of_<portlet:namespace/> = (window.of_<portlet:namespace/> || {}));
	of_<portlet:namespace/>.stock_table,
	of_<portlet:namespace/>.q = "<c:out value="${stocks}" />", 
	of_<portlet:namespace/>.red_font="<font color='red'>",
	of_<portlet:namespace/>.green_font="<font color='green'>", 
	of_<portlet:namespace/>.font_end="</font>";
	of_<portlet:namespace/>.ajaxUpdateSTable=function(){
		if(of_<portlet:namespace/>.q.length!=0){
			$("#<portlet:namespace/>googleScriptId").remove();
			var g = document.createElement('script'); g.type = 'text/javascript'; g.async = true; g.id = '<portlet:namespace/>googleScriptId';
    		g.src = ('https:' == document.location.protocol ? 'https://' : 'http://www') + '.google.com/finance/info?client=ig&q='+of_<portlet:namespace/>.q+'&callback=of_<portlet:namespace/>.processData';
			$("#<portlet:namespace/>scriptContainer").append(g);
		}
	};
	of_<portlet:namespace/>.processData=function(jsondata){
		of_<portlet:namespace/>.stock_table.fnClearTable();
		for ( var i=0 ; i<jsondata.length ; i++ )
			{
				var arr = new Array(8);
				arr[0]= jsondata[i]["t"]?jsondata[i]["t"]:"none";
				arr[1]= jsondata[i]["e"]?jsondata[i]["e"]:"none";
				arr[2]= jsondata[i]["l"]?jsondata[i]["l"]:"none";
				arr[3]= jsondata[i]["l_cur"]?jsondata[i]["l_cur"]:"none";
				arr[4]= jsondata[i]["ltt"]?jsondata[i]["ltt"]:"none";
				arr[5]= jsondata[i]["lt"]?jsondata[i]["lt"]:"none";
				if(jsondata[i]["c"]>=0){
					arr[6] = of_<portlet:namespace/>.green_font+jsondata[i]["c"]+of_<portlet:namespace/>.font_end;
				}else if (jsondata[i]["c"]<0){
					arr[6] = of_<portlet:namespace/>.red_font+jsondata[i]["c"]+of_<portlet:namespace/>.font_end;
				}
				if(jsondata[i]["c"]>=0){
					arr[7] = of_<portlet:namespace/>.green_font+jsondata[i]["cp"]+of_<portlet:namespace/>.font_end;
				}else if (jsondata[i]["c"]<0){
					arr[7] = of_<portlet:namespace/>.red_font+jsondata[i]["cp"]+of_<portlet:namespace/>.font_end;
				}
				of_<portlet:namespace/>.stock_table.fnAddData(arr);
			}
	};
	$(document).ready(function() {
		of_<portlet:namespace/>.stock_table = $('#<portlet:namespace/>stock_table').dataTable( {
			"bJQueryUI": false,
			"bProcessing": false,
			"bJQueryUI":true,
			"bStateSave": true
		} );
		of_<portlet:namespace/>.ajaxUpdateSTable();
		setInterval( 'of_<portlet:namespace/>.ajaxUpdateSTable()', 5000 );
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
			<th>Last Trade Time</th>
			<th>Last Trade Date/Time</th>
			<th>Change</th>
			<th>Change (%)</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>