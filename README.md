# httpsink

mvn clean install


Listens on port 9123 and logs all request urls of GET and POST along with the body into console
Each request will be wait for 1 seconds by default
The property request.waitsecs can be set in seconds to like 100 minutes to test Sites which just holds the connection and work as a blockhole. 
Used mainly for testing readtimeout on external urls as a test utility

java -jar httpsink-0.0.1-SNAPSHOT.jar --request.waitsecs=600

On Linux servers to capture the requests redirect to files by appending 

nohup java -jar httpsink-0.0.1-SNAPSHOT.jar --request.waitsecs=600 &> httpsink-capture.log &
