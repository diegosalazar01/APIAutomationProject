# 🐶 PerfDog API Automation with RestAssured

## 📌 Overview
This project automates API testing for the **PerfDog PetStore** using [RestAssured](https://rest-assured.io/).  
The tests validate key functionalities of the PetStore API as described in the technical test assignment.  

API Reference: [Swagger Petstore](https://petstore.swagger.io)  

---

## 🎯 User Story
As a user, I want to:
- Create an account.  
- Log in and view available pets.  
- Get details of a specific pet.  
- Place an order for a pet.  
- Log out of the application.  

So I can prepare everything and speed up my purchase.  

---

## ✅ Functionalities Tested
1. **Create User** – Validates user creation (`/user`).  
2. **Login User** – Validates login of a newly created user (`/user/login`).  
3. **List Available Pets** – Retrieves all pets with status `available` (`/pet/findByStatus`).  
4. **Get Pet by ID** – Retrieves details of a specific pet (`/pet/{petId}`).  
5. **Create Order** – Places an order for a pet (`/store/order`).  
6. **Logout User** – Validates user logout (`/user/logout`).  

---

## 🛠️ Tech Stack
- **Java 8+**  
- **Maven** – Dependency Management  
- **RestAssured** – API Testing  
- **TestNG** – Test Runner & Assertions  
- **Lombok** – Boilerplate code reduction  
- **Jackson** – JSON serialization/deserialization  

---

## 📂 Project Structure
```
src
 └── test
     ├── java
     │   ├── com.automationProject.config
     │   │   └── TestRunner.java
     │   ├── com.automationProject.model
     │   │   ├── category/Category.java
     │   │   ├── order/{CreateOrderRequest, CreateOrderResponse, Order}.java
     │   │   ├── pet/{Pet, AvailablePetRequest, AvailablePetResponse, GetPetByIdRequest}.java
     │   │   ├── tag/Tag.java
     │   │   └── user/{CreateUserRequest, CreateUserResponse, LoginUserRequest, LoginUserResponse, LogoutUserResponse, User}.java
     │   ├── com.automationProject.request
     │   │   └── RequestBuilder.java
     │   └── com.automationProject.tests
     │       ├── CreateUserTests.java
     │       ├── LoginUserTests.java
     │       ├── AvailablePetTests.java
     │       ├── GetPetByIDTests.java
     │       ├── CreateOrderTests.java
     │       └── LogoutUserTests.java
     └── resources
         ├── config.properties
         └── suite.xml
```

---

## ▶️ Running the Tests

### From IntelliJ
- Right-click on `suite.xml` → **Run 'suite.xml'**  

### From Maven
```bash
mvn clean test
```

---

## 🧪 Example Test (Create User)
```java
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

    assertEquals(response.getStatusCode(), 200);
    assertEquals(createUserResponse.getCode(), 200);
    assertEquals(createUserResponse.getMessage(), "1");
}
```

---

## 📊 Test Suite
The `suite.xml` defines the TestNG suite to run all API tests:
```xml
<suite name="TestsSuite">
    <test name="CreateUserTests">
        <classes>
            <class name="com.automationProject.tests.CreateUserTests"/>
        </classes>
    </test>
    <test name="LoginUserTests">
        <classes>
            <class name="com.automationProject.tests.LoginUserTests"/>
        </classes>
    </test>
    <test name="AvailablePetTests">
        <classes>
            <class name="com.automationProject.tests.AvailablePetTests"/>
        </classes>
    </test>
    <test name="GetPetByIDTests">
        <classes>
            <class name="com.automationProject.tests.GetPetByIDTests"/>
        </classes>
    </test>
    <test name="CreateOrderTests">
        <classes>
            <class name="com.automationProject.tests.CreateOrderTests"/>
        </classes>
    </test>
    <test name="LogoutUserTests">
        <classes>
            <class name="com.automationProject.tests.LogoutUserTests"/>
        </classes>
    </test>
</suite>
```

