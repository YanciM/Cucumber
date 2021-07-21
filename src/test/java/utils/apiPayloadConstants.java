package utils;

public class apiPayloadConstants {

    public static String createEmployeePayload(){

        String createEmployeePayload= "{\n" +
                "  \"emp_firstname\": \"Emma\",\n" +
                "  \"emp_lastname\": \"Thomas\",\n" +
                "  \"emp_middle_name\": \"Rose\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1993-10-29\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                "}";

        return createEmployeePayload;
    }

}