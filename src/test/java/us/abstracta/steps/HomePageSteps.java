package us.abstracta.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import us.abstracta.config.DependencyInjector;
import us.abstracta.pages.HomePage;

import java.nio.file.Paths;

public class HomePageSteps<screenshotName> {
    private Page page;
    private HomePage homePage;

    public HomePageSteps() {
        this.page = DependencyInjector.getPage("chromium");
        this.homePage = new HomePage(page);
    }

    @Given("estoy en la página principal de WOM")
    public void estoy_en_la_pagina_principal_de_WOM() {
        homePage.navigateToHomePage();
        takeScreenshot("Página Principal");
    }

    @When("navego al menú Hogar y selecciono sub menu Revisa factibilidad")
    public void navego_al_menu_Hogar_y_selecciono_sub_menu_Revisa_factibilidad() {
        homePage.clickMenuHogar();
        homePage.clickSubMenuReviseFactibilidad();
        takeScreenshot("Menú Hogar - Revisa factibilidad");
    }

    @When("voy a {string} uso la barra de navegacion")
    public void voyASeccionUsoLaBarraDeNavegacion(String seccion) {
        homePage.clickOnSectionNavigationBar(seccion);
        takeScreenshot("Secciones");
    }
    public void takeScreenshot(String stepName) {
        String screenshotName = stepName + "_" + System.currentTimeMillis() + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/Evidencia/Evidencia_" + screenshotName)));
    }
}