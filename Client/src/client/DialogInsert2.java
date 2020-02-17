package client;

import com.jgoodies.forms.layout.FormLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.SystemColor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.text.DateFormatter;

import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class DialogInsert2 extends JDialog {    
    
    /*Переменные для получения данных из формы DialogInsert3s*/
    public static int linkdata  = 0; //Флажок управляется формой DialogInsert3s для случая линковки выданного оборудования на другю строку журнала
                                     //случай когда генерация была выполнена на существующее оборудования т.е. клиент уже получал ранее оборудование (ОТП, USB, Дистрибутив)
    
    public static int linkdataotp  = 0; //Флажок управляется формой DialogInsert3s для случая линковки выданного оборудования на другю строку журнала
                                     //случай когда генерация была выполнена на существующее оборудования т.е. клиент уже получал ранее оборудование (ОТП)
                                     
    
    public static String gikeynum=new String();
    public static String gregdate=new String();
    public static String gcliname=new String();
    public static String gpost=new String();
    public static String gusbtype=new String();
    public static String gusbid=new String();
    public static String gusbnum=new String();
    public static String gusbactnum=new String();
    public static String gusbactdate=new String();
    public static String gotptype=new String();
    public static String gotpid=new String();
    public static String gotpnum=new String();
    public static String gotpsum=new String();
    public static String gdistnum=new String();
    public static String gdistdate=new String();
    /*************************************************************/  
    
    private boolean list2changed=false;
    private boolean combobox3changed=false;
    private int icusnum;
    private String short_name;
    private String full_name;
    
    private String sql_idistnum;
    private String sql_iprotonum;
    private String sql_idsttknnum;
    private String sql_itknjnum;
    private String sql_idstsgnnum;
    private String sql_iprodnum;
    
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel jPanel4 = new JPanel();
    private JPanel jPanel5 = new JPanel();
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private FormLayout formLayout1 = new FormLayout("f:750px:n, f:15px:g" , "c:70px:n, c:15px:g" );
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private XYLayout xYLayout1 = new XYLayout();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JTextField jTextField5 = new JTextField();
    private XYLayout xYLayout2 = new XYLayout();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JTextField jTextField6 = new JTextField();
    private JTextField jTextField7 = new JTextField();
    private XYLayout xYLayout3 = new XYLayout();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JTextField jTextField8 = new JTextField();
    private JTextField jTextField9 = new JTextField();
    private XYLayout xYLayout4 = new XYLayout();
    private JLabel jLabel10 = new JLabel();
    private JTextField jTextField10 = new JTextField();
    private JTextField jTextField11 = new JTextField();
    private JLabel jLabel11 = new JLabel();
    private JTextField jTextField12 = new JTextField();
    private JTextField jTextField13 = new JTextField();
    private JLabel jLabel12 = new JLabel();
    private JLabel jLabel13 = new JLabel();
    private XYLayout xYLayout5 = new XYLayout();
    private JPanel jPanel6 = new JPanel();
    private XYLayout xYLayout6 = new XYLayout();
    private JLabel jLabel14 = new JLabel();
    private JTextField jTextField14 = new JTextField();
    private JLabel jLabel15 = new JLabel();
    private JTextField jTextField15 = new JTextField();
    private JLabel jLabel16 = new JLabel();
    private JTextField jTextField16 = new JTextField();
    private JLabel jLabel17 = new JLabel();
    private JTextField jTextField17 = new JTextField();
    private JLabel jLabel18 = new JLabel();
    private JTextField jTextField18 = new JTextField();
    private JLabel jLabel19 = new JLabel();
    private JLabel jLabel20 = new JLabel();
    private JLabel jLabel21 = new JLabel();
    private JLabel jLabel22 = new JLabel();
    private JLabel jLabel23 = new JLabel();
    private JLabel jLabel110 = new JLabel();
    private JTextField jTextField110 = new JTextField();
    private JLabel jLabel24 = new JLabel();
    private JTextField jTextField24 = new JTextField();
    private JLabel jLabel111 = new JLabel();
    private JTextField jTextField25 = new JTextField();
    private JLabel jLabel112 = new JLabel();
    private JTextField jTextField26 = new JTextField();
    private JLabel jLabel113 = new JLabel();
    private JTextField jTextField27 = new JTextField();
    private JTextField jTextField28 = new JTextField();
    private JLabel jLabel114 = new JLabel();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JList jList1 = new JList();
    private JLabel jLabel25 = new JLabel();
    private JLabel jLabel27 = new JLabel();
    private JTextField jTextField29 = new JTextField();
    private JPanel jPanel7 = new JPanel();
    private XYLayout xYLayout7 = new XYLayout();
    private JLabel jLabel26 = new JLabel();  
    private JList jList2 = new JList();
    private JLabel jLabel115 = new JLabel();
    private JTextField jTextField111 = new JTextField();
    private JTextField jTextField112 = new JTextField();
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");        
    private JFormattedTextField jFormattedTextField1 =
        new JFormattedTextField(df);
    private JFormattedTextField jFormattedTextField2 = 
        new JFormattedTextField(df);
    private JFormattedTextField jFormattedTextField3 = new JFormattedTextField(df);
    private JCheckBox jCheckBox1 = new JCheckBox();
    private JCheckBox jCheckBox2 = new JCheckBox();
    private JComboBox jComboBox1 = new JComboBox();
    private JComboBox jComboBox2 = new JComboBox();
    private JComboBox jComboBox3 = new JComboBox();
    private JPanel jPanel8 = new JPanel();
    private JLabel jLabel28 = new JLabel();
    private GridLayout gridLayout1 = new GridLayout();
    private JCheckBox jCheckBox3 = new JCheckBox();
    private JLabel jLabel29 = new JLabel();
    private JLabel jLabel210 = new JLabel();
    private JComboBox jComboBox4 = new JComboBox();
    private JComboBox jComboBox5 = new JComboBox();
    private JLabel jLabel211 = new JLabel();
    private JComboBox jComboBox6 = new JComboBox();


    /*  public DialogInsert2(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

   public DialogInsert2(dialogInsert parent, String title, boolean modal, int icusnum, String short_name, String full_name) {
        super(parent, title, modal);
        //System.out.println("DialogInsert2 - icusnum:"+Integer.toString(icusnum));
        this.icusnum=icusnum;
        this.short_name=short_name;
        this.full_name=full_name;
        linkdata=0;
        linkdataotp=0;
        //System.out.println("DialogInsert2 - in_icusnum:"+Integer.toString(this.icusnum));
        
        try {
            this.setLocationRelativeTo(parent); 
            fill_sql_JList(jList1);
            jList1.setSelectedIndex(0);
            if (jList1.getSelectedIndex()>=0){
                fill_ownerdata(jList1.getSelectedValue().toString());
            }            
            FillOtpCombo();
            FillUsbCombo();
            this.setResizable(false);
        } catch (SQLException e) {
        }
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(735, 557));
        this.getContentPane().setLayout( null );
        this.setModal(true);        
        this.setTitle("Регистрация сведений о сертификате ("+Integer.toString(this.icusnum)+" - "+this.short_name+")");
        this.setBackground(java.awt.Color.lightGray);
        jPanel1.setBounds(new Rectangle(0, 120, 230, 80));
        jPanel1.setBorder(BorderFactory.createTitledBorder("Установочный дистрибутив"));
        jPanel1.setLayout(xYLayout2);
        jPanel1.setBackground(new java.awt.Color(165, 198, 255));
        jPanel2.setBounds(new Rectangle(0, 200, 230, 80));
        jPanel2.setBorder(BorderFactory.createTitledBorder("Заключение о допуске"));
        jPanel2.setLayout(xYLayout3);
        jPanel2.setBackground(new Color(165, 198, 255));
        jPanel3.setBounds(new Rectangle(0, 280, 230, 220));
        jPanel3.setBorder(BorderFactory.createTitledBorder("USB-токен / НЭК (Носитель)"));
        jPanel3.setLayout(xYLayout4);
        jPanel3.setBackground(new java.awt.Color(165, 198, 255));
        jPanel4.setBounds(new Rectangle(230, 120, 270, 380));
        jPanel4.setBorder(BorderFactory.createTitledBorder("Ключ электронной подписи"));
        jPanel4.setLayout(xYLayout5);
        jPanel4.setBackground(new java.awt.Color(165, 198, 255));
        jPanel5.setBounds(new Rectangle(0, 0, 570, 120));
        jPanel5.setBorder(BorderFactory.createTitledBorder("Владелец сертификата"));
        jPanel5.setLayout(xYLayout1);
        jPanel5.setBackground(new Color(165, 198, 255));
        jLabel1.setText("Фамилия");
        jLabel2.setText("Имя");
        jLabel3.setText("Отчество");
        jLabel4.setText("Должность");
        jLabel5.setText("Документ");
        jTextField1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField1.setEditable(false);
        jTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //jTextField2.setEditable(false);
        jTextField3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //jTextField3.setEditable(false);
        jTextField4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //jTextField4.setEditable(false);
        jTextField5.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField5.setEditable(false);
        jLabel6.setText("Учетный номер:");
        jLabel7.setText("Дата выдачи:");
        jTextField6.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField7.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel8.setText("Дата выдачи:");
        jLabel9.setText("Номер:");
        jTextField8.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField9.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel10.setText("Заводской номер:");
        jTextField10.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField11.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel11.setText("Дата выдачи:");
        jTextField12.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField13.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel12.setText("№ Акта п/п:");
        jLabel13.setText("Дата акта п/п:");
        jPanel6.setBounds(new Rectangle(500, 120, 230, 215));
        jPanel6.setLayout(xYLayout6);
        jPanel6.setBorder(BorderFactory.createTitledBorder("OTP/SMS-токен"));
        jPanel6.setBackground(new java.awt.Color(165, 198, 255));
        jLabel14.setText("Заводской номер:");
        jTextField14.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel15.setText("Модель:");
        jTextField15.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField15.setText("VASCO Digipass Go3");
        jTextField15.setToolTipText("Модель OTP-токена");
        jTextField15.setEditable(false);
        jLabel16.setText("Дата выдачи:");
        jTextField16.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel17.setText("№ Акта п/п:");
        jTextField17.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel18.setText("Дата акта п/п:");
        jTextField18.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel19.setText("Сумма подтв.");
        jLabel20.setText("СКЗИ:");
        jLabel21.setText("Дата регистрации:");
        jLabel22.setText("Дата начала действия:");
        jLabel23.setText("Дата окончания действия:");
        jLabel110.setText("Учетный номер:");
        jTextField110.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel24.setText("Группа подписи:");
        jTextField24.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField24.setText("1");
        jLabel111.setText("№ Акта п/п сертификата:");
        jTextField25.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel112.setText("Дата акта п/п сертификата:");
        jTextField26.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel113.setText("№ Акта вып. работ:");
        jTextField27.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField28.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel114.setText("Дата акта вып. работ:");
        jButton1.setText("Регистрация");
        jButton1.setBounds(new Rectangle(520, 475, 100, 25));
        jButton1.setActionCommand("Регистрация");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Отмена");
        jButton2.setBounds(new Rectangle(650, 475, 75, 25));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jLabel25.setText("Сотрудинки клиента:");
        jLabel27.setText("ID ключа ЭП:");
        jTextField29.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jPanel7.setBounds(new Rectangle(570, 0, 160, 120));
        jPanel7.setLayout(xYLayout7);
        jPanel7.setBorder(BorderFactory.createTitledBorder("Доп. сведения"));
        jPanel7.setBackground(new Color(165, 198, 255));
        jLabel26.setText("Причина регистрации:");
        jList2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                jList2_valueChanged(e);
            }
        });
        jLabel115.setText("Тип устройства:");
        jTextField111.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField111.setText("USB-токен");
        jTextField111.setEditable(false);
        jTextField112.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField112.setText("100000");
        jTextField112.setHorizontalAlignment(JTextField.RIGHT);
        jFormattedTextField1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jFormattedTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jFormattedTextField3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jFormattedTextField3.setEditable(false);
        jCheckBox1.setBounds(new Rectangle(505, 335, 195, 25));
        jCheckBox1.setText("\u041f\u041e/USB/OTP \u0432\u044b\u0434\u0430\u043d\u044b \u0440\u0430\u043d\u0435\u0435");
        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox1_actionPerformed(e);
            }
        });
        jCheckBox2.setText("OTP \u0432\u044b\u0434\u0430\u043d \u0440\u0430\u043d\u0435\u0435");
        jCheckBox2.setBounds(new Rectangle(505, 360, 115, 20));
        jCheckBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jCheckBox2_actionPerformed(e);
            }
        });
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox1_actionPerformed(e);
            }
        });
        jComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox2_actionPerformed(e);
            }
        });
        jComboBox3.setBounds(new Rectangle(45, 15, 415, 20));
        jComboBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox3_actionPerformed(e);
            }
        });
        jPanel8.setBounds(new Rectangle(5, 510, 725, 25));
        jPanel8.setLayout(gridLayout1);
        jLabel28.setText("jLabel28");
        jLabel28.setHorizontalTextPosition(SwingConstants.LEFT);
        jLabel28.setHorizontalAlignment(SwingConstants.LEFT);
        jCheckBox3.setText("");
        jCheckBox3.setToolTipText("\u0412\u044b\u0447\u0438\u0441\u043b\u044f\u0442\u044c \u043a\u0430\u043a \u0432 ibank2");
        jLabel29.setText("\u0416\u0443\u0440\u043d\u0430\u043b \u041c\u041d\u0418:");
        jLabel210.setText("\u0416\u0443\u0440\u043d\u0430\u043b \u0421\u041a\u0417\u0418:");
        jComboBox4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox4_actionPerformed(e);
            }
        });
        jComboBox5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox5_actionPerformed(e);
            }
        });
        jLabel211.setText("\u0416\u0443\u0440\u043d\u0430\u043b \u041c\u041d\u0418:");
        jComboBox6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox4_actionPerformed(e);
            }
        });
        jPanel5.add(jLabel25, new XYConstraints(450, -4, 115, 15));
        jPanel5.add(jList1, new XYConstraints(450, 11, 80, 80));
        jPanel5.add(jTextField5, new XYConstraints(75, 66, 150, 20));
        jPanel5.add(jTextField4, new XYConstraints(295, 11, 140, 20));
        jPanel5.add(jTextField3, new XYConstraints(150, 11, 140, 20));
        jPanel5.add(jTextField2, new XYConstraints(5, 11, 140, 20));
        jPanel5.add(jTextField1, new XYConstraints(75, 41, 360, 20));
        jPanel5.add(jLabel1, new XYConstraints(55, -4, 55, 15));
        jPanel5.add(jLabel2, new XYConstraints(200, -4, 55, 15));
        jPanel5.add(jLabel3, new XYConstraints(330, -4, 55, 15));
        jPanel5.add(jLabel4, new XYConstraints(5, 71, 75, 15));
        jPanel5.add(jLabel5, new XYConstraints(5, 46, 65, 15));
        jPanel6.add(jLabel19, new XYConstraints(5, 149, 95, 15));
        jPanel6.add(jTextField18, new XYConstraints(100, 119, 115, 20));
        jPanel6.add(jTextField17, new XYConstraints(100, 94, 115, 20));
        jPanel6.add(jTextField16, new XYConstraints(100, 69, 115, 20));
        jPanel6.add(jLabel14, new XYConstraints(5, 26, 95, 15));
        jPanel6.add(jTextField14, new XYConstraints(100, 21, 115, 20));
        jPanel6.add(jLabel16, new XYConstraints(5, 74, 95, 15));
        jPanel6.add(jLabel17, new XYConstraints(5, 99, 95, 15));
        jPanel6.add(jLabel18, new XYConstraints(5, 124, 95, 15));
        jPanel6.add(jTextField15, new XYConstraints(100, -4, 115, 20));
        jPanel6.add(jLabel15, new XYConstraints(5, 1, 95, 15));
        jPanel6.add(jTextField112, new XYConstraints(100, 144, 115, 20));
        jPanel6.add(jComboBox1, new XYConstraints(100, 44, 115, 20));
        jPanel6.add(jLabel211, new XYConstraints(5, 174, 80, 15));
        jPanel6.add(jComboBox6, new XYConstraints(100, 169, 100, 20));
        jPanel7.add(jList2, new XYConstraints(0, 11, 145, 80));
        jPanel7.add(jLabel26, new XYConstraints(5, -4, 120, 15));
        jPanel8.add(jLabel28, null);
        this.getContentPane().add(jPanel8, null);
        this.getContentPane().add(jCheckBox2, null);
        this.getContentPane().add(jPanel7, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jPanel6, null);
        this.getContentPane().add(jPanel5, null);
        this.getContentPane().add(jPanel4, null);
        this.getContentPane().add(jPanel3, null);
        this.getContentPane().add(jPanel2, null);
        this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jCheckBox1, null);
        jPanel4.add(jComboBox5, new XYConstraints(155, 329, 100, 20));
        jPanel4.add(jLabel210, new XYConstraints(5, 334, 95, 15));
        jPanel4.add(jCheckBox3, new XYConstraints(235, 99, 20, 15));
        jPanel4.add(jFormattedTextField3, new XYConstraints(145, 94, 85, 20));
        jPanel4.add(jFormattedTextField2, new XYConstraints(145, 71, 110, 20));
        jPanel4.add(jTextField29, new XYConstraints(75, 21, 180, 20));
        jPanel4.add(jLabel27, new XYConstraints(5, 26, 80, 15));
        jPanel4.add(jLabel114, new XYConstraints(5, 251, 140, 15));
        jPanel4.add(jTextField28, new XYConstraints(155, 246, 100, 20));
        jPanel4.add(jTextField27, new XYConstraints(155, 221, 100, 20));
        jPanel4.add(jLabel113, new XYConstraints(5, 226, 140, 15));
        jPanel4.add(jTextField26, new XYConstraints(155, 191, 100, 20));
        jPanel4.add(jTextField25, new XYConstraints(155, 166, 100, 20));
        jPanel4.add(jTextField24, new XYConstraints(145, 119, 110, 20));
        jPanel4.add(jLabel24, new XYConstraints(5, 124, 130, 15));
        jPanel4.add(jLabel23, new XYConstraints(5, 101, 140, 15));
        jPanel4.add(jLabel22, new XYConstraints(5, 76, 120, 15));
        jPanel4.add(jLabel21, new XYConstraints(5, 51, 100, 15));
        jPanel4.add(jLabel20, new XYConstraints(5, 1, 80, 15));
        jPanel4.add(jLabel111, new XYConstraints(5, 171, 140, 15));
        jPanel4.add(jLabel112, new XYConstraints(5, 196, 150, 15));
        jPanel4.add(jFormattedTextField1, new XYConstraints(145, 46, 110, 20));
        jPanel4.add(jComboBox3, new XYConstraints(40, -1, 215, 20));
        jPanel3.add(jLabel115, new XYConstraints(5, -1, 95, 15));
        jPanel3.add(jTextField110, new XYConstraints(100, 144, 115, 20));
        jPanel3.add(jLabel110, new XYConstraints(5, 149, 95, 15));
        jPanel3.add(jLabel13, new XYConstraints(5, 124, 95, 15));
        jPanel3.add(jLabel12, new XYConstraints(5, 99, 95, 15));
        jPanel3.add(jTextField13, new XYConstraints(100, 119, 115, 20));
        jPanel3.add(jTextField12, new XYConstraints(100, 94, 115, 20));
        jPanel3.add(jLabel11, new XYConstraints(5, 74, 95, 15));
        jPanel3.add(jTextField11, new XYConstraints(100, 69, 115, 20));
        jPanel3.add(jLabel10, new XYConstraints(5, 24, 95, 15));
        jPanel3.add(jTextField10, new XYConstraints(100, 19, 115, 20));
        jPanel3.add(jTextField111, new XYConstraints(100, -4, 115, 20));
        jPanel3.add(jComboBox2, new XYConstraints(100, 44, 115, 20));
        jPanel3.add(jComboBox4, new XYConstraints(100, 169, 100, 20));
        jPanel3.add(jLabel29, new XYConstraints(5, 174, 80, 15));
        jPanel2.add(jLabel9, new XYConstraints(5, 6, 80, 15));
        jPanel2.add(jLabel8, new XYConstraints(5, 36, 80, 15));
        jPanel2.add(jTextField8, new XYConstraints(135, 1, 80, 20));
        jPanel2.add(jTextField9, new XYConstraints(95, 31, 120, 20));
        jPanel1.add(jTextField7, new XYConstraints(95, 31, 120, 20));
        jPanel1.add(jLabel7, new XYConstraints(5, 36, 80, 15));
        jPanel1.add(jLabel6, new XYConstraints(5, 6, 82, 14));
        jPanel1.add(jTextField6, new XYConstraints(135, 1, 80, 20));
        this.GetFrmParams(); //считываем из СУБД параметры для автозаполнения
        this.jTextField6.setText(this.sql_idistnum);
        this.jTextField8.setText(this.sql_iprotonum);
        this.jTextField12.setText(this.sql_idsttknnum);
        this.jTextField110.setText(this.sql_itknjnum);
        this.jTextField25.setText(this.sql_idstsgnnum);
        this.jTextField27.setText(this.sql_iprodnum);
        this.jTextField17.setText(this.sql_idsttknnum);

        this.jList1.addListSelectionListener(new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent arg0) {
                        if (!arg0.getValueIsAdjusting()) {
                           //System.out.println(jList1.getSelectedValue().toString());
                        try {
                            fill_ownerdata(jList1.getSelectedValue().toString());
                        } catch (SQLException e) {
                        }
                    }
                    }
                });

        jFormattedTextField1.getDocument().addDocumentListener(new DocumentListener() {
          public void changedUpdate(DocumentEvent e) {
            check();
          }
          public void removeUpdate(DocumentEvent e) {
            check();
          }
          public void insertUpdate(DocumentEvent e) {
            check();
          }

          public void check() {
                      jFormattedTextField2.setText(jFormattedTextField1.getText());
                      jFormattedTextField3.setText(Add_Year(jFormattedTextField2.getText()));                      
              }                       
        });
        
        jFormattedTextField2.getDocument().addDocumentListener(new DocumentListener() {
          public void changedUpdate(DocumentEvent e) {
            check();
          }
          public void removeUpdate(DocumentEvent e) {
            check();
          }
          public void insertUpdate(DocumentEvent e) {
            check();
          }

          public void check() {                 
                     jFormattedTextField3.setText(Add_Year(jFormattedTextField2.getText()));      
             }          
        });
        
        Init_EditObjects();
        FillJrnCombo();
    }
    
    /*ОТМЕНА*/
    private void jButton2_actionPerformed(ActionEvent e) {               
        this.dispose();
    }
    
    /*РЕГИСТРАЦИЯ*/   
    private int jButton1_actionPerformed(ActionEvent e) {        
        if (!combobox3changed){
            String skzi=jComboBox3.getSelectedItem().toString();
            if (jComboBox3.getSelectedItem().toString().contains("Криптомодуль")){
                skzi="USB-токен iBank 2 Key"+skzi;
               }        
            int dialog1 = JOptionPane.showConfirmDialog (null, "Указан СКЗИ: "+skzi+"\nПродолжить регистрацию?","Внимание!",JOptionPane.YES_NO_OPTION);
            if(dialog1 == JOptionPane.NO_OPTION){
               return 1;
            }            
           }
        if (!list2changed){
            JOptionPane.showMessageDialog(this, "Не указана причина регистрации.", "Ошибка!", JOptionPane.WARNING_MESSAGE);
            return 1;            
        }        
        if (!CheckFormFill()){
            JOptionPane.showMessageDialog(this, "Должны быть заполнены все поля формы.", "Ошибка!", JOptionPane.WARNING_MESSAGE);
            return 1;            
        }        
        if (!CheckDateMinimum(jFormattedTextField1.getText())){
            try {
                JOptionPane.showMessageDialog(this, "Дата регистрации некорректна либо младше " + GetMaxDate() + " !",
                                              "Ошибка!", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException f) {
                return 1; 
            }
            return 1; 
        }
        if (!CheckDateMinimumProd(jTextField28.getText())){
            try {
                JOptionPane.showMessageDialog(this, "Дата акта вып. работ некорректна либо младше " + GetMaxDateProd() + " !",
                                              "Ошибка!", JOptionPane.WARNING_MESSAGE);
            } catch (SQLException f) {     
                return 1; 
            }
            return 1; 
        }
        if (this.jComboBox4.getItemCount()<0){
            JOptionPane.showMessageDialog(this, "Один из журналов не указан!",
                                              "Ошибка!", JOptionPane.WARNING_MESSAGE);
            return 1; 
        }
        if (this.jComboBox5.getItemCount()<0){
            JOptionPane.showMessageDialog(this, "Один из журналов не указан!",
                                              "Ошибка!", JOptionPane.WARNING_MESSAGE);
            return 1; 
        }
        try {
            if (IdAlreadyExist(jTextField29.getText(),0)) {
                JOptionPane.showMessageDialog(this, "Такой сертификат уже существует в системе!" + jTextField29.getText() + " !",
                                              "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return 1;
            }
            if (IdAlreadyExist(jTextField10.getText(),1)&&linkdata==0) {
                JOptionPane.showMessageDialog(this, "Такой носитель уже существует в системе!" + jTextField10.getText() + " !",
                                              "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return 1;
            }
            if (IdAlreadyExist(jTextField14.getText(),2)&&linkdata==0&&linkdataotp==0) {
                JOptionPane.showMessageDialog(this, "Средство подтверждения уже существует в системе!" + jTextField14.getText() + " !",
                                              "Ошибка!", JOptionPane.ERROR_MESSAGE);
                return 1;
            }            
        } catch (SQLException f) {
            return 1; 
        }

        String ikeynum = "(select max(ikeynum)+1 from xxi.key_info)";//"xxi.keys_seq.NEXTVAL";  /*автоинкремент на стороне СУБД*/
        String inpp="(select max(inpp)+1 from xxi.key_info)"; //"xxi.keysnpp_seq.NEXTVAL";  /*автоинкремент на стороне СУБД*/           /*,INPP       NUMBER(12,0)    NOT NULL      --Порядковый номер журнала*/
        String dregdate=this.jFormattedTextField1.getText();      /*,DREGDATE   DATE                          --Дата выдачи ключа*/
        String crgevent=Integer.toString(jList2.getSelectedIndex()+1); // .toString();      /* ,CRGEVENT   VARCHAR2(500 BYTE)            --Причина:(1) - Первичная регистрация;(2) - Компрометация;(3) - Смена должностного лица;(4) - Плановая смена ключа*/
        String iclicusid=Integer.toString(this.icusnum);     /*,ICLICUSID  NUMBER(12,0)    NOT NULL      --ID клиента (внутр.)*/
        String ccliname=this.full_name;     /*,CCLINAME   VARCHAR2(500 BYTE)                --Полное наименование предприятия*/
        String csgnid=this.jTextField29.getText();        /*    ,CSGNID     VARCHAR2(500 BYTE)        --ID ключа ЭП*/
        String ifacecusid=jList1.getSelectedValue().toString();    /*,IFACECUSID NUMBER(12,0)              --ID Владельца ЭП (внутр.)*/
        String cfacename1=this.jTextField2.getText();    /* ,CFACENAME1 VARCHAR2(500 BYTE)        --Фамилия*/
        String cfacename2=this.jTextField3.getText();    /*,CFACENAME2 VARCHAR2(500 BYTE)        --Имя*/
        String cfacename3=this.jTextField4.getText();    /*,CFACENAME3 VARCHAR2(500 BYTE)         --Отчество владельца ЭП*/
        String cfacepost=this.jTextField5.getText();     /*    ,cfacepost  VARCHAR2(100 BYTE)        --Должность владельца ЭП*/
        String ctkntype=this.jTextField111.getText();      /*    ,CTKNTYPE   VARCHAR2(100 BYTE)        --Тип носителя (usb-token)*/
        String ctknid=this.jTextField10.getText();        /*    ,CTKNID     VARCHAR2(100 BYTE)        --S/N носителя*/
        String itknjnum=this.jTextField110.getText();      /*    ,ITKNJNUM   NUMBER(6,0) NOT NULL      --Учётный номер носителя*/
        String ccnfrmtype=this.jTextField15.getText();    /*,CCNFRMTYPE VARCHAR2(100 BYTE)        --Тип средства подтверждения (otp-токен)*/
        String ccnfrmid=this.jTextField14.getText();      /* ,CCNFRMID   VARCHAR2(100 BYTE)        --s/n средства подтверждения (otp-токен)*/
/*?*/        String icnfrmjnum=itknjnum; //"null";    /*   ,ICNFRMJNUM NUMBER(6,0) NOT NULL      --Учётный номер средства подтверждения*/
        String icnfrmsum=this.jTextField112.getText();  //Сумма подтверждения ОТП
        String idistnum=this.jTextField6.getText();//,IDISTNUM   NUMBER(6,0) DEFAULT NULL  --Учётный номер дистрибутива (установочный пакет)
        String ddist=this.jTextField7.getText(); //,DDIST      DATE			  --дата выдачи дистрибутива
        String iprotonum=this.jTextField8.getText();     /*   ,IPROTONUM  NUMBER(6,0) NOT NULL      --Номер Протокола и Заключения*/
        String idsttknnum=this.jTextField12.getText();    /*  ,IDSTTKNNUM NUMBER(6,0) NOT NULL      --№ Акта передачи носителя*/
        String ddsttnkd=this.jTextField13.getText();       /* ,DDSTTNKD   DATE                  --Дата акта передачи носителя*/
        String idstsgnnum=this.jTextField25.getText();   /*    ,IDSTSGNNUM NUMBER(6,0) NOT NULL      --№ Акта пердачи ключа ЭП*/
        String ddstsgnd=this.jTextField26.getText();      /*    ,DDSTSGND   DATE                  --Дата акта передачи ключа ЭП*/
        /*Учет ранее выданного USB*/
        String ilkeynum="null";       /* ILKEYNUM    NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
        String ildsttknnum="null";    /*,ILDSTTKNNUM NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя (из связанной строки ILNKIKN)*/
        String dldsttnkd="null";      /*,DLDSTTNKD   DATE         DEFAULT NULL  --Дата акта передачи носителя (из связанной строки ILNKIKN)*/
        String iltknjnum="null";      /*,ILTKNJNUM   NUMBER(6,0)  DEFAULT NULL  --Учётный номер носителя (из связанной строки ILNKIKN)*/
        /*Учет ранее выданного ОТП*/
        String ilkeynumotp="null";/*,ILKEYNUMOTP    NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
        String ildactotp="null";    /*,ILDACTOTP     NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя в которм был передан OTP(из связанной строки ILKEYNUMOTP)*/
        String dldactotp="null";   /* DLDACTOTP   DATE         DEFAULT NULL  --Дата акта передачи носителя в котором передавался OTP (из связанной строки ILKEYNUMOTP)*/
        /**/
        String iprodnum=this.jTextField27.getText();       /*  ,IPRODNUM   NUMBER(6,0) NOT NULL      --№ Акта ввода в эксплуатацию*/
        String dprodd=this.jTextField28.getText();        /*  ,DPRODD     DATE                  --Дата акта ввода в эксплуатацию*/
        String ijrnki=this.jComboBox4.getSelectedItem().toString();
        String ijrnkiotp=this.jComboBox6.getSelectedItem().toString();
        String ijrnkidist=this.jComboBox4.getSelectedItem().toString();        
        String iwipenum="null";      /*,IWIPENUM   NUMBER(6,0) NOT NULL      --№ Акта уничтожения*/
        String dwiped="null";        /*    ,DWIPED     DATE                  --Дата акта уничтожения*/
        String comment="null";        /*  ,CCOMMENT   VARCHAR2(1024 BYTE)       --Примечание*/
        
        
        /*СЕРТИФИКАТ key_cert*/
        String icrtkeynum="(select max(icrtkeynum)+1 from xxi.key_cert)"; //"xxi.keycert_seq.NEXTVAL";//ICRTKEYNUM     NUMBER(12,0)    NOT NULL            --ID записи
        String ckeyid=this.jTextField29.getText(); //,CKEYID         VARCHAR2(500 BYTE)                  --ID ключа ЭП
        String cskzitype=jComboBox3.getSelectedItem().toString();
        if (jComboBox3.getSelectedItem().toString().contains("Криптомодуль")){
            cskzitype="USB-токен iBank 2 Key"+cskzitype;
        }        
           //,CSKZITYPE      VARCHAR2(500 BYTE)                  --Тип СКЗИ
        //dregdate=this.jFormattedTextField1.getText();//,DREGDATE       DATE                                --Дата регистрации ключа
        String dstartd=this.jFormattedTextField2.getText();//,DSTARTD        DATE                                --Дата начала действия
        String dendd=this.jFormattedTextField3.getText();//,DENDD          DATE                                --Дата окончания действия
        String csigngrp=this.jTextField24.getText();//,CSIGNGRP       VARCHAR2(500 BYTE)                  --Группа подписи        
        String istate="1"; //,ISTATE         NUMBER(6,0) DEFAULT 1               --Статус ключа (1-дейстует,2-уничтожен)
        String ijrnkc=this.jComboBox5.getSelectedItem().toString();
        //String iwipenum="null";      /*,IWIPENUM   NUMBER(6,0) NOT NULL      --№ Акта уничтожения*/
        //String dwiped="null";        /*    ,DWIPED     DATE                  --Дата акта уничтожения*/
        //String comment="null";        /*  ,CCOMMENT   VARCHAR2(1024 BYTE)       --Примечание*/
        
        /*Контролируем заполнение полей для случая ранее выданного оборудования/дистрибутива*/
        if (linkdata==1){
            /*Учет ранее выданного USB*/
            ilkeynum=gikeynum;       /* ILKEYNUM    NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
            ildsttknnum=gusbactnum;    /*,ILDSTTKNNUM NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя (из связанной строки ILNKIKN)*/
            dldsttnkd=gusbactdate;      /*,DLDSTTNKD   DATE         DEFAULT NULL  --Дата акта передачи носителя (из связанной строки ILNKIKN)*/
            iltknjnum=gusbnum;      /*,ILTKNJNUM   NUMBER(6,0)  DEFAULT NULL  --Учётный номер носителя (из связанной строки ILNKIKN)*/            

            ctkntype="null";        /*   Тип носителя (usb-token)*/
            ctknid="null";          /*    S/N носителя*/
            itknjnum="0";        /*    ,ITKNJNUM   NUMBER(6,0) NOT NULL      --Учётный номер носителя*/
            ccnfrmtype="null";      /*,CCNFRMTYPE VARCHAR2(100 BYTE)        --Тип средства подтверждения (otp-токен)*/
            ccnfrmid="null";        /* ,CCNFRMID   VARCHAR2(100 BYTE)        --s/n средства подтверждения (otp-токен)*/
            icnfrmjnum="0";      /*   ,ICNFRMJNUM NUMBER(6,0) NOT NULL      --Учётный номер средства подтверждения*/
            icnfrmsum="null";       //Сумма подтверждения ОТП
            idistnum="null";        //,IDISTNUM   NUMBER(6,0) DEFAULT NULL  --Учётный номер дистрибутива (установочный пакет)
            ddist="null";           //,DDIST      DATE                       --дата выдачи дистрибутива
            /*Для случая когда оборудование уже выдавалось клиенту, но лицо меняется*/
            if (this.jList2.getSelectedIndex()==2){  /*Если индекс = смена руководителя*/
               iprotonum=this.sql_iprotonum;
            }else{
                iprotonum="0";       /*   ,IPROTONUM  NUMBER(6,0) NOT NULL      --Номер Протокола и Заключения*/    
            }            
            idsttknnum="0";      /*  ,IDSTTKNNUM NUMBER(6,0) NOT NULL      --№ Акта передачи носителя*/
            ddsttnkd="null";        /* ,DDSTTNKD   DATE                  --Дата акта передачи носителя*/                        
            /*Учет ранее выданного ОТП*/
            ilkeynumotp=gikeynum;     /*,ILKEYNUMOTP   NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
            ildactotp=gusbactnum;     /*,ILDACTOTP     NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя в которм был передан OTP(из связанной строки ILKEYNUMOTP)*/
            dldactotp=gusbactdate;    /* DLDACTOTP     DATE         DEFAULT NULL  --Дата акта передачи носителя в котором передавался OTP (из связанной строки ILKEYNUMOTP)*/
        }

        /*Контролируем заполнение полей для случая ранее выданного OTP*/
        if (linkdataotp==1){
            /*Учет ранее выданного OTP*/

            ccnfrmtype="null";      /*,CCNFRMTYPE VARCHAR2(100 BYTE)        --Тип средства подтверждения (otp-токен)*/
            ccnfrmid="null";        /* ,CCNFRMID   VARCHAR2(100 BYTE)        --s/n средства подтверждения (otp-токен)*/
            icnfrmjnum="0";      /*   ,ICNFRMJNUM NUMBER(6,0) NOT NULL      --Учётный номер средства подтверждения*/
            icnfrmsum="null";       //Сумма подтверждения ОТП
            /*Учет ранее выданного ОТП*/
            ilkeynumotp=gikeynum;     /*,ILKEYNUMOTP   NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
            ildactotp=gusbactnum;     /*,ILDACTOTP     NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя в которм был передан OTP(из связанной строки ILKEYNUMOTP)*/
            dldactotp=gusbactdate;    /* DLDACTOTP     DATE         DEFAULT NULL  --Дата акта передачи носителя в котором передавался OTP (из связанной строки ILKEYNUMOTP)*/
        }
        
        if (CheckFormFill()){
            /*Вносим данные в журнал и в таблицу сертификатов*/
            try {            
                this.Insert_Jrnl(ikeynum,inpp,dregdate,crgevent,iclicusid,ccliname,csgnid,ifacecusid,cfacename1,cfacename2,cfacename3,cfacepost,ctkntype,ctknid,itknjnum,idistnum, ddist,
                                 ccnfrmtype,ccnfrmid,icnfrmjnum,icnfrmsum,iprotonum,idsttknnum,ddsttnkd,ilkeynum, ildsttknnum, dldsttnkd, iltknjnum,ilkeynumotp,ildactotp, dldactotp,idstsgnnum,ddstsgnd,
                                 iprodnum,dprodd,iwipenum, dwiped,comment,ijrnki,ijrnkiotp,ijrnkidist);
                this.Insert_Cert(icrtkeynum, ckeyid, cskzitype, dregdate, dstartd, dendd, csigngrp, istate, iwipenum, dwiped, comment,ijrnkc);
            } catch (Exception f) {
                System.out.println(f.getMessage());
            }        
                    
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Должны быть заполнены все поля.", "Ошибка!", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    /*Контроль заполнения всех сведений формы*/
    private boolean  CheckFormFill() {
        boolean check=true;
        
        //проверяем все TextFields на форме        
        //if (jTextField1.getText().length()<1) {check=false;}
        if (jTextField2.getText().length()<1) {check=false;}
        if (jTextField3.getText().length()<1) {check=false;}
        if (jTextField4.getText().length()<1) {check=false;}
        if (jTextField5.getText().length()<1) {check=false;}
        if (jTextField6.getText().length()<1) {check=false;}
        if (jTextField7.getText().length()<1) {check=false;}
        if (jTextField8.getText().length()<1) {check=false;}
        if (jTextField9.getText().length()<1) {check=false;}
        if (jTextField10.getText().length()<1) {check=false;}
        if (jTextField11.getText().length()<1) {check=false;}
        if (jTextField12.getText().length()<1) {check=false;}
        if (jTextField13.getText().length()<1) {check=false;}
        if (jTextField14.getText().length()<1) {check=false;}
        if (jTextField15.getText().length()<1) {check=false;}
        if (jTextField16.getText().length()<1) {check=false;}
        if (jTextField17.getText().length()<1) {check=false;}
        if (jTextField18.getText().length()<1) {check=false;}        
        if (jTextField24.getText().length()<1) {check=false;}
        if (jTextField25.getText().length()<1) {check=false;}
        if (jTextField26.getText().length()<1) {check=false;}
        if (jTextField27.getText().length()<1) {check=false;}
        if (jTextField28.getText().length()<1) {check=false;}
        if (jTextField29.getText().length()<1) {check=false;}
        if (jTextField110.getText().length()<1) {check=false;}
        if (jTextField111.getText().length()<1) {check=false;}
        if (jTextField112.getText().length()<1) {check=false;}
        if (jFormattedTextField1.getText().length()<1) {check=false;}
        if (jFormattedTextField2.getText().length()<1) {check=false;}
        if (jFormattedTextField3.getText().length()<1) {check=false;}        
        
        return check;
    }
    
    /*insert_cert*/
    public int Insert_Jrnl(
                                  String ikeynum,       /* IKEYNUM     NUMBER(12,0)    NOT NULL          --ID записи*/
                                  String inpp,           /*,INPP       NUMBER(12,0)    NOT NULL      --Порядковый номер журнала*/
                                  String dregdate,      /*,DREGDATE   DATE                          --Дата выдачи ключа*/
                                  String crgevent,      /* ,CRGEVENT   VARCHAR2(500 BYTE)            --Причина:(1) - Первичная регистрация;(2) - Компрометация;(3) - Смена должностного лица;(4) - Плановая смена ключа*/
                                  String iclicusid,     /*,ICLICUSID  NUMBER(12,0)    NOT NULL      --ID клиента (внутр.)*/
                                  String ccliname,      /*,CCLINAME   VARCHAR2(500 BYTE)                --Полное наименование предприятия*/
                                  String csgnid,        /*    ,CSGNID     VARCHAR2(500 BYTE)        --ID ключа ЭП*/
                                  String ifacecusid,    /*,IFACECUSID NUMBER(12,0)              --ID Владельца ЭП (внутр.)*/
                                  String cfacename1,    /* ,CFACENAME1 VARCHAR2(500 BYTE)        --Фамилия*/
                                  String cfacename2,    /*,CFACENAME2 VARCHAR2(500 BYTE)        --Имя*/
                                  String cfacename3,    /*,CFACENAME3 VARCHAR2(500 BYTE)         --Отчество владельца ЭП*/
                                  String cfacepost,     /*    ,cfacepost  VARCHAR2(100 BYTE)        --Должность владельца ЭП*/
                                  String ctkntype,      /*    ,CTKNTYPE   VARCHAR2(100 BYTE)        --Тип носителя (usb-token)*/
                                  String ctknid,        /*    ,CTKNID     VARCHAR2(100 BYTE)        --S/N носителя*/
                                  String itknjnum,      /*    ,ITKNJNUM   NUMBER(6,0) NOT NULL      --Учётный номер носителя*/
                                  String idistnum,       //,IDISTNUM   NUMBER(6,0) DEFAULT NULL  --Учётный номер дистрибутива (установочный пакет)
                                  String ddist,        //,DDIST      DATE                       --дата выдачи дистрибутива                                  
                                  String ccnfrmtype,    /*,CCNFRMTYPE VARCHAR2(100 BYTE)        --Тип средства подтверждения (otp-токен)*/
                                  String ccnfrmid,      /* ,CCNFRMID   VARCHAR2(100 BYTE)        --s/n средства подтверждения (otp-токен)*/
                                  String icnfrmjnum,    /*   ,ICNFRMJNUM NUMBER(6,0) NOT NULL      --Учётный номер средства подтверждения*/
                                  String icnfrmsum,     /*сумма подтверждения ОТП*/
                                  String iprotonum,     /*   ,IPROTONUM  NUMBER(6,0) NOT NULL      --Номер Протокола и Заключения*/
                                  String idsttknnum,    /*  ,IDSTTKNNUM NUMBER(6,0) NOT NULL      --№ Акта передачи носителя*/
                                  String ddsttnkd,       /* ,DDSTTNKD   DATE                  --Дата акта передачи носителя*/
                                  String ilkeynum,     /* ILKEYNUM    NUMBER(12,0) DEFAULT NULL  --ID записи (связь с другой строкой журнала)*/
                                  String ildsttknnum,    /*,ILDSTTKNNUM NUMBER(6,0)  DEFAULT NULL  --№ Акта передачи носителя (из связанной строки ILNKIKN)*/
                                  String dldsttnkd,   /*,DLDSTTNKD   DATE         DEFAULT NULL  --Дата акта передачи носителя (из связанной строки ILNKIKN)*/
                                  String iltknjnum,   /*,ILTKNJNUM   NUMBER(6,0)  DEFAULT NULL  --Учётный номер носителя (из связанной строки ILNKIKN)*/
                                  String ilkeynumotp,   /*Учет ранее выданного ОТП по существующей строке журнала*/
                                  String ildactotp,     /*Учет ранее выданного ОТП по существующей строке журнала*/
                                  String dldactotp,      /*Учет ранее выданного ОТП по существующей строке журнала*/
                                  String idstsgnnum,    /*    ,IDSTSGNNUM NUMBER(6,0) NOT NULL      --№ Акта пердачи ключа ЭП*/
                                  String ddstsgnd,      /*    ,DDSTSGND   DATE                  --Дата акта передачи ключа ЭП*/
                                  String iprodnum,       /*  ,IPRODNUM   NUMBER(6,0) NOT NULL      --№ Акта ввода в эксплуатацию*/
                                  String dprodd,        /*  ,DPRODD     DATE                  --Дата акта ввода в эксплуатацию*/                                  
                                  String iwipenum,      /*,IWIPENUM   NUMBER(6,0) NOT NULL      --№ Акта уничтожения*/
                                  String dwiped,        /*    ,DWIPED     DATE                  --Дата акта уничтожения*/
                                  String comment,        /*  ,CCOMMENT   VARCHAR2(1024 BYTE)       --Примечание*/
                                  String ijrnki,
                                  String ijrnkiotp,
                                  String ijrnkidist
                 ) throws Exception {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
           
            ikeynum = "(select max(ikeynum)+1 from xxi.key_info)";//"xxi.keyinfo_seq.NEXTVAL";
            inpp = "(select max(inpp)+1 from xxi.key_info)"; //"xxi.keysnpp_seq.NEXTVAL";
            if (dwiped.compareTo("null")==0) {
                //dwiped="null";
                }                
            else{
                dwiped="to_date('"+dwiped+"','DD.MM.RRRR')";
                }            

            if (dldsttnkd.compareTo("null")==0) {
                //dldsttnkd="null";
                }                
            else{
                dldsttnkd="to_date('"+dldsttnkd+"','DD.MM.RRRR')";
                }                         
            
            if (ddist.compareTo("null")==0) {
                //dldsttnkd="null";
                }                
            else{
                ddist="to_date('"+ddist+"','DD.MM.RRRR')";
                }  
            String insert_sql="INSERT INTO xxi.key_info VALUES(" +
                            ikeynum + "," +
                            inpp + "," +
                            "to_date('"+dregdate + "','DD.MM.RRRR')," +
                            "'"+crgevent + "'," +
                            iclicusid  + "," +
                            "'"+ccliname + "'," +
                            "'"+csgnid + "'," +
                            ifacecusid + "," +
                            "'"+cfacename1 + "'," +
                            "'"+cfacename2 + "'," +
                            "'"+cfacename3 + "'," +
                            "'"+cfacepost + "'," +
                            "'"+ctkntype + "'," +
                            "'"+ctknid + "'," +
                            itknjnum + "," +
                            "'"+ccnfrmtype + "'," +
                            "'"+ccnfrmid + "'," +
                            icnfrmjnum + "," +
                            icnfrmsum +","+
                            idistnum + "," +
                            ddist + "," +
                            iprotonum + "," +
                            idsttknnum + "," +
                            "to_date('"+ddsttnkd + "','DD.MM.RRRR')," +
                            ilkeynum + "," +
                            ildsttknnum + "," +
                            dldsttnkd + "," +                            
                            iltknjnum + "," +
                            ilkeynumotp + "," +
                            ildactotp + "," +                            
                            "to_date('"+dldactotp  + "','DD.MM.RRRR')," +
                            idstsgnnum + "," +
                            "to_date('"+ddstsgnd + "','DD.MM.RRRR')," +
                            iprodnum + "," +
                            "to_date('"+dprodd + "','DD.MM.RRRR')," +                            
                            iwipenum + "," +
                            dwiped +"," +
                            "'"+comment + "',"+
                            ijrnki+","+
                            ijrnkiotp+","+
                            ijrnkidist+")";
            Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
            Statement st = con.createStatement();
            insert_sql=insert_sql.replaceAll("'null'", "null");
            //System.out.println("DIAG:"+insert_sql);
            ///System.out.println("DIAG:"+ccliname+this.full_name);            
            st.executeUpdate(insert_sql);
            //con.commit();
            st.close();
            con.close(); 
            con = null;
            FrameLogon.mainpool.Close(); 
            return 0;
        }
    
    public int Insert_Cert(
    String icrtkeynum, //="keycert_seq.NEXTVAL";//ICRTKEYNUM     NUMBER(12,0)    NOT NULL            --ID записи
    //String iceynum, //ICEYNUM     NUMBER(12,0)    NOT NULL            --ID записи по таблице key_info
    String ckeyid, //=this.jTextField29.getText(); //,CKEYID         VARCHAR2(500 BYTE)                  --ID ключа ЭП
    String cskzitype, //=this.jTextField20.getText();//,CSKZITYPE      VARCHAR2(500 BYTE)                  --Тип СКЗИ
    String dregdate, //=this.jFormattedTextField1.getText();//,DREGDATE       DATE                                --Дата регистрации ключа
    String dstartd, //=this.jFormattedTextField2.getText();//,DSTARTD        DATE                                --Дата начала действия
    String dendd, //=this.jFormattedTextField3.getText();//,DENDD          DATE                                --Дата окончания действия
    String csigngrp, //=this.jTextField24.getText();//,CSIGNGRP       VARCHAR2(500 BYTE)                  --Группа подписи    
    String istate,//="1", //; //,ISTATE         NUMBER(6,0) DEFAULT 1               --Статус ключа (1-дейстует,2-уничтожен)
    String iwipenum, //="null";      /*,IWIPENUM   NUMBER(6,0) NOT NULL      --№ Акта уничтожения*/
    String dwiped, //="null";        /*    ,DWIPED     DATE                  --Дата акта уничтожения*/
    String comment,  //="null";        /*  ,CCOMMENT   VARCHAR2(1024 BYTE)       --Примечание*/
    String ijrnkc
                 ) throws Exception {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
           
            icrtkeynum = "(select max(icrtkeynum)+1 from xxi.key_cert)";//"xxi.keycert_seq.NEXTVAL";
            String iceynum = Get_IkeynumByCert(ckeyid);
            if (dwiped.compareTo("null")==0) {
                dwiped="null";
                }                
            else{
                dwiped="to_date('"+dwiped+"','DD.MM.RRRR')";
                }  
            String insert_sql="INSERT INTO xxi.key_cert VALUES(" +
                            icrtkeynum + "," +
                            iceynum + "," +  
                            "'"+ckeyid + "'," +
                            "'"+cskzitype + "'," +
                            "to_date('"+dregdate + "','DD.MM.RRRR')," +
                            "to_date('"+dstartd  + "','DD.MM.RRRR')," +
                            "to_date('"+dendd + "','DD.MM.RRRR')," +
                            "'"+csigngrp + "'," +                            
                            ""+istate + "," +                            
                            iwipenum + "," +
                            dwiped + "," +
                            "'"+comment +"',"+ ijrnkc+")";
            Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
            Statement st = con.createStatement();
            insert_sql=insert_sql.replaceAll("'null'", "null");
            //System.out.println("DIAG cert:"+insert_sql);
            st.executeUpdate(insert_sql);
            //con.commit();
            st.close();
            con.close(); 
            con = null;
            FrameLogon.mainpool.Close();
            return 0;
        }
    
    public void fill_sql_JList(JList list) throws SQLException
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        DefaultListModel model = new DefaultListModel(); //create a new list model


        String query="select distinct id_cus_child as v01 from xxi.cus_lnk where id_lnk_type in (1,21,121) and id_cus_parent ="+Integer.toString(this.icusnum);
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query); 

        while (rs.next()) 
        {
            String itemCode = rs.getString("v01"); 
            model.addElement(itemCode); //add each item to the model
        }
        list.setModel(model);

        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
    }    
    
    public String Get_CurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");  //"yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curdate = sdf.format(date);        
        return curdate;
    }

/*високосный год*/
    public boolean isLeapYear(int year) {
     
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    return true;
            } else {
                    return false;
            }
        }

/*прибавить год к указанной дате*/
    public String Add_Year(String datevalue){                
        
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = sdf.parse(datevalue);
        } catch (ParseException e) {
        }
        
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, 1); //прибавим год        
        int year = c.get(Calendar.YEAR);        
        
       
        if (isLeapYear(year)){
                c.add(Calendar.DAY_OF_MONTH, -1); //вычитаем день для високосного года
        }            
        
        /*корректировка даты (вычислять так как в ibank2)*/
        if (this.jCheckBox3.isSelected()){
                c.add(Calendar.DAY_OF_MONTH, -1);
        }
        
        Date newdate = c.getTime();
        String curdate = sdf.format(newdate);
        return curdate;
    }
    
    
    /*Проверить - если указанная дата не меньше минимально допустимой*/
        public boolean CheckDateMinimum(String datevalue){
            if (!this.isThisDateValid(datevalue, "dd.MM.yyyy")){
                return false;
            }
            String mindate=datevalue;
            try {
                mindate = GetMaxDate();
            } catch (SQLException e) {
            }
            DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);            
            Date date = new Date();
            Date date2 = new Date();
            try {
                date = sdf.parse(datevalue);
                date2 = sdf.parse(mindate);
            } catch (ParseException e) {
            }
            
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(date);
            c2.setTime(date2);
                        
            if (c1.after(c2)||c1.equals(c2)){
                    return true;
                }else{
                    return false;
                }        
        }
    
    
    /*максимальная дата журнала*/
    private String GetMaxDate() throws SQLException
    {
        String query="select to_char(max(dregdate),'DD.MM.RRRR') v01 from xxi.key_info";    
        
                                
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query); 

        String resstr="";
        
        while (rs.next()) 
        {
            resstr = rs.getString("v01");
        }        

        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
        return resstr;
    }    
    
    
    
    /*Проверить - если указанная дата акта ввода в экспл. не меньше минимально допустимой*/
        public boolean CheckDateMinimumProd(String datevalue){
            if (!this.isThisDateValid(datevalue, "dd.MM.yyyy")){
                return false;
            }
            String mindate=datevalue;
            try {
                mindate = GetMaxDateProd();
            } catch (SQLException e) {
            }
            DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);            
            Date date = new Date();
            Date date2 = new Date();
            try {
                date = sdf.parse(datevalue);
                date2 = sdf.parse(mindate);
            } catch (ParseException e) {
            }
            
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(date);
            c2.setTime(date2);
                        
            if (c1.after(c2)||c1.equals(c2)){
                    return true;
                }else{
                    return false;
                }        
        }
    
    /*максимальная дата журнала акт ввода в эспл.*/
    private String GetMaxDateProd() throws SQLException
    {
        String query="select to_char(max(dprodd),'DD.MM.RRRR') v01 from xxi.key_info";    
        
                                
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query); 

        String resstr="";
        
        while (rs.next()) 
        {
            resstr = rs.getString("v01");
        }        

        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
        return resstr;
    }    
    
 
 /*Заполняем Комбобокс OTP SN*/
 public void FillOtpCombo() throws SQLException {        
     String query="select nvl(ccnfrmsn,'НЕТ ИНФОРМАЦИИ') v01 from xxi.szflow where recstate=1 and iclicusid="+Integer.toString(icusnum);
     Connection con = FrameLogon.mainpool.OpenConnection();
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(query);
     
     jComboBox1.removeAllItems(); //чистим бокс
     //jComboBox1.addItem("Взять из базы...");
     
     while (rs.next()) 
       {
          jComboBox1.addItem(rs.getString("v01"));
       }
     
     st.close();
     con.close(); 
     con = null;
     FrameLogon.mainpool.Close();     
 }
 
    /*Заполняем Комбобокс USB SN*/
    public void FillUsbCombo() throws SQLException {        
        String query="select nvl(cneksn,'НЕТ ИНФОРМАЦИИ') v01 from xxi.szflow where recstate=1 and iclicusid="+Integer.toString(icusnum);
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        jComboBox2.removeAllItems(); //чистим бокс
        //jComboBox1.addItem("Взять из базы...");
        
        while (rs.next()) 
          {
             jComboBox2.addItem(rs.getString("v01"));
          }
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();     
    }
 
    
    public String Get_IkeynumByCert(String csgnid) throws SQLException {        
        String res = new String();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
             
        String query="select ikeynum from xxi.key_info where csgnid like '"+csgnid+"'";        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) 
          {
             res=rs.getString("ikeynum");             
          }
                
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
        return (res);
    }
    
   /*Проверка на наличие сертификата в базе (контроль дубликатов ID сертификата)*/ 
    //type = 0 - сертификат, 1 - нэк, 2 - otp
    public boolean IdAlreadyExist(String id, int type) throws SQLException {        
        String res="";        
        
        String query="select count(*) v01 from xxi.key_info where csgnid like '"+id+"'";
        if (type==0){ query="select count(*) v01 from xxi.key_info where csgnid like '"+id+"'";}
        else if(type==1){ query="select count(*) v01 from xxi.key_info where ctknid like '"+id+"'";}
        else if(type==2){ query="select count(*) v01 from xxi.key_info where ccnfrmid like '"+id+"'";}
        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) 
          {
             res=rs.getString("v01");             
          }
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();     
        
        if (Integer.parseInt(res)>0){
            return true;
        } else {
            return false;
        }
    }
        
    
    
    /*Проверка даты на валидность формату*/
    
    public boolean isThisDateValid(String dateToValidate, String dateFromat){
     
                    if(dateToValidate == null){
                            return false;
                    }
     
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
                    sdf.setLenient(false);
     
                    try {
     
                            //if not valid, it will throw ParseException
                            Date date = sdf.parse(dateToValidate);
                            //System.out.println(date);
     
                    } catch (ParseException e) {
     
                            e.printStackTrace();
                            return false;
                    }
     
                    return true;
            }
    
    /*Выбираем номера устройств и актов для автозаполнения*/
    public void GetFrmParams() throws SQLException {        
        String res = new String();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String query="select " + 
                "   SUM(V01)  v01" + 
                "  ,SUM(V02)  v02" + 
                "  ,SUM(V03)  v03" + 
                "  ,SUM(V04)  v04" + 
                "  ,SUM(V05)  v05" + 
                "  ,SUM(V06)  v06 " + 
                "from " + 
                "(select " + 
                " nvl(max(IDISTNUM),0)+1 as v01     " +  //--Учётный номер дистрибутива (установочный пакет)
                ",nvl(max(IPROTONUM),0)+1 as v02     " +  //--Номер Протокола и Заключения
                ",nvl(max(IDSTTKNNUM),0)+1 as v03   " +  //--№ Акта передачи носителя
                ",nvl(max(ITKNJNUM),0)+1 as v04     " +  //--Учётный номер носителя (из связанной строки ILNKIKN)
                ",0 v05" + 
                ",0 v06" + 
                " " + 
                "from xxi.key_info where dregdate>=trunc(sysdate,'YY' )" + 
                /*"and DDSTTNKD is not null " +  временно отключим*/ 
                "union " + 
                "select " + 
                "0 v01" + 
                ",0 v02" + 
                ",0 v03" + 
                ",0 v04 " + 
                ",nvl(max(IDSTSGNNUM),0)+1 as v05   " +  //--№ Акта пердачи ключа ЭП
                ",nvl(max(IPRODNUM),0)+1 as v06     " +  //--№ Акта ввода в эксплуатацию
                " " + 
                "from xxi.key_info where dregdate>=trunc(sysdate,'YY'))";
        
        ///System.out.println(query);
        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
                        
                
        while (resultSet.next()) 
          {            
            this.sql_idistnum=resultSet.getString("v01");
            this.sql_iprotonum=resultSet.getString("v02");
            this.sql_idsttknnum=resultSet.getString("v03");
            this.sql_itknjnum =resultSet.getString("v04");
            this.sql_idstsgnnum=resultSet.getString("v05");
            this.sql_iprodnum=resultSet.getString("v06");            
          }
        
        resultSet.close();
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
        
    }
    
 
    public void Init_EditObjects(){
        jLabel28.setText("");
        DateFormatter formatter1 = new DateFormatter(df);
        MaskFormatter datemask1 = new MaskFormatter();
        try {
            datemask1 = new MaskFormatter("##.##.####");
        } catch (ParseException e) {
        }
                
        formatter1.install(jFormattedTextField1);
        datemask1.install(jFormattedTextField1);
        formatter1.install(jFormattedTextField2);
        datemask1.install(jFormattedTextField2);
        formatter1.install(jFormattedTextField3);
        datemask1.install(jFormattedTextField3);
        
        this.jTextField7.setText(Get_CurrentDate());
        this.jTextField9.setText(Get_CurrentDate());
        this.jTextField11.setText(Get_CurrentDate());
        this.jTextField13.setText(Get_CurrentDate());
        this.jTextField16.setText(Get_CurrentDate());
        this.jTextField18.setText(Get_CurrentDate());
        this.jFormattedTextField1.setText(Get_CurrentDate());
        this.jFormattedTextField2.setText(Get_CurrentDate());
        this.jFormattedTextField3.setText(this.Add_Year(Get_CurrentDate()));
        this.jTextField26.setText(Get_CurrentDate());
        this.jTextField28.setText(Get_CurrentDate());
        
        DefaultListModel listModel_reasons;
        listModel_reasons = new DefaultListModel();
        this.jList2.setModel(listModel_reasons);
        listModel_reasons.addElement("1.Первичная регистрация");
        listModel_reasons.addElement("2.Компрометация");
        listModel_reasons.addElement("3.Смена должн. лица");
        listModel_reasons.addElement("4.Плановая смена ключа");
        listModel_reasons.addElement("5.Проблемы с НЭК");
        //this.jList2.setSelectedIndex(0);
                
        /*Фраза USB Токен ibank2key добавляется ниже для строк с Криптомодулем*/
        String[] skziList=new String[0];
        try {
            skziList = this.GetUsableSKZI();
        } catch (SQLException e) {
        }        
        
        for (int i=0;i<skziList.length;i++){
            jComboBox3.addItem(skziList[i]);
        }
        
        ////jComboBox3.addItem("СКЗИ \"MS_KEY K\" - \"АНГАРА\" Исп.8.1.1");
        ////jComboBox3.addItem("СКЗИ Рутокен ЭЦП 2.0");
        //jComboBox3.addItem("СКЗИ \"MS_KEY K\" Исп.5.1.1");
        /*jComboBox3.addItem("(СКЗИ ФОРОС. Исполнение №1)");*/
        //jComboBox3.addItem("(СКЗИ ФОРОС. Исполнение №2 / Криптомодуль C23)");
        ////jComboBox3.addItem("Крипто-Ком 3.3");
        //jComboBox3.addItem("(СКЗИ \"Криптомодуль C23\")");
        
        combobox3changed=false;
    }
               
    private String[] GetUsableSKZI() throws SQLException
    {
        String query="SELECT CSKZINAME v01 FROM XXI.KEYARCH_SKZI_TYPE WHERE RECSTATE=1";
                                
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query); 

        String[] skzi=new String[0];
        String s;
        
        while (rs.next()) 
        {
             s = rs.getString("v01");
             skzi=Append(skzi,s);
        }        

        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();

        return skzi;
    }  

    public static String[] Append(String[] stringArray, String newValue)
    {
        String[] tempArray = new String[ stringArray.length + 1 ];
        for (int i=0; i<stringArray.length; i++)
        {
            tempArray[i] = stringArray[i];
        }
        tempArray[stringArray.length] = newValue;
        return tempArray;
    }
    
    public void fill_ownerdata(String ownerid) throws SQLException
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
               
        //String sql_f="select regexp_replace(CCUSNAME,'(.*) (.*) (.*)','\\1') as v01 from cus where icusnum = "+ownerid; //фамилия
        String sql_f="select regexp_replace(CCUSNAME,' (.*)') as v01 from xxi.cus where icusnum = "+ownerid; //фамилия
        //String sql_i="select regexp_replace(CCUSNAME,'(.*) (.*) (.*)','\\2') as v01 from cus where icusnum = "+ownerid; //имя
        String sql_i="select regexp_replace(CCUSNAME, ' (.*)|^[^ ]* ') as v01 from xxi.cus where icusnum = "+ownerid; //имя
        
        //String sql_o="select regexp_replace(CCUSNAME,'(.*) (.*) (.*)','\\3') as v01 from cus where icusnum = "+ownerid; //отчество
        String sql_o="select regexp_replace(CCUSNAME,'(.*) ') as v01 from xxi.cus where icusnum = "+ownerid; //отчество
        String sql_passp="select  ccusdoctype||' '||ccuspassp_ser||' '||ccuspassp_num||' '||dcuspassp||' '||ccuspassp_place||' '||ccuspassp_subdiv v01 from xxi.cus where icusnum = "+ownerid; //паспорт
        
        String sql_postname="select post_name v01 from xxi.cus_lnk l,xxi.cus_post p, xxi.cus c where" + 
        " l.id_lnk_type in (1,21,121) " + 
        " and l.id_cus_parent = " + Integer.toString(this.icusnum) +
        " and id_cus_child = " + ownerid +
        " and p.id_post (+)= l.id_post " + 
        " and c.icusnum (+)= l.id_cus_child " + 
        " and id_lnk=" + 
        "(select min(id_lnk) from" + 
        "    xxi.cus_lnk l, " + 
        "    xxi.cus_post p," + 
        "    xxi.cus c " + 
        "where" + 
        "    l.id_lnk_type in (1,21,121) " + 
        " and l.id_cus_parent = " + Integer.toString(this.icusnum) +
        " and id_cus_child = " + ownerid +
        "    and p.id_post (+)= l.id_post " + 
        "    and c.icusnum (+)= l.id_cus_child )";  //Должность сотрудника
        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
    
        ResultSet resultSet = st.executeQuery(sql_f); 
        
        while (resultSet.next()) 
          {
             this.jTextField2.setText(resultSet.getString("v01"));
             //System.out.println(sql_f);
          }
        resultSet = st.executeQuery(sql_i);
        while (resultSet.next()) 
          {
             this.jTextField3.setText(resultSet.getString("v01"));             
          }
        resultSet = st.executeQuery(sql_o);
        while (resultSet.next()) 
          {
             this.jTextField4.setText(resultSet.getString("v01"));             
          }
        resultSet = st.executeQuery(sql_passp);
        while (resultSet.next()) 
          {
             this.jTextField1.setText(resultSet.getString("v01"));             
          }       
         
        resultSet = st.executeQuery(sql_postname);
        while (resultSet.next()) 
          {
             this.jTextField5.setText(resultSet.getString("v01"));             
          }       
         

        resultSet.close();
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();

    }

    public void setData(int test){
        this.icusnum=test;
    }

    public void UpdateFieldsByLink(){
        if (linkdata==1){        
            /*DIST*/
            this.jTextField6.setText(gdistnum);
            jTextField6.setBackground(Color.CYAN);
            this.jTextField7.setText(gdistdate);
            jTextField7.setBackground(Color.CYAN);
            /*АКТ ОБУЧЕНИЯ*/            
            jTextField8.setBackground(Color.CYAN);            
            jTextField9.setBackground(Color.CYAN);
            /*USBTOKEN*/
            this.jTextField111.setText(gusbtype);
            jTextField111.setBackground(Color.CYAN);
            this.jTextField10.setText(gusbid);
            jTextField10.setBackground(Color.CYAN);
            this.jTextField11.setText(gregdate);
            jTextField11.setBackground(Color.CYAN);
            this.jTextField12.setText(gusbactnum);
            jTextField12.setBackground(Color.CYAN);
            this.jTextField13.setText(gusbactdate);
            jTextField13.setBackground(Color.CYAN);
            this.jTextField110.setText(gusbnum);
            jTextField110.setBackground(Color.CYAN);
            /*OTP/SMS TOKEN*/
            this.jTextField15.setText(gotptype);
            jTextField15.setBackground(Color.CYAN);
            this.jTextField14.setText(gotpid);
            jTextField14.setBackground(Color.CYAN);
            this.jTextField16.setText(gregdate);      //в одном акте с USB
            jTextField16.setBackground(Color.CYAN);
            this.jTextField17.setText(gusbactnum);      //в одном акте с USB
            jTextField17.setBackground(Color.CYAN);
            this.jTextField18.setText(gusbactdate);       //в одном акте с USB
            jTextField18.setBackground(Color.CYAN);
            this.jTextField112.setText(gotpsum);
            jTextField112.setBackground(Color.CYAN);
            try {
                SelectJrnNum(gusbid, gotpid,4);  ///обновим только USB/OTP комбобоксы по журналу
                SetManualJrnNum(3);
            } catch (SQLException e) {
            }
            jComboBox4.setEnabled(false); 
            jComboBox6.setEnabled(false); 
            jComboBox2.setEnabled(false); 
            jComboBox1.setEnabled(false); 


        }else  if (linkdataotp==1){        
            /*OTP/SMS TOKEN*/
            this.jTextField15.setText(gotptype);
            jTextField15.setBackground(Color.CYAN);
            this.jTextField14.setText(gotpid);
            jTextField14.setBackground(Color.CYAN);
            this.jTextField16.setText(gregdate);      //в одном акте с USB
            jTextField16.setBackground(Color.CYAN);
            this.jTextField17.setText(gusbactnum);      //в одном акте с USB
            jTextField17.setBackground(Color.CYAN);
            this.jTextField18.setText(gusbactdate);       //в одном акте с USB
            jTextField18.setBackground(Color.CYAN);
            this.jTextField112.setText(gotpsum);
            jTextField112.setBackground(Color.CYAN);      
            try {
                SelectJrnNum(gusbid, gotpid,2); ///обновим только OTP комбобокс по журналу
                SetManualJrnNum(1);
                SetManualJrnNum(3);
            } catch (SQLException e) {
            }
            jComboBox6.setEnabled(false);   
            jComboBox1.setEnabled(false);
        }else {            
            jTextField6.setBackground(Color.WHITE);
            jTextField7.setBackground(Color.WHITE);
            jTextField8.setBackground(Color.WHITE);
            jTextField9.setBackground(Color.WHITE);
            jTextField111.setBackground(Color.WHITE);
            jTextField10.setBackground(Color.WHITE);
            jTextField11.setBackground(Color.WHITE);
            jTextField12.setBackground(Color.WHITE);
            jTextField13.setBackground(Color.WHITE);
            jTextField110.setBackground(Color.WHITE);
            jTextField15.setBackground(Color.WHITE);
            jTextField14.setBackground(Color.WHITE);
            jTextField16.setBackground(Color.WHITE);
            jTextField17.setBackground(Color.WHITE);
            jTextField18.setBackground(Color.WHITE);
            jTextField112.setBackground(Color.WHITE);
            
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField111.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            jTextField12.setText("");
            jTextField13.setText("");
            jTextField110.setText("");
            jTextField15.setText("");
            jTextField14.setText("");
            jTextField16.setText("");
            jTextField17.setText("");
            jTextField18.setText("");
            jTextField112.setText("");
   
            this.jTextField6.setText(this.sql_idistnum);
            this.jTextField8.setText(this.sql_iprotonum);
            this.jTextField12.setText(this.sql_idsttknnum);
            this.jTextField110.setText(this.sql_itknjnum);
            this.jTextField25.setText(this.sql_idstsgnnum);
            this.jTextField27.setText(this.sql_iprodnum);
            this.jTextField17.setText(this.sql_idsttknnum);
            this.jTextField7.setText(Get_CurrentDate());
            this.jTextField9.setText(Get_CurrentDate());
            this.jTextField11.setText(Get_CurrentDate());
            this.jTextField13.setText(Get_CurrentDate());
            this.jTextField16.setText(Get_CurrentDate());
            this.jTextField18.setText(Get_CurrentDate());
            this.jFormattedTextField1.setText(Get_CurrentDate());
            this.jFormattedTextField2.setText(Get_CurrentDate());
            this.jFormattedTextField3.setText(this.Add_Year(Get_CurrentDate()));
            this.jTextField26.setText(Get_CurrentDate());
            this.jTextField28.setText(Get_CurrentDate());            
            jTextField15.setText("VASCO Digipass Go3");               
            jTextField111.setText("USB-токен iBank 2 Key");            
            jComboBox6.setEnabled(true); 
            jComboBox4.setEnabled(true); 
            jComboBox1.setEnabled(true); 
            jComboBox1.setEnabled(true);
            try {
                SelectJrnNum(gusbid, gotpid,0); ///обновим все комбо боксы "по журналу"                
                SetManualJrnNum(0);
            } catch (SQLException e) {
            }
        }
        
    }

    /*USB OTP выдан ранее*/
    private void jCheckBox1_actionPerformed(ActionEvent e) {
        if (this.jCheckBox1.isSelected()){            
            jList1.setEnabled(false); //Блокируем выбор владельца ключа
            jCheckBox2.setEnabled(false);
            linkdata=0; //Данные по оборудованию не нужно связывать с существующей записью журнала.
            String clinum=jList1.getSelectedValue().toString(); //Номер ФЛ представителя клиента
            DialogInsert3s dialogInsert3 = new DialogInsert3s(this,"",true,this.icusnum, clinum, 1);
            dialogInsert3.setLocationRelativeTo(this);
            dialogInsert3.setVisible(true);
            UpdateFieldsByLink();                        
        }else{
                linkdata=0;
                jList1.setEnabled(true); //Рзблокируем выбор владельца ключа                
                jCheckBox2.setEnabled(true);
                UpdateFieldsByLink();            
            }
        
    }

/*ОТП выдан ранее*/
    private void jCheckBox2_actionPerformed(ActionEvent e) {
        if (this.jCheckBox2.isSelected()){            
            jList1.setEnabled(false); //Блокируем выбор владельца ключа
            jCheckBox1.setEnabled(false);
            linkdataotp=0; //Данные по оборудованию не нужно связывать с существующей записью журнала.
            String clinum=jList1.getSelectedValue().toString(); //Номер ФЛ представителя клиента
            DialogInsert3s dialogInsert3 = new DialogInsert3s(this,"",true,this.icusnum, clinum, 2);
            dialogInsert3.setLocationRelativeTo(this);
            dialogInsert3.setVisible(true);            
            UpdateFieldsByLink();                        
        }else{
                linkdataotp=0;
                jList1.setEnabled(true); //Рзблокируем выбор владельца ключа                
                jCheckBox1.setEnabled(true);
                UpdateFieldsByLink();            
            }
    }
    
    /*Заполняем Комбобоксы журналов*/
    public void FillJrnCombo() throws SQLException {        
        String query1="select nvl(cjnum,'НЕТ ИНФОРМАЦИИ') v01 from xxi.keyarch_jrn  where ijtype_id=1 order by ddate_start ";
        String query2="select nvl(cjnum,'НЕТ ИНФОРМАЦИИ') v01 from xxi.keyarch_jrn  where ijtype_id=2 order by ddate_start ";        
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);        
        
        jComboBox4.removeAllItems(); //чистим бокс
        jComboBox5.removeAllItems(); //чистим бокс
        jComboBox6.removeAllItems(); //чистим бокс
        
        //журнал МНИ
        while (rs.next()) 
          {             
             jComboBox4.addItem(rs.getString("v01"));
             jComboBox6.addItem(rs.getString("v01"));
          }     
                
        //журнал СКЗИ
        rs = st.executeQuery(query2);
        while (rs.next()) 
          {
             jComboBox5.addItem(rs.getString("v01"));
          }    
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();   
        
        if (jComboBox4.getItemCount()>0){
            jComboBox4.setSelectedIndex(jComboBox4.getItemCount()-1);
        }
        if (jComboBox5.getItemCount()>0){
            jComboBox5.setSelectedIndex(jComboBox5.getItemCount()-1);
        }
        if (jComboBox6.getItemCount()>0){
            jComboBox6.setSelectedIndex(jComboBox6.getItemCount()-1);
        }
    }


    /*Поставить самый актуальный журнал в форме*/
    public void SetManualJrnNum(int selection){
        //selection = 0,1,2,3,4 (какие комбо боксы обновлять 1,2 = МНИ usb и otp,3 = СКЗИ  0=все 4= только OTP/USB
        if((selection!=1)&&(selection!=2)&&(selection!=3)&&(selection!=4)){
            selection = 0;          
        }
        
        if (selection==1){
            if (jComboBox4.getItemCount()>0){
                jComboBox4.setSelectedIndex(jComboBox4.getItemCount()-1);
            }
        }else if (selection==2){
            if (jComboBox6.getItemCount()>0){
                jComboBox6.setSelectedIndex(jComboBox6.getItemCount()-1);
            }                      
        }if (selection==3){
            if (jComboBox5.getItemCount()>0){
                jComboBox5.setSelectedIndex(jComboBox5.getItemCount()-1);
            }
        }else if (selection==0){
             if (jComboBox4.getItemCount()>0){
                 jComboBox4.setSelectedIndex(jComboBox4.getItemCount()-1);
             }
             if (jComboBox5.getItemCount()>0){
                 jComboBox5.setSelectedIndex(jComboBox5.getItemCount()-1);
             }
             if (jComboBox6.getItemCount()>0){
                 jComboBox6.setSelectedIndex(jComboBox6.getItemCount()-1);
             }
         }else if (selection==4){
             if (jComboBox4.getItemCount()>0){
                 jComboBox4.setSelectedIndex(jComboBox4.getItemCount()-1);
             }
             if (jComboBox6.getItemCount()>0){
                 jComboBox6.setSelectedIndex(jComboBox6.getItemCount()-1);
             }             
         }
    }
    

    /*Вычислитель номеров журналов для комбобокса*/
    public void SelectJrnNum(String ctknid, String ccnfrmid, int selection) throws SQLException {
        //selection = 0,1,2,3,4 (какие комбо боксы обновлять 1,2 = МНИ usb и otp,3 = СКЗИ  0=все 4= только OTP/USB
        if((selection!=1)&&(selection!=2)&&(selection!=3)&&(selection!=4)){
            selection = 0;          
        }
        String query1="select\n" + 
        "   ijrnki  v01 \n" + 
        "   ,ijrnkiotp  v02 \n" + 
        "   ,ijrnkidist  v03 \n" +                       
        "   ,ijrnkc  v04 \n" + 
        "   ,ccnfrmid v05 \n" + 
        "   ,ctknid v06 \n" + 
        "from xxi.key_info i,xxi.key_cert c \n" + 
        "where i.ikeynum=c.iceynum \n" + 
        "and (ctknid like '"+ctknid +"' and ccnfrmid like '"+ccnfrmid+"')";        
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);            
        
        while (rs.next()) 
          {
            if (selection==1){
                jComboBox4.setSelectedItem(rs.getString("v01"));  
            }else if (selection==2){
                jComboBox6.setSelectedItem(rs.getString("v02"));                         
            }if (selection==3){
                jComboBox5.setSelectedItem(rs.getString("v04"));
            }else if (selection==0){
                jComboBox4.setSelectedItem(rs.getString("v01"));   
                jComboBox6.setSelectedItem(rs.getString("v02"));
                jComboBox5.setSelectedItem(rs.getString("v04"));
             }else if (selection==4){
                 jComboBox4.setSelectedItem(rs.getString("v01"));   
                 jComboBox6.setSelectedItem(rs.getString("v02"));
             }
          }     
                
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();        
    }
    
    private void jComboBox1_actionPerformed(ActionEvent e) {
        if (jComboBox1.getItemCount()>0){
            jTextField14.setText(jComboBox1.getSelectedItem().toString());
        }
    }

    private void jComboBox2_actionPerformed(ActionEvent e) {
        if (jComboBox2.getItemCount()>0){
            jTextField10.setText(jComboBox2.getSelectedItem().toString());
        }
    }

    private void jList2_valueChanged(ListSelectionEvent e) {
        list2changed=true;
    }

    private void jComboBox3_actionPerformed(ActionEvent e) {        
        jComboBox3.setToolTipText(jComboBox3.getSelectedItem().toString());
        jLabel28.setText(jComboBox3.getSelectedItem().toString());
        this.combobox3changed=true; //фиксируем факт того что комбо боксом пользовались
    }

    private void jComboBox4_actionPerformed(ActionEvent e) {
        if (jComboBox4.getItemCount()>0){
            jComboBox4.setToolTipText(jComboBox4.getSelectedItem().toString());            
        }
    }

    private void jComboBox5_actionPerformed(ActionEvent e) {
        if (jComboBox5.getItemCount()>0){
            jComboBox5.setToolTipText(jComboBox5.getSelectedItem().toString());            
        }
    }
}
