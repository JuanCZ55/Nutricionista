package Vista;

import Modelo.Comidas;
import Modelo.Ingredientes;
import Persistencia.ComidaData;
import Persistencia.IngredientesData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanz
 */
public class CrearComidas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private IngredientesData id = new IngredientesData();
    private ComidaData cd = new ComidaData();

    private HashMap<Integer, Double> ingredientesPesos = new HashMap<>();

    public CrearComidas() {
        initComponents();
        cargarVacio();
        setClosable(true);
        cargarIngredientes();
        JBModificar.setEnabled(false);
        JBAlta.setEnabled(false);
        JBBaja.setEnabled(false);
        modelo = (DefaultTableModel) jTComidas.getModel();
        enlistarPacientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JCBTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JCBIng1 = new javax.swing.JComboBox<>();
        JCBIng3 = new javax.swing.JComboBox<>();
        JCBIng2 = new javax.swing.JComboBox<>();
        JCBIng5 = new javax.swing.JComboBox<>();
        JCBIng4 = new javax.swing.JComboBox<>();
        JTF1 = new javax.swing.JTextField();
        JTF2 = new javax.swing.JTextField();
        JTF3 = new javax.swing.JTextField();
        JTF5 = new javax.swing.JTextField();
        JTF4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JBAlta = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBBaja = new javax.swing.JButton();
        JBNuevo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTComidas = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Crear Comidas");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Tipo de Comida: ");

        JCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Colacion", "Almuerzo", "Merienda", "Cena" }));
        JCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBTipoActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingridiente 1:");

        jLabel7.setText("Ingridiente 3:");

        jLabel10.setText("Ingridiente 2:");

        jLabel11.setText("Ingridiente 4:");

        jLabel12.setText("Ingridiente 5:");

        JCBIng1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIng1ActionPerformed(evt);
            }
        });

        JCBIng3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIng3ActionPerformed(evt);
            }
        });

        JCBIng2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIng2ActionPerformed(evt);
            }
        });

        JCBIng5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIng5ActionPerformed(evt);
            }
        });

        JCBIng4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIng4ActionPerformed(evt);
            }
        });

        JTF1.setEnabled(false);

        JTF2.setEnabled(false);

        JTF3.setEnabled(false);

        JTF5.setEnabled(false);

        JTF4.setEnabled(false);

        jLabel5.setText("Pesos en gramos");

        JBAlta.setText("Alta");
        JBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAltaActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        JBModificar.setText("Modificar");
        JBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBModificarActionPerformed(evt);
            }
        });

        JBBaja.setText("Baja");
        JBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBajaActionPerformed(evt);
            }
        });

        JBNuevo.setText("Nuevo");
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        JTFid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFidKeyReleased(evt);
            }
        });

        jTComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Calorias", "No Apto", "Ingrediente 1", "Ingrediente 2", "Ingrediente 3", "Ingrediente 4", "Ingrediente 5", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTComidas);
        if (jTComidas.getColumnModel().getColumnCount() > 0) {
            jTComidas.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JBModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JCBIng2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JCBIng1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(77, 77, 77))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JCBIng3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JCBIng4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JCBIng5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(65, 65, 65)
                                                        .addComponent(JBAlta)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(JTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTF4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBBuscar))
                                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JBNuevo)
                                .addGap(346, 346, 346)
                                .addComponent(JBBaja))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1)))
                .addContainerGap(235, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBuscar)
                    .addComponent(jLabel6)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCBIng1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(JCBIng2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JCBIng3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JCBIng4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JCBIng5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNuevo)
                    .addComponent(JBModificar)
                    .addComponent(JBAlta)
                    .addComponent(JBBaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBTipoActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        JBModificar.setEnabled(true);
        try {
            int idComida = Integer.parseInt(JTFid.getText());
            if (idComida <= 0) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un numero mayor a 0.");
                return;
            }
            Comidas comida = cd.buscarComida(idComida);

            JTFNombre.setText(comida.getNombre());
            JCBTipo.setSelectedItem(comida.getTipoDeComida());
            HashMap<Integer, Double> ing = cd.buscarIngredientesComidas(idComida);
            ArrayList<JComboBox> jcbs = new ArrayList<>();
            jcbs.add(JCBIng1);
            jcbs.add(JCBIng2);
            jcbs.add(JCBIng3);
            jcbs.add(JCBIng4);
            jcbs.add(JCBIng5);
            ArrayList<JTextField> txts = new ArrayList<>();
            txts.add(JTF1);
            txts.add(JTF2);
            txts.add(JTF3);
            txts.add(JTF4);
            txts.add(JTF5);
            int i = 0;
            for (HashMap.Entry<Integer, Double> ipa : ing.entrySet()) {
                JComboBox combo = jcbs.get(i);
                JTextField jt = txts.get(i);
                Ingredientes ingrediente = id.buscarIngredientes(ipa.getKey());
                combo.setSelectedItem(ingrediente);
                jt.setText(String.valueOf(ipa.getValue()));
                i++;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido en el campo ID.");
        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void JBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBModificarActionPerformed

        if (controlPesos()) {
            try {
                int id = Integer.parseInt(JTFid.getText());
                if (id <= 0) {
                    JOptionPane.showMessageDialog(this, "El ID debe ser un numero mayor a 0.");
                    return;
                }
                String nom = JTFNombre.getText();
                String tipo = (String) JCBTipo.getSelectedItem();
                double caloriasT = cd.caloriasComidas(ingredientesPesos);
                if (nom == null || nom.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                    return;

                }
                Comidas com = new Comidas(id, nom, tipo, caloriasT);
                if (cd.modificarComida(com, ingredientesPesos)) {
                    setNulo();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero valido en el campo ID.");

            }
        }
        enlistarPacientes();
    }//GEN-LAST:event_JBModificarActionPerformed

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        if (controlPesos()) {
            try {
                String nom = JTFNombre.getText();
                String tipo = (String) JCBTipo.getSelectedItem();
                double caloriasT = cd.caloriasComidas(ingredientesPesos);
                boolean a = false;
                if (nom == null || nom.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese un nombre");
                    return;

                }
                Comidas com = new Comidas(nom, tipo, caloriasT, null);
                a = cd.crearComida(com, ingredientesPesos);

                if (a) {
                    setNulo();
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Complete los Campos");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Caracteres Invalidos");

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Error en el constructor");

            }
        }
        enlistarPacientes();
    }//GEN-LAST:event_JBNuevoActionPerformed

    private void JCBIng1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIng1ActionPerformed
        habilitarPeso();
    }//GEN-LAST:event_JCBIng1ActionPerformed

    private void JCBIng2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIng2ActionPerformed
        habilitarPeso();
    }//GEN-LAST:event_JCBIng2ActionPerformed

    private void JCBIng3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIng3ActionPerformed
        habilitarPeso();
    }//GEN-LAST:event_JCBIng3ActionPerformed

    private void JCBIng4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIng4ActionPerformed
        habilitarPeso();
    }//GEN-LAST:event_JCBIng4ActionPerformed

    private void JCBIng5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIng5ActionPerformed
        habilitarPeso();
    }//GEN-LAST:event_JCBIng5ActionPerformed

    private void JTFidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFidKeyReleased
        if (JTFid.getText().isEmpty()) {
            JBModificar.setEnabled(false);
            JBAlta.setEnabled(false);
            JBBaja.setEnabled(false);
        } else {
            JBModificar.setEnabled(true);
            JBAlta.setEnabled(true);
            JBBaja.setEnabled(true);
        }    }//GEN-LAST:event_JTFidKeyReleased

    private void JBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAltaActionPerformed
        try {
            int id = Integer.parseInt(JTFid.getText());
            cd.altaLogica(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese unicamente numeros en ID");

        }
        enlistarPacientes();
    }//GEN-LAST:event_JBAltaActionPerformed

    private void JBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBajaActionPerformed
        try {
            int id = Integer.parseInt(JTFid.getText());
            cd.bajaLogica(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese unicamente numeros en ID");

        }
        enlistarPacientes();
    }//GEN-LAST:event_JBBajaActionPerformed
    private void cargarIngredientes() {
        for (Ingredientes ingre : id.listarIngredientes()) {
            JCBIng1.addItem(ingre);
            JCBIng2.addItem(ingre);
            JCBIng3.addItem(ingre);
            JCBIng4.addItem(ingre);
            JCBIng5.addItem(ingre);
        }
    }

    private void cargarVacio() {
        JCBIng1.addItem(null);
        JCBIng2.addItem(null);
        JCBIng3.addItem(null);
        JCBIng4.addItem(null);
        JCBIng5.addItem(null);
    }

    public void setNulo() {
        JTFid.setText("");
        JTFNombre.setText("");
        JCBIng1.setSelectedItem(null);
        JCBIng2.setSelectedItem(null);
        JCBIng3.setSelectedItem(null);
        JCBIng4.setSelectedItem(null);
        JCBIng5.setSelectedItem(null);
        ingredientesPesos.clear();

    }

    private void habilitarPeso() {
        if (JCBIng1.getSelectedItem() != null) {
            JTF1.setEnabled(true);
        } else {
            JTF1.setText("");
            JTF1.setEnabled(false);
        }
        if (JCBIng2.getSelectedItem() != null) {
            JTF2.setEnabled(true);
        } else {
            JTF2.setText("");
            JTF2.setEnabled(false);
        }
        if (JCBIng3.getSelectedItem() != null) {
            JTF3.setEnabled(true);
        } else {
            JTF3.setText("");
            JTF3.setEnabled(false);
        }
        if (JCBIng4.getSelectedItem() != null) {
            JTF4.setEnabled(true);
        } else {
            JTF4.setText("");
            JTF4.setEnabled(false);
        }
        if (JCBIng5.getSelectedItem() != null) {
            JTF5.setEnabled(true);
        } else {
            JTF5.setText("");
            JTF5.setEnabled(false);
        }
    }

    public boolean controlPesos() {
        Ingredientes ele1 = (Ingredientes) JCBIng1.getSelectedItem();
        Ingredientes ele2 = (Ingredientes) JCBIng2.getSelectedItem();
        Ingredientes ele3 = (Ingredientes) JCBIng3.getSelectedItem();
        Ingredientes ele4 = (Ingredientes) JCBIng4.getSelectedItem();
        Ingredientes ele5 = (Ingredientes) JCBIng5.getSelectedItem();

        // Set para almacenar los IDs de los ingredientes seleccionados
        Set<Integer> ingredientesSeleccionados = new HashSet<>();
        boolean validPesos = true;
        int cant = 0;

        try {
            double a = 0;
            double b = 0;
            double c = 0;
            double d = 0;
            double e = 0;

            if (ele1 != null) {
                if (ingredientesSeleccionados.contains(ele1.getIdIngredientes())) {
                    JCBIng1.setSelectedItem(null);
                    validPesos = false;
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ele1.getNombre() + " ya fue seleccionado.");
                } else {
                    ingredientesSeleccionados.add(ele1.getIdIngredientes());
                    if (!JTF1.getText().isEmpty()) {
                        a = Double.parseDouble(JTF1.getText());
                        if (a > 0) {
                            ingredientesPesos.put(ele1.getIdIngredientes(), a);
                            cant++;
                        } else {
                            validPesos = false;
                            JOptionPane.showMessageDialog(this, "Ingrese peso valido y mayor a 0 en el primer ingrediente");
                        }
                    } else {
                        validPesos = false;
                        JOptionPane.showMessageDialog(this, "Ingrese peso valido para el primer ingrediente");
                    }
                }
            }

            if (ele2 != null) {
                if (ingredientesSeleccionados.contains(ele2.getIdIngredientes())) {
                    JCBIng2.setSelectedItem(null);
                    validPesos = false;
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ele2.getNombre() + " ya fue seleccionado.");
                } else {
                    ingredientesSeleccionados.add(ele2.getIdIngredientes());
                    if (!JTF2.getText().isEmpty()) {
                        b = Double.parseDouble(JTF2.getText());
                        if (b > 0) {
                            ingredientesPesos.put(ele2.getIdIngredientes(), b);
                            cant++;
                        } else {
                            validPesos = false;
                            JOptionPane.showMessageDialog(this, "Ingrese peso valido y mayor a 0 en el segundo ingrediente");
                        }
                    } else {
                        validPesos = false;
                        JOptionPane.showMessageDialog(this, "Ingrese peso valido para el segundo ingrediente");
                    }
                }
            }

            if (ele3 != null) {
                if (ingredientesSeleccionados.contains(ele3.getIdIngredientes())) {
                    JCBIng3.setSelectedItem(null);
                    validPesos = false;
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ele3.getNombre() + " ya fue seleccionado.");
                } else {
                    ingredientesSeleccionados.add(ele3.getIdIngredientes());
                    if (!JTF3.getText().isEmpty()) {
                        c = Double.parseDouble(JTF3.getText());
                        if (c > 0) {
                            ingredientesPesos.put(ele3.getIdIngredientes(), c);
                            cant++;
                        } else {
                            validPesos = false;
                            JOptionPane.showMessageDialog(this, "Ingrese peso valido y mayor a 0 en el tercer ingrediente");
                        }
                    } else {
                        validPesos = false;
                        JOptionPane.showMessageDialog(this, "Ingrese peso valido para el tercer ingrediente");
                    }
                }
            }

            if (ele4 != null) {
                if (ingredientesSeleccionados.contains(ele4.getIdIngredientes())) {
                    JCBIng4.setSelectedItem(null);
                    validPesos = false;
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ele4.getNombre() + " ya fue seleccionado.");
                } else {
                    ingredientesSeleccionados.add(ele4.getIdIngredientes());
                    if (!JTF4.getText().isEmpty()) {
                        d = Double.parseDouble(JTF4.getText());
                        if (d > 0) {
                            ingredientesPesos.put(ele4.getIdIngredientes(), d);
                            cant++;
                        } else {
                            validPesos = false;
                            JOptionPane.showMessageDialog(this, "Ingrese peso valido y mayor a 0 en el cuarto ingrediente");
                        }
                    } else {
                        validPesos = false;
                        JOptionPane.showMessageDialog(this, "Ingrese peso valido para el cuarto ingrediente");
                    }
                }
            }

            if (ele5 != null) {
                if (ingredientesSeleccionados.contains(ele5.getIdIngredientes())) {
                    JCBIng5.setSelectedItem(null);
                    validPesos = false;
                    JOptionPane.showMessageDialog(this, "El ingrediente " + ele5.getNombre() + " ya fue seleccionado.");
                } else {
                    ingredientesSeleccionados.add(ele5.getIdIngredientes());
                    if (!JTF5.getText().isEmpty()) {
                        e = Double.parseDouble(JTF5.getText());
                        if (e > 0) {
                            ingredientesPesos.put(ele5.getIdIngredientes(), e);
                            cant++;
                        } else {
                            validPesos = false;
                            JOptionPane.showMessageDialog(this, "Ingrese peso valido y mayor a 0 en el quinto ingrediente");
                        }
                    } else {
                        validPesos = false;
                        JOptionPane.showMessageDialog(this, "Ingrese peso valido para el quinto ingrediente");
                    }
                }
            }

            if (cant < 2) {
                validPesos = false;
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos 2 ingredientes con pesos validos.");
            }
        } catch (NumberFormatException | NullPointerException ex) {
            validPesos = false;
            JOptionPane.showMessageDialog(this, "Ingrese valores validos para los pesos");
        }

        return validPesos;
    }

    private void enlistarPacientes() {
        ArrayList<Comidas> lista = cd.listarComidas();
        modelo.setRowCount(0);
        if (!lista.isEmpty()) {
            for (Comidas com : lista) {
                ArrayList<String> listIngre = new ArrayList<>();
                int idcom = com.getIdComida();
                HashMap<Integer, Double> ingrePesos = cd.buscarIngredientesComidas(idcom);
                if (ingrePesos != null && !ingrePesos.isEmpty()) {
                    for (Map.Entry<Integer, Double> entry : ingrePesos.entrySet()) {
                        Ingredientes ing = id.buscarIngredientes(entry.getKey());
                        if (ing != null) {
                            String ingre = ing.getNombre() + ": " + entry.getValue();
                            listIngre.add(ingre);
                        } else {
                            listIngre.add("Ingrediente no encontrado");
                        }
                    }
                }
                String[] ingredientes = new String[5];
                for (int i = 0; i < 5; i++) {
                    if (i < listIngre.size()) {
                        ingredientes[i] = listIngre.get(i);
                    } else {
                        ingredientes[i] = "";
                    }
                }
                modelo.addRow(new Object[]{
                    com.getIdComida(),
                    com.getNombre(),
                    com.getTipoDeComida(),
                    com.getCaloriasComida(),
                    com.getNoApto(),
                    ingredientes[0], ingredientes[1], ingredientes[2], ingredientes[3], ingredientes[4],
                    com.isEstado()
                });
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlta;
    private javax.swing.JButton JBBaja;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBNuevo;
    private javax.swing.JComboBox<Ingredientes> JCBIng1;
    private javax.swing.JComboBox<Ingredientes> JCBIng2;
    private javax.swing.JComboBox<Ingredientes> JCBIng3;
    private javax.swing.JComboBox<Ingredientes> JCBIng4;
    private javax.swing.JComboBox<Ingredientes> JCBIng5;
    private javax.swing.JComboBox<String> JCBTipo;
    private javax.swing.JTextField JTF1;
    private javax.swing.JTextField JTF2;
    private javax.swing.JTextField JTF3;
    private javax.swing.JTextField JTF4;
    private javax.swing.JTextField JTF5;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFid;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTComidas;
    // End of variables declaration//GEN-END:variables
}
