package Steps;

import Pages.FacebookPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.Set;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FacebookPageSteps {
    FacebookPage facebookPage = new FacebookPage();

    @Step("check Facebook Window")
    public FacebookPageSteps checkFacebookWindow(){
        switchTo().window("Facebook");
        facebookPage.facebook.should(Condition.appear);
        return this;
    }


}
