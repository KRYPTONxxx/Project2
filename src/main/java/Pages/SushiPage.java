package Pages;

import Data.SelectorsInStringData;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SushiPage {


//    private String xPath = "//div[@class = 'special-offer']";

//    public ElementsCollection sellSushi = $$(byXpath("//div[@class = 'special-offer']//div[@class = 'voucher-limit']"));
//    public ElementsCollection  favoriteIconOfSushi = $$(byXpath("//div[@class = 'special-offer']//div[@class = 'dis-price']")),
//            allSushi = $$(byXpath("//div[@class = 'special-offer']//div[@class = 'special-offer-img-container']"));

    public ElementsCollection  sellSushi = $$(byXpath(SelectorsInStringData.specialOfferXpath + "//div[@class = 'voucher-limit']")),
            favoriteIconOfSushi = $$(byXpath(SelectorsInStringData.specialOfferXpath + "//div[@class = 'dis-price']")),
            allSushi = $$(byXpath(SelectorsInStringData.specialOfferXpath + "//div[@class = 'special-offer-img-container']"));



    public SelenideElement filter = $("#sort"),
            decreasingPrice = filter.$(byText("ფასით კლებადი"));



}
