package testCase;

import Pages.P04_Wishlist;
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

public class T04_Wishlist {

    By wishlistloc =By.className("towishlist");

    public static ChromeDriver driver;
    P04_Wishlist WLocs = new P04_Wishlist();


    @Given("user open the browser")
    public void user_open_the_browser() {
        driver = new ChromeDriver();
    }

    @And("user open the website URL")
    public void user_open_the_website_URL() {
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @And("user scroll down to Hot Sellers Section")
    public void user_scroll_down_to_Hot_Sellers_Section() {
        boolean c1 = WLocs.HSellersLoc().getText().contains("Sellers");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(c1);
        soft.assertAll();
    }

    @When("user hover on any card")
    public void user_hover_on_any_card() {
        Actions act = new Actions(driver);
        act.moveToElement(WLocs.HoverCardLoc()).perform();
        WebDriverWait Expwait = new WebDriverWait(driver, Duration.ofSeconds(7));
        Expwait.until(ExpectedConditions.presenceOfElementLocated(wishlistloc));
    }

    @And ("user click on Add to Wishlist button")
    public void user_click_on_Add_to_Wishlist_button() {

        WLocs.AddtoWlLoc().click();

    }

    @Then ("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        boolean r = WLocs.LoginLoc().getText().contains("Login");
        SoftAssert ssoft = new SoftAssert();
        ssoft.assertTrue(r);
        ssoft.assertAll();
    }

    @And("user log in successfully")
    public void user_log_in_successfully() {
        WLocs.SignInLoc().click();
        WLocs.UsernameLoc().sendKeys("sandra.sgorgi@gmail.com");
        WLocs.PasswordLoc().sendKeys("12345StrongPassword");
        WLocs.LoginButtonLoc().click();
    }

    @Then ("user should be navigated to My Wishlist page with the same product added to Wishlist from landing page")
    public void user_should_be_navigated_to_My_Wishlist_page_with_the_same_product_added_to_Wishlist_from_landing_page() {
        boolean s = WLocs.MyWishListLoc().isDisplayed();
        SoftAssert ysoft = new SoftAssert();
        ysoft.assertTrue(s);
        ysoft.assertAll();

        boolean h = WLocs.HoverCardLoc().isDisplayed();
        SoftAssert zsoft = new SoftAssert();
        zsoft.assertTrue(h);
        zsoft.assertAll();
    }

    }




