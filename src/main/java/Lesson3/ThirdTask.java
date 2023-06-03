package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ThirdTask {
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    //options.addArguments("--headless");
    options.addArguments("start-maximized");
    options.addArguments("--remote-allow-origins=*");


    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.livejournal.com/");

    //Авторизуемся под своей учетной записью
    WebElement webElement1 = driver.findElement(By.xpath(".//a[contains(text(),'Войти')]"));
    webElement1.click();

    driver.findElement(By.id("user")).sendKeys("SomeStudent101");
    driver.findElement(By.id("lj_loginwidget_password")).sendKeys("SMNwuJL!#p");

    WebElement webElement2 = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
    webElement2.click();

    WebElement webElement3 = driver.findElement(By.name("action:login"));
    webElement3.click();

    //Создаем пост
    WebElement webElement4 = driver.findElement(By.cssSelector(".s-header-item-post"));
    webElement4.click();

    //Пишем текст заголовка
    driver.findElement(By.xpath("//textarea")).sendKeys("Some Text");

    //Пишем текст поста
    driver.findElement(By.cssSelector(".notranslate")).sendKeys("Some Long Text...");

    //Публикуем пост
    WebElement webElement5 = driver.findElement(By.xpath("//span[contains(.,'Настроить и опубликовать')]"));
    webElement5.click();

    WebElement webElement6 = driver.findElement(By.xpath(".//footer/div/button"));
    webElement6.click();


   driver.quit();
}
}
