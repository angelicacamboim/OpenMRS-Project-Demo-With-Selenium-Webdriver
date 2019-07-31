package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = {"PatientData.csv", "CaptureVitalsPatientData.csv"})
public class PatientPageObjectTest {

    private WebDriver navegador;
    private String username;
    private String password;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
        username = "Admin";
        password = "Admin123";
    }
    @Test
    public void registerAPatient(){
        String textoToast = new LoginPage(navegador)
                .login(username,password)
                .clickMenuRegisterAPatient()
                .registerAPatient("Angelica", "Bayern",
                "Female", "20","March", "1999", "130 Tottenham Court Rd", "London", "N/A",
                "England","25126", "+44 20 7388 4130", "Parent", "Robert Bayern")
                .sucessMessage();

        System.out.println("Texto de sucesso: " + textoToast);
       //Assert.assertEquals("Created Patient Record: " + "name", textoToast);

    }

    @Test
    public void FindPatient() {
        LoginPage user = new LoginPage(navegador);
        user.login(username,password).clickMenuFindPatientRecord().findPatientRecord("Robert Hall");

    }

    @Test
    public void CaptureVitalsPatient() {
        String textoToast =  new LoginPage(navegador)
                .login(username,password).clickMenuFindPatientRecord().findPatientRecord("Robert Smith").
                ClickStartVisit().ClickCaptureVitals().createCaptureVitalsPatient("180","80",
                        "40", "40", "50","50", "50","60")
                .ClickEndVisit().sucessMessage();

        System.out.println("Texto de sucesso: " + textoToast);
       // Assert.assertEquals("Entered Vitals for  " + "name", textoToast);
    }
   @Test
    public void DeletePatient() {
        String textoToast = new LoginPage(navegador)
            .login(username,password).clickMenuFindPatientRecord().findPatientRecord("Angelica Bayern").
                deletePatient().sucessMessage();

      Assert.assertEquals("Patient has been deleted successfully", textoToast);
    }

   // @After
    public void tearDown() {
        navegador.quit();
    }
}
