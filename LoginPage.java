package kismia.pages;
import static core.BrowserFactory.driver;
import static org.openqa.selenium.Keys.ENTER;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private By emailFld = By.cssSelector("input[name=email]");
    private By passwordFld = By.cssSelector("input[name=password]");


    public void open (){
        driver.get("https://kismia.com/");
    }

    public void login (String email, String password){
        //Provide email and password
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(emailFld)).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(passwordFld).sendKeys(ENTER);
    }
}
