package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SecondTask {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        WebElement webElement1 = driver.findElement(By.xpath(".//a[contains(text(),'Коротко')]"));
        webElement1.click();

        WebElement webElement2 = driver.findElement(By.cssSelector(".cat-widget:nth-child(2) > .cat-widget__row:nth-child(1) > .cat-widget__col:nth-child(2) .post-card__link"));
        webElement2.click();

        WebElement webElement3 = driver.findElement(By.xpath(".//a[contains(text(),'Подписаться')]"));
        webElement3.click();

        driver.quit();

    }
}
