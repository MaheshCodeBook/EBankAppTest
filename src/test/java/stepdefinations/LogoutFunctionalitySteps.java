package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogoutFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And("I click the Logout button of the Home page")
    public void iClickOnLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        driver.findElement(By.className("logout-button")).click();
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        String expectedUrl = "https://qaebank.ccbp.tech/ebank/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}
