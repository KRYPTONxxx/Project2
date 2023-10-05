import Data.DbOperationCustomer;
import Pages.CategoriesDropDownPage;
import Steps.*;
import Utils.TakeScreenShot;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.$;
@Listeners({TakeScreenShot.class})

@Epic("Swoop Test")
public class SwoopTest extends ConfigTest{

    HomePageSteps homePageSteps = new HomePageSteps();
    RestPageSteps restPageSteps = new RestPageSteps();

    CategoriesDropDownPageSteps categoriesDropDownPageSteps = new CategoriesDropDownPageSteps();
    SushiPageSteps sushiPageSteps = new SushiPageSteps();
    RegisterPageSteps registerPageSteps = new RegisterPageSteps();
    SushiVoucherPageSteps sushiVoucherPageSteps = new SushiVoucherPageSteps();
    FacebookPageSteps facebookPageSteps = new FacebookPageSteps();
    CategoriesPageSteps categoriesPageSteps = new CategoriesPageSteps();
    DbOperationCustomer dbOperationCustomer = new DbOperationCustomer();


    @org.testng.annotations.Test(description = "elements price are from 200 to 230",groups = {"Regression1"})
    @Feature("scroll to price and set prices")
    @Story("set min and max price")
    @Description("Go to 'დასვენება', put range from 200 to 230 and check that all returned elements on the first page are in selected range")
    public void testMethod1(){
        homePageSteps.clickOnRest();
        categoriesPageSteps.
                scrollToPrice().
                inputMinPrice().
                inputMaxPrice().
                clickOnSearch();
        restPageSteps.
                checkPriceRange();
    }


    @org.testng.annotations.Test(description = "add first returned item to favorites",groups = {"Regression1"})
    @Feature("Enter sushi voucher")
    @Story("Checking Register Window")
    @Description("Go to 'კატეგორიები', hover on 'კვება' and click on 'სუში', check vouchers are not sold out and add first returned item to favorites list and verify that Login Window has appeared")
    public void testMethod2(){
        homePageSteps.clickOnCategories();
        categoriesDropDownPageSteps.
                hoverOnFeed().
                clickOnSushi();
        sushiPageSteps.clickSushiItem();
        registerPageSteps.checkRegisterWindow();

    }

    @org.testng.annotations.Test(description = "sort item by decrease",groups = {"Regression2"})
    @Feature("Filter Price")
    @Story("Checking price")
    @Description("Go to 'კატეგორიები',hover on 'კვება' and click on 'სუში', sort element with 'ფასი კლებადი' and Check that the price of the first item is higher than the price of the second item")
    public void testMethod3(){
        homePageSteps.clickOnCategories();
        categoriesDropDownPageSteps.
                hoverOnFeed().
                clickOnSushi();
        sushiPageSteps.
                clickOnFilter().
                clickOnDecreasingPrice().
                checkHigherPrice();
    }

    @org.testng.annotations.Test(description = "navigate to first suhi voucher",groups = {"Regression2"})
    @Feature("click share button")
    @Story("checking facebook window")
    @Description("go to 'კატეგორიები',hover on 'კვება' and click on 'სუში',navigate to the first returned item, click on ‘გაზიარება’,validate that window with Facebook login page has appeared")
    public void testMethod4(){
        homePageSteps.clickOnCategories();
        categoriesDropDownPageSteps.
                hoverOnFeed().
                clickOnSushi();
        sushiPageSteps.clickFirstSushi();
        sushiVoucherPageSteps.clickShare();
        facebookPageSteps.checkFacebookWindow();
    }


    @org.testng.annotations.Test(description = "Register for new account",groups = {"Regression2"})
    @Feature("Insert,Select and Delete of data")
    @Story("use database")
    @Description("Register for new account 'ფიზიკური პირი&',fill all mandatory fields, except Gender and check that error message ‘გთხოვთ აირჩიოთ სქესი!’ is appear")
    public void testMethod5() throws SQLException {
      dbOperationCustomer.insertCustomerInfo();
      homePageSteps.clickOnEnter();
      registerPageSteps.clickOnRegistration().
                setFirstName().
                setLastName().
                setEmail().
                setMobileNumber().
                setDateBirth().
                setPassword().
                setRepeatPassword().
                clickOnRegistrationButton().
                checkErrorMessage();
        dbOperationCustomer.deleteCustomerInfo();
    }



}
