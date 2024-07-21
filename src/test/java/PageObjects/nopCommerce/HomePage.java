package PageObjects.nopCommerce;
import Common.Constant.Constant;

public class HomePage extends GeneralPage {
    public HomePage open(){
        Constant.WEBDRIVER.navigate().to(Constant.NopCommerce_URL);
        return this;
    }
}
