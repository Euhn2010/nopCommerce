package PageObjects.nopCommerce;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class SearchPage extends GeneralPage{
    private final By _txtSearchstore=By.xpath("//input[@id='small-searchterms']");
    private final By _btnSearch=By.xpath("//button[@class='button-1 search-box-button']");
    private final By _lblSearchnoresult=By.xpath("//div[@class='no-result']");
    private final By _btnviewProduct=By.xpath("//a[@class='viewmode-icon list']");
    private final By _txtProductTitle=By.xpath("//h2[@class='product-title']");

    public WebElement getTxtProductTitle(){
        return Constant.WEBDRIVER.findElement(_txtProductTitle);
    }
    public WebElement getBtnViewProduct(){
        return Constant.WEBDRIVER.findElement(_btnviewProduct);
    }
    public WebElement getTxtSearchstore(){
        return Constant.WEBDRIVER.findElement(_txtSearchstore);
    }
    public WebElement getBtnSearch(){
        return Constant.WEBDRIVER.findElement(_btnSearch);
    }
    public WebElement getlblSearchnoresult(){
        return Constant.WEBDRIVER.findElement(_lblSearchnoresult);
    }

    public HomePage search(String searchstore){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.getTxtSearchstore().sendKeys(searchstore);
        this.getBtnSearch().click();
        return new HomePage();

    }
}
