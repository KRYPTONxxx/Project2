package Steps;

import Pages.CategoriesDropDownPage;
import io.qameta.allure.Step;

public class CategoriesDropDownPageSteps {
    CategoriesDropDownPage categoriesDropDownPage = new CategoriesDropDownPage();

    @Step("Hover on Feed")
    public CategoriesDropDownPageSteps hoverOnFeed(){
        categoriesDropDownPage.feeding.hover();
        return this;
    }

    @Step("click on sushi")
    public CategoriesDropDownPageSteps clickOnSushi(){
        categoriesDropDownPage.sushi.click();
        return this;
    }
}
