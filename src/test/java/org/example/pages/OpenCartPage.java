package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://opencart.abstracta.us/index.php?route=common/home")
public class OpenCartPage extends PageObject {

    @FindBy(className = "dropdown")
    private WebElementFacade myAccountButton;

    @FindBy(name = "email")
    private WebElementFacade emailInputField;

    @FindBy(name = "password")
    private WebElementFacade passwordInputField;

    @FindBy(jquery = "[value|='Login']")
    private WebElementFacade mainLoginButton;

    public void open_my_account() {
        myAccountButton.click();
    }

    public void open_my_account_login() {
        (myAccountButton.findElements(By.tagName("li")).get(1).findElement(By.tagName("a"))).click();
    }

    public void enter_email(String email) {
        emailInputField.type(email);
    }

    public void enter_password(String password) {
        passwordInputField.type(password);
    }

    public void login() {
        mainLoginButton.click();
    }

    public List<String> get_my_account_options() {
        return (myAccountButton.findElements(By.tagName("li")).stream().map(WebElement::getText).collect(Collectors.toList()));
    }

    public String get_error_message() {
        return find(By.className("alert-danger")).getText();
    }

    public void open_tablets_page() {
        find(By.className("navbar-nav")).findElements(By.tagName("li")).get(12).findElement(By.tagName("a")).click();
    }

    public String get_first_item_name() {
        return find(By.className("product-thumb")).findElements(By.tagName("a")).get(1).getText();
    }

    public void add_first_product_to_cart() {
        find(By.className("button-group")).findElements(By.tagName("button")).get(0).click();
    }

    public void open_cart() {
        find(By.id("cart")).findElements(By.tagName("button")).get(0).click();
    }

    public String get_first_cart_item_name() {
        return find(By.className("text-left")).findElement(By.tagName("a")).getText();
    }

    public void press_remove_cart_item_button() {
        find(By.className("btn-xs")).click();
    }

    public String get_cart_message() {
        return findAll(By.className("pull-right")).get(1).findElement(By.tagName("p")).getText();
    }

    public void click_my_account_logout() {
        myAccountButton.findElements(By.tagName("li")).get(4).click();
    }

    public String get_logout_message() {
        return find(By.className("col-sm-9")).findElement(By.tagName("h1")).getText();
    }
}