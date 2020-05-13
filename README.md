# doc


# Instructions

Clone the 3 repositories under dealretail (drl, dr-parent, dr-db-scripts)

Install JDK 1.8, Mysql 5+ and Tomcat 8+

Run the Sale.sql under dealretail/dr-db-scripts through MySQL client

Build dr-parent (mvn clean install)

Change the MySQL username/password for Datasouce as per your local setup. https://github.com/dealretail/drl/blob/master/dr/src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml

Build drl (mvn clean install)

Deploy drl.war in Tomcat server

Access http://localhost:8080/drl
