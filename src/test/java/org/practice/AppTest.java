package org.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AppTest {

    static WebDriver driver;
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        AppTest appTest = new AppTest();
        appTest.launchAWebPage(driver, "https://the-internet.herokuapp.com/");

        appTest.addRemoveTheElement(driver);

        appTest.closeTheLaunchedBrowser(driver);
    }

    private void addRemoveTheElement(WebDriver driver) {
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.id("elements")).isDisplayed();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
    }

    private void launchAWebPage(WebDriver driver, String url){
        driver.get(url);
        driver.manage().window().maximize();
    }



    private void closeTheLaunchedBrowser(WebDriver driver){
        driver.quit();
    }


}
