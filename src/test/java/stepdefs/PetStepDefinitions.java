package stepdefs;


import com.google.gson.Gson;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HttpRequester;
import helpers.Verb;
import model.Pet;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PetStepDefinitions {


    private String EndPoint_GET_BY_ID = "/pet/%s";
    private String Endpoint_Add_New_PET = "/pet";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private Pet pet = new Pet();
    private HttpRequester httpRequester = new HttpRequester();
    private Request theRequest;
    private Response response;
    private Map<String, String> params = new HashMap<>();
    private Pet expectedObject = new Pet();
    private Pet actualObject = new Pet();


    @Given("a pet exists with an id of (.*)")
    public void a_pet_exists_with_id(int id) {
        pet.setId(id);
    }

    @When("a user retrieves the pet by id")
    public void a_user_retrieves_the_pet_by_id() throws Exception {
        String petId = String.valueOf(pet.getId());
        theRequest = httpRequester.request(Verb.GET, String.format(EndPoint_GET_BY_ID, petId), params, null);
        httpRequester.response(theRequest);
    }

    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode) throws Exception {
        assertEquals(httpRequester.statusCode, statusCode);
    }

    @And("^response includes the following$")
    public void response_equals() throws Exception {
        Gson gson = new Gson();
        actualObject = gson.fromJson(httpRequester.responseBody, Pet.class);
        System.out.println(httpRequester.responseBody);

    }

    @And("^the result$")
    public void theResult() throws Exception {
        actualObject.getId();

    }

    @Given("^a user enter pet details$")
    public void aUserEnterPetDetails() {
        Gson gson = new Gson();
        expectedObject = expectedObject.generatePet(true);
        System.out.println(gson.toJson(expectedObject));
    }

    @When("^(.*) web services is triggered$")
    public void updateWebServicesIsTriggered(String verb) throws Exception {
        RequestBody body= RequestBody.create(httpRequester.requestBodybuilder(expectedObject), JSON);
        theRequest=httpRequester.request(Verb.valueOf(verb),Endpoint_Add_New_PET,params,body);
        httpRequester.response(theRequest);

    }

    @Then("^get the pet id and retrive the data$")
    public void getThePetIdAndRetriveTheData() throws Exception {

        String petId = String.valueOf(expectedObject.getId());
        theRequest = httpRequester.request(Verb.GET, String.format(EndPoint_GET_BY_ID, petId), params, null);
        httpRequester.response(theRequest);
    }

    @Then("^compare the Actual with the expected data$")
    public void compareTheActualWithTheExpectedData() {

        Gson gson = new Gson();
        actualObject= gson.fromJson(httpRequester.responseBody,Pet.class);
        assertEquals(httpRequester.responseBody,gson.toJson(expectedObject));

    }
}


