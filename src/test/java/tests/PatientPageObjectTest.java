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
import pages.PatientDashboardPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {"PatientData.csv", "CaptureVitalsPatientData.csv","DeletedPatient.csv"})
public class PatientPageObjectTest {

    private WebDriver navegador;
    private String username;
    private String password;

    @Before
    public void setUp() {
       // navegador = Web.createBrowserStack();
        navegador = Web.createChrome();
        username = "Admin";
        password = "Admin123";
    }
   // @Test
    public void registerAPatient(
            @Param(name="givenName")String givenName,
            @Param(name="familyName")String familyName,
            @Param(name="dayBirthday")String dayBirthday,
            @Param(name="gender")String gender,
            @Param(name="monthBirthday")String monthBirthday,
            @Param(name="yearBirthday")String yearBirthday,
            @Param(name="address")String address,
            @Param(name="city")String city,
            @Param(name="state")String state,
            @Param(name="country")String country,
            @Param(name="postalcode")String postalcode,
            @Param(name="phone")String phone,
            @Param(name="relationType")String relationType,
            @Param(name="namePerson")String namePerson,
            @Param(name="messageSucess")String messageSucess
            ){
        String textoToast = new LoginPage(navegador)
                .login(username,password)
                .clickMenuRegisterAPatient()
                .registerAPatient(givenName,familyName,gender,dayBirthday,monthBirthday,yearBirthday,address,
                        city,state,country,postalcode,phone,relationType,namePerson)
                .sucessMessage();

        System.out.println("Texto de sucesso: " + textoToast);
       Assert.assertEquals(messageSucess, textoToast);

    }

    @Test
    public void CaptureVitalsPatient(
            //p,bloodOxygenSaturation,messageSucess
            @Param(name="patient")String patient,
            @Param(name="height")String height,
            @Param(name="weight")String weight,
            @Param(name="temperature")String temperature,
            @Param(name="pulse")String pulse,
            @Param(name="respiratoryRate")String respiratoryRate,
            @Param(name="bloodPressure1")String bloodPressure1,
            @Param(name="bloodPressure2")String bloodPressure2,
            @Param(name="bloodOxygenSaturation")String bloodOxygenSaturation,
            @Param(name="messageSucess")String messageSucess
            ) {
        String textoToast =  new LoginPage(navegador)
                .login(username,password).clickMenuFindPatientRecord().findPatientRecord(patient).
                    ClickStartVisit().ClickCaptureVitals().createCaptureVitalsPatient(height,weight,temperature,pulse,
                        respiratoryRate,bloodPressure1,bloodPressure2,bloodOxygenSaturation)
                            .sucessMessage();

        PatientDashboardPage endVisit = new PatientDashboardPage(navegador).ClickEndVisit();

        System.out.println("Texto de sucesso: " + textoToast);
       Assert.assertEquals(messageSucess, textoToast);
    }
   //@Test
    public void DeletePatient(
           @Param(name="name")String name,
           @Param(name="messageSucess")String messageSucess
   ) {
        String textoToast = new LoginPage(navegador)
            .login(username,password).clickMenuFindPatientRecord().findPatientRecord(name).
                deletePatient().sucessMessage();

      Assert.assertEquals(messageSucess, textoToast);
    }

   @After
    public void tearDown() {
        navegador.quit();
    }
}
