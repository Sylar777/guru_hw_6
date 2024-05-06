import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class PopulateFormTest extends BaseTest {
    // Test Data
    private final String firstName = "firstName";
    private final String lastName = "lastName";
    private final String userEmail = "userEmail@useremail.com";
    private final String gender = "Male";
    private final String userNumber = "1234567890";
    private final String incorrectUserNumber = "777";
    private final String month = "December";
    private final String day = "12";
    private final String year = "2020";
    private final String subjectFirst = "Computer Science";
    private final String subjectSecond = "Social Studies";
    private final String hobby = "Sports";
    private final String fileName = "wolf.JPG";
    private final String currentAddress = "currentAddress";
    private final String state = "Rajasthan";
    private final String city = "Jaipur";

    @Test
    void populateFormWithCorrectDataTest() {
        formPage.setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderMale()
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubject(subjectFirst)
                .setSubject(subjectSecond)
                .setHobby(hobby)
                .uploadPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit();

        formPage.tableResponsiveComponent.checkName(firstName, lastName)
                .checkEmail(userEmail)
                .checkGender(gender)
                .checkUserNumber(userNumber)
                .checkDateOfBirth(day, month, year)
                .checkSubject(subjectFirst, subjectSecond)
                .checkHobby(hobby)
                .checkPicture(fileName)
                .checkCurrentAddress(currentAddress)
                .checkStateAndCity(state, city);
    }

    @Test
    void setFormWithOutProvidedDataTest() {
        formPage.clickSubmit();

        formPage.tableResponsiveComponent.tableResponsive.shouldNotBe(visible);
        formPage.checkFieldsRequirements();
    }

    @Test
    void setIncorrectDataTest() {
        formPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGenderMale()
                .setUserNumber(incorrectUserNumber)
                .clickSubmit();

        formPage.tableResponsiveComponent.tableResponsive.shouldNotBe(visible);
    }
}
