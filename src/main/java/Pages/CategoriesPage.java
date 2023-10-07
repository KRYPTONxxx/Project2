package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesPage {
    public SelenideElement inputPrice = $(".sidebar"),
            miniPrice = inputPrice.$("#minprice"),
            maxPrice = inputPrice.$("#maxprice"),
            search = inputPrice.$(byText("ძებნა"));
}
