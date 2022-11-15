package CucumberTests;

import com.mashape.unirest.http.exceptions.UnirestException;
import cps3230.RestHandling;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MarketUMValidation {

    WebDriver driver;
    RestHandling rest = new RestHandling();

    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/Alerts/Login");
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        driver.findElement(By.id("UserId")).sendKeys("abd230b1-3908-46a5-9ca7-36f4464198b7");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        WebElement title = driver.findElement(By.tagName("h1"));
        Assertions.assertEquals("Latest alerts for Kyle Borg", title.getText());
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {
        driver.findElement(By.id("UserId")).sendKeys("abd230b1-3908-46a5-9ca7-36f4764198b7tf");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        List<WebElement> formButton = driver.findElements(By.xpath("//input[@type='submit']"));
        Assertions.assertEquals(1, formButton.size());
    }

    @Given("I am an administrator of the website and I upload {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAlerts(int arg0) throws UnirestException {
        rest.DeleteAlerts();
        JSONObject json = new JSONObject();
        json.put("alertType", 6);
        json.put("heading", "A title");
        json.put("description", "A Description");
        json.put("url", "https://www.google.com/");
        json.put("imageURL", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.petco.com%2Fcontent%2Fpetco%2FPetcoStore%2Fen_US%2Fpet-services%2Fresource-center%2Fcaresheets%2Ftree-frogs.html&psig=AOvVaw22kyBcrdDzVA_9oUNcqP7G&ust=1668454486170000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLiFxLjzq_sCFQAAAAAdAAAAABAD");
        json.put("postedBy", "abd230b1-3908-46a5-9ca7-36f4464198b7");
        json.put("priceInCents", 12345);

        for(int i = 0; i < 3; i++){
            rest.AddAlert(json);
        }
    }

    @When("I view a list of alerts")
    public void iViewAListOfAlerts() {
        driver.findElement(By.id("UserId")).sendKeys("abd230b1-3908-46a5-9ca7-36f4464198b7");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        List<WebElement> iconList = driver.findElements(By.xpath("//img[@src='/images/icon-electronics.png']"));
        Assertions.assertEquals(3, iconList.size());
    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
        List<WebElement> titleList = driver.findElements(By.tagName("h4"));
        Assertions.assertEquals(3, titleList.size());
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
        List<WebElement> imageList = driver.findElements(By.xpath("//img[@width='200']"));
        Assertions.assertEquals(3, imageList.size());
    }

    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
        List<WebElement> descriptionList = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assertions.assertEquals(3, descriptionList.size());
    }

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        List<WebElement> priceList = driver.findElements(By.xpath("//tbody/tr[4]/td/b"));
        Assertions.assertEquals(3, priceList.size());
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        List<WebElement> linkList = driver.findElements(By.xpath("//tbody/tr[5]/td/a"));
        Assertions.assertEquals(3, linkList.size());
    }

    @Given("I am an administrator of the website and I upload more than {int} alerts")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadMoreThanAlerts(int arg0) throws UnirestException {
        rest.DeleteAlerts();
        JSONObject json = new JSONObject();
        json.put("alertType", 6);
        json.put("heading", "A title");
        json.put("description", "A Description");
        json.put("url", "https://www.google.com/");
        json.put("imageURL", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.petco.com%2Fcontent%2Fpetco%2FPetcoStore%2Fen_US%2Fpet-services%2Fresource-center%2Fcaresheets%2Ftree-frogs.html&psig=AOvVaw22kyBcrdDzVA_9oUNcqP7G&ust=1668454486170000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLiFxLjzq_sCFQAAAAAdAAAAABAD");
        json.put("postedBy", "abd230b1-3908-46a5-9ca7-36f4464198b7");
        json.put("priceInCents", 12345);

        for(int i = 0; i < 10; i++){
            rest.AddAlert(json);
        }
    }

    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
        List<WebElement> alertList = driver.findElements(By.tagName("table"));
        Assertions.assertEquals(arg0, alertList.size());
    }

    @And("the icon displayed should be <icon file name>")
    public void theIconDisplayedShouldBeIconFileName() {
        List<WebElement> alertList = driver.findElements(By.xpath("//img[width='100']/@src"));
    }

    @Given("I am an administrator of the website and I upload an alert of type {int}")
    public void iAmAnAdministratorOfTheWebsiteAndIUploadAnAlertOfType(int arg0) throws UnirestException {
        rest.DeleteAlerts();
        JSONObject json = new JSONObject();
        json.put("alertType", arg0);
        json.put("heading", "A title");
        json.put("description", "A Description");
        json.put("url", "https://www.google.com/");
        json.put("imageURL", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.petco.com%2Fcontent%2Fpetco%2FPetcoStore%2Fen_US%2Fpet-services%2Fresource-center%2Fcaresheets%2Ftree-frogs.html&psig=AOvVaw22kyBcrdDzVA_9oUNcqP7G&ust=1668454486170000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCLiFxLjzq_sCFQAAAAAdAAAAABAD");
        json.put("postedBy", "abd230b1-3908-46a5-9ca7-36f4464198b7");
        json.put("priceInCents", 12345);

        rest.AddAlert(json);
    }
}
