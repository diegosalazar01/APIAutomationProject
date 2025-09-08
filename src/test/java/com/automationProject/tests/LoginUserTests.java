package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.user.LoginUserResponse;
import com.automationProject.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginUserTests extends TestRunner {

    @Test(testName = "Validate user login")
    public void validateUserLogin() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", "DiegoSalazar");
        queryParams.put("password", "123456");

        Response response = RequestBuilder.getRequestWithQueryParams(getBaseUrl(), "/user/login", queryParams, getApiKey());

        LoginUserResponse loginUserResponse = response.as(LoginUserResponse.class);

        assertEquals(loginUserResponse.getCode(), 200, "Status code should be 200");
        assertEquals(loginUserResponse.getType(), "unknown", "The type should match");
        assertTrue(loginUserResponse.getMessage().contains("logged in user session"),"The message should contain 'logged in user session'");
        System.out.println("Login response: " + response.asString());
    }

}
