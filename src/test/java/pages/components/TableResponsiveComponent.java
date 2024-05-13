package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsiveComponent {
    public SelenideElement tableResponsive = $(".table-responsive");

    public TableResponsiveComponent checkName(String firstName, String lastName) {
        tableResponsive.shouldHave(text(firstName + " " + lastName));
        return this;
    }

    public TableResponsiveComponent checkEmail(String userEmail) {
        tableResponsive.shouldHave(text(userEmail));
        return this;
    }

    public TableResponsiveComponent checkGender(String gender) {
        tableResponsive.shouldHave(text(gender));
        return this;
    }

    public TableResponsiveComponent checkUserNumber(String userNumber) {
        tableResponsive.shouldHave(text(userNumber));
        return this;
    }

    public TableResponsiveComponent checkDateOfBirth(String day, String month, String year) {
        tableResponsive.shouldHave(text(day + " " + month + "," + year));
        return this;
    }

    public TableResponsiveComponent checkSubject(String subjectFirst) {
        tableResponsive.shouldHave(text(subjectFirst));
        return this;
    }

    public TableResponsiveComponent checkHobby(String hobby) {
        tableResponsive.shouldHave(text(hobby));
        return this;
    }

    public TableResponsiveComponent checkPicture(String fileName) {
        tableResponsive.shouldHave(text(fileName));
        return this;
    }

    public TableResponsiveComponent checkCurrentAddress(String currentAddress) {
        tableResponsive.shouldHave(text(currentAddress));
        return this;
    }

    public void checkStateAndCity(String state, String city) {
        tableResponsive.shouldHave(text(state + " " + city));
    }
}
