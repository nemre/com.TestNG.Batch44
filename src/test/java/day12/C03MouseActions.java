package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03MouseActions extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement kutu=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Thread.sleep(2000);

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        actions.moveToElement(kutu).perform();
        actions.contextClick(kutu).perform();
        Thread.sleep(2000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        String alertSTR=driver.switchTo().alert().getText();
        Assert.assertEquals(alertSTR,"You selected a context menu","beklenen yazı içermiyor");
        Thread.sleep(2000);

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //6- Elemental Selenium linkine tiklayalim
        String ilkshandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        Thread.sleep(2000);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String>handles=driver.getWindowHandles();
        String ikinciHandle="";
        for (String each:handles){
            if (!(each.equals(ilkshandle))){
                ikinciHandle=each;
            }
        }
        driver.switchTo().window(ikinciHandle);
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Elemental Selenium","h1 bekleneni içermiyor");



    }
}
