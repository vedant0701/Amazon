package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResults {
    private WebDriver driver;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
    }



    public void ClickOnProduct(String productTitle) {
        WebElement productElement = driver.findElement(By.xpath("//span[starts-with(text(), '" + productTitle + "')]"));
        productElement.click();
    }

    public void clickAddToCart() {
        try {
            By addToCartLocator = By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[39]/div[1]/span/span/span/input");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));

            if (addToCartButton.isDisplayed() && addToCartButton.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

                addToCartButton.click();

                String mainWindowHandle = driver.getWindowHandle();
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(mainWindowHandle)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }
            } else {
                throw new NoSuchElementException("Add to Cart button is not visible or enabled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ProceedToCheckout() {
        try {
            By proceedToCheckoutLocator = By.xpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/span/span/input");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutLocator));

            proceedToCheckoutButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
