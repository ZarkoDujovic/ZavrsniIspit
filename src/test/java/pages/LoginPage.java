package pages;
import models.User;
import org.example.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public ChromeDriver driver;

    public LoginPage (ChromeDriver driver){
        this.driver = driver;}

    public void openPage(){
        driver.get(Url.urlLoginPage);
    }

    public void setUsername(String username){

        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

    }

    public void clicLoginButton(){
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
    }


    public void login(User user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        clicLoginButton();


    }


}