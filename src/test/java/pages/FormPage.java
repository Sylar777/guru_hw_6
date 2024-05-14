package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsiveComponent;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    //  Components
    public TableResponsiveComponent tableResponsiveComponent;
    public CalendarComponent calendarComponent;

    //  Input fields
    public final SelenideElement firstName = $("#firstName");
    public final SelenideElement lastName = $("#lastName");
    public final SelenideElement userEmail = $("#userEmail");
    public final SelenideElement userNumber = $("#userNumber");
    public final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public final SelenideElement subjectsInput = $("#subjectsInput");
    public final SelenideElement uploadPicture = $("#uploadPicture");
    public final SelenideElement currentAddress = $("#currentAddress");
    public final SelenideElement statePickList = $("#state input");
    public final SelenideElement cityPickList = $("#city input");

    // Buttons
    public final SelenideElement genderMaleRadioButton = $("#genterWrapper input[value='Male']");
    public final SelenideElement genderFemaleRadioButton = $("#genterWrapper input[value='Female']");
    public final SelenideElement genderOtherRadioButton = $("#genterWrapper input[value='Other']");
    public final ElementsCollection hobbiesCheckboxes = $$("#hobbiesWrapper .custom-control-label");
    public final SelenideElement hobbiesSportsCheckbox = hobbiesCheckboxes.filterBy(text("Sports")).first();
    public final SelenideElement hobbiesReadingCheckbox = hobbiesCheckboxes.filterBy(text("Reading")).first();
    public final SelenideElement hobbiesMusicCheckbox = hobbiesCheckboxes.filterBy(text("Music")).first();
    public final SelenideElement submit = $("#submit");

    public FormPage() {
        this.tableResponsiveComponent = new TableResponsiveComponent();
        this.calendarComponent = new CalendarComponent();
    }

    /**
     * Remove elements from the page
     */
    public void removeElements() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    /**
     * Set state and city
     *
     * @param state String of state
     * @param city  String of city
     */
    public FormPage setStateAndCity(String state, String city) {
        statePickList.setValue(state).pressEnter();
        cityPickList.setValue(city).pressEnter();
        return this;
    }

    /**
     * Click on label Male for selecting checkbox Male
     */
    public FormPage setGender(String value) {
        $("#genterWrapper input[value='" + value + "']").sibling(0).click();
        return this;
    }

    /**
     * Check fields requirements
     */
    public void checkFieldsRequirements() {
        //  Check that the fields are required
        firstName.shouldHave(attribute("required"));
        lastName.shouldHave(attribute("required"));
        genderMaleRadioButton.shouldHave(attribute("required"));
        genderFemaleRadioButton.shouldHave(attribute("required"));
        genderOtherRadioButton.shouldHave(attribute("required"));
        userNumber.shouldHave(attribute("required"));

        // Check that the fields are not required
        userEmail.shouldNotHave(attribute("required"));
        dateOfBirthInput.shouldNotHave(attribute("required"));
        subjectsInput.shouldNotHave(attribute("required"));
        hobbiesSportsCheckbox.shouldNotHave(attribute("required"));
        hobbiesReadingCheckbox.shouldNotHave(attribute("required"));
        hobbiesMusicCheckbox.shouldNotHave(attribute("required"));
        currentAddress.shouldNotHave(attribute("required"));
        statePickList.shouldNotHave(attribute("required"));
        cityPickList.shouldNotHave(attribute("required"));
    }

    public FormPage setFirstName(String firstName) {
        this.firstName.setValue(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.setValue(lastName);
        return this;
    }

    public FormPage setUserEmail(String userEmail) {
        this.userEmail.setValue(userEmail);
        return this;
    }

    public FormPage setUserNumber(String userNumber) {
        this.userNumber.setValue(userNumber);
        return this;
    }

    public FormPage setDateOfBirth(String day, String month, String year) {
        this.dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public FormPage setSubject(String subject) {
        this.subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public FormPage setHobby(String hobby) {
        switch (hobby) {
            case "Sports" -> this.hobbiesSportsCheckbox.click();
            case "Reading" -> this.hobbiesReadingCheckbox.click();
            case "Music" -> this.hobbiesMusicCheckbox.click();
        }
        return this;
    }

    public FormPage uploadPicture(String fileName) {
        this.uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public FormPage setCurrentAddress(String currentAddress) {
        this.currentAddress.setValue(currentAddress);
        return this;
    }

    public void clickSubmit() {
        this.submit.click();
    }
}
