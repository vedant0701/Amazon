package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Product {
    public static void main(String[] args) {


//        String userDataDir = "/Users/vedantnaik/Library/Application Support/Google/Chrome/";
//
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("--user-data-dir=" + userDataDir);
//        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.in");

        Amazon Search = new Amazon(driver);
        Search.searchforamazon("amazon.in");

        Amazon click = new Amazon(driver);
        click.Click("Amazon.in");

        Amazon homepage = new Amazon(driver);
        homepage.searchforProduct("laptop");

        SearchResults results = new SearchResults(driver);
        results.ClickOnProduct("HP Laptop 15s");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);");


        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);


        }
        SearchResults Add = new SearchResults(driver);
        Add.clickAddToCart();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        SearchResults Proceed = new SearchResults(driver);
        Proceed.ProceedToCheckout();

        Amazon Signin = new Amazon(driver);
        Signin.Signintoaccount("+918788070164");

        WebElement Continue = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[2]/span/span/input"));
        Continue.click();

        Amazon Password = new Amazon(driver);
        Password.EnterPassword("Vedant@0701");

        WebElement SignIn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/span/span/input"));
        SignIn.click();

        System.out.println("Order Placed");

        driver.quit();

    }

}

