package pages;


import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import org.openqa.selenium.support.FindBy;

@Name("Главная страница")
public class MainPage {

    @Name("Поле_логин")
    @FindBy(xpath = "//input[contains(@id,'loginByLogin')]")
    private SelenideElement LoginInput;

    @Name("Поле_пароль")
    @FindBy(xpath = "//input[contains(@id,'password')]")
    private SelenideElement PasswordInput;

    @Name("Войти")
    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private SelenideElement Login;

}
