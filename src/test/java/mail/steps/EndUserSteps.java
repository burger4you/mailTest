package mail.steps;

import mail.pages.messages.ComposePage;
import mail.pages.messages.InboxPage;
import mail.pages.messages.LoginPage;
import mail.pages.messages.MessagePage;
import mail.pages.settings.MessagesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Библиотека шагов пользователя, зарегестрированного на mail.ru
 */
public class EndUserSteps extends ScenarioSteps {

    LoginPage mainPage;
    InboxPage inboxPage;
    ComposePage createMessagePage;
    MessagesPage settingsMessagesPage;
    MessagePage messagePage;

    public EndUserSteps(Pages pages) {
        super(pages);
    }

    /**
     * Логинится на сайт
     * @param login - логин
     * @param password - пароль
     */
    @Step
    public void logs_on_mail(String login, String password) {
        mainPage.open();
        mainPage.enter_login(login);
        mainPage.enter_password(password);
        mainPage.click_login_button();
        inboxPage.shouldBeDisplayed();
    }

    /**
     * Отправляет письмо
     *
     * @param toAddress - кому
     * @param subject - тема письма
     * @param body - тело письма
     * @param numberOfMessages - количество писем
     */
    @Step
    public void sends_messages(String toAddress, String subject, String body, int numberOfMessages) {
        for (int i = 0; i < numberOfMessages; i++) {
            createMessagePage.open();
            createMessagePage.enter_to(toAddress);
            createMessagePage.enter_subject(subject);
            createMessagePage.click_simple_body_link();
            createMessagePage.enter_body(body);
            createMessagePage.click_send_button();
        }
    }

    /**
     * Устанавливает в настройках отображение следующего письма после удаления текущего
     */
    @Step
    public void sets_in_settings_show_next_message_after_deleting_message() {
        settingsMessagesPage.open();
        settingsMessagesPage.select_show_next_message();
        settingsMessagesPage.click_save_button();
        settingsMessagesPage.waitForTextToDisappear("Хочу получать информационные рассылки");
    }

    /**
     * Устанавливает в настройках отображение списка писем после удаления текущего письма
     */
    @Step
    public void sets_in_settings_show_list_of_subjects_after_deleting_message() {
        settingsMessagesPage.open();
        settingsMessagesPage.select_show_list_of_subjects();
        settingsMessagesPage.click_save_button();
        settingsMessagesPage.waitForTextToDisappear("Хочу получать информационные рассылки");
    }

    /**
     * Удаляет верхнее письмо
     */
    @Step
    public void deletes_top_message() {
        inboxPage.open();
        inboxPage.click_on_top_message();
        messagePage.callWhenPageOpensMethods();
        messagePage.click_delete_button();
    }

    /**
     * Находится на странице следующего письма
     */
    @Step
    public void is_on_next_message_page() {
        assertThat(getDriver().getCurrentUrl())
                .contains(getPages().getDefaultBaseUrl() + "/message/");
    }

    /**
     * Находится на странице списка тем писем
     */
    @Step
    public void is_on_list_of_subjects_page() {
        inboxPage.shouldBeDisplayed();
    }
}