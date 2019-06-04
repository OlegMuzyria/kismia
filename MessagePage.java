package kismia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;
import static org.openqa.selenium.Keys.ENTER;

public class MessagePage {
    private By messagesBtn = By.cssSelector(".new-header-main-nav__link--messages");
    private By firstThread = By.cssSelector(".thread");
    private By messageInput = By.cssSelector("textarea[name=message]");

    public void open (){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(messagesBtn)).click();
    }

    public void sendMessage(String messageText) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(firstThread)).click();
        driver.findElement(messageInput).clear();
        driver.findElement(messageInput).sendKeys(messageText);
        driver.findElement(messageInput).sendKeys(ENTER);
    }
}
