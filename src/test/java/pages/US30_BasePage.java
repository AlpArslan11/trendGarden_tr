package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US30_BasePage {

    /*public BasePage() {


        PageFactory.initElements(Driver.getDriver(), this);

    }

     */

    private WebDriver driver;

    public US30_BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div/div/div[1]/div/div[5]/div/div/div[3]/div[4]/a[1]")
    public WebElement sepeteEkleButtonOnTheHomepage;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/div[3]/div/a[2]")
    public WebElement sepetimButtonOnTheHomepage;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[3]/div[4]/a[1]")
    public WebElement sepeteEkleButtonOnTheHomepageScroll;

@FindBy(xpath = "/html/body/div[1]/div[5]/div[2]/div[2]/div[2]/div/div[3]/div/div/div[3]/div[4]/a[1]")
    public WebElement sepeteEkle3;

@FindBy(xpath = "//a[@href='?islem=sepete_ekle2&;sid=599648308&;uid=1155']")
    public WebElement sepeteEkle4;



}
