package ru.guru.qa.school.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {
    public TableResponsiveModal tableResponsiveModal;

    //  Input fields
    public final SelenideElement firstName = $("#firstName");
    public final SelenideElement lastName = $("#lastName");
    public final SelenideElement userEmail = $("#userEmail");
    public final SelenideElement userNumber = $("#userNumber");
    public final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public final SelenideElement subjectsInput = $("#subjectsInput");
    public final SelenideElement uploadPicture = $("#uploadPicture");
    public final SelenideElement currentAddress = $("#currentAddress");
    public final SelenideElement statePickList = $("#state");
    public final SelenideElement cityPickList = $("#city");

    // Buttons
    public final SelenideElement genderMaleRadioButton = $("[for=gender-radio-1]");
    public final SelenideElement genderFemaleRadioButton = $("[for=gender-radio-2]");
    public final SelenideElement genderOtherRadioButton = $("[for=gender-radio-3]");


    public final SelenideElement hobbiesSportsCheckbox = $("[for=hobbies-checkbox-1]");
    public final SelenideElement hobbiesReadingCheckbox = $("[for=hobbies-checkbox-1]");
    public final SelenideElement hobbiesMusicCheckbox = $("[for=hobbies-checkbox-1]");

    public final SelenideElement submit = $("#submit");

    public FormPage() {
        this.tableResponsiveModal = new TableResponsiveModal();
    }

    /**
     * Set date of birth
     *
     * @param day   String of day
     * @param month String of month
     * @param year  String of year
     */
    public void setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        $x("//select[contains(@class, 'react-datepicker__month-select')]/option[text()='" + month + "']").click();
        $x("//select[contains(@class, 'react-datepicker__year-select')]/option[text()='" + year + "']").click();
        if (day.length() == 1) {
            day = "00" + day;
        } else {
            day = "0" + day;
        }
        $(".react-datepicker__day--" + day + "").click();
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
    public void setStateAndCity(String state, String city) {
        statePickList.click();
        $(".css-11unzgr").shouldBe(visible);
        statePickList.$x(".//div[contains(text(),'" + state + "')]").click();

        cityPickList.click();
        $(".css-11unzgr").shouldBe(visible);
        cityPickList.$x(".//div[contains(text(),'" + city + "')]").click();
    }

    public void checkFieldsRequirements() {
        //  Check that the fields are required
        firstName.shouldHave(attribute("required"));
        lastName.shouldHave(attribute("required"));
        genderMaleRadioButton.preceding(0).shouldHave(attribute("required"));
        genderFemaleRadioButton.preceding(0).shouldHave(attribute("required"));
        genderOtherRadioButton.preceding(0).shouldHave(attribute("required"));
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
}
