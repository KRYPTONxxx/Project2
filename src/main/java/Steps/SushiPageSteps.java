package Steps;


import Pages.SushiPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SushiPageSteps {
    SoftAssert softAssert = new SoftAssert();
    SushiPage sushiPage = new SushiPage();
    RestPageSteps restPageSteps = new RestPageSteps();


    @Step("click on filter")
    public SushiPageSteps clickOnFilter(){
        sushiPage.filter.click();
        return this;
    }

    @Step("click on decreasing price")
    public SushiPageSteps clickOnDecreasingPrice(){
        sushiPage.decreasingPrice.setSelected(true);
        return this;
    }


    @Step("check vouchers")
    public int checkVouchers(){
        for (int i = 0; i < sushiPage.sellSushi.size(); i++) {
            if (Double.parseDouble(sushiPage.sellSushi.get(i).getAttribute("data-width")) < 100) {
                return i;
            }
        }
        softAssert.fail();
        softAssert.assertAll();
        return -1;
    }


    @Step("click sushi item")
    public SushiPageSteps clickSushiItem(){
        sushiPage.favoriteIconOfSushi.get(checkVouchers()).click();
        return this;
    }

    @Step("click first sushi item")
    public SushiPageSteps clickFirstSushi() {
        sushiPage.allSushi.get(0).click();
        return this;
    }

    @Step("check higher price")
    public SushiPageSteps checkHigherPrice(){
        List<Integer> priceList = restPageSteps.getPriceList();
        for (int i = 0; i < priceList.size()-1; i++) {
            if (!(priceList.get(i) >= priceList.get(i+1))){
                softAssert.fail();
            }
        }
        softAssert.assertAll();
        return this;
    }

}
