package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.id;

public class RegistrationPage {

    public SelenideElement registrationButton = $x("//a/strong[text() = 'Not registered?']");
    public SelenideElement createNewAccountButton = $x("//button[text() = 'Create New Account']");
    public SelenideElement createFirst = $(id("create_first"));
    public SelenideElement createFirstError = $x("//label[@for = 'create_first' and @class = 'error']");
    public SelenideElement createLast = $(id("create_last"));
    public SelenideElement createLastError = $x("//label[@for = 'create_last' and @class = 'error']");
    public SelenideElement createEmail = $(id("create_email"));
    public SelenideElement createEmailError = $x("//label[@for = 'create_email' and @class = 'error']");
    public SelenideElement passwordMeter = $(id("password_meter"));
    public SelenideElement passwordMeterError = $x("//label[@for = 'password_meter' and @class = 'error']");
    public SelenideElement createPasswordMatch = $(id("create_passwordmatch"));
    public SelenideElement createPasswordMatchError = $x("//label[@for = 'create_passwordmatch' and @class = 'error']");
    public SelenideElement timeZoneSelect = $(id("create_timezone"));
    public SelenideElement timeZoneError = $x("//label[@for = 'create_timezone' and @class = 'error']");
    public SelenideElement alertError = $x("//div[@class = 'alert alert-error']");

    @Step("Ввод данных на форме регистрации")
    public RegistrationPage createNewAccount(String createFirst, String createLast, String createEmail, String passwordMeter,
                                             String createPasswordMatch) {
        this.createFirst.setValue(createFirst);
        this.createLast.setValue(createLast);
        this.createEmail.setValue(createEmail);
        this.passwordMeter.setValue(passwordMeter);
        this.createPasswordMatch.setValue(createPasswordMatch);
        createNewAccountButton.click();
        return this;
    }
}