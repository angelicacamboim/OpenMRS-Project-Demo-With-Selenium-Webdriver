package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaptureVitalsPage extends BasePage {

    @FindBy(xpath="//span[@id=\"height\"]/input")
    WebElement height;
    @FindBy(xpath="//span[contains(text(),'Weight (kg)')]")
    WebElement menuWeight;
    @FindBy(xpath="//span[@id=\"weight\"]/input")
    WebElement weight;
    @FindBy(xpath="//span[contains(text(),'(Calculated) BMI')]")
    WebElement menuCalculatedBMI;
    @FindBy(xpath="//span[contains(text(),'Temperature (C)')]")
    WebElement menuTemperature;
    @FindBy(xpath="//span[@id=\"temperature\"]/input")
    WebElement temperature;
    @FindBy(xpath="//span[contains(text(),'Pulse')]")
    WebElement menuPulse;
    @FindBy(xpath="//span[@id=\"heart_rate\"]/input")
    WebElement heartRate;
    @FindBy(xpath="//span[contains(text(),'Respiratory rate')]")
    WebElement menuRespiratoryRate;
    @FindBy(xpath="//span[@id=\"respiratory_rate\"]/input")
    WebElement respiratoryRate;
    @FindBy(xpath="//span[contains(text(),'Blood Pressure')]")
    WebElement menuBloodPressure;
    @FindBy(xpath="//span[@id=\"bp_systolic\"]/input")
    WebElement bpSystolic;
    @FindBy(xpath="//span[@id=\"bp_diastolic\"]/input")
    WebElement bpDiastolic;
    @FindBy(xpath="//span[contains(text(),'Blood oxygen saturation')]")
    WebElement menuBloodOxygenSaturation;
    @FindBy(xpath="//span[@id=\"o2_sat\"]/input")
    WebElement oxygenSaturation;
    @FindBy(xpath="//span[contains(text(),'Confirm')]")
    WebElement menuConfirm;
    @FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement save;

        public CaptureVitalsPage(WebDriver navegador) {
        super(navegador);
    }

    public PatientDashboardPage createCaptureVitalsPatient(String a_height, String b_weight, String c_temperature,
                                                           String d_heart, String e_respiratory,
                                                           String f_bp, String g_dp, String h_oxygen) {
        height.sendKeys(a_height);//180
        menuWeight.click();
        weight.sendKeys(b_weight);
        menuCalculatedBMI.click();
        menuTemperature.click();
        temperature.sendKeys(c_temperature);//40
        menuPulse.click();
        heartRate.sendKeys(d_heart);
        menuRespiratoryRate.click();
        respiratoryRate.sendKeys(e_respiratory);//40
        menuBloodPressure.click();
        bpSystolic.sendKeys(f_bp);//50
        bpDiastolic.sendKeys(g_dp);//60
        menuBloodOxygenSaturation.click();
        oxygenSaturation.sendKeys(h_oxygen);//100
        menuConfirm.click();
        save.click();
        return new PatientDashboardPage(navegador);
    }

}
