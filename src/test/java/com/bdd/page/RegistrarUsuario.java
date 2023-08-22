package com.bdd.page;

import challengue.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrarUsuario extends PageBase {

    public RegistrarUsuario(WebDriver driver) {
        super(driver);
    }

    private By btnSignUp = By.id("signin2");
    private By txtUserName = By.id("sign-username");
    private By txtPassword = By.id("sign-password");
    private By btnRegister = By.xpath("//button[normalize-space()='Sign up']");
    private By btnAceptar = By.xpath("//button[contains(text(), 'Aceptar')]");

    public void cargarPagina(){
        driver.get("https://www.demoblaze.com/index.html");
    }
    public void clickSignUp(){
        click(btnSignUp);
    }

    public void editUserName(String username) throws InterruptedException {
        Thread.sleep(2000);
        type(username,txtUserName);
    }

    public void editPassword(String password){
        type(password,txtPassword);
    }

    public void clickRegistrar(){
        click(btnRegister);
    }

    public String getMessage() throws InterruptedException {
        Thread.sleep(2000);
        return driver.switchTo().alert().getText();

    }

    public void clickAceptar(){
        driver.switchTo().alert().accept();
    }


}
