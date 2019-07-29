package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptureVitalsPage extends BasePage {

    public CaptureVitalsPage(WebDriver navegador) {
        super(navegador);
    }

    public CaptureVitalsPage typeHeight(String height) {
        navegador.findElement(By.xpath("//span[@id=\"height\"]/input")).sendKeys(height);//180
        return this;
    }
    public CaptureVitalsPage typeWeight(String weight) {
        navegador.findElement(By.xpath("//span[contains(text(),'Weight (kg)')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"weight\"]/input")).sendKeys(weight);//80
        return this;
    }
    public CaptureVitalsPage typeBMI(String bmi) {
        navegador.findElement(By.xpath("//span[contains(text(),'(Calculated) BMI')]")).click();
        return this;
    }
    public CaptureVitalsPage typeTemperature(String temp) {
        navegador.findElement(By.xpath("//span[contains(text(),'Temperature (C)')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"temperature\"]/input")).sendKeys(temp);//40
        return this;
    }
    public CaptureVitalsPage typePulse(String pulse) {
        navegador.findElement(By.xpath("//span[contains(text(),'Pulse')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"heart_rate\"]/input")).sendKeys(pulse);//50
        return this;
    }
    public CaptureVitalsPage typeRespiratoryRate(String respRate) {
        navegador.findElement(By.xpath("//span[contains(text(),'Respiratory rate')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"respiratory_rate\"]/input")).sendKeys(respRate);//40
        return this;
    }
    public CaptureVitalsPage typeBloodPressure(String bloodPressure1, String bloodPressure2) {
        navegador.findElement(By.xpath("//span[contains(text(),'Blood Pressure')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"bp_systolic\"]/input")).sendKeys(bloodPressure1);//50
        navegador.findElement(By.xpath("//span[@id=\"bp_diastolic\"]/input")).sendKeys(bloodPressure2);//60
        return this;
    }
    public CaptureVitalsPage typeBloodOxygenSaturation(String bloodOxy) {
        navegador.findElement(By.xpath("//span[contains(text(),'Blood oxygen saturation')]")).click();
        navegador.findElement(By.xpath("//span[@id=\"o2_sat\"]/input")).sendKeys(bloodOxy);//100
        return this;
    }
    public PatientDashboardPage clickConfirm() {
        navegador.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
        navegador.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        return new PatientDashboardPage(navegador);
    }


    public PatientDashboardPage createCaptureVitalsPatient(String height, String weight, String bmi, String temp, String pulse,
                                                           String respiratoryrate, String blood1, String blood2, String bloodOxy) {
        return typeHeight(height)
                .typeWeight(weight)
                .typeBMI(bmi)
                .typeTemperature(temp)
                .typePulse(pulse)
                .typeRespiratoryRate(respiratoryrate)
                .typeBloodPressure(blood1,blood2)
                .typeBloodOxygenSaturation(bloodOxy)
                .clickConfirm();
    }

}
