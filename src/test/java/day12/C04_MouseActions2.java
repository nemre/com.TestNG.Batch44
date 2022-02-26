package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {
    //Yeni bir class olusturalim: MouseActions2


    @Test
    public void test1() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(2000);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement DragMe=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement Draghere=driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(DragMe).perform();
        actions.dragAndDrop(DragMe,Draghere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String act=Draghere.getText();
        String exp="Dropped!";
        Assert.assertEquals(act,exp,"beklenen oldu");

    }







}
