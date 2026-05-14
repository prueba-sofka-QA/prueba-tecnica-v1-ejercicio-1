package com.purchase.questions;

import com.purchase.ui.CartPage;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ConfirmationPurchase {
	private ConfirmationPurchase() {
		// Utility class
	}

	public static Question<Boolean> isDisplayed() {
		return actor -> {
			CartPage.SWEET_ALERT.resolveFor(actor).waitUntilVisible();
			return CartPage.SWEET_ALERT.resolveFor(actor).isCurrentlyVisible();
		};
	}

	public static Question<String> title() {
		return actor -> {
			CartPage.SWEET_ALERT.resolveFor(actor).waitUntilVisible();
			return safeTrim(Text.of(CartPage.SWEET_ALERT_TITLE).answeredBy(actor));
		};
	}

	public static Question<String> details() {
		return actor -> {
			CartPage.SWEET_ALERT.resolveFor(actor).waitUntilVisible();
			return safeTrim(Text.of(CartPage.SWEET_ALERT_DETAILS).answeredBy(actor));
		};
	}

	public static Question<String> fullText() {
		return actor -> {
			CartPage.SWEET_ALERT.resolveFor(actor).waitUntilVisible();
			return safeTrim(Text.of(CartPage.SWEET_ALERT).answeredBy(actor));
		};
	}

	private static String safeTrim(String value) {
		return value == null ? "" : value.trim();
	}

}
