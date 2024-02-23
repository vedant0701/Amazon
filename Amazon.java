package org.example;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;



public class Amazon {
    private WebDriver driver;

    @FindBy(id = "APjFqb")
    private WebElement Chrome;

    @FindBy(partialLinkText = "Shop online at Amazon India")
    private WebElement ClickAmazon;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(id = "ap_email")
    private WebElement EmailorNumber;

    @FindBy(id = "ap_password")
    private WebElement Strongpassword;

    public Amazon (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchforamazon(String Website) {
        Chrome.sendKeys(Website);
        Chrome.sendKeys(Keys.ENTER);

    }
    public void Click(String ClickLink) {
        ClickAmazon.click();
    }


    public void searchforProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
    }

    public void Signintoaccount(String SignIn) {
        EmailorNumber.sendKeys(SignIn);
    }

//        ap_password
    public void EnterPassword(String password) {
        Strongpassword.sendKeys(password);
    }



}
