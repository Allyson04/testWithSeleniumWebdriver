package tests;

import java.util.concurrent.TimeUnit;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Generator;
import support.Screenshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserInfoTestData.csv")

public class InformacoesUsuarioTest {
    private WebDriver navegador;
    
    @Rule
    public TestName test = new TestName();
    
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
    }
    
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="type")String type, @Param(name="contact")String contact, @Param(name="message")String message) {
        //click button "data-target: addmoredata"
        navegador.findElement(By.cssSelector("button[data-target=addmoredata]")).click();
        
        //identify modal "#addmoredata"
        WebElement modalAddMoreData = navegador.findElement(By.id("addmoredata"));
        
        //identify select "name: type"
        WebElement selectType = modalAddMoreData.findElement(By.cssSelector("select[name=type]"));
        
        //select option "value: phone"
        new Select(selectType).selectByValue(type);
        
        //insert phone number in "name: contact"
        modalAddMoreData.findElement(By.name("contact")).sendKeys(contact);
        
        //click "SAVE" button 
        modalAddMoreData.findElement(By.linkText("SAVE")).click();
        
        //assert "Your contact has been added!"
        WebElement confirmContainer = navegador.findElement(By.id("toast-container"));
        String confirmMessage = confirmContainer.getText();
        assertEquals(message, confirmMessage);
    }
    
//    @Test
    public void removeUserContact() {
        //click remove link from "(21) 965999999" number
        navegador.findElement(By.xpath("//span[text()=\"(21) 965999999\"]/following::a")).click();
        
        //confirm alert
        navegador.switchTo().alert().accept();
        
        //check  "Rest in peace, dear phone!" 
        WebElement popContainer = navegador.findElement(By.id("toast-container"));
        String message = popContainer.getText();
        assertEquals("Rest in peace, dear phone!", message);
        
        String screenshotFileName = "C:\\projects\\testWithSeleniumWebdriver\\src\\test\\java\\test-reports\\" + Generator.dateHourForArchive() + test.getMethodName() + ".png";
        Screenshot.screenShotting(navegador, screenshotFileName);
//        Screenshot.tirar(navegador, "..\\test-reports" + Generator.dateHourForArchive() + "removeUserContact.png");
        
        //wait 10 seconds to message disappear
        WebDriverWait waitPopMessage = new WebDriverWait(navegador, 10);
        waitPopMessage.until(ExpectedConditions.stalenessOf(popContainer));

        //click "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }
    
    @After
    public void tearDown() {
//      closing the window
        navegador.close();
    }
}
