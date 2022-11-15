package cps3230;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class WebScraperTests {

    WebScraper scraper;

    @BeforeEach
    public void setup() {
        scraper = new WebScraper();
    }

    @AfterEach
    public void teardown() { scraper = null; }

    @Test
    public void test() {
        //setup

        //Exercise

        //Verify

        //Teardown
    }

    @Test
    public void testGetDataWithNoValuesReturnsNull() {

        WebScraper mockWS = mock(WebScraper.class);
        String result = mockWS.GetData();
        Assertions.assertEquals(null, result);
    }

    @Test
    public void testGetTitlesReturnsNull() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getTitles(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getTitles(null));
    }

    @Test
    public void testGetDescsReturnsNull() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getDescs(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getDescs(null));
    }

    @Test
    public void testGetImagesReturnsNull() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getImages(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getImages(null));
    }

    @Test
    public void testGetLinksReturnsNull() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getLinks(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getLinks(null));
    }

    @Test
    public void testGetPricesReturnsNull() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getPrices(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getPrices(null));
    }

    @Test
    public void testGetTitlesReturnsEmptyList() {
        //Exercise
        String result = scraper.CheckTitles(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No Titles", result);

    }

    @Test
    public void testGetTitlesReturnsListOf5Strings() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4","title5");
        //Exercise
        String result = scraper.CheckTitles(list);
        //Verify
        Assertions.assertEquals("good", result);
    }

    @Test
    public void testGetTitlesReturnsListOf4Strings() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4");
        //Exercise
        String result = scraper.CheckTitles(list);
        //Verify
        Assertions.assertEquals("There were less or more then 5 Titles", result);
    }

    @Test
    public void testGetTitlesReturnsListOf6Strings() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4","title6","title7");
        //Exercise
        String result = scraper.CheckTitles(list);
        //Verify
        Assertions.assertEquals("There were less or more then 5 Titles", result);
    }

    @Test
    public void testGetDescsReturnsEmptyList() {
        //Exercise
        String result = scraper.CheckDesc(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No Descriptions", result);

    }

    @Test
    public void testGetDescsReturnsListOf5Strings() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4","desc5");
        //Exercise
        String result = scraper.CheckDesc(list);
        //Verify
        Assertions.assertEquals("good", result);
    }

    @Test
    public void testGetDescsReturnsListOf4Strings() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4");
        //Exercise
        String result = scraper.CheckDesc(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 Descriptions", result);
    }

    @Test
    public void testGetDescsReturnsListOf6Strings() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4","desc5","desc6");
        //Exercise
        String result = scraper.CheckDesc(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 Descriptions", result);
    }

    @Test
    public void testGetImagesReturnsEmptyList() {
        //Exercise
        String result = scraper.CheckImages(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No images", result);

    }

    @Test
    public void testGetImagesReturnsListOf5Strings() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4","image5");
        //Exercise
        String result = scraper.CheckImages(list);
        //Verify
        Assertions.assertEquals("good", result);
    }

    @Test
    public void testGetImagesReturnsListOf4Strings() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4");
        //Exercise
        String result = scraper.CheckImages(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 images", result);
    }

    @Test
    public void testGetImagesReturnsListOf6Strings() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4","image5","image6");
        //Exercise
        String result = scraper.CheckImages(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 images", result);
    }

    @Test
    public void testGetLinksReturnsEmptyList() {
        //Exercise
        String result = scraper.CheckLinks(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No links", result);

    }

    @Test
    public void testGetLinksReturnsListOf5Strings() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4","link5");
        //Exercise
        String result = scraper.CheckLinks(list);
        //Verify
        Assertions.assertEquals("good", result);
    }

    @Test
    public void testGetLinksReturnsListOf4Strings() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4");
        //Exercise
        String result = scraper.CheckLinks(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 links", result);
    }

    @Test
    public void testGetLinksReturnsListOf6Strings() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4","link5","link6");
        //Exercise
        String result = scraper.CheckLinks(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 links", result);
    }

    @Test
    public void testGetPricesReturnsEmptyList() {
        //Exercise
        String result = scraper.CheckPrices(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No prices", result);

    }

    @Test
    public void testGetPricesReturnsListOf5Strings() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //Exercise
        String result = scraper.CheckPrices(list);
        //Verify
        Assertions.assertEquals("good", result);
    }

    @Test
    public void testGetPricesReturnsListOf4Strings() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4);
        //Exercise
        String result = scraper.CheckPrices(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 prices", result);
    }

    @Test
    public void testGetPricesReturnsListOf6Strings() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        //Exercise
        String result = scraper.CheckPrices(list);
        //Verify
        Assertions.assertEquals("There were more or less than 5 prices", result);
    }

    @Test
    public void testAddCharToStringWithString() {
        //setup;
        String string = "asd23r4";
        char ch = 'd';

        //Exercise
        String result = scraper.addCharToString(string, ch);

        //Verify
        Assertions.assertEquals("asd23r4d", result);
    }

    @Test
    public void testAddCharToStringWithEmptyString() {
        //setup;
        String string = "";
        char ch = 'a';

        //Exercise
        String result = scraper.addCharToString(string, ch);

        //Verify
        Assertions.assertEquals("a", result);
    }

    @Test
    public void testProcessPriceWithExpectedStringType() {
        //setup
        String string = "€4,894.06";

        //Exercise
        int result = scraper.processPrice(string);

        //Verify
        Assertions.assertEquals(489406, result);
    }

    @Test
    public void testProcessPriceWithRandomStringType() {
        //setup
        String string = "f3N65'#f63gsdg542";

        //Exercise
        int result = scraper.processPrice(string);

        //Verify
        Assertions.assertEquals(36563542, result);
    }

    @Test
    public void testProcessPriceWithWithIntegerString() {
        //setup
        String string = "4325";

        //Exercise
        int result = scraper.processPrice(string);

        //Verify
        Assertions.assertEquals(4325, result);
    }

    @Test
    public void testProcessPriceWithWithEmptyString() {
        //setup
        String string = "";

        //Exercise
        int result = scraper.processPrice(string);

        //Verify
        Assertions.assertEquals(0, result);
    }
}
