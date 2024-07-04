package us.abstracta.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

public class FactibilityPage extends BasePage {

    public FactibilityPage(Page page) {
        super(page);
    }

    public void titleFactibilityPage() {
        waitForTimeout(5000);
        assertThat(page).hasTitle(Pattern.compile("Revisa factibilidad y cobertura"));
    }

    public void clickOpcion600MB() {
        page.click("text=Revisar Factibilidad");
    }

    public void sedespliegayllenaformulario() {
        // Método para llenar el formulario de factibilidad con datos

        page.locator("css=#city_in_modal").click();
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("PAINE")).click();
        //page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("MAIPÚ")).click();

        // Ingresar Dirección y seleccionar dirección
        fillInputField("#street_in_modal", "Las Acacias 112");
        page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("CALLE LAS ACACIAS 112 PAINE")).click();

        // Ingresar RUT, Email y Teléfono
        fillInputField("#rut_number_in_modal", "12345678-5");
        fillInputField("#email_in_modal", "test_poc_wom@gmail.com");
        fillInputField("#phone_number_in_modal", "912341234");

        // Presionar Botón
        page.click("xpath=//button[@type='button']");

    }
    public void laAplicacionValidaLosDatosIngresadosYValidaSiTengoFactibilidad() {
        String textoAValidar = "xpath=//h2[contains(text(),'Estamos trabajando para llegar a todo el país con ')]";
        String actualText = getTextContent(textoAValidar);
        assertEquals("Estamos trabajando para llegar a todo el país con la mejor fibra", actualText);
    }

    public void seleccionoElBotonQuieroQueMeLlamen() {
        //page.locator("xpath=//body/div[10]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/button[1]").click();
        page.locator("xpath=/html[1]/body[1]/div[10]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/button[1]").click();
    }

    public void ingresoNombreYNumero() {
        fillInputField("#fullName", "POC WOM");
        fillInputField("#phoneNumber", "912341234");
    }

    public void presionoBotonLlamame() {
        page.locator("xpath=//span[contains(text(),'llámenme')]").click();
    }

}