package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void registrationClick() {
        registrationPage.registrationButton.click();
    }

    @Test(testName = "Регистрация без ввода FirstName",
            description = "Тест с проверкой невозможности регистрации без ввода значения в поле Имя")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutFirstNameTest() {
        registrationPage.createNewAccount("", "Фамилия", "test@mail.ru", "qaz123wsx123",
                        "qaz123wsx123")
                .createFirstError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация без ввода LastName",
            description = "Тест с проверкой невозможности регистрации без ввода значения в поле Фамилия")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutLastNameTest() {
        registrationPage.createNewAccount("Имя",
                        "", "test@mail.ru", "qaz123wsx123", "qaz123wsx123")
                .createLastError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация без ввода Email",
            description = "Тест с проверкой невозможности регистрации без ввода значения в поле Электронная почта")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutEmailAddressTest() {
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "", "qaz123wsx123", "qaz123wsx123")
                .createEmailError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация без ввода Password",
            description = "Тест с проверкой невозможности регистрации без ввода значения в поле Пароль")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutPasswordTest() {
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "test@mail.ru", "", "qaz123wsx123")
                .passwordMeterError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация без ввода Re-type password",
            description = "Тест с проверкой невозможности регистрации без ввода значения в поле Re-type password")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutReTypePasswordTest() {
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "test@mail.ru", "qaz123wsx123", "")
                .createPasswordMatchError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация без выбора значения в поле Time Zone",
            description = "Тест с проверкой невозможности регистрации с пустым значением в поле Time Zone")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountWithoutTimeZoneTest() {
        registrationPage.timeZoneSelect.selectOptionContainingText("Select...");
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "test@mail.ru", "qaz123wsx123", "qaz123wsx123")
                .timeZoneError.shouldHave(exactText("This field is required."));
    }

    @Test(testName = "Регистрация с несовпадающими значениями в полях Password и Re-type password",
            description = "Тест с проверкой невозможности авторизации с несовпадающими паролями")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountNotMatchedPasswordTest() {
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "test@mail.ru", "MRS567kih897", "MRS567kih")
                .alertError.shouldHave(exactText("Error: The passwords you entered did not match."));
    }

    @Test(testName = "Регистрация с некорректным паролем",
            description = "Тест с проверкой невозможности авторизации при вводе невалидного значения в поле Пароль")
    @Epic("FinalSurge 1.0")
    @Feature("Регистрация")
    public void createAccountTwoPasswordsFailedTest() {
        registrationPage.createNewAccount("Имя",
                        "Фамилия", "test@mail.ru", "qaz123wsx123", "qaz123wsx123")
                .alertError.shouldHave(exactText("Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length."));
    }
}