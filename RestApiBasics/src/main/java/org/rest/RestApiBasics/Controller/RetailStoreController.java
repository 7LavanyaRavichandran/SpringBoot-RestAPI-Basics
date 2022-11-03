package org.rest.RestApiBasics.Controller;

import org.rest.RestApiBasics.Model.RetailStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.*;

@RestController
//@RequestMapping is used to define base URL's - in our case it is "ListOfStores"
@RequestMapping("ListOfStores")
public class RetailStoreController {

    //#1. Spring Boot REST API with GetMapping that returns List of JSON
    //http://localhost:8080/ListOfStores
    @GetMapping
    public List<RetailStore> getListOfStoreDetails() {
        List<RetailStore> storeList = new ArrayList<>();
        storeList.add(new RetailStore(1, "MnS", "US", 59155667, "mns@mns.com", 100));
        storeList.add(new RetailStore(2, "LifeStyle", "INDIA", 59155667, "lifestyle@ls.com", 200));
        return storeList;
    }

    //#2. Spring Boot REST API with @GetMapping that returns java bean as JSON
    //http://localhost:8080/ListOfStores/StoreDetails
    @GetMapping("/StoreDetails")
    public RetailStore getStoreDetails() {
        return new RetailStore(4, "Otto", "INDIA", 45683, "Otto@ot.com", 300);
    }

    /* #3. !****------------ Start of Spring Boot REST API with Path Variable-------------****!
    @PathVariable annotation is used to handle template variables in the request URI mapping
    #3.1- Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say name
    #3.2 - Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say Id
    #3.3- Simple PathVariable without mapping with pathvariable and method Parameter is same -- Say name */

    //http://localhost:8080/ListOfStores/PathVariable/{StoreId}/{name}/{NoOfWorkers}
    @GetMapping("/PathVariable/{StoreId}/{name}/{NoOfWorkers}")
    public RetailStore getDetailsUsingPathVariable(@PathVariable("StoreId") int Id, @PathVariable String name, @PathVariable(value = "NoOfWorkers") int Workers) {
        // return new RetailStore(Id,name,"Chennai",4857,"max@outlook.com",Workers);
        return new RetailStore(Id, name, getStoreDetails().location, getStoreDetails().mobile, getStoreDetails().email, Workers);
    }

    //#4.Handling more than one @PathVariable parameter using a method parameter of type java.util.Map<String, String>
    //http:localhost:8080/ListOfStores/PathMapVariable/{Id}/{name}
    //@GetMapping("/PathMapVariable/{Id}/{name}")
    @GetMapping(value = {"/PathMapVariable/{Id}/{name}", "/PathMapVariable/{Id}", "/PathMapVariable"})
    public ResponseEntity<String> getDetailsUsingPath_Map_Variable(@PathVariable Map<Integer, String> pathMap) {
        int Id = pathMap.get("Id") != null ? parseInt(pathMap.get("Id")) : 0;
        String name = pathMap.get("name");
        RetailStore retailstore = new RetailStore(Id, name, "INDIA", 45683, "Otto@ot.com", 99);
        if (Id != 0 && name != null) {
            return new ResponseEntity<>(retailstore.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Parameter Missing in URI !!!!", HttpStatus.BAD_REQUEST);
        }
    }

    //#5. The below method doesn't Handles only "http:;localhost:8080/ListOfStores/PathvariableWithoutOptional/"
    //http:localhost:8080/ListOfStores/PathvariableWithoutOptional/{ID}
    @GetMapping(value = {"/PathVariableWithoutOptional", "/PathVariableWithoutOptional/{ID}"})
    public String pathVariableWithoutOptional(@PathVariable("ID") int id) {
        return "ID: " + id + " received";
    }

    /* #6. To resolve #5 - Let's try make it Optional Path Variable by using "REQUIRED" and "OPTIONAL" to handle non mandatory path
    6.1. Using Required to make it optional */
    //http:localhost:8080/ListOfStores/PathVariableWithRequired/{Name}
    @GetMapping(value = {"/PathVariableWithRequired", "/PathVariableWithRequired/{Name}"})
    public String pathVariableWithRequired(@PathVariable(value = "Name", required = false) String name) {
        if (name != null)
            return "NAME: " + name + " received";
        else
            return "Missing path variable - NAME!";
    }

    //6.2. Using OPTIONAL to make it optional - Java 8
    //http:localhost:8080/ListOfStores/PathVariableWithOptional/{Name}
    @GetMapping(value = {"/PathVariableWithOptional", "/PathVariableWithOptional/{Name}"})
    public String pathVariableWithOptional(@PathVariable(value = "Name") Optional<String> name) {
        if (name.isPresent())
            return "NAME: " + name.toString() + " received";
        else
            return "Missing path variable - NAME!";
    }

    //#6.3. Can be handled using  java.util.Map<String, String> also refer #4
    //!****------------ End of Spring Boot REST API with Path Variable-------------****!

    /* #7. !****------------ Start of Spring Boot REST API with RequestParam-------------****!
    @RequestParam to extract query parameters, form parameters, and even files from the request. */
    //http:localhost:8080/ListOfStores/QueryParam?Id=9&name=Max
    @GetMapping("/QueryParam")
    public RetailStore getDetailsRequestParam(@RequestParam(name = "Id") int storeId, @RequestParam(value = "name") String name) {
        return new RetailStore(storeId, name, "Chennai", 82401, "xx.gmail.com", 80);
    }

    //Like @Pathvariable we have Required,Optional,default, and Map all parameters
    //#7.1. @RequestParam with required
    //http://localhost:8080/ListOfStores/QueryParam/Required?Id=8
    @GetMapping("/QueryParam/Required")
    public String getRequestParamRequired(@RequestParam(name = "Id", required = false) String storeId) {
        return "ID:" + storeId;
    }

    //#7.2 @RequestParam with Optional - orElse/orElseget
    //http://localhost:8080/ListOfStores/QueryParam/Optional?name=Elazz
    @GetMapping("/QueryParam/Optional")
    public RetailStore getRequestParamOptional(@RequestParam("name") Optional<String> Name) {
        return new RetailStore(20, Name.orElse("Name not provided"), "Bangalorw", 69131, "elaz@gmail.com", 700);
    }

    //#7.3 @RequestParam with Default
    //http://localhost:8080/ListOfStores/QueryParam/Default?StoreName=Lavan
    @GetMapping("/QueryParam/Default")
    public String getRequestParamDefault(@RequestParam(defaultValue = "I'm Default Store!") String StoreName) {
        return "Name Of the Store: " + StoreName;
    }

    //7.4 @RequestParam with Map
    //http://localhost:8080/ListOfStores/QueryParam/Map?ID=0&Name=Lavanya&Age=22
    @GetMapping("/QueryParam/Map")
    public String getRequestParamMap(@RequestParam Map<String, String> mappingParameters) {
        return "Parameters are " + mappingParameters.entrySet();
    }

    //7.5 Single @RequestParam with multiple values
    //http://localhost:8080/ListOfStores/QueryParam/MultipleValues?Id=111,121,123
    //http://localhost:8080/ListOfStores/QueryParam/MultipleValues?Id=111&Id=121&Id=123
    @GetMapping("/QueryParam/MultipleValues")
    public List getMultipleRequestParam(@RequestParam List<Integer> Id) {
        return Id;
    }
    //!****------------ End of Spring Boot REST API with RequestParam-------------****!

    /* 8. SPRING BOOT REST API using POSTMAPPING - Create new resource
    @postmapping used to post the http post request into method handler
    @RequestBody responsible for retrieving HttpRequest body  and convert it into JAva Object for converting it uses Spring provided HTTP Message convertor internally ie,deserialization
    @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
    Note:: status of postmapping is always CREATED - 201
    http:localhost:8080/ListOfStores/Create */
    @PostMapping(value = "/Create")
    @ResponseStatus(HttpStatus.CREATED)
    public String postDetails(@RequestBody RetailStore retailStore) {
        return retailStore.toString();
    }

    //#9. Spring boot REST API that handles HTTP PUT method - Update existing resource
    //http:localhost:8080/ListOfStores//Update/{ID}
    @PutMapping("/Update/{ID}")
    public RetailStore updateID(@RequestBody RetailStore retailStore, @PathVariable("ID") int storeId) {
        retailStore.setStoreId(storeId);
        System.out.println("ID:" + retailStore.getStoreId());
        System.out.println("NAME:" + retailStore.getName());
        System.out.println("Location:" + retailStore.getLocation());
        return retailStore;
    }

    //#10. Spring boot with RESTAPI that handles Delete Method
    //http:localhost:8080/ListOfStores/Delete/{ID}
    @DeleteMapping("/Delete/{ID}")
    public String deleteID(@PathVariable("ID") int storeId) {
        System.out.println("Deleting ID..." + storeId + "!");
        return "StoreID " + storeId + " deleted successfully!!";
    }

    /* #11. Apring boot with REST API - @ResponseEntity
    @ResponseEntity represents the whole HTTP response: status code, headers, and body
    @ResponseStaus is not required if we use ResponeEntity */
    //http:localhost:8080/ListOfStores/ResponseEntity
    @GetMapping("/ResponseEntity")
    public ResponseEntity<String> getUsingResponseEntity() {
        // return new ResponseEntity<>("ResponseEntity!", HttpStatus.OK);
        // return ResponseEntity.ok().body("ResponseEntity!");
        return ResponseEntity.ok().header("Customized-Header", "Lavanya").body("ResponseEntity!");
    }

}
