package com.promineotech.inventory.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.inventory.entity.Peripherals;
import com.promineotech.inventory.entity.UserData;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

  @RequestMapping("/peripherals")
  @OpenAPIDefinition(info = @Info(title = "IT Peripherals"), servers = {
      @Server(url = "http://localhost:8080", description = "Local server.")})
  public interface PeripheralsController {
    
    @Operation(
        summary = " Returns a Peripheral", 
        description = "Returns a Peripheral given an optional Make and/or Model", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A Peripheral is returned", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Peripherals.class))),
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
                name = "periphId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral ID"),
            
                 }
     )
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Peripherals> fetchPeripherals(
        @RequestParam(required = false) 
        Long PeriphId);
   
    @Operation(
        summary = " Creates a Peripheral", 
        description = "Returns a Peripheral", 
        responses = {
            @ApiResponse(
                responseCode = "201", 
                description = "A Peripheral is created", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Peripherals.class))),
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
                name = "periphId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral ID"),
            @Parameter(
                name = "userId", 
                allowEmptyValue = false, 
                required = false, 
                description = "User ID"),
            @Parameter(
                name = "device", 
                allowEmptyValue = false, 
                required = false, 
                description = "device type"),
            @Parameter(
                name = "make", 
                allowEmptyValue = false, 
                required = false, 
                description = "Manufacurer of device (i.e. ('Dell')"),
            @Parameter(
                name = "model", 
                allowEmptyValue = false, 
                required = false, 
                description = "Model of device (i.e. ('WD19')"),
            
                 }
     )
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Optional<Peripherals> createPeripherals(
        @RequestParam(required = false) 
        Long PeriphId,
        Long userId,
        String device,
        String make,
        String model);
    
    @Operation(
        summary = "Updates a Peripheral", 
        description = "Updates a Peripheral", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A Peripheral is updated", 
                content = @Content(
                    mediaType = "application/json", 
                    schema = @Schema(implementation = Peripherals.class))),
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
                name = "periphId", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral ID"),
            @Parameter(
                name = "userId", 
                allowEmptyValue = false, 
                required = false, 
                description = "User ID"),
            @Parameter(
                name = "device", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral device (i.e 'Docking Station')"),
            @Parameter(
                name = "make", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral make (i.e 'Dell')"),
            @Parameter(
                name = "model", 
                allowEmptyValue = false, 
                required = false, 
                description = "Peripheral model (i.e 'WD19')"),

                 }
     )
    
    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Peripherals> updatePeripherals(
        @RequestParam(required = false) 
        Long PeriphId,
        Long userId,
        String device,
        String make,
        String model);

    
    @Operation(
        summary = " Deletes a Peripheral", 
        description = "Deletes a Peripheral", 
        responses = {
            @ApiResponse(
                responseCode = "200", 
                description = "A Peripheral is deleted", 
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
                name = "periphId", 
                allowEmptyValue = false, 
                required = false, 
                description = "ID of Peripherals"),            
             }
     )
    
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    Optional<Peripherals> deletePeripheral(
        @RequestParam(required = false) 
        Long periphId);
        
  }


