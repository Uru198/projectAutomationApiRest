package co.com.apirest.automation.interactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;

@Slf4j
public class GetRequest implements Interaction {

    private EnvironmentVariables environmentVariables;
    private static final String MESSAGE_GENERAL = "El servicio se consumio de forma exitosa";
    private String baseUrl;
    private final String request;
    private final String typeContent;

    public GetRequest(String baseUrl, String request, String typeContent) {
        this.baseUrl = baseUrl;
        this.request = request;
        this.typeContent = typeContent;
    }

    @Override
    @Subject("{0} El usuario obtiene urlBase: #baseUrl - segun su ambiente: #typeContent, y consumen el servicio #request")
    public <T extends Actor> void performAs(T actor) {
        String pathBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(baseUrl);
        //Vamos a darle una habilidad al actor quien puede "whoCan" llamar al api "CallAnApi"
        actor.whoCan(CallAnApi.at(pathBaseUrl));
        actor.attemptsTo(
                Get.resource(request)
                        //Esta expresion requestSpecification nos permite mandarle el tipo de contenido o proptocolo
                        .with(requestSpecification -> requestSpecification
                                //accept es el tipo de contenido
                                .accept(typeContent)
                                .relaxedHTTPSValidation())
        );
        log.info(MESSAGE_GENERAL);
        //Aqui le desimos que nos imprima el body
        SerenityRest.lastResponse().body().prettyPrint();
    }

    public static GetRequest params(String baseUrl, String request, String typeContent) {
        return Tasks.instrumented(GetRequest.class, baseUrl, request, typeContent);
    }
}
