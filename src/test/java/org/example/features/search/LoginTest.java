package org.example.features.search;

import com.google.gson.JsonObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.UserSteps;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.net.URISyntaxException;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public UserSteps nina;

    @Test
    public void test_login_valid() {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject data = (JSONObject) jsonParser.parse(new FileReader("src/test/resources/validLoginData.json"));
            login_valid((String)data.get("email"), (String)data.get("password"));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_login_invalid() {
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject data = (JSONObject) jsonParser.parse(new FileReader("src/test/resources/invalidLoginData.json"));
            login_invalid((String)data.get("email"), (String)data.get("password"));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public void login_valid(String email, String password) {
        nina.is_the_home_page();
        nina.click_open_my_account();
        nina.click_go_to_login();
        nina.enter_email(email);
        nina.enter_password(password);
        nina.click_login();
        nina.click_open_my_account();
        nina.should_see_complete_my_account_menu();
    }

    public void login_invalid(String email, String password) {
        nina.is_the_home_page();
        nina.click_open_my_account();
        nina.click_go_to_login();
        nina.enter_email(email);
        nina.enter_password(password);
        nina.click_login();
        nina.should_see_login_error();
//        nina.click_open_my_account();
//        nina.should_see_complete_my_account_menu();
    }
}
