package Steps;

import Pages.HomePage;
import io.qameta.allure.Step;

import java.io.ObjectInputFilter;

public class HomePageSteps {
    HomePage homePage = new HomePage();


    @Step("click on rest")
    public void clickOnRest(){
        homePage.rest.click();
    }

    @Step("click on categories")
    public void clickOnCategories(){
        homePage.categories.click();
    }


    @Step("click on enter button")
    public void clickOnEnter(){
        homePage.enter.click();
    }
}
