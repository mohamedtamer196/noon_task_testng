import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountSignInLink() {
        WebElement accountLink = driver.findElement(By.xpath("//a[@id='accountNav']"));
        accountLink.click();
        WebElement signInLink = driver.findElement(By.xpath("//a[@data-qa='account-signin-link']"));
        signInLink.click();
    }

    public void clickCreateAccountLink() {
        WebElement createAccountLink = driver.findElement(By.xpath("//a[@data-qa='create-account-link']"));
        createAccountLink.click();
    }
    public void hoverFashionMenu() {
        WebElement fashionMenu = driver.findElement(By.xpath("//span[text()='Fashion']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fashionMenu).perform();
    }

    public void clickShirtsSubMenu() {
        WebElement shirtsSubMenu = driver.findElement(By.xpath("//a[contains(text(), 'Shirts')]"));
        shirtsSubMenu.click();
    }

}

