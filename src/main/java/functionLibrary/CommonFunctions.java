package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser() throws Exception
    {
        String browser = getDataFromProperty("browser");
        String device  = getDataFromProperty("device");
        switch (browser)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
              /*  switch(device)
                {
                    case "iphone7":
                        Dimension dimension = new Dimension(414, 768);
                        driver.manage().window().setSize(dimension);
                    case "s3":
                        Dimension dimension1= new Dimension(367, 768);
                        driver.manage().window().setSize(dimension1);

                   default:
                        Dimension dimension2 = new Dimension(414, 768);
                        driver.manage().window().setSize(dimension2);

                }*/
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

    }


    public void closeBrowser()
    {
        driver.quit();
    }

    public String getDataFromProperty(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(FilePaths.configFilePath);
        Properties properties =  new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public void implicitWait(int waittime)
    {
        driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
    }

    public void explicitwait(WebElement element, int maxTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, maxTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public ResultSet createDBCon(String sqlQuery) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:8012/asosaut", "root", "");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        connection.close();
        return rs;
    }

    public void takeScreenShot(String screenName) throws Exception
    {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\rohin.ramadass\\IdeaProjects\\AsosAut\\src\\main\\resources\\screenShots\\"+screenName+".jpg");
        FileUtils.copyFile(srcFile, destFile);
    }


}
