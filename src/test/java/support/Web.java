package support;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
    public static WebDriver createChrome() {
        //select a browser driver, in this case is chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\assets\\drivers\\chromedriver.exe");
        
        //create a variable to indicate the instruction using chromedriver
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //go to webpage
        navegador.get("http://www.juliodelima.com.br/taskit");
        
        //maximize browser window
        navegador.manage().window().maximize();
        
        return navegador;
    }
}
