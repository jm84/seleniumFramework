package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe" );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    /*
    @After
    public void tearDown(){
        driver.quit();
    }
    */
    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("AutoFN" + generateRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("Molina");

    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name=\"email\"]"))
              .sendKeys("AutoEmail"+ generateRandomNumber(4) + "@mail.com" );
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//textarea[@name=\"message\"]"))
                .sendKeys("AutoComment" + generateRandomString(5) + " :" + "Comment");
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
    }
    @Then("I should be presented with a successfull contact us submission message")
    public void i_should_be_presented_with_a_successfull_contact_us_submission_message() {
        // Write code here that turns the phrase above into concrete actions
        WebElement contactUs_Submission_Message = driver
                .findElement(By.xpath("//div[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText() , "Thank You for your Message!" );

    }
}
