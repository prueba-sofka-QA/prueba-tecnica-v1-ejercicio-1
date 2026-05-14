package com.purchase.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class PurchaseStepDefinitions {

    @Given("the customer is browsing the product catalog on the home page")
    public void browseCatalogOnHome() {
        // Implementation here
    }

    @When("the customer navigates to the first product")
    public void openFirstProduct() {
        // Implementation here
    }

    @And("the customer sees the first product with")
    public void shouldSeeFirstProductWith(DataTable dataTable) {
        // Implementation here
    }

    @And("the customer adds the first product to the cart")
    public void addFirstProductToCart() {
        // Implementation here
    }

    @And("the customer navigates to the home page")
    public void goHome() {
        // Implementation here
    }

    @When("the customer navigates to the second product in the catalog")
    public void openSecondProduct() {
        // Implementation here
    }

    @And("the customer sees the second product with")
    public void shouldSeeSecondProductWith(DataTable dataTable) {
        // Implementation here
    }

    @And("the customer adds the second product to the cart")
    public void addSecondProductToCart() {
        // Implementation here
    }

    @And("the customer navigates to the shopping cart")
    public void openCart() {
        // Implementation here
    }

    @And("the customer reviews the order")
    public void reviewOrder() {
        // Implementation here
    }

    @When("the customer proceeds to place the Cart")
    public void placeOrder() {
        // Implementation here
    }

    @And("the customer completes the purchase form with")
    public void fillPurchaseFormWith(DataTable dataTable) {
        // Implementation here
    }

    @And("the customer confirms the purchase")
    public void confirmPurchase() {
        // Implementation here
    }

    @Then("the purchase should be confirmed successfully")
    public void shouldSeePurchaseConfirmed() {
        // Implementation here
    }

    @And("the confirmation should display the purchase details")
    public void shouldSeePurchaseDetails(DataTable dataTable) {
        // Implementation here
    }
}