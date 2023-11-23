/*
package com.codedecode.restDemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RestDemoControllerTest {

    @InjectMocks
    private RestDemoController restDemoController;

    @Test
    public void testGetEmployeeDetails() {
        // Given
        Long employeeId = 1L;
        Integer startYear = 2023;
        String gender = "female";

        // Mocking the behavior of dependencies (in this case, no dependencies to mock)
        // You can use mock() to create a mock object if needed
        // Mocking the behavior of dependencies (in this case, no dependencies to mock)

        // When
        String result = restDemoController.getEmployeeDetails(employeeId, startYear, gender);

        // Then
        String expectedResponse = "Employee ID: " + employeeId + "\n"
                + "Start Year: " + startYear + "\n"
                + "Gender: " + gender + "\n";

        assertEquals(expectedResponse, result);
    }
}
*/
