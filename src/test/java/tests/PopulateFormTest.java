package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class PopulateFormTest extends BaseTest {
    @Test
    void populateFormWithCorrectDataTest() {
        formPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGenderMale()
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.fileName)
                .setCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .clickSubmit();

        formPage.tableResponsiveComponent.checkName(testData.firstName, testData.lastName)
                .checkEmail(testData.userEmail)
                .checkGender(testData.gender)
                .checkUserNumber(testData.userNumber)
                .checkDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .checkSubject(testData.subject)
                .checkHobby(testData.hobby)
                .checkPicture(testData.fileName)
                .checkCurrentAddress(testData.currentAddress)
                .checkStateAndCity(testData.state, testData.city);
    }

    @Test
    void setFormWithOutProvidedDataTest() {
        formPage.clickSubmit();

        formPage.tableResponsiveComponent.tableResponsive.shouldNotBe(visible);
        formPage.checkFieldsRequirements();
    }

    @Test
    void setIncorrectDataTest() {
        formPage.setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderMale()
                .setUserNumber(testData.incorrectUserNumber)
                .clickSubmit();

        formPage.tableResponsiveComponent.tableResponsive.shouldNotBe(visible);
    }
}
