RestPrinters
============

This is a standalone executable tomcat server that expose all your local printer over a simple RESTful API.


Usage
============

build and download dependancies
mvn clean install 


assemble a executable jar with all dependancies
mvn assembly:assembly

start the server
java -jar distribution-print-server-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Api
============

http://[machineName]:8080/printers

type: GET
accept: text / html / xml / json
description: retrieve a list of all printers


http://[machineName]:8080/{printerName}/print

type: POST
content-type : application/octet-stream
description: print a document  on a specific printer


