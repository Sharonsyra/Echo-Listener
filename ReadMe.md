## Echo HTTP Listener

Prerequisites:
- JDK 11
- sbt 1.4.x or higher

Once inside the project folder use the following command to run the code:
```
sbt run
```

This project listens to the server on port `9532` on path `"/echo"` and returns the request details as the 
HTTP response in JSON format. The HTTP response contains there Request details:

- The request path
- All headers
- Any Cookies
- The requesting IP
