package mail.pages.messages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Полученное письмо
 */
@At("https://e.mail.ru/message/1*")
public class MessagePage extends PageObject {

    @FindBy(xpath = "//*[@class='b-toolbar__btn b-toolbar__btn_adaptive b-toolbar__btn_adaptive_rdm-mid b-toolbar__btn_ js-shortcut']")
    private WebElementFacade deleteButton;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        deleteButton.shouldBeEnabled();
    }

    /**
     * Удалить открытое письмо
     */
    public void click_delete_button() {
        deleteButton.click();
    }
}