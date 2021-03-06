/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class VentanaVigentesPorCriterios extends javax.swing.JFrame {
    private FactorSanguineo factorSanguineoSeleccionado;
    private GrupoSanguineo grupoSanguineoSeleccionado;
    final public GrupoSanguineo[] grupoSanguineos = GrupoSanguineo.values();
    final public FactorSanguineo[] factorSanguineos = FactorSanguineo.values();

    private List<Carnet> carnetsVigentes;
    
    /**
     * Creates new form VentanaVigentesPorCriterios
     */
    public VentanaVigentesPorCriterios() {
        initComponents();
        
        carnetsVigentes = new ArrayList<>();
        
        try {
            completarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCGSanguineo = new javax.swing.JComboBox<>();
        jLFSanguineo = new javax.swing.JLabel();
        jCFSanguineo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCBDonante = new javax.swing.JComboBox<>();
        jBBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTCriterios = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jBImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar licencias vigentes");

        jLabel1.setText("Apellidos:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Grupo sanguíneo:");

        jCGSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "AB", "O" }));
        jCGSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCGSanguineoActionPerformed(evt);
            }
        });

        jLFSanguineo.setText("Factor sanguíneo");

        jCFSanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "+", "-" }));
        jCFSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCFSanguineoActionPerformed(evt);
            }
        });

        jLabel4.setText("Donante");

        jCBDonante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Sí", "No" }));
        jCBDonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDonanteActionPerformed(evt);
            }
        });

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Buscar licencias vigentes");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel17.setText("Ingrese los criterios de búsqueda (opcionales).");

        JTCriterios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de licencia", "Fecha de expiración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTCriterios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTCriterios.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        JTCriterios.setPreferredSize(new java.awt.Dimension(357, 1000));
        JTCriterios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTCriteriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTCriterios);

        jBImprimir.setText("Imprimir...");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCGSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLFSanguineo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCFSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBDonante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBBuscar)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBImprimir)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jCGSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLFSanguineo)
                    .addComponent(jCFSanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jCBDonante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        
        try {
            completarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void JTCriteriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTCriteriosMouseClicked

        if (evt.getClickCount() == 2){
            int fila = JTCriterios.getSelectedRow();
            
            Carnet c = carnetsVigentes.get(fila);
            
            VentanaDetallesCarnet ventanaDetallesCarnet = new VentanaDetallesCarnet(null, true, c, 0);
            ventanaDetallesCarnet.setVisible(true);
        }
    }//GEN-LAST:event_JTCriteriosMouseClicked

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        if(carnetsVigentes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista para imprimir.");
            return;
        }
        
        try {
            pdf unPdf = new pdf();
            unPdf.imprimirListaCarnets(carnetsVigentes, "Listado de Licencias Vigentes", false);
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de escritura al generar el PDF.");
        } 
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jCGSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCGSanguineoActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String nombreGrupoSanguineo = (String)cb.getSelectedItem();
        
        grupoSanguineoSeleccionado = null;
        for (GrupoSanguineo unGrupoSanguineo: grupoSanguineos) {
            if (unGrupoSanguineo.nombre.equals(nombreGrupoSanguineo)) {
                grupoSanguineoSeleccionado = unGrupoSanguineo;
                break;
            }
        }
    }//GEN-LAST:event_jCGSanguineoActionPerformed

    private void jCFSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCFSanguineoActionPerformed
        factorSanguineoSeleccionado = null;
        
        JComboBox cb = (JComboBox)evt.getSource();
        String cad = cb.getSelectedItem().toString().replaceAll("\\s+","");
        char nombreFactorSanguineo = (cad.isEmpty()) ? ' ' : cad.charAt(0);
        
        
        for (FactorSanguineo unFactorSanguineo: factorSanguineos) {
            if (unFactorSanguineo.signo == nombreFactorSanguineo) {
                factorSanguineoSeleccionado = unFactorSanguineo;
                break;
            }
        }
    }//GEN-LAST:event_jCFSanguineoActionPerformed

    private void jCBDonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDonanteActionPerformed
        
    }//GEN-LAST:event_jCBDonanteActionPerformed

    private void completarTabla() throws SQLException {
        Optional<String> apellidos = Optional.ofNullable(jTApellidos.getText()).filter(s -> !s.isEmpty());
        Optional<String> nombres = Optional.ofNullable(jTNombres.getText()).filter(s -> !s.isEmpty());
        Boolean esDonante = null;

        if (!jCBDonante.getSelectedItem().equals(" ")) {
            esDonante = jCBDonante.getSelectedItem().equals("Sí");
        }

        Criterios criterios = new Criterios(
                apellidos,
                nombres,
                Optional.ofNullable(grupoSanguineoSeleccionado),
                Optional.ofNullable(factorSanguineoSeleccionado),
                Optional.ofNullable(esDonante)
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        carnetsVigentes = DAOCarnet.vigentesPorCriterios(criterios);

        //Borramos todas las filas
        DefaultTableModel model = (DefaultTableModel) JTCriterios.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        //llenamos el modelo con la lista
        carnetsVigentes.forEach((c) -> {
            model.addRow(new Object[]{c.getNumero().get(), c.getExpiracion().format(formatter)});
        });
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVigentesPorCriterios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVigentesPorCriterios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTCriterios;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JComboBox<String> jCBDonante;
    private javax.swing.JComboBox<String> jCFSanguineo;
    private javax.swing.JComboBox<String> jCGSanguineo;
    private javax.swing.JLabel jLFSanguineo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTApellidos;
    private javax.swing.JTextField jTNombres;
    // End of variables declaration//GEN-END:variables
}
