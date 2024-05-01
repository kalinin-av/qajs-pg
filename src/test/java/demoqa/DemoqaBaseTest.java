package demoqa;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DemoqaBaseTest {

    static void beforeAllSuite() {
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "http://127.0.0.1:4444/wd/hub";
    }

    void beforeEachSuite() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    void addAttachments() {
        // screenshot

        // page source

        // console logs

        // video
    }

    @BeforeAll
    static void beforeAll() {
        beforeAllSuite();
    }

    @BeforeEach
    void beforeEach() {
        beforeEachSuite();
    }

    @AfterEach
    void afterEach() {
        addAttachments();
    }
}
