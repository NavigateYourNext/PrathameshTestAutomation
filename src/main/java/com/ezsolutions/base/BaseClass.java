package com.ezsolutions.base;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.util.Properties;
    import java.util.concurrent.TimeUnit;

    public class BaseClass {

        public static Properties theProperties;
        public static WebDriver driver;

        public BaseClass() {
            try {
                theProperties = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                theProperties.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static WebDriver loadWebDriver(String browserName){
               if(browserName.equalsIgnoreCase("chrome")){
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }else if(browserName.equalsIgnoreCase("firefox")) {
                   WebDriverManager.firefoxdriver().setup();
                   driver = new FirefoxDriver();
            }else{
                   driver = null;
               }
               driver.get(theProperties.getProperty("baseUrl"));
               driver.manage().window().maximize();
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.manage().deleteAllCookies();
               return driver;
        }

        public void closeBrowser(){
            driver.close();
        }

    }
