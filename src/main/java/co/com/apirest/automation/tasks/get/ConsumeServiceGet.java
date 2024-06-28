package co.com.apirest.automation.tasks.get;

import co.com.apirest.automation.interactions.GetRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
public class ConsumeServiceGet {

    //Aqui loque se quiere es encapsular el GetRequest
    //TAmbien los parametros deben ser dinamicos
    //Esta tarea tiene un where donde contendra la llamada de un servicio tipo get
    //El where contiene ciertos parametro el 1. titulo 2. se llama el servicio "GetRequest"
    //y se llama los demas parametros
    //Aun asi es complicado llamarlo por eso se crea otra tarea llamada CAll
    public Performable apiget(String baseUrl, String request, String typeContent) {
        return Task.where("{0} call the service at execute GET",
                GetRequest.params(baseUrl, request, typeContent)
        );
    }
}
