package org.example.entity;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Konstansok */
public interface Constants {

    /** A teljes kép szélessége */
    public static final int IMAGE_WIDTH = 480;

    /** A teljes kép magassága */
    public static final int IMAGE_HEIGHT = 360;

    /** A képfájlok elérési útjai */
    public static final String IMAGE_FILE_01 = "images/image01.jpg";
    public static final String IMAGE_FILE_02 = "images/image02.jpg";
    public static final String IMAGE_FILE_03 = "images/image03.jpg";
    public static final String IMAGE_FILE_04 = "images/image04.jpg";
    public static final String IMAGE_FILE_05 = "images/image05.jpg";
    public static final String IMAGE_FILE_06 = "images/image06.jpg";
    public static final String IMAGE_FILE_07 = "images/image07.jpg";
    public static final String IMAGE_FILE_08 = "images/image08.jpg";

    /** Az oszlopfeliraotk értékei */
    public static final String[] LETTERS =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

    /** A kinézet lehetséges értékei */
    public static final int WINDOWS_LOOK_AND_FEEL = 100;
    public static final int METAL_LOOK_AND_FEEL = 101;
    public static final int MOTIF_LOOK_AND_FEEL = 103;

    /** A színbeállítás a rácsra vonatkozik */
    public static final int GRID_COLOR_SETTING = 0;

    /** A színbeállítás a kijelölésre vonatkozik */
    public static final int FOCUS_COLOR_SETTING = 1;

    /** Nincs kijelölt lap */
    public static final String NONE = "—  ";

    /** Ki van rakva */
    public static final String MADE = "KÉSZ!";
}







