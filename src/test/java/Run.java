import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import functionLibrary.FilePaths;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features=".", tags={"@linksV"}, dryRun = false, plugin="com.cucumber.listener.ExtentCucumberFormatter:target/TSR/tsr.html")
public class Run {

    @AfterClass
    public static void generateTestReport()
    {
        Reporter.loadXMLConfig("C:\\Users\\rohin.ramadass\\IdeaProjects\\AsosAut\\src\\main\\resources\\extent-config.xml");
    }

}
