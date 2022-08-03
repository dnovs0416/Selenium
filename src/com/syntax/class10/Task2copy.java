package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2copy {
    //Go to aa.com/homePage.do
    //select depart date
    //select return date
    //select destination
    //click on search
    //quit the browser
    public static String url = "https://www.aa.com/homePage.do";

    public static <TakingScreenShot> void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //select depart date
        WebElement departCalendarButton= driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following-sibling::button"));
        departCalendarButton.click();
        WebElement departMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][1]"));
        String departMonthText=departMonth.getText();
        WebElement nextButton= driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
        if(!departMonthText.equals("November")){
            nextButton.click();

        }
        List<WebElement> departDaysT=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement departDay : departDaysT) {
            String departDayaytext=departDay.getText();
            if(departDayaytext.equals("8")){
                departDay.click();
                break;
            }
        }
        //select return date//a[@aria-label='Next Month']
        WebElement returnCalender= driver.findElement(By.xpath("//label[@for='aa-returningFrom']/following-sibling::button"));
        returnCalender.click();
        WebElement nextButtonRe= driver.findElement(By.xpath("//a[@aria-label='Next Month']"));
        WebElement returnMonth=driver.findElement(By.xpath("//a[@aria-label='Next Month']/parent::div"));
        String returnMonthText=returnMonth.getText();
        if(!returnMonthText.equals("February")){
            nextButtonRe.click();
        }
        List<WebElement>daysReturnT=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement dayReturn : daysReturnT) {
            String dayReturnText= dayReturn.getText();
            if(dayReturnText.equals("20")){
                dayReturn.click();
                break;
            }
        }
        //select destination
        WebElement fromSearchButton=driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.originAirport']"));
        fromSearchButton.click();
        WebElement fromContryDD=driver.findElement(By.id("countryCode"));
        Select selectCountryFrom=new Select(fromContryDD);
        selectCountryFrom.selectByValue("US");

        WebElement fromStateDD=driver.findElement(By.xpath("//select[@id='stateCode']"));
        fromStateDD.click();
        Select selectStateF=new Select(fromStateDD);
        selectStateF.selectByValue("VA");

        List<WebElement> airportsFTable=driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr/td"));
        for (WebElement fromAirport : airportsFTable) {
            String fromAirporttext=fromAirport.getText();
            //System.out.println(fromAirporttext);
            if(fromAirporttext.contains("SHD")){
                fromAirport.click();
                break;
            }
        }

        WebElement ToSearch=driver.findElement(By.xpath("//a[@data-for='reservationFlightSearchForm.destinationAirport']"));
        ToSearch.click();
        WebElement toCountryDD=driver.findElement(By.xpath("//select[@id='countryCode']"));
        Select selectToCountry=new Select(toCountryDD);
        selectToCountry.selectByValue("US");

        WebElement toState=driver.findElement(By.xpath("//select[@id='stateCode']"));
        Select selectState=new Select(toState);
        selectState.selectByValue("AK");

        List<WebElement>toAirports=driver.findElements(By.xpath("//table[@id='airportsSection']/tbody/tr/td"));
        for (WebElement toAirport : toAirports) {
            String toAirportText=toAirport.getText();
            if(toAirportText.contains("KKI")){
                toAirport.click();
                break;
            }
        }
//        WebElement searchButton=driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
//        searchButton.click();
//        driver.quit();

    }
}
