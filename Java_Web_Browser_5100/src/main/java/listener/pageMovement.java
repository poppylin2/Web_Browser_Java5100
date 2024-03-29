package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.example.Main;

import URL.urlList;
import utils.Constant;

public class pageMovement implements ActionListener {
    private Integer direction;

    public pageMovement(Integer direction) {
        this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (direction == Constant.FORWARD) {
            // move forward
            boolean flag = urlList.right();
            if (!flag) {
                // Page forward failed
                JOptionPane.showMessageDialog(null, "You are at the initial page. Unable to proceed forward.");
                return;
            }
            // refresh the page
            Main.refresh(urlList.getCurrent());
        } else if (direction == Constant.BACKWARD) {
            // move backward
            boolean flag = urlList.left();
            if (!flag) {
                // Page backward failed
                JOptionPane.showMessageDialog(null, "You've reached the final page. Unable to proceed backward.");
                return;
            }
            // refresh the page
            Main.refresh(urlList.getCurrent());
        }

    }

}
