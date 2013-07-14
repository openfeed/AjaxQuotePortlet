<%@ include file="/WEB-INF/jsp/include.jsp"%>
<table cellpadding="0" cellspacing="0" border="0" width="400">
	<c:if test="${!empty errorMsg}"><tr><td colspan="2"><c:out value="${errorMsg}"/></td></tr></c:if>
	<form name="formLogin" method="post" action="j_security_check"	id="j_security_check">
		<tr>
			<td align="right" class="textbd">
				<spring:message code="label.username"/>:&nbsp;
			</td>
			<td class="text" align="left">
				<input size="15" name="j_username" maxlength="20"
					id="j_security_check_j_username" />
			</td>
		</tr>
		<tr>
			<td align="right" class="textbd">
				<spring:message code="label.password"/>:&nbsp;
			</td>
			<td class="text" align="left">
				<input type="password" size="15" name="j_password" maxlength="20"
					 id="j_security_check_j_password" />
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<table>
					<tr>
						<td>
							<br>
							<div class="button" onclick="document.formLogin.submit();">
								<spring:message code="label.submit"/>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</form>
</table>
<script>
document.getElementById("j_username").focus();
</script>