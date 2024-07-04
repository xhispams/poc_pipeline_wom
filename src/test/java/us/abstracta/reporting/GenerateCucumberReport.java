package us.abstracta.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;

public class GenerateCucumberReport {

    public static void generateReport() {
        String buildNumber = "1";
        String projectName = "MyProject";

        Configuration configuration = new Configuration(new File("POC"), projectName);
        configuration.setBuildNumber(buildNumber);

        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList("src//main//java//us//abstracta//reportes.json"), configuration);
        reportBuilder.generateReports();
    }

    public static void main(String[] args) {
        generateReport();
    }
}
