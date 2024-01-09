package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductsPage {

    public ChromeDriver driver;

    public ProductsPage (ChromeDriver driver){
        this.driver = driver;
    }

    public void addProductTocart(String productName) {
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));

        List<WebElement> inventoryItems = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));

        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement item = inventoryItems.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));

            if (itemName.getText().equals(productName)) {
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                break;



            }
        }
    }

    public void openCartPage(){
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }



}