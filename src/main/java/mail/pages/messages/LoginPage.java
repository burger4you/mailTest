package mail.pages.messages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Страница логина
 */
@DefaultUrl("https://e.mail.ru/login")
public class LoginPage extends PageObject {

    @FindBy(name = "Login")
    private WebElementFacade loginField;

    @FindBy(name = "Password")
    private WebElementFacade passwordField;

    @FindBy(name = "Domain")
    private WebElementFacade domainDropDown;

    @FindBy(xpath = "//*[@class='login-page__external__form__button login-page__external__form__button_blue js-login-page__external__submit']")
    private WebElementFacade loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        loginButton.shouldBeEnabled();
    }

    /**
     * Ввести логин
     */
    public void enter_login(String login) {
        enter(login).into(loginField);
    }

    /**
     * Ввести пароль
     */
    public void enter_password(String password) {
        enter(password).into(passwordField);
    }

    /**
     * Выбрать домейн
     */
    public void select_domain(String domain) {
        domainDropDown.selectByValue(domain);
    }

    /**
     * Войти
     */
    public void click_login_button() {
        loginButton.click();
    }
}