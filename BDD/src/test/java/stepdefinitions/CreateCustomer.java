package stepdefinitions;

import org.testng.Reporter;

import io.cucumber.java.en.Given;

public class CreateCustomer {
	@Given("Create Customer has been executed")
	public void create_customer_has_been_executed() {
		Reporter.log("Customer has been created",true);
	}

}
