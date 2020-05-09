# warungpintar

## Prerequisites
1. Install Java version 1.8.x
2. Install Gradle version 5.4.x
3. Install [Postman](https://www.postman.com/) or other API testing tools (i.e curl).

## Run Application
Open folder warungpintar and run following command :
```bash
$ ./gradlew bootRun
```
OR
```bash
$ ./gradlew build

$ java -jar build/libs/simple-api-0.0.1-SNAPSHOT.jar
```



## Testing API send message
Using curl 
```bash
curl --location --request POST 'http://localhost:8080/greet/send' \
--header 'Content-Type: application/json' \
--header 'Content-Type: text/plain' \
--data-raw '{"message":"Hello from curl"}'
```

## Testing API collect message
Using curl
```bash
curl --location --request GET 'http://localhost:8080/greet/collect' \
--header 'Content-Type: application/json'
```

## Testing API display message
1. Open browser firefox / chrome.
2. Insert this address : http://localhost:8080/
3. Click button Connect to listen from websocket.
4. Hit API send message to send message.