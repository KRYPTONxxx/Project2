package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public SelenideElement rest = $(".Menus").$(by("href", "/category/24/dasveneba")),
            categories = $(".categoriesTitle"),
            enter = $(byText("შესვლა"));
}
