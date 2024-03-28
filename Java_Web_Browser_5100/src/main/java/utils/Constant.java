package utils;

import java.awt.*;

public interface Constant {

    int MAIN_WIDTH = 1920;
    int MAIN_HEIGHT = 1080;

    String[] menuList1 = {"Save as(A)", "Exit(I)"};

    String[] menuList2 = {"Forward", "Backward"};

    String[] menuList3 = {"Full Screen", "View Source Code(C)", "Refresh"};

    Font baseFont = new Font("SansSerif", Font.BOLD, 20);

    Font smallFont = new Font("Courier New", Font.PLAIN, 15);

    String[] toolBarButtonNameList = {"Save as", "Backward", "Forward", "View Source Code", "Exit"};

    int SOURCE_WIDTH = 800;
    int SOURCE_HEIGHT = 600;
}
