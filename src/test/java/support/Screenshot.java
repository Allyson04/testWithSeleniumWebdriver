package support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Screenshot {
    public static void screenShotting(WebDriver navegador, String arquivo) {
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception e) {
            System.out.println("There was a problem with printing to folder: " + e.getMessage());
        }
    }
}
