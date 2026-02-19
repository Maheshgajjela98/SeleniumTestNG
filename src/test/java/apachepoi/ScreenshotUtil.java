package apachepoi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static void captureFailureScreenshot(String testName) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screenRect);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            File screenshotFile = new File(
                    "screenshots/" + testName + "_" + timestamp + ".png"
            );

            screenshotFile.getParentFile().mkdirs();
            ImageIO.write(image, "png", screenshotFile);

            logger.error("Screenshot captured: {}", screenshotFile.getAbsolutePath());

        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
        }
    }
}

