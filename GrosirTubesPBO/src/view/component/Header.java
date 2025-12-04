package view.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author RAVEN
 */
public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setPaint(new GradientPaint(0, 0, new Color(14, 76, 49), 0, getHeight(), new Color(21, 110, 71)));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        namaUserLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(237, 237, 237));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/component/logo.png"))); // NOI18N
        jLabel1.setText("Grosir Mamah Hamzah");

        logoutButton.setBackground(new java.awt.Color(255, 0, 51));
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        namaUserLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        namaUserLabel.setForeground(new java.awt.Color(255, 255, 255));
        namaUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        namaUserLabel.setText("nama_user");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(namaUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(logoutButton)
                    .addComponent(namaUserLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Anda yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window instanceof JFrame) {
                window.dispose();
            }
            LoginFrame landing = new LoginFrame();
            landing.setLocationRelativeTo(null);
            landing.setVisible(true);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    public void setNamaUserLabel(String nama){
        namaUserLabel.setText("Hallo, " + nama);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel namaUserLabel;
    // End of variables declaration//GEN-END:variables
}
