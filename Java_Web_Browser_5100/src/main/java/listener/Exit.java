package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Exit the program
 */


public class Exit implements ActionListener {
    private JFrame jFrame;

    public Exit(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    /**
     * Invoked when an action occurs.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.dispose();
        System.exit(0);
    }


}
