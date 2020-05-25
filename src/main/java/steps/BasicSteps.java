package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static com.codeborne.selenide.WebDriverRunner.*;

public class BasicSteps {

     @Дано("^Загружена главная страница$")
    public void goToHomePage() {
         String title = getWebDriver().getTitle();
         String expectedValue = "Сбербанк Онлайн";
         assertThat(String.format("Страница не заружена", expectedValue, title), title, containsString(expectedValue));
     }

     @Тогда("^Загружена страница регистрации$")
     public void goToRegistrationPage() {
         String title = getWebDriver().findElement(By.xpath("//h1[contains(text(),'Введите номер карты')]")).getText();
         String expectedValue = "Введите номер карты";
         assertThat(String.format("Страница не заружена", expectedValue, title), title, containsString(expectedValue));
     }

    @Тогда("^Загружена страница подтверждения регистрации смс кодом$")
    public void goToSmsConfirmationPage() {
        String title = getWebDriver().findElement(By.xpath("//h1[contains(text(),'Введите СМС-код')]")).getText();
        String expectedValue = "Введите СМС-код";
        assertThat(String.format("Страница не заружена", expectedValue, title), title, containsString(expectedValue));
    }

    @Когда("^в поле логина введено значение \"(.*)\"$")
    public void setLoginValue(String value) {
         Keys removeKey = isIE() ? Keys.BACK_SPACE : Keys.DELETE;
         WebElement valueInput = getWebDriver().findElement(By.xpath("//input[contains(@id,'loginByLogin')]"));
         valueInput.sendKeys(removeKey);
         valueInput.sendKeys(value);
    }

    @Когда("^в поле пароля введено значение \"(.*)\"$")
    public void setPasswordValue(String value) {
        Keys removeKey = isIE() ? Keys.BACK_SPACE : Keys.DELETE;
        WebElement valueInput = getWebDriver().findElement(By.xpath("//input[contains(@id,'password')]"));
        valueInput.sendKeys(removeKey);
        valueInput.sendKeys(value);
    }

    @Тогда("^Ошибка входа неверный логин иили пароль$")
    public void checkError() {
         String expectedError = "Неверный логин или пароль.";
         String actualError = getWebDriver().findElement(By.xpath("//div//p[contains(text(),'Неверный логин или пароль.')]")).toString();
         assertThat(String.format("Ошибка не показывается", expectedError, actualError), actualError, containsString(expectedError));
    }

    @Когда("^выполнено ожидание в течение (\\d+) (?:секунд|секунды)")
    public void waitForSeconds(long seconds) {
        sleep(1000 * seconds);
    }

    @Тогда("^выполнено нажатие на кнопку Войти$")
    public void clickOnLogin() {
         getWebDriver().findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
    }

    @Тогда("^выполнено нажатие на кнопку Регистраия$")
    public void clickOnRegistry() {
         getWebDriver().findElement(By.xpath("//span[contains(text(),'Регистрация')]")).click();
    }

    @Тогда("^выполнено нажатие на кнопку Продолжить$")
    public void clickOnContinue() {
        getWebDriver().findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();
    }

    @Когда("^в поле номера карты введено значение \"(.*)\"$")
    public void setCardNumberValue(String value) {
        Keys removeKey = isIE() ? Keys.BACK_SPACE : Keys.DELETE;
        WebElement valueInput = getWebDriver().findElement(By.xpath("//input[contains(@id,'cardNumber')]"));
        valueInput.sendKeys(removeKey);
        valueInput.sendKeys(value);
    }



}
