package Steps;

import Pages.RestPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import org.testng.asserts.SoftAssert;
public class RestPageSteps{
    RestPage restPage = new RestPage();
    SoftAssert softAssert = new SoftAssert();


    @Step("Get list of price")
    public List<Integer> getPriceList(){
        restPage.bodyUnset.should(Condition.appear);
        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < restPage.rangeList.size(); i++) {
            SelenideElement element = restPage.rangeList.get(i).$$(byXpath(".//p[@class ='deal-voucher-price']")).first();
            int price = Integer.parseInt(element.getText().trim().replace("₾",""));
            priceList.add(price);
        }
        return priceList;
    }


    @Step("check price range")
    public RestPageSteps checkPriceRange(){
        List<Integer> priceList = getPriceList();
        for (int i = 0; i < priceList.size(); i++) {
            if (!(priceList.get(i) >= 200 && priceList.get(i) <= 230)){
                softAssert.fail();
            }
        }
        softAssert.assertAll();
        return this;
    }





}
