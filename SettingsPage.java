package kismia.pages;
import static core.BrowserFactory.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SettingsPage {
    private By personalData = By.cssSelector(".settings-nav__elem:nth-child(2)");
    private By femaleIconBtn = By.cssSelector("input[name=gender][value=f]");
    private By maleIconBtn = By.cssSelector("input[name=gender][value=m]");
    private By saveBtn = By.cssSelector(".button--flat-green");
    private By daySelect = By.cssSelector("#day");
    private By monthSelect = By.cssSelector("#month");
    private By yearSelect = By.cssSelector("#year");
    private By userSettingsSelect = By.cssSelector(".icon--header-sub");
    private By settingsOption = By.cssSelector(".new-header-subs__elem:nth-child(3)");

    public void openSettings (){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(userSettingsSelect)).click();
    }

    public void changeAge (int day, int month, int year){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(settingsOption)).click();

        //Change age
        wait.until(ExpectedConditions.elementToBeClickable(personalData)).click();
        wait.until(ExpectedConditions.elementToBeClickable(daySelect));
        Select selectDay = new Select(driver.findElement(daySelect));
        selectDay.selectByValue(Integer.toString(day));
        Select selectMonth = new Select(driver.findElement(monthSelect));
        selectMonth.selectByValue(Integer.toString(month));
        Select selectYear = new Select(driver.findElement(yearSelect));
        selectYear.selectByValue(Integer.toString(year));
    }

    public void changeSex (){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //Change sex
        driver.findElement(femaleIconBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

    }
}
