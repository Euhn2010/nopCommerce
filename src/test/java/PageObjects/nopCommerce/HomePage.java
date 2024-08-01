package PageObjects.nopCommerce;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.NopCommerce_URL);
        return this;
    }
}
