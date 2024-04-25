package org.example;

import utils.Constant;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Ref;

import javax.swing.*;

import URL.urlList;
import javafx.application.Platform;
import javafx.scene.web.WebView;
import listener.Exit;
import listener.FullScreen;
import listener.Refresh;
import listener.SaveCode;
import listener.SourceCodeSee;
import listener.pageMovement;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import java.awt.event.KeyEvent;

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
        urlList.add("https://www.google.com");
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
        redirect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // add url to url list
                String url = html.getText();
                urlList.add(url);
                // re-render user interface
                refresh(url);
            }
        });
    }

    private static WebView webView;

    // Reload the page based on the URL
    public static void refresh(String url) {
        Platform.runLater(() -> {
            webView = new WebView();
            webPanel.setScene(new Scene(webView));
            webView.getEngine().load(url);// load the page
            html.setText(url);// reload the page based on URL
        });
    }

    public Main() {
        // Set the window with constant width and height
        this.setSize(Constant.MAIN_WIDTH, Constant.MAIN_HEIGHT);

        // Set the window in the center of the screen
        this.setLocationRelativeTo(null);

        // Set the window to be visible
        this.setVisible(true);

        // Set the window to be closed when the close button is clicked
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize menu bar
        initMenuBar();

        // initialize toolbar
        initToolBar();

        // initialize web View
        initWeb();

        // Add the workspace to the window
        this.add(workSpace);

        // Set the window to be visible
        this.setVisible(true);
    }

    /*
     * Initialize Web View
     */
    private void initWeb() {
        Platform.runLater(() -> {
            // load HTML view
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
        JMenu jMenu1 = new JMenu("File(F)");

        jMenu1.setFont(Constant.baseFont);

        for (int i = 0; i < Constant.menuList1.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList1[i]);
            item.setFont(Constant.smallFont);
            // Adding interaction for menu items
            if (Constant.menuList1[i].equals("Save as(A)")) {
                item.addActionListener(new SaveCode());
                // setup hotkey
                KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.META_DOWN_MASK);
                Action openMenuAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMenu1.doClick();
                    }
                };
                jMenu1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "openFileMenu");
                jMenu1.getActionMap().put("openFileMenu", openMenuAction);
                // Set the shortcut key(Ctrl+S)
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
            } else if (Constant.menuList1[i].equals("Exit(I)")) {
                item.addActionListener(new Exit(this));
                // Set the hotkey(I+ALT)
                item.setMnemonic(KeyEvent.VK_I);
                // Set the shortcut key(Ctrl+E)
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
            }

            jMenu1.add(item);
        }

        jMenuBar.add(jMenu1);

        // Set the Jmenu2 'Edit' with menuItems
        JMenu jMenu2 = new JMenu("Edit(E)");

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.META_DOWN_MASK);
        Action openMenuAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenu2.doClick();
            }
        };
        jMenu2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "openFileMenu");
        jMenu2.getActionMap().put("openFileMenu", openMenuAction);

        jMenu2.setFont(Constant.baseFont);
        for (int i = 0; i < Constant.menuList2.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList2[i]);
            item.setFont(Constant.smallFont);
            // Adding interaction for menu items
            if (Constant.menuList2[i].equals("Forward")) {
                item.addActionListener(new pageMovement(Constant.FORWARD));
                // Set the shortcut key(Ctrl+Z)
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_MASK));
            } else if (Constant.menuList2[i].equals("Backward")) {
                item.addActionListener(new pageMovement(Constant.BACKWARD));
                // Set the shortcut key(Ctrl+D)
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
            }

            jMenu2.add(item);
        }

        jMenuBar.add(jMenu2);

        // Set the Jmenu3 'View' with menuItems
        JMenu jMenu3 = new JMenu("View(V)");

        jMenu3.setFont(Constant.baseFont);
        for (int i = 0; i < Constant.menuList3.length; i++) {
            JMenuItem item = new JMenuItem(Constant.menuList3[i]);
            item.setFont(Constant.smallFont);
            // Adding interaction for menu items
            if (Constant.menuList3[i].equals("Full Screen")) {
                
                KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.META_DOWN_MASK);
                Action openMenuAction2 = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jMenu3.doClick();
                    }
                };
                jMenu3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke2, "openFileMenu");
                jMenu3.getActionMap().put("openFileMenu", openMenuAction2);

                // Set the shortcut key(Ctrl+U)
                item.addActionListener(new FullScreen(this));
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
            } else if (Constant.menuList3[i].equals("View Source Code(C)")) {
                item.addActionListener(new SourceCodeSee());

                // set the shortcut key(Ctrl+C)
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
            } else if (Constant.menuList3[i].equals("Refresh")) {
                // set the shortcut key(Ctrl+R)
                item.addActionListener(new Refresh());
                item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
            }
            jMenu3.add(item);
        }

        jMenuBar.add(jMenu3);

        this.setJMenuBar(jMenuBar);
    }

    private void initToolBar() {
        initToolBar1();
        initToolBar2();
    }

    // initialize toolbar1
    private void initToolBar1() {
        // Set the buttons, and add them to the toolbar
        JToolBar jToolBar1 = new JToolBar();
        for (int i = 0; i < Constant.toolBarButtonNameList.length; i++) {
            JButton button = new JButton(Constant.toolBarButtonNameList[i]);
            button.setFont(Constant.smallFont);
            // Adding interaction for button
            if (Constant.toolBarButtonNameList[i].equals("Forward")) {
                button.addActionListener(new pageMovement(Constant.FORWARD));
            } else if (Constant.toolBarButtonNameList[i].equals("Backward")) {
                button.addActionListener(new pageMovement(Constant.BACKWARD));
            } else if (Constant.toolBarButtonNameList[i].equals("View Source Code")) {
                button.addActionListener(new SourceCodeSee());
            } else if (Constant.toolBarButtonNameList[i].equals("Save as")) {
                button.addActionListener(new SaveCode());
            } else if (Constant.toolBarButtonNameList[i].equals("Exit")) {
                button.addActionListener(new Exit(this));

            }
            jToolBar1.add(button);
        }
        toolBarSpace.add(jToolBar1);// add the toolbars to the toolbar space
    }

    // initialize toolbar2
    private void initToolBar2() {
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
        toolBarSpace.add(jToolBar2);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
