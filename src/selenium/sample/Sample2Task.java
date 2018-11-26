package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Sample2Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByID() throws Exception {
//         TODO:
//         get text "Heading 2 text" using id
        System.out.println(driver.findElement(By.id("Heading 2 text")).getText());
//        <h2 id="heading_2">Heading 2 text</h2>
    }

    @Test
    public void findElementByName() throws Exception {
//         TODO:
//         get attribute "id" and "value" of button "This is also a button" using name
//        <input type="button" id="buttonId" value="This is also a button" name="randomButton2">

        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("id")); // "This is a button"
        System.out.println(driver.findElement(By.name("randomButton2")).getAttribute("value")); // "button"

    }

    @Test
    public void findElementByClassFirst() throws Exception {
//         TODO:
//         get first text of class "test" (should be "Test Text 1")
        System.out.println(driver.findElement(By.className("test")).getText()); // "sample text 1"
    }

    @Test
    public void findElementByClassAll() throws Exception {
//         TODO:
//         get size text of class "test" (should be 5)
//         get text of class "test"
//         get third text of class "test" (should be "Test Text 4")

            System.out.println(driver.findElements(By.className("test")).size()); // 5
            List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));
            System.out.println(driver.findElements(By.className("test")).size()); // 4
//
            for (WebElement elementWithClass : allElementsWithClass) {
                System.out.println(elementWithClass.getText());
                //            sample text 1
                //            sample text 2
                //            unbelievable sample text
                //            amazing sample text
                //            dummy text
            }
            System.out.println("-----------------------");
            System.out.println(driver.findElements(By.className("test")).get(0).getText());
            System.out.println(driver.findElements(By.className("test")).get(2).getText()); // "unbelievable sample text"
        }
    }
