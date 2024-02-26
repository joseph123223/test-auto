import info.debatty.java.stringsimilarity.Levenshtein;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
public class AndroidTest {
    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("newCommandTimeout", 180);
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setCapability("app",System.getProperty("user.dir")+"\\apps\\camscanner-6-54-0-2312040000.apk");
        options.setDeviceName("Nexus 5 test287");
        options.setAppPackage("com.intsig.camscanner");
        options.setAppActivity("com.intsig.camscanner.mainmenu.mainactivity.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // go into app
        driver.findElement(By.id("com.intsig.camscanner:id/tv_page_1_next")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.intsig.camscanner:id/aiv_close")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.intsig.camscanner:id/iv_close")).click();

        // login
        driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.intsig.camscanner:id/bottom_tag\"]/android.widget.LinearLayout[4]/android.view.ViewGroup")).click();
        driver.findElement(By.id("com.intsig.camscanner:id/iv_me_page_auth_google")).click();
        Thread.sleep(15000);

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(534, 947);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
        Thread.sleep(15000);

        // select images
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.intsig.camscanner:id/main_bottom_tab_image\"])[1]")).click();
        driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.intsig.camscanner:id/main_home_kingkong_image\"])[3]")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.intsig.camscanner:id/tv_i_know")).click();
        driver.findElement(By.id("com.intsig.camscanner:id/tv_select")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("com.intsig.camscanner:id/tv_export")).click();
        Thread.sleep(60000);

        Thread.sleep(5000);
        final var finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint2 = new Point(237, 504);
        var tap2 = new Sequence(finger2, 1);
        tap2.addAction(finger2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint2.x, tapPoint2.y));
        tap2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap2.addAction(new Pause(finger2, Duration.ofMillis(50)));
        tap2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap2));
        Thread.sleep(5000);

        Levenshtein levenshtein = new Levenshtein();
        double totalDistance = 0.0;
        int totalExpectedTextLength = 0;
        int numOfPics = 26;
        int temp = 0;

        final var finger_sw = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe;

        for (int i = 1; i <= numOfPics; i++) {

            if (i == 2){
                Thread.sleep(3000);
                driver.findElement(By.id("com.intsig.camscanner:id/message_close")).click();
                Thread.sleep(3000);
            }

            Thread.sleep(2000);
            //scroll the screen
            if (i == 5 || i == 9 || i == 13 || i == 17 || i == 21 || i == 25) {
                /*if (i == 25){
                    temp = temp - 2;
                }*/
                Thread.sleep(5000);
                temp = temp + 4;
                Point start1 = new Point(542, 1019);
                Point end1 = new Point(542, 267);
                swipe = new Sequence(finger_sw, 1);
                swipe.addAction(finger_sw.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), start1.getX(), start1.getY()));
                swipe.addAction(finger_sw.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger_sw.createPointerMove(Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(), end1.getX(), end1.getY()));
                swipe.addAction(finger_sw.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Arrays.asList(swipe));
                Thread.sleep(5000);

                // Second swipe action
                Point start2 = new Point(542, 1019);
                Point end2 = new Point(542, 267);
                swipe = new Sequence(finger_sw, 1);
                swipe.addAction(finger_sw.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), start2.getX(), start2.getY()));
                swipe.addAction(finger_sw.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger_sw.createPointerMove(Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(), end2.getX(), end2.getY()));
                swipe.addAction(finger_sw.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Arrays.asList(swipe));
                Thread.sleep(5000);
            }

            System.out.println("Start scanning test case " + i);
            Thread.sleep(2000);

            String xpath = "(//android.view.View[@resource-id=\"com.intsig.camscanner:id/view_checked_border\"])["+(i-temp)+"]";
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(4000);

            //refresh
            Thread.sleep(5000);
            final var finger12 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var tapPoint12 = new Point(546, 569);
            var tap12 = new Sequence(finger12, 1);
            tap12.addAction(finger12.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), tapPoint12.x, tapPoint12.y));
            tap12.addAction(finger12.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap12.addAction(new Pause(finger12, Duration.ofMillis(50)));
            tap12.addAction(finger12.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(tap12));
            Thread.sleep(5000);
            final var finger13 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var tapPoint13 = new Point(546, 569);
            var tap13 = new Sequence(finger13, 1);
            tap13.addAction(finger13.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), tapPoint13.x, tapPoint13.y));
            tap13.addAction(finger13.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap13.addAction(new Pause(finger13, Duration.ofMillis(50)));
            tap13.addAction(finger13.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(tap13));
            Thread.sleep(5000);

            // text extract button
            driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.intsig.camscanner:id/widget_imageview\"])[6]")).click();
            Thread.sleep(10000);

            if (i == 1){
                Thread.sleep(5000);
                final var finger3 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                var tapPoint3 = new Point(489, 1252);
                var tap3 = new Sequence(finger3, 1);
                tap3.addAction(finger3.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), tapPoint3.x, tapPoint3.y));
                tap3.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap3.addAction(new Pause(finger3, Duration.ofMillis(50)));
                tap3.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Arrays.asList(tap3));
            }
            Thread.sleep(3000);

            String outputText = null;
            try {
                outputText = driver.findElement(By.id("com.intsig.camscanner:id/et_ocr_result")).getText();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // refresh by clicking
                Thread.sleep(7000);
                final var finger9 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                var tapPoint9 = new Point(531, 844);
                var tap9 = new Sequence(finger9, 1);
                tap9.addAction(finger9.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), tapPoint9.x, tapPoint9.y));
                tap9.addAction(finger9.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap9.addAction(new Pause(finger9, Duration.ofMillis(50)));
                tap9.addAction(finger9.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Arrays.asList(tap9));
                outputText = "";
                Thread.sleep(5000);
            }

            String expectedText = ExpectedOutputs.getExpectedOutput(i);

            // Accuracy calculation
            double distance = levenshtein.distance(expectedText, outputText);
            double diff_percent = distance / (double) expectedText.length() * 100;

            System.out.println("Test Case " + i + ":");
            System.out.println("Levenshtein distance: " + distance);
            System.out.println("Accuracy (%): " + (100 - diff_percent));

            totalDistance += distance;
            totalExpectedTextLength += expectedText.length();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
            Thread.sleep(5000);
        }

        double finalDistance = totalDistance / (double) totalExpectedTextLength;
        double finalAccuracy = 100 - (finalDistance / (double) numOfPics) * 100;

        Assertions.assertTrue(finalAccuracy >= 95, "Test failed because the accuracy is less than 95%");
    }
}