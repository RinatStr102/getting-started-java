import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1420x920";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void successForm() {
        open("/automation-practice-form");
        practiceFormPage
                .setFirstName("Chac")
                .setLastName("Noris")
                .setEmail("test@mail.ru")
                .selectGender()
                .setUserNumber("9112233444")
                .setDateOfBirth("1965", "11", "24")
                .setSubjects("Math")
                .selectHobby()
                .uploadPicture("img/Снимок экрана 2024-09-24 в 12.39.43.png")
                .setAddress("New York")
                .selectState("NCR")
                .selectCity("Noida")
                .submitForm();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Chac"), text("Noris"), text("test@mail.ru"), text("9112233444"));
    }
}
