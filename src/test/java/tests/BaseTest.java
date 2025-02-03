package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        open("https://log.finalsurge.com/");
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 10000;
        registrationPage = new RegistrationPage();
    }
}