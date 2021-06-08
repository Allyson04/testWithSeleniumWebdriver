package tests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InformacoesUsuarioTest {
    private WebDriver navegador;
    
    @Before
    public void setUp() {
        //select a browser driver, in this case is chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\assets\\drivers\\chromedriver.exe");
        
        //create a variable to indicate the instruction using chromedriver
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //go to webpage
        navegador.get("http://www.juliodelima.com.br/taskit");
        
        //maximize browser window
        navegador.manage().window().maximize();
    }
    
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
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
        
        //click "Hi, Allyson Eduardo"
        navegador.findElement(By.linkText("Hi, Allyson Eduardo")).click();
        
        //click "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        
        //click button "data-target: addmoredata"
        navegador.findElement(By.cssSelector("button[data-target=addmoredata]")).click();
        
        //identify modal "#addmoredata"
        WebElement modalAddMoreData = navegador.findElement(By.id("addmoredata"));
        
        //identify select "name: type"
        WebElement selectType = modalAddMoreData.findElement(By.cssSelector("select[name=type]"));
        
        //select option "value: phone"
        new Select(selectType).selectByValue("phone");
        
        //insert phone number in "name: contact"
        modalAddMoreData.findElement(By.name("contact")).sendKeys("(21) 965999999");
        
        //click "SAVE" button 
        modalAddMoreData.findElement(By.linkText("SAVE")).click();
        
        //assert "Your contact has been added!"
        WebElement confirmContainer = navegador.findElement(By.id("toast-container"));
        String confirmMessage = confirmContainer.getText();
        
        assertEquals("Your contact has been added!", confirmMessage);
    }
    
    @After
    public void tearDown() {
//      closing the window
//        navegador.close();
    }
}
