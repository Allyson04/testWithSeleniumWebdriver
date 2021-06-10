package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMoreDataPage extends BasePage {

    public AddMoreDataPage(WebDriver navegador) {
        super(navegador);
    }
    
    public AddMoreDataPage openAddMoreDataTab() {
        //click "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        
        return this;
    }
    
    public ModalAddContactPage clickAddMoreDataButton() {
        //click button "data-target: addmoredata"
        navegador.findElement(By.cssSelector("button[data-target=addmoredata]")).click();

        return new ModalAddContactPage(navegador);
    } 
}
