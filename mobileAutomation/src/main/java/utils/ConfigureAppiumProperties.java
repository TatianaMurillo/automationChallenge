package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigureAppiumProperties {

    public static AndroidDriver getDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","c2adf7bc");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app","");
        capabilities.setCapability("appPackage","com.ba.universalconverter");
        capabilities.setCapability("appActivity","com.ba.universalconverter.MainConverterActivity");
        capabilities.setCapability("platformVersion","10.0");


       return  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

}
