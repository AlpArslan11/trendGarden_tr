package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US30_KisiselVeTeslimatBilgileri {

    public US30_KisiselVeTeslimatBilgileri() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[2]/div[1]/a")
    public WebElement sonrakiAdimButtonOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[2]/div[1]/div[2]/em")
    public WebElement gecerliBilgiGirinUyarisiOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[1]/div/table[1]/tbody/tr[1]/td/div/input ")
    public WebElement adKisiselInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[1]/div/table[1]/tbody/tr[2]/td/div/input")
    public WebElement soyadKisiselInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[1]/div/table[1]/tbody/tr[3]/td/div/input")
    public WebElement epostaKisiselInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[1]/tbody/tr[1]/td/div/input")
    public WebElement adTeslimatInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[1]/tbody/tr[2]/td/div/input")
    public WebElement soyadTeslimatInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[1]/tbody/tr[4]/td/div/input")
    public WebElement cepTelTeslimatInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[2]/tbody/tr[2]/td/div/select")
    public WebElement sehirDropdownInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[2]/tbody/tr[3]/td/div/select")
    public WebElement ilceDropdownInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[1]/div[2]/div/table[2]/tbody/tr[4]/td/div/textarea")
    public WebElement adresTeslimatInfoOnTheInfoPage;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/form/div[2]/div[1]/div[2]/input")
    public WebElement gizlilikPolCheckboxOnTheInfoPage;






}