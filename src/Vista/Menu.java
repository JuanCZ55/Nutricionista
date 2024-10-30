/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        jDesktopPane1.setBorder(new ImagenFondo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        JDPMenu = new javax.swing.JDesktopPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMIngreso = new javax.swing.JMenu();
        jMIPaciente = new javax.swing.JMenuItem();
        jMiDieta = new javax.swing.JMenuItem();
        jMIMenuDiario = new javax.swing.JMenuItem();
        jMIComidas = new javax.swing.JMenuItem();
        jMIIngredientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMIListaPacientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMCuantoFalta = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        JDPMenu.setLayer(jDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDPMenuLayout = new javax.swing.GroupLayout(JDPMenu);
        JDPMenu.setLayout(JDPMenuLayout);
        JDPMenuLayout.setHorizontalGroup(
            JDPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        JDPMenuLayout.setVerticalGroup(
            JDPMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDPMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1))
        );

        jMIngreso.setText("Ingresos");

        jMIPaciente.setText("Pacientes");
        jMIPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPacienteActionPerformed(evt);
            }
        });
        jMIngreso.add(jMIPaciente);

        jMiDieta.setText("Dieta");
        jMiDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiDietaActionPerformed(evt);
            }
        });
        jMIngreso.add(jMiDieta);

        jMIMenuDiario.setText("MenuDiario");
        jMIngreso.add(jMIMenuDiario);

        jMIComidas.setText("Comidas");
        jMIngreso.add(jMIComidas);

        jMIIngredientes.setText("Ingredientes");
        jMIIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIngredientesActionPerformed(evt);
            }
        });
        jMIngreso.add(jMIIngredientes);

        jMenuBar1.add(jMIngreso);

        jMenu2.setText("Listas");

        jMIListaPacientes.setText("Lista de Pacientes");
        jMIListaPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIListaPacientesActionPerformed(evt);
            }
        });
        jMenu2.add(jMIListaPacientes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Menu3");

        jMenuItem5.setText("jMenuItem5");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Adicionales.");

        jMenuItem1.setText("IMC");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMCuantoFalta.setText("Cuanto Falta");
        jMCuantoFalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCuantoFaltaActionPerformed(evt);
            }
        });
        jMenu1.add(jMCuantoFalta);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPMenu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPacienteActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        GestionarPaciente paciente = new GestionarPaciente();
        JDPMenu.add(paciente);
        paciente.setVisible(true);
    }//GEN-LAST:event_jMIPacienteActionPerformed

    private void jMIIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIIngredientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMIIngredientesActionPerformed

    private void jMIListaPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIListaPacientesActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        ListaPacientes listP = new ListaPacientes();
        JDPMenu.add(listP);
        listP.setVisible(true);
    }//GEN-LAST:event_jMIListaPacientesActionPerformed

    private void jMiDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiDietaActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        Dieta listP = new Dieta();
        JDPMenu.add(listP);
        listP.setVisible(true);
    }//GEN-LAST:event_jMiDietaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        IMC imc = new IMC();
        JDPMenu.add(imc);
        imc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMCuantoFaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCuantoFaltaActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        CuantoPesoFalta cpf = new CuantoPesoFalta();
        JDPMenu.add(cpf);
        cpf.setVisible(true);
    }//GEN-LAST:event_jMCuantoFaltaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDPMenu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMCuantoFalta;
    private javax.swing.JMenuItem jMIComidas;
    private javax.swing.JMenuItem jMIIngredientes;
    private javax.swing.JMenuItem jMIListaPacientes;
    private javax.swing.JMenuItem jMIMenuDiario;
    private javax.swing.JMenuItem jMIPaciente;
    private javax.swing.JMenu jMIngreso;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMiDieta;
    // End of variables declaration//GEN-END:variables
}
