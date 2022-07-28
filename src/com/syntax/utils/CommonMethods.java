package com.syntax.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
    WebDriver driver = new ChromeDriver();
    public void openBrowser(String url) {
        driver.get(url);
    }

    public void quitBrowser(){
        driver.quit();
    }
}
