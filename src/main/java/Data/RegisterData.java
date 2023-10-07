package Data;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.JavascriptExecutor;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import java.sql.Date;

public class RegisterData {
    static final String firstName = "Alfred", lastName = "Hitchcock", phoneNumber = "577151515", email = "Alfred@gmail.com", password = "password";
    static final Date dateOfBirth = Date.valueOf("1899-08-13");
}
