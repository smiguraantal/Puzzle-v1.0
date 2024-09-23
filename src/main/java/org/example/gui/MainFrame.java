package org.example.gui;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.example.entity.Constants;
import org.example.entity.DataModule;
import org.example.entity.Divider;
import org.example.gui.dialog.AboutDialog;
import org.example.gui.dialog.HowToUseDialog;
import org.example.gui.panel.ColorPalette;
import org.example.gui.panel.GamePanel;
import org.example.gui.panel.LittleImagePanel;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>Title: Puzzle</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.0
 */

/** Az alkalmazás főablaka */
public class MainFrame extends JFrame implements Constants {

    /** Adatmodul */
    private DataModule dataModule = DataModule.getDataModule();

    /** Játékpanel */
    GamePanel gamePanel;

    /** Színpaletta */
    ColorPalette colorPalette = new ColorPalette(this);

    /** Miniatűr kép */
    LittleImagePanel littleImage = new LittleImagePanel();

    /** Névjegy dialógus */
    AboutDialog aboutDialog = new AboutDialog(this);

    /** Használat dialógus */
    HowToUseDialog howToUseDialog = new HowToUseDialog(this);

    ButtonGroup bgImages = new ButtonGroup();
    ButtonGroup bgLookAndFeel = new ButtonGroup();

    JPanel contentPane;
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu miGame = new JMenu();
    JMenuItem miExit = new JMenuItem();
    JMenu mHelp = new JMenu();
    JMenuItem miAbout = new JMenuItem();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JMenuItem miShuffle = new JMenuItem();
    JMenuItem miSort = new JMenuItem();
    JMenu mSettings = new JMenu();
    JMenu miImage = new JMenu();
    JMenuItem miUse = new JMenuItem();
    JCheckBoxMenuItem miGrid = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miFocus = new JCheckBoxMenuItem();
    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JPanel pnGameBase = new JPanel();
    GridBagLayout gridBagLayout3 = new GridBagLayout();
    JPanel pnColumnLabels = new JPanel();
    GridBagLayout gridBagLayout4 = new GridBagLayout();
    JPanel pnLetters = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JPanel pnRowLabels = new JPanel();
    GridBagLayout gridBagLayout5 = new GridBagLayout();
    JPanel pnNumbers = new JPanel();
    GridLayout gridLayout2 = new GridLayout();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    JLabel jLabel15 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JPanel jPanel100 = new JPanel();
    JPanel pnColumnButtons = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel7 = new JPanel();
    JPanel jPanel8 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    FlowLayout flowLayout2 = new FlowLayout();
    JPanel pnRowButtons = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel10 = new JPanel();
    JPanel jPanel11 = new JPanel();
    FlowLayout flowLayout3 = new FlowLayout();
    FlowLayout flowLayout4 = new FlowLayout();
    JLabel lbPlusColumn = new JLabel();
    Border border1;
    JLabel lbMinusColumn = new JLabel();
    Border border2;
    JLabel lbMinusRow = new JLabel();
    Border border3;
    JLabel lbPlusRow = new JLabel();
    Border border4;
    GridBagLayout gridBagLayout6 = new GridBagLayout();
    JCheckBoxMenuItem miLabels = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miDivideButtons = new JCheckBoxMenuItem();
    Border border5;
    TitledBorder titledBorder1;
    JPanel jPanel6 = new JPanel();
    JPanel jPanel9 = new JPanel();
    JPanel jPanel12 = new JPanel();
    JPanel jPanel13 = new JPanel();
    JPanel jPanel14 = new JPanel();
    JPanel jPanel15 = new JPanel();
    JPanel jPanel16 = new JPanel();
    JPanel jPanel17 = new JPanel();
    JPanel jPanel18 = new JPanel();
    JPanel jPanel19 = new JPanel();
    Border border6;
    Border border7;
    Border border8;
    JPanel jPanel20 = new JPanel();
    JPanel jPanel21 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    GridBagLayout gridBagLayout7 = new GridBagLayout();
    GridBagLayout gridBagLayout8 = new GridBagLayout();
    JCheckBoxMenuItem miColorPalette = new JCheckBoxMenuItem();
    JCheckBoxMenuItem miLittleImage = new JCheckBoxMenuItem();
    JRadioButtonMenuItem miImage01 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage02 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage03 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage04 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage05 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage06 = new JRadioButtonMenuItem();
    JMenu miLookAndFeel = new JMenu();
    JRadioButtonMenuItem miWindows = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMetal = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miMotif = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage07 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem miImage08 = new JRadioButtonMenuItem();
    JPanel pnStatus = new JPanel();
    GridBagLayout gridBagLayout9 = new GridBagLayout();
    JLabel jLabel17 = new JLabel();
    JLabel lbNumberOfPictures = new JLabel();
    JLabel jLabel19 = new JLabel();
    JLabel lbAtWrongPlace = new JLabel();
    JLabel lbMade = new JLabel();
    JLabel jLabel22 = new JLabel();
    JLabel lbSelectedImage = new JLabel();
    JCheckBoxMenuItem miStatus = new JCheckBoxMenuItem();
    JMenuItem jMenuItem1 = new JMenuItem();

    //----------------------------------------------------------------------

    /** Konstruktor */
    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------

    private void jbInit() throws Exception {
        pnColumnLabels.setBackground(Color.white);
        pnRowLabels.setBackground(Color.white);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        contentPane = (JPanel) this.getContentPane();
        border1 = BorderFactory.createLineBorder(Color.black, 1);
        border2 = BorderFactory.createLineBorder(Color.black, 1);
        border3 = BorderFactory.createLineBorder(Color.black, 1);
        border4 = BorderFactory.createLineBorder(Color.black, 1);
        border5 = BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140));
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140)), "Színek");
        border6 = BorderFactory.createCompoundBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black, 1), " Színek "), BorderFactory.createEmptyBorder(5, 5, 5, 5));
        border7 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(SystemColor.controlText, 1), BorderFactory.createEmptyBorder(0, 5, 0, 0));
        border8 = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(SystemColor.controlText, 1), BorderFactory.createEmptyBorder(0, 5, 0, 0));
        contentPane.setLayout(gridBagLayout1);
        this.setTitle("Puzzle");
        this.addWindowListener(new MainFrame_this_windowAdapter(this));
        miGame.setAlignmentY((float) 0.5);
        miGame.setMnemonic('J');
        miGame.setText("Játék");
        miGame.setArmed(false);
        miExit.setText("Kilépés");
        miExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK, false));
        miExit.addActionListener(new MainFrame_miExit_actionAdapter(this));
        mHelp.setMnemonic('S');
        mHelp.setText("Súgó");
        miAbout.setText("Névjegy");
        miAbout.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK, false));
        miAbout.addActionListener(new MainFrame_miAbout_actionAdapter(this));
        miShuffle.setText("Keverés");
        miShuffle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0, false));
        miShuffle.addActionListener(new MainFrame_miShuffle_actionAdapter(this));
        miSort.setText("Kirakás");
        miSort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0, false));
        miSort.addActionListener(new MainFrame_miSort_actionAdapter(this));
        mSettings.setMnemonic('B');
        mSettings.setText("Beállítások");
        miImage.setText("Kép");
        miUse.setText("Használat");
        miUse.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0, false));
        miUse.addActionListener(new MainFrame_miUse_actionAdapter(this));
        miGrid.setText("Rács");
        miGrid.setAccelerator(KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK, false));
        miGrid.addActionListener(new MainFrame_miGrid_actionAdapter(this));
        miFocus.setText("Kijelölés");
        miFocus.setAccelerator(KeyStroke.getKeyStroke('K', KeyEvent.CTRL_MASK, false));
        miFocus.addActionListener(new MainFrame_miFocus_actionAdapter(this));
        jPanel1.setLayout(gridBagLayout2);
        pnGameBase.setBackground(Color.white);
        pnGameBase.setLayout(gridBagLayout3);
        pnColumnLabels.setLayout(gridBagLayout4);
        pnLetters.setLayout(gridLayout1);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("A");
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("E");
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("G");
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("F");
        pnRowLabels.setLayout(gridBagLayout5);
        pnNumbers.setLayout(gridLayout2);
        gridLayout2.setColumns(1);
        gridLayout2.setRows(0);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("1");
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("4");
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("3");
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel8.setText("2");
        //pnRowLabels.setBackground(Color.black);
        pnNumbers.setPreferredSize(new Dimension(20, 60));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("E");
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("D");
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("C");
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setText("B");
        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setText("F");
        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setText("G");
        jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel15.setText("H");
        jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel16.setText("I");
        pnLetters.setMinimumSize(new Dimension(96, 15));
        pnLetters.setPreferredSize(new Dimension(96, 20));
        jPanel100.setLayout(gridBagLayout6);
        pnColumnButtons.setLayout(borderLayout1);
        jPanel7.setLayout(flowLayout1);
        flowLayout1.setHgap(0);
        flowLayout1.setVgap(0);
        jPanel8.setLayout(flowLayout2);
        flowLayout2.setHgap(0);
        flowLayout2.setVgap(0);
        pnRowButtons.setLayout(borderLayout2);
        jPanel11.setLayout(flowLayout3);
        jPanel10.setLayout(flowLayout4);
        flowLayout4.setHgap(0);
        flowLayout4.setVgap(0);
        flowLayout3.setHgap(0);
        flowLayout3.setVgap(0);
        lbPlusColumn.setFont(new Font("Dialog", 0, 15));
        lbPlusColumn.setBorder(border1);
        lbPlusColumn.setPreferredSize(new Dimension(20, 20));
        lbPlusColumn.setHorizontalAlignment(SwingConstants.CENTER);
        lbPlusColumn.setHorizontalTextPosition(SwingConstants.CENTER);
        lbPlusColumn.setText("+");
        lbPlusColumn.addMouseListener(new MainFrame_lbPlusColumn_mouseAdapter(this));
        lbMinusColumn.setFont(new Font("Dialog", 0, 15));
        lbMinusColumn.setBorder(border2);
        lbMinusColumn.setPreferredSize(new Dimension(20, 20));
        lbMinusColumn.setHorizontalAlignment(SwingConstants.CENTER);
        lbMinusColumn.setHorizontalTextPosition(SwingConstants.CENTER);
        lbMinusColumn.setText("–");
        lbMinusColumn.addMouseListener(new MainFrame_lbMinusColumn_mouseAdapter(this));
        lbMinusRow.setFont(new Font("Dialog", 0, 15));
        lbMinusRow.setBorder(border3);
        lbMinusRow.setPreferredSize(new Dimension(20, 20));
        lbMinusRow.setHorizontalAlignment(SwingConstants.CENTER);
        lbMinusRow.setHorizontalTextPosition(SwingConstants.CENTER);
        lbMinusRow.setText("–");
        lbMinusRow.addMouseListener(new MainFrame_lbMinusRow_mouseAdapter(this));
        lbPlusRow.setFont(new Font("Dialog", 0, 15));
        lbPlusRow.setBorder(border4);
        lbPlusRow.setPreferredSize(new Dimension(20, 20));
        lbPlusRow.setHorizontalAlignment(SwingConstants.CENTER);
        lbPlusRow.setHorizontalTextPosition(SwingConstants.CENTER);
        lbPlusRow.setText("+");
        lbPlusRow.addMouseListener(new MainFrame_lbPlusRow_mouseAdapter(this));
        miLabels.setText("Feliratok");
        miLabels.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_MASK, false));
        miLabels.addActionListener(new MainFrame_miLabels_actionAdapter(this));
        miDivideButtons.setText("Felbontás");
        miDivideButtons.setAccelerator(KeyStroke.getKeyStroke('F', KeyEvent.CTRL_MASK, false));
        miDivideButtons.addActionListener(new MainFrame_miDivideButtons_actionAdapter(this));
        pnRowButtons.setAlignmentY((float) 0.5);
        jPanel20.setBackground(Color.pink);
        jPanel20.setPreferredSize(new Dimension(120, 90));
        jPanel21.setLayout(borderLayout4);
        jPanel2.setLayout(gridBagLayout8);
        jPanel3.setLayout(gridBagLayout7);
        jPanel3.setPreferredSize(new Dimension(170, 160));
        miColorPalette.setText("Színpaletta");
        miColorPalette.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK, false));
        miColorPalette.addActionListener(new MainFrame_miColorPalette_actionAdapter(this));
        miLittleImage.setText("Miniatűr");
        miLittleImage.setAccelerator(KeyStroke.getKeyStroke('M', KeyEvent.CTRL_MASK, false));
        miLittleImage.addActionListener(new MainFrame_miLittleImage_actionAdapter(this));
        miImage01.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.CTRL_MASK, false));
        miImage01.setText("Kókuszdió");
        miImage01.addActionListener(new MainFrame_mi1_actionAdapter(this));
        miImage02.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, KeyEvent.CTRL_MASK, false));
        miImage02.setText("Szőlő");
        miImage02.addActionListener(new MainFrame_mi2_actionAdapter(this));
        miImage03.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.CTRL_MASK, false));
        miImage03.setText("Oroszlán");
        miImage03.addActionListener(new MainFrame_mi3_actionAdapter(this));
        miImage04.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_MASK, false));
        miImage04.setText("Graffiti");
        miImage04.addActionListener(new MainFrame_mi4_actionAdapter(this));
        miImage05.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, KeyEvent.CTRL_MASK, false));
        miImage05.setText("Kavics");
        miImage05.addActionListener(new MainFrame_mi5_actionAdapter(this));
        miImage06.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, KeyEvent.CTRL_MASK, false));
        miImage06.setText("Erdő");
        miImage06.addActionListener(new MainFrame_mi6_actionAdapter(this));
        miLookAndFeel.setText("Felület");
        miWindows.setAccelerator(KeyStroke.getKeyStroke('W', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miWindows.setText("Windows");
        miWindows.addActionListener(new MainFrame_miWindows_actionAdapter(this));
        miMetal.setAccelerator(KeyStroke.getKeyStroke('M', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miMetal.setText("Metal");
        miMetal.addActionListener(new MainFrame_miMetal_actionAdapter(this));
        miMotif.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK | KeyEvent.ALT_MASK, false));
        miMotif.setText("CDE/Motif");
        miMotif.addActionListener(new MainFrame_miMotif_actionAdapter(this));
        miImage07.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, KeyEvent.CTRL_MASK, false));
        miImage07.setText("Krokodil");
        miImage07.addActionListener(new MainFrame_miImage07_actionAdapter(this));
        miImage08.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, KeyEvent.CTRL_MASK, false));
        miImage08.setText("Fa kockák");
        miImage08.addActionListener(new MainFrame_miImage08_actionAdapter(this));
        pnStatus.setLayout(gridBagLayout9);
        jLabel17.setText("Képkockák száma:");
        lbNumberOfPictures.setPreferredSize(new Dimension(30, 16));
        lbNumberOfPictures.setHorizontalAlignment(SwingConstants.RIGHT);
        lbNumberOfPictures.setText("334");
        jLabel19.setPreferredSize(new Dimension(100, 16));
        jLabel19.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel19.setText("Rossz helyen:");
        lbAtWrongPlace.setPreferredSize(new Dimension(30, 16));
        lbAtWrongPlace.setHorizontalAlignment(SwingConstants.RIGHT);
        pnStatus.setPreferredSize(new Dimension(204, 20));
        jLabel22.setPreferredSize(new Dimension(120, 16));
        jLabel22.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel22.setText("Kijelölt képkocka:");
        lbSelectedImage.setPreferredSize(new Dimension(40, 16));
        lbSelectedImage.setHorizontalAlignment(SwingConstants.RIGHT);
        lbSelectedImage.setText(NONE);
        miStatus.setText("Állapotsor");
        miStatus.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.CTRL_MASK, false));
        miStatus.addActionListener(new MainFrame_miStatus_actionAdapter(this));
        lbMade.setFont(new Font("Dialog", 1, 15));
        lbMade.setForeground(Color.red);
        jMenuItem1.setText("Metal 3D");
        miGame.add(miImage);
        miImage.add(miImage01);
        miImage.add(miImage02);
        miImage.add(miImage03);
        miImage.add(miImage04);
        miImage.add(miImage05);
        miImage.add(miImage06);
        miImage.add(miImage07);
        miImage.add(miImage08);
        miGame.addSeparator();
        miGame.add(miShuffle);
        miGame.add(miSort);
        miGame.addSeparator();
        miGame.add(miExit);
        mHelp.add(miUse);
        mHelp.add(miAbout);
        jMenuBar1.add(miGame);
        jMenuBar1.add(mSettings);
        jMenuBar1.add(mHelp);

        mSettings.add(miFocus);
        mSettings.add(miGrid);

        mSettings.addSeparator();

        mSettings.add(miLittleImage);
        mSettings.add(miColorPalette);
        mSettings.add(miDivideButtons);
        mSettings.add(miLabels);
        mSettings.add(miStatus);
        mSettings.addSeparator();
        mSettings.add(miLookAndFeel);

        contentPane.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(pnGameBase, new GridBagConstraints(2, 2, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        jPanel1.add(pnColumnLabels, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        pnColumnLabels.add(pnLetters, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        pnLetters.add(jLabel1, null);
        pnLetters.add(jLabel12, null);
        pnLetters.add(jLabel11, null);
        pnLetters.add(jLabel10, null);
        pnLetters.add(jLabel9, null);
        pnLetters.add(jLabel4, null);
        pnLetters.add(jLabel3, null);
        pnLetters.add(jLabel2, null);
        pnLetters.add(jLabel13, null);
        pnLetters.add(jLabel14, null);
        pnLetters.add(jLabel15, null);
        pnLetters.add(jLabel16, null);
        jPanel1.add(pnRowLabels, new GridBagConstraints(1, 2, 1, 1, 0.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 0), 0, 0));
        pnRowLabels.add(pnNumbers, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        pnNumbers.add(jLabel5, null);
        pnNumbers.add(jLabel8, null);
        pnNumbers.add(jLabel7, null);
        pnNumbers.add(jLabel6, null);
        jPanel1.add(jPanel100, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel100.add(jPanel21, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        jPanel1.add(pnColumnButtons, new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
        pnColumnButtons.add(jPanel7, BorderLayout.EAST);
        jPanel7.add(lbPlusColumn, null);
        pnColumnButtons.add(jPanel8, BorderLayout.WEST);
        jPanel8.add(lbMinusColumn, null);
        jPanel1.add(pnRowButtons, new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 0), 0, 0));
        pnRowButtons.add(jPanel10, BorderLayout.SOUTH);
        jPanel10.add(lbPlusRow, null);
        pnRowButtons.add(jPanel11, BorderLayout.NORTH);
        jPanel11.add(lbMinusRow, null);
        jPanel1.add(pnStatus, new GridBagConstraints(2, 3, 1, 1, 1.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        pnStatus.add(jLabel17, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0
                , GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 5, 0, 0), 0, 0));
        pnStatus.add(lbNumberOfPictures, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        pnStatus.add(jLabel19, new GridBagConstraints(2, 0, 1, 1, 0.0, 10.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        pnStatus.add(lbAtWrongPlace, new GridBagConstraints(3, 0, 1, 1, 0.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        pnStatus.add(lbMade, new GridBagConstraints(6, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
        pnStatus.add(jLabel22, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        pnStatus.add(lbSelectedImage, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.setJMenuBar(jMenuBar1);

        jPanel21.add(jPanel2, BorderLayout.SOUTH);
        jPanel2.add(littleImage, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        jPanel21.add(jPanel3, BorderLayout.NORTH);
        jPanel3.add(colorPalette, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));


        bgImages.add(miImage01);
        bgImages.add(miImage02);
        bgImages.add(miImage03);
        bgImages.add(miImage04);
        bgImages.add(miImage05);
        bgImages.add(miImage06);
        bgImages.add(miImage07);
        bgImages.add(miImage08);

        bgLookAndFeel.add(miWindows);
        bgLookAndFeel.add(miMetal);
        bgLookAndFeel.add(miMotif);

        miLookAndFeel.add(miWindows);
        miLookAndFeel.add(miMetal);
        miLookAndFeel.add(miMotif);

        initLettersPanel();
        initNumbersPanel();

        pnGameBase.add(gamePanel = new GamePanel(this),
                new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(1, 1, 1, 1), 0, 0));

        setComponents();
    }

    /** Beállítja a komponenseket */
    private void setComponents() {
        // kép
        if (dataModule.getFileName().equals(IMAGE_FILE_01))
            miImage01.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_02))
            miImage02.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_03))
            miImage03.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_04))
            miImage04.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_05))
            miImage05.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_06))
            miImage06.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_07))
            miImage07.setSelected(true);
        if (dataModule.getFileName().equals(IMAGE_FILE_08))
            miImage08.setSelected(true);
        // feliratok
        miLabels.setSelected(dataModule.isLabels());
        pnColumnLabels.setVisible(dataModule.isLabels());
        pnRowLabels.setVisible(dataModule.isLabels());
        // felosztás gombok
        miDivideButtons.setSelected(dataModule.isDivideButtons());
        pnColumnButtons.setVisible(dataModule.isDivideButtons());
        pnRowButtons.setVisible(dataModule.isDivideButtons());
        // állapotsor
        miStatus.setSelected(dataModule.isStatusBar());
        pnStatus.setVisible(dataModule.isStatusBar());
        // rács
        miGrid.setSelected(dataModule.isGrid());
        // kijelölés
        miFocus.setSelected(dataModule.isFocus());
        // kép keretének színe
        pnGameBase.setBackground(dataModule.isGrid() ?
                dataModule.getGridColor() : Color.black);
        // színpaletta
        miColorPalette.setSelected(dataModule.isColorPalette());
        jPanel3.setVisible(dataModule.isColorPalette());
        // miniatűr
        miLittleImage.setSelected(dataModule.isLittleImage());
        jPanel2.setVisible(dataModule.isLittleImage());
        // Kinézet
        if (dataModule.getLookAndFeel() == WINDOWS_LOOK_AND_FEEL)
            miWindows.setSelected(true);
        else if (dataModule.getLookAndFeel() == METAL_LOOK_AND_FEEL)
            miMetal.setSelected(true);
        else
            miMotif.setSelected(true);
        // képek száma
        lbNumberOfPictures.setText(
                "" + dataModule.getNumberOfColumns() * dataModule.getNumberOfRows());
    }

    /** Ha a kapott kinézet eltér az aktuális kinézettől, akkor az
     * alkalmazás összes komponense új megjelenítést kap. */
    private void changeLookAndFeel(int lookAndFeel) {
        int actualLookAndFeel = dataModule.getLookAndFeel();
        if (actualLookAndFeel != lookAndFeel) {
            try {
                if (lookAndFeel == WINDOWS_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                if (lookAndFeel == METAL_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                if (lookAndFeel == MOTIF_LOOK_AND_FEEL)
                    UIManager.setLookAndFeel(new MotifLookAndFeel());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                // a dialógusok frissítése
                SwingUtilities.updateComponentTreeUI(howToUseDialog.getRootPane());
                howToUseDialog.refreshTree(); // a fa ikonjai nem frissülnek maguktók
                SwingUtilities.updateComponentTreeUI(aboutDialog.getRootPane());

                dataModule.setLookAndFeel(lookAndFeel); // az új kinézet elmentése
                getRootPane().revalidate();
                getRootPane().repaint();
                pack();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }
    }

    //----------------------------------------------------------------------

    /** Új képet jelenít meg */
    private void changeImage(String fileName) {
        if (!dataModule.getFileName().equals(fileName)) { // csak akkor cserél, ha másik kép került kiválasztásra
            dataModule.setFileName(fileName);
            gamePanel.shuffle();
            gamePanel.refresh();
            littleImage.loadImage();
            littleImage.repaint();
            witchLabels(NONE);
            lbMade.setText("");
        }
    }

    //----------------------------------------------------------------------

    /** Kiírja, hogy melyik oszlop, illetve sor indexű képkocka van kijelölve */
    public void witchLabels(String labels) {
        lbSelectedImage.setText(labels);
    }

    //----------------------------------------------------------------------

    /** Kiírja hogy kész a kirakás */
    public void made() {
        lbMade.setText(MADE);
        Toolkit.getDefaultToolkit().beep();
    }

    //----------------------------------------------------------------------

    /** Létrehozza a betűpanelokat */
    private void initLettersPanel() {
        pnLetters.removeAll();
        for (int i = 0; i < dataModule.getNumberOfColumns(); i++) {
            pnLetters.add(new JLabel(LETTERS[i], SwingConstants.CENTER));
        }
    }

    //----------------------------------------------------------------------

    /** Létrehozza a számpanelokat */
    private void initNumbersPanel() {
        pnNumbers.removeAll();
        for (int i = 1; i <= dataModule.getNumberOfRows(); i++) {
            pnNumbers.add(new JLabel("" + i, SwingConstants.CENTER));
        }
    }

    //----------------------------------------------------------------------

    /** Kijelöli a kiválasztott képkocka indexeit */
    public void selectLabels(int column, int row) {
        for (int i = 0; i < dataModule.getNumberOfColumns(); i++) {
            Component component = pnLetters.getComponent(i);
            component.setForeground(column == i ? Color.red : Color.black);
        }
        for (int i = 0; i < dataModule.getNumberOfRows(); i++) {
            Component component = pnNumbers.getComponent(i);
            component.setForeground(row == i ? Color.red : Color.black);
        }
    }

    //----------------------------------------------------------------------

    /** Feliratok láthatóságának beállítása */
    void miLabels_actionPerformed(ActionEvent e) {
        dataModule.setLabels(!dataModule.isLabels());
        pnColumnLabels.setVisible(dataModule.isLabels());
        pnRowLabels.setVisible(dataModule.isLabels());
        pack();
    }

    //----------------------------------------------------------------------

    /** Felbontást állító gombok láthatósága */
    void miDivideButtons_actionPerformed(ActionEvent e) {
        dataModule.setDivideButtons(!dataModule.isDivideButtons());
        pnColumnButtons.setVisible(dataModule.isDivideButtons());
        pnRowButtons.setVisible(dataModule.isDivideButtons());
        pack();
    }


    //----------------------------------------------------------------------

    /** Rács láthatósága */
    void miGrid_actionPerformed(ActionEvent e) {
        dataModule.setGrid(!dataModule.isGrid());
        pnGameBase.setBackground(dataModule.isGrid() ?
                dataModule.getGridColor() : Color.black);
        gamePanel.grid();
    }

    //----------------------------------------------------------------------

    /** Kijelölés láthatósága */
    void miFocus_actionPerformed(ActionEvent e) {
        dataModule.setFocus(!dataModule.isFocus());
        gamePanel.focus();
    }

    //----------------------------------------------------------------------

    void mi1_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_01);
    }

    void mi2_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_02);
    }

    void mi3_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_03);
    }

    void mi4_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_04);
    }

    void mi5_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_05);
    }

    void mi6_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_06);
    }

    void miImage07_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_07);
    }

    void miImage08_actionPerformed(ActionEvent e) {
        changeImage(IMAGE_FILE_08);
    }

    //----------------------------------------------------------------------

    /** Keverés */
    void miShuffle_actionPerformed(ActionEvent e) {
        gamePanel.shuffle();
        lbAtWrongPlace.setText("" + gamePanel.atWrongPlace());
        witchLabels(NONE);
        lbMade.setText("");
    }

    //----------------------------------------------------------------------

    /** Beállítja a szükséges komponenseket egy-egy új felbontás beállítása
     * után */
    private void newDividing() {
        dataModule.setNumberOfSelectedImagePanels(0);
        initLettersPanel();
        initNumbersPanel();
        pnGameBase.removeAll();
        pnGameBase.add(gamePanel = new GamePanel(this),
                new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(1, 1, 1, 1), 0, 0));
        lbNumberOfPictures.setText(
                "" + dataModule.getNumberOfColumns() * dataModule.getNumberOfRows());
        witchLabels(NONE);
        lbMade.setText("");
        pack();
    }

    //----------------------------------------------------------------------

    /** Kevesebb oszlop */
    void lbMinusColumn_mousePressed(MouseEvent e) {
        int lessDividing =
                new Divider(dataModule.getNumberOfColumns()).lessDividing();
        if (lessDividing < dataModule.getNumberOfColumns()) {
            dataModule.setNumberOfColumns(lessDividing);
            newDividing();
        }
    }

    //----------------------------------------------------------------------

    /** Több oszlop */
    void lbPlusColumn_mousePressed(MouseEvent e) {
        int moreDividing =
                new Divider(dataModule.getNumberOfColumns()).moreDividing();
        if (moreDividing > dataModule.getNumberOfColumns()) {
            dataModule.setNumberOfColumns(moreDividing);
            newDividing();
        }
    }

    //----------------------------------------------------------------------

    /** Kevesebb sor */
    void lbMinusRow_mousePressed(MouseEvent e) {
        int lessDividing =
                new Divider(dataModule.getNumberOfRows()).lessDividing();
        if (lessDividing < dataModule.getNumberOfRows()) {
            dataModule.setNumberOfRows(lessDividing);
            newDividing();
        }
    }

    //----------------------------------------------------------------------

    /** Több sor */
    void lbPlusRow_mousePressed(MouseEvent e) {
        int moreDividing =
                new Divider(dataModule.getNumberOfRows()).moreDividing();
        if (moreDividing > dataModule.getNumberOfRows()) {
            dataModule.setNumberOfRows(moreDividing);
            newDividing();
        }
    }

    //----------------------------------------------------------------------

    /** Kirakás */
    void miSort_actionPerformed(ActionEvent e) {
        gamePanel.sort();
        lbAtWrongPlace.setText("" + gamePanel.atWrongPlace());
        witchLabels(NONE);
        made();
    }

    //----------------------------------------------------------------------

    /** Színpaletta megjelenítése/elrejtése */
    void miColorPalette_actionPerformed(ActionEvent e) {
        dataModule.setColorPalette(!dataModule.isColorPalette());
        jPanel3.setVisible(dataModule.isColorPalette());
        pack();
    }

    //----------------------------------------------------------------------

    /** Állapotsor megjelenítése/elrejtése */
    void miStatus_actionPerformed(ActionEvent e) {
        dataModule.setStatusBar(!dataModule.isStatusBar());
        pnStatus.setVisible(dataModule.isStatusBar());
        pack();
    }

    //----------------------------------------------------------------------

    /** Miniatűr megjelenítése/elrejtése */
    void miLittleImage_actionPerformed(ActionEvent e) {
        dataModule.setLittleImage(!dataModule.isLittleImage());
        jPanel2.setVisible(dataModule.isLittleImage());
        pack();
    }

    //----------------------------------------------------------------------

    /** Windows kinézet */
    void miWindows_actionPerformed(ActionEvent e) {
        changeLookAndFeel(WINDOWS_LOOK_AND_FEEL);
    }

    //----------------------------------------------------------------------

    /** Metal kinézet */
    void miMetal_actionPerformed(ActionEvent e) {
        changeLookAndFeel(METAL_LOOK_AND_FEEL);
    }

    //----------------------------------------------------------------------

    /** Motif kinézet */
    void miMotif_actionPerformed(ActionEvent e) {
        changeLookAndFeel(MOTIF_LOOK_AND_FEEL);
    }

    public JLabel getLbAtWrongPlace() {
        return lbAtWrongPlace;
    }

    public ColorPalette getColorPalette() {
        return colorPalette;
    }

    public JPanel getPnGameBase() {
        return pnGameBase;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    //----------------------------------------------------------------------

    /** Kilépés */
    private void exit() {
        if (MessageManager.showConfirmDialog(this, "Biztosan kilép?"))
            System.exit(0);
    }

    //----------------------------------------------------------------------

    /** Használat dialógus hívása */
    void miUse_actionPerformed(ActionEvent e) {
        howToUseDialog.showDialog();
    }

    //----------------------------------------------------------------------

    /** Névjegy dialógus hívása */
    void miAbout_actionPerformed(ActionEvent e) {
        aboutDialog.showDialog();
    }

    //----------------------------------------------------------------------

    /** Ablak bezására */
    void this_windowClosing(WindowEvent e) {
        exit();
    }

    //----------------------------------------------------------------------

    /** Kilépés */
    void miExit_actionPerformed(ActionEvent e) {
        exit();
    }


}

class MainFrame_miShuffle_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miShuffle_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miShuffle_actionPerformed(e);
    }
}

class MainFrame_lbMinusColumn_mouseAdapter extends MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbMinusColumn_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbMinusColumn_mousePressed(e);
    }
}

class MainFrame_lbPlusColumn_mouseAdapter extends MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbPlusColumn_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbPlusColumn_mousePressed(e);
    }
}

class MainFrame_lbMinusRow_mouseAdapter extends MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbMinusRow_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbMinusRow_mousePressed(e);
    }
}

class MainFrame_lbPlusRow_mouseAdapter extends MouseAdapter {
    MainFrame adaptee;

    MainFrame_lbPlusRow_mouseAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.lbPlusRow_mousePressed(e);
    }
}


class MainFrame_miSort_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miSort_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miSort_actionPerformed(e);
    }
}

class MainFrame_miGrid_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miGrid_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miGrid_actionPerformed(e);
    }
}

class MainFrame_miFocus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miFocus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miFocus_actionPerformed(e);
    }
}

class MainFrame_miLabels_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLabels_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLabels_actionPerformed(e);
    }
}

class MainFrame_miDivideButtons_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miDivideButtons_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miDivideButtons_actionPerformed(e);
    }
}

class MainFrame_miLittleImage_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miLittleImage_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miLittleImage_actionPerformed(e);
    }
}

class MainFrame_miColorPalette_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miColorPalette_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miColorPalette_actionPerformed(e);
    }
}

class MainFrame_mi1_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi1_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi1_actionPerformed(e);
    }
}

class MainFrame_mi2_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi2_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi2_actionPerformed(e);
    }
}

class MainFrame_mi3_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi3_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi3_actionPerformed(e);
    }
}

class MainFrame_mi4_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi4_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi4_actionPerformed(e);
    }
}

class MainFrame_mi5_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi5_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi5_actionPerformed(e);
    }
}

class MainFrame_mi6_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_mi6_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.mi6_actionPerformed(e);
    }
}

class MainFrame_miMetal_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMetal_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMetal_actionPerformed(e);
    }
}

class MainFrame_miMotif_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miMotif_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miMotif_actionPerformed(e);
    }
}

class MainFrame_miWindows_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miWindows_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miWindows_actionPerformed(e);
    }
}

class MainFrame_miImage07_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miImage07_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miImage07_actionPerformed(e);
    }
}

class MainFrame_miImage08_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miImage08_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miImage08_actionPerformed(e);
    }
}

class MainFrame_miStatus_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miStatus_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miStatus_actionPerformed(e);
    }
}

class MainFrame_miUse_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miUse_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miUse_actionPerformed(e);
    }
}

class MainFrame_miAbout_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miAbout_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miAbout_actionPerformed(e);
    }
}

class MainFrame_this_windowAdapter extends WindowAdapter {
    MainFrame adaptee;

    MainFrame_this_windowAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void windowClosing(WindowEvent e) {
        adaptee.this_windowClosing(e);
    }
}

class MainFrame_miExit_actionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_miExit_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.miExit_actionPerformed(e);
    }
}