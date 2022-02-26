package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_dropdown {


    WebDriver driver;
    WebElement dropdown;
    Select select;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1(){
        //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        driver.get("https://www.amazon.com/ ");
        dropdown=driver.findElement(By.id("//select[@id='searchDropdownBox']"));
        select=new Select(dropdown);
        List <WebElement> optionlist=select.getOptions();
        int actualoptionsayisi=optionlist.size();
        int expectedsayisi=45;
        Assert.assertEquals(actualoptionsayisi,expectedsayisi);
    }

    @Test
    public void test2(){
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        //    2. Arama kutusuna Java yazin ve aratin
        //    3. Bulunan sonuc sayisini yazdirin
        //    4. Sonucun Java kelimesini icerdigini test edin




    }



}
