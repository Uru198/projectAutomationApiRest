package co.com.apirest.automation.stepdefinitions;

import co.com.apirest.automation.questions.GetQuestion;
import co.com.apirest.automation.tasks.get.Call;
import co.com.apirest.automation.utils.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.apirest.automation.utils.Constants.*;

import static io.restassured.parsing.Parser.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_OK;

public class GetStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("configura la peticion a consumir")
    public void configureRequestToConsume() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service().apiget(
                        //Esta parte de aqui es la que llama de forma dinamica lo de que tenemos en serenity.conf
                        //se llama BASE_URL que es la ruta "restapi.default.baseurl.{env}"
                        //Al final lo que esta en corchetes es esta variable TYPE_ENVIRONMENT que contiene {env}
                        // la variable ENV_QA = {env} esto puede ser o baseurl.qa o baseurl.dev
                        BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        Uri.LIST_USERS.getUri(),
                        String.valueOf(JSON)));
    }

    @Then("valida estado de la peticion")
    public void validateStatusOfTheRequest() {
        theActorInTheSpotlight().should(seeThat(GetQuestion.successful(SC_OK)));
        System.out.println("Response: " + SC_OK);
    }
}
