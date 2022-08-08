package mapsme.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainScreen {
    private AndroidDriver driver;

    public MainScreen() {
    }

    public MainScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Search button
    //@AndroidFindBy(xpath = ".//android.view.View[@resource-id='bottom_bar_search']")
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='bottom bar icon'])[1]")
    private WebElement searchButton;

    //@AndroidFindBy(xpath = ".//android.view.View[@resource-id='bottom_bar_routes']")
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='bottom bar icon])[2]")
    private WebElement routeButton;

    @AndroidFindBy(xpath = ".//android.widget.ImageView[@content-desc='Zoom In']")
    private WebElement zoomInButton;


    //Click search button
    public void clickSearchButton() {
        this.searchButton.click();
    }

    //Click route button
    public void clickRouteButton() {
        this.routeButton.click();
    }

    //Is search button displayed
    public boolean isSearchButton() {
        return searchButton.isDisplayed();
    }

    //Is route button displayed
    public boolean isRouteButton() {
        return routeButton.isDisplayed();
    }
}
