package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q11 extends TestBase {

    //amazona gidin
    //araba,ev,anahtarlık,ayakkabı,gömlek ürünlerini arayın

    @Test(dataProvider = "urunler")
    public void amazonTest(String kelime){

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime+ Keys.ENTER);

    }
    @DataProvider(name="urunler")
    public Object [] [] getUrunler(){
        Object[][] urunler={{"araba"},{"ev"},{"anahtarlık"},{"ayakkabı"},{"gomlek"}};
        return urunler;
    }

    //gittigidiyor sitesine git
    //java,javascript ve pyhton
    @Test(dataProvider = "programlar")
    public void gittigidiyorTest(String programlar){
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.id("//div[@class='sc-4995aq-4 dNPmGY']")).sendKeys(programlar+Keys.ENTER);
    }

    @DataProvider
    public Object[][] programlar(){
        String data[][] ={{"java"},{"javascript"},{"pyhton"}};
        return data;
    }
}
