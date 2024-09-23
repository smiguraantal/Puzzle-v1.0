package org.example.entity;

import java.awt.Toolkit;
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

/** A kép felosztását vezérlő osztály */
public class Divider {

    /** A felbontások értékeit tároló vektor */
    Vector divides = new Vector();

    /** Az aktuális felbontás */
    Integer actualDividing;

    //----------------------------------------------------------------------

    /** Konstruktor */
    public Divider(int actualDividing) {
        this.actualDividing = new Integer(actualDividing);
        initSizes();
    }

    //----------------------------------------------------------------------

    /** Feltölti a felbontásokat tároló vektort */
    private void initSizes() {
        divides.add(new Integer(2));
        divides.add(new Integer(3));
        divides.add(new Integer(4));
        divides.add(new Integer(5));
        divides.add(new Integer(6));
        divides.add(new Integer(8));
        divides.add(new Integer(10));
        divides.add(new Integer(12));
    }

    //----------------------------------------------------------------------

    /** Eggyel nagyobb felbontást ad vissza, ha még lehetséges nagyobb */
    public int moreDividing() {
        int index = divides.indexOf(actualDividing);
        if (index < divides.size() - 1)
            return ((Integer) divides.get(index + 1)).intValue();
        Toolkit.getDefaultToolkit().beep();
        return ((Integer) divides.get(index)).intValue();
    }

    //----------------------------------------------------------------------

    /** Eggyel kisebb felbontást ad vissza, ha még lehetséges kisebb */
    public int lessDividing() {
        int index = divides.indexOf(actualDividing);
        if (index > 0)
            return ((Integer) divides.get(index - 1)).intValue();
        Toolkit.getDefaultToolkit().beep();
        return ((Integer) divides.get(index)).intValue();
    }
}





