package client;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import oracle.jdeveloper.layout.VerticalFlowLayout;
import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class DialogDeleteRecord extends JDialog {
    private boolean confirm=false; //для включения кнопки
    private boolean datechanged=false;
    private int icusnum;
    private int ikeynum;

    private String full_name=new String();
    private JButton jButton1 = new JButton();
    private JTextPane jTextPane1 = new JTextPane();
    private JTextPane jTextPane2 = new JTextPane();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JLabel jLabel1 = new JLabel();
    private JFormattedTextField jFormattedTextField1 =
        new JFormattedTextField();
    private JButton jButton2 = new JButton();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField2 = new JTextField();
    private JLabel jLabel4 = new JLabel();
    private JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
    private JPanel jPanel1 = new JPanel();
    private XYLayout xYLayout1 = new XYLayout();

    public DialogDeleteRecord() {
        this(null, "", false, -1,-1,null);
    }

    public DialogDeleteRecord(Frame parent, String title, boolean modal, int icusnum, int ikeynum, String full_name) {
        super(parent, title, modal);
        
        this.icusnum=icusnum;
        this.full_name=full_name;
        this.ikeynum=ikeynum;        
        try {
            jbInit();
            this.setLocationRelativeTo(parent);
            this.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(610, 412));
        this.getContentPane().setLayout( null );
        this.setTitle("Удаление записи журнала");
        this.setModal(true);
        jButton1.setText("Закрыть");
        jButton1.setBounds(new Rectangle(505, 350, 80, 25));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jScrollPane1.getViewport().add(jTextPane1, null);
        jPanel1.setBounds(new Rectangle(0, 265, 600, 80));
        jPanel1.setLayout(xYLayout1);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Акт уничтожения ключа ЭП"));
        jPanel1.add(jLabel2, new XYConstraints(5, 31, 85, 15));
        jPanel1.add(jLabel3, new XYConstraints(5, 1, 140, 15));
        jPanel1.add(jTextField2, new XYConstraints(140, 1, 75, 20));
        jPanel1.add(jLabel4, new XYConstraints(350, 1, 155, 15));
        jPanel1.add(jFormattedTextField2, new XYConstraints(500, 1, 80, 20));
        jPanel1.add(jTextField1, new XYConstraints(90, 31, 490, 20));
        this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jFormattedTextField1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jButton1, null);
        jTextPane1.setContentType("text/html");
        jTextPane1.setText(GenHtmlMessage(this.ikeynum));
        jTextPane1.setEditable(false);
        jScrollPane1.setBounds(new Rectangle(0, 0, 600, 260));
        jLabel1.setText("Для уничтожения укажите номер клиента:");
        jLabel1.setBounds(new Rectangle(5, 355, 320, 15));
        jLabel1.setFont(new Font("Tahoma", 1, 12));
        jFormattedTextField1.setBounds(new Rectangle(280, 350, 65, 25));
        jFormattedTextField1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jFormattedTextField1.setBackground(new Color(214, 231, 255));
        jButton2.setText("Уничтожение");
        jButton2.setBounds(new Rectangle(385, 350, 105, 25));
        jButton2.setEnabled(false);
       /* MaskFormatter cusnumformat = new MaskFormatter();
        try {
            cusnumformat = new MaskFormatter("#####");
        } catch (ParseException e) {
        }
        cusnumformat.install(jFormattedTextField1);*/
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jLabel2.setText("Примечание:");
        jLabel2.setFont(new Font("Tahoma", 0, 13));
        jTextField1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel3.setText("№ акта уничтожения:");
        jLabel3.setFont(new Font("Tahoma", 0, 13));
        jTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jLabel4.setText("Дата акта уничтожения:");
        jLabel4.setFont(new Font("Tahoma", 0, 13));
        jFormattedTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        jFormattedTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFormattedTextField2_actionPerformed(e);
            }
        });
        jFormattedTextField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                jFormattedTextField2_keyPressed(e);
            }
        });
        jFormattedTextField1.addActionListener(new ActionListener(){                
                public void actionPerformed(ActionEvent e) {
             String text = jFormattedTextField1.getText();
             if (text.matches("[0-9]+")) {
                 if (Integer.parseInt(text) == icusnum) {                      
                   confirm=true;
                   jButton2.setEnabled(true);
                 } else {
                   confirm=false;
                   jButton2.setEnabled(false);
                 }
             }else{//text.matches("[0-9]+"
                 jFormattedTextField1.setText("");
                 jButton2.setEnabled(false);
             } }});
        
        InitEditObjects();        
    }
    
    public String GenHtmlMessage(int ikeynumm) throws SQLException
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String html_text = new String();        
        String sql="select "+
                "c.ckeyid," + 
                "cfacename1||' '||cfacename2||' '||cfacename3 as cfacename," + 
                "cfacepost," + 
                "to_char(c.dregdate,'DD.MM.RRRR') as dregdate," + 
                "to_char(c.dstartd,'DD.MM.RRRR') as dstartd," + 
                "to_char(c.dendd,'DD.MM.RRRR') as dendd," + 
                "c.csigngrp " +         
                "from xxi.key_info i,xxi.key_cert c " + 
                "where ikeynum=iceynum " + 
                "and ikeynum="+Integer.toString(ikeynumm);
        //System.out.println(sql);
        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        
        while (rs.next())
          {            
             html_text="<html><head><style>h2 {" + 
             "    font-family: Verdana, Arial, Helvetica, sans-serif;  " + 
             "    font-size: 14pt;  } " + 
             "   p {" + 
             "    font-family: Verdana, Arial, Helvetica, sans-serif; " + 
             "    font-size: 12pt;  " + 
             "   }" + 
             "  </style></head><body bgcolor=\"#D2D2D2\"><h2>Удаление записи журнала</h2>\n" + 
                      "<p><strong>Клиент: </strong>"+Integer.toString(icusnum)+" - "+full_name+"</p>\n" + 
                      "<p><strong>ID ключа ЭП: </strong>"+rs.getString("ckeyid")+"</p>\n" + 
                      "<p><strong>Владелец: </strong>"+rs.getString("cfacename")+" - "+rs.getString("cfacepost")+"</p>\n" + 
                      "<p><strong>Дата начала действия: </strong>"+rs.getString("dstartd")+"</p>\n" +                       
                      "<p><strong>Дата окончания действия: </strong>"+rs.getString("dendd")+"</p>" +
                      "<p><strong>Группа подписи: </strong>"+rs.getString("csigngrp")+
                      "</body></html>";
              //System.out.println(html_text);
          }                       
        rs.close();
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();        
        return (html_text);
    } 
    
    
    public String GetCurrentActNum() throws SQLException
    {
        String res = new String();        
        String sql="select nvl(max(iwipenum),0)+1 v01 from xxi.key_info where dwiped>=trunc(sysdate,'YY' )";//берем последний номер+1 за текущий год            
        
        //System.out.println(sql);
        
        Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        
        while (rs.next())
          {            
             res=rs.getString("v01");
          }                       
        rs.close();
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();        
        return (res);
    } 
  

    public String Get_CurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");  //"yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String curdate = sdf.format(date);        
        return curdate;
    }
    
    public void InitEditObjects(){
        MaskFormatter datemask1 = new MaskFormatter();
        try {
            datemask1 = new MaskFormatter("##.##.####");
        } catch (ParseException e) {
        }
        datemask1.install(this.jFormattedTextField2);
        this.jFormattedTextField2.setText(this.Get_CurrentDate());
        try {
            this.jTextField2.setText(GetCurrentActNum());
        } catch (SQLException e) {
        }
    }
    
    /*проверка строки на шаблон даты ДД.ММ.ГГГГ*/
    boolean validateDate(String date, String pattern) throws ParseException {
        String regex = pattern.replaceAll("\\w", "\\\\d").replace(".", "\\.");
        if (!date.matches(regex)) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



    public void MarkCertDeleted() throws Exception {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
             
             ///'DD.MM.RRRR HH24:MI:SS'          
            String keycertupd_sql="update xxi.key_cert " + 
                                  "set iwipenum=" + jTextField2.getText() +
                                  ", dwiped=to_date('"+jFormattedTextField2.getText()+"','DD.MM.RRRR') " + 
                                  ", ccomment='"+jTextField1.getText()+"'" + 
                                  ", istate=2" + 
                                  "where iceynum="+Integer.toString(this.ikeynum);
            
            String keyinfoupd_sql="update xxi.key_info " + 
                                  "set iwipenum=" + jTextField2.getText() +
                                  ", dwiped=to_date('"+jFormattedTextField2.getText()+"','DD.MM.RRRR') " +                                                                                                       
                                  "where ikeynum="+Integer.toString(this.ikeynum);
            
            Connection con = FrameLogon.mainpool.OpenConnection(); //DriverManager.getConnection(Frame1.get_dbconndata(1), Frame1.get_dbconndata(2), Frame1.get_dbconndata(3));
            Statement st = con.createStatement();
            
            //System.out.println("DIAG wipecert:"+keycertupd_sql+"\n"+keyinfoupd_sql);
            st.executeUpdate(keycertupd_sql);
            //con.commit();
            st.executeUpdate(keyinfoupd_sql);
            //con.commit();                        
            st.close();
            con.close(); 
            con = null;
            FrameLogon.mainpool.Close();
        }

    
    private void jButton1_actionPerformed(ActionEvent e) {
        this.dispose();
    }

    private int jButton2_actionPerformed(ActionEvent e) {        
        boolean datecheck=false;
        try {
            datecheck = validateDate(this.jFormattedTextField2.getText(),"dd.MM.yyyy");
        } catch (ParseException f) {
        }
        
        if (!datechanged){
            int dialog1 = JOptionPane.showConfirmDialog (null, "Дата акта не изменялась, оставить текущую дату?","Внимание!",JOptionPane.YES_NO_OPTION);
            if(dialog1 == JOptionPane.NO_OPTION){
                return 1;
            }            
        }
        
        if(this.jTextField2.getText().length()==0){
           JOptionPane.showMessageDialog(this, "Не заполнено поле № акта уничтожения.", "Предупреждение!", JOptionPane.WARNING_MESSAGE);
           return 1;
        } else if (datecheck==false) {
            JOptionPane.showMessageDialog(this, "Не заполнено поле Дата акта уничтожения.", "Предупреждение!", JOptionPane.WARNING_MESSAGE);   
            return 1;
        } else {
            try {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Пометить сертификат клиента как уничтоженный?","Внимание!",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    MarkCertDeleted();
                    this.dispose();
                }
            } catch (Exception f) {
                System.out.println(f.getMessage());
            }
        }
        return 0;      
    }

    private void jFormattedTextField2_actionPerformed(ActionEvent e) {
        this.datechanged=true;
    }

    private void jFormattedTextField2_keyPressed(KeyEvent e) {
        this.datechanged=true;
    }
}
