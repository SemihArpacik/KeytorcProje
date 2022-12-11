package Tests;

import Pages.HepsiBuradaPage;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.*;

public class HepsiBuradaTest extends TestBaseRapor{
    HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();

    @Test
    public void test01() {


        // 1_Kullanici https://www.hepsiburada.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hepsiBuradaUrl"));

        extentTest=extentReports.createTest("KeytorcProje",
                "Favorilere ürün ekleme ve çıkarma");

        extentTest.info("Anasayfaya gidildi");

        String expectedTitle = "Hepsiburada";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        // 2_Kullanici giris yapmak icin giris yap sekmesine tiklar
        hepsiBuradaPage.cerezKabulEt.click();
        extentTest.info("Çerez kabul edildi");
        hepsiBuradaPage.girisYap.click();
        hepsiBuradaPage.girisYapButon.click();
        hepsiBuradaPage.mail.sendKeys(ConfigReader.getProperty("email"));
        hepsiBuradaPage.girisYapSisteme.click();
        hepsiBuradaPage.parola.sendKeys(ConfigReader.getProperty("password"));

        hepsiBuradaPage.girisYapAnaSayfaya.click();
        extentTest.info("Giriş yapıldı");


        // 3_Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır
        Assert.assertTrue(hepsiBuradaPage.girisDogrulama.isDisplayed());


        //4_Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        hepsiBuradaPage.urunAra.sendKeys("Samsung");
        hepsiBuradaPage.ara.click();
        extentTest.info("Samsung ürün aratıldı");

        ReasuableMethods.waitFor(2);
        Assert.assertTrue(hepsiBuradaPage.SamsungSonucAra.getText().contains("Samsung"));
        ReasuableMethods.JSEScrollBy();


        //5- Sansung ürünleri tek sayfada aşağıya kadar devam ettiği(2. sayfası olmadığı) için
        // ilk sıradaki 3. ürün favorilere eklenir.
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hepsiBuradaPage.ücüncüSamsung).perform();
        ReasuableMethods.waitFor(2);
        String favoriledigimUrun = hepsiBuradaPage.favorilerdenÖnceÜrün.getText();
        hepsiBuradaPage.begenButonu.click();
        extentTest.info("Ürün favorilere eklendi");
        hepsiBuradaPage.Hesabım.click();
        hepsiBuradaPage.Beğendiklerim.click();

        //6-Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak

        String favorilerimSayfasindakiUrun = hepsiBuradaPage.favorilerdekiÜrün.getText();
        Assert.assertEquals(favoriledigimUrun, favorilerimSayfasindakiUrun);


        //7-Favorilere eklenen ürün favorilerden kaldırılacak
        // JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        // executor.executeScript("arguments[0].click();", hepsiBuradaPage.DüzenleButonu1);
        hepsiBuradaPage.DüzenleButonuu.click();
        hepsiBuradaPage.ÜrünüSec.click();
        hepsiBuradaPage.silButonu.click();
        hepsiBuradaPage.silOnayla.click();

        extentTest.info("Ürün favorilerimden çıkarıldı");

        //8-Favorilerde ürün olmadığı belirlenecek.

        Assert.assertTrue(hepsiBuradaPage.sepeptteürünyok.isDisplayed());

        ReasuableMethods.waitFor(2);


        // 9- sayfa kapanacak.
        Driver.closeDriver();
    }


}


 