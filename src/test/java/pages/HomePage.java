package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText="Register a patient")
    WebElement linkRegisterAPatient;
    @FindBy(linkText="Find Patient Record")
    WebElement linkFindAPatient;

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    public RegisterAPatientPage clickMenuRegisterAPatient() {
        linkRegisterAPatient.click();
        return new RegisterAPatientPage(navegador);
    }
    public FindPatientRecordPage clickMenuFindPatientRecord() {
        linkFindAPatient.click();
        return new FindPatientRecordPage(navegador);
    }
}
