package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

/** Egy szín panelen való megjelenítése */
public class ColorPanel extends JPanel implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A megjeleníteni kívánt szín */
    Color color;

    /** Főablak */
    MainFrame mainFrame;

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public ColorPanel(MainFrame mainFrame, Color color) {
        this.mainFrame = mainFrame;
        this.color = color;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**  */
    void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        setBackground(color);
        setPreferredSize(new Dimension(20, 20));
        this.addMouseListener(new ColorPanel_this_mouseAdapter(this));
    }

    //----------------------------------------------------------------------

    /** Kattintás a színen */
    void this_mousePressed(MouseEvent e) {
        if (dataModule.getColorSetting() == GRID_COLOR_SETTING) { // ha a színbeállítás a rácsra vonatkozik
            dataModule.setGridColor(getBackground());
            mainFrame.getColorPalette().getPnGrid().setBackground(
                    dataModule.getGridColor());
            mainFrame.getGamePanel().grid();
            mainFrame.getPnGameBase().setBackground(dataModule.isGrid() ?
                    dataModule.getGridColor() :
                    Color.black);
        } else { // ha a színbeállítás a kijelölésre vonatkozik
            dataModule.setFocusColor(getBackground());
            mainFrame.getColorPalette().getPnFocus().setBackground(
                    dataModule.getFocusColor());
            mainFrame.getGamePanel().focus();
        }
    }
}

class ColorPanel_this_mouseAdapter extends MouseAdapter {
    ColorPanel adaptee;

    ColorPanel_this_mouseAdapter(ColorPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.this_mousePressed(e);
    }
}






