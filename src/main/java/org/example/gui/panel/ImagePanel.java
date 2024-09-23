package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.SelectingListener;

import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
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

/** Egy képkockát tartalmazó panel */
public class ImagePanel extends JPanel implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A megjelenített kép */
    private Image image;

    /** A játék panel */
    private GamePanel gamePanel;

    /** sorindex */
    private int row;

    /** oszlopindex */
    private int column;

    /** kijelölt-e a kép */
    private boolean selected;

    /** A kijelölésfigyelő */
    private SelectingListener selectingListener = new SelectingListener(this);

    BorderLayout borderLayout1 = new BorderLayout();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public ImagePanel(GamePanel gamePanel, int row, int column) {
        this.gamePanel = gamePanel;
        this.row = row;
        this.column = column;
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
        addSelectingListener();
        setPreferredSize(new Dimension(IMAGE_WIDTH / dataModule.getNumberOfColumns(),
                IMAGE_HEIGHT / dataModule.getNumberOfRows()));
        setBounds();
        loadImage();
    }

    //----------------------------------------------------------------------

    /** Beállítja a kép helyét a sor-, és oszlopindexei alapján */
    public void setBounds() {
        setBounds(IMAGE_WIDTH / dataModule.getNumberOfColumns() * column,
                IMAGE_HEIGHT / dataModule.getNumberOfRows() * row,
                IMAGE_WIDTH / dataModule.getNumberOfColumns(),
                IMAGE_HEIGHT / dataModule.getNumberOfRows());
    }

    //----------------------------------------------------------------------

    /** Betölti a képet egy fáljból */
    public void loadImage() {
        MediaTracker tr = new MediaTracker(this);
        image = Toolkit.getDefaultToolkit().getImage(dataModule.getFileName());
        tr.addImage(image, 0);
        try {
            tr.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    /** Eltávolítja a kijelölés figyelőt */
    public void removeSelectingListener() {
        removeMouseListener(selectingListener);
    }

    //----------------------------------------------------------------------

    /** Hozzáadja a kijelölés figyelőt */
    public void addSelectingListener() {
        if (getMouseListeners().length == 0) // ha nincs hozzáadva a figyelő
            addMouseListener(selectingListener);
    }

    //----------------------------------------------------------------------

    /** Megrajzolja a kártya képét */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) { // csak ha megvan a kép
            g.drawImage(image,
                    IMAGE_WIDTH / dataModule.getNumberOfColumns() * column * -1,
                    IMAGE_HEIGHT / dataModule.getNumberOfRows() * row * -1,
                    this);
        }
        // rács
        if (dataModule.isGrid()) {
            g.setColor(dataModule.getGridColor());
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
        // kijelölés
        if (selected && dataModule.isFocus()) {
            Graphics2D g2 = (Graphics2D) g;

            float dash[] = {2.0f}; //vonalak hossza
            BasicStroke dashed = new BasicStroke(2.0f, // vonal vastagság
                    BasicStroke.CAP_BUTT, //élek találkozása
                    BasicStroke.JOIN_MITER, //vonalvég típusa
                    2.0f, //közök hossza ????
                    dash, // szagatott vonalak hossza
                    0.0f);

            g2.setStroke(dashed);
            g2.setColor(dataModule.getFocusColor());
            g2.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
        }
    }

    //----------------------------------------------------------------------

    /** Egérkattintás a panelon */
    public void mousePressed(MouseEvent e) {
        if (e.getModifiers() == e.BUTTON1_MASK) { // bal egérkattintás
            leftClick();
        }
        if (e.getModifiers() == e.BUTTON3_MASK) { // jobb egérkattintás
            gamePanel.changeWithOriginal(this);
        }
        if (gamePanel.atWrongPlace() == 0) { // ha mindegyik a helyére került
            gamePanel.removeSelectingListeners();
            gamePanel.made();
        }
        gamePanel.witchLabels(this);
    }

    //----------------------------------------------------------------------

    /** Bal kattintás */
    private void leftClick() {
        if (!selected) { // ha nem kijelölt
            selected = true;
            dataModule.increaseNumberOfSelectedImagePanels();
            gamePanel.selectLabels(this);
        } else { // ha kijelölt
            selected = false;
            dataModule.decreaseNumberOfSelectedImagePanels();
            gamePanel.selectLabels(null);
        }
        if (dataModule.getNumberOfSelectedImagePanels() == 2) { // ha már kettő van kijelölve
            gamePanel.changeImagePanels();
        }
        repaint();
    }

    //----------------------------------------------------------------------

    public int getColumn() {
        return column;
    }

    public Image getImage() {
        return image;
    }

    public int getRow() {
        return row;
    }

    public boolean isSelected() {
        return selected;
    }

    public SelectingListener getSelectingListener() {
        return selectingListener;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setSelectingListener(SelectingListener selectingListener) {
        this.selectingListener = selectingListener;
    }
}