package com.zerobank.step_defenitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

        @Before
        public void setUp(){
           Driver.getDriver().manage().window().maximize();
           Driver.getDriver().get(ConfigurationReader.get("url"));
           Driver.getDriver().manage().timeouts().implicitlyWait(2 , TimeUnit.SECONDS);

        }

        @After
        public void tearDown(Scenario scenario)
        {
            if(scenario.isFailed())
            {
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"image.png");

            }

            Driver.closeDriver();

        }

    }
