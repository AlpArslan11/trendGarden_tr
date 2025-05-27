package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US29_Sepetim {

    public US29_Sepetim() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[1]/div[2]")
    public WebElement satinAlButtonOnTheSepetPage;




}