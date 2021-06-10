package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage{

    public MainPage(WebDriver navegador) {
        super(navegador);
    }

    
    public AddMoreDataPage clickHiUser() {
        navegador.findElement(By.linkText("Hi, Allyson Eduardo")).click();

        return new AddMoreDataPage(navegador);
    }
}
