package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sample_Selenium_Test {

    private static WebDriver webdriver;
    private static ChromeOptions chromeOptions;


    @BeforeClass
    public void launchWhatsAppWeb(){
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

    }

    @Test
    public void verifyPageTitle(){

        try {
            webdriver = new ChromeDriver(chromeOptions);
            webdriver.get("https://web.whatsapp.com/");
            Assert.assertTrue(webdriver.getTitle().equals("WhatsApp Web"),"Pass");
            System.out.println("Pass");

        }catch(Exception e){
            e.getMessage();
        }finally {
            webdriver.close();
            System.out.println("Closed Driver Instance");
        }
    }


    @Test
    public void verifyLogin(){

        try {
            webdriver = new ChromeDriver(chromeOptions);
            webdriver.get("https://web.whatsapp.com/");
            webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebElement element = webdriver.findElement(By.xpath("//div[@class='b77wc']/span"));
            Assert.assertTrue(element.isDisplayed(),"Pass");
            System.out.println("Pass");

        }catch(Exception e){
            e.getMessage();
        }finally {
            webdriver.close();
            System.out.println("Closed Driver Instance");
        }
    }

    @AfterClass
    public void tearDown(){
        if (webdriver !=null)
        webdriver.quit();
    }
}
