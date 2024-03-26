package org.example;

//package com.xhf.keshe;
//
//import com.xhf.keshe.listener.*;
import utils.Constant;
//import com.xhf.keshe.utils.URLList;

import javax.swing.*;

/**
 * Main interface
 */
public class Main extends JFrame {
    public static JPanel toolBarPanel;
    public Main() {
        this.setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        initUI();
    }

    /**
     * Initial interface
     */
    private void initUI() {
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
