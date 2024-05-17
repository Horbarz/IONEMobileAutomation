package pages;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

public class Utils {
    static double SCROLL_RATIO = 0.5;

    static double MID_RATIO = 0.5;
    static Duration SCROLL_DUR = Duration.ofMillis(500);

    static AppiumDriver driver;

    public Utils(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement containsText(String elementText){
        By textBy = By.xpath("//*[contains(@content-desc,'"+elementText+"')]");
        WebElement el = driver.findElement(textBy);
        return el;
    }

    public boolean verifyElementPresent(By by) throws IOException {
        boolean isElement = false;
        try
        {
            if (driver.findElement(by) != null)
            {
                isElement = true;
                return isElement;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Element not found");
            isElement = false;
            return isElement;
        }
        return isElement;
    }

    public boolean isTextPresent(String text){
        try{
            driver.findElement(AppiumBy.accessibilityId(text));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void goBack(){
        driver.navigate().back();
    }

    public WebElement PageText(String text){
        String uiText = String.format("new UiSelector().text('%s')", text);
        return driver.findElement(MobileBy.AndroidUIAutomator(uiText));
    }

    public static void scrollNclick(By listItems, String attrName, String text) throws InterruptedException {
        String prevPageSource = "";
        boolean flag = false;

        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = driver.getPageSource();

            for (WebElement el : driver.findElements(listItems)) {

                if (el.getAttribute(attrName).equalsIgnoreCase(text)) {
                    el.click();
                    flag = true; //come out of the for loop
                    break;
                }
            }
            if (flag)
                break; //come out of the while loop
            else {
                scroll(ScrollDirection.DOWN, Utils.SCROLL_RATIO,null);
                Thread.sleep(1000);
            }

        }

    }

    public static void scrollNclick(By byEl) {
        String prevPageSource = "";
        boolean flag = false;

        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = driver.getPageSource();

            try {
                driver.findElement(byEl).click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                scroll(ScrollDirection.DOWN, Utils.SCROLL_RATIO,null);
            }
        }

    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

    public static boolean isEndOfPage(String pageSource) {
        return pageSource.equals(driver.getPageSource());
    }

    public static void scroll(ScrollDirection dir, double scrollRatio, WebElement element) {
        Dimension size;
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        if(element != null){
            size = element.getSize(); //get the dimensions
        }else{
            size = driver.manage().window().getSize(); //get the dimensions
        }
        System.out.println(size); //print the size of the screen
        Point midPoint = new Point((int) (size.width * MID_RATIO), (int) (size.height * MID_RATIO)); // get the midpoint of the screen
        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio); //get the bottom point cos it is the starting point scrolling up
        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
        //Point Start = new Point(midPoint.x, bottom );
        //Point End = new Point(midPoint.x, top );
        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
        int right = midPoint.x + (int) (midPoint.x * scrollRatio);

        if (dir == ScrollDirection.UP) {
            //swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
            swipe(new Point(362, 711), new Point(362, 1000), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(678, 245), new Point(80, 245), SCROLL_DUR);
            //swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    protected static void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        /*if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }*/
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver)driver).perform(ImmutableList.of(swipe));
    }

    public static void tapOnElement(WebElement element){

        Point location = element.getLocation();
        Dimension elementSize = element.getSize();
        Point centerOfElement = getCenterElement(location,elementSize);

        System.out.println(centerOfElement.getX());
        System.out.println(centerOfElement.getY());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public static void tapOnCoordinates(int x, int y){
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),new Point(x,y)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterElement(Point location, Dimension size){
        return new Point(location.getX()+ size.getWidth()/2,
                location.getY()+size.getHeight()/2);
    }

    public void enterTransactionPin(String pin) throws InterruptedException {

        tapOnCoordinates(96,922);
        System.out.println("Enter Pin");
        tapOnCoordinates(104,1075);
        System.out.println(1);
        tapOnCoordinates(64,1087);
        Thread.sleep(2000);
        tapOnCoordinates(245,1080);
        System.out.println(2);
        Thread.sleep(2000);
        tapOnCoordinates(458,1078);
        System.out.println(3);
        Thread.sleep(2000);
        tapOnCoordinates(103,1202);
        System.out.println(4);
        Thread.sleep(2000);
        tapOnCoordinates(278,1193);
        System.out.println(5);
        Thread.sleep(2000);
        tapOnCoordinates(454,1198);
        System.out.println(6);
        Thread.sleep(10000);

    }

    public void selectCalendarDate(String year,String day,boolean scroll){
        driver.findElement(AppiumBy.accessibilityId("Select year")).click();
        WebElement calendar = driver.findElement(By.xpath("(//*[@class='android.view.View'])[6]"));
        if(scroll){
            Utils.scroll(ScrollDirection.UP,0.7,null);
            Utils.scroll(ScrollDirection.UP,0.7,null);
        }
        try{
            driver.findElement(AppiumBy.accessibilityId(year)).click();
        }catch (Exception e){
            Utils.scroll(ScrollDirection.UP,0.7,null);
            driver.findElement(AppiumBy.accessibilityId(year)).click();
        }
        containsText(day).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
    }

}
