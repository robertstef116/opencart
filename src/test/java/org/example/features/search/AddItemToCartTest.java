package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.UserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddItemToCartTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    public UserSteps nina;

    @Test
    public void add_to_cart_test(){
        nina.is_the_home_page();
        nina.click_open_my_account();
        nina.click_go_to_login();
        nina.enter_email("robert@robert.com");
        nina.enter_password("12341234");
        nina.click_login();
        nina.click_open_my_account();
        nina.should_see_complete_my_account_menu();

        nina.go_to_tablets_page();
        nina.should_have_samsung_tab_10_first_item();
        nina.click_add_to_cart_first_item();
        nina.open_cart();
        nina.tablet_should_be_in_cart();
        nina.remove_item_from_cart();

        nina.open_cart();
        nina.cart_should_be_empty();
        nina.click_open_my_account();
        nina.click_my_account_logout();
        nina.should_see_logout_button();
    }
}
