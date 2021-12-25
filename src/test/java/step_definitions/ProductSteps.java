package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
    @Given("^the user is on the product page upon successful Login$")
    public void theUserIsOnTheProductPageUponSuccessfulLogin() {

    }


    @Then("^validate the product is listed with title \"(.+?)\" and price \"(.+?)\"$")
    public void validateTheProductIsListedWithTitleAndPrice(String string, String string2) {
    }

    @When("^user clicks on product tile \"(.+?)\"$")
    public void userClicksOnProductTile(String string) {
    }

    @Then("^user should be on product details page with title \"(.+?)\", price \"(.+?)\" and \"(.+?)\"$")
public void userShouldBeOnProductDetailsPageWithTitlePriceAnd(String title, String price, String description) {
}



}

