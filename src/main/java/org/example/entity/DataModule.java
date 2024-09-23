package org.example.entity;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Több osztály számára is fontos adatokat tartalamzó osztály */
public class DataModule implements Constants {

    /** Adatmodul */
    private static DataModule dataModule;

    /** A kiválasztott kép eléréi útja */
    String fileName = IMAGE_FILE_01;

    /** Oszlopok száma */
    int numberOfColumns = 4;

    /** Sorok száma */
    int numberOfRows = 4;

    /** Rács színe */
    Color gridColor = Color.white;

    /** Fókusz színe */
    Color focusColor;

    /** Látszik-e a rács */
    boolean grid;

    /** Látszik-e a fókusz */
    boolean focus;

    /** Látszanak-e az feliratok */
    boolean labels;

    /** Látszanak-e a felosztást vezérlő gombok */
    boolean divideButtons;

    /** Látszik-e a színpaletta */
    boolean colorPalette;

    /** Látszik-e az állotsor */
    boolean statusBar;

    /** Látszik-e a kép kicsinyített mása */
    boolean littleImage;

    /** Felület */
    int lookAndFeel;

    /** A kijelölt képpanelok száma */
    int numberOfSelectedImagePanels;

    /** Megadja, hogy a rácsra vagy a kijelölésre vonatkozik a
     * színbeállítás */
    int colorSetting = FOCUS_COLOR_SETTING;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public DataModule() {
        Settings settings = readSettings();
        this.fileName = settings.fileName;
        this.numberOfColumns = settings.getNumberOfColumns();
        this.numberOfRows = settings.getNumberOfRows();
        this.gridColor = settings.getGridColor();
        this.focusColor = settings.getFocusColor();
        this.grid = settings.isGrid();
        this.focus = settings.isFocus();
        this.labels = settings.isColumnLabels();
        this.divideButtons = settings.isColumnButtons();
        this.colorPalette = settings.isColorPalette();
        this.statusBar = settings.isStatusBar();
        this.littleImage = settings.isLittleImage();
        this.lookAndFeel = settings.getLookAndFeel();
    }

    //----------------------------------------------------------------------

    /** Visszaadja az adatmodult */
    public static DataModule getDataModule() {
        if (dataModule == null)
            dataModule = new DataModule();
        return dataModule;
    }

    //----------------------------------------------------------------------

    /** Az osztályadatok alapján visszaad egy objektumot, mely a beállításokat
     * tartalmazza. */
    private Settings getSettings() {
        return new Settings(fileName,
                numberOfColumns,
                numberOfRows,
                gridColor,
                focusColor,
                grid,
                focus,
                labels,
                divideButtons,
                colorPalette,
                statusBar,
                littleImage);
    }

    //----------------------------------------------------------------------

    /** Kiírja a megadott beállításokat */
    public void writeSettings(Object object) {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("settings.dat"));
            os.writeObject(object);
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //----------------------------------------------------------------------

    /** Beolvassa a beállításokat */
    public Settings readSettings() {
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("settings.dat"));
            Settings settings = (Settings) os.readObject();
            os.close();
            return settings;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new Settings();
    }

    //----------------------------------------------------------------------

    /** Növeli a kijelölt képpanelok számát */
    public void increaseNumberOfSelectedImagePanels() {
        ++numberOfSelectedImagePanels;
    }

    //----------------------------------------------------------------------

    /** Csökkenti a kijelölt képpanelok számát */
    public void decreaseNumberOfSelectedImagePanels() {
        --numberOfSelectedImagePanels;
    }

    //----------------------------------------------------------------------

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
        writeSettings(getSettings());
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
        writeSettings(getSettings());
    }

    public void setLabels(boolean labels) {
        this.labels = labels;
        writeSettings(getSettings());
    }

    public void setDivideButtons(boolean divideButtons) {
        this.divideButtons = divideButtons;
        writeSettings(getSettings());
    }

    public void setGrid(boolean grid) {
        this.grid = grid;
        writeSettings(getSettings());
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        writeSettings(getSettings());
    }

    public void setFocusColor(Color focusColor) {
        this.focusColor = focusColor;
        writeSettings(getSettings());
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        writeSettings(getSettings());
    }

    public void setColorPalette(boolean colorPalette) {
        this.colorPalette = colorPalette;
        writeSettings(getSettings());
    }

    public void setLittleImage(boolean littleImage) {
        this.littleImage = littleImage;
        writeSettings(getSettings());
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
        writeSettings(getSettings());
    }

    public void setStatusBar(boolean statusBar) {
        this.statusBar = statusBar;
        writeSettings(getSettings());
    }

    //----------------------------------------------------------------------

    public String getFileName() {
        return fileName;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfSelectedImagePanels() {
        return numberOfSelectedImagePanels;
    }

    public void setNumberOfSelectedImagePanels(int numberOfSelectedImagePanels) {
        this.numberOfSelectedImagePanels = numberOfSelectedImagePanels;
    }

    public Color getFocusColor() {
        return focusColor;
    }

    public boolean isFocus() {
        return focus;
    }

    public boolean isGrid() {
        return grid;
    }

    public boolean isColorPalette() {
        return colorPalette;
    }

    public boolean isLabels() {
        return labels;
    }

    public Color getGridColor() {
        return gridColor;
    }

    public boolean isLittleImage() {
        return littleImage;
    }

    public int getLookAndFeel() {
        return lookAndFeel;
    }

    public boolean isStatusBar() {
        return statusBar;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public boolean isDivideButtons() {
        return divideButtons;
    }

    public int getColorSetting() {
        return colorSetting;
    }

    public void setColorSetting(int colorSetting) {
        this.colorSetting = colorSetting;
    }
}