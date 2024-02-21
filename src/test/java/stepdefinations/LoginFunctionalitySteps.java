package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinations.Hooks;

import java.time.Duration;

public class LoginFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://qaebank.ccbp.tech/ebank/login");
    }

    @When("I click on the login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.className("login-button")).click();
    }

    @Then("an error message 'Invalid user ID' should be visible")
    public void verifyInvalidUserErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text"))).getText();
        Assert.assertEquals(actualText, "Invalid user ID");
    }

    @When("I enter a valid PIN")
    public void iEnterValidPin() {
        driver.findElement(By.id("pinInput")).sendKeys("231225");
    }

    @When("I enter a valid User ID")
    public void iEnterValidUserId() {
        driver.findElement(By.id("userIdInput")).sendKeys("142420");
    }

    @Then("an error message 'Invalid PIN' should be visible")
    public void verifyInvalidPinErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text"))).getText();
        Assert.assertEquals(actualText, "Invalid PIN");
    }

    @And("I enter an invalid PIN")
    public void iEnterInvalidPin() {
        driver.findElement(By.id("pinInput")).sendKeys("123456");
    }

    @Then("an error message 'User ID and PIN didn't match' should be visible")
    public void verifyInvalidInputsErrorText() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text"))).getText();
        Assert.assertEquals(actualText, "User ID and PIN didn't match");
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomePage() {
        String expectedUrl = "https://qaebank.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}