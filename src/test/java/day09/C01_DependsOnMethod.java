package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethod {

    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //    1. Test : Amazon ana sayfaya gittiginizi test edin
    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin                          arama yapin ve aramanizin gerceklestigini Test edin
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $16.83 oldugunu test edin
    //Collapse

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (dependsOnMethods = "test1")
    public void test2(){
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);
        String actTitle=driver.getTitle();
        String arann="nutella";

        Assert.assertTrue(actTitle.contains(arann));

    }
    @Test (dependsOnMethods = "test2")
    public void test3(){
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement fiyat=driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        String urun= fiyat.getText();
        String arananklm="$14.99";
        Assert.assertTrue(urun.contains(arananklm));


    }


}
