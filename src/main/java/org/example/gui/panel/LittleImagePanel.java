package org.example.gui.panel;

import org.example.entity.DataModule;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A teljes kép miniatűr változata */
public class LittleImagePanel extends JPanel {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A megjelenítendő kép */
    private Image image;

    /** Az átméretezett kép */
    private Image fittedImage = null;

    /** Szélesség és hosszúság aránya */
    private double ratio;

    /** A kép elérési útja */
    private String fileName;

    /** A panel szélessége */
    int WIDTH = 160;

    /** A panel magassága */
    int HEIGHT = 120;

    BorderLayout borderLayout1 = new BorderLayout();
    Border border1;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public LittleImagePanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /**  */
    void jbInit() throws Exception {
        border1 = BorderFactory.createLineBorder(SystemColor.controlText, 1);
        this.setLayout(borderLayout1);
        this.setBorder(border1);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        loadImage();
    }

    //----------------------------------------------------------------------

    /** Betölti és átméretezi a képet */
    public void loadImage() {
        image = Toolkit.getDefaultToolkit().getImage(dataModule.getFileName());
        MediaTracker tr = new MediaTracker(this);
        tr.addImage(image, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException ex) {
        }
        ratio = 1.0 * image.getWidth(this) / image.getHeight(this);
        if (ratio > 1)
            fittedImage = image.getScaledInstance(WIDTH,
                    (int) (WIDTH / ratio), Image.SCALE_FAST);
        else
            fittedImage = image.getScaledInstance(
                    (int) (HEIGHT * ratio), HEIGHT, Image.SCALE_FAST);
    }

    //----------------------------------------------------------------------

    /** Kirajzolja a képet */
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        if (fittedImage != null) {
            gr.drawImage(fittedImage,
                    (WIDTH - fittedImage.getWidth(this)) / 2,
                    (HEIGHT - fittedImage.getHeight(this)) / 2, this);
        }
    }
}









