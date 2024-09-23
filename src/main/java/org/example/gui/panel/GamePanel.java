package org.example.gui.panel;

import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.gui.MainFrame;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.Vector;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A képkockákat tartalmazó panel */
public class GamePanel extends JPanel implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** A képpanelek */
    Vector imagePanels = new Vector();

    /** Főablak */
    MainFrame mainFrame;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public GamePanel(MainFrame mainFrame) {
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
        this.setLayout(null);
        setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        initImagePanels();
        shuffle();
    }

    //----------------------------------------------------------------------

    /** Létrehozza a panelokat */
    private void initImagePanels() {
        for (int i = 0; i < dataModule.getNumberOfRows(); i++) {
            for (int j = 0; j < dataModule.getNumberOfColumns(); j++) {
                ImagePanel imagePanel = new ImagePanel(this, i, j);
                imagePanels.add(imagePanel);
                add(imagePanel);
            }
        }
    }

    //----------------------------------------------------------------------

    /** Megkeveri a képeket */
    public void shuffle() {
        int numberOfChange = dataModule.getNumberOfColumns() * dataModule.getNumberOfRows() * 2;
        for (int i = 0; i < numberOfChange; i++) {
            Collections.shuffle(imagePanels);
            changeImagePanels((ImagePanel) imagePanels.get(0),
                    (ImagePanel) imagePanels.get(1));
        }
        if (badShuffle())  // ha a képeknek legalább a fele véletlenül a helyére került, akkor új keverés kell
            shuffle();
        addSelectingListeners();
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy a keverés után több kép van-e a helyén, mint az
     * összes kép fele */
    private boolean badShuffle() {
        int atOriginalPlace = 0;
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            if (imagePanel.getX() == IMAGE_WIDTH / dataModule.getNumberOfColumns() * imagePanel.getColumn() &&
                    imagePanel.getY() == IMAGE_HEIGHT / dataModule.getNumberOfRows() * imagePanel.getRow())
                ++atOriginalPlace;
        }
        return atOriginalPlace >= (dataModule.getNumberOfColumns() * dataModule.getNumberOfRows()) / 2;
    }

    //----------------------------------------------------------------------

    /** Felcseréli a kapott két képet */
    public void changeImagePanels(ImagePanel ip_1, ImagePanel ip_2) {
        Rectangle bounds = ip_1.getBounds();
        ip_1.setBounds(ip_2.getBounds());
        ip_2.setBounds(bounds);
        ip_1.setSelected(false);
        ip_2.setSelected(false);
        dataModule.setNumberOfSelectedImagePanels(0);
        mainFrame.getLbAtWrongPlace().setText("" + atWrongPlace());
        mainFrame.selectLabels(-1, -1);
    }

    //----------------------------------------------------------------------

    /** Felcseréli a két kijelölt képet */
    public void changeImagePanels() {
        Vector selectedImagePanels = new Vector();
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            if (imagePanel.isSelected())
                selectedImagePanels.add(imagePanel);
        }
        changeImagePanels((ImagePanel) selectedImagePanels.get(0),
                (ImagePanel) selectedImagePanels.get(1));
    }

    //----------------------------------------------------------------------

    /** Midegyik képet a helyére teszi */
    public void sort() {
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            imagePanel.setBounds();
            imagePanel.setSelected(false);
            imagePanel.removeSelectingListener();
        }
        dataModule.setNumberOfSelectedImagePanels(0);
        mainFrame.selectLabels(-1, -1);
    }

    //----------------------------------------------------------------------

    /** Eltávolítja az összes képpanelról a kijelölésfigyelést */
    public void removeSelectingListeners() {
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            imagePanel.removeSelectingListener();
        }
    }

    //----------------------------------------------------------------------

    /** Hozzáadja az összes képpanelhez a kijelölésfigyelést */
    public void addSelectingListeners() {
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            imagePanel.addSelectingListener();
        }
    }

    //----------------------------------------------------------------------

    /** Új képeket rajzol mindegyik panelra */
    public void refresh() {
        dataModule.setNumberOfSelectedImagePanels(0);
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            imagePanel.setSelected(false);
            imagePanel.loadImage();
            imagePanel.repaint();
            imagePanel.addSelectingListener();
        }
    }

    //----------------------------------------------------------------------

    /** Újrarajzolja a képpanelokat a rács megjelenítéséhez illetve elrejtétéhez */
    public void grid() {
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            imagePanel.repaint();
        }
    }

    //----------------------------------------------------------------------

    /** Újrarajzolja a kijelölt képpanel a kijelölés megjelenítéséhez illetve
     * elrejtéséhez */
    public void focus() {
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            if (imagePanel.isSelected())
                imagePanel.repaint();
        }
    }

    //----------------------------------------------------------------------

    /** A kapott kép helyére az eredetit teszi */
    public void changeWithOriginal(ImagePanel imagePanel) {
        int column = imagePanel.getX() * dataModule.getNumberOfColumns() / IMAGE_WIDTH;
        int row = imagePanel.getY() * dataModule.getNumberOfRows() / IMAGE_HEIGHT;
        ImagePanel original = null; // ez fog a kapott kép helyére, vagyis az eredeti helyére ugrani
        for (int i = 0; i < imagePanels.size(); i++) { // ha van kijelölt, akkor azt meg kell szűntetni
            ImagePanel ip = (ImagePanel) imagePanels.get(i);
            if (ip.isSelected()) {
                ip.setSelected(false);
                ip.repaint();
            }
        }
        for (int i = 0; i < imagePanels.size(); i++) { // eredeti megkeresése
            original = (ImagePanel) imagePanels.get(i);
            if (original.getColumn() == column && original.getRow() == row) {
                break;
            }
        }

        changeImagePanels(imagePanel, original);
    }

    //----------------------------------------------------------------------

    /** Visszaadja, hogy hány képkocka van rossz helyen */
    public int atWrongPlace() {
        int atWrongPlace = 0;
        for (int i = 0; i < imagePanels.size(); i++) {
            ImagePanel imagePanel = (ImagePanel) imagePanels.get(i);
            if (imagePanel.getColumn() !=
                    imagePanel.getX() * dataModule.getNumberOfColumns() / IMAGE_WIDTH ||
                    imagePanel.getRow() !=
                            imagePanel.getY() * dataModule.getNumberOfRows() / IMAGE_HEIGHT)
                ++atWrongPlace;
        }
        return atWrongPlace;
    }

    //----------------------------------------------------------------------

    /** Megkéri a főablakot, hogy jelölje ki az aktuális oszlop, és sorfeliratokat */
    public void selectLabels(ImagePanel imagePanel) {
        if (imagePanel == null) // nincs kijelölt képkocka
            mainFrame.selectLabels(-1, -1);
        else { // van kijelölt képkocka
            int column = imagePanel.getX() * dataModule.getNumberOfColumns() / IMAGE_WIDTH;
            int row = imagePanel.getY() * dataModule.getNumberOfRows() / IMAGE_HEIGHT;
            mainFrame.selectLabels(column, row);
        }
    }

    //----------------------------------------------------------------------

    /** Megkéri a főablakot, hogy írja ki, hogy melyik a kijelölt panel */
    public void witchLabels(ImagePanel imagePanel) {
        if (imagePanel.isSelected()) {
            int column = imagePanel.getX() * dataModule.getNumberOfColumns() / IMAGE_WIDTH;
            int row = imagePanel.getY() * dataModule.getNumberOfRows() / IMAGE_HEIGHT;
            mainFrame.witchLabels(LETTERS[column] + "–" + (row + 1));
        } else
            mainFrame.witchLabels(NONE);
    }

    //----------------------------------------------------------------------

    /** Megkéri a főablakot, hogy írja ki, hogy: KÉSZ! */
    public void made() {
        mainFrame.made();
    }

}






