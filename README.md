RestPrinters
============

Expose all your local printer over a simple RESTful API (standalone embedded tomcat 7 server).



Usage

build and download dependancies
mvn clean install 


assemble a executable jar with all dependancies
mvn assembly:assembly



Api

http://[machineName]:8080/printers

retrieve a list of all printers

HTTP GET
http://[machineName]:8080/printers


print a document on a specific printer

HTTP POST
http://[machineName]:8080/{printerName}/print