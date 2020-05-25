package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.WebDriverRunner.*;

public class BasicSteps {


    MainPage mainPage = new MainPage();
    RegistrationPage registrationPage = new RegistrationPage();

     @Given ("^I open a browser$")
    public void goToHomePage() {
        String title = getWebDriver().getTitle();
        assertEquals(title, "Сбербанк Онлайн");
    }

}
