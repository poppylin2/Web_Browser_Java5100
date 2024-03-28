package org.example;

import utils.Constant;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import javafx.application.Platform;
import javafx.scene.web.WebView;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

/**
 * Main interface
 */
public class Main extends JFrame {
    /*
     * The workspace is the main panel of the interface
     */
    private static JPanel workSpace = new JPanel();

    static {
        workSpace.setLayout(new BorderLayout());
    }

    /*
     * The toolbar is the panel that contains the buttons
     */
    private static JPanel toolBarSpace = new JPanel();

    static {
        toolBarSpace.setLayout(new GridLayout(2, 1));
        workSpace.add(toolBarSpace, BorderLayout.NORTH);
    }

    /*
     * HTML rendering interface (JFXPanel)
     */

    /*
     * Initialize text field for html input
     */
    private static JTextField html = new JTextField();

    static {
        html.setFont(Constant.smallFont);
        html.setText("https://www.google.com");
    }

    /*
     * Build HTML render panel
     */
    private static JFXPanel webPanel = new JFXPanel();

    /*
     * Navigation button
     */
    private static JButton redirect = new JButton("Go");

    static {
        redirect.setFont(Constant.smallFont);
    }

    public Main() {
        // Set the window with constant width and height
        this.setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);

        // Set the window in the center of the screen
        this.setLocationRelativeTo(null);

        // Set the window to be closed when the close button is clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize menu bar
        initMenuBar();

        // initialize toolbar
        initToolBar();

        //initialize web View
        initWeb();

        // Add the workspace to the window
        this.add(workSpace);

        // Set the window to be visible
        this.setVisible(true);
    }

    /*
     * Initialize Web View
     */
    private void initWeb(){
        Platform.runLater(()-> {
            //load HTML view
            WebView webView = new WebView();
            webPanel.setScene(new Scene(webView));
            webView.getEngine().load(html.getText());
        });

        workSpace.add(webPanel, BorderLayout.CENTER);
    }
    /*
     * Initialize MenuBar
     */
    private void initMenuBar() {
        // Set the menu bar
        JMenuBar jMenuBar = new JMenuBar();

        // Set the Jmenu1 'File' with menuItems
        JMenu jMenu1 = new JMenu("File");
        jMenu1.setFont(Constant.baseFont);
        for (int i = 0; i < Constant.menuList1.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList1[i]);
            item.setFont(Constant.smallFont);
            jMenu1.add(item);
        }

        jMenuBar.add(jMenu1);

        // Set the Jmenu2 'Edit' with menuItems
        JMenu jMenu2 = new JMenu("Edit");
        jMenu2.setFont(Constant.baseFont);
        for (int i = 0; i < Constant.menuList2.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList2[i]);
            item.setFont(Constant.smallFont);
            jMenu2.add(item);
        }

        jMenuBar.add(jMenu2);

        // Set the Jmenu3 'View' with menuItems
        JMenu jMenu3 = new JMenu("View");
        jMenu3.setFont(Constant.baseFont);
        for (int i = 0; i < Constant.menuList3.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList3[i]);
            item.setFont(Constant.smallFont);
            jMenu3.add(item);
        }
        
        jMenuBar.add(jMenu3);

        this.setJMenuBar(jMenuBar);
    }

    /*
     * Initialize the toolbar
     */
    private void initToolBar() {
        // Set the toolbar1, which contains the buttons
        JToolBar jToolBar1 = new JToolBar();


        // Set the buttons, and add them to the toolbar
        for (int i = 0; i < Constant.toolBarButtonNameList.length; i++) {
            JButton button = new JButton(Constant.toolBarButtonNameList[i]);
            button.setFont(Constant.smallFont);
            jToolBar1.add(button);
        }

        // Set the toolbar2, which contains the address bar
        JToolBar jToolBar2 = new JToolBar();

        // set the address bar, label and text field
        JLabel jLabel = new JLabel("URL:");
        jLabel.setFont(Constant.smallFont);

        // add the label, html text field and the navigation button to the toolbar
        jToolBar2.add(jLabel);
        jToolBar2.add(html);
        jToolBar2.add(redirect);

        // add the toolbars to the toolbar space
        toolBarSpace.add(jToolBar1);
        toolBarSpace.add(jToolBar2);

    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
