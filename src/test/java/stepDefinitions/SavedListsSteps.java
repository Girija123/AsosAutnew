package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import pageObjects.Header;
import pageObjects.SavedListsPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SavedListsSteps extends CommonFunctions {

    Header header = new Header(driver);
    SavedListsPage savedListsPage = new SavedListsPage(driver);

    @Given("^I'm on homepage$")
    public void i_m_on_homepage() throws Exception  {
        driver.get(getDataFromProperty("url"));

    }

    @When("^I click savedList Icon$")
    public void i_click_savedList_Icon()  {
        implicitWait(2);
        header.clickSavedLists();
    }

    @Then("^I should redirected to the saved lists page with text as \"([^\"]*)\"$")
    public void i_should_redirected_to_the_saved_lists_page_with_text_as(String expectedText) throws Exception {
        explicitwait(savedListsPage.noSavedItemsText,3);

      ResultSet rs = createDBCon("select noproducttext from savedlists");
      while(rs.next())
      {
          savedListsPage.validateNoSavedItems(rs.getString(1));
      }

    }
}
