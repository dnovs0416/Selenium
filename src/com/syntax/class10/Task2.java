package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task2 {
    /*
    Go to aa.com/homePage.do
    select depart date
    select return date
    select destination
    click on search
    quit the browser
     */
    public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement destinationAirport = driver.findElement(By.xpath("//input[@id = 'reservationFlightSearchForm.destinationAirport']"));
        destinationAirport.sendKeys("MNL");

        WebElement departCalendar = driver.findElement(By.className("ui-datepicker-trigger"));
        departCalendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        WebElement dateMonth = driver.findElement(By.xpath("//span[@class = 'ui-datepicker-month']"));
//        String dMonthText = dateMonth.getText();
        nextButton.click();
        System.out.println(dateMonth.getText());
        nextButton = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        nextButton.click();
        System.out.println(dateMonth.getText());
        nextButton = driver.findElement(By.xpath("//a[@data-handler = 'next']"));
        nextButton.click();
        System.out.println(dateMonth.getText());



    }
}
//div[@class = 'ui-datepicker-group ui-datepicker-group-first']/table/tbody
