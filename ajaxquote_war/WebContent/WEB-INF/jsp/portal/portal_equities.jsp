<%@ taglib uri="http://ibm.com/portlet/aggregation" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<portlet:scope>
	<portlet:portlet context="/openfeed" portletname="eplt"
		windowId="firstWnd" />
</portlet:scope>
<portlet:init portletURLPrefix="/openfeed/portale">
	<html>
	<head>
	<title>Equity Portal</title>
	</head>
	<!-- create portal table of two columns -->
	<body style="font-size: 65%;">

	<table>
		<tr>
			<td><a href="/openfeed/portale">Market Analytics</a></td>
		</tr>
		<tr>
			<td><a href="/openfeed/portale">Equities</a></td>
		</tr>
		<tr>
			<td>
			<TABLE BORDER="1" WIDTH="900">
				<TR>
					<TD>
					<table WIDTH="450">
						<tr BGCOLOR="BBBBFF">
							<td>
							<TABLE WIDTH="450">
								<TR>
									<TD><B><span id="title_1">Portlet 1</span></B></TD>
									<TD ALIGN="right"><a
										href="<portlet:state url='/openfeed/eplt' 
				windowId='firstWnd' portletMode='view'/>">view</a>/<a
										href="<portlet:state url='/openfeed/eplt' 
				windowId='firstWnd' portletMode='edit'/>">edit</a>
									</TD>
								</TR>
							</TABLE>
							</td>
						</tr>
						<tr>
							<td><portlet:insert url="openfeed/eplt"
								windowId="firstWnd" titleVar="portlettitle_1" /></td>
						</tr>
					</table>
					</TD>
				</TR>
			</TABLE>
			</td>
		</tr>
				<tr>
			<td>
			<TABLE BORDER="1" WIDTH="900">
				<TR>
					<TD>
					<table WIDTH="450">
						<tr BGCOLOR="BBBBFF">
							<td>
							<TABLE WIDTH="450">
								<TR>
									<TD><B><span id="title_2">Portlet 2</span></B></TD>
									<TD ALIGN="right"><a
										href="<portlet:state url='/openfeed/eplt' 
				windowId='secondWnd' portletMode='view'/>">view</a>/<a
										href="<portlet:state url='/openfeed/eplt' 
				windowId='secondWnd' portletMode='edit'/>">edit</a>
									</TD>
								</TR>
							</TABLE>
							</td>
						</tr>
						<tr>
							<td><portlet:insert url="openfeed/eplt"
								windowId="secondWnd" titleVar="portlettitle_2" /></td>
						</tr>
					</table>
					</TD>
				</TR>
			</TABLE>
			</td>
		</tr>
	</table>
	<!-- insert portlet title --> <script type="text/javascript">
  		document.getElementById("title_1").firstChild.nodeValue = "${portlettitle_1}";
  		document.getElementById("title_2").firstChild.nodeValue = "${portlettitle_2}";
	</script>
	</body>
	</html>
</portlet:init>