
package main;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import metodosnumericos.SistemaEcuacionesLineales;


/**
 *
 * @author Jedabero
 */
public class MetodosMatrices extends javax.swing.JFrame {

    /**
     * Creates new form MetodosMatrices
     */
    public MetodosMatrices() {
        
        for (int i = 0; i<tableHeaders.length-1; i++) {
            tableHeaders[i] = "<html>x<sub>"+(i+1)+"</sub></html>";
        }
        tableHeaders[tableHeaders.length-1] = "<html>b</html>";
        
        matrizTabla = new Double[2][3];
        double mt[][] = new double[2][3];
        for (int i = 0; i < matrizTabla.length; i++) {
            for (int j = 0; j < matrizTabla[0].length; j++) {
                matrizTabla[i][j] = Double.parseDouble(""+1);
                mt[i][j] = matrizTabla[i][j].doubleValue();
            }
        }
        
        sel = new SistemaEcuacionesLineales(mt);
        dtmMatriz = new javax.swing.table.DefaultTableModel(matrizTabla,tableHeaders);
        
        Object mt2[][] = new Object[2][3];
        dtmMetodo = new javax.swing.table.DefaultTableModel(mt2,tableHeaders);
        
        Object mt3[][] = new Object[2][2];
        dtmRes = new javax.swing.table.DefaultTableModel(mt3,resTableHeaders);
        
        initComponents();
        
        this.setLocationRelativeTo(this.getRootPane());
    }
    
    private void resetTable(int cols, int rows){
        tableHeaders = new String[cols];
        for (int i = 0; i<tableHeaders.length-1; i++) {
            tableHeaders[i] = "<html>x<sub>"+(i+1)+"</sub></html>";
        }
        tableHeaders[tableHeaders.length-1] = "<html>b</html>";
        
        double mt[][] = new double[rows-1][cols-1];
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt[0].length; j++) {
                System.out.println(tablaMatriz.getValueAt(i, j).toString());
                mt[i][j] = Double.parseDouble(tablaMatriz.getValueAt(i, j).toString());
            }
        }
        
        matrizTabla = new Double[rows][cols];
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt[0].length; j++) {
                matrizTabla[i][j] = new Double(mt[i][j]);
            }
        }
        
        for (int i = 0; i < matrizTabla.length; i++) {
            matrizTabla[i][matrizTabla[0].length-1] = Double.parseDouble(""+1);
        }
        for (int j = 0; j < matrizTabla[0].length; j++) {
            matrizTabla[matrizTabla.length-1][j] = Double.parseDouble(""+1);
        }
        
        mt = new double[rows][cols];
        for (int i = 0; i < matrizTabla.length; i++) {
            for (int j = 0; j < matrizTabla[0].length; j++) {
                System.out.println("("+i+","+j+")"+matrizTabla[i][j]);
                mt[i][j] = matrizTabla[i][j].doubleValue();
            }
        }
        
        sel = new SistemaEcuacionesLineales(mt);
        dtmMatriz = new javax.swing.table.DefaultTableModel(matrizTabla,tableHeaders);
        tablaMatriz.setModel(dtmMatriz);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMatriz = new javax.swing.JTable(){
            public boolean getScrollableTracksViewportWidth(){
                return getPreferredSize().width < getParent().getWidth();
            }
        };
        lblNumEc = new javax.swing.JLabel();
        spnrNumEc = new javax.swing.JSpinner();
        lblNumIncog = new javax.swing.JLabel();
        spnrNumIn = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResAn = new javax.swing.JTable();
        btnGauss = new javax.swing.JButton();
        btnJordan = new javax.swing.JButton();
        btnJacobi = new javax.swing.JButton();
        btnSeidel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaResIt = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        spnIter = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        txtTol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solucion de Sistemas de Ecuaciones Lineales");

        tablaMatriz.setModel(dtmMatriz);
        jScrollPane1.setViewportView(tablaMatriz);

        lblNumEc.setText("Numero de ecuaciones:");

        spnrNumEc.setModel(new javax.swing.SpinnerNumberModel(2, 2, 25, 1));
        spnrNumEc.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnrNumEcStateChanged(evt);
            }
        });

        lblNumIncog.setText("Número de incognitas:");

        spnrNumIn.setModel(new javax.swing.SpinnerNumberModel(2, 2, 25, 1));
        spnrNumIn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnrNumInStateChanged(evt);
            }
        });

        tablaResAn.setModel(dtmMetodo);
        jScrollPane2.setViewportView(tablaResAn);

        btnGauss.setText("Gauss");
        btnGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaussActionPerformed(evt);
            }
        });

        btnJordan.setText("Jordan");
        btnJordan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJordanActionPerformed(evt);
            }
        });

        btnJacobi.setText("Jacobi");
        btnJacobi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJacobiActionPerformed(evt);
            }
        });

        btnSeidel.setText("Seidel");
        btnSeidel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeidelActionPerformed(evt);
            }
        });

        jLabel1.setText("Matriz de ecuaciones");

        jLabel2.setText("Matriz resultante:");

        jLabel3.setText("Resolver:");

        tablaResIt.setModel(dtmRes);
        jScrollPane3.setViewportView(tablaResIt);

        jLabel4.setText("Iteraciones");

        spnIter.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(15), Integer.valueOf(5), null, Integer.valueOf(1)));

        jLabel5.setText("Tolerancia");

        txtTol.setColumns(8);
        txtTol.setText("0.001");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNumEc)
                                .addGap(18, 18, 18)
                                .addComponent(spnrNumEc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumIncog)
                                .addGap(18, 18, 18)
                                .addComponent(spnrNumIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGauss)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnJordan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnJacobi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeidel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnIter, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumIncog)
                        .addComponent(spnrNumIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumEc)
                        .addComponent(spnrNumEc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGauss)
                    .addComponent(btnJordan)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJacobi)
                    .addComponent(btnSeidel)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(spnIter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnrNumEcStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnrNumEcStateChanged
        // TODO add your handling code here:
        numEc = Integer.parseInt(((javax.swing.JSpinner) evt.getSource()).getValue().toString());
        System.out.println("Numero de ecuaciones:"+numEc);
        resetTable(numInc+1, numEc);
    }//GEN-LAST:event_spnrNumEcStateChanged

    private void spnrNumInStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnrNumInStateChanged
        // TODO add your handling code here:
        numInc = Integer.parseInt(((javax.swing.JSpinner) evt.getSource()).getValue().toString());
        System.out.println("Numero de incognitas:"+numInc);
        if(numInc>numEc){
            JOptionPane.showMessageDialog(this, "No hay solución si hay más incognitas que ecuaciones.");
            spnrNumIn.setValue(spnrNumEc.getValue());
        }
        resetTable(numInc+1, numEc);
    }//GEN-LAST:event_spnrNumInStateChanged

    private void btnGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaussActionPerformed
        creaMatriz();
        mostrarTabla(sel.metodoGauss().getMatriz(), dtmMetodo, tableHeaders,
                tablaResAn);
    }//GEN-LAST:event_btnGaussActionPerformed

    private void btnJordanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJordanActionPerformed
        creaMatriz();
        mostrarTabla(sel.metodoJordan().getMatriz(), dtmRes, tableHeaders,
                tablaResAn);
    }//GEN-LAST:event_btnJordanActionPerformed

    private void btnJacobiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJacobiActionPerformed
        creaMatriz();
        try {
            int it = Integer.parseInt(spnIter.getValue().toString());
            double tol = Double.parseDouble(txtTol.getText());
            mostrarTabla(sel.metodoJacobi(it, tol).getMatriz(), dtmRes,
                    resTableHeaders, tablaResIt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnJacobiActionPerformed

    private void btnSeidelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeidelActionPerformed
        creaMatriz();
        try {
            int it = Integer.parseInt(spnIter.getValue().toString());
            double tol = Double.parseDouble(txtTol.getText());
            mostrarTabla(sel.metodoSeidel(it, tol).getMatriz(), dtmRes,
                    resTableHeaders, tablaResIt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSeidelActionPerformed

    public void creaMatriz(){
        double[][] mt = new double[matrizTabla.length][matrizTabla[0].length];
        for (int i = 0; i < matrizTabla.length; i++) {
            for (int j = 0; j < matrizTabla[0].length; j++) {
                String v = tablaMatriz.getValueAt(i, j).toString();
                if(v.isEmpty()){
                    v = "1";
                }
                mt[i][j] = Double.parseDouble(v);

            }
        }
        sel = new SistemaEcuacionesLineales(mt);
    }
    public void mostrarTabla(double[][] mt, DefaultTableModel dtm,
            String[] th, JTable t){
        Object[][] obj = new Object[mt.length][mt[0].length];
        for (int i = 0; i < mt.length; i++) {
            for (int j = 0; j < mt[0].length; j++) {
                obj[i][j] = mt[i][j];
            }
        }
        
        dtm = new javax.swing.table.DefaultTableModel(obj, th);
        
        t.setModel(dtm);
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
            java.util.logging.Logger.getLogger(MetodosMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodosMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodosMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodosMatrices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MetodosMatrices().setVisible(true);
            }
        });
    }
    private int numEc = 2;
    private int numInc = 2;
    private String[] tableHeaders = new String[numInc+1];
    private String resTableHeaders[]
            = {"<html>x<sub>i</sub></html>", "<html>e<sub>i</sub></html>"};
    private Double matrizTabla[][];
    
    private SistemaEcuacionesLineales sel;
    private javax.swing.table.DefaultTableModel dtmMatriz;
    private javax.swing.table.DefaultTableModel dtmMetodo;
    private javax.swing.table.DefaultTableModel dtmRes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGauss;
    private javax.swing.JButton btnJacobi;
    private javax.swing.JButton btnJordan;
    private javax.swing.JButton btnSeidel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNumEc;
    private javax.swing.JLabel lblNumIncog;
    private javax.swing.JSpinner spnIter;
    private javax.swing.JSpinner spnrNumEc;
    private javax.swing.JSpinner spnrNumIn;
    private javax.swing.JTable tablaMatriz;
    private javax.swing.JTable tablaResAn;
    private javax.swing.JTable tablaResIt;
    private javax.swing.JTextField txtTol;
    // End of variables declaration//GEN-END:variables
}