package com.bdd.stepdefinition;

import challengue.base.PageBase;
import challengue.driver.DriverManager;
import com.bdd.page.AgregarProducto;
import com.bdd.page.IniciarSesion;
import com.bdd.page.RegistrarUsuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class TiendaStepDefinition {

    WebDriver driver;

    RegistrarUsuario registrarUsuario;
    IniciarSesion iniciarSesion;
    AgregarProducto agregarProducto;

    @Before
    public void configuracionInicial() {
        driver = DriverManager.getInstancia(DriverManager.NavegadorWeb.CHROME);
        registrarUsuario = new RegistrarUsuario(driver);
        iniciarSesion = new IniciarSesion(driver);
        agregarProducto = new AgregarProducto(driver);
        driver.manage().window().maximize();
    }

    @After
    public void liberarRecursos(){
        driver.quit();
    }

    @Given("Ingreso a la Wed de la Tienda")
    public void ingresoALaWedDeLaTienda() {
        registrarUsuario.cargarPagina();
    }

    @When("presiono el boton SignUp")
    public void presionoElBotonSignUp() {
        registrarUsuario.clickSignUp();
    }

    @And("ingreso el username {string}")
    public void ingresoElUsername(String username) throws InterruptedException {
        registrarUsuario.editUserName(username);
    }

    @And("ingreso el password {string}")
    public void ingresoElPassword(String password) {
        registrarUsuario.editPassword(password);
    }

    @And("presiono el boton Registrar")
    public void presionoElBotonRegistrar() {
        registrarUsuario.clickRegistrar();
    }

    @Then("Se muestra un mensaje de confirmacion {string}")
    public void seMuestraUnMensajeDeConfirmacion(String message) throws InterruptedException {

        Assert.assertEquals(registrarUsuario.getMessage(),message);
    }

    @When("presiono el boton Login")
    public void presionoElBotonLogin() {
        iniciarSesion.clickLogin();
    }

    @And("escribo el username {string}")
    public void escriboElUsername(String username) throws InterruptedException {
        iniciarSesion.escribirUsername(username);
    }

    @And("escribo el password {string}")
    public void escriboElPassword(String password) {
        iniciarSesion.escribirPassword(password);
    }

    @Then("se muestra un mensaje de bienvenida {string}")
    public void seMuestraUnMensajeDeBienvenida(String message) throws InterruptedException {
        Assert.assertEquals(iniciarSesion.obtenerMensajeBienvenida(),message);
    }

    @And("presiono el boton Iniciar Sesion")
    public void presionoElBotonIniciarSesion() {
        iniciarSesion.clickIniciarSesion();
    }

    @And("presiono el boton Logout")
    public void presionoElBotonLogout() throws InterruptedException {
        iniciarSesion.clickLogout();
    }

    @Then("se muestra la pagina principal")
    public void seMuestraLaPaginaPrincipal() throws InterruptedException {
        Assert.assertTrue(iniciarSesion.esVisibleBotonLogin());
    }

    @And("selecciono la categoria {string}")
    public void seleccionoLaCategoria(String opcion) throws InterruptedException {
        agregarProducto.seleccionarCategoria(opcion);
    }

    @And("selecciono el Producto {string}")
    public void seleccionoElProducto(String opcion) throws InterruptedException {
        agregarProducto.seleccionarProducto(opcion);
    }

    @And("presiono el boton Add to cart")
    public void presionoElBotonAddToCart() {
        agregarProducto.clickAgregarAlCarro();
    }

}
