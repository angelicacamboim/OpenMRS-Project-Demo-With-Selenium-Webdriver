package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FindPatientRecordPage extends BasePage {

    @FindBy(id="patient-search")
    WebElement patientSearch;

    public FindPatientRecordPage(WebDriver navegador) {
        super(navegador);
    }

    public PatientPage findPatientRecord(String name) {
        patientSearch.sendKeys(name);//robert hall
        navegador.findElement(By.xpath("//td[contains(text(),'" + name +"')]")).click();

        return new PatientPage(navegador);
    }

}
