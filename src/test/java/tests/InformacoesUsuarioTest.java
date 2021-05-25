package tests;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //select a browser driver, in this case is chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\assets\\drivers\\chromedriver.exe");
        
        //create a variable to indicate the instruction using chromedriver
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //go to webpage
        navegador.get("http://www.juliodelima.com.br/taskit");
        
        //maximize browser window
        navegador.manage().window().maximize();
        
        //click on "sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        
        //identifying the form
        WebElement formSigninbox = navegador.findElement(By.id("signinbox"));
        
        //type login
        formSigninbox.findElement(By.name("login")).sendKeys("allyson04");

        //type password
        formSigninbox.findElement(By.name("password")).sendKeys("123456");

        //click on "sign in" inside the modal "sign in"
        formSigninbox.findElement(By.linkText("SIGN IN")).click();
        
        //make a validation
        WebElement confirmMessage = navegador.findElement(By.className("me"));
        String loginName = confirmMessage.getText();
        assertEquals("Hi, Allyson Eduardo", loginName);
        
    }
}
