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
import com.promineotech.inventory.entity.UserData;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

    @RequestMapping("/userData")
    @OpenAPIDefinition(info = @Info(title = "User Data"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})
    public interface UserDataController {
      
      @Operation(
          summary = " Returns a Users", 
          description = "Returns a list of Users", 
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A Users is returned", 
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
                  name = "userId", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "user ID")
               }
       )
      @GetMapping
      @ResponseStatus(code = HttpStatus.OK)
      Optional<UserData> fetchUserData(
          @RequestParam(required = false) 
            Long userId);
          
      @Operation(
          summary = " Creates a User", 
          description = "Creates a User", 
          responses = {
              @ApiResponse(
                  responseCode = "201", 
                  description = "A User is created", 
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
                  name = "userId", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "ID of user"),
              @Parameter(
                  name = "firstName", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "First name of user (i.e. 'Shawntel')"),
              @Parameter(
                  name = "lastName", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "Last name of user (i.e. 'Gallegos')"),
              @Parameter(
                  name = "location", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "location of user (i.e. 'Los Angeles')")          
              
               }
       )
      
      @PostMapping
      @ResponseStatus(code = HttpStatus.CREATED)
      Optional<UserData> createUserData(
          @RequestParam(required = false) 
            Long userId,
            String firstName,
            String lastName,
            String location);
      
      @Operation(
          summary = " Updates a User", 
          description = "Updates a User", 
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A User is updated", 
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
                  name = "userId", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "ID of user"),
              @Parameter(
                  name = "firstName", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "First name of user (i.e. 'Shawntel')"),
              @Parameter(
                  name = "lastName", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "Last name of user (i.e. 'Gallegos')"),
              @Parameter(
                  name = "location", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "location of user (i.e. 'Los Angeles')") 
              
               }
       )
      
      @PutMapping
      @ResponseStatus(code = HttpStatus.OK)
      Optional<UserData> updateUserData(
          @RequestParam(required = false) 
          Long userId,
          String firstName,
          String lastName,
          String location);

      @Operation(
          summary = " Deletes a User", 
          description = "Deletes a User", 
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A User is deleted", 
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
                  name = "userId", 
                  allowEmptyValue = false, 
                  required = false, 
                  description = "ID of user"),
               }
       )
      
      @DeleteMapping
      @ResponseStatus(code = HttpStatus.OK)
      Optional<UserData> deleteUserData(
          @RequestParam(required = false) 
          Long userId);
  }

