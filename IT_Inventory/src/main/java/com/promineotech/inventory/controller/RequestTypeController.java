package com.promineotech.inventory.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.inventory.entity.RequestType;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

  @Validated
  @RequestMapping("/requestType")
  @OpenAPIDefinition(info = @Info(title = "IT Request Type"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface RequestTypeController {
    
    @Operation(
        summary = " Returns the Equipment Type", 
        description = "Returns an Equipment Request Type", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "The Equipment Type is returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = RequestType.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "An Inventory component was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An Unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "typeId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Request type ID"),
             }
     )
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<RequestType> fetchRequestType(
        @RequestParam(required = false) 
        Long typeId); 
        
        
    @Operation(
        summary = " Creates an Equipment Type Request", 
        description = "Creates an Equipment Type Request", 
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "The Equipment Type is created", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = RequestType.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "An Inventory component was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An Unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "typeId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Type ID"),
            @Parameter(
                name = "typeName", 
                allowEmptyValue = false, 
                required = false, 
                description = "Type of equipment (i.e 'Cell Phone') "),
                      
            
             }
     )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Optional<RequestType> createRequestType(
        @RequestParam(required = false) 
        Long typeId,
        String typeName);
    
    @Operation(
        summary = " Updates an Equipment Type Request", 
        description = "Updates an Equipment Type Request", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "An Equipment Type Request is Updated", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = RequestType.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "An Inventory component was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An Unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "typeId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Type ID"),
            @Parameter(
                name = "typeName", 
                allowEmptyValue = false, 
                required = false, 
                description = "Type of equipment (i.e 'Cell Phone') "),
           
             }
     )
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<RequestType> updateRequestType(
        @RequestParam(required = false) 
        Long typeId,
        String typeName
        );

    @Operation(
        summary = " Deletes an Equipment Type Request", 
        description = "Deletes a an Equipment Type Request", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "An equipment Type Request is deleted", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = RequestType.class))),
            @ApiResponse(
                responseCode = "400", 
                description = "The request parameters are invalid", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "404", 
                description = "No Inventory was found with the input criteria", 
                content = @Content(mediaType = "application/json")),
            @ApiResponse(
                responseCode = "500", 
                description = "An Unplanned error occurred", 
                content = @Content(mediaType = "application/json"))
        },
        parameters = {
            @Parameter(
                name = "typeId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Type ID"),
                      
            
             }
     )
    
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<RequestType> deleteRequestType(
        @RequestParam(required = false) 
        Long typeId);        
}

  