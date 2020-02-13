
package client;

import java.awt.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Galutvo
 */
public class DialogJrn extends java.awt.Dialog {
    private TableRowSorter<TableModel> sorter;
    private int recnum=-1;  
    /** Creates new form DialogJrn */
    public DialogJrn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        //jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event){
                 //System.out.println("event...");
                if(jTable1.getSelectedRow() != -1){  
                 recnum = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
                 jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()+" "
                                     +jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()+" "
                                     +jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()+" "
                                     +jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
              }
                }});
        ClearAndRefillTable();
        try {
            if (getUser().compareTo("GTG") == 0) {
                this.jButton2.setEnabled(true);
            }
        } catch (SQLException e) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setTitle("���������� ��������");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setEditable(false);
        jTextField1.setText("������ �� ������");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("������� ������:");

        jButton1.setText("������� ������");
        jButton1.setToolTipText("�������� ����� ������ � ����������");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("�������");
        jButton2.setToolTipText("������� ������ �� ����������� (������ ��� ��������������)");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(3, 3, 3))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("������������������ �������:");
        jPanel2.add(jLabel1);

        add(jPanel2, java.awt.BorderLayout.NORTH);

        jButton3.setText("�������");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    setVisible(false);
    dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DialogJrnAdd dialogjrnadd = new DialogJrnAdd(this,true);
        dialogjrnadd.setVisible(true);  
        this.ClearAndRefillTable();
    }//GEN-LAST:event_jButton1ActionPerformed

/*�������� ������*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(jTable1.getSelectedRow() < 0){
        JOptionPane.showMessageDialog(this, "������ ��� �������� �� ������ � �������!", "������!", JOptionPane.WARNING_MESSAGE);        
    }else{
        int dialogResult = JOptionPane.showConfirmDialog (null, "������ "+jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()+" "+jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()
                                                                +"\n����������� �������� ���������� �������?","��������!",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(jTable1.getSelectedRow() != -1){
                    try {
                        int dialogResult2 = JOptionPane.showConfirmDialog (null, "�� �������?","��������!",JOptionPane.YES_NO_OPTION);
                        if(dialogResult2 == JOptionPane.YES_OPTION){
                            /*�������� ��� iid ������������ �� ������ � �������*/
                            if (isJrnUsed(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString())){
                                JOptionPane.showMessageDialog(this, "������ ������ �������� ��������, �������� ���������.", "������!", JOptionPane.WARNING_MESSAGE);                                
                            }else{
                                DropJrn((jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                            }                                                           
                        }
                    } catch (SQLException e) {
                    }
            }else{
                    JOptionPane.showMessageDialog(this, "������ ��� �������� �� ������ � �������!", "������!", JOptionPane.WARNING_MESSAGE);
                }      
            this.ClearAndRefillTable();        
    }    
    }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogJrn dialog = new DialogJrn(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void ClearAndRefillTable(){
        /*������� �������*/
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
        setColumnsWidth(jTable1);                
    }

    public void refilltable(JTable table) throws SQLException {        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }      
        
        try {        
        Connection con = FrameLogon.mainpool.OpenConnection();  //.gconn; //DriverManager.getConnection(get_dbconndata(1), get_dbconndata(2), get_dbconndata(3));        
        
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select " +             
            "iid v01" + 
            ",(select cjtype_short from xxi.keyarch_jrntype t where t.iid=j.ijtype_id) v02" + 
            ",cjnum v03" + 
            ",nvl(to_char(ddate_start,'RRRR.MM.DD'),'NULL') v04" + 
            ",nvl(to_char(ddate_end,'RRRR.MM.DD'),'NULL') v05 " +             
            "from xxi.keyarch_jrn j order by iid");
            table.setModel(buildTableModel(rs));            
            rs.close();            

        st.close();
        con.close(); 
        con = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        FrameLogon.mainpool.Close();
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        String[] ColNames = {
                                "� �.�."                                
                                ,"��� �������      "
                                ,"� �������"
                                ,"������. � "
                                ,"������. ��"
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


    /*������ ������� �� ������ �������� �������*/
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
    
    //������� ��� �������������� ������ �������� �������
    public static void Set_Column_Render(JTable table){
        //����� ������� ��� ������� table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
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
    
    /*������� ������������ �������*/
    public String getUser() throws SQLException {        
        String query="select user v01 from dual";
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        String res="";
        
        while (rs.next()) 
          {
             res=rs.getString("v01");
          }
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();     
        return res;
    }
   
    /*����������� �������� ������� - ��������*/
                                    // ��� ������� �� ������� ����������� (id)
    public boolean isJrnUsed(String jrnid) throws SQLException {        
        String query="select count(*) v01 from xxi.key_info i,xxi.key_cert c where i.ikeynum=c.iceynum and " +
            "(ijrnki like (select cjnum from xxi.keyarch_jrn where iid="+jrnid+") " +
            "or ijrnkiotp like (select cjnum from xxi.keyarch_jrn where iid="+jrnid+") " +
            "or ijrnkidist like (select cjnum from xxi.keyarch_jrn where iid="+jrnid+")" +
            "or ijrnkc like (select cjnum from xxi.keyarch_jrn where iid="+jrnid+"))";
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        String res="0";
        
        while (rs.next()) 
          {
             res=rs.getString("v01");
          }
                
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();     

        if(Integer.parseInt(res)>0){
            return true;                  //�� - ������ ��� ������������ � ������� - ������� ������
        }
        return false;
    }
   
   /*�������� ������*/
    public void DropJrn(String iid) throws SQLException {        
        String query="delete from xxi.keyarch_jrn where iid="+iid;
        Connection con = FrameLogon.mainpool.OpenConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);
        
        st.close();
        con.close(); 
        con = null;
        FrameLogon.mainpool.Close();             
    }
}
