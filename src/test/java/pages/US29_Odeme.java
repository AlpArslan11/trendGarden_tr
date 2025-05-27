package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US29_Odeme {
    public US29_Odeme() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div/div/div[2]/ul/li[2]/a")
    public WebElement eftButtonOnTheOdemePage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[2]/div[1]/a")
    public WebElement sonrakiAdimButtonOnTheOdemePage;


}


