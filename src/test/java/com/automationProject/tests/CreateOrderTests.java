package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.order.CreateOrderRequest;
import com.automationProject.model.order.CreateOrderResponse;
import com.automationProject.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

import static org.testng.Assert.*;

public class CreateOrderTests extends TestRunner {

    @Test(testName = "Create an order for a pet")
    public void createOrderForPet() {

        CreateOrderRequest createOrderRequest = CreateOrderRequest.builder()
                .id(1)
                .petId(2)
                .quantity(3)
                .shipDate("2025-09-08T20:27:38.578Z")
                .status("placed")
                .complete(false)
                .build();

        Response response = RequestBuilder.postRequest(getBaseUrl(), "/store/order", createOrderRequest, getApiKey());
        CreateOrderResponse createOrderResponse = response.as(CreateOrderResponse.class);

        assertEquals(response.getStatusCode(), 200, "The status code should match");
        assertEquals(createOrderResponse.getId(), 1, "The order id should match");
        assertEquals(createOrderResponse.getPetId(), 2, "The pet id should match");
        assertEquals(createOrderResponse.getQuantity(), 3, "The quantity should match");
        assertEquals(createOrderResponse.getStatus(), "placed", "The status should match");
        assertFalse(createOrderResponse.isComplete(), "The status should match");
    }
}
