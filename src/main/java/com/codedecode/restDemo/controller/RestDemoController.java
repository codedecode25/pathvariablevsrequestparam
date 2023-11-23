package com.codedecode.restDemo.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RestController
public class RestDemoController {
    @GetMapping("/employees/{employeeId}")
    public String getEmployeeDetails(
            @PathVariable Long employeeId,
            @RequestParam(name = "startYear", required = false) Integer startYear,
            @RequestParam(name = "gender", required = false) String gender) {

        // Your business logic goes here
        // For example, you can use the received parameters to fetch employee details from a database

        StringBuilder response = new StringBuilder();
        response.append("Employee ID: ").append(employeeId).append("\n");
        response.append("Start Year: ").append(startYear).append("\n");
        response.append("Gender: ").append(gender).append("\n");

        return response.toString();
    }

    @GetMapping("/users")
    public String getUsersByIds(@RequestParam List<Long> userIds) {
        // Your logic to fetch user information based on the provided user IDs
        return "Retrieved user information for IDs: " + userIds;
    }


    /*@GetMapping("/users/{userId}")
    public String getUserById(@PathVariable String userId,
                              @RequestParam String username,
                              @RequestParam String email) throws UnsupportedEncodingException {
        // URL decode the values received in path variable and query parameters
        String decodedUserId = URLDecoder.decode(userId, StandardCharsets.UTF_8.toString());
        String decodedUsername = URLDecoder.decode(username, StandardCharsets.UTF_8.toString());
        String decodedEmail = URLDecoder.decode(email, StandardCharsets.UTF_8.toString());

        // Your logic to fetch user information based on the decoded values
        return String.format("User ID: %s, Username: %s, Email: %s",
                decodedUserId, decodedUsername, decodedEmail);
    }*/


    @GetMapping("/users/id/{pathVariableName}")
    public String getUserByEncodedName(@PathVariable String pathVariableName,
                                       @RequestParam String reqParamName) throws UnsupportedEncodingException {
        // URL decode the path variable and values received in query parameters


        // Display the decoded values
        StringBuilder response = new StringBuilder();
        response.append("Path Variable Name: ").append(pathVariableName).append("\n");
        response.append("Start Year: ").append(reqParamName).append("\n");
        return response.toString();
    }


    @GetMapping("/employees/optional/{employeeId}")
    public String getEmployeeDetailsOptional(
            @PathVariable(required = false) Optional<Long> employeeId,
            @RequestParam(name = "startYear", required = false) Integer startYear,
            @RequestParam(name = "gender", required = false) String gender) {

        // Your business logic goes here
        // For example, you can use the received parameters to fetch employee details from a database

        StringBuilder response = new StringBuilder();
        response.append("Employee ID: ").append(employeeId).append("\n");
        response.append("Start Year: ").append(startYear).append("\n");
        response.append("Gender: ").append(gender).append("\n");

        return response.toString();
    }



    @GetMapping("/employees/validation/{employeeId}")
    public ResponseEntity<String> getEmployeeDetailsValidations(
            @PathVariable @NotNull @Min(10) Long employeeId,
            @RequestParam(name = "startYear", required = false) @Min(3000) Integer startYear,
            @RequestParam(name = "gender") @NotBlank String gender) {

        // Your business logic goes here
        // For example, you can use the received parameters to fetch employee details from a database

        StringBuilder response = new StringBuilder();
        response.append("Employee ID: ").append(employeeId).append("\n");
        response.append("Start Year: ").append(startYear).append("\n");
        response.append("Gender: ").append(gender).append("\n");

        return ResponseEntity.ok(response.toString());
    }
}
