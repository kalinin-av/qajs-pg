package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.component.RegistrationResultsModal;
import demoqa.pages.data.GenderEnum;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationPage {
    private final static String URI = "/automation-practice-form";
    private final SelenideElement
            formNameWrapper = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderMaleRadio = $("input[value=Male]").parent(),
            genderFemaleRadio = $("input[value=Female]").parent(),
            genderOtherRadio = $("input[value=Other]").parent(),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            fileUploadInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropbox = $("#state"),
            cityDropbox = $("#city"),
            submitButton = $("#submit");
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public StudentRegistrationPage openPage() {
        open(URI);
        return this;
    }

    public StudentRegistrationPage openPageWithoutBannerAndFooter() {
        openPage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public StudentRegistrationPage verifyIsStudentRegistrationForm() {
        formNameWrapper.shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationPage setFirstName(final String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setLastName(final String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setEmail(final String value) {
        emailInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setGender(final GenderEnum gender) {
        switch (gender) {
            case MALE -> genderMaleRadio.click();
            case FEMALE -> genderFemaleRadio.click();
            case OTHER -> genderOtherRadio.click();
        }
        return this;
    }

    public StudentRegistrationPage setMobileNumber(final String value) {
        numberInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setDateOfBirth(final int year, final String month, final int day) {
        dateOfBirthInput.click();

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        if (day < 10)
            $(".react-datepicker__day--00" + day + ":not(.react-datepicker__day--outside-month)").click();
        else
            $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }

    public StudentRegistrationPage addSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage addHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationPage uploadFile(String classpath) {
        fileUploadInput.uploadFromClasspath(classpath);
        return this;
    }

    public StudentRegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public StudentRegistrationPage selectState(String state) {
        stateDropbox.click();
        stateDropbox.$(byText(state)).click();
        return this;
    }

    public StudentRegistrationPage selectCity(String city) {
        cityDropbox.click();
        cityDropbox.$(byText(city)).click();
        return this;
    }

    public StudentRegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyResultsModalAppears();
        return this;
    }

    public StudentRegistrationPage verifyDataExists(String value) {
        registrationResultsModal.verifyDataExists(value);
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
