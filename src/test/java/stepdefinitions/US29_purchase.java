package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.US30_BasePage;
import pages.US30_KisiselVeTeslimatBilgileri;
import pages.US29_Sepetim;
import utilities.Driver;
import utilities.ReusableMethods;


import java.time.Duration;

public class US29_purchase {

    private WebDriver driver;
    private JavascriptExecutor js;

    public US29_purchase() {
        this.driver = Driver.getDriver();
        // this.driver = driver;
        this.js = (JavascriptExecutor) driver; }



    // pages paketinin altindaki locatorlarini aldigimiz elementleri cagirabilmek icin tanimlama yapacagiz.
    US30_BasePage US30BasePage = new US30_BasePage();

    US30_KisiselVeTeslimatBilgileri US30KisiselVeTeslimatBilgileri = new US30_KisiselVeTeslimatBilgileri();
    US29_Sepetim US29Sepetim = new US29_Sepetim();

    // JavascriptExecutor js = (JavascriptExecutor) driver;

    // bu method basepagedeki satin al butonuna scroll etmek icin.
    public void scrollToElementVisible(WebDriver driver,  int maxScrollAttempts) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        int attempts = 0;
        while (attempts < maxScrollAttempts) {
            try {
                WebElement element = US30BasePage.sepeteEkleButtonOnTheHomepageScroll;
                // Element görünür mü kontrol et
                if (element.isDisplayed()) {
                    break;  // Element görünür, scroll işlemi tamam
                }
            } catch (NoSuchElementException e) {
                // Element henüz yok, scroll devam edecek
            }

            // Aşağı kaydır
            js.executeScript("window.scrollBy(0, window.innerHeight);");

            // Kısa bekleme (isteğe bağlı)
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}

            attempts++;
        }
    }



    // feature dosyasini olusturdugumuz adimlari buraya yerlestirerek kodlarimizi girecegiz

    @Given("user is on the homepage of the application -trendgarden.net")
    public void userIsOnTheHomepageOfTheApplicationTrendgardenNet() {
        driver.manage().window().maximize(); // driver ekrani maximize ediyor
        driver.get("https://trendgarden.net"); // websitesini aciyoruz

        ReusableMethods.waitForVisibility(US30BasePage.sepetimButtonOnTheHomepage, 10);
        // sepete ekle butonunu bulabilmek icin ve olasi aksamalari onlemek icin
        //utils paketinden cagirdigimiz bekleme metodunu 5 saniyeligine calistiriyoruz.
    }

    @When("user clicked on the Sepete Ekle button for an item")
    public void userClickedOnTheSepeteEkleButtonForAnItem() {
        //scroll
        js.executeScript("window.scrollBy(5, window.innerHeight);");
        ReusableMethods.waitForVisibility(US30BasePage.sepeteEkle3, 15);
        US30BasePage.sepeteEkle3.click(); // sepete ekle butonuna tikliyoruz.
        ReusableMethods.wait(5); // 5 saniyeligine beklemesini sagliyoruz.

    }

    @And("user goes to Sepetim button on the top right of the homepage")
    public void userGoesToSepetimButtonOnTheTopRightOfTheHomepage() {

        US30BasePage.sepetimButtonOnTheHomepage.click(); //sepetim butonuna tiklayarak yeni ekranin acilmasini sagliyoruz
        ReusableMethods.wait(2);

    }

    @And("user clicks on the Satin Al button on the newly opening page")
    public void userClicksOnTheSatinAlButtonOnTheNewlyOpeningPage() {
        Assert.assertTrue(US29Sepetim.satinAlButtonOnTheSepetPage.isDisplayed());
        //sepetim sayfasindaki satin al butonunun gorunurlugunu kontrol ediyoruz.
        US29Sepetim.satinAlButtonOnTheSepetPage.click(); //sepetim sayfasindaki satin al butonuna tikliyoruz.

    }

    @And("user enters nothing on the Purchasing page")
    public void userEntersNothingOnThePurchasingPage() {
        //kullanicinin hicbir bilgi girmemesini sagliyoruz
    }

    @And("user clicks on the Sonraki Adim button there")
    public void userClicksOnTheSonrakiAdimButtonThere() {
        US30KisiselVeTeslimatBilgileri.sonrakiAdimButtonOnTheInfoPage.click();
        // satin alma bilgileri girilen sayfada hicbir bilgi girmeden sonraki adim butonu ile purchase'i ilerletmeye calisiyoruz.
        ReusableMethods.wait(3);
    }

    @Then("user should not be able to proceed with next page")
    public void userShouldNotBeAbleToProceedWithNextPage() {
        Assert.assertTrue(US30KisiselVeTeslimatBilgileri.gecerliBilgiGirinUyarisiOnTheInfoPage.isDisplayed());
        // uyari gelip gelmedigini kontrol ediyoruz.

        Assert.assertTrue(US30KisiselVeTeslimatBilgileri.sonrakiAdimButtonOnTheInfoPage.isDisplayed());
        // kullanicinin sonraki sayfaya gecemedigini kontrol ediyoruz.

    }
}
