package junit5tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Selenium {
    private final String HOME_PAGE_URL = "https://ctco.lv/en";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//div[contains(@class,'ok')]");
    private final By DROPDOWN_MENU = By.id("menu-item-127");
    private final By VACANCIES = By.id("menu-item-131");
    private final By TEST_ENGINEER = By.id("menu-item-4629");
    private final By TEXT_BLOCK = By.xpath(".//div[contains(@class, 'animated fadeIn active')]/div[@class = 'text-block']");

    private WebDriver driver;

    @Test
    public void testEngineerTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/irinasavenkova/IdeaProjects/junit/chromedriver");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
        driver.findElement(ACCEPT_COOKIES_BTN).click();
        driver.findElement(DROPDOWN_MENU).click();
        driver.findElement(VACANCIES).click();
        wait.until(ExpectedConditions.elementToBeClickable(TEST_ENGINEER));
        driver.findElement(TEST_ENGINEER).click();
        wait.until(ExpectedConditions.elementToBeClickable(TEXT_BLOCK));

        WebElement blockElement = driver.findElement(TEXT_BLOCK);
        List<WebElement> elements = blockElement.findElements(By.tagName("li"));
     //это я хз что такое но так сказал гугл
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
        }



    }

    //     @AfterEach
    //  public void closeBrowser() {
    //     browser.close();

