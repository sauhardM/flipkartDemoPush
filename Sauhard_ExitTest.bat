set "location= C:\Users\sauhardmishra\Downloads\Flipkart_Automation_Project\Flipkart_Automation_Project\"
call mvn -f %location%/pom.xml dependency:resolve
call mvn -f %location%/pom.xml compile
call mvn -f %location%/pom.xml test -DtestSuite=testng
pause