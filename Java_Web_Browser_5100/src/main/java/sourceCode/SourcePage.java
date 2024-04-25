package sourceCode;

import javax.swing.*;

import URL.urlList;
import listener.Exit;
import listener.SaveCode;

import java.awt.*;
import java.io.IOException;

import utils.Constant;
import utils.WebsiteHTMLGetter;

public class SourcePage extends JFrame{

    private static JPanel workspace = new JPanel();

    /**
     * Text component for displaying HTML interfaces.
     */

     private static JTextArea sourceCode = new JTextArea();

     /**
      * The bottom panel of the interface
      */
     
     private static JPanel bottom = new JPanel();
 
     /**
      * The button for saving the source code
      */
 
     private static JButton save = new JButton("Save");
 
     /**
      * The button for exiting the source code
      */
 
      private static JButton exit = new JButton("Exit");
 
     static{
        //Set the layout manager for the bottom panel
        bottom.setLayout(new FlowLayout());
         //Add the buttons to the bottom panel
         bottom.add(save);
         bottom.add(exit);
     }
 
    static {
        workspace.setLayout(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(sourceCode);
        workspace.add(jScrollPane, BorderLayout.CENTER);
        workspace.add(bottom, BorderLayout.SOUTH);
    }

    public SourcePage(){
        // Initialize the frame
        this.setSize(Constant.SOURCE_WIDTH, Constant.SOURCE_HEIGHT);

        // Set the window in the center of the screen
        this.setLocationRelativeTo(null);

        // Set the window to be visible
        this.setVisible(true);

        // Set the window to be closed when the close button is clicked
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the text area for the source page
        initText();

        //Initialize the buttons for the source page
        initButton();


        this.add(workspace);
    }

    /**
     * Initialize the buttons for the source page
     */
    private void initButton(){
        //save button
        save.addActionListener(new SaveCode());
        save.setFont(Constant.baseFont);
        //exit button
        exit.addActionListener(new Exit(this));
        exit.setFont(Constant.baseFont);
        
    }

    /**
     * Initialize the code for the source page
     */

    private void initText(){
        sourceCode.setFont(Constant.smallFont);
        sourceCode.setLineWrap(true);
    try {
        sourceCode.setText(WebsiteHTMLGetter.getHTMLCode(urlList.getCurrent()));
    }catch (IOException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "html code get error");
    }
    }

    public static void main(String[] args){
        urlList.add("https://www.google.com");
        SourcePage sourcePage = new SourcePage();
        sourcePage.setVisible(true);
    }
}

