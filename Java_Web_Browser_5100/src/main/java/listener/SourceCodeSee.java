package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sourceCode.SourcePage;

/**
 * get the"view source code" page
 */

public class SourceCodeSee implements ActionListener{
    /**
     * Invoked when an action occurs.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SourcePage page = new SourcePage();
        
    }

}
