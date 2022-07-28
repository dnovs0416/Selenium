package com.syntax.class08;

import com.syntax.utils.CommonMethods;

public class Task2 {
    /*
    create a package and name it as utils
    create a class and name as CommonMethods
    create functions (methods) to open and quit the browsers
    open method has to accept a url as a parameter
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        CommonMethods commonMethods = new CommonMethods();
        commonMethods.openBrowser("https:www.bestbuy.com");
        commonMethods.quitBrowser();
    }

}
