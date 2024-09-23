package org.example.entity;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** A beállításokat tartalmazó osztály */
public class Settings implements Serializable, Constants {

    /** A kiválasztott kép eléréi útja */
    String fileName;

    /** Oszlopok száma */
    int numberOfColumns;

    /** Sorok száma */
    int numberOfRows;

    /** Rács színe */
    Color gridColor;

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

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Settings(String fileName,
                    int numberOfColumns,
                    int numberOfRows,
                    Color gridColor,
                    Color focusColor,
                    boolean grid,
                    boolean focus,
                    boolean labels,
                    boolean divideButtons,
                    boolean colorPalette,
                    boolean statusBar,
                    boolean littleImage) {
        this.fileName = fileName;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.gridColor = gridColor;
        this.focusColor = focusColor;
        this.grid = grid;
        this.focus = focus;
        this.labels = labels;
        this.divideButtons = divideButtons;
        this.colorPalette = colorPalette;
        this.statusBar = statusBar;
        this.littleImage = littleImage;
    }

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Settings() {
        this(IMAGE_FILE_01,
                4,
                4,
                Color.gray,
                Color.white,
                true,
                true,
                true,
                true,
                true,
                true,
                true);
    }

    //----------------------------------------------------------------------

    public boolean isColorPalette() {
        return colorPalette;
    }

    public boolean isColumnButtons() {
        return divideButtons;
    }

    public boolean isColumnLabels() {
        return labels;
    }

    public void setColorPalette(boolean colorPalette) {
        this.colorPalette = colorPalette;
    }

    public void setColumnButtons(boolean columnButtons) {
        this.divideButtons = columnButtons;
    }

    public void setColumnLabels(boolean columnLabels) {
        this.labels = columnLabels;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public Color getFocusColor() {
        return focusColor;
    }

    public boolean isGrid() {
        return grid;
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

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }


    public boolean isStatusBar() {
        return statusBar;
    }

    public void setStatusBar(boolean statusBar) {
        this.statusBar = statusBar;
    }


    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public void setLookAndFeel(int lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public void setLittleImage(boolean littleImage) {
        this.littleImage = littleImage;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    public void setGrid(boolean grid) {
        this.grid = grid;
    }

    public void setFocusColor(Color focusColor) {
        this.focusColor = focusColor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}