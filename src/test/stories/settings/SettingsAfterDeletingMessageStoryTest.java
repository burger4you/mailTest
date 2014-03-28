package settings;

import mail.requirements.Mail.Settings.Messages;
import mail.steps.EndUserSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Набор тестов проверяющих настройки "Работа с письмами"
 */
@Story(Messages.class)
@RunWith(ThucydidesRunner.class)
public class SettingsAfterDeletingMessageStoryTest {

    private static final String LOGIN = "special.for.test";
    private static final String PASSWORD = "Test1234";
    private static final String TO = "special.for.test@mail.ru";
    private static final String SUBJECT = "Тестовая тема письма";
    private static final String BODY = "Тестовое тело письма";

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://e.mail.ru")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    /**
     * Настройка отображения следующего письма после удаления текущего
     */
    @Test
    @WithDriver("chrome")
    public void selecting_show_next_message_after_deleting_message() {
        endUser.logs_on_mail(LOGIN, PASSWORD);
        endUser.sends_messages(TO, SUBJECT, BODY, 0);
        endUser.sets_in_settings_show_next_message_after_deleting_message();
        endUser.deletes_top_message();
        endUser.is_on_next_message_page();
    }

    /**
     * Настройка отображения списка тем писем после удаления текущего письма
     */
    @Test
    @WithDriver("firefox")
    public void selecting_show_list_of_subjects_after_deleting_message() {
        endUser.logs_on_mail(LOGIN, PASSWORD);
        endUser.sends_messages(TO, SUBJECT, BODY, 0);
        endUser.sets_in_settings_show_list_of_subjects_after_deleting_message();
        endUser.deletes_top_message();
        endUser.is_on_list_of_subjects_page();
    }
}