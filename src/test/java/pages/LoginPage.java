package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suporte.Screenshot;

public class LoginPage extends BasePage {

    @FindBy(id="username")
    WebElement username;
    @FindBy(id="password")
    WebElement password;
    @FindBy(xpath="//li[contains(text(),'Inpatient Ward')]")
    WebElement selectLocationForThisSession;
    @FindBy(id="loginButton")
    WebElement buttonLogin;

    public LoginPage(WebDriver navegador) {

        super(navegador);
    }

    public HomePage login(String login, String value) {
        username.sendKeys(login);
        password.sendKeys(value);
        selectLocationForThisSession.click();
        Screenshot.tirar(navegador, "loginPage");
        buttonLogin.click();
        return new HomePage(navegador);
    }
}

