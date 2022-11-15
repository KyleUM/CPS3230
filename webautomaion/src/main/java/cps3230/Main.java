package cps3230;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws UnirestException, InterruptedException {


        System.out.println("==================================================");
        System.out.println("=============To add 5 alerts press 1==============");
        System.out.println("===========To delete the alerts press 2===========");
        System.out.println("==================================================");

        int answer = menuChoice();

        if (answer == 1) {
            WebScraper webScraper = new WebScraper();
            webScraper.GetData();
            webScraper.SendData();
            webScraper.teardown();
        }
        else if (answer == 2) {
            RestHandling rest = new RestHandling();
            rest.DeleteAlerts();
        }
        else {
            System.out.println("invalid input ... terminating program");
        }
    }

    static int menuChoice() {
        Scanner s = new Scanner(System.in);
        System.out.print("answer: ");
        int answer = s.nextInt();
        return answer;
    }

//    public static void main (String[] args) throws UnirestException, InterruptedException {
//
//        WebDriver driver;
//
//        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
//        driver = new ChromeDriver();
//
//        driver.get("https://www.scanmalta.com/shop/catalogsearch/result/?q=laptops");
//
//        WebElement elements = driver.findElement(By.cssSelector(".products.wrapper.product-list-style-04.grid.products-grid"));
//        System.out.println(elements);
//        List<WebElement> titleList = elements.findElements(By.xpath("(//a[@class='product-item-link'])[position() < 6]"));
//        System.out.println(titleList);
//    }

}



