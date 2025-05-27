package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

public class US30_purchase {

    private WebDriver driver;
    private JavascriptExecutor js;



    public US30_purchase() {
        this.driver = Driver.getDriver();
        // this.driver = driver;
        this.js = (JavascriptExecutor) driver; }

    //rastgele dropdown element secme metodu
    public static String selectRandomOption(WebElement dropdownElement) {
        // Dropdown öğesini Select sınıfıyla sar
        Select dropdown = new Select(dropdownElement);

        // Dropdown'daki tüm seçenekleri al
        List<WebElement> options = dropdown.getOptions();

        // Rastgele bir indeks seç
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());

        // Rastgele seçeneği seç
        dropdown.selectByIndex(randomIndex);

        // Seçilen seçeneğin metnini döndür
        return options.get(randomIndex).getText();
    }

    Faker faker = new Faker();
    US30_BasePage US30BasePage = new US30_BasePage();

    US30_KisiselVeTeslimatBilgileri US30KisiselVeTeslimatBilgileri = new US30_KisiselVeTeslimatBilgileri();
    US29_Sepetim US29Sepetim = new US29_Sepetim();
    US29_Odeme US29Odeme = new US29_Odeme();
    US30_Onay US30Onay = new US30_Onay();

  /*  @Given("user is on the homepage of the application -trendgarden.net")
    public void userIsOnTheHomepageOfTheApplicationTrendgardenNet() {

        driver.manage().window().maximize(); // driver ekrani maximize ediyor
        driver.get("https://trendgarden.net"); // websitesini aciyoruz

        ReusableMethods.waitForVisibility(basePage.sepetimButtonOnTheHomepage, 5);
        // sepetim  butonunu bulabilmek icin ve olasi aksamalari onlemek icin
        //utils paketinden cagirdigimiz bekleme metodunu 5 saniyeligine calistiriyoruz.


    }

   */

    @And("user enters required info for the Purchasing page")
    public void userEntersRequiredInfoForThePurchasingPage() {

        // kisisel ve teslimat bilgileri sayfasindaki her bir required alana faker ile deger atayacagiz.
        US30KisiselVeTeslimatBilgileri.adKisiselInfoOnTheInfoPage.sendKeys(faker.name().firstName());
        US30KisiselVeTeslimatBilgileri.soyadKisiselInfoOnTheInfoPage.sendKeys(faker.name().lastName());
        US30KisiselVeTeslimatBilgileri.epostaKisiselInfoOnTheInfoPage.sendKeys(faker.internet().emailAddress());
        US30KisiselVeTeslimatBilgileri.adTeslimatInfoOnTheInfoPage.sendKeys(faker.name().firstName());
        US30KisiselVeTeslimatBilgileri.soyadTeslimatInfoOnTheInfoPage.sendKeys(faker.name().lastName());
        // turkiye kosullarinda gecerli bir tel no
        String[] turkishAreaCodes = {"501", "505", "506", "507", "531", "532", "533", "534", "535", "536", "537", "538", "539", "541", "542", "543", "544", "545", "546", "547", "548", "549"};

        // Rastgele bir alan kodu seç
        String areaCode = turkishAreaCodes[faker.random().nextInt(turkishAreaCodes.length)];

        // Rastgele 7 haneli bir numara oluştur
        String localNumber = faker.number().digits(7);

        // Türkiye formatında telefon numarası oluştur

        US30KisiselVeTeslimatBilgileri.cepTelTeslimatInfoOnTheInfoPage.sendKeys(areaCode  + localNumber.substring(0, 3)  + localNumber.substring(3));

        //dropdown teslimat sehir ve ilce secimi
        ReusableMethods.wait(5);
        selectRandomOption(US30KisiselVeTeslimatBilgileri.sehirDropdownInfoOnTheInfoPage);
        selectRandomOption(US30KisiselVeTeslimatBilgileri.ilceDropdownInfoOnTheInfoPage);

        US30KisiselVeTeslimatBilgileri.adresTeslimatInfoOnTheInfoPage.sendKeys(faker.address().fullAddress());
        US30KisiselVeTeslimatBilgileri.gizlilikPolCheckboxOnTheInfoPage.click();
        ReusableMethods.wait(5);

    }

    @And("user selects EFT option")
    public void userSelectsEFTOption() {
        // odeme sayfasinda eft sec
        US29Odeme.eftButtonOnTheOdemePage.click();

    }

    @And("user clicks on the Sonraki Adim button")
    public void userClicksOnTheSonrakiAdimButton() {
        US29Odeme.sonrakiAdimButtonOnTheOdemePage.click();
        ReusableMethods.wait(5);
    }

    @And("user clicks on the Homepage button from the top left side of the newly opening page")
    public void userClicksOnTheHomepageButtonFromTheTopLeftSideOfTheNewlyOpeningPage() {
        // onay sayfasinda sol ustteki homepage logosuna tikla.
        Assert.assertTrue(US30Onay.turningBackToHomepageButton.isDisplayed());
        US30Onay.turningBackToHomepageButton.click();
    }

    @Then("user should be able to turned back to the homepage successfully")
    public void userShouldBeAbleToTurnedBackToTheHomepageSuccessfully() {
        // eft purchase esnasinda homepage e donulup donulmedigini kontrol et.
        ReusableMethods.waitForVisibility(US30BasePage.sepetimButtonOnTheHomepage, 5);
        Assert.assertTrue(US30BasePage.sepetimButtonOnTheHomepage.isDisplayed());

    }
}