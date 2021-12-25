package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.Login;


public class LoginSteps {
    AppiumDriver driver = Hooks.driver;

    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void userEntersUsernameAndPassword(String userName, String password) {
        new Login(driver)
                .enterUserName(userName)
                .enterPassword(password);

    }
    @And("^click on login button$")
    public void clickOnLoginButton() {
        new Login(driver)
                .clickOnLoginButton();
    }
    @Then("^user should get error message \"(.+?)\"$")
    public void userShouldGetErrorMessage(String errorMsg) {
        new Login(driver)
                .unsuccessfulLoginError(errorMsg);
    }
    @Then("^user should see product page with title \"(.+?)\"$")
    public void userShouldSeeProductPageWithTitle(String title) {
        new Login(driver)
                .loginIsSuccessful(title);
    }
}

//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
//    public void userEntersUsernameAndPassword(String userName, String password) {
//
//    }
//
//    @And("^click on login button$")
//    public void clickOnLoginButton() {
//
//    }
//
//    @Then("^user should get error message \"(.+?)\"$")
//    public void userShouldGetErrorMessage(String errorMsg) {
//
//    }
//
//    @Then("^user should see product page with title \"(.+?)\"$")
//    public void userShouldSeeProductPageWithTitle(String title) {
//
//    }
//}