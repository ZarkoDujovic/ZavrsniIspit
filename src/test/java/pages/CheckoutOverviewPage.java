package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.CheckoutPagePath;
import resources.Items;

import java.util.List;

public class CheckoutOverviewPage {
    public ChromeDriver driver;

    public CheckoutOverviewPage(ChromeDriver driver) {
        this.driver = driver;
    }


    public Double returnOneItemPrice(String productName){
        Double prices = 0.0;

        WebElement inventoryList = driver.findElement(By.xpath(CheckoutPagePath.cartList));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath(CheckoutPagePath.cartItem));

        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name']"));
            if (itemName.getText().equals(productName)) {
                WebElement price = inventoryItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_price']"));
                String priceValue = price.getText();
                Double priceValueDouble = Double.parseDouble(priceValue.substring(1));
                prices = priceValueDouble;
                //System.out.println(priceValueDouble);

            }
        }
        return prices;
    }

    public Double returnTaxPrice(){
        Double tax = 0.0;
        WebElement summaryInfo = driver.findElement(By.xpath(CheckoutPagePath.summaryInfo));
        WebElement taxValue = summaryInfo.findElement(By.xpath(CheckoutPagePath.taxLabel));
        String taxText = taxValue.getText();
        Double taxDouble = Double.parseDouble(taxText.substring(6));
        //System.out.println("Taxa" + taxDouble);
        tax = taxDouble;



        return tax;
    }

    public Double sumOfPricesAndTaxes(){
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Double[] prices = {checkoutOverviewPage.returnOneItemPrice(Items.backpack), checkoutOverviewPage.returnOneItemPrice(Items.bikeLight), checkoutOverviewPage.returnOneItemPrice(Items.tShirt), checkoutOverviewPage.returnTaxPrice()};
        Double sum = 0.0;
        for (Double num : prices) {
            sum += num;
        }
        //System.out.println("Total price je " + " " + sum);
        return sum;

    }

    public Double totalPrice(){
        Double totalPrice = 0.0;


        WebElement summaryInfo = driver.findElement(By.xpath(CheckoutPagePath.summaryInfo));
        WebElement totalPriceValue = summaryInfo.findElement(By.xpath(CheckoutPagePath.totalPriceLabel));
        String totalPriceValueText = totalPriceValue.getText();
        Double totalPriceValueDouble = Double.parseDouble(totalPriceValueText.substring(8));
        totalPrice = totalPriceValueDouble;
        //System.out.println(totalPrice);

        return totalPrice;
    }

    public void closePage (){
        driver.quit();
    }
}

