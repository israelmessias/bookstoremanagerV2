package com.messias.bookstoremanagerv2.author.controller;

import com.messias.bookstoremanagerv2.author.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/*Criado docuemntação para metodo post*/
@Api("Authors Management")
public interface AuthorControllerDocs {
    @ApiOperation(value = "Author creation operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Sucess author creation"),
        @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or author alereafy registered on system")
    })
    public AuthorDTO create(AuthorDTO authorDTO);
}
