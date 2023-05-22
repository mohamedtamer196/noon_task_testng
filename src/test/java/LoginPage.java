import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isLoginSuccessful() {
        // Implement the logic to check if the login is successful
        // Return true if the login is successful, otherwise return false
        // You can check for any element or condition on the page that indicates a successful login
        // For example, you can check for the presence of a welcome message or a logged-in user's profile element
        return driver.findElement(By.xpath("//span[@data-qa='welcome-message']")).isDisplayed();
    }


    public boolean login(String email, String password) {
        // Implement the logic to enter the email and password and click the login button
        // Return true if the login is successful, otherwise return false
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='sign-in-button']"));
        loginButton.click();

        // Check if the login is successful and return the result
        return isLoginSuccessful();
    }
}
