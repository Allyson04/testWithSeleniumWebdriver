package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UserInfoTestDataPageObjects.csv")
public class UserInfoPageObjects {
    private WebDriver navegador;
    
    @Before
    public void setUp() {
        navegador = Web.createChrome();
        
    }
    
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="password")String password,
            @Param(name="type")String type,
            @Param(name="contact")String contact,
            @Param(name="messageExpected")String messageExpected
        ) {
        
        String confirmMessage = new LoginPage(navegador)
                .clickSignIn()
                .logIn(login,password)
                .clickHiUser()
                .openAddMoreDataTab()
                .clickAddMoreDataButton()
                .addNewContact(type, contact)
                .checkComboBox();
        
        assertEquals(messageExpected, confirmMessage);

    }
    
    @After
    public void tearDown() {
        navegador.quit();
    }
}
