package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientDashboardPage extends BasePage {

    @FindBy(linkText="Capture Vitals")
    WebElement linkCaptureVitals;
    @FindBy(linkText="End Visit")
    WebElement endVisit;
    @FindBy(xpath="//*[@id='end-visit-dialog']//button[.='Yes']")
    WebElement endVisitConfirm;
    @FindBy(xpath="//*[@class='toast-item toast-type-success']/p")
    WebElement captureMessage;

    public PatientDashboardPage(WebDriver navegador) {
        super(navegador);
    }

    public CaptureVitalsPage ClickCaptureVitals() {
        linkCaptureVitals.click();
        return new CaptureVitalsPage(navegador);
    }
    public PatientDashboardPage ClickEndVisit() {
        endVisit.click();
        endVisitConfirm.click();
        return this;
    }
    public String sucessMessage()
    {
        return captureMessage.getText();
    }

}
