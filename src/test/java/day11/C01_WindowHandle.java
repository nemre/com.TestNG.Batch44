package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println("ilk sayfanın window handle degeri:"+driver.getWindowHandle());
        String whandle1=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);//yeni pencere açılır
        driver.get("https://www.bestbuy.com");
        System.out.println("ilk sayfanın window handle degeri:"+driver.getWindowHandle());
        String whandle2=driver.getWindowHandle();

        Set<String> handleDegerleri=driver.getWindowHandles();
        System.out.println(handleDegerleri);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://facebook.com");

        //amazonn acıkoldugu sayfada geri git nutella arat
        driver.switchTo().window(whandle1);
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);


        //acık olan sayfada best buya gec ve title bestbuy oldugunu test et
        driver.switchTo().window(whandle2);
        //String acttt=driver.getTitle();
       // String exptt="bestbuy";
        //Assert.assertEquals(acttt,exptt);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        //facebook acık say. gec url https://facebook.com
        handleDegerleri = driver.getWindowHandles();

        String whandle3="";
        for (String each: handleDegerleri){
            if (!(each.equals(whandle1)||each.equals(whandle2))){
                whandle3=each;
            }
        }
        System.out.println(whandle3);
        System.out.println(handleDegerleri);

        driver.switchTo().window(whandle3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://facebook.com");

        Thread.sleep(3000);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
