package day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExistTest {
    @Test
    public void fileExistTest(){
        //projemizde pom.xml olup olmadığını test edelim
        String dosyayolu=System.getProperty("user.dir")+"/pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
}
