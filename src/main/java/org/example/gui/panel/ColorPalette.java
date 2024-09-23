package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A színbeállításokhoz szükséges komponenseket összefogó panel */
public class ColorPalette extends JPanel implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** Főablak */
    MainFrame mainFrame;

    JPanel pnGrid = new JPanel();
    JPanel pnFocus = new JPanel();

    ColorPanel white;
    ColorPanel yellow;
    ColorPanel pink;
    ColorPanel green;
    ColorPanel blue;
    ColorPanel black;
    ColorPanel cyan;
    ColorPanel magenta;
    ColorPanel red;
    ColorPanel gray;

    ButtonGroup buttonGroup = new ButtonGroup();

    GridBagLayout gridBagLayout1 = new GridBagLayout();
    Border border1;
    TitledBorder titledBorder1;
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JRadioButton rbFocus = new JRadioButton();
    JRadioButton rbGrid = new JRadioButton();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JPanel jPanel5 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();

    //----------------------------------------------------------------------

    /** Konsturktor */
    public ColorPalette(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**  */
    void jbInit() throws Exception {
        pnGrid.setBackground(dataModule.getGridColor());
        pnFocus.setBackground(dataModule.getFocusColor());

        white = new ColorPanel(mainFrame, Color.white);
        yellow = new ColorPanel(mainFrame, Color.yellow);
        pink = new ColorPanel(mainFrame, Color.pink);
        green = new ColorPanel(mainFrame, Color.green);
        blue = new ColorPanel(mainFrame, Color.blue);
        black = new ColorPanel(mainFrame, Color.black);
        cyan = new ColorPanel(mainFrame, Color.cyan);
        magenta = new ColorPanel(mainFrame, Color.magenta);
        red = new ColorPanel(mainFrame, Color.red);
        gray = new ColorPanel(mainFrame, Color.gray);

        border1 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        titledBorder1 = new TitledBorder(border1, "Színek");
        this.setBorder(titledBorder1);
        this.setLayout(gridBagLayout1);
        jPanel1.setLayout(gridBagLayout2);
        rbFocus.setText("Kijelölés:");
        rbFocus.addActionListener(new ColorPalette_rbFocus_actionAdapter(this));
        rbFocus.setSelected(true);
        rbGrid.setText("Rács:");
        rbGrid.addActionListener(new ColorPalette_rbGrid_actionAdapter(this));
        pnGrid.setPreferredSize(new Dimension(20, 20));
        pnFocus.setPreferredSize(new Dimension(20, 20));
        jPanel2.setLayout(gridBagLayout3);
        jPanel5.setLayout(gridLayout1);
        gridLayout1.setColumns(0);
        gridLayout1.setHgap(5);
        gridLayout1.setRows(2);
        gridLayout1.setVgap(5);
        this.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 20, 0), 0, 0));
        jPanel1.add(rbFocus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel1.add(rbGrid, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0));
        jPanel1.add(pnGrid, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(pnFocus, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(jPanel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        jPanel2.add(jPanel5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        jPanel5.add(white, null);
        jPanel5.add(yellow, null);
        jPanel5.add(pink, null);
        jPanel5.add(magenta, null);
        jPanel5.add(red, null);
        jPanel5.add(green, null);
        jPanel5.add(cyan, null);
        jPanel5.add(blue, null);
        jPanel5.add(gray, null);
        jPanel5.add(black, null);

        buttonGroup.add(rbGrid);
        buttonGroup.add(rbFocus);
    }

    //----------------------------------------------------------------------

    /** A színbeállítások a rácsra vonatkoznak */
    void rbGrid_actionPerformed(ActionEvent e) {
        dataModule.setColorSetting(GRID_COLOR_SETTING);
    }

    //----------------------------------------------------------------------

    /** A színbeállítások a kijelölésre vonatkoznak */
    void rbFocus_actionPerformed(ActionEvent e) {
        dataModule.setColorSetting(FOCUS_COLOR_SETTING);
    }

    public JPanel getPnFocus() {
        return pnFocus;
    }

    public JPanel getPnGrid() {
        return pnGrid;
    }
}

class ColorPalette_rbGrid_actionAdapter implements ActionListener {
    ColorPalette adaptee;

    ColorPalette_rbGrid_actionAdapter(ColorPalette adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.rbGrid_actionPerformed(e);
    }
}

class ColorPalette_rbFocus_actionAdapter implements ActionListener {
    ColorPalette adaptee;

    ColorPalette_rbFocus_actionAdapter(ColorPalette adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.rbFocus_actionPerformed(e);
    }
}





