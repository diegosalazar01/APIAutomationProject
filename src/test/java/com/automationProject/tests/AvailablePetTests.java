package com.automationProject.tests;

import com.automationProject.config.TestRunner;
import com.automationProject.model.pet.Pet;
import com.automationProject.request.RequestBuilder;
import io.restassured.common.mapper.TypeRef;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class AvailablePetTests extends TestRunner {

    @Test(testName = "Get all pets with Available status")
    public void GetAllPetsWithAvailableStatus(){
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("status", "available");

        Response response = RequestBuilder.getRequestWithQueryParams(getBaseUrl(), "pet/findByStatus", queryParams, getApiKey());
        List<Pet> pets = response.as(new TypeRef<List<Pet>>() {});

        assertEquals(response.getStatusCode(), 200, "Status code not as expected");
        assertFalse(pets.isEmpty(), "The pets list should not be empty");
        for (int i = 0; i < pets.size(); i++) {
            assertEquals(pets.get(i).getStatus(), "available", "the status should match");
        }

    }
}
