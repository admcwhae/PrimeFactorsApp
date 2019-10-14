package app;

import gui.Prime_GUI;

/**
 *
 * @author Alex McWhae
 */
public class Prime_GUIApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Prime_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prime_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prime_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prime_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                
                        /**
         * NetBeans is using "java.awt.EventQutue.invokeLater()"
         * - this does not work when Swing component are changed.
         * 
         * Change it to use "javax.swing.SwingUtilities.invokeLater()"
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Prime_GUI().setVisible(true);
            }
        });
    }
    
}
