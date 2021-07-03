package com.messias.bookstoremanagerv2.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/books")
public class BookController {
    @ApiOperation(value = "Return an example hello World")
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Sucess method return")
    })
    @GetMapping
    public String mensage(){
        return "Hello World";
    }
}
