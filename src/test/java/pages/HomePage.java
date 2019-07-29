package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }
    public RegisterAPatientPage clickRegisterAPatient() {
        navegador.findElement(By.linkText("Register a patient")).click();

        return new RegisterAPatientPage(navegador);
    }
    public FindPatientRecordPage clickFindPatient() {
        navegador.findElement(By.linkText("Find Patient Record")).click();

        return new FindPatientRecordPage(navegador);
    }
}
