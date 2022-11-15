package cps3230;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class WebScraper {

    WebDriver driver;
    RestHandling rest = new RestHandling();
    List<String> titles = new ArrayList<>();
    List<String> descriptions = new ArrayList<>();
    List<String> images = new ArrayList<>();
    List<String> links = new ArrayList<>();
    List<Integer> prices = new ArrayList<>();

    public void teardown() {
        driver.close();
    }

    public WebElement DriverSetup() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.scanmalta.com/shop/catalogsearch/result/?q=laptops");

        return driver.findElement(By.cssSelector(".products.wrapper.product-list-style-04.grid.products-grid"));
    }
    public String GetData() {

        WebElement elements = DriverSetup();

        // Title
        List<WebElement> titleList = getTitles(elements);
        titleList.forEach(title -> titles.add(title.getText()));
        if (CheckTitles(titles) != "good"){
            return CheckTitles(titles);
        }

        // Description
        List<WebElement> descList = getDescs(elements);
        descList.forEach(desc -> descriptions.add(desc.getText()));
        if (CheckDesc(descriptions) != "good"){
            return CheckDesc(descriptions);
        }

        //Image
        List<WebElement> imageSegments = getImages(elements);
        for (int i = 0; i <= 4; i++){
            images.add(imageSegments .get(i).getAttribute("src"));
        }
        if (CheckImages(images) != "good"){
            return CheckImages(images);
        }

        //link
        List<WebElement> linkSegments = getLinks(elements);
        for (int i = 0; i <= 4; i++){
            links.add(linkSegments.get(i).getAttribute("href"));
        }
        if (CheckImages(links) != "good"){
            return CheckImages(links);
        }

        //price
        List<WebElement> priceList = getPrices(elements);
        priceList.forEach(price -> prices.add(processPrice(price.getText())));
        if (CheckPrices(prices) != "good"){
            return CheckPrices(prices);
        }

        return "Success";

    }

    public void SendData() throws UnirestException {
        rest.AddAlert(rest.CreateJsonObject(titles.get(0), descriptions.get(0), images.get(0), links.get(0), prices.get(0)));
        rest.AddAlert(rest.CreateJsonObject(titles.get(1), descriptions.get(1), images.get(1), links.get(1), prices.get(1)));
        rest.AddAlert(rest.CreateJsonObject(titles.get(2), descriptions.get(2), images.get(2), links.get(2), prices.get(2)));
        rest.AddAlert(rest.CreateJsonObject(titles.get(3), descriptions.get(3), images.get(3), links.get(3), prices.get(3)));
        rest.AddAlert(rest.CreateJsonObject(titles.get(4), descriptions.get(4), images.get(4), links.get(4), prices.get(4)));
    };

    public List<WebElement> getTitles(WebElement elements) {
        return elements.findElements(By.xpath("(//a[@class='product-item-link'])[position() < 6]"));
    }

    public List<WebElement> getDescs(WebElement elements) {
        return elements.findElements(By.xpath("(//span[@class='value'])[position() < 6]"));
    }

    public List<WebElement> getImages(WebElement elements) {
        return elements.findElements(By.cssSelector(".product-image-photo.main-img"));
    }

    public List<WebElement> getLinks(WebElement elements) {
        return elements.findElements(By.cssSelector(".product.photo.product-item-photo"));
    }

    public List<WebElement> getPrices(WebElement elements) {
        return elements.findElements(By.xpath("(//span[@class='special-price'])[position() < 6]"));
    }

    public int processPrice (String str){
        String intString = "";
        if (str.equals("")){
            return 0;
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    intString = addCharToString(intString, ch);
                }
            }
            return Integer.parseInt(intString);
        }
    }

    public String addCharToString(String str, char c) {
        return str + c;
    }

    public String CheckTitles(List<String> titleList) {
        if (titleList.size() == 0){
            return "No Titles";
        }
        if (titleList.size() != 5){
            return "There were less or more then 5 Titles";
        }
        return "good";
    }

    public String CheckDesc (List<String> descList) {
        if (descList.size() == 0){
            return "No Descriptions";
        }
        if (descList.size() != 5){
            return "There were more or less than 5 Descriptions";
        }
        return "good";
    }

    public String CheckImages(List<String> imageList) {
        if (imageList.size() == 0){
            return "No images";
        }
        if (imageList.size() != 5){
            return "There were more or less than 5 images";
        }
        return "good";
    }

    public String CheckLinks(List<String> linkList) {
        if (linkList.size() == 0){
            return "No links";
        }
        if (linkList.size() != 5){
            return "There were more or less than 5 links";
        }
        return "good";
    }

    public String CheckPrices(List<Integer> priceList) {
        if (priceList.size() == 0){
            return "No prices";
        }
        if (priceList.size() != 5){
            return "There were more or less than 5 prices";
        }
        return "good";
    }

}

