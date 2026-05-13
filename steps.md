# Generación de elementos

## HomePage

- Genera los mapeos para la clase HomePage con SerenityBDD
- Define los elementos como estáticos públicos usando Target.the() y locatedBy().
- Utiliza los Xpaths para localizar y identificar plenamente a los elementos de la pagina
- Usa el MCP de playwrigh

Elementos a mapear:

    LINK_PRODUCT_1 (Elemento DIV que contiene un elemento de ancle con un href="prod.html?idp_=1" ) 
    LINK_PRODUCT_2 (Elemento DIV que contiene un elemento de ancle con un href="prod.html?idp_=2" )
    LINK_NAVBAR_BRAND (Elemento de ancla con una class="nabvar-brand")
    LINK_CART (Elemento de ancla con id="cartur")

## Product Page

- Genera los mapeos para la clase ProductPage con Serenity BDD
- Define los elementos cómo públicos usando Target.the() y locatedBy().
- Utiliza los Xpaths para localizar y identificar plenamente a los elementos de la pagina
- Usa el MCP de playwright

    - PRODUCT_NAME (h2 con class='name')  
    - PRODUCT_PRICE (h3 con class='price-container')  
    - PRODUCT_DESCRIPTION (div con id='more-information')  
    - BUTTON "Add to cart" (a con class='btn btn-success btn-lg')  

- Sigue las convenciones de Screenplay

La estructura de la página es idéntica para cualquier producto (independientemente del parámetro idp_), por lo que una sola clase debe manejar todos los productos.  

## Cart Page

- Genera los mapeos para la clase ProductPage con Serenity BDD
- Define los elementos cómo públicos usando Target.the() y locatedBy().
- Usa el MCP de playwright
- Usa XPaths para localizar los siguientes elementos de la página de producto:


    - TABLE_PRODUCT (Elemento que contiene los productos agregados al carrito de compra)
    - PLACE_ORDER (Botón que dice "Place Order")
    - MODAL_DIALOG (Elemento div con class="modal_dialog")

    Dentro de MODAL_DIALOG

    - PURCHASE_BUTTON (Elemento dentro del formulario de botón que dice "Purchase")

    - SWEET_ALERT (Elemento con class="sweet-alert")




