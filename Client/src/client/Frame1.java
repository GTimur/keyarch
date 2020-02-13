package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;

import javax.management.Query;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultCaret;

public class Frame1 extends JFrame {
    @SuppressWarnings("compatibility:5402982300376480605")
    private static final long serialVersionUID = 1L;
    private String VERSION_BANNER=keyarch.VERSION_BANNER+" @"+FrameLogon.orasid;
    private String filteryear=this.Get_CurrentDate().substring(6,10);
    private int icusnum=-1;
    private int ikeynum=-1;    
    private DialogInformer dialoginformer = new DialogInformer(this,false);
    private String full_name=""; 
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jTable1 = new JTable();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField2 = new JTextField();
    private JPanel jPanel1 = new JPanel();
    private JTextField jTextField3 = new JTextField();
    private JLabel jLabel3 = new JLabel();   
    TableRowSorter<TableModel> sorter;
    private JMenu menuData = new JMenu();
    private JMenuItem menuDataInsert = new JMenuItem();
    private JMenuItem menuDataDelete = new JMenuItem();
    private JMenuItem menuDataUpdate = new JMenuItem();
    private JToolBar jToolBar1 = new JToolBar();
    private JEditorPane jEditorPane1 = new JEditorPane();
    private JCheckBox jCheckBox1 = new JCheckBox();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JTextField jTextField4 = new JTextField();
    private JTextField jTextField5 = new JTextField();
    private JLabel jLabel6 = new JLabel();
    private JTextField jTextField6 = new JTextField();
    private JLabel jLabel7 = new JLabel();
    private JTextField jTextField7 = new JTextField();    
    private JTextField jTextField8 = new JTextField();    
    private JMenu jMenu1 = new JMenu();
    private JMenuItem jMenuItem1 = new JMenuItem();
    private JButton jButton1 = new JButton();
    private JMenu jMenu2 = new JMenu();
    private JMenuItem jMenuItem2 = new JMenuItem();
    private JButton jButton2 = new JButton();
    private JMenuItem jMenuItem3 = new JMenuItem();
    private JLabel jLabel8 = new JLabel();
    private JTextField jTextField9 = new JTextField();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JTextField jTextField10 = new JTextField();
    private JTextField jTextField11 = new JTextField();
    private JTextField jTextField12 = new JTextField();
    private JTextField jTextField13 = new JTextField();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    private JTextField jTextField14 = new JTextField();
    private JLabel jLabel14 = new JLabel();
    private JTextField jTextField15 = new JTextField();
    private JTextField jTextField16 = new JTextField();
    private JTextField jTextField17 = new JTextField();
    private JLabel jLabel15 = new JLabel();
    private JLabel jLabel16 = new JLabel();
    private JLabel jLabel17 = new JLabel();
    private JMenu jMenu3 = new JMenu();
    private JMenuItem jMenuItem4 = new JMenuItem();
    private JLabel jLabel18 = new JLabel();
    private JLabel jLabel19 = new JLabel();
    private JTextField jTextField18 = new JTextField();
    private JTextField jTextField19 = new JTextField();
    private JLabel jLabel111 = new JLabel();
    private JLabel jLabel112 = new JLabel();
    private JTextField jTextField110 = new JTextField();
    private JLabel jLabel113 = new JLabel();
    private JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
    private JComboBox jComboBox1 = new JComboBox();
    private JTextField jTextField20 = new JTextField();
    private JLabel jLabel20 = new JLabel();
    private JMenuItem jMenuItem5 = new JMenuItem();
    private JMenuItem jMenuItem6 = new JMenuItem();

    public Frame1() {
        try {
            jbInit();
            this.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    private void jbInit() throws Exception {
        /**/      
        //jTable1 = new JTable(myModel());
        jTable1 = new JTable(new DefaultTableModel());
        jTable1.setFillsViewportHeight(true);        
        //jTable1.setPreferredSize(new Dimension(300,300));
        jTable1.setPreferredScrollableViewportSize(new Dimension(1000, 1000));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTextField1.setBounds(new Rectangle(570, 495, 190, 25));
        jTextField1.setFont(new Font("Tahoma", 0, 12));
        jLabel1.setText("ID \u043a\u043b\u044e\u0447\u0430");
        jLabel1.setBounds(new Rectangle(570, 480, 60, 15));
        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jLabel2.setText("Êëèåíò");
        jLabel2.setBounds(new Rectangle(5, 525, 50, 15));
        jLabel2.setFont(new Font("Tahoma", 1, 12));
        jTextField2.setBounds(new Rectangle(70, 540, 535, 25));
        jTextField2.setFont(new Font("Tahoma", 0, 12));
        jLabel3.setText("Ïîèñê:");
        jLabel3.setFont(new Font("Tahoma", 0, 12));
        menuData.setText("Îáðàáîòêà");
        menuDataInsert.setText("Äîáàâèòü");
        menuDataInsert.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuDataInsert_actionPerformed(e);
                }
            });
        menuDataDelete.setText("Óäàëèòü");
        menuDataDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menuDataDelete_actionPerformed(e);
                }
            });
        menuDataUpdate.setText("Èçìåíèòü");
        jToolBar1.setBounds(new Rectangle(5, 10, 320, 25));
        jToolBar1.setFloatable(false);
        jToolBar1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jCheckBox1.setText("\u041e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0442\u044c \u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0435\u043d\u043d\u044b\u0435");
        jCheckBox1.setBounds(new Rectangle(780, 10, 185, 25));
        jCheckBox1.setFont(new Font("Tahoma", 0, 12));        
        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox1_actionPerformed(e);
            }
        });
        jLabel4.setText("Äåéñòâóþùóèå êëþ÷è êëèåíòîâ");
        jLabel4.setForeground(Color.BLUE);
        jLabel4.setBounds(new Rectangle(370, 15, 300, 15));
        jLabel4.setFont(new Font("Arial", 1, 17));
        jLabel5.setText("0");
        jLabel5.setBounds(new Rectangle(1020, 595, 45, 15));
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setHorizontalTextPosition(SwingConstants.RIGHT);
        jTextField4.setBounds(new Rectangle(5, 540, 60, 25));
        jTextField4.setFont(new Font("Tahoma", 0, 12));
        jTextField5.setBounds(new Rectangle(620, 540, 125, 25));
        jTextField5.setFont(new Font("Tahoma", 0, 12));
        jLabel6.setText("\u041d\u042d\u041a");
        jLabel6.setBounds(new Rectangle(620, 525, 45, 15));
        jLabel6.setFont(new Font("Tahoma", 1, 12));
        jTextField6.setBounds(new Rectangle(855, 540, 115, 25));
        jTextField6.setFont(new Font("Tahoma", 0, 12));
        jLabel7.setText("OTP");
        jLabel7.setBounds(new Rectangle(860, 525, 45, 15));
        jLabel7.setFont(new Font("Tahoma", 1, 12));
        jTextField7.setBounds(new Rectangle(745, 540, 45, 25));
        jTextField7.setBackground(Color.orange);
        jTextField7.setHorizontalAlignment(JTextField.CENTER);
        jTextField8.setBounds(new Rectangle(970, 540, 45, 25));
        jTextField8.setBackground(Color.orange);
        jTextField8.setHorizontalAlignment(JTextField.CENTER);
        jMenu1.setText("\u0421\u0440-\u0432\u0430 \u0437\u0430\u0449\u0438\u0442\u044b");
        jMenuItem1.setText("\u0412\u044b\u0434\u0430\u0442\u044c \u0441\u0440\u0435\u0434\u0441\u0442\u0432\u0430 \u0437\u0430\u0449\u0438\u0442\u044b");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem1_actionPerformed(e);
            }
        });
        jButton1.setBounds(new Rectangle(970, 5, 45, 35));
        jButton1.setToolTipText("\u041f\u0435\u0447\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 (\u0432\u044b\u0434\u0430\u0447\u0430/\u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0435\u043d\u0438\u0435)");
        jButton1.setIconTextGap(0);
        jButton1.setMargin(new Insets(1, 1, 1, 1));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1_actionPerformed(e);
            }
        });
        jScrollPane1 = new JScrollPane(jTable1);
        this.refilltable(jTable1);
        jScrollPane1.setViewportView(jTable1);        
        /**/
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(1078, 677));
        this.setTitle(this.VERSION_BANNER);
        this.setBounds(new Rectangle(10, 10, 1078, 680));
        menuFile.setText("Ôàéë");
        menuFileExit.setText("Âûõîä");
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText("Ïîìîùü");
        menuHelpAbout.setText("Î ïðîãðàììå");
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        jScrollPane1.setBounds(new Rectangle(5, 45, 1060, 430));
        jScrollPane1.setFont(new Font("Dialog", 0, 13));
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        jMenu3.add(jMenuItem4);
        jMenu3.add(jMenuItem5);
        menuBar.add(jMenu3);
        menuData.add(menuDataInsert);
        menuData.add(menuDataUpdate);
        menuData.add(menuDataDelete);
        menuData.add(jMenuItem6);
        menuBar.add(menuData);
        jMenu1.add(jMenuItem1);
        menuBar.add(jMenu1);
        jMenu2.add(jMenuItem2);
        jMenu2.add(jMenuItem3);
        menuBar.add(jMenu2);
        menuHelp.add(menuHelpAbout);
        menuBar.add(menuHelp);
        jToolBar1.add(jLabel3, null);
        jToolBar1.add(jTextField3, null);
        this.getContentPane().add(jLabel20, null);
        this.getContentPane().add(jTextField20, null);
        this.getContentPane().add(jComboBox1, null);
        this.getContentPane().add(jLabel113, null);
        this.getContentPane().add(jTextField110, null);
        this.getContentPane().add(jLabel112, null);
        this.getContentPane().add(jLabel111, null);
        this.getContentPane().add(jTextField19, null);
        this.getContentPane().add(jTextField18, null);
        this.getContentPane().add(jLabel19, null);
        this.getContentPane().add(jLabel18, null);
        this.getContentPane().add(jLabel17, null);
        this.getContentPane().add(jLabel16, null);
        this.getContentPane().add(jLabel15, null);
        this.getContentPane().add(jTextField17, null);
        this.getContentPane().add(jTextField16, null);
        this.getContentPane().add(jTextField15, null);
        this.getContentPane().add(jLabel14, null);
        this.getContentPane().add(jTextField14, null);
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jTextField13, null);
        this.getContentPane().add(jTextField12, null);
        this.getContentPane().add(jTextField11, null);
        this.getContentPane().add(jTextField10, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jTextField9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jTextField8, null);
        this.getContentPane().add(jTextField7, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jTextField6, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jTextField5, null);
        this.getContentPane().add(jTextField4, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jCheckBox1, null);
        this.getContentPane().add(jToolBar1, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jTextField1, null);
        jScrollPane1.getViewport().add(jTable1, null);
        this.getContentPane().add(jScrollPane1, null);

        sorter = new TableRowSorter<TableModel>(this.jTable1.getModel());
        jTable1.setRowSorter(sorter);
        
        
        //Icon icon1 = new ImageIcon("print.png");
        //Icon icon2 = new ImageIcon("informer.png");
        Icon icon1 = new ImageIcon(getClass().getClassLoader().getResource("print.png"));
        Icon icon2 = new ImageIcon(getClass().getClassLoader().getResource("informer.png"));
        jButton1.setIcon(icon1);
        jButton2.setIcon(icon2);
        
        dialoginformer.setVisible(true);
        //jTextField7.setVisible(false);        
        //jTextField8.setVisible(false);

        jMenu2.setText("\u041e\u0442\u0447\u0435\u0442\u044b");
        jMenuItem2.setText("\u0421\u0432\u0435\u0440\u043a\u0430 \u0441 iBank2");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem2_actionPerformed(e);
            }
        });
        jButton2.setBounds(new Rectangle(1020, 5, 45, 35));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton2_actionPerformed(e);
            }
        });
        jMenuItem3.setText("\u0418\u043d\u0444\u043e\u0440\u043c\u0435\u0440");
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem3_actionPerformed(e);
            }
        });
        jLabel8.setText("\u041d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435");
        jLabel8.setBounds(new Rectangle(70, 525, 100, 15));
        jLabel8.setFont(new Font("Tahoma", 1, 12));
        jTextField9.setBounds(new Rectangle(5, 495, 60, 25));
        jTextField9.setFont(new Font("Tahoma", 0, 12));
        jLabel9.setText("\u2116 \u0437\u0430\u043f\u0438\u0441\u0438");
        jLabel9.setBounds(new Rectangle(5, 480, 65, 15));
        jLabel9.setFont(new Font("Tahoma", 1, 12));
        jLabel10.setText("\u0414\u0430\u0442\u0430 \u0437\u0430\u043f\u0438\u0441\u0438");
        jLabel10.setBounds(new Rectangle(70, 480, 85, 15));
        jLabel10.setFont(new Font("Tahoma", 1, 12));
        jTextField10.setBounds(new Rectangle(70, 495, 75, 25));
        jTextField10.setFont(new Font("Tahoma", 0, 12));
        jTextField11.setBounds(new Rectangle(150, 590, 115, 25));
        jTextField11.setFont(new Font("Tahoma", 0, 12));
        jTextField12.setBounds(new Rectangle(270, 590, 110, 25));
        jTextField12.setFont(new Font("Tahoma", 0, 12));
        jTextField13.setBounds(new Rectangle(385, 590, 110, 25));
        jTextField13.setFont(new Font("Tahoma", 0, 12));
        jLabel11.setText("\u0424\u0430\u043c\u0438\u043b\u0438\u044f");
        jLabel11.setBounds(new Rectangle(150, 575, 65, 15));
        jLabel11.setFont(new Font("Tahoma", 1, 12));
        jLabel12.setText("\u0418\u043c\u044f");
        jLabel12.setBounds(new Rectangle(270, 575, 65, 15));
        jLabel12.setFont(new Font("Tahoma", 1, 12));
        jLabel13.setText("\u041e\u0442\u0447\u0435\u0441\u0442\u0432\u043e");
        jLabel13.setBounds(new Rectangle(385, 575, 65, 15));
        jLabel13.setFont(new Font("Tahoma", 1, 12));
        jTextField14.setBounds(new Rectangle(5, 590, 140, 25));
        jTextField14.setFont(new Font("Tahoma", 0, 12));
        jTextField14.setAutoscrolls(false);
        jTextField14.setCaret(new DefaultCaret());
        jLabel14.setText("\u0414\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u044c");
        jLabel14.setBounds(new Rectangle(5, 575, 85, 15));
        jLabel14.setFont(new Font("Tahoma", 1, 12));
        jTextField15.setBounds(new Rectangle(770, 495, 75, 25));
        jTextField15.setFont(new Font("Tahoma", 0, 12));
        jTextField16.setBounds(new Rectangle(855, 495, 75, 25));
        jTextField16.setFont(new Font("Tahoma", 0, 12));
        jTextField17.setBounds(new Rectangle(940, 495, 75, 25));
        jTextField17.setFont(new Font("Tahoma", 0, 12));
        jLabel15.setText("\u0410\u043a\u0442\u0438\u0432\u0435\u043d \u0441");
        jLabel15.setBounds(new Rectangle(770, 480, 70, 15));
        jLabel15.setFont(new Font("Tahoma", 1, 12));
        jLabel16.setText("\u043f\u043e");
        jLabel16.setBounds(new Rectangle(855, 480, 35, 15));
        jLabel16.setFont(new Font("Tahoma", 1, 12));
        jLabel17.setText("\u0423\u043d\u0438\u0447\u0442\u043e\u0436\u0435\u043d");
        jLabel17.setBounds(new Rectangle(940, 480, 75, 15));
        jLabel17.setFont(new Font("Tahoma", 1, 12));
        jMenu3.setText("\u0421\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a\u0438");
        jMenuItem4.setText("\u0416\u0443\u0440\u043d\u0430\u043b\u044b \u041c\u041d\u0418/\u0421\u041a\u0417\u0418");
        jMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem4_actionPerformed(e);
            }
        });
        jLabel18.setText("\u0421\u0412\u042f\u0417\u042c");
        jLabel18.setBounds(new Rectangle(970, 525, 45, 15));
        jLabel18.setFont(new Font("Tahoma", 1, 12));
        jLabel19.setText("\u0421\u0412\u042f\u0417\u042c");
        jLabel19.setBounds(new Rectangle(745, 525, 45, 15));
        jLabel19.setFont(new Font("Tahoma", 1, 12));
        jTextField18.setBounds(new Rectangle(795, 540, 45, 25));
        jTextField18.setBackground(Color.lightGray);
        jTextField18.setHorizontalAlignment(JTextField.CENTER);
        jTextField19.setBounds(new Rectangle(1020, 495, 45, 25));
        jTextField19.setBackground(Color.lightGray);
        jTextField19.setHorizontalAlignment(JTextField.CENTER);
        jLabel111.setText("\u041c\u041d\u0418");
        jLabel111.setBounds(new Rectangle(805, 525, 35, 15));
        jLabel111.setFont(new Font("Tahoma", 1, 12));
        jLabel112.setText("\u0421\u041a\u0417\u0418");
        jLabel112.setBounds(new Rectangle(1020, 480, 45, 15));
        jLabel112.setFont(new Font("Tahoma", 1, 12));
        jTextField110.setBounds(new Rectangle(1020, 540, 45, 25));
        jTextField110.setBackground(Color.lightGray);
        jTextField110.setHorizontalAlignment(JTextField.CENTER);
        jLabel113.setText("\u041c\u041d\u0418");
        jLabel113.setBounds(new Rectangle(1030, 525, 35, 15));
        jLabel113.setFont(new Font("Tahoma", 1, 12));
        jComboBox1.setBounds(new Rectangle(710, 10, 60, 25));
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox1_actionPerformed(e);
            }
        });
        jTextField20.setBounds(new Rectangle(220, 495, 340, 25));
        jTextField20.setFont(new Font("Tahoma", 0, 12));
        jLabel20.setText("\u0422\u0438\u043f \u0421\u041a\u0417\u0418 (\u0438\u0437 \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u0430):");
        jLabel20.setBounds(new Rectangle(220, 480, 185, 15));
        jLabel20.setFont(new Font("Tahoma", 1, 12));
        jMenuItem5.setText("\u0411\u0438\u0431\u043b\u0438\u043e\u0442\u0435\u043a\u0438 \u0421\u041a\u0417\u0418");
        jMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem5_actionPerformed(e);
            }
        });
        jMenuItem6.setText("\u041d\u043e\u0432\u044b\u0435 \u043a\u043b\u044e\u0447\u0438");
        jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jMenuItem6_actionPerformed(e);
            }
        });
        jTable1.setFont(new Font("Tahoma", 0, 12));
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event){
                DefaultCaret caret = (DefaultCaret)jTextField14.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
                caret = (DefaultCaret)jTextField2.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
                caret = (DefaultCaret)jTextField11.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
                caret = (DefaultCaret)jTextField12.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
                caret = (DefaultCaret)jTextField13.getCaret();
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

                 //System.out.println("event...");
                if(jTable1.getSelectedRow() != -1){                             
                 jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString()); 
                 jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString()); 
                 jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());                  
                 
                 ///
                 
                 jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString()); 
                 jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 16).toString()); 
                  
                 //ÈÄ æóðíàëà è äàòà
                 jTextField9.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()); 
                 jTextField10.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()); 
                 //Äîëæíîñòü
                 jTextField14.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString());                  
                 
                 //ÔÈÎ
                 jTextField11.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString()); 
                 jTextField12.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString()); 
                 jTextField13.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString()); 
                 //Ñðîêè ñåðòèôèêàòà
                 jTextField15.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 43+3).toString()); 
                 jTextField16.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 44+3).toString()); 
                 jTextField18.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 35).toString()); 
                 jTextField19.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 50).toString()); 
                 jTextField110.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 36).toString());
                    try {
                        jTextField20.setText(this.GetCertSKZI(jTable1.getValueAt(jTable1.getSelectedRow(),
                                                                                 6).toString()));
                    } catch (SQLException e) {
                        System.out.println(e);
                    }


                    if(jTable1.getValueAt(jTable1.getSelectedRow(), 48+3)==null){
                      jTextField17.setVisible(false);
                      jLabel17.setVisible(false);
                  }else{
                      jTextField17.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 48+3).toString()); 
                      jTextField17.setVisible(true);
                      jTextField17.setBackground(Color.RED);                      
                      jLabel17.setVisible(true);
                  }                 
                 
                 if(jTable1.getValueAt(jTable1.getSelectedRow(), 24).toString().compareTo("0")==0){
                     jTextField7.setText("");
                     jTextField7.setVisible(false);
                     
                  }
                 else {
                       jTextField7.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 24).toString());
                        jTextField7.setVisible(true);                        
                        try {
                            jTextField5.setText(GetDevID(jTable1.getValueAt(jTable1.getSelectedRow(), 24).toString(),1));
                        } catch (SQLException e) {
                        }
                    }
                 if(jTable1.getValueAt(jTable1.getSelectedRow(), 28).toString().compareTo("0")==0){
                     jTextField8.setText("");
                         jTextField8.setVisible(false);
                     }
                 else {
                       jTextField8.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 28).toString());
                          jTextField8.setVisible(true);                          
                          try {
                              jTextField6.setText(GetDevID(jTable1.getValueAt(jTable1.getSelectedRow(), 28).toString(),2));
                          } catch (SQLException e) {
                              System.out.println(e);
                          }
                      }
                 
                 icusnum = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
                 ikeynum = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
                 full_name=jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
                 
              }
                }
            

            private String GetCertSKZI(String id) throws SQLException {
                /*Îïðåäåëÿåì òèï ÑÊÇÈ êëèåíòà*/
                     String res="";                            
                     
                     String query="SELECT SUBSTR(REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1'),0,10) v01 \n" + 
                     "            ,REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<PROVIDER>(.*)</PROVIDER>.*$', '\\1') v02 \n" + 
                     "            ,case when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%ST19NR66%' \n" + 
                     "                  then '\"ÔÎÐÎÑ. Èñïîëíåíèå ¹1\" / \"Êðèïòîìîäóëü C\"'\n" + 
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%ST23YL18-002%' \n" + 
                     "                  then 'Êðèïòîìîäóëü Ñ23'\n" + 
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%ST23YL18-004%' \n" + 
                     "                  then 'ÑÊÇÈ \"ÔÎÐÎÑ. Èñïîëíåíèå ¹2\" / \"Êðèïòîìîäóëü C23\"' \n" + 
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<PROVIDER>(.*)</PROVIDER>.*$', '\\1') like '%ccom33%' \n" + 
                     "                  then 'Êðèïòî-Êîì 3.3' " + 
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%MSKEY_K-201%' \n" + 
                     "                  then 'ÑÊÇÈ \"MS_KEY K\" Èñï.5.1.1' " +                      
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%MSKEY_K-202%' \n" + 
                     "                  then 'ÑÊÇÈ \"MS_KEY K\" - \"ÀÍÃÀÐÀ\" Èñï.8.1.1' " +                      
                     "                  when REGEXP_REPLACE(XXI.LongToVarchar(k.id_key), '^.*<TOKEN_CHIP_TYPE>(.*)</TOKEN_CHIP_TYPE>.*$', '\\1') like '%RUTOKEN_EC%'  \n" +
                     "                  then 'ÑÊÇÈ Ðóòîêåí ÝÖÏ 2.0' \n" +
                     "            end v03 " +                      
                     "            FROM ibank2.keys@ibank2lnk k\n" + 
                     "            where k.id_key like '"+id+"'";
                     
                     Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
                     Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery(query);
                     
                     while (rs.next()) 
                       {
                         res=rs.getString("v03");
                       }
                     
                     st.close();
                     con.close(); 
                     con = null;
                     FrameLogon.mainpool.Close();
                     //System.out.println(res);

                    return res;
                 }
            }
        );

        jTextField3.setToolTipText("Ïîèñê â òàáëèöå ïî êëþ÷åâîìó ñëîâó");
        jTextField3.setFont(new Font("Tahoma", 0, 13));
        jTextField3.addActionListener(new ActionListener(){                
                public void actionPerformed(ActionEvent e) {
             String text = jTextField3.getText().toUpperCase();
                     if (text.length() == 0) {                      
                       sorter.setRowFilter(null);
                     } else {
                       sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));                       
                     }                    
                }});
        this.jLabel5.setText(Integer.toString(jTable1.getRowCount()));
        FillJrnCombo();
    }

    void fileExit_ActionPerformed(ActionEvent e) {        
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, new Frame1_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
    }
    

    /*Âçÿòü èç òàáëèöû ID óñòðîéñòâ USB/OTP*/ 
     //type = 1 - íýê, 2 - otp
     public String GetDevID(String id, int type) throws SQLException {        
         String res="";        
         
         String query="select ctknid v01,ccnfrmid v02 from xxi.key_info where ikeynum='"+id+"'";
         
         Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(query);
         
         while (rs.next()) 
           {
             if(type==1){res=rs.getString("v01");}
             if(type==2){res=rs.getString("v02");}
           }
         
         st.close();
         con.close(); 
         con = null;
         FrameLogon.mainpool.Close();              
        return res;
     }
         
    
         


    
    /*ÌÅÍÞ - ÎÁÐÀÁÎÒÊÀ - ÄÎÁÀÂÈÒÜ*/
    private void menuDataInsert_actionPerformed(ActionEvent e) {
        dialogInsert dialogInsert1 = new dialogInsert(this,"",true);
        dialogInsert1.setVisible(true); 
        ClearAndRefillTable();

    }
    


/*ÌÅÍÞ - ÎÁÐÀÁÎÒÊÀ - ÓÄÀËÈÒÜ*/
    private void menuDataDelete_actionPerformed(ActionEvent e) {
        if (icusnum == -1) {
            JOptionPane.showMessageDialog(this, "Íå âûáðàí êëèåíò äëÿ óêàçàííîãî äåéñòâèÿ.", "Ïðåäóïðåæäåíèå!", JOptionPane.WARNING_MESSAGE);
        }else{
            if (this.jCheckBox1.isSelected()){
                JOptionPane.showMessageDialog(this, "Ñåðòèôèêàò óæå áûë óíè÷òîæåí.", "Îøèáêà!", JOptionPane.ERROR_MESSAGE);
            }else{
                DialogDeleteRecord dialogdelrecord1 = new DialogDeleteRecord(this,"",true,icusnum,ikeynum,full_name);
                dialogdelrecord1.setVisible(true);
                ClearAndRefillTable();

            }           
        }       
    }


    public void refilltable(JTable table) throws SQLException {
        String datequerypart_active="and (i.dregdate >= to_date('01.01.'||'"+this.filteryear+"','DD.MM.RRRR') and i.dregdate <= to_date('31.12.'||'"+this.filteryear+"','DD.MM.RRRR'))";
        String datequerypart_wiped="and (i.dregdate >= to_date('01.01.'||'"+this.filteryear+"','DD.MM.RRRR') and i.dregdate <= to_date('31.12.'||'"+this.filteryear+"','DD.MM.RRRR')) ";
        
        Connection con = FrameLogon.mainpool.OpenConnection();  //.gconn; //DriverManager.getConnection(get_dbconndata(1), get_dbconndata(2), get_dbconndata(3));
        
        if (this.filteryear.compareTo("ÂÑÅ")==0) { 
            datequerypart_active="";
            datequerypart_wiped="";
        }
        
        Statement st = con.createStatement();        
        if (this.jCheckBox1.isSelected()){
            ResultSet rs = st.executeQuery("select  " +             
            "IKEYNUM " + 
            ",INPP " + 
            ",to_char(i.DREGDATE,'RRRR.MM.DD') " + 
            ",CRGEVENT " + 
            ",ICLICUSID " + 
            ",upper(CCLINAME) " + 
            ",CSGNID " + 
            ",IFACECUSID " + 
            ",upper(CFACENAME1) " + 
            ",upper(CFACENAME2) " + 
            ",upper(CFACENAME3) " + 
            ",upper(CFACEPOST) " + 
            ",upper(CTKNTYPE) " + 
            ",nvl(CTKNID,'NULL') " + 
            ",ITKNJNUM " + 
            ",CCNFRMTYPE " + 
            ",nvl(CCNFRMID,'NULL') " + 
            ",ICNFRMJNUM " + 
            ",ICNFRMSUM " + 
            ",IDISTNUM " + 
            ",to_char(DDIST,'RRRR.MM.DD') " + 
            ",IPROTONUM " + 
            ",IDSTTKNNUM " + 
            ",to_char(DDSTTNKD,'RRRR.MM.DD') " + 
            ",nvl(ILKEYNUM,0) " + 
            ",ILDSTTKNNUM " + 
            ",to_char(DLDSTTNKD,'RRRR.MM.DD') " + 
            ",ILTKNJNUM " + 
            ",nvl(ILKEYNUMOTP,0) " + 
            ",ILDACTOTP " + 
            ",DLDACTOTP  " + 
            ",IDSTSGNNUM " + 
            ",to_char(DDSTSGND,'RRRR.MM.DD') " + 
            ",IPRODNUM "+             
            ",to_char(DPRODD,'RRRR.MM.DD') " + 
            ",nvl(IJRNKI,0) " +
            ",nvl(IJRNKIOTP,0) "+
            ",nvl(IJRNKIDIST,0) "+
            ",i.IWIPENUM " + 
            ",to_char(i.DWIPED,'RRRR.MM.DD') " + 
            ",i.CCOMMENT " + 
            ",c.ICRTKEYNUM " + 
            ",c.ICEYNUM " + 
            ",c.CKEYID " + 
            ",c.CSKZITYPE " + 
            ",to_char(c.DREGDATE,'RRRR.MM.DD') " + 
            ",to_char(c.DSTARTD,'RRRR.MM.DD') " + 
            ",to_char(c.DENDD,'RRRR.MM.DD') " + 
            ",c.CSIGNGRP " +             
            ",c.ISTATE " + 
            ",nvl(c.IJRNKC,0) " +
            ",c.IWIPENUM " + 
            ",to_char(c.DWIPED,'RRRR.MM.DD')" + 
            ",c.CCOMMENT " +             
            "from xxi.key_info i, xxi.key_cert c where ikeynum=iceynum and i.dwiped is not null " +datequerypart_wiped+" order by c.DWIPED");//"select * from xxi.key_info i, xxi.key_cert c where ikeynum=iceynum and i.dwiped is not null order by ikeynum");           
            //ResultSet rs = FrameLogon.gstmt.executeQuery("select * from key_info i, key_cert c where ikeynum=iceynum and i.dwiped is not null order by ikeynum");                                   
            
            table.setModel(buildTableModel(rs));            
            rs.close();
        }else {
            ResultSet rs = st.executeQuery("select  " +             
            "IKEYNUM " + 
            ",INPP " + 
            ",to_char(i.DREGDATE,'RRRR.MM.DD') " + 
            ",CRGEVENT " + 
            ",ICLICUSID " + 
            ",upper(CCLINAME) " + 
            ",CSGNID " + 
            ",IFACECUSID " + 
            ",upper(CFACENAME1) " + 
            ",upper(CFACENAME2) " + 
            ",upper(CFACENAME3) " + 
            ",upper(CFACEPOST) " + 
            ",upper(CTKNTYPE) " + 
            ",nvl(CTKNID,'NULL') " + 
            ",ITKNJNUM " + 
            ",CCNFRMTYPE " + 
            ",nvl(CCNFRMID,'NULL') " + 
            ",ICNFRMJNUM " + 
            ",ICNFRMSUM " + 
            ",IDISTNUM " + 
            ",to_char(DDIST,'RRRR.MM.DD') " + 
            ",IPROTONUM " + 
            ",IDSTTKNNUM " + 
            ",to_char(DDSTTNKD,'RRRR.MM.DD') " + 
            ",nvl(ILKEYNUM,0) " + 
            ",ILDSTTKNNUM " + 
            ",to_char(DLDSTTNKD,'RRRR.MM.DD') " + 
            ",ILTKNJNUM " + 
            ",nvl(ILKEYNUMOTP,0) " + 
            ",ILDACTOTP " + 
            ",DLDACTOTP  " + 
            ",IDSTSGNNUM " + 
            ",to_char(DDSTSGND,'RRRR.MM.DD') " + 
            ",IPRODNUM " + 
            ",to_char(DPRODD,'RRRR.MM.DD') " + 
            ",nvl(IJRNKI,0) "+
            ",nvl(IJRNKIOTP,0) "+
            ",nvl(IJRNKIDIST,0) "+
            ",i.IWIPENUM " + 
            ",to_char(i.DWIPED,'RRRR.MM.DD') " + 
            ",i.CCOMMENT " + 
            ",c.ICRTKEYNUM " + 
            ",c.ICEYNUM " + 
            ",c.CKEYID " + 
            ",c.CSKZITYPE " + 
            ",to_char(c.DREGDATE,'RRRR.MM.DD') " + 
            ",to_char(c.DSTARTD,'RRRR.MM.DD') " + 
            ",to_char(c.DENDD,'RRRR.MM.DD') " + 
            ",c.CSIGNGRP " +             
            ",c.ISTATE " + 
            ",nvl(c.IJRNKC,0) " + 
            ",c.IWIPENUM " + 
            ",to_char(c.DWIPED,'RRRR.MM.DD')" + 
            ",c.CCOMMENT " +              
            "from xxi.key_info i, xxi.key_cert c where ikeynum=iceynum and i.dwiped is null "+datequerypart_active+" order by IKEYNUM");
            //"select * from xxi.key_info i, xxi.key_cert c where ikeynum=iceynum and i.dwiped is null order by ikeynum");
            table.setModel(buildTableModel(rs));            
            rs.close();
        }               
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
        setColumnsWidth(table);        

    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        String[] ColNames = {
                                "ID     "
                                ,"¹ Ï.Ï."
                                ,"ÄÀÒÀ ÂÛÄÀ×È"
                                ,"ÏÐÈ×ÈÍÀ"
                                ,"ID ÊËÈÅÍÒÀ"
                                ,"ÏÎËÍÎÅ ÍÀÈÌÅÍÎÂÀÍÈÅ ÏÐÅÄÏÐÈßÒÈß                                               "
                                ,"ID ÊËÞ×À ÝÏ"
                                ,"ID ÂËÀÄÅËÜÖÀ ÝÏ"
                                ,"ÔÀÌÈËÈß    "
                                ,"ÈÌß        "/*10*/
                                ,"ÎÒ×ÅÑÒÂÎ   "
                                ,"ÄÎËÆÍÎÑÒÜ  "
                                ,"ÒÈÏ ÍÎÑÈÒÅËß"
                                ,"S/N ÍÎÑÈÒÅËß"
                                ,"Ó×. ¹"
                                ,"ÒÈÏ OTP       "
                                ,"S/N OTP       "
                                ,"Ó×. ¹"
                                ,"ÑÓÌÌÀ"
                                ,"ÄÈÑÒÐ."/*20*/
                                ,"ÄÀÒÀ ÂÛÄÀ×È"
                                ,"ÏÐÎÒÎÊÎË ¹"
                                ,"¹ ÀÊÒÀ ÍÝÊ"
                                ,"ÄÀÒÀ ÀÊÒÀ ÍÝÊ"
                                ,"LINK:ID ÍÝÊ"
                                ,"LINK:¹ ÀÊÒÀ ÍÝÊ"
                                ,"LINK:ÄÀÒÀ ÀÊÒÀ ÍÝÊ"
                                ,"LINK:Ó×. ¹ ÍÝÊ"
                                ,"LINK:ID OTP"
                                ,"LINK:¹ ÀÊÒÀ OTP"/*30*/
                                ,"LINK:ÄÀÒÀ ÀÊÒÀ OTP"
                                ,"ÀÊÒ Ï/Ï ÝÏ"
                                ,"ÄÀÒÀ ÀÊÒÀ"
                                ,"ÀÊÒ ÂÂÎÄÀ"
                                ,"ÄÀÒÀ ÀÊÒÀ"
                                ,"USB ÏÎ ÆÓÐÍ."
                                ,"OTP ÏÎ ÆÓÐÍ."
                                ,"ÄÈÑÒÐ. ÏÎ ÆÓÐÍ."
                                ,"ÀÊÒ ÓÍÈ×Ò."
                                ,"ÄÀÒÀ ÀÊÒÀ"/*40*/
                                ,"ÊÎÌÌÅÍÒÀÐÈÉ"
                                ,"WID"
                                ,"ID"
                                ,"ID ÊËÞ×À ÝÏ"
                                ,"ÒÈÏ ÑÊÇÈ                             "
                                ,"ÄÀÒÀ ÐÅÃÈÑÒÐÀÖÈÈ"
                                ,"ÄÀÒÀ ÍÀ×ÀËÀ ÄÅÉÑÒÂÈß"
                                ,"ÄÀÒÀ ÎÊÎÍ×. ÄÅÉÑÒÂÈß"
                                ,"ÃÐÓÏÏÀ ÏÎÄÏÈÑÈ"
                                ,"ÑÒÀÒÓÑ ÊËÞ×À" /*50*/
                                ,"ÆÓÐÍÀË ÑÅÐÒÈÔÈÊÀÒÀ"
                                ,"ÀÊÒ ÓÍÈ×Ò."
                                ,"ÄÀÒÀ ÀÊÒÀ"
                                ,"ÊÎÌÌÅÍÒÀÐÈÉ           "                                
                                };
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 0; column <= columnCount-1; column++) {
            //columnNames.add(metaData.getColumnName(column));
            columnNames.add(ColNames[column]);
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        
        TableModel resmodel = new DefaultTableModel(data, columnNames) {
                          
              //  Returning the Class of each column will allow different renderers and editors to be used based on Class       
                public Class getColumnClass(int column)
                {
                    for (int row = 0; row < getRowCount(); row++)
                    {
                     Object o = getValueAt(row, column);
                     if (o != null) return o.getClass();
                    }
                     return Object.class;
                    }
            
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                 return false;
                }
            };
        
        return (DefaultTableModel) resmodel;
    }
    
    
    private void ClearAndRefillTable(){
        /*Î÷èñòêà òàáëèöû*/
        DefaultTableModel model = (DefaultTableModel)this.jTable1.getModel();
        while (model.getRowCount() > 0){
                for (int i = 0; i < model.getRowCount(); ++i){
                    model.removeRow(i);
                }
            };
        /**/
        try {
            this.refilltable(jTable1);            
        } catch (SQLException f) {
        }
        sorter = new TableRowSorter<TableModel>(this.jTable1.getModel());
        jTable1.setRowSorter(sorter);         
    }


    /*Ôîðìàò òàáëèöû ïî øèðèíå íàçâàíèÿ ñòîëáöà*/
        public void setColumnsWidth(JTable table) {
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JTableHeader th = table.getTableHeader();
            for (int i = 0; i < table.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                int prefWidth = 
                    Math.round(
                        (float) th.getFontMetrics(
                            th.getFont()).getStringBounds(th.getTable().getColumnName(i),
                            th.getGraphics()
                        ).getWidth()
                    );
                column.setPreferredWidth(prefWidth + 10);
            }
        }

    /*Çàïîëíÿåì Êîìáîáîêñ òèï æóðíàëà*/
    public void FillJrnCombo() throws SQLException {        
        String query="select distinct to_char(k.dregdate,'RRRR') v01 from xxi.key_info k,xxi.key_cert c where ikeynum=iceynum order by 1 desc";
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        jComboBox1.removeAllItems(); //÷èñòèì áîêñ        
        
        while (rs.next()) 
          {
             jComboBox1.addItem(rs.getString("v01"));
          }
                
        
        this.filteryear=this.jComboBox1.getSelectedItem().toString();
        jComboBox1.addItem("ÂÑÅ");
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();     
    }
    
     private void jCheckBox1_actionPerformed(ActionEvent e) {                       
        ClearAndRefillTable();
        if (this.jCheckBox1.isSelected()){
            this.jLabel4.setText("Óíè÷òîæåííûå êëþ÷è êëèåíòîâ");            
            this.jLabel4.setForeground(Color.RED);
            icusnum=-1;
        }else{
            this.jLabel4.setText("Äåéñòâóþùèå êëþ÷è êëèåíòîâ");
            this.jLabel4.setForeground(Color.BLUE);
            icusnum=-1;
        }
        this.jLabel5.setText(Integer.toString(jTable1.getRowCount()));

    }

/*Ñðåäñòâà çàùèòû - Âûäàòü*/
    private void jMenuItem1_actionPerformed(ActionEvent e) {
                DialogSZ dialogsz = new DialogSZ(this,"",true);
                dialogsz.setVisible(true);                            
    }

    private int jButton1_actionPerformed(ActionEvent e) {                
        if (icusnum == -1) {
            JOptionPane.showMessageDialog(this, "Íå âûáðàíà çàïèñü äëÿ ïå÷àòè.", "Ïðåäóïðåæäåíèå!", JOptionPane.WARNING_MESSAGE);
            return 1;
        }       
        int dialogResult = JOptionPane.showConfirmDialog (null, "Ñôîðìèðîâàòü îò÷åò äëÿ óêàçàííîé çàïèñè?","Âîïðîñ?",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.NO_OPTION){            
            return 1;
        }        
        String cred=FrameLogon.dbuname+"/"+FrameLogon.dbsword+"@"+FrameLogon.orasid;        
        String proc1=FrameLogon.dev6ipath+"\\DEV6I\\BIN\\ifrun60.exe";
        String proc2=FrameLogon.formspath+"\\KERNEL\\ap_main.fmx";
        String proc3="userid="+cred;
        String proc4="REPORT_TYPE_ID=1000001";
        String proc5="report_id=9990000104";
        String proc6="p4=\""+jTable1.getValueAt(jTable1.getSelectedRow(),4).toString()+"\"";
        String proc7="report_generate_type=\"D\"";
        String proc8="report_silent=\"N\"";
        
        if (jCheckBox1.isSelected()==false){
            proc5="report_id=9990000103";            
        }
        
        try {
            Process p= new ProcessBuilder(proc1,proc2,proc3,proc4,proc5,proc6,proc7,proc8).start();
        } catch (IOException f) {
            f.printStackTrace();
        } 
        return 0;
    }

    public String Get_CurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");  //"yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curdate = sdf.format(date);        
        return curdate;
    }
    
    
    private void jMenuItem2_actionPerformed(ActionEvent e) {
        int dialogResult = JOptionPane.showConfirmDialog (null, "Ñôîðìèðîâàòü îò÷åò ñâåðêè?","Âîïðîñ?",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){            
            String cred=FrameLogon.dbuname+"/"+FrameLogon.dbsword+"@"+FrameLogon.orasid;        
            String proc1=FrameLogon.dev6ipath+"\\DEV6I\\BIN\\ifrun60.exe";
            String proc2=FrameLogon.formspath+"\\KERNEL\\ap_main.fmx";
            String proc3="userid="+cred;
            String proc4="REPORT_TYPE_ID=200998";
            String proc5="report_id=9990000236";
            String proc6="";
            String proc7="report_generate_type=\"D\"";
            String proc8="report_silent=\"N\"";        
            
            try {
                Process p= new ProcessBuilder(proc1,proc2,proc3,proc4,proc5,proc6,proc7,proc8).start();
            } catch (IOException f) {
                f.printStackTrace();
            }                     
        }        
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        if (dialoginformer.isVisible()){
            dialoginformer.setVisible(false);
        }else{
            try {
                dialoginformer.initTables();
            } catch (SQLException f) {
            }
            dialoginformer.setVisible(true);
            
        }
    }

    private void jMenuItem3_actionPerformed(ActionEvent e) {
        if (dialoginformer.isVisible()){
            dialoginformer.setVisible(false);
        }else{
            dialoginformer.setVisible(true);
        }
    }

    /*ÂÛÁÐÀÍ ÏÓÍÊÒ ÌÅÍÞ ÑÏÐÀÂÎ×ÍÈÊÈ - ÆÓÐÍÀËÛ ÌÍÈ/ÑÊÇÈ*/
    private void jMenuItem4_actionPerformed(ActionEvent e) {
        DialogJrn dialogjrn = new DialogJrn(this,true);
        dialogjrn.setVisible(true);  
    }

    /*Ñîáûòèÿ êîìáîáîêñà - âûáîð ãîäà äëÿ ôèëüòðàöèè*/
    private void jComboBox1_actionPerformed(ActionEvent e) {
        //åñëè âûáðàí ôèëüòð "ÂÑÅ" òî âûâîäèì âñå äàííûå       
        this.filteryear=this.jComboBox1.getSelectedItem().toString();
        ClearAndRefillTable();
        this.jLabel5.setText(Integer.toString(jTable1.getRowCount()));
    }

    /*Áèáëèîòåêè ÑÊÇÈ (Ìåíþ)*/
    private void jMenuItem5_actionPerformed(ActionEvent e) {
        DialogLibSKZI dialoglibskzi = new DialogLibSKZI(this,true);
        dialoglibskzi.setVisible(true);
    }

    private void jMenuItem6_actionPerformed(ActionEvent e) {
        DialogNewKeys dialognewkeys = new DialogNewKeys(this,true);
        dialognewkeys.setVisible(true);
    }
}
