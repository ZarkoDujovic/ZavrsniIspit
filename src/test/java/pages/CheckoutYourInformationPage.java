package pages;

import models.UserInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutYourInformationPage {
    public ChromeDriver driver;

    public CheckoutYourInformationPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys(firstName);
    }

    public void setLastName(String password) {
        driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys(password);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(By.xpath("//input[@data-test='postalCode']")).sendKeys(postalCode);
    }

    public void clickOnContinueButton() {
        driver.findElement(By.xpath("//input[@data-test='continue']")).click();
    }

    public void setUserInfo(UserInfo userInfo) {
        setFirstName(userInfo.getFirstName());
        setLastName(userInfo.getLastName());
        setPostalCode(userInfo.getPostalCode());
        clickOnContinueButton();

    }
}





