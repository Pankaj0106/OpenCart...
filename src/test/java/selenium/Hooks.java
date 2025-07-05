// selenium/Hooks.java
package selenium;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before
    public void setup() {
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
