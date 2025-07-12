// selenium/Hooks.java
package selenium;

import java.io.File;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setup() {
        File logFile = new File("target/logs/test-execution.log");
        if (logFile.exists()) {
            logFile.delete();
        }
        BaseClass.initDriver();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(scenario.getName());
        }
        BaseClass.quitDriver();
    }
    
}
