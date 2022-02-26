package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_Soru {




    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(text.getText(),"Opening a new window","yazı faklı");

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa title farlı");

        //● Click Here butonuna basın.
        //click here a basınca handle degerini bilmediğimiz bir sayfa acılıyor
        //o sayfanın degerini bulmak için window handle degerlerini kaydetmeliyim
        String whandleD1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //once acılan yeni syf. handle degirini elde etmeliyim
        // once tım handle degerlerini alıp bir sete koyalım
        Set<String> handleD=driver.getWindowHandles();
        String whandleD2="";
        for (String each:handleD){
            if (!each.equals(whandleD1)){
                whandleD2=each;
            }
        }
        //artık yeni syf geciş yapabiliriz
        driver.switchTo().window(whandleD2);
        softAssert.assertEquals(driver.getTitle(),"New Window","title farklı");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikincitext=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikincitext.getText(),"New Window", "yazı farklı");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(whandleD1);
        softAssert.assertEquals(driver.getTitle(),"The Internet", "title farklı");

        softAssert.assertAll();

    }






}
