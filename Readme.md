---


---

<p>NOTE:This file contains information about the three Java Applications found in the repository.</p>
<p>1)Java Grep Application</p>
<p>Prerequisites</p>
<p>Libraries required:<br>
1)PrintWriter<br>
2)FileWriter<br>
3)BufferedWriter</p>
<p>Architecture</p>
<p>This application searches for a java regex pattern and outputs the results to a file.This program has an interface,JavaGrep,that provides an abtraction of the methods and a class called JavaGrepImp that calls the “process” method.</p>
<p>Implementation</p>
<p>The program takes three arguments as program inputs and scans all the desired directories and subfolders recursively until the file path is found.<br>
The file path is then stored to a list and the file contents are read and stored to a list of string.</p>
<p>Once, all the lines of the file have been stored to a list of string,the text in the String list is compared to the regex pattern and the result is stored to an output file.</p>
<p>Usage<br>
How To Use: JavaGrepImp regex rootPath outFile<br>
Example : JavaGrepImp .<em>data.</em> home/centos/dev /tmp/grep.out</p>
<p>Java DataBase Connectivity(JDBC) Application</p>
<p>Prerequisite<br>
PostgreSQL</p>
<p>This application builts a postgreSQL database that implements CRUD(Create,Read,Update,Delete) operations using Data Object Access(DAO) pattern.</p>
<p>JDBCExecutor runs the main method and executes the <a href="http://program.It">program.It</a> allows the user to perform CRUD operations by receiving user input.</p>
<p>DatabaseConnectionManager connects to the database server.</p>
<p>CustomerDAO and OrderDAO executes the SQL queries.They contain CRUD operation methods.</p>
<p>Improvements<br>
SQL queries can be passed through Command Line Interface in future.</p>
<p>Architecture</p>
<p>Implementation</p>
<p>Twitter</p>

