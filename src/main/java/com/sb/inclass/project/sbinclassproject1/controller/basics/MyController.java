package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.common.Addressdto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inclass")
public class MyController {
    //Method - GET, POST, PUT, DELETE
    // 1. Path variable http://localhost:8080/hello/{id}
    // 2. Query Param http://localhost:8080/hello?id=1234

    @Value("${sb.inclass.db.name}")
    private String dbIpAddress;

    @GetMapping("/hello-get/{id}")
    public String firstGetMethod(@PathVariable Integer id) {
        System.out.println(dbIpAddress);
        System.out.println(SpringVersion.getVersion());
        System.out.println(SpringBootVersion.getVersion());

        System.out.println("Passing id in the path - "+ id);
        return "This is my first REST Endpoint and get method with path and id is "+ id;
    }

    @GetMapping("/hello-get-1")
    public String firstGetMethod1(@RequestParam Integer id) {

        System.out.println("Passing id in the query - "+ id);
        return "This is my first REST Endpoint and get method with query and id is "+ id;
    }

    @GetMapping("/getAddress")
    public Addressdto get_with_return_type_address() {

        Addressdto address = new Addressdto("a1", "a2", "a3", "s1", "c1", 75063);
      return address;
    }


    @PostMapping("/hello-post-header")
    public String post_with_header(@RequestHeader("Authorization") String authToken) {
        System.out.println(authToken);

        return "This is my first POST Call";
    }

    @PostMapping("/hello-post-body")
    public Addressdto post_with_body(@RequestBody Addressdto address) {
        System.out.println("Inside the post_with_body "+ address);

        System.out.println("Printing zip code" + address.getZip());

        //
        return address;
    }

    @DeleteMapping("/hello-delete-query")
    public String delete_with_queryParam(@RequestParam String id) {
        System.out.println("Deleted the record with id "+ id);

        return "Deleted record";
    }

    @PutMapping("/hello-put-body")
    public String put_with_body(@RequestBody Addressdto address) {
        System.out.println("Put call  "+ address);

        return "Performing update using put call";
    }






}
