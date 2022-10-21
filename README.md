# codeTest
[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)

Surburb codeTest [Spring Boot](http://projects.spring.io/spring-boot/)  sample app.

## Requirements

For building and running the application you need:

- [JDK 17.0.2](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.demo` class from your IDE.

For testing the application you need:


- [PostMan](http://www.postman.com)

  ## postman Api..
  
 -save api : curl --location --request POST 'http://localhost:8081/api/v1/save' \
 
             --header 'Content-Type: application/json' \
             
             --data-raw '[
    {
        "surburb_name": [
            "ikeja",
            "itire",
            "ijesha"
        ],
        "post_code": "123"
    },
    {
     "surburb_name": [
            "surulere",
            "itire",
            "ijesha"
        ],
        "post_code": "1234"
    },
    {
     "surburb_name": [
            "lagos",
            "itire",
            "ijesha"
        ],
        "post_code": "1235"
    }
]'

    -Get api :  curl --location --request GET 'http://localhost:8081/api/v1/postCode?postCode=123'
