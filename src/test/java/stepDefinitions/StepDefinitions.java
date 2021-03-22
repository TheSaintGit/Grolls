package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private WebDriver driver;
    @Given("I have selected size small")
    public void i_have_also_selected_size_small()  throws InterruptedException {
            // Optional. If not specified, WebDriver searches the PATH for chromedriver.
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\nv95j\\OneDrive\\Skrivbord\\Selenium\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
            driver.manage().window().maximize();
        Select sizedrop = new Select(driver.findElement(By.name("super_attribute[400]")));
        sizedrop.selectByValue("1419");
        Thread.sleep(2000);



    }

    @Given("I have also selected {int} T-shirt")
    public void i_have_selected_t_shirt_on_grolls(Integer int1)  throws InterruptedException{
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement plusbut = driver.findElement(By.cssSelector("input.input-text.qty"));
        plusbut.clear();
        plusbut.sendKeys(String.valueOf(int1));

        //plusbut.click();

    }

    @When("I press cart")
    public void i_press_add() throws InterruptedException{
        WebElement cartbut = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span"));
        cartbut.click();
        Thread.sleep(2000);

    }

    @Then("the result should be {int} small T-shirts in the basket")
    public void the_result_should_be_small_t_shirts_in_the_basket(Integer int1) throws InterruptedException{
       WebElement result=driver.findElement(By.xpath("/html/body/div[4]/header/div[3]/div[4]/div/div/div/div[2]/div[4]/div/ol/li/div/div/div[3]/div[2]/input"));
        assertEquals(String.valueOf(int1),result.getAttribute("value"));
        Thread.sleep(2000);  // Let the user actually see something!
        driver.quit();


    }

}
