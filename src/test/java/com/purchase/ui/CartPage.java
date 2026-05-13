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

	public static final Target PURCHASE_BUTTON = Target.the("Purchase button")
			.locatedBy(
					"//div[@id='orderModal']//div[contains(@class,'modal-dialog') or contains(@class,'modal_dialog')]//button[normalize-space()='Purchase']");

	public static final Target SWEET_ALERT = Target.the("Sweet alert dialog")
			.locatedBy("//div[contains(concat(' ', normalize-space(@class), ' '), ' sweet-alert ')]");
}
