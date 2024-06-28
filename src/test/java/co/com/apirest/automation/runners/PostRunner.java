package co.com.apirest.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/post.feature",
        glue = "co.com.apirest.automation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Successful"
)
public class PostRunner {

}
