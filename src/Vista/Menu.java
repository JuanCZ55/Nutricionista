/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

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
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        //this.setSize(900, 700);8
        //this.setResizable(false);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMCuantoFalta = new javax.swing.JMenuItem();
        jMIListaPacientes = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMiDieta = new javax.swing.JMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMIMenuDiario = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMIComidas = new javax.swing.JMenuItem();
        jMiListarComidas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMIIngredientes = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
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
            .addComponent(jDesktopPane1)
        );

        jMIngreso.setText("Paciente");

        jMIPaciente.setText("Pacientes");
        jMIPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPacienteActionPerformed(evt);
            }
        });
        jMIngreso.add(jMIPaciente);

        jMenuItem1.setText("IMC");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMIngreso.add(jMenuItem1);

        jMCuantoFalta.setText("Cuanto Falta");
        jMCuantoFalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCuantoFaltaActionPerformed(evt);
            }
        });
        jMIngreso.add(jMCuantoFalta);

        jMIListaPacientes.setText("Lista de Pacientes");
        jMIListaPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIListaPacientesActionPerformed(evt);
            }
        });
        jMIngreso.add(jMIListaPacientes);

        jMenuBar1.add(jMIngreso);

        jMenu2.setText("Dieta");

        jMenuItem2.setText("Cargar Dieta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMiDieta.setText("Buscar Dieta");
        jMiDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiDietaActionPerformed(evt);
            }
        });
        jMenu2.add(jMiDieta);

        jCheckBoxMenuItem2.setText("Mostrar todas las dietas");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Menu");

        jMIMenuDiario.setText("MenuDiario");
        jMIMenuDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMenuDiarioActionPerformed(evt);
            }
        });
        jMenu3.add(jMIMenuDiario);

        jMenuItem5.setText("Lista de menus");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Comidas");

        jMIComidas.setText("Gestionar Comidas");
        jMIComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIComidasActionPerformed(evt);
            }
        });
        jMenu1.add(jMIComidas);

        jMiListarComidas.setText("Listar Comidas");
        jMiListarComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiListarComidasActionPerformed(evt);
            }
        });
        jMenu1.add(jMiListarComidas);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Ingredientes");

        jMIIngredientes.setText("Gestionar Ingredientes");
        jMIIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIIngredientesActionPerformed(evt);
            }
        });
        jMenu4.add(jMIIngredientes);

        jMenuItem3.setText("Listar Ingredientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

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
        JDPMenu.removeAll();
        JDPMenu.repaint();
        GestionarIngredientes gi = new GestionarIngredientes();
        JDPMenu.add(gi);
        gi.setVisible(true);
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
        DietaVista listP = new DietaVista();

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

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        MostrarDieta MostrarDieta = new MostrarDieta();
        JDPMenu.add(MostrarDieta);
        MostrarDieta.setVisible(true);
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jMIMenuDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMenuDiarioActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        MenuDiarioVista menuDiarioVista = new MenuDiarioVista();
        JDPMenu.add(menuDiarioVista);
        menuDiarioVista.setVisible(true);
    }//GEN-LAST:event_jMIMenuDiarioActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        ListarMenuDiario listarMenuDiario = new ListarMenuDiario();
        JDPMenu.add(listarMenuDiario);
        listarMenuDiario.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        CargarDieta cargarDieta = new CargarDieta();
        JDPMenu.add(cargarDieta);
        cargarDieta.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        ListarIngredientes li = new ListarIngredientes();
        JDPMenu.add(li);
        li.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMiListarComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiListarComidasActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        ListarComidas listCom = new ListarComidas();
        JDPMenu.add(listCom);
        listCom.setVisible(true);
    }//GEN-LAST:event_jMiListarComidasActionPerformed

    private void jMIComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIComidasActionPerformed
        JDPMenu.removeAll();
        JDPMenu.repaint();
        CrearComidas cc = new CrearComidas();
        JDPMenu.add(cc);
        cc.setVisible(true);
}//GEN-LAST:event_jMIComidasActionPerformed

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
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMiDieta;
    private javax.swing.JMenuItem jMiListarComidas;
    // End of variables declaration//GEN-END:variables
}
