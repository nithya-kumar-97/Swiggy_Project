package swiggy.StepDefinition;

import java.io.IOException;

import BaseClass.Base_Class;
import PageObjectModelPackage.PageObjectModelClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionClass extends Base_Class {

	@Given("user Launch The Swiggy Application")
	public void user_launch_the_swiggy_application() {
		launchBrowser("chrome");
		getUrl("https://www.swiggy.com/");
	}

	@When("user  Enters the Location {string} In Location Field")
	public void user_enters_the_location_in_location_field(String string) {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		sendKeys(object.getEnterLocation(), string);
	}

	@When("click Clear button")
	public void click_clear_button() {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		click(object.clickClearButton());
	}

	@When("enters the Location {string} In Location Field")
	public void enters_the_location_in_location_field(String location) {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		sendKeys(object.getEnterLocation(), location);
		implicitWait(20);
	}

	@Then("select The Desired Location From The Location Suggestions and Navigates To Home Page")
	public void select_the_desired_location_from_the_location_suggestions_and_navigates_to_home_page() {
		PageObjectModelClass object = new PageObjectModelClass(driver);

		click(object.selectDesiredLocation());
	}

	@Given("user Is On Search Page")
	public void user_is_on_search_page() {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		click(object.clickSearchButton());
	}

	@When("user Enters The Required Food {string} In Search Box")
	public void user_enters_the_required_food_in_search_box(String foodName) {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		sendKeys(object.enterFood(), foodName);
	}

	@When("user Can Select The Required Food in Food List")
	public void user_can_select_the_required_food_in_food_list() {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		click(object.SelectFoodItem());
		implicitWait(20);
		click(object.selectHotel());
	}

	@When("user Select The Required Hotel and Add button")
	public void user_select_the_required_hotel_and_add_button() {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		click(object.clickImage());
		implicitWait(20);

	}

	@When("click The Required Quantity and Add The Item In Cart")
	public void click_the_required_quantity_and_add_the_item_in_cart() {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		click(object.clickAddBtn());
		click(object.clickFull());
		implicitWait(20);
		click(object.clickAddItem());
	}

	@Then("click Cart button and Check The Required Order Is In Cart")
	public void click_cart_button_and_check_the_required_order_is_in_cart() throws IOException {
		PageObjectModelClass object = new PageObjectModelClass(driver);
		navigateBack();
		click(object.clickCart());
		takesSreenShot("Swiggy", "com.swiggy.project");
	}

}
