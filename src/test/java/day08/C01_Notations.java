package day08;

import org.testng.annotations.Test;

public class C01_Notations {


    @Test(priority = 9)
    public void youtubeTest(){
        System.out.println("youtubeTest calişti");
    }
    @Test
    public void amazonTest(){
        System.out.println("amazonTest calişti");
    }
    @Test(priority = 5)
    public void bestBuyTest(){
        System.out.println("bestBuyTest calıstı");
    }





}
