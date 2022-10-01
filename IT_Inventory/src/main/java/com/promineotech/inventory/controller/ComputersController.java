package com.promineotech.inventory.controller;

 import java.util.Date;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.inventory.entity.Computers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

   @RequestMapping("/computers")
   @OpenAPIDefinition(info = @Info(title = "IT Computers"), servers = {
       @Server(url = "http://localhost:8080", description = "Local server.")})
   public interface ComputersController {
     
     @Operation(
         summary = "Returns a Computer", 
         description = "Returns a Computer given an optional make, model, and expiration", 
         responses = {
             @ApiResponse(
                 responseCode = "200", 
                 description = "A Computer is returned", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Computers.class))),
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
                 name = "compId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computer's ID"),
         }
             
      )
     
     @GetMapping
     @ResponseStatus(code = HttpStatus.OK)
     Optional<Computers> fetchComputers(
         @RequestParam(required = false) 
           Long compId);
         
     @Operation(
         summary = " Creates Computers", 
         description = "Creates a list of Computers given an optional make, model, and expiration", 
         responses = {
             @ApiResponse(
                 responseCode = "201", 
                 description = "A Computer is created", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Computers.class))),
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
                 name = "compId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computers ID"),
             @Parameter(
                 name = "userId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "User ID"),
             @Parameter(
                 name = "serviceTag", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Service Tag of computer(i.e., '583JK13')"),
             @Parameter(
                 name = "make", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Name of equipment Manufacturer (i.e., 'Dell')"),
             @Parameter(
                 name = "model", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Name of equipment Model (i.e., 'Latitude 5411')"),
             @Parameter(
                 name = "expiration", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computers expiration date (i.e., '09-20-2020')"),
                  }
      )
     
     @PostMapping
     @ResponseStatus(code = HttpStatus.CREATED)
     Optional<Computers> createComputers(
         @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date expiration, 
         @RequestParam Long compId,
         @RequestParam Long userId,
         @RequestParam String serviceTag,
         @RequestParam String make, 
         @RequestParam String model);
   
     @Operation(
         summary = " Updates a Computers", 
         description = "Updates a list of Computers given an optional make, model, and expiration", 
         responses = {
             @ApiResponse(
                 responseCode = "201", 
                 description = "A Computer is updated", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Computers.class))),
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
                 name = "compId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computers ID"),
             @Parameter(
                 name = "userId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "User ID"),
             @Parameter(
                 name = "serviceTag", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Service Tag of computer(i.e., '583JK13')"),
             @Parameter(
                 name = "make", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Name of equipment Manufacturer (i.e., 'Dell')"),
             @Parameter(
                 name = "model", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Name of equipment Model (i.e., 'Latitude 5411')"),
             @Parameter(
                 name = "expiration", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computers expiration date (i.e., '09-20-2020')"),
                  }
      )
     
     @PutMapping
     @ResponseStatus(code = HttpStatus.OK)
     Optional<Computers> updateComputers(
         @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")  Date expiration, 
         @RequestParam Long compId,
         @RequestParam Long userId,
         @RequestParam String serviceTag,
         @RequestParam String make, 
         @RequestParam String model);

     
     @Operation(
         summary = " Deletes a Computer", 
         description = "Deletes a list of Computers", 
         responses = {
             @ApiResponse(
                 responseCode = "200", 
                 description = "A Computers is deleted", 
                 content = @Content(
                     mediaType = "application/json", 
                     schema = @Schema(implementation = Computers.class))),
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
                 name = "compId", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "Computers ID"),
             
                  }
      )
     
     @DeleteMapping
     @ResponseStatus(code = HttpStatus.OK)
     Optional<Computers> deleteComputers(
         @RequestParam(required = false) 
         Long compId);

   

    

 }
   



