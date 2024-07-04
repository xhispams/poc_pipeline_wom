package us.abstracta.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String menuHogar = "text=Hogar";

    public HomePage(Page page) {
        super(page);
    }

    public void clickMenuHogar() {
        clickElement(menuHogar);
    }

    public void clickSubMenuReviseFactibilidad() {
        clickElement("text=Revisa Factibilidad");
    }

    public void navigateToHomePage() {
        navigateTo("https://www.wom.cl/");
    }
    public void clickOnSectionNavigationBar(String seccion) {
        // Reemplaza el marcador de posición en sectionLink con el nombre de la sección
        String xpathSection = String.format(sectionLink, seccion);
        clickElement(xpathSection);
    }

}