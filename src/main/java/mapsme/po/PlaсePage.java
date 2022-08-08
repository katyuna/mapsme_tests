package mapsme.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PlaсePage {
    private AndroidDriver driver;

    public PlaсePage() {
    }

    public PlaсePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = ".//android.view.View[@content-desc='Back icon']")
    private WebElement backArrow;

    @AndroidFindBy(xpath = ".//android.view.View[@content-desc='Marker coordinates icon']")
    private WebElement markerCoordinatesIcon;

    public boolean isBackArrow() {
        return backArrow.isDisplayed();
    }

    //Close place page
    public void clickBackArrow() {
        this.backArrow.click();
    }

    //Is Marker coordinates icon displayed
    public boolean isMarkerCoordinatesIcon() {
        return markerCoordinatesIcon.isDisplayed();
    }
}
