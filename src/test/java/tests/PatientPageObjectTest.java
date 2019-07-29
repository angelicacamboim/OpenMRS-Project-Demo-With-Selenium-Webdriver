package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

public class PatientPageObjectTest {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();

    }
    //@Test
    public void registerAPatient(){
        LoginPage user = new LoginPage(navegador);
        user.login("Admin","Admin123").clickRegisterAPatient().createPatient("Angelica", "Bayern",
                "Female", "20","March", "1999", "130 Tottenham Court Rd", "London", "N/A",
                "England","25126", "+44 20 7388 4130", "Parent", "Robert Bayern");
       // assertEquals("Flight Confirmation: Mercury Tours", texto);

    }

    //@Test
    public void FindPatient() {
        LoginPage user = new LoginPage(navegador);
        user.login("Admin","Admin123").clickFindPatient().findPatientRecord("Robert Hall");

    }

    @Test
    public void CaptureVitalsPatient() {
        LoginPage user = new LoginPage(navegador);
        user.login("Admin","Admin123").clickFindPatient().findPatientRecord("Robert Hall").
                ClickStartVisit().ClickCaptureVitals().createCaptureVitalsPatient("180","80","40", "40",
                "50","40", "50","60","100").ClickEndVisit();
    }
  // @Test
    public void DeletePatient() {
        LoginPage user = new LoginPage(navegador);
        user.login("Admin","Admin123").clickFindPatient().findPatientRecord("Andrew Young").
                deletePatient();

    }

   // @After
    public void tearDown() {
        navegador.quit();
    }
}
