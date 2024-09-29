import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {
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
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Chac");
        $("#lastName").setValue("Noris");
        $("#userEmail").setValue("test@mail.ru");
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("9112233444");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1965");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day--024").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Math");
        $(".subjects-auto-complete__option").click();
        $("label[for='hobbies-checkbox-2']").click();
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/Снимок экрана 2024-09-24 в 12.39.43.png"));
        $("#uploadPicture").uploadFromClasspath("img/Снимок экрана 2024-09-24 в 12.39.43.png");
        $("#currentAddress").setValue("New York");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Chac"), text("Noris"), text("test@mail.ru"), text("9112233444"));
    }
}
