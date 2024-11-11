/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.MenuDiario;
import Modelo.Paciente;
import Modelo.Comidas;
import Modelo.Dieta;
import Persistencia.DietaData;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MenuDiarioVista extends javax.swing.JInternalFrame {

    MenuDiarioData menuAcceso = new MenuDiarioData();
    PacienteData pacienteAcceso = new PacienteData();
    DietaData dietaData = new DietaData();

    /**
     * Creates new form MenuDiario
     */
    public MenuDiarioVista() {
        initComponents();
        cargarDietas();

        deshabilitar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCBDia = new javax.swing.JComboBox<>();
        jCBDieta = new javax.swing.JComboBox<>();
        jBInsert = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCBCena = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCBDesayuno = new javax.swing.JComboBox<>();
        jCBMerienda = new javax.swing.JComboBox<>();
        jCBColacion = new javax.swing.JComboBox<>();
        jCBAlmuerzo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLCalorias = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Menu Diario");

        jLabel2.setText("Seleccione un dia:");

        jLabel3.setText("Seleccione una Dieta:");

        jCBDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        jCBDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDiaActionPerformed(evt);
            }
        });

        jCBDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDietaActionPerformed(evt);
            }
        });

        jBInsert.setText("Insertar");
        jBInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBCena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCenaActionPerformed(evt);
            }
        });

        jLabel9.setText("Cena: ");

        jLabel8.setText("Almuerzo:");

        jLabel7.setText("Colacion:");

        jLabel6.setText("Merienda:");

        jLabel5.setText("Desayuno:");

        jCBDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDesayunoActionPerformed(evt);
            }
        });

        jCBMerienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMeriendaActionPerformed(evt);
            }
        });

        jCBColacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBColacionActionPerformed(evt);
            }
        });

        jCBAlmuerzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlmuerzoActionPerformed(evt);
            }
        });

        jLabel10.setText("Calorias Del Dia");

        jLCalorias.setText("\"Calorias\"");

        jLabel4.setText("Seleccione las comidas del dia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBColacion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLCalorias))
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBCena, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jCBMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBColacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLCalorias)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel11.setText("Paciente:");

        jTFPaciente.setEditable(false);

        jButton1.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBDia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jBInsert)
                .addGap(47, 47, 47)
                .addComponent(jBActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jCBDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTFPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInsert)
                    .addComponent(jBActualizar)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDiaActionPerformed
        //Busca las comidas activas
        ArrayList<Comidas> listaComidas = menuAcceso.listarComidasActivas();
        //Contempla que existan
        if (!listaComidas.isEmpty()) {
            //Verifica que la Dieta seleccionada no sea null
            if (jCBDieta.getSelectedItem() != null) {
                Paciente pac = new Paciente();
                pac = menuAcceso.obtenerPacientePorDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta());
                if (pac != null) {
                    String condicion = pacienteAcceso.convertirSetString(pac.getCondicionSalud());

                    ArrayList<Comidas> comidas = menuAcceso.obtenerComidasAptas(listaComidas, condicion);
                    if (!comidas.isEmpty()) {
                        for (Comidas comida : comidas) {
                            switch (comida.getTipoDeComida()) {
                                case "Desayuno":
                                    jCBDesayuno.addItem(comida);
                                    break;
                                case "Merienda":
                                    jCBMerienda.addItem(comida);
                                    break;
                                case "Colacion":
                                    jCBColacion.addItem(comida);
                                    break;
                                case "Almuerzo":
                                    jCBAlmuerzo.addItem(comida);
                                    break;
                                case "Cena":
                                    jCBCena.addItem(comida);
                                    break;
                            }
                        }
                        jCBAlmuerzo.setSelectedIndex(-1);
                        jCBCena.setSelectedIndex(-1);
                        jCBColacion.setSelectedIndex(-1);
                        jCBDesayuno.setSelectedIndex(-1);
                        jCBMerienda.setSelectedIndex(-1);
                        jCBDesayuno.setEnabled(true);
                        jCBAlmuerzo.setEnabled(false);
                        jCBCena.setEnabled(false);
                        jCBColacion.setEnabled(false);
                        jCBMerienda.setEnabled(false);

                        jBActualizar.setEnabled(false);
                        jBInsert.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró ninguna comida apta para el paciente en la base de datos");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La dieta seleccionada no tiene un paciente asociado.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se han cargado comidas a la base de datos");
        }
    }//GEN-LAST:event_jCBDiaActionPerformed

    private void jCBDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDietaActionPerformed

        if (jCBDieta.getSelectedIndex() != -1 && Objects.nonNull(jCBDieta.getSelectedItem())) {
            jCBDia.setEnabled(true);

            PacienteData pacData = new PacienteData();
            Paciente pac = new Paciente();
            pac = pacData.buscarPaciente(dietaData.buscarDietaSegunID(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()).getPaciente().getIdPaciente());
            if (pac != null) { // Verificación de null
                jTFPaciente.setText(pac.getIdPaciente() + " " + pac.getNombre());
            } else {
                jTFPaciente.setText("");
            }
        }
    }//GEN-LAST:event_jCBDietaActionPerformed

    private void jBInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertActionPerformed

        if (jCBDieta.getSelectedItem() != null && jCBDia.getSelectedItem() != null
                && jCBDesayuno.getSelectedItem() != null && jCBMerienda.getSelectedItem() != null
                && jCBColacion.getSelectedItem() != null && jCBAlmuerzo.getSelectedItem() != null
                && jCBCena.getSelectedItem() != null) {
            MenuDiario menuDiario;
            menuDiario = menuAcceso.buscarMenuDiarioPorDietaYDia(
                    ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(),
                    Integer.parseInt((String) jCBDia.getSelectedItem()));

            if (!Objects.nonNull(menuDiario)) {
                if (Integer.parseInt((String) jCBDia.getSelectedItem()) == 1) {
                    MenuDiario menu = new MenuDiario();
                    menu.setDia(Integer.parseInt((String) jCBDia.getSelectedItem()));
                    menu.setIdDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta());
                    menu.setCaloriasDelMenu(
                            ((Comidas) jCBAlmuerzo.getSelectedItem()).getCaloriasComida()
                            + ((Comidas) jCBCena.getSelectedItem()).getCaloriasComida()
                            + ((Comidas) jCBColacion.getSelectedItem()).getCaloriasComida()
                            + ((Comidas) jCBDesayuno.getSelectedItem()).getCaloriasComida()
                            + ((Comidas) jCBMerienda.getSelectedItem()).getCaloriasComida()
                    );
                    menu.getComidas().add((Comidas) jCBAlmuerzo.getSelectedItem());
                    menu.getComidas().add((Comidas) jCBCena.getSelectedItem());
                    menu.getComidas().add((Comidas) jCBColacion.getSelectedItem());
                    menu.getComidas().add((Comidas) jCBDesayuno.getSelectedItem());
                    menu.getComidas().add((Comidas) jCBMerienda.getSelectedItem());

                    menuAcceso.insertMenuDiario(menu);

                } else {
                    if (Objects.nonNull(menuAcceso.buscarMenuDiarioPorDietaYDia(
                            ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(),
                            (Integer.parseInt((String) jCBDia.getSelectedItem())) - 1))) {
                        MenuDiario menu = new MenuDiario();
                        menu.setDia(Integer.parseInt((String) jCBDia.getSelectedItem()));
                        menu.setIdDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta());

                        menu.setCaloriasDelMenu(
                                ((Comidas) jCBAlmuerzo.getSelectedItem()).getCaloriasComida()
                                + ((Comidas) jCBCena.getSelectedItem()).getCaloriasComida()
                                + ((Comidas) jCBColacion.getSelectedItem()).getCaloriasComida()
                                + ((Comidas) jCBDesayuno.getSelectedItem()).getCaloriasComida()
                                + ((Comidas) jCBMerienda.getSelectedItem()).getCaloriasComida()
                        );

                        menu.getComidas().add((Comidas) jCBAlmuerzo.getSelectedItem());
                        menu.getComidas().add((Comidas) jCBCena.getSelectedItem());
                        menu.getComidas().add((Comidas) jCBColacion.getSelectedItem());
                        menu.getComidas().add((Comidas) jCBDesayuno.getSelectedItem());
                        menu.getComidas().add((Comidas) jCBMerienda.getSelectedItem());

                        menuAcceso.insertMenuDiario(menu);
                    } else {
                        JOptionPane.showMessageDialog(this, "No existe un MenuDiario anterior al de la fecha por lo cual no se podra insertar el actual");
                    }
                }
                if (menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) < 3 && menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) != 0 ) {
                    jCBDieta.setEnabled(false);
                }
                jCBDia.setSelectedIndex(-1);
                jCBAlmuerzo.setSelectedIndex(-1);
                jCBCena.setSelectedIndex(-1);
                jCBColacion.setSelectedIndex(-1);
                jCBDesayuno.setSelectedIndex(-1);
                jCBMerienda.setSelectedIndex(-1);

                jCBDia.setEnabled(false);
                jCBAlmuerzo.setEnabled(false);
                jCBCena.setEnabled(false);
                jCBColacion.setEnabled(false);
                jCBDesayuno.setEnabled(false);
                jCBMerienda.setEnabled(false);
                jTFPaciente.setText(null);

                jBActualizar.setEnabled(false);
                jBInsert.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un Menu Diario asociado");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione cada una de las opciones que se solicitan");
        }
    }//GEN-LAST:event_jBInsertActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        if (jCBDieta.getSelectedItem() != null && jCBDia.getSelectedItem() != null
                && jCBDesayuno.getSelectedItem() != null && jCBMerienda.getSelectedItem() != null
                && jCBColacion.getSelectedItem() != null && jCBAlmuerzo.getSelectedItem() != null
                && jCBCena.getSelectedItem() != null) {

            MenuDiario menuDiario;
            menuDiario = menuAcceso.buscarMenuDiarioPorDietaYDia(
                    ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(),
                    Integer.parseInt((String) jCBDia.getSelectedItem()));
            if (Objects.nonNull(menuDiario)) {

                ArrayList<Comidas> listaComidaNEw = new ArrayList<>();
                listaComidaNEw.add((Comidas) jCBAlmuerzo.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBCena.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBColacion.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBDesayuno.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBMerienda.getSelectedItem());

                menuDiario.setComidas(menuAcceso.buscarComidasPorMenuDiario(menuDiario));

                int index = 0;
                for (Comidas comidas : listaComidaNEw) {
                    menuAcceso.actualizarMenuComidas(menuDiario.getIdMenu(), comidas.getIdComida(),
                            menuDiario.getComidas().get(index).getIdComida());
                    index++;
                }

            } else {
                JOptionPane.showMessageDialog(this, "No existe un Menu Diario asociado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione cada una de las opciones que se solicitan");
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jCBDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDesayunoActionPerformed
        if (Objects.nonNull(jCBDesayuno.getSelectedItem())) {
            jCBMerienda.setEnabled(true);
        }
    }//GEN-LAST:event_jCBDesayunoActionPerformed

    private void jCBMeriendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMeriendaActionPerformed
        if (Objects.nonNull(jCBMerienda.getSelectedItem())) {
            jCBColacion.setEnabled(true);
        }
    }//GEN-LAST:event_jCBMeriendaActionPerformed

    private void jCBColacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBColacionActionPerformed
        if (Objects.nonNull(jCBColacion.getSelectedItem())) {
            jCBAlmuerzo.setEnabled(true);
        }

    }//GEN-LAST:event_jCBColacionActionPerformed

    private void jCBAlmuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlmuerzoActionPerformed
        if (Objects.nonNull(jCBAlmuerzo.getSelectedItem())) {
            jCBCena.setEnabled(true);
        }
    }//GEN-LAST:event_jCBAlmuerzoActionPerformed

    private void jCBCenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCenaActionPerformed
        if (Objects.nonNull(jCBCena.getSelectedItem())) {
            jBInsert.setEnabled(true);
            jBActualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jCBCenaActionPerformed

    // Metodos  auxiliares
    private void cargarDietas() {
        MenuDiarioData munuData = new MenuDiarioData();
        for (Dieta aux : munuData.listarTodasLasDietasActivas()) {
            jCBDieta.addItem(aux);
        }
    }

    private void cargarComdias(int idPaciente) {
        PacienteData pacData = new PacienteData();
        Paciente paciente = pacData.buscarPaciente(idPaciente);

        paciente.getCondicionSalud();

    }

    /*
    private void actualizarJLabelCalorias() {
        double calorias = ((Comidas) jCBAlmuerzo.getSelectedItem()).getCaloriasComida();
        calorias += ((Comidas) jCBCena.getSelectedItem()).getCaloriasComida();
        calorias += ((Comidas) jCBColacion.getSelectedItem()).getCaloriasComida();
        calorias += ((Comidas) jCBDesayuno.getSelectedItem()).getCaloriasComida();
        calorias += ((Comidas) jCBMerienda.getSelectedItem()).getCaloriasComida();
        jLCalorias.setText(Double.toString(calorias));
    }
     */
    private void deshabilitar() {
        jCBDieta.setSelectedIndex(-1);
        jCBDia.setSelectedIndex(-1);
        jCBAlmuerzo.setSelectedIndex(-1);
        jCBCena.setSelectedIndex(-1);
        jCBColacion.setSelectedIndex(-1);
        jCBDesayuno.setSelectedIndex(-1);
        jCBMerienda.setSelectedIndex(-1);

        jCBDia.setEnabled(false);
        jCBAlmuerzo.setEnabled(false);
        jCBCena.setEnabled(false);
        jCBColacion.setEnabled(false);
        jCBDesayuno.setEnabled(false);
        jCBMerienda.setEnabled(false);
        jTFPaciente.setText(null);

        jBActualizar.setEnabled(false);
        jBInsert.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBInsert;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Comidas> jCBAlmuerzo;
    private javax.swing.JComboBox<Comidas> jCBCena;
    private javax.swing.JComboBox<Comidas> jCBColacion;
    private javax.swing.JComboBox<Comidas> jCBDesayuno;
    private javax.swing.JComboBox<String> jCBDia;
    private javax.swing.JComboBox<Dieta> jCBDieta;
    private javax.swing.JComboBox<Comidas> jCBMerienda;
    private javax.swing.JLabel jLCalorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFPaciente;
    // End of variables declaration//GEN-END:variables
}
