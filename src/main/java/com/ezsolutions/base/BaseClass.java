package com.ezsolutions.base;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.firefox.FirefoxBinary;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.firefox.FirefoxOptions;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.util.Properties;
    import java.util.concurrent.TimeUnit;

    public class BaseClass {

        public static Properties theProperties;
        public static WebDriver driver;
        private static Logger logger = LogManager.getLogger(BaseClass.class);

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
                    if(theProperties.getProperty("isHidden").equalsIgnoreCase("true")){
                        ChromeOptions theChromeOptions = new ChromeOptions();
                        theChromeOptions.addArguments("--headless");
                        theChromeOptions.addArguments("window-size=1400,800");
                        driver = new ChromeDriver(theChromeOptions);
                        logger.warn("Chrome has been loaded with Headless options");
                    }else {
                        driver = new ChromeDriver();
                        logger.info("Chrome has been loaded without Headless options");
                    }
                }else if(browserName.equalsIgnoreCase("firefox")) {
                   WebDriverManager.firefoxdriver().setup();
                   if(theProperties.getProperty("isHidden").equalsIgnoreCase("true")){
                       FirefoxBinary firefoxBinary = new FirefoxBinary();
                       FirefoxOptions options = new FirefoxOptions();
                       options.setBinary(firefoxBinary);
                       options.setHeadless(true);
                       driver = new FirefoxDriver(options);
                       logger.warn("Firefox has been loaded with Headless options");
                   }else {
                       driver = new FirefoxDriver();
                       logger.info("Firefox has been loaded without Headless options");
                   }
            }else{
                   driver = null;
               }
               driver.get(theProperties.getProperty("baseUrl"));
               logger.info("Driver navigated to: "+theProperties.getProperty("baseUrl"));
               driver.manage().window().maximize();
               logger.info("Window maximised");
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               driver.manage().deleteAllCookies();
               logger.info("Cookies deleted");
               return driver;
        }

        public void closeBrowser(){
            driver.close();
            logger.info("Driver closed successfully");
        }

    }
