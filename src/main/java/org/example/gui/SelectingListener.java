package org.example.gui;

import org.example.entity.DataModule;
import org.example.gui.panel.ImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Kijelölés figyelő */
public class SelectingListener extends MouseAdapter {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A figyelt képpanel */
    private ImagePanel imagePanel;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public SelectingListener(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    //----------------------------------------------------------------------

    /** Egérgomb lenyomása */
    public void mousePressed(MouseEvent e) {
        imagePanel.mousePressed(e);
    }
}










