package Steps;

import Data.DbOperationCustomer;
import Data.RegisterPageData;
import Pages.RegisterPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;


import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class RegisterPageSteps {

    RegisterPage registerPage = new RegisterPage();
    DbOperationCustomer dbOperationCustomer = new DbOperationCustomer();
    SoftAssert softAssert = new SoftAssert();

    @Step("check registration window")
    public RegisterPageSteps checkRegisterWindow(){
        registerPage.register.should(Condition.appear);
        return this;
    }

    @Step("click on registration")
    public RegisterPageSteps clickOnRegistration(){
        registerPage.registration.click();
        return this;
    }

    @Step("set firstname")
    public RegisterPageSteps setFirstName(){
        registerPage.firstName.setValue(dbOperationCustomer.getCustomerInfo().get(0)[0].toString());
        return this;
    }

    @Step("set lastname")
    public RegisterPageSteps setLastName(){
        registerPage.lastName.setValue(dbOperationCustomer.getCustomerInfo().get(0)[1].toString());
        return this;
    }

    @Step("set email")
    public RegisterPageSteps setEmail(){
        registerPage.email.setValue(dbOperationCustomer.getCustomerInfo().get(0)[3].toString());
        return this;
    }

    @Step("set mobile number")
    public RegisterPageSteps setMobileNumber(){
        registerPage.mobileNumber.setValue(dbOperationCustomer.getCustomerInfo().get(0)[2].toString());
        return this;
    }

    @Step("set birth date")
    public RegisterPageSteps setDateBirth(){
       Selenide.executeJavaScript("arguments[0].valueAsDate= new Date(arguments[1]);", registerPage.dateBirth, dbOperationCustomer.getCustomerInfo().get(0)[4]);
       return this;
    }

    @Step("set password")
    public RegisterPageSteps setPassword(){
        registerPage.password.setValue(dbOperationCustomer.getCustomerInfo().get(0)[5].toString());
        return this;
    }

    @Step("set repeat password")
    public RegisterPageSteps setRepeatPassword(){
        registerPage.repeatPassword.setValue(dbOperationCustomer.getCustomerInfo().get(0)[5].toString());
        return this;
    }

    @Step("click on registration button")
    public RegisterPageSteps clickOnRegistrationButton(){
        registerPage.registrationButton.click();
        return this;
    }

    @Step("check error message")
    public RegisterPageSteps checkErrorMessage(){
        softAssert.assertEquals(registerPage.errorMessage.getText(),RegisterPageData.errorMessage);
        softAssert.assertAll();
        return this;
    }


}
