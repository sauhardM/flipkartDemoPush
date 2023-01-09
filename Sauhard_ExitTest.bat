set "location= C:\Users\sauhardmishra\Downloads\Flipkart_Automation_Project\Flipkart_Automation_Project\"
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=<ReadFilePropertiesJarFile.jar>
call mvn -f %location%/pom.xml dependency:resolve
call mvn -f %location%/pom.xml compile
call mvn -f %location%/pom.xml test -DtestSuite=testng
pause