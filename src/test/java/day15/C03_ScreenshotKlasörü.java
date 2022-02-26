package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenshotKlasörü extends TestBase {
      //amazona git
    //3 farklı test metodu ile java,nutella ve elma arattıp
    //screenshot i kaydedin
      WebElement aramaKutusu;
    @Test
    public void test1() throws IOException {
        driver.get("https://www.amazon.com");
        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
         tumsayfaScreenshot();
    }
    @Test
    public void test2() throws IOException {

        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        tumsayfaScreenshot();
    }
    @Test
    public void test3() throws IOException {

        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("elma" + Keys.ENTER);
        tumsayfaScreenshot();
    }
}
