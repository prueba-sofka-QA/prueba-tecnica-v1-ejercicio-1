package com.purchase.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import com.purchase.hooks.OpenBrowser;
import com.purchase.questions.ConfirmationPurchase;
import com.purchase.ui.CartPage;
import com.purchase.ui.HomePage;
import com.purchase.ui.ProductPage;
import com.purchase.util.Constantes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actors.OnStage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PurchaseStepDefinitions {

    private static final String MEMORY_PRODUCT_1_NAME = "purchase.product1.name";
    private static final String MEMORY_PRODUCT_2_NAME = "purchase.product2.name";
    private static final String MEMORY_CONFIRMATION_TITLE = "purchase.confirmation.title";
    private static final String MEMORY_CONFIRMATION_DETAILS = "purchase.confirmation.details";

    private Actor customer() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("the customer is browsing the product catalog on the home page")
    public void browseCatalogOnHome() {
        OnStage.theActorCalled("Customer");
        customer().attemptsTo(
                OpenBrowser.AbrirUrl(Constantes.DEMOBLAZE_URL),
                WaitUntil.the(HomePage.LINK_PRODUCT_1, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
    }

    @When("the customer navigates to the first product")
    public void openFirstProduct() {
        customer().attemptsTo(
                WaitUntil.the(HomePage.LINK_PRODUCT_1, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(HomePage.LINK_PRODUCT_1),
                WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
        rememberCurrentProductName(MEMORY_PRODUCT_1_NAME);
    }

    @And("the customer sees the first product with")
    public void shouldSeeFirstProductWith(DataTable dataTable) {
		assertCurrentProductAgainst(dataTable);
    }

    @And("the customer adds the first product to the cart")
    public void addFirstProductToCart() {
		addCurrentProductToCart();
    }

    @And("the customer navigates to the home page")
    public void goHome() {
        customer().attemptsTo(
                WaitUntil.the(HomePage.LINK_NAVBAR_BRAND, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(HomePage.LINK_NAVBAR_BRAND),
                WaitUntil.the(HomePage.LINK_PRODUCT_1, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
    }

    @When("the customer navigates to the second product in the catalog")
    public void openSecondProduct() {
        customer().attemptsTo(
                WaitUntil.the(HomePage.LINK_PRODUCT_2, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(HomePage.LINK_PRODUCT_2),
                WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
        rememberCurrentProductName(MEMORY_PRODUCT_2_NAME);
    }

    @And("the customer sees the second product with")
    public void shouldSeeSecondProductWith(DataTable dataTable) {
		assertCurrentProductAgainst(dataTable);
    }

    @And("the customer adds the second product to the cart")
    public void addSecondProductToCart() {
		addCurrentProductToCart();
    }

    @And("the customer navigates to the shopping cart")
    public void openCart() {
        customer().attemptsTo(
                WaitUntil.the(HomePage.LINK_CART, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(HomePage.LINK_CART),
                WaitUntil.the(CartPage.TABLE_PRODUCT, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
    }

    @And("the customer reviews the order")
    public void reviewOrder() {
        String tableText = Text.of(CartPage.TABLE_PRODUCT).answeredBy(customer());
        String product1 = customer().recall(MEMORY_PRODUCT_1_NAME);
        String product2 = customer().recall(MEMORY_PRODUCT_2_NAME);

        customer().attemptsTo(
                Ensure.that(tableText).isNotBlank(),
                Ensure.that(product1).isNotBlank(),
                Ensure.that(product2).isNotBlank(),
                Ensure.that(tableText).contains(product1),
                Ensure.that(tableText).contains(product2)
        );
    }

    @When("the customer proceeds to place the Cart")
    public void placeOrder() {
        customer().attemptsTo(
                WaitUntil.the(CartPage.PLACE_ORDER, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(CartPage.PLACE_ORDER),
                WaitUntil.the(CartPage.MODAL_DIALOG, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
        );
    }

    @And("the customer completes the purchase form with")
    public void fillPurchaseFormWith(DataTable dataTable) {
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        String name = required(form.get("Name"), "Name");
        String country = required(form.get("Country"), "Country");
        String city = required(form.get("City"), "City");
        String creditCard = required(form.get("Credit Card"), "Credit Card");
        String month = required(form.get("Month"), "Month");
        String year = required(form.get("Year"), "Year");

        customer().attemptsTo(
                WaitUntil.the(CartPage.INPUT_NAME, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Enter.theValue(name).into(CartPage.INPUT_NAME),
                Enter.theValue(country).into(CartPage.INPUT_COUNTRY),
                Enter.theValue(city).into(CartPage.INPUT_CITY),
                Enter.theValue(creditCard).into(CartPage.INPUT_CREDIT_CARD),
                Enter.theValue(month).into(CartPage.INPUT_MONTH),
                Enter.theValue(year).into(CartPage.INPUT_YEAR)
        );
    }

    @And("the customer confirms the purchase")
    public void confirmPurchase() {
        customer().attemptsTo(
                WaitUntil.the(CartPage.PURCHASE_BUTTON, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(CartPage.PURCHASE_BUTTON)
        );

        customer().attemptsTo(Ensure.that(ConfirmationPurchase.isDisplayed()).isTrue());

        String title = customer().asksFor(ConfirmationPurchase.title());
        String details = customer().asksFor(ConfirmationPurchase.details());
        customer().remember(MEMORY_CONFIRMATION_TITLE, title);
        customer().remember(MEMORY_CONFIRMATION_DETAILS, details);

        customer().attemptsTo(
                Ensure.that(title).isNotBlank(),
                Ensure.that(details).isNotBlank(),
                Click.on(CartPage.SWEET_ALERT_OK)
        );
    }

    @Then("the purchase should be confirmed successfully")
    public void shouldSeePurchaseConfirmed() {
		String title = customer().recall(MEMORY_CONFIRMATION_TITLE);
		customer().attemptsTo(Ensure.that(title).isNotBlank());
    }

    @And("the confirmation should display the purchase details")
    public void shouldSeePurchaseDetails(DataTable dataTable) {
        Map<String, String> expected = dataTable.asMap(String.class, String.class);
        String details = customer().recall(MEMORY_CONFIRMATION_DETAILS);

        customer().attemptsTo(
                Ensure.that(details).isNotBlank(),
                Ensure.that(details).contains("Id:"),
                Ensure.that(details).contains("Amount:"),
                Ensure.that(details).contains("Card Number:"),
                Ensure.that(details).contains("Name:"),
                Ensure.that(details).contains("Date:")
        );

        assertContainsIfProvided(details, expected.get("Card Number"));
        assertContainsIfProvided(details, expected.get("Name"));
        assertLooksLikePurchaseDetails(details);
    }

    private void addCurrentProductToCart() {
        customer().attemptsTo(
                WaitUntil.the(ProductPage.BUTTON_ADD_TO_CART, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
                Click.on(ProductPage.BUTTON_ADD_TO_CART)
        );
        acceptAlertIfPresent(customer());
    }

    private void rememberCurrentProductName(String memoryKey) {
        String name = safeTrim(Text.of(ProductPage.PRODUCT_NAME).answeredBy(customer()));
        customer().remember(memoryKey, name);
        customer().attemptsTo(Ensure.that(name).isNotBlank());
    }

    private void assertCurrentProductAgainst(DataTable dataTable) {
        Map<String, String> expected = dataTable.asMap(String.class, String.class);
        String actualName = safeTrim(Text.of(ProductPage.PRODUCT_NAME).answeredBy(customer()));
        String actualPrice = safeTrim(Text.of(ProductPage.PRODUCT_PRICE).answeredBy(customer()));
        String actualDescription = safeTrim(Text.of(ProductPage.PRODUCT_DESCRIPTION).answeredBy(customer()));

        customer().attemptsTo(
                Ensure.that(actualName).isNotBlank(),
                Ensure.that(actualPrice).isNotBlank(),
                Ensure.that(actualDescription).isNotBlank()
        );

        assertContainsIfProvided(actualName, expected.get("Name"));
        assertContainsIfProvided(actualPrice, expected.get("Price"));
        assertContainsIfProvided(actualDescription, expected.get("Product Description"));
    }

    private static void acceptAlertIfPresent(Actor actor) {
        var driver = BrowseTheWeb.as(actor).getDriver();
        try {
            new WebDriverWait(driver, Constantes.DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.alertIsPresent())
                    .accept();
        } catch (org.openqa.selenium.TimeoutException ignored) {
            // No alert appeared; continue.
        }
    }

    private static String required(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing required field in DataTable: " + fieldName);
        }
        return value.trim();
    }

    private static String safeTrim(String value) {
        return value == null ? "" : value.trim();
    }

    private static boolean isIgnorable(String expected) {
        if (expected == null) {
            return true;
        }
        String trimmed = expected.trim();
        return trimmed.isEmpty() || trimmed.matches("^<[^>]+>$");
    }

    private void assertContainsIfProvided(String actual, String expected) {
        if (isIgnorable(expected)) {
            return;
        }
        customer().attemptsTo(Ensure.that(actual).contains(expected.trim()));
    }

    private void assertLooksLikePurchaseDetails(String details) {
        customer().attemptsTo(
                Ensure.that(details).matches("(?s).*Id:\\s*\\d+.*"),
                Ensure.that(details).matches("(?s).*Amount:\\s*\\d+\\s*USD.*"),
                Ensure.that(details).matches("(?s).*Date:.*")
        );
    }
}