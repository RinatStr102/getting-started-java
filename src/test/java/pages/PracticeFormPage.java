package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderRadioButton = $("label[for='gender-radio-3']");
    private SelenideElement userButtonInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckbox = $("label[for='hobbies-checkbox-2']");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateDropdown = $("#state");
    private SelenideElement cityDropdown = $("#city");
    private SelenideElement submitButton = $("#submit");

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage selectGender() {
        genderRadioButton.click();
        return this;
    }

    public PracticeFormPage setUserNumber(String userNumber) {
        userButtonInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public PracticeFormPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby() {
        hobbiesCheckbox.click();
        return this;
    }

    public PracticeFormPage uploadPicture(String picturePath) {
        uploadPicture.uploadFromClasspath(picturePath);
        return this;
    }

    public PracticeFormPage setAddress(String address){
        currentAddressInput.setValue(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateDropdown.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        cityDropdown.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }
}
