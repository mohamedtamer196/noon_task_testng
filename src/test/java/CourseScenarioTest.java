import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CourseScenarioTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ShirtsPage shirtsPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        shirtsPage = new ShirtsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1)
    public void createAccount() {
        driver.get("https://www.noon.com/egypt-en/");
        homePage.clickAccountSignInLink();
        homePage.clickCreateAccountLink();

        String username = "mohamed";
        String password = "password123";
        String firstName = "mohamed";
        String lastName = "tamer";
        String email = "mohamed@gmail.com";

        registrationPage.fillRegistrationData(username, password, firstName, lastName, email);
        registrationPage.submitRegistrationForm();

        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Test(priority = 2)
    public void addItemsToCartAndVerifySubtotal() {
        homePage.hoverFashionMenu();
        homePage.clickShirtsSubMenu();

        shirtsPage.addToCart(2);

        shirtsPage.goToCart();
        cartPage.increaseQuantity(1);

        Assert.assertTrue(cartPage.isItemInCart());

        double expectedSubtotal = shirtsPage.getItemPrice() * 3; // Assuming each item costs the same
        Assert.assertEquals(cartPage.getSubtotal(), expectedSubtotal);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
