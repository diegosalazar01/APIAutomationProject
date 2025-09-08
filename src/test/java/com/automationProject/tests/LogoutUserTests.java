package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.user.LogoutUserResponse;
import com.automationProject.request.RequestBuilder;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class LogoutUserTests extends TestRunner {

    @Test
    public void testLogoutUser() {

        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/logout");
        LogoutUserResponse logoutUserResponse = response.as(LogoutUserResponse.class);

        assertEquals(logoutUserResponse.getCode(), 200, "The status code doesn't match.");
        assertEquals(logoutUserResponse.getType(), "unknown",  "The type should match.");
        assertEquals(logoutUserResponse.getMessage(), "ok",  "The message should match.");

    }
}
