package org.example.steps.serenity;

import groovy.util.logging.Log4j;
import net.thucydides.core.annotations.Step;
import org.example.pages.OpenCartPage;

import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserSteps {
    OpenCartPage openCartPage;

    @Step
    public void click_open_my_account() {
        openCartPage.open_my_account();
    }

    @Step
    public void click_go_to_login() {
        openCartPage.open_my_account_login();
    }

    @Step
    public void is_the_home_page() {
        openCartPage.open();
    }

    @Step
    public void enter_email(String email) {
        openCartPage.enter_email(email);
    }

    @Step
    public void enter_password(String password) {
        openCartPage.enter_password(password);
    }

    @Step
    public void click_login() {
        openCartPage.login();
    }

    @Step
    public void should_see_complete_my_account_menu() {
        List<String> options = openCartPage.get_my_account_options();
        System.out.println(options);
        assertThat("should have 5 items", options.size() == 5);
        assertThat("should have the order history option", options.contains("Order History"));
        assertThat("should have the logout option", options.contains("Logout"));
    }

    @Step
    public void should_see_login_error() {
        assertThat("should have warning", openCartPage.get_error_message().startsWith("Warning"));
    }

    @Step
    public void go_to_tablets_page() {
        openCartPage.open_tablets_page();
    }

    @Step
    public void should_have_samsung_tab_10_first_item() {
        assertThat("item should be Samsung Galaxy Tab 10.1", openCartPage.get_first_item_name().equals("Samsung Galaxy Tab 10.1"));
    }

    @Step
    public void click_add_to_cart_first_item() {
        openCartPage.add_first_product_to_cart();
    }

    @Step
    public void open_cart() {
        openCartPage.open_cart();
    }

    @Step
    public void tablet_should_be_in_cart() {
        assertThat("tablet should be in cart", openCartPage.get_first_cart_item_name().endsWith("Samsung Galaxy Tab 10.1"));
    }

    @Step
    public void remove_item_from_cart() {
        openCartPage.press_remove_cart_item_button();
    }

    @Step
    public void cart_should_be_empty() {
        assertThat("cart should be empty", openCartPage.get_cart_message().equals("Your shopping cart is empty!"));
    }

    @Step
    public void click_my_account_logout() {
        openCartPage.click_my_account_logout();
    }

    @Step
    public void should_see_logout_button() {
        assertThat("should see logout button", openCartPage.get_logout_message().equals("Account Logout"));
    }
}
