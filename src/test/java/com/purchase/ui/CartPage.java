package com.purchase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
	public static final Target TABLE_PRODUCT = Target.the("Cart products table body")
			.locatedBy("//tbody[@id='tbodyid']");

	public static final Target PLACE_ORDER = Target.the("Place Order button")
			.locatedBy("//button[normalize-space()='Place Order' and (@data-target='#orderModal' or @data-toggle='modal')]");

	public static final Target MODAL_DIALOG = Target.the("Order modal dialog")
			.locatedBy(
					"//div[@id='orderModal']//div[contains(@class,'modal-dialog') or contains(@class,'modal_dialog')]");

	public static final Target INPUT_NAME = Target.the("Name input")
			.locatedBy("//div[@id='orderModal']//input[@id='name']");

	public static final Target INPUT_CITY = Target.the("City input")
			.locatedBy("//div[@id='orderModal']//input[@id='city']");

	public static final Target INPUT_COUNTRY = Target.the("Country input")
			.locatedBy("//div[@id='orderModal']//input[@id='country']");

	public static final Target INPUT_CREDIT_CARD = Target.the("Credit card input")
			.locatedBy("//div[@id='orderModal']//input[@id='card']");

	public static final Target INPUT_MONTH = Target.the("Month input")
			.locatedBy("//div[@id='orderModal']//input[@id='month']");

	public static final Target INPUT_YEAR = Target.the("Year input")
			.locatedBy("//div[@id='orderModal']//input[@id='year']");

	public static final Target CLOSE_BUTTON = Target.the("Close button")
			.locatedBy("//div[@id='orderModal']//button[normalize-space()='Close']");

	public static final Target PURCHASE_BUTTON = Target.the("Purchase button")
			.locatedBy(
					"//div[@id='orderModal']//div[contains(@class,'modal-dialog') or contains(@class,'modal_dialog')]//button[normalize-space()='Purchase']");

	public static final Target SWEET_ALERT = Target.the("Sweet alert dialog")
			.locatedBy("//div[contains(concat(' ', normalize-space(@class), ' '), ' sweet-alert ')]");

	public static final Target SWEET_ALERT_TITLE = Target.the("Sweet alert title")
			.locatedBy(
					"//div[contains(concat(' ', normalize-space(@class), ' '), ' sweet-alert ')]//h2");

	public static final Target SWEET_ALERT_DETAILS = Target.the("Sweet alert details")
			.locatedBy(
					"//div[contains(concat(' ', normalize-space(@class), ' '), ' sweet-alert ')]//p");

	public static final Target SWEET_ALERT_OK = Target.the("Sweet alert OK button")
			.locatedBy("//div[contains(concat(' ', normalize-space(@class), ' '), ' sweet-alert ')]//button[normalize-space()='OK']");
}
