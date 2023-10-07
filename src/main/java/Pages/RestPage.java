package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RestPage {
    public ElementsCollection rangeList = $$(byXpath("//div[@class = 'discounted-prices']"));
    public SelenideElement bodyUnset = $(byXpath("//body[@style = 'overflow: unset;']"));

}

