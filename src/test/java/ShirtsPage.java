import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShirtsPage {
    private WebDriver driver;

    public ShirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(int quantity) {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-qa='add-to-cart-button']"));
        for (int i = 0; i < quantity; i++) {
            addToCartButton.click();
        }
    }

    public double getItemPrice() {
        WebElement priceElement = driver.findElement(By.xpath("//span[@data-qa='price']"));
        String priceText = priceElement.getText();
        double price = Double.parseDouble(priceText.replace("EGP", "").trim());
        return price;
    }

    public void goToCart() {
        WebElement cartIcon = driver.findElement(By.xpath("//a[@data-qa='cart-icon']"));
        cartIcon.click();
    }
}
