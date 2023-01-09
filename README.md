#Flipkart Automation Exit Test Assignment

<hr>

## Git Respository link:-

https://github.com/sauhardM/Flipakart_ExitTest_Assignment

##Requirements :-

- JDK needs to be installed in your local machine and path needs to be set in your local machine.

- Refer to this link on how to set path for the JDK : https://www.javatpoint.com/how-to-set-path-in-java

- Install and IDE, I recommend using Eclipse.

- Also make sure to install maven for java as it will be an essential part of the project.

<hr>

##TestNG installion in eclipse :-

- Refer to the file "TestNG installion in Eclipse.docx" availabe in folder [Flipkart_Automation_Project//Resources].

<hr>

##Steps to intall the project :-

- Unzip or extract the .zip File.

- Copy and paste whole project file with name "Flipkart_Automation_Project" in your eclipse-workspace folder or any any folder you want to.

- Make sure to install the webdrivers of the same version for chrome, firefox and edge you are currently working with.

- Make sure to download to the webdrivers inside the [Flipkart_Automation_Project//Resources] folder as it will be a part of the project.

- Now go to the config.properties file inside the project [Flipkart_Automation_Project//Resources//config.propeties]

- Now change the path of the "driverpath", "ffdriverpath" and "edgedriverpath" with the actual path of the drivers you have downloaded inside the file [Flipkart_Automation_Project//Resources].


<hr>

##Running the test cases :-

- Test cases will run in two modes GUI and Headless.

- Go to [Flipkart_Automation_Project//Resources//config.propeties] and change the "mode" to "headless" to run in that mode.

- Go to [Flipkart_Automation_Project//Resources//config.propeties] and change the "mode" to "non-headless" to run in GUI mode.

- - Go to [Flipkart_Automation_Project//Resources//config.propeties] and change the "browser" to "chrome,firefox or edge" to run with that particular browser.

- Now go to testNG.xml file and open it, i have provided the path for the each test cases in comments.

- To run a test case copythe name path of the test case inside "name" attribute of the "class" tag.

- For exmaple <class name="TestCases.LogInTest"/>.

- Enter the path of the test case you wish to run that i have already provided inside the commensts.

- Now right click inside the testNG.xml file and go to "Run As" option and select TestNg Suite.

- P.S :- Also change the path of the driverpath inside the "value" attribute of the "parameter" tag  with the chrome driver path you have installed, if you wish to call the path with parameter.


<hr>

##ScreenShots :-

- ScreenShots of the failed test cases will be available inside the folder [Flipkart_Automation_Project//ScreenShots]

<hr>

##Reports :-

- Reports of the test cases will be updated after every execution of that particular testcase.

- Reports of the test cases will be availabe inside the folder [Flipkart_Automation_Project//Reports//Extent_demo.html]

- Double click the Extent_demo.html file to open the report in your default browser.


##Jars:-

External jars have been created and used, you can find the jar file named "ReadFilePropertiesJarFile.jar".