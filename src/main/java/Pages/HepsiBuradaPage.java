package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {

    public HepsiBuradaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "myAccount")
    public WebElement girisYap;

    @FindBy(id = "login")
    public WebElement girisYapButon;

    @FindBy(id = "txtUserName")
    public WebElement mail;

    @FindBy(id = "btnLogin")
    public WebElement girisYapSisteme;

    @FindBy(id = "txtPassword")
    public WebElement parola;

    @FindBy(id = "btnEmailSelect")
    public WebElement girisYapAnaSayfaya;

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement girisDogrulama;

    @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement urunAra;

    @FindBy(xpath = "//div[@class='searchResultSummaryBar-HM2Hk6FnQ2zwnblc0BJb']")
    public WebElement SamsungSonucAra;

    @FindBy(xpath = "(//*[@data-test-id='product-card-name'])[3]")
    public WebElement ücüncüSamsung;


    @FindBy(xpath = "(//*[@height='20'])[1]")
    public WebElement begenButonu;

    @FindBy(xpath = "(//span[@class='sf-OldMyAccount-d0xCHLV38UCH5cD9mOXq'])[1]")
    public WebElement Hesabım;


    @FindBy(xpath = "(//a[@title='Beğendiklerim'])[1]")
    public WebElement Beğendiklerim;


    @FindBy(xpath = "(//*[text()='Düzenle'])[2]")
    public WebElement DüzenleButonuu;

    @FindBy(xpath = "(//*[@type='comfort'])[2]")
    public WebElement ÜrünüSec;

    @FindBy(xpath = "(//*[@id='StickActionHeader-RemoveSelected'])[1]")
    public WebElement silButonu;

    @FindBy(xpath = "(//*[@id='DeleteConfirmationModal-ActionButton'])[1]")
    public WebElement silOnayla;


    @FindBy(xpath = "//div[@class='emptyFavoritesRedirectTitle']")
    public WebElement sepeptteürünyok;

    @FindBy(xpath = "(//*[@data-test-id='product-card-name'])[3]")
    public WebElement favorilerdenÖnceÜrün;

    @FindBy(xpath = "//*[@data-test-id='product-card-name']")
    public WebElement favorilerdekiÜrün;



    @FindBy(xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement ara;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cerezKabulEt;


}



