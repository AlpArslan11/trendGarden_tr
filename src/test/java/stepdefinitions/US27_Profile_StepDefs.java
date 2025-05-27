package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;

public class US27_Profile_StepDefs {

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("trendGarden_url"));
    }

    @When("User Logins with valid credentials")
    public void userLoginsWithValidCredentials() {
    }
    @Then("Navigate to the sifre degistirme page")
    public void navigateToTheSifreDegistirmePage() {
    }


    @When("Enter the correct current password to Mevcut Sifreniz")
    public void enterTheCorrectCurrentPasswordToMevcutSifreniz() {

    }

    @When("Enter a valid password to the Yeni Sifreniz")
    public void enterAValidPasswordToTheYeniSifreniz() {

    }

    @Then("Re-enter new password in the confirmation field Yeni Sifreniz Tekrar textbox")
    public void reEnterNewPasswordInTheConfirmationFieldYeniSifrenizTekrarTextbox() {

    }

    @And("Click on Sifremi Degistir button")
    public void clickOnSifremiDegistirButton() {

    }

    @Then("Verify that the system displays a message on a pop up indicating that the password has changed")
    public void verifyThatTheSystemDisplaysAMessageOnAPopUpIndicatingThatThePasswordHasChanged() {

    }

    @And("Log out from the account")
    public void logOutFromTheAccount() {
    }

    @Then("Login with the new password")
    public void loginWithTheNewPassword() {
    }

    @Then("Verify logged in the account")
    public void verifyLoggedInTheAccount() {
    }

    @And("Update new password to the old one")
    public void updateNewPasswordToTheOldOne() {
    }
}
