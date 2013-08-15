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
<code>mvn clean install -P jpa10</code>
<br>
IBM WebSphere Portal 8.0 and all Tomcat LifeRay bundle: 
<br>
<code>mvn clean install -P jpa20</code>
<br>
JBOSS LifeRay bundle (MySQL):
<br>
<code>mvn clean install -P jpa20,mysql</code>


Eclipse M2E Instructions
========================

If you are using eclipse; in order to get rid of IDE errors in the jar project you will have to uncomment this line in the backend jar pom to indicate:
<code> <!-- activeByDefault>true</activeByDefault--> </code> 
<br>
<br>
Located:

https://github.com/openfeed/AjaxQuotePortlet/blob/master/ajaxquote_jar/pom.xml

Database Instructions
========================
Initial SQL scripts are provided to load the popular company and market symbols for key stroke ahead find company functionality; into the openfeed schema.
<br>
https://github.com/openfeed/AjaxQuotePortlet/tree/master/sql


LifeRay 6.1 GA2 Support
=======================
LifeRay 6.1 GA2 has a issue with (LPS-29103) the deployment manager moving the Spring context listner directive deep down in the bottom of the post deployed web.xml. Use the following web.xml script post deployment for the portlet to function:
<br>
https://github.com/openfeed/AjaxQuotePortlet/tree/master/liferay_6.1_GA2_post_deployment_fix


<!-- 
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<br>
<listener>
	<listener-class>com.liferay.portal.kernel.servlet.PluginContextListener</listener-class>
</listener>
<br>
<listener>
	<listener-class>com.liferay.portal.kernel.servlet.SerializableSessionAttributeListener</listener-class>
</listener>
 -->

When deploying to WAS. Make sure that before you run a maven build you edit "ajaxquote-v0.91\ajaxquote_war\WebContent\WEB-INF\web.xml"

<code>
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
 </code>
remove these comments.

TRUNCATE TABLE wdgt_user;
<br>
TRUNCATE TABLE wdgt_user_ui;
<br>
TRUNCATE TABLE wdgt_user_ui_market_entity;
