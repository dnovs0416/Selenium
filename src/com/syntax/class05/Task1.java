package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task1 {

    /*
    Facebook dropdown verification
    Open chrome browser
    Go to "https://www.facebook.com"
    click on create new account
    Verify:
    month dd has 12 month options
    day dd has 31 day options
    year dd has 115 year options
    Select your date of birth
    Quit browser
     */
    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createNewAccount = driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']"));
        createNewAccount.click();
        Thread.sleep(1000);

        WebElement monthsDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthsDD);
        List<WebElement> monthOptions = selectMonth.getOptions();
        int size = monthOptions.size();
        System.out.println("Months size = " + size);

        WebElement daysDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(daysDD);
        List<WebElement> daysOptions = selectDay.getOptions();
        size = daysOptions.size();
        System.out.println("Months size = " + size);

        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> yearOptions = selectYear.getOptions();
        size = yearOptions.size();
        System.out.println("Years size = " + size);

        selectMonth.selectByVisibleText("Apr");
        selectDay.selectByVisibleText("16");
        selectYear.selectByVisibleText("1988");

        Thread.sleep(2000);
        driver.quit();
    }
}
