AjaxQuote Portlet
=================

A update the great LifeRay Stock Plugin Portlet!

Real-time market quote data is streamed to one or more portlets on the page by Ajax and JavaScript technology. Watch the tickers move in real-time on the screen (with no stress on the back-end; all client side services)

Features:
Quote data is updated on the page in real-time
Support Annoymous and Personalized portlets with different portfolios
Multiple Instance Portlets on the same page
Support JPA 1.0 and 2.0 persistance units and hibernate libraries with maven profile build switches


Build Instructions
==================

IBM WebSphere Portal 7.0
<br>
<code>mvn -P jpa10 clean install</code>
<br>
IBM WebSphere Portal 8.0 and all Tomcat LifeRay bundle: 
<br>
<code>mvn -P jpa20 clean install</code>
<br>
JBOSS LifeRay bundle:
<br>
<code>mvn clean install -P jpa20,mysql</code>


Eclipse M2E Instructions
========================

If you are using eclipse; in order to get rid of IDE errors in the jar project you will have to uncomment this line in the backend jar pom to indicate:

<br>
<code><!-- activeByDefault>true</activeByDefault--></code> 
<br>
Located:
<br>
https://github.com/openfeed/AjaxQuotePortlet/blob/master/ajaxquote_jar/pom.xml



Vanilla WebSphere Application Server test portal harness can be configured by uncommenting the PortalEquitiesServlet servlet in the web.xml

After deployment to liferay "liferay-portal-6.1.1-ce-ga2\tomcat-7.0.27\webapps\ajaxquote_war\WEB-INF\web.xml" must be edited. Listeners supposed be in the right sequence:

<code>
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<listener>
	<listener-class>com.liferay.portal.kernel.servlet.PluginContextListener</listener-class>
</listener>
<listener>
	<listener-class>com.liferay.portal.kernel.servlet.SerializableSessionAttributeListener</listener-class>
</listener>
</code>

When deploying to WAS. Make sure that before you run a maven build you edit "ajaxquote-v0.91\ajaxquote_war\WebContent\WEB-INF\web.xml"

 <!-- 
	<servlet>
		<servlet-name>PortalEquitiesServlet</servlet-name>
		<jsp-file>/WEB-INF/jsp/portal/portal_equities.jsp</jsp-file>
	</servlet>


	<servlet-mapping>
		<servlet-name>PortalEquitiesServlet</servlet-name>
		<url-pattern>/portale/*</url-pattern>
	</servlet-mapping>
 -->
 
remove these comments.

TRUNCATE TABLE wdgt_user;
<br>
TRUNCATE TABLE wdgt_user_ui;
<br>
TRUNCATE TABLE wdgt_user_ui_market_entity;
