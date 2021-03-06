package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {



    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.usernamebox, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordbox, ConfigReader.getPropertyValue("password"));
        click(loginPage.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dash=new DashBoardPage();
        click(dash.pimOPtion);
        click(dash.employeeListOption);

    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emplist=new EmployeeListPage();
        sendText(emplist.idEmployee,"15518");
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        EmployeeListPage emplist=new EmployeeListPage();
        click(emplist.searchButton);
    }
    
   
    @When("user enters valid employee name")
    public void userEntersValidEmployeeName() {
        EmployeeListPage emplist=new EmployeeListPage();
        sendText(emplist.employeenamefield,"sofiia");
    }


    @Then("user see employee information is displayed")
    public void userSeeEmployeeInformationIsDisplayed() {
        System.out.println("Employee name is displayed");
    }
}
