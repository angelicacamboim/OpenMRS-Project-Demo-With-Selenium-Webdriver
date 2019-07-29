package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterAPatientPage extends BasePage {

    public RegisterAPatientPage(WebDriver navegador) {
        super(navegador);
    }
    public RegisterAPatientPage typeName(String given, String familyName) {
        navegador.findElement(By.name("givenName")).sendKeys(given);
        navegador.findElement(By.name("familyName")).sendKeys(familyName);

        return this;
    }

    public RegisterAPatientPage typeGender(String gender) {
        navegador.findElement(By.xpath("//span[contains(text(),'Gender')]")).click();
        // Identificar a popup onde está o formulário
        WebElement form = navegador.findElement(By.id("gender"));
        // Na combo de name "type" escolhe a opção "Female"
        WebElement fieldSelect = form.findElement(By.id("gender-field"));
        new Select(fieldSelect).selectByVisibleText(gender);

        return this;
    }

    public RegisterAPatientPage typeBirthdate(String day, String month, String year) {
        navegador.findElement(By.xpath("//span[contains(text(),'Birthdate')]")).click();
        navegador.findElement(By.id("birthdateDay-field")).sendKeys(day);
        // Identificar a popup onde está o formulário
        WebElement form = navegador.findElement(By.id("demographics-birthdate"));
        // Na combo escolher a opção "March"
        WebElement fieldSelect = form.findElement(By.id("birthdateMonth-field"));
        new Select(fieldSelect).selectByVisibleText(month);

        navegador.findElement(By.id("birthdateYear-field")).sendKeys(year);

        return this;
    }
    public RegisterAPatientPage typeAddress(String address, String city, String state, String country, String postalCode) {
        navegador.findElement(By.xpath("//span[contains(text(),'Address')]")).click();
        navegador.findElement(By.id("address1")).sendKeys(address);
        navegador.findElement(By.id("cityVillage")).sendKeys(city);
        navegador.findElement(By.id("stateProvince")).sendKeys(state);
        navegador.findElement(By.id("country")).sendKeys(country);
        navegador.findElement(By.id("postalCode")).sendKeys(postalCode);

        return this;
    }
    public RegisterAPatientPage typePhoneNumber(String number) {
        navegador.findElement(By.xpath("//span[contains(text(),'Phone Number')]")).click();
        navegador.findElement(By.name("phoneNumber")).sendKeys(number);

        return this;
    }
    public RegisterAPatientPage typeRelatives(String typeRelationship, String name) {
        navegador.findElement(By.xpath("//span[contains(text(),'Relatives')]")).click();
        WebElement fieldSelect = navegador.findElement(By.id("relationship_type"));
        new Select(fieldSelect).selectByVisibleText(typeRelationship);//Parent

        navegador.findElement(By.xpath("//input[@placeholder=\"Person Name\"]")).sendKeys(name);

        return this;
    }
    public HomePage clickConfirm() {
        navegador.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
        navegador.findElement(By.id("submit")).click();
        return new HomePage(navegador);
    }

    public HomePage createPatient(String given, String familyName, String gender, String day, String month, String year,
                                  String address, String city, String state, String country, String postalCode,
                                  String number,String typeRelationship, String name) {
        return typeName(given, familyName)
                .typeGender(gender)
                .typeBirthdate(day, month, year)
                .typeAddress(address, city, state, country, postalCode)
                .typePhoneNumber(number)
                .typeRelatives(typeRelationship, name)
                .clickConfirm();
    }
}
