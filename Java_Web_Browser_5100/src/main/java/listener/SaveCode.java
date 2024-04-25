package listener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.JOptionPane;

import URL.urlList;
import utils.WebsiteHTMLGetter;

/**
 * Save html code
 */

public class SaveCode implements ActionListener {
    /**
     * Invoked when an action occurs.
     * 
     * @param e
     */

     @Override
     public void actionPerformed(ActionEvent e) {
         // get URL
         String url = urlList.getCurrent();
         // analyze URL, get html code
         try {
             String htmlCode = WebsiteHTMLGetter.getHTMLCode(url);
 
             // implement Java IO to save the html code
             String fileName = removeUrlPrefix(url);
             String filePath = System.getProperty("user.home") + "/Desktop/" + fileName;
 
             // wrtie file
             writeFile(filePath, htmlCode);
         } catch (IOException ioException) {
             ioException.printStackTrace();
             JOptionPane.showMessageDialog(null, "Failed to get HTML code");
         }
 
     }

    /**
     * write file
     * @param filepath
     * @param content
     * @throws IOException
     */
    private static void writeFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        System.out.println(filePath);

        //build file output stream
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))){
            //write content to file
            writer.print(content);
        }
    }

    /**
     * remove prefix of the website URL
     * 
     * @param url
     * @return
     */
    private static String removeUrlPrefix(String url) {
        // remove "http://" prefix
        if (url.startsWith("http://")) {
            url = url.substring(7);
        } 
        // remove "https://" prefix
        else if (url.startsWith("https://")) {
            url = url.substring(8);
        }
        return url;
    }
}
