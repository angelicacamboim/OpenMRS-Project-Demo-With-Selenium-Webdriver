package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FindPatientRecordPage extends BasePage {

    public FindPatientRecordPage(WebDriver navegador) {
        super(navegador);
    }

    public PatientPage findPatientRecord(String name) {
        navegador.findElement(By.id("patient-search")).sendKeys(name);//robert hall
        navegador.findElement(By.xpath("//td[contains(text(),'" + name +"')]")).click();

        return new PatientPage(navegador);
    }

}
