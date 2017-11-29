/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 *
 * @author user
 */
public class VentanaAltaTitular extends javax.swing.JDialog {
    private final VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) this.getParent();
    private final ComboBoxModel<String> tipoDNIModel;
    private final ComboBoxModel<String> grupoSanguineoModel;
    private final ComboBoxModel<String> factorSanguineoModel;
    private boolean esDonanteSeleccionado;
    private TipoDocumento tipoDocumentoSeleccionado;
    private FactorSanguineo factorSanguineoSeleccionado;
    private GrupoSanguineo grupoSanguineoSeleccionado;
    
    /**
     * Creates new form VentanaEmitir
     */
    public VentanaAltaTitular(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        // Init tipoDNICombo
        ArrayList<String> tipoDNIModelItems = new ArrayList<>();
        for (TipoDocumento tipoDocumento: ventanaPrincipal.tipoDocumentos) {
            tipoDNIModelItems.add(tipoDocumento.nombre);
        }
        tipoDNIModel = new DefaultComboBoxModel(tipoDNIModelItems.toArray());
        
        // Init grupoSanguineoCombo
        ArrayList<String> grupoSanguineoModelItems = new ArrayList<>();
        for (GrupoSanguineo grupoSanguineo: ventanaPrincipal.grupoSanguineos) {
            grupoSanguineoModelItems.add(grupoSanguineo.nombre);
        }
        grupoSanguineoModel = new DefaultComboBoxModel(grupoSanguineoModelItems.toArray());
        
        // Init factorSanguineoCombo
        ArrayList<Character> factorSanguineoModelItems = new ArrayList<>();
        for (FactorSanguineo factorSanguineo: ventanaPrincipal.factorSanguineos) {
            factorSanguineoModelItems.add(factorSanguineo.signo);
        }
        factorSanguineoModel = new DefaultComboBoxModel(factorSanguineoModelItems.toArray());
        
        initComponents();
        
        tipoDNICombo.setSelectedIndex(0);
        grupoSanguineoCombo.setSelectedIndex(0);
        factorSanguineoCombo.setSelectedIndex(0);
        esDonanteSeleccionado = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tipoDNICombo = new javax.swing.JComboBox<>();
        nroDNITextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        nombresTextField = new javax.swing.JTextField();
        fechaNacimientoTextField = new javax.swing.JTextField();
        domicilioTextField = new javax.swing.JTextField();
        grupoSanguineoCombo = new javax.swing.JComboBox<>();
        factorSanguineoCombo = new javax.swing.JComboBox<>();
        altaBtn = new javax.swing.JButton();
        esDonanteCheckbox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Titular");

        jLabel1.setText("Tipo de documento:");

        jLabel2.setText("Número de documento:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Nombres:");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("Domicilio:");

        jLabel7.setText("Grupo sanguíneo:");

        jLabel8.setText("Factor sanguíneo:");

        jLabel9.setText("Donante:");

        tipoDNICombo.setModel(tipoDNIModel);
        tipoDNICombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDNIComboActionPerformed(evt);
            }
        });

        grupoSanguineoCombo.setModel(grupoSanguineoModel);
        grupoSanguineoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grupoSanguineoComboActionPerformed(evt);
            }
        });

        factorSanguineoCombo.setModel(factorSanguineoModel);
        factorSanguineoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorSanguineoComboActionPerformed(evt);
            }
        });

        altaBtn.setText("Dar de alta...");
        altaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titularBtnActionPerformed(evt);
            }
        });

        esDonanteCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esDonanteCheckboxActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Dar de alta un titular");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel17.setText("Ingrese los datos del titular a añadir al sistema.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(tipoDNICombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(altaBtn)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nroDNITextField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidosTextField)
                                .addComponent(nombresTextField)
                                .addComponent(fechaNacimientoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(domicilioTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addComponent(grupoSanguineoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(esDonanteCheckbox)
                                .addComponent(factorSanguineoCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel11)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipoDNICombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nroDNITextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fechaNacimientoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(domicilioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(grupoSanguineoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(factorSanguineoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(esDonanteCheckbox))
                .addGap(5, 5, 5)
                .addComponent(altaBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void titularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titularBtnActionPerformed

        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoTextField.getText(), formatter);
            
            if (nroDNITextField.getText().equals("")) { throw new CampoVacioException("DNI"); }
            if (apellidosTextField.getText().equals("")) { throw new CampoVacioException("Apellidos"); }
            if (nombresTextField.getText().equals("")) { throw new CampoVacioException("Nombres"); }
            if (domicilioTextField.getText().equals("")) { throw new CampoVacioException("Domicilio"); }
            if (fechaNacimientoTextField.getText().equals("")) { throw new CampoVacioException("Fecha de Nacimiento"); }
            
            Titular unTitular = new Titular(tipoDocumentoSeleccionado, nroDNITextField.getText(), apellidosTextField.getText(), nombresTextField.getText(), fechaNacimiento, domicilioTextField.getText(), grupoSanguineoSeleccionado, factorSanguineoSeleccionado, esDonanteSeleccionado);
            
            // retorno = DAOTitular.insertar(unTitular);

            int seleccion = JOptionPane.showOptionDialog(
                            ventanaPrincipal,
                            "Se esta por crear el titular: " + unTitular.getApellidos() + " " + unTitular.getNombres() + "\n", 
                            "",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
                            "Aceptar");
            
            if (seleccion == 0)
            {
                int retorno = DAOTitular.insertar(unTitular);
                
                if (retorno > 0)
                {
                    JOptionPane.showOptionDialog(
                            ventanaPrincipal,
                            "Se ha creado correctamente el titular.", 
                            "",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Aceptar" },   // null para YES, NO y CANCEL
                            "Aceptar");
                    
                    setModal(false);
                    this.dispose();
                }
                else
                {
                    JOptionPane.showOptionDialog(
                            ventanaPrincipal,
                            "Ocurrio un error y no se pudo crear el nuevo titular.", 
                            "",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[] { "Aceptar" },   // null para YES, NO y CANCEL
                            "Aceptar");
                }
            }
        }
        catch (DateTimeParseException exc) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento debe ser válida y estar en formato dd/mm/yyyy.");
        }
        catch (CampoVacioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " no puede estar vacío.");
        }
    }//GEN-LAST:event_titularBtnActionPerformed

    
    private void tipoDNIComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDNIComboActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String nombreTipoDNI = (String)cb.getSelectedItem();
        
        for (TipoDocumento unTipoDocumento: ventanaPrincipal.tipoDocumentos) {
            if (unTipoDocumento.nombre.equals(nombreTipoDNI)) {
                tipoDocumentoSeleccionado = unTipoDocumento;
                break;
            }
        }
    }//GEN-LAST:event_tipoDNIComboActionPerformed

    private void grupoSanguineoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grupoSanguineoComboActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        String nombreGrupoSanguineo = (String)cb.getSelectedItem();
        
        for (GrupoSanguineo unGrupoSanguineo: ventanaPrincipal.grupoSanguineos) {
            if (unGrupoSanguineo.nombre.equals(nombreGrupoSanguineo)) {
                grupoSanguineoSeleccionado = unGrupoSanguineo;
                break;
            }
        }
    }//GEN-LAST:event_grupoSanguineoComboActionPerformed

    private void factorSanguineoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factorSanguineoComboActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        char nombreFactorSanguineo = (char)cb.getSelectedItem();
        
        for (FactorSanguineo unFactorSanguineo: ventanaPrincipal.factorSanguineos) {
            if (unFactorSanguineo.signo == nombreFactorSanguineo) {
                factorSanguineoSeleccionado = unFactorSanguineo;
                break;
            }
        }
    }//GEN-LAST:event_factorSanguineoComboActionPerformed

    private void esDonanteCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esDonanteCheckboxActionPerformed
        AbstractButton cb = (AbstractButton)evt.getSource();
        esDonanteSeleccionado = cb.getModel().isSelected();
    }//GEN-LAST:event_esDonanteCheckboxActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEmitir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaAltaTitular dialog = new VentanaAltaTitular(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton altaBtn;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JTextField domicilioTextField;
    private javax.swing.JCheckBox esDonanteCheckbox;
    private javax.swing.JComboBox<String> factorSanguineoCombo;
    private javax.swing.JTextField fechaNacimientoTextField;
    private javax.swing.JComboBox<String> grupoSanguineoCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombresTextField;
    private javax.swing.JTextField nroDNITextField;
    private javax.swing.JComboBox<String> tipoDNICombo;
    // End of variables declaration//GEN-END:variables

    private static class CampoVacioException extends Exception {
        public CampoVacioException(String campo) {
            super(campo);
        }
    }
}
