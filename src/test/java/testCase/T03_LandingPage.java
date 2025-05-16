package testCase;

import Pages.P03_LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class T03_LandingPage {
    By AddToCartLoc=By.xpath("//span[text()=\"Add to Cart\"]");
    public static ChromeDriver driver;
    P03_LandingPage LLocs = new P03_LandingPage();

    @Given("user opens the browser")
    public void user_opens_the_browser() {
        driver = new ChromeDriver();
    }

    @And("user opens the website URL")
    public void user_opens_the_website_URL() {
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @When("user scrolls down to Hot Sellers Section")
    public void user_scrolls_down_to_Hot_Sellers_Section() {
        boolean c1 = LLocs.HotSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(c1);

    }

    @Then("user observe each card should display price in $ and as Double not Integer")
    public void user_observe_each_card_should_display_price_in_$_and_as_Double_not_Integer() {
        for (int i = 0; i < 6; i++) {
            boolean c2 = driver.findElements(By.className("price-final_price")).get(i).getText().contains("$");
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(c2);
        }
    }

    @Then("user observe each card should display Add to Cart button and it should be clickable")
    public void user_observe_each_card_should_display_Add_to_Cart_button_and_it_should_be_clickable() {
        for (int y = 0; y < 6; y++) {
            boolean c2 = driver.findElements(By.className("tocart")).get(y).isDisplayed();
            SoftAssert zsoft = new SoftAssert();
            zsoft.assertTrue(c2);
            zsoft.assertAll();
        }

    }

    @When("user hover on Card Breathe Easy Tank")
    public void user_hover_on_Card_Breathe_Easy_Tank() {
        Actions act = new Actions(driver);
        act.moveToElement(LLocs.HoverOnBreatheEasyLoc()).perform();
        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(AddToCartLoc));

    }

    @And("user Select Size M")
    public void user_Select_Size_M() {

        LLocs.SelectSizeLoc().click();
    }

    @And("user select color")
    public void user_select_color() {
        LLocs.SelectColorLoc().click();
    }

    @And("user Click on Add to Cart button")
    public void user_Click_on_Add_to_Cart_button() {
        LLocs.AddToCartLoc().click();
    }

    @Then("Product should be added to cart successfully and Cart icon should display number 1")
    public void Product_should_be_added_to_cart_successfully_and_Cart_icon_should_display_number_1() {
        LLocs.ShoppingCartLoc().click();
        boolean s=LLocs.HoverOnBreatheEasyLoc().getText().contains("Breathe");
        SoftAssert ssoft = new SoftAssert();
        ssoft.assertTrue(s);

        boolean e=LLocs.CartIconCounterLoc().getText().contains("1");
        ssoft.assertTrue(e);
        ssoft.assertAll();
    }
}




