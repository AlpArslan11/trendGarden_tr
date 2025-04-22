package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver() {

    }



    /*
    Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu
    için yeni bir pencere(driver) açıyor. Eğer driver'a bir değer atanmamışsa yani driver==null ise
    bir kere driver'i çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere
    çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer
    teslerimiz aynı pencere(driver) üzerinde çalışacak
     */

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
//                case "chrome":                        //default icinde chrome old. için bu switch bloguna gerek yok.
//                    driver = new ChromeDriver();      // aynı zamanda chromeda calisması icin conf. propertiese browser yazmamıza gerek yok
//                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                default:
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a değer atanmışsa kapat
            driver.close();
            driver = null; // Kapandıktan sonra sonraki açmaları garanti altına almak için driver'i tekrar null yaptık
        }
    }

    public static void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }
}