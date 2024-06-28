package co.com.apirest.automation.tasks.put;

import co.com.apirest.automation.interactions.PutRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
public class ConsumeServicePut {


    public Performable apiPut(String baseUrl, String bodyRequest, String request, String typeContent) {
        return Task.where("{0} call the service at execute PUT",
                PutRequest.params(baseUrl, bodyRequest, request, typeContent));
    }
}
