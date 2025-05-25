package com.donesvad.stepdef;

import static com.codeborne.selenide.Selenide.open;

import com.donesvad.page.StorePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreSteps extends BaseSteps {

    private final StorePage storePage = new StorePage();

    @Given("user opens the application")
    public void userOpensTheApp() {
        open(getBaseUrl());
    }

    @When("user searches for {string}")
    public void userSearchesFor(String search) {
        storePage.inputSearchItem(search);
    }

    @When("user selects the {string} destination from the {string} section")
    public void userSelectsTheDestinationFromTheSection(String destination, String section) {
        storePage.selectDestination(destination, section);
    }

    @Then("user is on {string} store page")
    public void userIsOnResultPage(String storeTitle) {
        storePage.verifyStoreTitle(storeTitle);
    }

    @When("user selects to buy the {int} purchasable result")
    public void userSelectsToBuyThePurchasableResult(Integer itemIndex) {
        storePage.selectPurchasableItemByIndex(itemIndex - 1); // Adjusting for zero-based index
    }

}
