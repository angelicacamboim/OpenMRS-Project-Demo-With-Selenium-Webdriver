package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void tirar(WebDriver navegador, String name) {
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("Prints/" + Generator.dataHoraParaArquivo() + name + ".png"));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: " + e.getMessage());
        }
    }
}