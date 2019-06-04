package kismia;

import core.BrowserFactory;
import kismia.pages.LoginPage;
import kismia.pages.MessagePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MessageTest extends BrowserFactory {
    @Test ()
    public void sendMessage (){
        LoginPage loginPage = new LoginPage();
        MessagePage messagePage = new MessagePage();
        String message = "Hello";

        loginPage.open();
        loginPage.login("gispazerzo@desoz.com", "Qsdfo123!");
        messagePage.open();
        messagePage.sendMessage(message);

        Assert.assertTrue(!driver.findElements(By.cssSelector(".chat-list__elem--new-message")).isEmpty(), "Message is not sent");
    }
}
