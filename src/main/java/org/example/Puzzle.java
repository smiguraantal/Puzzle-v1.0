package org.example;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;
import org.example.gui.WindowLocation;

import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Az alkalmazást indító osztály */
public class Puzzle implements Constants {

    public Puzzle() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.pack();
        WindowLocation.center(mainFrame);
        mainFrame.setVisible(true);
    }

    //----------------------------------------------------------------------

    /** Main */
    public static void main(String[] args) {
        try {
            int lookAndFeel = DataModule.getDataModule().getLookAndFeel();
            if (lookAndFeel == WINDOWS_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
            if (lookAndFeel == METAL_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            if (lookAndFeel == MOTIF_LOOK_AND_FEEL)
                UIManager.setLookAndFeel(new MotifLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Puzzle();
    }
}