package mapsme.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class RouteBottomSheet {
    private AndroidDriver driver;

    public RouteBottomSheet() {
    }

    public RouteBottomSheet(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //@AndroidFindBy(xpath = ".//android.widget.TextView[@text='Route']")
    //private WebElement routeTitle;

    @AndroidFindBy(xpath = ".//android.view.View[@content-desc='finish icon']")
    private WebElement finishIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='closeButton']")
    private WebElement closeRouteSheetButton;

    //Is route title displayed
    /*public boolean isRouteTitle() {
        return routeTitle.isDisplayed();
    }*/

    //Is finish icon displayed
    public boolean isFinishIcon() {
        return finishIcon.isDisplayed();
    }

    //Close route sheet
    public void clickCloseButton() {
        this.closeRouteSheetButton.click();
    }
}