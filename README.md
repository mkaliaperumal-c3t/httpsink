# httpsink

This is a test utility for running as a test http server that captures the GET/POST request along with the body and responses either immediately or serving as a blockhole used for testing external URLs used by application to validate the content as well as test read timeouts..

mvn clean install


Listens on port 9123 and logs all request urls of GET and POST along with the body into console
Each request will be wait for 1 seconds by default
The property request.waitsecs can be set in seconds to like 100 minutes to test Sites which just holds the connection and work as a blockhole. 
Used mainly for testing readtimeout on external urls as a test utility

java -jar httpsink-0.0.1-SNAPSHOT.jar --request.waitsecs=600

On Linux servers to capture the requests redirect to files by appending 

nohup java -jar httpsink-0.0.1-SNAPSHOT.jar --request.waitsecs=600 &> httpsink-capture.log &

To Test this Server using curl client and use localhost in url if running from the same server..

curl -X POST -d "dateTime=2021-03-04 09:07:44&cellNum=9600000019&Accuracy=-1&action=1&Latitude=0.0&sessionID=123641606&carrierID=1&msgBody=Initial simulator message&passCode=ksy8KPFgdP&psapID=1&userID=1&Longitude=0.0&" http://localhost:9123/demo/incomingtextpostservlet
