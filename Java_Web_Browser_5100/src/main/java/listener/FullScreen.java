package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



public class FullScreen implements ActionListener{

    private JFrame jFrame;

    private boolean isFull = true;

    public FullScreen(JFrame jFrame){
        this.jFrame = jFrame;

    }

    /**
     * Invoked when an action occurs.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //set the window to full screen
        if(isFull){
            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }else{
            //minimize the window
            jFrame.setExtendedState(JFrame.NORMAL);
        }
        isFull = !isFull;
        

    }

}
