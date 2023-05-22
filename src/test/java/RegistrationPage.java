import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationData(String username, String password, String firstName, String lastName, String email) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys(email);
    }

    public void submitRegistrationForm() {
        WebElement submitButton = driver.findElement(By.xpath("//button[@data-qa='register-button']"));
        submitButton.click();
    }
}
