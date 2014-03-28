package mail.pages.messages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Входящие
 */
@DefaultUrl("https://e.mail.ru/cgi-bin/msglist")
@At(urls = {"https://e.mail.ru/cgi-bin/msglist",
        "https://e.mail.ru/messages/inbox"})
public class InboxPage extends PageObject {

    @FindBy(xpath = "//*[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']")
    private WebElementFacade sendMessageButton;

    @FindBy(xpath = "//*[@class='js-href b-datalist__item__link']")
    private WebElementFacade message;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        sendMessageButton.shouldBeEnabled();
    }

    /**
     * Открыть первое письмо
     */
    public void click_on_top_message() {
        message.click();
    }
}