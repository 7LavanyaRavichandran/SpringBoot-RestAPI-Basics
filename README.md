# SpringBoot-RestAPI-Basics
Spring Boot Rest API Basics

Tools and Technologies Used
===========================
Technologies:
Spring Boot - 2.7.5
JDK - 1.8 or later
Spring MVC
Spring WEB

IDE:
Spring Tool Suite (STS) or IntelleJ IDEA

Tools:
Postman - Test REST API
Maven - Build Tool

Requirements:
Java and JAva8 is plus
Basic understanding of IntelleJ/STS
Spring Boot Basics.

What you will learn?
In this project you will learn REST aPI Basics- Resources,HTTP methods.

The following features are implemented in this REST API projects :
Learn >>
#1. Spring Boot REST API with GetMapping that returns List of JSON
#2. Spring Boot REST API with @GetMapping that returns java bean as JSON
#3. !****------------ Start of Spring Boot REST API with Path Variable-------------****!
    @PathVariable annotation is used to handle template variables in the request URI mapping
    #3.1- Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say name
    #3.2 - Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say Id
    #3.3- Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say name
#4.Handling more than one @PathVariable parameter using a method parameter of type java.util.Map<String, String>
#5.The below method doesn't Handles only "http:;localhost:8080/ListOfStores/PathvariableWithoutOptional/"
#6.To resolve #5 - Let's try make it Optional Path Variable by using "REQUIRED" and "OPTIONAL" to handle non mandatory path
    #6.1. Using Required to make it optional 
    #6.2. Using OPTIONAL to make it optional - Java 8
    #6.3. Can be handled using  java.util.Map<String, String> also refer #4
!****------------ End of Spring Boot REST API with Path Variable-------------****!
#7. !****------------ Start of Spring Boot REST API with RequestParam-------------****!
    @RequestParam to extract query parameters, form parameters, and even files from the request.
    Like @Pathvariable we have Required,Optional,default, and Map all parameters
    #7.1. @RequestParam with required
    #7.2 @RequestParam with Optional - orElse/orElseget  
    #7.3 @RequestParam with Default
    #7.4 @RequestParam with Map
    #7.5 Single @RequestParam with multiple values
!****------------ End of Spring Boot REST API with RequestParam-------------****!
#8. SPRING BOOT REST API using POSTMAPPING - Create new resource
    @postmapping is used to post the http post request into method handler
    @RequestBody responsible for retrieving HttpRequest body  and convert it into JAva Object for converting it uses Spring provided HTTP Message convertor internally ie,deserialization
    @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
    Note:: status of postmapping is always CREATED - 201
#9. Spring boot REST API that handles HTTP PUT method - Update existing resource
#10. Spring boot with RESTAPI that handles Delete Method
#11. Apring boot with REST API - @ResponseEntity
    @ResponseEntity represents the whole HTTP response: status code, headers, and body
    @ResponseStaus is not required if we use ResponeEntity
  
