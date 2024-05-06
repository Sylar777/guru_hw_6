package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthElement = $("[class=react-datepicker__month-select]");
    private final SelenideElement yearElement = $("[class=react-datepicker__year-select]");

    /**
     * Set date of birth
     *
     * @param day   String of day
     * @param month String of month
     * @param year  String of year
     */
    public void setDate(String day, String month, String year) {
        monthElement.selectOption(month);
        yearElement.selectOption(year);

        if (day.length() == 1) {
            day = "00" + day;
        } else {
            day = "0" + day;
        }
        $(".react-datepicker__day--" + day + "").click();
    }
}
