hateoas-link-test
=================

A test project for demonstrating the issues with HATEOAS links and matrix variables on different application servers.

Instructions
============

1. Deploy the .war to your preferred application server.
2. Navigate to "http://localhost:port/contextPath/test-items/firstString;matrixVariable=secondString/test".
3. Observe the output. It should be "http://localhost:port/contextPath/test-items/firstString;matrixVariable=secondString/test", not "http://localhost:port/contextPath/test-items/firstString/test-items/firstString;matrixVariable=secondString/test".

Additional
==========

A simple unit called TestControllerTest is available. This test generates a link, and passes if the link is as expected.

The link has been observed to be correct when deployed to Tomcat 8.0.15, but incorrect when deployed to JBoss 6.2 EAP (7.3.0.Final-redhat-14) or JBoss 6.3 EAP GA (7.4.0.Final-redhat-19).

Deployment to Tomcat was done through IntelliJ 13.1.5, while deployments to JBoss were done manually as well as using IntelliJ 13.1.5 and 13.1.6.

For JBoss, you'll need to set enable-welcome-root="false" in your standalone.xml, or specify a different context-path in /WEB-INF/jboss-web.xml.