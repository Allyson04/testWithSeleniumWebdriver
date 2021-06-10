package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ModalAddContactPage extends BasePage{
    
    public ModalAddContactPage(WebDriver navegador) {
        super(navegador);
    }
    
    public ModalAddContactPage selectContactType(String type) {
        //identify modal "#addmoredata"
        WebElement selectType = navegador.findElement(By.id("addmoredata")).findElement(By.cssSelector("select[name=type]"));

        //select option "value: phone"
        new Select(selectType).selectByValue(type);
        return this;
    }
    
    public ModalAddContactPage typeContact(String contact) {
        //insert contact in "name: contact"
        navegador.findElement(By.id("addmoredata"))
            .findElement(By.name("contact")).sendKeys(contact);
        
        return this;
    }
    
    public AddMoreDataPage clickSave() {
        //click "SAVE" button 
        navegador.findElement(By.id("addmoredata"))
           .findElement(By.linkText("SAVE")).click();
        
        return new AddMoreDataPage(navegador);
    }
    
    public AddMoreDataPage addNewContact(String type, String contact) {
        selectContactType(type);
        typeContact(contact);
        clickSave();
        
        return new AddMoreDataPage(navegador);
    }
}
