package demoqa.tests;

import com.github.javafaker.Faker;
import demoqa.DemoqaBaseTest;
import demoqa.pages.StudentRegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


public class StudentRegistrationTest extends DemoqaBaseTest {
    private final StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    private final Faker faker = new Faker(Locale.ENGLISH);

    @Test
    void successfulRegistrationTest() {
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String email = faker.internet().emailAddress();

        step("Действие step на google.com, demoqa лежит =(", () -> {
            open("https://google.com/");
        });
        sleep(4000);

        step("Действие step на ya.ru, demoqa лежит =(", () -> {
            open("https://ya.ru/");
        });
        sleep(5000);

        step("Действие step на youtube.com, demoqa лежит =(", () -> {
            open("https://youtube.com/");
        });
        sleep(6000);

//        studentRegistrationPage.openPageWithoutBannerAndFooter()
//                .verifyIsStudentRegistrationForm()
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setEmail(email)
//                .setGender(GenderEnum.MALE)
//                .setMobileNumber("89817263265")
//                .setDateOfBirth(2006, "July", 12)
//                .addSubject("Physics")
//                .addSubject("Math")
//                .addHobby("Music")
//                .uploadFile("img/1.png")
//                .setAddress("Some address 123 123")
//                .selectState("NCR")
//                .selectCity("Delhi")
//                .submit();
//
//        studentRegistrationPage.verifyResultsModalAppears()
//                .verifyDataExists(firstName)
//                .verifyDataExists(lastName)
//                .verifyDataExists(email);
    }
}
