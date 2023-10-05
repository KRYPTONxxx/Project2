package Steps;

import Data.CategoriesPageData;
import Pages.CategoriesPage;
import Pages.RestPage;
import io.qameta.allure.Step;
//import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CategoriesPageSteps {
    CategoriesPage categoriesPage = new CategoriesPage();

    @Step("scroll to price")
    public CategoriesPageSteps scrollToPrice(){
        executeJavaScript("window.scrollBy(0, 500);");
        return this;
    }

    @Step("inout minimum price")
    public CategoriesPageSteps inputMinPrice(){
        categoriesPage.miniPrice.setValue(CategoriesPageData.minPrice);
        return this;
    }
    @Step("input maximum price")
    public CategoriesPageSteps inputMaxPrice(){
        categoriesPage.maxPrice.setValue(CategoriesPageData.maxPrice);
        return this;
    }

    @Step("click on search")
    public CategoriesPageSteps clickOnSearch(){
        categoriesPage.search.click();
        return this;
    }
}
