package mail.pages.messages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Написание письма
 */
@DefaultUrl("https://e.mail.ru/compose")

public class ComposePage extends PageObject {

    @FindBy(xpath = "//*[@data-original-name='To']")
    private WebElementFacade toField;

    @FindBy(name = "Subject")
    private WebElementFacade subjectField;

    @FindBy(xpath = "//*[text()='Убрать оформление']")
    private WebElementFacade simpleBodyLink;

    @FindBy(name = "Body")
    private WebElementFacade bodyField;

    @FindBy(xpath = "//*[@title='Отправить']")
    private WebElementFacade sendButton;

    public ComposePage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        toField.shouldBeEnabled();
        subjectField.shouldBeEnabled();
    }

    /**
     * Ввести адрес Кому письмо
     */
    public void enter_to(String toAddress) {
        enter(toAddress).into(toField);
    }

    /**
     * Ввести Тему письма
     */
    public void enter_subject(String subject) {
        enter(subject).into(subjectField);
    }

    /**
     * Убрать оформление
     */
    public void click_simple_body_link() {
        simpleBodyLink.click();
    }

    /**
     * Ввести Тело письма
     */
    public void enter_body(String body) {
        enter(body).into(bodyField);
    }

    /**
     * Кликнуть отправить
     */
    public void click_send_button() {
        sendButton.click();
    }
}