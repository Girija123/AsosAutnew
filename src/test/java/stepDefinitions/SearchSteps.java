package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import pageObjects.SearchPage;
import pageObjects.SearchResultsPage;

public class SearchSteps extends CommonFunctions {

    SearchPage searchPage = new SearchPage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    @Given("^I'm on google home page$")
    public void i_m_on_google_home_page() throws Exception {
        driver.get("https://www.google.co.uk");
    }

    @When("^I enter searchTerm \"([^\"]*)\"$")
    public void i_enter_searchTerm(String searchTerm)  {
        searchPage.enterSearchTerm(searchTerm);
    }

    @When("^I click searchButton$")
    public void i_click_searchButton()  {
        searchPage.clickSearchButton();
    }

    @Then("^I should get appropriate search results that contains text \"([^\"]*)\"$")
    public void i_should_get_appropriate_search_results_that_contains_text(String term)  {
        searchResultsPage.validateSearchResults(term);
    }
}
