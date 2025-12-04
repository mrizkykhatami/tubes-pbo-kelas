package view.layout.main;

import view.component.DefaultForm;
import view.component.KategoriForm;
import view.component.SupplierForm;
import view.component.HomeForm;
import java.awt.Component;
import view.layout.menu.MenuEvent;
import model.User;
import view.component.UserForm;
import view.component.ProdukForm;


/**
 *
 * @author view.layout
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainMenu() {
        initComponents();
        
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new HomeForm());
                } 
                else if(index == 1 && subIndex == 1){
                    showForm(new ProdukForm()); // ganti panel
                }
                else if(index == 1 && subIndex == 2){
                    showForm(new DefaultForm("Master 2")); // ganti panel
                }
                else if(index == 1 && subIndex == 3){
                    showForm(new DefaultForm("Master 3")); // ganti panel
                }
                else if(index == 1 && subIndex == 4){
                    showForm(new UserForm()); // ganti panel
                }
                else if(index == 2 && subIndex == 1){
                    showForm(new DefaultForm("Transaksi 1")); // ganti panel
                }
                else if(index == 2 && subIndex == 2){
                    showForm(new DefaultForm("Transaksi 2")); // ganti panel
                }
                else if(index == 3 && subIndex == 1){
                    showForm(new DefaultForm("Laporan 1")); // ganti panel
                }
                else if(index == 3 && subIndex == 2){
                    showForm(new DefaultForm("Laporan 2")); // ganti panel
                }
                else if(index == 3 && subIndex == 3){
                    showForm(new DefaultForm("Laporan 3")); // ganti panel
                }
                
                else {
                     showForm(new DefaultForm("Form : " + index + " " + subIndex));
                }
            }
        });
    }
    
    public MainMenu(User user) {
        initComponents();
        header1.setNamaUserLabel(user.getNamaUser());
        menu1.setRole(user.getRole()); 
        
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0) {
                    showForm(new HomeForm());
                } 
                else if(index == 1 && subIndex == 1){
                    showForm(new ProdukForm()); // ganti panel
                }
                else if(index == 1 && subIndex == 2){
                    showForm(new SupplierForm()); // ganti panel
                }
                else if(index == 1 && subIndex == 3){
                    showForm(new KategoriForm()); // ganti panel
                }
                else if(index == 1 && subIndex == 4){
                    showForm(new UserForm()); // ganti panel
                }
                else if(index == 2 && subIndex == 1){
                    showForm(new DefaultForm("Transaksi 1")); // ganti panel
                }
                else if(index == 2 && subIndex == 2){
                    showForm(new DefaultForm("Transaksi 2")); // ganti panel
                }
                else if(index == 3 && subIndex == 1){
                    showForm(new DefaultForm("Laporan 1")); // ganti panel
                }
                else if(index == 3 && subIndex == 2){
                    showForm(new DefaultForm("Laporan 2")); // ganti panel
                }
                else if(index == 3 && subIndex == 3){
                    showForm(new DefaultForm("Laporan 3")); // ganti panel
                }
                
                else {
                     showForm(new DefaultForm("Form : " + index + " " + subIndex));
                }
            }
        });
    }

    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin111 = new view.layout.scroll.win11.ScrollPaneWin11();
        menu1 = new view.layout.menu.Menu();
        header1 = new view.component.Header();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(21, 110, 71));

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setViewportView(menu1);

        body.setBackground(new java.awt.Color(245, 245, 245));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showForm(new DefaultForm("Tampilan Default atau Awal Masuk"));
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private view.component.Header header1;
    private javax.swing.JPanel jPanel1;
    private view.layout.menu.Menu menu1;
    private view.layout.scroll.win11.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
