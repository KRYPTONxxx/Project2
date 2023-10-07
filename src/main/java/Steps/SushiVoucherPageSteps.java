package Steps;

import Pages.SushiVoucherPage;
import io.qameta.allure.Step;

public class SushiVoucherPageSteps {

    SushiVoucherPage sushiVoucherPage = new SushiVoucherPage();

    @Step("click on share")
    public SushiVoucherPageSteps clickShare(){
        sushiVoucherPage.share.click();
        return this;
    }
}