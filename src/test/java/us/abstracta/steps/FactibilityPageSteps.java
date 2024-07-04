package us.abstracta.steps;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import us.abstracta.config.DependencyInjector;
import us.abstracta.pages.FactibilityPage;

import java.nio.file.Paths;

public class FactibilityPageSteps {
    private Page page;
    private FactibilityPage factibilityPage;

    public FactibilityPageSteps() {
        this.page = DependencyInjector.getPage("chromium");
        this.factibilityPage = new FactibilityPage(page);
    }

    @When("selecciono la opción de 600 MB")
    public void selecciono_la_opcion_de_600_MB() {
        factibilityPage.clickOpcion600MB();
        takeScreenshot("Seleccionar plan de 600 mb");
    }

    @Then("se despliega el formulario de factibilidad de fibra óptica")
    public void se_despliega_el_formulario_de_factibilidad_de_fibra_optica() {
        factibilityPage.sedespliegayllenaformulario();
        takeScreenshot("Formulario factibilidad");
    }

    @Then("la aplicación valida los datos ingresados y valida si tengo factibilidad")
    public void laAplicacionValidaLosDatosIngresadosYValidaSiTengoFactibilidad() {
        factibilityPage.laAplicacionValidaLosDatosIngresadosYValidaSiTengoFactibilidad();
        takeScreenshot("Verificación de factibilidad");
    }

    @And("selecciono el botón Quiero que me llamen")
    public void seleccionoElBotonQuieroQueMeLlamen() {
        factibilityPage.seleccionoElBotonQuieroQueMeLlamen();
        takeScreenshot("Seleccionar botón");
    }

    @And("ingreso nombre y numero")
    public void ingresoNombreYNumero() {
        factibilityPage.ingresoNombreYNumero();
        takeScreenshot("Ingreso de datos para llamada");
    }


    @Then("presiono botón Llámame")
    public void presionoBotonLlamame() {
        factibilityPage.presionoBotonLlamame();
        takeScreenshot("presionar botón");
    }
    public void takeScreenshot(String stepName) {
        String screenshotName = stepName + "_" + System.currentTimeMillis() + ".png";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/Evidencia/Evidencia_" + screenshotName)));
    }
}