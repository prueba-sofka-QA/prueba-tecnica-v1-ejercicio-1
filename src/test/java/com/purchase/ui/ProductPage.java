package com.purchase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
	public static final Target PRODUCT_NAME = Target.the("Product name")
			.locatedBy("//h2[@class='name']");

	public static final Target PRODUCT_PRICE = Target.the("Product price")
			.locatedBy("//h3[contains(@class,'price-container')]");

	public static final Target PRODUCT_DESCRIPTION = Target.the("Product description")
			.locatedBy("//div[@id='more-information']");

	public static final Target BUTTON_ADD_TO_CART = Target.the("Add to cart button")
			.locatedBy(
					"//a[contains(@class,'btn') and contains(@class,'btn-success') and contains(@class,'btn-lg') and normalize-space()='Add to cart']");
}
