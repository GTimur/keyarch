package client;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class Frame1_AboutBoxPanel1 extends JPanel {
    private JLabel labelTitle = new JLabel();
    private Border border = BorderFactory.createEtchedBorder();
    private XYLayout xYLayout1 = new XYLayout();
    private String VERSION_BANNER=keyarch.VERSION_BANNER;
    private JLabel jLabel1 = new JLabel();

    public Frame1_AboutBoxPanel1() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    private void jbInit() throws Exception {
        this.setLayout(xYLayout1);
        this.setBorder( border );
        labelTitle.setText( VERSION_BANNER );
        labelTitle.setFont(new Font("Tahoma", 1, 13));
        jLabel1.setText("\u041e\u0442\u0434\u0435\u043b \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0437\u0430\u0446\u0438\u0438 \u0438 \u0441\u0432\u044f\u0437\u0438");
        this.add(jLabel1, new XYConstraints(123, 28, 160, 15));
        this.add(labelTitle, new XYConstraints(3, 8, 355, 15));
    }
}
