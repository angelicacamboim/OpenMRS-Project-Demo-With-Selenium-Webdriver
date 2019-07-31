package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPage extends BasePage {

    @FindBy(linkText="End Visit")
    WebElement endVisit;
    @FindBy(xpath="//*[@id='end-visit-dialog']//button[.='Yes']")
    WebElement endVisitConfirm;
    @FindBy(linkText="Start Visit")
    WebElement startVisit;
    @FindBy(xpath="//*[@id='quick-visit-creation-dialog']//button[.='Confirm']")
    WebElement startVisitConfirm;
    @FindBy(linkText="Delete Patient")
    WebElement deletePatient;
    @FindBy(id="delete-reason")
    WebElement deleteReason;
    @FindBy(xpath="//*[@id=\"delete-patient-creation-dialog\"]//button[contains(text(),'Confirm')]")
    WebElement deletePatientConfirm;
    @FindBy(xpath="//*[@class='toast-item toast-type-success']/p")
    WebElement captureMessage;

    public PatientPage(WebDriver navegador) {
        super(navegador);
    }

    public PatientDashboardPage ClickStartVisit() {
        //To check text present
        if(!navegador.findElements(By.linkText("End Visit")).isEmpty()){
            endVisit.click();
            endVisitConfirm.click();
        }
        startVisit.click();
        startVisitConfirm.click();

        return new PatientDashboardPage(navegador);
    }
    public PatientPage deletePatient() {
        deletePatient.click();
        deleteReason.sendKeys("Yes, I'm sure!");
        deletePatientConfirm.click();
        return this;
    }
    public String sucessMessage()
    {
        return captureMessage.getText();
    }
}
