package pingPkg;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class misc {
    private static int screenWidth;
    private static int screenHeight;
    private static String modalTitle = "A simple App";
    private static String baseIP = "192.168.1.";


    public static int getScreenWidth() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //screenWidth = screenSize.width;
        screenWidth = screenSize.width / 2;
        return screenWidth;
    }

    public static int getScreenHeight() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.height - 50;
        return screenHeight;
    }

    public static String getModalTitle() {
        return modalTitle;
    }

    public String timeStamp(){
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a");

        return ft.format(dNow);
    }

    public String getbaseIP(){
        return baseIP;
    }
}
