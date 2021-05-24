package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //select a browser driver, in this case is chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\assets\\drivers\\chromedriver.exe");
        
        //create a variable to indicate the instruction using chromedriver
        WebDriver navegador = new ChromeDriver();
        
        //go to webpage
        navegador.get("http://www.juliodelima.com.br/taskit");
        
        //maximize browser window
        navegador.manage().window().maximize();
        
        //make a validation
        assertEquals(1, 1);
        
    }
}
