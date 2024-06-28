package co.com.apirest.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.apirest.automation.utils.Constants.STATUS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetQuestion implements Question<Boolean> {

    private int statusOK;

    public GetQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    @Subject("{0} valida el codigo de estado exitoso #statusOK ")
    public Boolean answeredBy(Actor actor) {
        //Aqui se valida el estado de la respuesta que sea exitosa un 200 y se manda por parametro
        //Decimo el actor deberia "should" ver la ultima respuesta "seeThatResponse"
        //Se crea el objeto para que retorne true
        actor.should(seeThatResponse(STATUS, response -> response.statusCode(statusOK)));
        return true;
    }

    public static GetQuestion successful(int statusOK) {
        return new GetQuestion(statusOK);
    }
}
