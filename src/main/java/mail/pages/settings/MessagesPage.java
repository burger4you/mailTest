package mail.pages.settings;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Работа с письмами
 */
@DefaultUrl("https://e.mail.ru/stories/messages")
public class MessagesPage extends PageObject {

    @FindBy(id = "MessagesPerPage")
    private WebElementFacade numberOfPagesDropDown;

    @FindBy(id = "snippets")
    private WebElementFacade beginningMessageCheckbox;

    @FindBy(id = "messageline-style")
    private WebElementFacade compactMessageCheckbox;

    @FindBy(id = "incl_cont")
    private WebElementFacade initialMessageCheckbox;

    @FindBy(id = "clear_fol")
    private WebElementFacade clearTrashCheckbox;

    @FindBy(id = "afterDelete0")
    private WebElementFacade nextMessageRadioButton;

    @FindBy(id = "afterDelete1")
    private WebElementFacade topicsListRadioButton;

    @FindBy(id = "InsertAddress")
    private WebElementFacade insertAddressCheckbox;

    @FindBy(id = "send_ads")
    private WebElementFacade sendInfoCheckbox;

    @FindBy(xpath = "//*[text()='Сохранить']")
    private WebElementFacade submitButton;

    @FindBy(xpath = "//*[text()='Отменить']")
    private WebElementFacade cancelButton;

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void loading() {
        submitButton.shouldBeEnabled();
    }

    public void select_number_of_pages(String numberOfPages) {
        numberOfPagesDropDown.selectByValue(numberOfPages);
    }

    public void check_show_beginning_of_message() {
        beginningMessageCheckbox.click();
    }

    public void check_show_compact_message() {
        compactMessageCheckbox.click();
    }

    public void check_show_initial_message() {
        initialMessageCheckbox.click();
    }

    public void check_clear_trash() {
        clearTrashCheckbox.click();
    }

    /**
     * После удаления письма переходить к следующему письму
     */
    public void select_show_next_message() {
        nextMessageRadioButton.click();
    }

    /**
     * После удаления письма переходить к списку писем
     */
    public void select_show_list_of_subjects() {
        topicsListRadioButton.click();
    }

    public void check_save_new_addresses() {
        insertAddressCheckbox.click();
    }

    public void check_send_info() {
        sendInfoCheckbox.click();
    }

    /**
     * Сохранить
     */
    public void click_save_button() {
        submitButton.click();
    }

    /**
     * Отменить
     */
    public void click_cancel_button() {
        cancelButton.click();
    }
}