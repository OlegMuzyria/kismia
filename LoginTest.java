package kismia;

import core.BrowserFactory;
import kismia.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {
    @Test
    public void login (){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("gispazerzo@desoz.com", "Qsdfo123!");

        Assert.assertTrue(!driver.findElements(By.cssSelector(".new-header-main-nav__link--messages")).isEmpty(), "Main page is not opened");
    }
}
