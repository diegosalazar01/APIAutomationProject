package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.user.CreateUserRequest;
import com.automationProject.model.user.CreateUserResponse;
import com.automationProject.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateUserTests extends TestRunner {

    @Test(testName = "Validate user creation")
    public void validateUserCreation() {

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .id(1)
                .userName("DiegoSalazar")
                .firstName("Diego")
                .lastName("Salazar")
                .email("diego@gmail.com")
                .password("123456")
                .phone("1231234565")
                .userStatus(0)
                .build();
        Response response = RequestBuilder.postRequest(getBaseUrl(), "/user", createUserRequest, getApiKey());
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
        assertEquals(createUserResponse.getCode(), 200, "The id should be greater than 0");
        assertEquals(createUserResponse.getType(), "unknown", "The username should match");
        assertEquals(createUserResponse.getMessage(), "1");

    }
}
