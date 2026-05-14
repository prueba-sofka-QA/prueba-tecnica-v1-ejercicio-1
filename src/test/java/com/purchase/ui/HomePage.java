package com.purchase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
	public static final Target LINK_PRODUCT_1 = Target.the("First product link in catalog")
			.locatedBy("(//div[@id='tbodyid']//a[contains(@class,'hrefch')])[1]");

	public static final Target LINK_PRODUCT_2 = Target.the("Second product link in catalog")
			.locatedBy("(//div[@id='tbodyid']//a[contains(@class,'hrefch')])[2]");

    public static final Target LINK_NAVBAR_BRAND = Target.the("Navbar brand link")
	    .locatedBy("//nav//a[contains(concat(' ', normalize-space(@class), ' '), ' navbar-brand ')]");

    public static final Target LINK_CART = Target.the("Cart link")
	    .locatedBy("//a[@id='cartur' and contains(@href,'cart.html')]");
}
