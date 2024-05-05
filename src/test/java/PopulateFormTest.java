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
        formPage.firstName.setValue(firstName);
        formPage.lastName.setValue(lastName);
        formPage.userEmail.setValue(userEmail);
        formPage.genderMaleRadioButton.click();
        formPage.userNumber.setValue(userNumber);
        formPage.setDate(day, month, year);
        formPage.subjectsInput.setValue(subjectFirst).pressEnter();
        formPage.subjectsInput.setValue(subjectSecond).pressEnter();
        formPage.hobbiesSportsCheckbox.click();
        formPage.uploadPicture.uploadFromClasspath(fileName);
        formPage.currentAddress.setValue(currentAddress);
        formPage.setStateAndCity(state, city);
        formPage.submit.click();

        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(firstName + " " + lastName));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(userEmail));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(gender));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(userNumber));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(day + " " + month + "," + year));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(subjectFirst + ", " + subjectSecond));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(hobby));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(fileName));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(currentAddress));
        formPage.tableResponsiveModal.tableResponsive.shouldHave(text(state + " " + city));
    }

    @Test
    void setFormWithOutProvidedDataTest() {
        formPage.submit.click();

        formPage.tableResponsiveModal.tableResponsive.shouldNotBe(visible);
        formPage.checkFieldsRequirements();
    }

    @Test
    void setIncorrectDataTest() {
        formPage.firstName.setValue(firstName);
        formPage.lastName.setValue(lastName);
        formPage.genderMaleRadioButton.click();
        formPage.userNumber.setValue(incorrectUserNumber);
        formPage.submit.click();

        formPage.tableResponsiveModal.tableResponsive.shouldNotBe(visible);
    }
}
