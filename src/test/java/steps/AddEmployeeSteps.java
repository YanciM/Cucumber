package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOPtion);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, "Gabbyyy");
        sendText(add.middleName, "middleeee");
        sendText(add.lastName, "lasttt");
    }


    @And("user enters first name {string} middlename {string} and lastname{string}")
    public void userEntersFirstNameMiddlenameAndLastname(String firstname, String middlename, String lastname) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, firstname);
        sendText(add.middleName, middlename);
        sendText(add.lastName, lastname);
        GlobalVariable.firstName=firstname;
        GlobalVariable.middleName=middlename;
        GlobalVariable.lastName=lastname;
    }

    @When("user enters {string} {string} and {string} in the application")
    public void user_enters_and_in_the_application(String FirstName, String MiddleName, String LastName) {
        AddEmployeePage add = new AddEmployeePage();
        sendText(add.firstName, FirstName);
        sendText(add.middleName, MiddleName);
        sendText(add.lastName, LastName);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage add = new AddEmployeePage();
        click(add.saveBtn);
    }


    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeName = employees.asMaps();
        for (Map<String, String> employeename : employeeName) {

            String firstnamevalue = employeename.get("FirstName");
            String middlenamevalue = employeename.get("MiddleName");
            String lastnamevalue = employeename.get("LastName");
            System.out.println(firstnamevalue + " " + middlenamevalue + " " + lastnamevalue);

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, firstnamevalue);
            sendText(addEmployeePage.middleName, middlenamevalue);
            sendText(addEmployeePage.lastName, lastnamevalue);
            click(addEmployeePage.saveBtn);

            //assertion take it as HW
            Thread.sleep(4000);
            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);
        }

    }
        @When("user adds multiple employees from excel file from {string} sheet and verify they are added")
        public void user_adds_multiple_employees_from_excel_file_from_sheet_and_verify_they_are_added (String sheetname){
            List<Map<String, String>>newemployees= ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetname);

            DashBoardPage dash=new DashBoardPage();
            AddEmployeePage addEmployeePage=new AddEmployeePage();

            Iterator<Map<String, String>>it=newemployees.iterator();
            while (it.hasNext()){
                Map<String, String>mapNewEm= it.next();
                sendText(addEmployeePage.firstName, mapNewEm.get("FirstName"));
                sendText(addEmployeePage.middleName, mapNewEm.get("MiddleName"));
                sendText(addEmployeePage.lastName,mapNewEm.get("LastName"));
                click(addEmployeePage.saveBtn);

                //assertion complete in HW
            }

    }

    @When("capture the employeeId")
    public void capture_the_employee_id() {
        AddEmployeePage addEmployeePage=new AddEmployeePage();
        GlobalVariable.empId= addEmployeePage.employeeId.getAttribute("value");

    }

    @Then("verify the data from frontend and backend")
    public void verify_the_data_from_frontend_and_backend() {
        System.out.println("Backend");
        System.out.println("DBFirstName"+GlobalVariable.dbFirstName);
        System.out.println("DBMiddleName"+GlobalVariable.dbMiddleName);
        System.out.println("DBLastName"+GlobalVariable.dbLastName);
        System.out.println("FrontEnd");
        System.out.println("Firstname"+GlobalVariable.firstName);
        System.out.println("MiddleName"+GlobalVariable.middleName);
        System.out.println("Lastname"+GlobalVariable.lastName);
    }







}