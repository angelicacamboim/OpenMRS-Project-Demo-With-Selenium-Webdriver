package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientPage extends BasePage {

    public PatientPage(WebDriver navegador) {
        super(navegador);
    }

    public PatientDashboardPage ClickStartVisit() {

       WebElement endVisit = navegador.findElement(By.linkText("End Visit"));
        if("End Visit".equals(endVisit.getText()))
        {
            navegador.findElement(By.linkText("End Visit")).click();
            navegador.findElement(By.xpath("//*[@class=\"dialog-content\"]//button[contains(text(),'Yes')]")).click();
        }
        navegador.findElement(By.linkText("Start Visit")).click();
        navegador.findElement(By.xpath("//*[@id=\"quick-visit-creation-dialog\"]//button[contains(text(),'Confirm')]")).click();

        return new PatientDashboardPage(navegador);
    }
    public PatientPage deletePatient() {
        navegador.findElement(By.linkText("Delete Patient")).click();
        navegador.findElement(By.id("delete-reason")).sendKeys("Yes, I'm sure!");
        navegador.findElement(By.xpath("//*[@id=\"delete-patient-creation-dialog\"]//button[contains(text(),'Confirm')]")).click();
        return this;
    }
}
