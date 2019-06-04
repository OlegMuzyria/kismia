package kismia;

import core.BrowserFactory;
import kismia.pages.LoginPage;
import kismia.pages.SettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SettingsTest extends BrowserFactory {
    @Test
    public void changeSettings  (){
        int day = ThreadLocalRandom.current().nextInt(1, 32);
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int year = ThreadLocalRandom.current().nextInt(1930, 2003);

        LoginPage loginPage = new LoginPage();
        SettingsPage  settingsPage = new SettingsPage();

        loginPage.open();
        loginPage.login("gispazerzo@desoz.com", "Qsdfo123!");
        settingsPage.openSettings();
        settingsPage.changeAge(day, month, year);

        Select selectDay = new Select(driver.findElement(By.cssSelector("#day")));
        String changedDayValue = selectDay.getFirstSelectedOption().getText();
        int newDay = Integer.parseInt(changedDayValue);

        //Compare selected value with generated
        Assert.assertEquals(day, newDay, "Day is not changed");

        settingsPage.changeSex();
        //Check that sex is changed
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name=gender][value=f]")).isSelected(), "Sex is not changed");
    }
}
