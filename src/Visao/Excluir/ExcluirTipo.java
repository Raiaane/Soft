/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Excluir;

import DAO.Conexao;
import DAO.TipoDAO;
import Modelo.Tipo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Raiane
 */
public class ExcluirTipo extends javax.swing.JFrame {

    /**
     * Creates new form ExcluirTipo
     */
    public ExcluirTipo() {
        initComponents();
        AtualizaCombo();
    }
    private void AtualizaCombo(){
        
        Connection con = Conexao.AbrirConexao();
       TipoDAO sql = new TipoDAO(con);
        List<Tipo> lista = new ArrayList<>();
        lista =  sql.ListarComboTipo();
        nome.addItem("");
        
        for(Tipo b :lista){
        
            nome.addItem(b.getNome());
        
        }
    
        Conexao.FecharConexao(con);
    
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
        jLabel3 = new javax.swing.JLabel();
        codi = new javax.swing.JTextField();
        nome = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EXCLUIR TIPO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 10, 160, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NOME");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 120, 43, 17);
        getContentPane().add(codi);
        codi.setBounds(100, 120, 60, 20);

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(170, 120, 200, 20);

        jButton2.setText("EXCLUIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 220, 80, 30);

        jButton3.setText("LIMPAR");
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 223, 80, 30);

        jButton1.setText("SAIR");
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 220, 80, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/scol.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 50, 520, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
         Connection con = Conexao.AbrirConexao();
      TipoDAO sql = new TipoDAO(con);
      List<Tipo> lista = new ArrayList<>();
        String nom = nome.getSelectedItem().toString();

        lista = sql. ConsultaCodigoTipo(nom);

        for(Tipo b : lista){
            int a = b.getCod();
            codi.setText(""+ a);
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_nomeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String cod = codi.getText();
        String nom = nome.getSelectedItem().toString();

        Connection con = Conexao.AbrirConexao();
        TipoDAO sql = new TipoDAO(con);
        Tipo c = new Tipo();

        if(nom.equals("")){
            JOptionPane.showMessageDialog(null,"Nenhum Nome selecionado",
                    "equipamento",JOptionPane.WARNING_MESSAGE);
        }else{
            int b = JOptionPane.showConfirmDialog(null,"Deseja realmene excluir \n "
                    + "("+cod+") ("+nom+")","Equipamento",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(b==0){
                int codigo = Integer.parseInt(cod);
                c.setCod(codigo);
                c.setNome(nom);
                sql.ExcluirTipo(c);
                Conexao.FecharConexao(con);
                dispose();
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ExcluirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExcluirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExcluirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExcluirTipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirTipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> nome;
    // End of variables declaration//GEN-END:variables
}
