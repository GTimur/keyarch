package client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DialogSZSelect extends JDialog {    
    private int icusnum=-1; 
    private JScrollPane jscrollpane_cli = new JScrollPane();
    private JTable jTable1_cli = new JTable();
    private JLabel jLabel1 = new JLabel();
    public String objectName;
    public String objectType;
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private TableRowSorter<TableModel> sorter;
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField3 = new JTextField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();

    public DialogSZSelect(DialogSZGive parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
            //this.setLocation(parent.getWidth()/2 - this.getWidth()/2, parent.getHeight()/2 - this.getHeight()/2);            
            this.setLocationRelativeTo(parent);            
            this.setResizable(false);
            //System.out.println("%f",parent.get.getWidth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DialogSZSelect() {
    }

    private void jbInit() throws Exception {
        jTable1_cli = new JTable(new DefaultTableModel()); //new JTable(myModel());        
        jscrollpane_cli = new JScrollPane(jTable1_cli);
        this.setSize(new Dimension(758, 480));
        this.getContentPane().setLayout( null );
        this.setTitle("Добавить в журнал данные по клиенту ");
        this.setModal(true);
        jscrollpane_cli.setBounds(new Rectangle(10, 70, 725, 270));
        jscrollpane_cli.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTable1_cli.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jLabel1.setText("Быстрый поиск:");
        jLabel1.setBounds(new Rectangle(10, 45, 100, 15));
        jLabel1.setFont(new Font("Tahoma", 0, 12));
        jTextField1.setBounds(new Rectangle(115, 45, 620, 20));
        jTextField2.setBounds(new Rectangle(95, 375, 640, 20));
        jTextField2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField2.setEditable(false);
        jLabel2.setText("Выберите клиента");
        jLabel2.setBounds(new Rectangle(10, 0, 535, 45));
        jLabel2.setFont(new Font("Arial", 0, 18));
        jLabel3.setText("Клиент для регистрации:");
        jLabel3.setBounds(new Rectangle(10, 350, 155, 15));
        jLabel3.setFont(new Font("Tahoma", 0, 12));
        jTextField3.setBounds(new Rectangle(10, 375, 80, 20));
        jTextField3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField3.setEditable(false);
        jButton1.setText("Далее");
        jButton1.setBounds(new Rectangle(570, 410, 75, 25));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Отмена");
        jButton2.setBounds(new Rectangle(660, 410, 75, 25));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jTextField3, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel1, null);
        jscrollpane_cli.getViewport().add(jTable1_cli, null);
        this.getContentPane().add(jscrollpane_cli, null);
        this.refilltable(jTable1_cli);
        sorter = new TableRowSorter<TableModel>(this.jTable1_cli.getModel());
        jTable1_cli.setRowSorter(sorter);        
        jTable1_cli.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        jTable1_cli.setSize(new Dimension(450, 400));
        jTable1_cli.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event){
                 //System.out.println("event...");
                if(jTable1_cli.getSelectedRow() != -1){                             
                 jTextField2.setText(jTable1_cli.getValueAt(jTable1_cli.getSelectedRow(), 1).toString());
                 jTextField3.setText(jTable1_cli.getValueAt(jTable1_cli.getSelectedRow(), 0).toString());
              }
                }});
        jTextField1.setToolTipText("Поиск в таблице по ключевому слову");
        jTextField1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jTextField1.addActionListener(new ActionListener(){                
                public void actionPerformed(ActionEvent e) {
                    String text = jTextField1.getText().toUpperCase();                    
                     if (text.length() == 0) {                      
                       sorter.setRowFilter(null);                         
                     } else {
                       sorter.setRowFilter(RowFilter.regexFilter(text));                          
                     }                    
                }});
       // this.Set_Column_Size(jTable1_cli, 0, 30);
       // this.Set_Column_Size(jTable1_cli, 1, 675);
       //Set_Column_Render(jTable1_cli);
       
       setColumnsWidth(jTable1_cli);   
    }
    
   
    /*ОТМЕНА*/
    private void jButton2_actionPerformed(ActionEvent e) {
        this.dispose();
    }


    /*ДАЛЕЕ*/
    private void jButton1_actionPerformed(ActionEvent e) {
        
        String client=this.jTextField3.getText();
        if (!client.isEmpty()){
            String short_name=jTable1_cli.getValueAt(jTable1_cli.getSelectedRow(), 2).toString();
            int client_number=Integer.parseInt(this.jTextField3.getText());    
            //DialogSZ dialog = new DialogSZ(this,"",true,client_number, short_name);
            //dialog .setLocationRelativeTo(this);
            //DialogInsert2.show(true);
            //dialog .setVisible(true);            
            DialogSZGive.icusnum=client_number;
            this.dispose();            
        }else{
            JOptionPane.showMessageDialog(this, "Не указан клиент для регистрации.", "Предупреждение!", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void refilltable(JTable table) throws SQLException {
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }        
                
        Connection con = FrameLogon.mainpool.OpenConnection();  //.gconn; //DriverManager.getConnection(get_dbconndata(1), get_dbconndata(2), get_dbconndata(3));
        
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select icusnum,upper(ccusname),upper(ccusname_sh) from xxi.cus,xxi.gcs where igcscat = 15 and igcsnum in (2,4) and igcscus=icusnum and icusnum in (select igcscus from xxi.gcs where igcscat=64 and igcsnum=1) union \n" + 
            "select icusnum,upper(ccusname),upper(ccusname_sh) from xxi.cus where icusnum=0");
            table.setModel(buildTableModel(rs));            
            rs.close();
                       
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        String[] ColNames = {
                                "№    "                               
                                ,"Наименование клиента                                                                                                                          "
                                ,"Краткое наименование клиента"
                                
                             };
        // names of columns
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
              public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
              }
            };
        
        return (DefaultTableModel) resmodel;
    }
    
    
    /*Формат таблицы по ширине названия столбца*/
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
    
    
    public static void Set_Column_Size(JTable table,int column_number, int size){
        TableColumn column = null;
        column = table.getColumnModel().getColumn(column_number);
        column.setMaxWidth(size);           
        column.setPreferredWidth(size);
        }

    public static void Set_Column_Name(JTable table,int column_number, String column_name){
        TableColumn column = null;
        column = table.getColumnModel().getColumn(column_number);
        column.setHeaderValue(column_name);        
        }

    //Функция для форматирования ширины столбцов таблицы
    public static void Set_Column_Render(JTable table){
        //Нужно указать для объекта table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        for (int column = 0; column < table.getColumnCount(); column++)
        {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
         
            for (int row = 0; row < table.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
         
                //  We've exceeded the maximum width, no need to check other rows
         
                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }         
            tableColumn.setPreferredWidth( preferredWidth );
        }
    }
}

