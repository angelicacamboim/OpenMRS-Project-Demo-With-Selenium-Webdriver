package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientDashboardPage extends BasePage {

    public PatientDashboardPage(WebDriver navegador) {
        super(navegador);
    }

    public CaptureVitalsPage ClickCaptureVitals() {
        navegador.findElement(By.linkText("Capture Vitals")).click();
        return new CaptureVitalsPage(navegador);
    }
    public PatientDashboardPage ClickEndVisit() {
        navegador.findElement(By.linkText("End Visit")).click();
        navegador.findElement(By.xpath("//*[@id=\"end-visit-dialog\"]//button[contains(text(),'Yes')]")).click();

        return this;
    }

}
