package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import functionLibrary.CommonFunctions;
import pageObjects.HomePage;

public class ValidateLinksSteps  extends CommonFunctions {

    HomePage homePage = new HomePage(driver);

    @Given("^I'm on a page$")
    public void i_m_on_a_page() throws Exception {
        driver.get("http://www.asos.com");
        takeScreenShot("homePage");
    }

    @Then("^I should click through all the links and gets redirected appropriately$")
    public void i_should_click_through_all_the_links_and_gets_redirected_appropriately() throws Exception {
        homePage.validateLinks();
    }
    
}
