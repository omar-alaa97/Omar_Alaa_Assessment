package com.assessment.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties props = new Properties();

    public Base()  {
    try {
        FileInputStream fis = new FileInputStream(new File("src/main/java/com/assessment/properties/config.properties"));
        props.load(fis);
    }

    catch (IOException e){
        e.printStackTrace();
    }
    }

    public static void initialization() {
       if(props.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
        }else if(props.getProperty("browser").equalsIgnoreCase("firefox")){
           WebDriverManager.firefoxdriver().setup();
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
}
