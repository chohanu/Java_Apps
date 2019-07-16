---


---

<p>**NOTE:**This file contains information about the three Java Applications found in the repository.</p>
<p><strong>Java Grep Application</strong></p>
<p><strong>Prerequisites</strong></p>
<p>Libraries required:<br>
1)PrintWriter<br>
2)FileWriter<br>
3)BufferedWriter</p>
<p><strong>Architecture</strong></p>
<p>This application searches for a java regex pattern and outputs the results to a file.This program has an interface,JavaGrep,that provides an abtraction of the methods and a class called JavaGrepImp that calls the “process” method.</p>
<p><strong>Implementation</strong></p>
<p>The program takes three arguments as program inputs and scans all the desired directories and subfolders recursively until the file path is found.<br>
The file path is then stored to a list and the file contents are read and stored to a list of string.</p>
<p>Once, all the lines of the file have been stored to a list of string,the text in the String list is compared to the regex pattern and the result is stored to an output file.</p>
<p><strong>Usage</strong><br>
How To Use: JavaGrepImp regex rootPath outFile<br>
Example : JavaGrepImp .<em>data.</em> home/centos/dev /tmp/grep.out</p>
<p><strong>Java DataBase Connectivity(JDBC) Application</strong></p>
<p><strong>Prerequisite</strong><br>
PostgreSQL</p>
<p>This application builts a postgreSQL database that implements CRUD(Create,Read,Update,Delete) operations using Data Object Access(DAO) pattern.</p>
<p><strong>Architecture</strong></p>
<p><strong>JDBCExecutor</strong> runs the main method and executes the program. It allows the user to perform CRUD operations by receiving user input.</p>
<p><strong>DatabaseConnectionManager</strong> connects to the database server.</p>
<p><strong>CustomerDAO</strong> and <strong>OrderDAO</strong> executes the SQL queries.They contain CRUD operation methods.</p>
<p><strong>Improvements</strong><br>
SQL queries can be passed through Command Line Interface in future.</p>
<p><strong>TwitterCLI Application</strong></p>

