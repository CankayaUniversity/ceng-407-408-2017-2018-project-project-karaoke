
<p align="center">
<img src="https://i.hizliresim.com/p6r94N.png">
 </p>

 <h1 align="center">ÇANKAYA UNIVERSITY </h1>
 <h1 align="center">FACULTY OF ENGINEERING COMPUTER ENGINEERING DEPARTMENT</h1>
<h2 align="center">Development of a Karaoke Application for Language Learning</h2>
<h2 align="center">CENG 407/408</h2>
<p align="center">
<b align="center">Innovative System Design and Development I/II</b>


<p align="center">
<b align="center">Mehmet Ali BEKERECI     Ege Naz ALARSLAN      Tolga KARAMAN</b><br>

<p align="center">
<b align="center">{c1311009, c1311002, c1111029}@student.cankaya.edu.tr</b><br>
 
 
<b align="center">Installation Guide for Karaoke Application</b><br>


You should go to this site to see our website: http://developmentkaraoke.unaux.com/MainPage.html?i=1</b><br>

For our Desktop application, you can install it by choosing one of these options below.</b><br>

1-) Install with the file Binary for Linux OS.</b><br>

To install the program, you need to do the following steps in order by opening the command prompt.</b><br>
</b><br>
Code:   mkdir / home / username / src /</b><br>
So we have our source package in / home / username / src /.</b><br>
</b><br>
</b><br>
Change to the directory / home / username / src / with the command "cd" (change directory) as follows:</b><br>
Code:   CD / home / username / src /</b><br>
</b><br>
Use the list directory contents (ls) command to see that the file exists:</b><br>
Code:   ls</b><br>
We now have to extract the zipped file, this happens differently depending on the file extension.</b><br>
</b><br>
For files ending in .tar.gz:</b><br>
Code:   tar -zxvf <filename></b><br>
(Replace <filename> with the name of the file).</b><br>
</b><br>
For files ending in .tar.bz2:</b><br>
Code:   tar -jxvf <filename></b><br>
</b><br>
For files with the extension .zip use:</b><br>
Code:   unzip <file name></b><br>
</b><br>
You should now have a new directory with all source files. To confirm that it exists and to get its name, use the ls command again.</b><br>
Code:   ls</b><br>
</b><br>
We now have to go into the new directory, so use the cd command:</b><br>
Code:   cd <directory></b><br>
</b><br>
Here things will be different. Some packages have an INSTALL or README file that contains installation instructions. Use "ls" to determine if the software contains an installation or readme file. If it has one, you can use the "more" command to read it:</b><br>
Code:   more INSTALL</b><br>
</b><br>
-In general, the last 3 levels are as follows:</b><br>
</b><br>
I.    Configure the installation
II.   Compile the software
III. Install the binaries</b><br>
</b><br>
Pre-installation configuration is done by running ./configure:</b><br>
Code:   ./configure</b><br>
</b><br>
</b><br>
2-) Downloading and applying source code from Intellij Idea</b><br>
</b><br>
First, you need to download and install the Intellij Idea tool from this link:</b><br>
https://www.jetbrains.com/idea/download/#section=windows</b><br>
</b><br>
After completing the installation of the Intellij Idea tool, you should download and unzip the latest version of your source code from the "Releases" tab in your Github depot.</b><br>
</b><br>
- Then you should open the Intellij Idea and follow these steps from the Intellij Idea window:</b><br>
</b><br>
I. Choose File -> Open-> Source code -> Select the file with a near Intellij Idea image -> Click "Open".</b><br>
II. After opening our source code, click the "Run" button at the top of the Intellij Idea user interface.</b><br>
