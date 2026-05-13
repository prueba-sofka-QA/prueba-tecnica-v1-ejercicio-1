package com.purchase.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target LINK_PRODUCT_1 = Target.the("Product 1 link container (prod.html?idp_=1)")
	    .locatedBy("//div[@id='tbodyid']//div[contains(@class,'col-lg-4') and contains(@class,'col-md-6') and contains(@class,'mb-4')][.//a[@href='prod.html?idp_=1']]");

    public static final Target LINK_PRODUCT_2 = Target.the("Product 2 link container (prod.html?idp_=2)")
	    .locatedBy("//div[@id='tbodyid']//div[contains(@class,'col-lg-4') and contains(@class,'col-md-6') and contains(@class,'mb-4')][.//a[@href='prod.html?idp_=2']]");

    public static final Target LINK_NAVBAR_BRAND = Target.the("Navbar brand link")
	    .locatedBy("//nav//a[contains(concat(' ', normalize-space(@class), ' '), ' navbar-brand ')]");

    public static final Target LINK_CART = Target.the("Cart link")
	    .locatedBy("//a[@id='cartur' and contains(@href,'cart.html')]");
}
