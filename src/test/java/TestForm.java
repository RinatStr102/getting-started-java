import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
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
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();
    String subject = "Math";
    String state = "NCR";
    String city = "Noida";


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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender()
                .setUserNumber(userNumber)
                .setDateOfBirth("1965", "11", "24")
                .setSubjects(subject)
                .selectHobby()
                .uploadPicture("img/Снимок экрана 2024-09-24 в 12.39.43.png")
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(email), text(userNumber));
    }
}
