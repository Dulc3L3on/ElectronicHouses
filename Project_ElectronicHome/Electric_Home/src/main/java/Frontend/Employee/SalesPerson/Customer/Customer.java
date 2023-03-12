/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.Employee.SalesPerson.Customer;

/**
 *
 * @author phily
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form SalesPerson_NewCustomer
     */
    public Customer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_customer_new = new javax.swing.JPanel();
        panel_customer_photo = new javax.swing.JPanel();
        lbl_customer_photo = new javax.swing.JLabel();
        lbl_customer_CUI = new javax.swing.JLabel();
        lbl_customer_name = new javax.swing.JLabel();
        lbl_customer_NIT = new javax.swing.JLabel();
        lbl_customer_adress = new javax.swing.JLabel();
        lbl_customer_dateOfJoining = new javax.swing.JLabel();
        spinner_customer_DateJoining = new javax.swing.JSpinner();
        txtF_customer_adress = new javax.swing.JTextField();
        txtF_customer_NIT = new javax.swing.JTextField();
        txtF_customer_name = new javax.swing.JTextField();
        txtF_customer_CUI = new javax.swing.JTextField();
        btn_customer_SAVE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel_customer_new.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        panel_customer_photo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panel_customer_photoLayout = new javax.swing.GroupLayout(panel_customer_photo);
        panel_customer_photo.setLayout(panel_customer_photoLayout);
        panel_customer_photoLayout.setHorizontalGroup(
            panel_customer_photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_customer_photoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_customer_photo, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_customer_photoLayout.setVerticalGroup(
            panel_customer_photoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_customer_photoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_customer_photo, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_customer_CUI.setText("CUI");

        lbl_customer_name.setText("Name:");

        lbl_customer_NIT.setText("NIT:");

        lbl_customer_adress.setText("Adress:");

        lbl_customer_dateOfJoining.setText("Date of joining:");

        spinner_customer_DateJoining.setEnabled(false);

        txtF_customer_CUI.setEditable(false);
        txtF_customer_CUI.setText("SHA5 base on NIT");

        btn_customer_SAVE.setText("SAVE");

        javax.swing.GroupLayout panel_customer_newLayout = new javax.swing.GroupLayout(panel_customer_new);
        panel_customer_new.setLayout(panel_customer_newLayout);
        panel_customer_newLayout.setHorizontalGroup(
            panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customer_newLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_customer_newLayout.createSequentialGroup()
                        .addComponent(lbl_customer_CUI)
                        .addGap(18, 18, 18)
                        .addComponent(txtF_customer_CUI))
                    .addComponent(panel_customer_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_customer_newLayout.createSequentialGroup()
                        .addComponent(lbl_customer_adress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtF_customer_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_customer_newLayout.createSequentialGroup()
                            .addComponent(lbl_customer_NIT)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtF_customer_NIT, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_customer_newLayout.createSequentialGroup()
                            .addComponent(lbl_customer_dateOfJoining)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spinner_customer_DateJoining, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_customer_newLayout.createSequentialGroup()
                            .addComponent(lbl_customer_name)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtF_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_customer_SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panel_customer_newLayout.setVerticalGroup(
            panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customer_newLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel_customer_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_customer_newLayout.createSequentialGroup()
                        .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinner_customer_DateJoining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customer_dateOfJoining))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF_customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customer_name))
                        .addGap(24, 24, 24)
                        .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtF_customer_adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customer_adress))
                        .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_customer_newLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtF_customer_NIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_customer_newLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_customer_NIT)))))
                .addGap(18, 18, 18)
                .addGroup(panel_customer_newLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_customer_CUI)
                    .addComponent(txtF_customer_CUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customer_SAVE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_customer_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_customer_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //el botón cb a EDIT, luego de presionarlo una vez para que no haya errores
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_customer_SAVE;
    private javax.swing.JLabel lbl_customer_CUI;
    private javax.swing.JLabel lbl_customer_NIT;
    private javax.swing.JLabel lbl_customer_adress;
    private javax.swing.JLabel lbl_customer_dateOfJoining;
    private javax.swing.JLabel lbl_customer_name;
    private javax.swing.JLabel lbl_customer_photo;
    private javax.swing.JPanel panel_customer_new;
    private javax.swing.JPanel panel_customer_photo;
    private javax.swing.JSpinner spinner_customer_DateJoining;
    private javax.swing.JTextField txtF_customer_CUI;
    private javax.swing.JTextField txtF_customer_NIT;
    private javax.swing.JTextField txtF_customer_adress;
    private javax.swing.JTextField txtF_customer_name;
    // End of variables declaration//GEN-END:variables
}