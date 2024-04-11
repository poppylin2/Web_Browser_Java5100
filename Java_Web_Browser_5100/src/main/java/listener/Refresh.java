package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.Main;

import URL.urlList;


public class Refresh implements ActionListener{
    /**
     * Invoked when an action occurs.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = urlList.getCurrent();
        Main.refresh(s);
    }

}
