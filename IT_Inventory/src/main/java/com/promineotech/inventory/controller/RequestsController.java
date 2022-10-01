package com.promineotech.inventory.controller;

import java.util.Date;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.inventory.entity.Requests;
import com.promineotech.inventory.entity.UserData;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

  @Validated
  @RequestMapping("/requests")
  @OpenAPIDefinition(info = @Info(title = "IT Requests"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface RequestsController {
    
    @Operation(
        summary = " Returns an Equipment Request", 
        description = "Returns an Equipment Request from users", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "An Equipment request is returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Requests.class))),
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
                name = "requestId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Request ID"),
             }
     )
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Requests> fetchRequests(
        @RequestParam(required = false) 
        Long requestId); 
        
        
    @Operation(
        summary = " Creates an Equipment Request", 
        description = "Creates an Equipment Request from users", 
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "An Equipment Request is Created", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Requests.class))),
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
                name = "requestId", 
                allowEmptyValue = false, 
                required = false, 
                description = "ID of equipment request"),
            @Parameter(
                name = "userId", 
                allowEmptyValue = false, 
                required = false, 
                description = "User ID"),
            @Parameter(
                name = "typeId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Computer ID"),
            @Parameter(
                name = "quantity", 
                allowEmptyValue = false, 
                required = false, 
                description = "Quantity of equipment needed"),
            @Parameter(
                name = "shipDate", 
                allowEmptyValue = false, 
                required = false, 
                description = "Date of equipment Shipped (i.e. '09-20-2022')"),
            @Parameter(
                name = "receiveDate", 
                allowEmptyValue = false, 
                required = false, 
                description = "Date of equipment received (i.e. '09-20-2022')"),
            @Parameter(
                name = "returnDate", 
                allowEmptyValue = false, 
                required = false, 
                description = "Date of equipment returned (i.e. '09-20-2022')")
            
            
             }
     )
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Optional<Requests> createRequests(
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date shipDate,
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date receiveDate,
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date returnDate,
        @RequestParam Long requestId,
        @RequestParam Long userId,
        @RequestParam Long typeId,
        @RequestParam int quantity);
    
    @Operation(
        summary = " Updates an Equipment Request", 
        description = "Updates an Equipment Request from users", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "An Equipment Request is Updated", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Requests.class))),
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
                    name = "requestId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "ID of equipment request"),
                @Parameter(
                    name = "userId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "User ID"),
                @Parameter(
                    name = "typeId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Computer ID"),
                @Parameter(
                    name = "quantity", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Quantity of equipment needed"),
                @Parameter(
                    name = "shipDate", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Date of equipment Shipped (i.e. '09-20-2022')"),
                @Parameter(
                    name = "receiveDate", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Date of equipment received (i.e. '09-20-2022')"),
                @Parameter(
                    name = "returnDate", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "Date of equipment returned (i.e. '09-20-2022')"),
            
             }
     )
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Requests> updateRequests(
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date shipDate,
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date receiveDate,
        @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date returnDate,
        @RequestParam Long requestId,
        @RequestParam Long userId,
        @RequestParam Long typeId,
        @RequestParam int quantity
        );

    @Operation(
        summary = " Deletes an equipment Request", 
        description = "Deletes a Request", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "An equipment Request is deleted", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = UserData.class))),
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
                    name = "requestId", 
                    allowEmptyValue = false, 
                    required = false, 
                    description = "ID of equipment request"),
             }
     )
    
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Requests> deleteRequests(
        @RequestParam(required = false) 
        Long requestId);
       
}

  