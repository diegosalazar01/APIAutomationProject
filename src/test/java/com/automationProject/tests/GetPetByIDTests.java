package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.pet.Pet;
import com.automationProject.request.RequestBuilder;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class GetPetByIDTests extends TestRunner {

    @Test(testName = "Get data from a specific pet")
    public void getPetByID() {
        int petId = 2;

        Response response = RequestBuilder.getRequestWithQueryParams(getBaseUrl(), "/pet/{petId}","petId", petId, getApiKey());
        Pet pet = response.as(Pet.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match the expected status code.");
        assertEquals(pet.getId(), 2, "The pet ID doesn't match the expected pet ID.");
    }
}
