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
        jBRandom = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTFPaciente = new javax.swing.JTextField();
        jBSalir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(115, 0, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Menu Diario");

        jLabel2.setBackground(new java.awt.Color(115, 0, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Seleccione un dia:");

        jLabel3.setBackground(new java.awt.Color(115, 0, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Seleccione una Dieta:");

        jCBDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7" }));
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

        jBInsert.setForeground(new java.awt.Color(0, 0, 102));
        jBInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        jBInsert.setText("Nuevo");
        jBInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertActionPerformed(evt);
            }
        });

        jBActualizar.setForeground(new java.awt.Color(0, 0, 102));
        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/actualizar.png"))); // NOI18N
        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCBCena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCenaActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(115, 0, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Cena: ");

        jLabel8.setBackground(new java.awt.Color(115, 0, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Almuerzo:");

        jLabel7.setBackground(new java.awt.Color(115, 0, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Colacion:");

        jLabel6.setBackground(new java.awt.Color(115, 0, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Merienda:");

        jLabel5.setBackground(new java.awt.Color(115, 0, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
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

        jLabel10.setBackground(new java.awt.Color(115, 0, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("Calorias Del Dia");

        jLCalorias.setBackground(new java.awt.Color(115, 0, 255));
        jLCalorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLCalorias.setForeground(new java.awt.Color(0, 0, 102));
        jLCalorias.setText("\"Calorias\"");

        jLabel4.setBackground(new java.awt.Color(115, 0, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Seleccione las comidas del dia");

        jBRandom.setForeground(new java.awt.Color(0, 0, 102));
        jBRandom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Random.png"))); // NOI18N
        jBRandom.setText("Random");
        jBRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBMerienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBColacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBAlmuerzo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBCena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jBRandom)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLCalorias)))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jCBMerienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBColacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRandom)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLCalorias)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel11.setBackground(new java.awt.Color(115, 0, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 102));
        jLabel11.setText("Paciente:");

        jTFPaciente.setEditable(false);
        jTFPaciente.setFocusable(false);

        jBSalir.setForeground(new java.awt.Color(0, 0, 102));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/puerta-abierta.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jBInsert)
                .addGap(42, 42, 42)
                .addComponent(jBActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCBDia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
                            if (!comida.getTipoDeComida().contains("Desayuno")) {
                                jCBDesayuno.addItem(comida);
                            } else if (!comida.getTipoDeComida().contains("Merienda")) {
                                jCBMerienda.addItem(comida);
                            } else if (!comida.getTipoDeComida().contains("Colacion")) {
                                jCBColacion.addItem(comida);
                            } else if (!comida.getTipoDeComida().contains("Almuerzo")) {
                                jCBAlmuerzo.addItem(comida);
                            } else if (!comida.getTipoDeComida().contains("Cena")) {
                                jCBCena.addItem(comida);
                            }
                        }

                        jCBDesayuno.setEnabled(true);
                        jCBAlmuerzo.setEnabled(false);
                        jCBCena.setEnabled(false);
                        jCBColacion.setEnabled(false);
                        jCBMerienda.setEnabled(false);

                        jBActualizar.setEnabled(false);
                        jBInsert.setEnabled(false);
                        jCBAlmuerzo.setSelectedIndex(-1);
                        jCBCena.setSelectedIndex(-1);
                        jCBColacion.setSelectedIndex(-1);
                        jCBDesayuno.setSelectedIndex(-1);
                        jCBMerienda.setSelectedIndex(-1);
                        jLCalorias.setText("Calorias");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró ninguna comida apta para el paciente en la base de datos");
                    }
                }
                jBRandom.setEnabled(true);
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

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        if (jCBDieta.getSelectedItem() != null && jCBDia.getSelectedItem() != null
                && jCBDesayuno.getSelectedItem() != null && jCBMerienda.getSelectedItem() != null
                && jCBColacion.getSelectedItem() != null && jCBAlmuerzo.getSelectedItem() != null
                && jCBCena.getSelectedItem() != null) {

            MenuDiario menuDiario;
            int dia = 0;
            switch (jCBDia.getSelectedItem().toString()) {
                case "Dia 1":
                    dia = 1;
                    break;
                case "Dia 2":
                    dia = 2;
                    break;
                case "Dia 3":
                    dia = 3;
                    break;
                case "Dia 4":
                    dia = 4;
                    break;
                case "Dia 5":
                    dia = 5;
                    break;
                case "Dia 6":
                    dia = 6;
                    break;
                case "Dia 7":
                    dia = 7;
                    break;
            }
            menuDiario = menuAcceso.buscarMenuDiarioPorDietaYDia(
                    ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(),
                    dia);
            if (Objects.nonNull(menuDiario)) {

                ArrayList<Comidas> listaComidaNEw = new ArrayList<>();
                listaComidaNEw.add((Comidas) jCBAlmuerzo.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBCena.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBColacion.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBDesayuno.getSelectedItem());
                listaComidaNEw.add((Comidas) jCBMerienda.getSelectedItem());

                double calorias = 0;
                for (Comidas comidas : listaComidaNEw) {
                    calorias += comidas.getCaloriasComida();
                }
                menuDiario.setComidas(menuAcceso.buscarComidasPorMenuDiario(menuDiario));

                menuAcceso.actualizarMenuDiario(calorias, ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(), dia);

                int index = 0;
                for (Comidas comidas : listaComidaNEw) {
                    menuAcceso.actualizarMenuComidas(menuDiario.getIdMenu(), comidas.getIdComida(),
                            menuDiario.getComidas().get(index).getIdComida());
                    index++;
                }
                JOptionPane.showMessageDialog(this, "Actualizacion completada");

            } else {
                JOptionPane.showMessageDialog(this, "No se puede actualizar, porque el menu del dia no existe");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione cada una de las opciones que se solicitan");
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jCBDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDesayunoActionPerformed
        if (Objects.nonNull(jCBDesayuno.getSelectedItem())) {
            if (jCBDesayuno.getSelectedIndex() != -1) {
                actualizarCaloriasTotal();
            }
            jCBMerienda.setEnabled(true);
        }
    }//GEN-LAST:event_jCBDesayunoActionPerformed

    private void jCBMeriendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMeriendaActionPerformed
        if (Objects.nonNull(jCBMerienda.getSelectedItem())) {
            if (jCBDesayuno.getSelectedIndex() != -1) {
                actualizarCaloriasTotal();
            }
            jCBColacion.setEnabled(true);
        }
    }//GEN-LAST:event_jCBMeriendaActionPerformed

    private void jCBColacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBColacionActionPerformed
        if (Objects.nonNull(jCBColacion.getSelectedItem())) {
            if (jCBDesayuno.getSelectedIndex() != -1) {
                actualizarCaloriasTotal();
            }
            jCBAlmuerzo.setEnabled(true);
        }

    }//GEN-LAST:event_jCBColacionActionPerformed

    private void jCBAlmuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlmuerzoActionPerformed
        if (Objects.nonNull(jCBAlmuerzo.getSelectedItem())) {
            if (jCBDesayuno.getSelectedIndex() != -1) {
                actualizarCaloriasTotal();
            }
            jCBCena.setEnabled(true);
        }
    }//GEN-LAST:event_jCBAlmuerzoActionPerformed

    private void jCBCenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCenaActionPerformed
        if (Objects.nonNull(jCBCena.getSelectedItem())) {
            if (jCBDesayuno.getSelectedIndex() != -1) {
                actualizarCaloriasTotal();
            }
            jBInsert.setEnabled(true);
            jBActualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jCBCenaActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        if (Objects.nonNull(((Dieta) jCBDieta.getSelectedItem()))) {
            if (menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) < 3 && menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) != 0) {
                JOptionPane.showMessageDialog(this, "No podra salir hasta que increse un minimo de 3 menu del dias la dieta seleccionada");
                jCBDieta.setEnabled(false);
            } else {

            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRandomActionPerformed
        if (Objects.nonNull(jCBDieta.getSelectedItem()) && Objects.nonNull(jCBDia.getSelectedItem())) {
            if (jCBAlmuerzo.getItemCount() != 0 && jCBCena.getItemCount() != 0 && jCBColacion.getItemCount() != 0
                    && jCBDesayuno.getItemCount() != 0 && jCBMerienda.getItemCount() != 0) {
                jCBAlmuerzo.setSelectedIndex((int) ((Math.random() * (jCBAlmuerzo.getItemCount() - 0)) + 0));
                jCBCena.setSelectedIndex((int) ((Math.random() * (jCBCena.getItemCount() - 0)) + 0));
                jCBColacion.setSelectedIndex((int) ((Math.random() * (jCBColacion.getItemCount() - 0)) + 0));
                jCBDesayuno.setSelectedIndex((int) ((Math.random() * (jCBDesayuno.getItemCount() - 0)) + 0));
                jCBMerienda.setSelectedIndex((int) ((Math.random() * (jCBMerienda.getItemCount() - 0)) + 0));
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo generar porque faltan ingredientes");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una Dieta y un Dia");
        }


    }//GEN-LAST:event_jBRandomActionPerformed

    private void jBInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertActionPerformed

        if (jCBDieta.getSelectedItem() != null && jCBDia.getSelectedItem() != null
                && jCBDesayuno.getSelectedItem() != null && jCBMerienda.getSelectedItem() != null
                && jCBColacion.getSelectedItem() != null && jCBAlmuerzo.getSelectedItem() != null
                && jCBCena.getSelectedItem() != null) {
            MenuDiario menuDiario;
            int dia = 0;
            switch (jCBDia.getSelectedItem().toString()) {
                case "Dia 1":
                    dia = 1;
                    break;
                case "Dia 2":
                    dia = 2;
                    break;
                case "Dia 3":
                    dia = 3;
                    break;
                case "Dia 4":
                    dia = 4;
                    break;
                case "Dia 5":
                    dia = 5;
                    break;
                case "Dia 6":
                    dia = 6;
                    break;
                case "Dia 7":
                    dia = 7;
                    break;
            }

            menuDiario = menuAcceso.buscarMenuDiarioPorDietaYDia(
                    ((Dieta) jCBDieta.getSelectedItem()).getIdDieta(),
                    Integer.parseInt((String) jCBDia.getSelectedItem()));

            if (!Objects.nonNull(menuDiario)) {
                if (dia == 1) {
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
                            dia - 1))) {
                        MenuDiario menu = new MenuDiario();
                        menu.setDia(dia);
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
                        JOptionPane.showMessageDialog(this, "Faltan menus previos al dia " + (jCBDia.getSelectedItem()) + ",\ningrese los menus correspondientes");
                    }
                }
                if (menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) < 3 && menuAcceso.contadorMenuDiariosDeUnaDieta(((Dieta) jCBDieta.getSelectedItem()).getIdDieta()) != 0) {
                    JOptionPane.showMessageDialog(this, "No se podra cambiar hasta la dieta hasta que tenga por lo menos 3 meenus del dia asociados");
                    jCBDieta.setEnabled(false);
                } else {
                    jCBDieta.setEnabled(true);
                }
                jCBDia.setSelectedIndex(-1);
                jCBAlmuerzo.setSelectedIndex(-1);
                jCBCena.setSelectedIndex(-1);
                jCBColacion.setSelectedIndex(-1);
                jCBDesayuno.setSelectedIndex(-1);
                jCBMerienda.setSelectedIndex(-1);

                jCBAlmuerzo.setEnabled(false);
                jCBCena.setEnabled(false);
                jCBColacion.setEnabled(false);
                jCBDesayuno.setEnabled(false);
                jCBMerienda.setEnabled(false);

                jBActualizar.setEnabled(false);
                jBInsert.setEnabled(false);
                jBSalir.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ya existe un Menu Diario asociado");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione cada una de las opciones que se solicitan");
        }
    }//GEN-LAST:event_jBInsertActionPerformed

    // Metodos  auxiliares
    private void cargarDietas() {
        MenuDiarioData munuData = new MenuDiarioData();
        for (Dieta aux : munuData.listarTodasLasDietasActivas()) {
            jCBDieta.addItem(aux);
        }
    }

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

        jBRandom.setEnabled(false);
        jBActualizar.setEnabled(false);
        jBInsert.setEnabled(false);
    }

    // Mostrar las calorías
    private void actualizarCaloriasTotal() {
        int caloriasTotal = 0;

        if (jCBDesayuno.getSelectedItem() != null) {
            caloriasTotal += ((Comidas) jCBDesayuno.getSelectedItem()).getCaloriasComida();
        }
        if (jCBMerienda.getSelectedItem() != null) {
            caloriasTotal += ((Comidas) jCBMerienda.getSelectedItem()).getCaloriasComida();
        }
        if (jCBColacion.getSelectedItem() != null) {
            caloriasTotal += ((Comidas) jCBColacion.getSelectedItem()).getCaloriasComida();
        }
        if (jCBAlmuerzo.getSelectedItem() != null) {
            caloriasTotal += ((Comidas) jCBAlmuerzo.getSelectedItem()).getCaloriasComida();
        }
        if (jCBCena.getSelectedItem() != null) {
            caloriasTotal += ((Comidas) jCBCena.getSelectedItem()).getCaloriasComida();
        }

        // Mostrar el total de calorías en el JTextField
        jLCalorias.setText(String.valueOf(caloriasTotal));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBInsert;
    private javax.swing.JButton jBRandom;
    private javax.swing.JButton jBSalir;
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
