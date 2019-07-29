package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginPage typeLogin(String login) {//click control + F - find element in console
        navegador.findElement(By.id("username")).sendKeys(login);

        return this;
    }

    public LoginPage typePassword(String password) {
        navegador.findElement(By.id("password")).sendKeys(password);

        return this;
    }

    public LoginPage selectLocationForThisSession() {
        navegador.findElement(By.xpath("//li[contains(text(),'Inpatient Ward')]")).click();

        return this;
    }

    public HomePage clickLogIn() {
        navegador.findElement(By.id("loginButton")).click();

        return new HomePage(navegador);
    }

    public HomePage login(String login, String password) {
        return typeLogin(login)
                .typePassword(password)
                .selectLocationForThisSession()
                .clickLogIn();
    }
}

