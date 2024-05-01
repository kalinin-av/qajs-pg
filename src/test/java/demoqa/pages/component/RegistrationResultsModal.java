package demoqa.pages.component;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void verifyResultsModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyDataExists(final String value) {
        $(".table-responsive").shouldHave(text(value));
    }
}
