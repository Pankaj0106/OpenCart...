package Cucumber;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="selenium.StepDefinition",
monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
    @Override
    @DataProvider(parallel = true) // ✅ This enables parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }

}