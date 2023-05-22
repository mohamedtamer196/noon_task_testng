import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void increaseQuantity(int quantity) {
        WebElement quantityInput = driver.findElement(By.xpath("//input[@data-qa='quantity-input']"));
        String currentQuantityText = quantityInput.getAttribute("value");
        int currentQuantity = Integer.parseInt(currentQuantityText);
        int remainingQuantity = quantity - currentQuantity;

        for (int i = 0; i < remainingQuantity; i++) {
            WebElement increaseButton = driver.findElement(By.xpath("//button[@data-qa='quantity-increase']"));
            increaseButton.click();
        }
    }

    public boolean isItemInCart() {
        List<WebElement> itemsInCart = driver.findElements(By.xpath("//div[@data-qa='cart-item']"));
        return itemsInCart.size() > 0;
    }

    public double getSubtotal() {
        WebElement subtotalElement = driver.findElement(By.xpath("//span[@data-qa='subtotal-value']"));
        String subtotalText = subtotalElement.getText();
        double subtotal = Double.parseDouble(subtotalText.replace("EGP", "").trim());
        return subtotal;
    }
}
