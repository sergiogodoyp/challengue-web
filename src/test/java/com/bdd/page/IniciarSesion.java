package com.bdd.page;

import challengue.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IniciarSesion extends PageBase {

    public IniciarSesion(WebDriver driver) {
        super(driver);
    }

    private By btnLogin = By.id("login2");
    private By txtUserNameLogin = By.id("loginusername");
    private By txtPasswordLogin = By.id("loginpassword");
    private By btnIniciarSesion = By.xpath("//button[normalize-space()='Log in']");
    private By lblMensajeBienvenida = By.xpath("//a[@id='nameofuser']");
    private By btnLogout = By.id("logout2");

    public void clickLogin(){
        click(btnLogin);
    }

    public void escribirUsername(String username) throws InterruptedException {
        Thread.sleep(2000);
        type(username,txtUserNameLogin);
    }

    public void escribirPassword(String password){
        type(password,txtPasswordLogin);
    }

    public void clickIniciarSesion(){
        click(btnIniciarSesion);
    }

    public String obtenerMensajeBienvenida() throws InterruptedException {
        Thread.sleep(9000);
        return getText(lblMensajeBienvenida);
    }

    public void clickLogout() throws InterruptedException {
        Thread.sleep(5000);
        click(btnLogout);
    }

    public boolean esVisibleBotonLogin() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(btnLogin);
    }

}
