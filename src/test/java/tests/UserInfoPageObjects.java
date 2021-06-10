package tests;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

public class UserInfoPageObjects {
    private WebDriver navegador;
    
    @Before
    public void setUp() {
        navegador = Web.createChrome();
        
    }
    
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        String confirmMessage = new LoginPage(navegador)
                .clickSignIn()
                .logIn("allyson04", "123456")
                .clickHiUser()
                .openAddMoreDataTab()
                .clickAddMoreDataButton()
                .addNewContact("phone", "(21) 965999999")
                .checkComboBox();
        
        assertEquals("Your contact has been added!", confirmMessage);

    }
    
    @After
    public void tearDown() {
//        navegador.quit();
    }
}
