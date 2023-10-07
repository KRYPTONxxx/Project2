package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesDropDownPage {
    public SelenideElement feeding = $(by("href", "/category/15/restornebi-da-barebi")),
            sushi = $(byText("სუში"));

}
