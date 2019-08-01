package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import suporte.Screenshot;

public class RegisterAPatientPage extends BasePage {

    @FindBy(name="givenName")
    WebElement givenName;
    @FindBy(name="familyName")
    WebElement familyName;
    @FindBy(xpath="//span[contains(text(),'Gender')]")
    WebElement menuGender;
    @FindBy(id="gender-field")
    WebElement gendeField;
    @FindBy(xpath="//span[contains(text(),'Birthdate')]")
    WebElement menuBirthDate;
    @FindBy(id="birthdateDay-field")
    WebElement dayBirthDate;
    @FindBy(id="demographics-birthdate")
    WebElement comboMonth;
    @FindBy(id="birthdateYear-field")
    WebElement yearBirthDate;
    @FindBy(xpath="//span[contains(text(),'Address')]")
    WebElement menuAddress;
    @FindBy(id="address1")
    WebElement address;
    @FindBy(id="cityVillage")
    WebElement cityVillage;
    @FindBy(id="stateProvince")
    WebElement stateProvince;
    @FindBy(id="country")
    WebElement country;
    @FindBy(id="postalCode")
    WebElement postalCode;
    @FindBy(xpath="//span[contains(text(),'Phone Number')]")
    WebElement menuPhoneNumber;
    @FindBy(name="phoneNumber")
    WebElement phoneNumber;
    @FindBy(xpath="//span[contains(text(),'Relatives')]")
    WebElement menuRelatives;
    @FindBy(id="relationship_type")
    WebElement relationshipType;
    @FindBy(xpath="//input[@placeholder='Person Name']")
    WebElement personalName;
    @FindBy(xpath="//span[contains(text(),'Confirm')]")
    WebElement menuConfirm;
    @FindBy(id="submit")
    WebElement submit;


    public RegisterAPatientPage(WebDriver navegador) {

        super(navegador);
    }

    public PatientPage registerAPatient(String a_name, String b_name, String c_gender, String d_birthday,
                                        String e_birthday, String f_birthday,
                                        String g_address, String h_address, String i_address, String j_address,
                                        String l_address, String m_phone,String n_relatives, String o_relatives) {

        givenName.sendKeys(a_name);
        familyName.sendKeys(b_name);
        menuGender.click();
        new Select(gendeField).selectByVisibleText(c_gender);
        menuBirthDate.click();
        dayBirthDate.sendKeys(d_birthday);
        WebElement fieldSelect = comboMonth.findElement(By.id("birthdateMonth-field"));
        new Select(fieldSelect).selectByVisibleText(e_birthday);
        yearBirthDate.sendKeys(f_birthday);
        menuAddress.click();
        address.sendKeys(g_address);
        cityVillage.sendKeys(h_address);
        stateProvince.sendKeys(i_address);
        country.sendKeys(j_address);
        postalCode.sendKeys(l_address);
        menuPhoneNumber.click();
        phoneNumber.sendKeys(m_phone);
        menuRelatives.click();
        new Select(relationshipType).selectByVisibleText(n_relatives);//Parent
        personalName.sendKeys(o_relatives);
        menuConfirm.click();
        Screenshot.tirar(navegador, "RegisterAPatientPage");
        submit.click();

        return new PatientPage(navegador);

    }

}
