package Test;

import resources.Credentials;
import models.User;
import models.UserInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import resources.Items;

public class VerifyPriceTotal {
    @Test
    public void verifyPriceTotal(){
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        loginPage.openPage();
        User standardUser = new User(Credentials.userName, Credentials.password);
        loginPage.login(standardUser);

        productsPage.addProductTocart(Items.backpack);
        productsPage.addProductTocart(Items.bikeLight);
        productsPage.addProductTocart(Items.tShirt);
        productsPage.openCartPage();

        cartPage.clickOnCheckoutButton();

        UserInfo userInfo = new UserInfo(Credentials.firstName, Credentials.lastName, Credentials.postalCode);
        checkoutYourInformationPage.setUserInfo(userInfo);

        checkoutOverviewPage.totalPrice();
        checkoutOverviewPage.sumOfPricesAndTaxes();

        String sumOfPricesAndTax = checkoutOverviewPage.sumOfPricesAndTaxes().toString();
        String actualTotalPrice = checkoutOverviewPage.totalPrice().toString();
        Assert.assertEquals(actualTotalPrice,sumOfPricesAndTax,"The sum of the prices of all products and taxes is not the same as the total price");

        checkoutOverviewPage.closePage();

    }


}
