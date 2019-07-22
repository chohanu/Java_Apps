---


---

<p>**NOTE:**This file contains information about the three Java Applications found in the repository.</p>
<h2 id="twittercli-application">TwitterCLI Application</h2>
<p><strong>Introduction</strong></p>
<p>This application allows you to create, read and delete tweets by using the Twitter Rest API</p>
<p><strong>Architecture</strong></p>
<img src=/assets/Twitter.PNG">
<p><strong>Implementation</strong></p>
<p>TwitterCliApp: Creates components and passes program arguments (user input) to TwitterCliRunner.</p>
<p>TwitterCliRunner: Parses the user input and calls the methods from the TwitterServiceImp class.</p>
<p>TwitterServiceImp: Provides business logic of the application. Validates and handle tweet Objects. Calls the methods from the TwitterRestDao class to pass the filtered data</p>
<p>TwitterRestDao: Constructs URI and passes it to ApacheHttpClient.Also,parses the response entity it gets from ApacheHttpClient.</p>
<p>ApacheHttpClient: Connects to Twitter Rest API and Handles authorization. Sends HTTP requests and gets a response.</p>
<p><strong>Usage</strong></p>
<p>Get a Twitter development account and get access to Keys and Tokens.Make sure they are stored into local machine’s environmental variables.</p>
<p>To Post/Create a Tweet: <code>post "text" latitude:longitude</code></p>
<p>This creates a tweet with a geotag and the specified text and outputs the created tweet object into JSON format.</p>
<p>To show/find a tweet: <code>show id "fields"</code></p>
<p>This finds a tweet by ID and prints the tweet object into JSON format.</p>
<p>To delete a Tweet: <code>delete "ids"</code></p>
<p>This deletes a list of tweets by id</p>
<h2 id="java-grep-application">Java Grep Application</h2>
<p><strong>Introduction</strong></p>
<p>This application searches for a java regex pattern and outputs the results to a file.This program has an interface,JavaGrep,that provides an abtraction of the methods and a class called JavaGrepImp that calls the “process” method.</p>
<p><strong>Implementation</strong></p>
<p>The program takes three arguments as program inputs and scans all the desired directories and subfolders recursively until the file path is found.<br>
The file path is then stored to a list and the file contents are read and stored to a String list.</p>
<p>The text in the String list is then compared to the regex pattern and the result is stored to an output file.</p>
<p>Below is the pseudocode :</p>
<p>matchingLines = []</p>
<p>for file in listFiles(directory)</p>
<p>for line in readLines(file)</p>
<p>if containesPattern(line)</p>
<p>matchingLines.add(line)</p>
<p>writeToFile(matchingLines)</p>
<p><strong>Usage</strong></p>
<p>USAGE: regex directory outFile</p>
<ul>
<li>regex: a string on which search would be performed</li>
<li>rootpath: path of the directory</li>
<li>outFile: path and name of output file where output search result would be stored</li>
</ul>
<p><strong>Improvement</strong></p>
<p>All the lines of a file are stored into a list. Allocating memory for the list can get problematic if the directory contains big files.</p>
<p>Every type of file is being scanned to look for the regex pattern. Specifying the type of files to search for can improve time complexity</p>
<h2 id="java-database-connectivityjdbc-application">Java DataBase Connectivity(JDBC) Application</h2>
<p><strong>Introduction</strong></p>
<p>This application uses JAVA database connectivity to connect to a PostgreSQL database. It uses CRUD(Create,Read,Update,Delete) operations using Data Object Access(DAO) pattern. This application is modelled on a sales business and can create,delete,update information on a customer. It also retrieves order information.</p>
<p><strong>Architecture</strong></p>
<img src="https://github.com/chohanu/Java_Apps/tree/master/assets/JDBC.PNG">
<p>JDBCExecutor: runs the main method and executes the program. It allows the user to perform CRUD operations by receiving user input.</p>
<p>DatabaseConnectionManager: connects to the database server.</p>
<p><em>CustomerDAO</em> and <em>OrderDAO</em> executes the SQL queries.They contain CRUD operation methods.</p>
<p><strong>Improvements</strong><br>
SQL queries can be passed through Command Line Interface in future.</p>

