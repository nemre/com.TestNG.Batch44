package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecutor extends TestBase {
    //amazona git
    //sell linkine JS iele tıkla
    //ve ilgili sayfayı test edin
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //1.adım
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2.adım
        WebElement sell=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        //3.adım
        jse.executeScript("arguments[0].click();",sell);
        Thread.sleep(5000);




    }
}
