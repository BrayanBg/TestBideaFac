package com.test.bideafac.controller;

import com.test.bideafac.model.entity.BookRequest;
import com.test.bideafac.model.service.IBookRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Permite reservar una casa"}, protocols = "http, https", consumes = "application/json", produces = "application/json")
public class BookRequestController {

    @Autowired
    private IBookRequestService bookRequestService;


    // controller de Reservar Casa
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/book")
    @ApiOperation(value = "Crear Entidad Datos Familiares ", notes = "<br>Realiza el registro de datos familiares"
            , response = BookRequest.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Accepted"),
            @ApiResponse(code = 400, message = "required property 'houseId'"),
            @ApiResponse(code = 409, message = "invalid discount"),
    })
    public String book(@RequestBody BookRequest bookRequest) throws Exception {
        return bookRequestService.reservaCasa(bookRequest);
    }


}
