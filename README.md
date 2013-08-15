AjaxQuote Portlet
================

A update the great LifeRay Stock Plugin Portlet


New in v0.93 is the maven build option for creating a JPA 1.0 or 2.0 persistence xml and the corresponding JPA Hibernate provider classes version 3.3.2.GA (JPA 1.0) or 4.2.2.Final (JPA 2.0).

Run the following maven profile commands for either build:
<br>
1. mvn -P jpa10 clean install (build for IBM WebSphere Portal 7)
<br>
2. mvn -P jpa20 clean install (build for LifeRay and IBM WebSphere Portal 8)

If you are using eclipse; in order to get rid of IDE errors in the jar project you will have to uncomment this line <!-- activeByDefault>true</activeByDefault--> in the backend jar pom.

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
