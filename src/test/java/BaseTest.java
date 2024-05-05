import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.guru.qa.school.pages.FormPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public final FormPage formPage;

    public BaseTest() {
        this.formPage = new FormPage();
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setUp() {
        open("/automation-practice-form");

        formPage.removeElements();
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }
}
