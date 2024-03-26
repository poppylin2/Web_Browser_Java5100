package utils;


import java.awt.*;

public interface Constant {

    int MAIN_WIDTH = 1920;
    int MAIN_HEIGHT = 1080;

    String[] menuList1 = {"Save as(A)", "Quit(I)"};

    String[] menuList2 = {"Forward", "Backward"};

    String[] menuList3 = {"Full Screen", "View Source Code(C)", "Refresh"};

    Font baseFont = new Font("arial", Font.BOLD, 20);

    Font smallFont = new Font("times new roman", Font.BOLD, 15);

    String[] toolBarButtonNameList = {"Save as", "Backward", "Forward", "View Source Code", "Quit"};

    int SOURCE_WIDTH = 800;
    int SOURCE_HEIGHT = 600;
}
