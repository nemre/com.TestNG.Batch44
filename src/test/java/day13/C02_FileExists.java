package day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));///Users/mac3
    //MASA üzerindeki deneme klasörünün path ini istersem
    ///Users/mac3/Desktop/DENEME

        //dinamik olarak denem kla. path ini yazma istersem
        String path=System.getProperty("user.home")+"/Desktop/DENEME/dnm.rtf";
        System.out.println(path);

        //masa üstünde deneme klasörü içerisinde dnm isminde bir dosya olduğunu test edin
        //1-önce dinamik path oluştur
        String dosyayolu=System.getProperty("user.home")+"/Desktop/DENEME/dnm.rtf";

        System.out.println(System.getProperty("user.dir"));
        Files.exists(Paths.get(dosyayolu));
        //prıjede pom.xml oldugunu kontrol edil
        ///Users/mac3/IdeaProjects/com.TestNG.Batch44/pom.xml
        System.out.println(System.getProperty("user.dir"));// projemin yolunu veriri
        String pomPath=System.getProperty("user.dir")+"/pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }
}
