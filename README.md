This Readme is for the TALA ATM program.

How to set up and run the ATM program on Windows 10 using IntelliJ IDE:

##########################     SETUP INTELLIJ AND JAVA PATH     ##########################
1. I have created this ATM program using the IntelliJ IDE on a windows computer, 
and thus I will explain the set up with relation to this.
2. If you have IntelliJ installed and running, then you can skip the step 3 through 7, otherwise
please continue reading.
3. Download and install IntelliJ for Windows, the community edition from the site:
https://www.jetbrains.com/idea/download/#section=windows.
4. Download JDK 1.8 from the site: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.
Download the JDK from "Java SE Development Kit 8u131" table. 
Accept the License Agreement and install the version that best matches your computer. I downloaded the Windows x64 file.
5. To install JDK, open the folder and double-click the installer's icon. Then, follow 
the instructions the installer provides.
6. Now you need to set the PATH to the JDK permanently on Windows:
		a) Go to your Control Panel, then System.

		b) Click Advanced system settings, then Environment Variables.
		
		c) Add a New System Variable: Variable Name: PATH and Variable Value: C:\Program Files\Java\jdk1.8.0_121
		
		Exit the control panel.

7) Add the JDK path to IntelliJ - Click on Filr -> Project Structure -> Under the 'Project SDK' add the path to the JDK. In
my case it is: 'C:\Program Files\Java\jdk1.8.0_121', click on Apply -> OK.


##################    CLONE REPOSITORY FROM GITHUB     ##########################

1. Assuming that you have access to GitHub, clone the repo at:
2. Open the project TalaATMQATest from the cloned repo, using IntelliJ.


##################    RUNNING THE ATM PROGRAM     ##########################
