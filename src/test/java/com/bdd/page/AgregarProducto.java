package com.bdd.page;

import challengue.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgregarProducto extends PageBase {

    public AgregarProducto(WebDriver driver) {
        super(driver);
    }

    private By btnAddToCart = By.xpath("(//a[normalize-space()='Add to cart'])[1]");

    public void seleccionarCategoria(String opcion) throws InterruptedException {
        Thread.sleep(2000);
        seleccionarOpcion(opcion);
    }

    public void seleccionarProducto(String opcion) throws InterruptedException {
        Thread.sleep(2000);
        seleccionarOpcion(opcion);
    }

    public void clickAgregarAlCarro(){
        click(btnAddToCart);
    }

}
