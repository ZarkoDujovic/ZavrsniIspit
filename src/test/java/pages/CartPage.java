package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {

    public ChromeDriver driver;

    public CartPage(ChromeDriver driver){
        this.driver = driver;
    }

    public void clickOnCheckoutButton(){
        driver.findElement(By.xpath("//button[@data-test='checkout']")).click();
    }
}
