package com.purchase.tasks;

import com.purchase.hooks.OpenBrowser;
import com.purchase.questions.ConfirmationPurchase;
import com.purchase.ui.CartPage;
import com.purchase.ui.HomePage;
import com.purchase.ui.ProductPage;
import com.purchase.util.Constantes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MakePurchase implements Task {
	private final PurchaseFormData purchaseFormData;

	public MakePurchase(PurchaseFormData purchaseFormData) {
		this.purchaseFormData = purchaseFormData;
	}

	public static Performable with(PurchaseFormData purchaseFormData) {
		return Tasks.instrumented(MakePurchase.class, purchaseFormData);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(OpenBrowser.AbrirUrl(Constantes.DEMOBLAZE_URL));

		actor.attemptsTo(WaitUntil.the(HomePage.LINK_PRODUCT_1, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds());

		ProductSnapshot firstProduct = openProductAndCaptureInfo(actor, HomePage.LINK_PRODUCT_1, "firstProduct");
		addCurrentProductToCart(actor);
		goToHome(actor);

		ProductSnapshot secondProduct = openProductAndCaptureInfo(actor, HomePage.LINK_PRODUCT_2, "secondProduct");
		addCurrentProductToCart(actor);
		goToHome(actor);

		goToCart(actor);
		verifyProductsInCart(actor, firstProduct, secondProduct);

		openPlaceOrderModal(actor);
		fillPurchaseForm(actor, purchaseFormData);
		confirmPurchaseAndCaptureConfirmation(actor);
		closeOrderModalIfPresent(actor);
	}

	private static ProductSnapshot openProductAndCaptureInfo(Actor actor, Target productLink, String memoryKeyPrefix) {
		actor.attemptsTo(
				WaitUntil.the(productLink, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(productLink),
				WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
		);

		String name = Text.of(ProductPage.PRODUCT_NAME).answeredBy(actor).trim();
		String price = Text.of(ProductPage.PRODUCT_PRICE).answeredBy(actor).trim();
		String description = Text.of(ProductPage.PRODUCT_DESCRIPTION).answeredBy(actor).trim();

		actor.remember(memoryKeyPrefix + ".name", name);
		actor.remember(memoryKeyPrefix + ".price", price);
		actor.remember(memoryKeyPrefix + ".description", description);

		actor.attemptsTo(
				Ensure.that(name).isNotBlank(),
				Ensure.that(price).isNotBlank(),
				Ensure.that(description).isNotBlank()
		);

		return new ProductSnapshot(name, price, description);
	}

	private static void addCurrentProductToCart(Actor actor) {
		actor.attemptsTo(
				WaitUntil.the(ProductPage.BUTTON_ADD_TO_CART, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(ProductPage.BUTTON_ADD_TO_CART)
		);
		acceptAlertIfPresent(actor);
	}

	private static void goToHome(Actor actor) {
		actor.attemptsTo(
				WaitUntil.the(HomePage.LINK_NAVBAR_BRAND, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(HomePage.LINK_NAVBAR_BRAND),
				WaitUntil.the(HomePage.LINK_PRODUCT_1, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
		);
	}

	private static void goToCart(Actor actor) {
		actor.attemptsTo(
				WaitUntil.the(HomePage.LINK_CART, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(HomePage.LINK_CART),
				WaitUntil.the(CartPage.TABLE_PRODUCT, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
		);
	}

	private static void verifyProductsInCart(Actor actor, ProductSnapshot first, ProductSnapshot second) {
		actor.attemptsTo(WaitUntil.the(CartPage.TABLE_PRODUCT, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds());

		String cartText = Text.of(CartPage.TABLE_PRODUCT).answeredBy(actor);
		actor.attemptsTo(
				Ensure.that(cartText).contains(first.name()),
				Ensure.that(cartText).contains(second.name())
		);
	}

	private static void openPlaceOrderModal(Actor actor) {
		actor.attemptsTo(
				WaitUntil.the(CartPage.PLACE_ORDER, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(CartPage.PLACE_ORDER),
				WaitUntil.the(CartPage.MODAL_DIALOG, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds()
		);
	}

	private static void fillPurchaseForm(Actor actor, PurchaseFormData data) {
		actor.attemptsTo(
				WaitUntil.the(CartPage.INPUT_NAME, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Enter.theValue(data.name()).into(CartPage.INPUT_NAME),
				Enter.theValue(data.city()).into(CartPage.INPUT_CITY),
				Enter.theValue(data.creditCard()).into(CartPage.INPUT_CREDIT_CARD),
				Enter.theValue(data.month()).into(CartPage.INPUT_MONTH),
				Enter.theValue(data.year()).into(CartPage.INPUT_YEAR)
		);
	}

	private static void confirmPurchaseAndCaptureConfirmation(Actor actor) {
		actor.attemptsTo(
				WaitUntil.the(CartPage.PURCHASE_BUTTON, isVisible()).forNoMoreThan(Constantes.DEFAULT_TIMEOUT_SECONDS).seconds(),
				Click.on(CartPage.PURCHASE_BUTTON)
		);

		actor.attemptsTo(
				Ensure.that(ConfirmationPurchase.isDisplayed()).isTrue(),
				Ensure.that(ConfirmationPurchase.title()).isNotBlank(),
				Ensure.that(ConfirmationPurchase.details()).isNotBlank()
		);

		String title = actor.asksFor(ConfirmationPurchase.title());
		String details = actor.asksFor(ConfirmationPurchase.details());
		actor.remember("purchase.confirmation.title", title);
		actor.remember("purchase.confirmation.details", details);

		actor.attemptsTo(Click.on(CartPage.SWEET_ALERT_OK));
	}

	private static void closeOrderModalIfPresent(Actor actor) {
		try {
			if (CartPage.CLOSE_BUTTON.resolveFor(actor).isCurrentlyVisible()) {
				actor.attemptsTo(Click.on(CartPage.CLOSE_BUTTON));
			}
		} catch (Exception ignored) {
			// Modal not present/visible; nothing to close.
		}
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

	public record PurchaseFormData(String name, String city, String creditCard, String month, String year) {
		public PurchaseFormData {
			if (isBlank(name) || isBlank(city) || isBlank(creditCard) || isBlank(month) || isBlank(year)) {
				throw new IllegalArgumentException("All purchase form fields must be provided");
			}
		}

		private static boolean isBlank(String value) {
			return value == null || value.trim().isEmpty();
		}
	}

	private record ProductSnapshot(String name, String price, String description) {
	}
}
