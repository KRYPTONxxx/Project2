package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class RegisterPage {

    public SelenideElement register = $(".authorization"),
            registration = $(".register"),
            firstName = $("#pFirstName"),
            lastName = $("#pLastName"),
            email= $("#pEmail"),
            mobileNumber = $("#pPhone"),
            dateBirth = $("#pDateBirth"),
            password = $("#pPassword"),
            repeatPassword = $("#pConfirmPassword"),
            registrationButton = $(byValue("რეგისტრაცია")),
            errorMessage = $("#physicalInfoMassage");
}
