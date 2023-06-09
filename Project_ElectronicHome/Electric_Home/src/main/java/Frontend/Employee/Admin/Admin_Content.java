/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend.Employee.Admin;

/**
 *
 * @author phily
 */
public class Admin_Content extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Content
     */
    public Admin_Content() {
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

        group_filters = new javax.swing.ButtonGroup();
        group_distincion = new javax.swing.ButtonGroup();
        tabPane_admin_actions = new javax.swing.JTabbedPane();
        tab_admin_employee = new javax.swing.JPanel();
        panel_admin_employeeData = new javax.swing.JPanel();
        txtF_admin_ID = new javax.swing.JTextField();
        lbl_admin_store = new javax.swing.JLabel();
        cbBox_store = new javax.swing.JComboBox<>();
        lbl_admin_ID = new javax.swing.JLabel();
        lbl_admin_name = new javax.swing.JLabel();
        txtF_admin_name = new javax.swing.JTextField();
        radioButton_ID = new javax.swing.JRadioButton();
        radioButton_name = new javax.swing.JRadioButton();
        panel_admin_employee_filter = new javax.swing.JPanel();
        radioButton_filter_ID = new javax.swing.JRadioButton();
        radioButton_admin_name = new javax.swing.JRadioButton();
        radioButton_admin_lastName = new javax.swing.JRadioButton();
        radioButton_admin_dateSignIn = new javax.swing.JRadioButton();
        cbBox_filter = new javax.swing.JComboBox<>();
        panel_admin_employee_position = new javax.swing.JPanel();
        radioButton_admin_inventory = new javax.swing.JRadioButton();
        radioButton_admin_all = new javax.swing.JRadioButton();
        radioButton_admin_sales = new javax.swing.JRadioButton();
        radioButton_admin_store = new javax.swing.JRadioButton();
        panel_admin_employee_detail = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_admin_employees = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button_inventoryT1_search = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tab_admin_reports = new javax.swing.JPanel();
        panel_admin_reportSpecification = new javax.swing.JPanel();
        lbl_report_option1 = new javax.swing.JLabel();
        lbl_report_option3 = new javax.swing.JLabel();
        lbl_report_option4 = new javax.swing.JLabel();
        lbl_report_option7 = new javax.swing.JLabel();
        lbl_report_option6 = new javax.swing.JLabel();
        lbl_report_option5 = new javax.swing.JLabel();
        lbl_report_option9 = new javax.swing.JLabel();
        lbl_report_option8 = new javax.swing.JLabel();
        lbl_report_option2 = new javax.swing.JLabel();
        lbl_report_option10 = new javax.swing.JLabel();
        lbl_admin_topReports = new javax.swing.JLabel();
        panel_admin_viewReport = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel_admin_employeeData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Jamrul", 0, 13))); // NOI18N

        lbl_admin_store.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        lbl_admin_store.setText("Office:");

        cbBox_store.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All (lo sacarás de la tabla)" }));

        lbl_admin_ID.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        lbl_admin_ID.setText("ID:");

        lbl_admin_name.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        lbl_admin_name.setText("Name:");

        txtF_admin_name.setEditable(false);
        txtF_admin_name.setText("por si se les olvida su ID");

        group_distincion.add(radioButton_ID);
        radioButton_ID.setSelected(true);

        group_distincion.add(radioButton_name);

        javax.swing.GroupLayout panel_admin_employeeDataLayout = new javax.swing.GroupLayout(panel_admin_employeeData);
        panel_admin_employeeData.setLayout(panel_admin_employeeDataLayout);
        panel_admin_employeeDataLayout.setHorizontalGroup(
            panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                                .addComponent(radioButton_name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_admin_name)
                                .addGap(11, 11, 11)
                                .addComponent(txtF_admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(lbl_admin_store)
                                .addGap(18, 18, 18)
                                .addComponent(cbBox_store, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_admin_employeeDataLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radioButton_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_admin_ID)
                        .addGap(36, 36, 36)
                        .addComponent(txtF_admin_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        panel_admin_employeeDataLayout.setVerticalGroup(
            panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_admin_employeeDataLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton_ID)
                            .addComponent(txtF_admin_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_admin_employeeDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_admin_ID)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_admin_name)
                        .addComponent(txtF_admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radioButton_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_admin_employeeDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBox_store, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_admin_store))
                .addGap(16, 16, 16))
        );

        panel_admin_employee_filter.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        group_filters.add(radioButton_filter_ID);
        radioButton_filter_ID.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_filter_ID.setSelected(true);
        radioButton_filter_ID.setText("ID");

        group_filters.add(radioButton_admin_name);
        radioButton_admin_name.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_name.setText("Name");

        group_filters.add(radioButton_admin_lastName);
        radioButton_admin_lastName.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_lastName.setText("CUI");
        radioButton_admin_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButton_admin_lastNameActionPerformed(evt);
            }
        });

        group_filters.add(radioButton_admin_dateSignIn);
        radioButton_admin_dateSignIn.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_dateSignIn.setText("Date sign in");

        cbBox_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));

        javax.swing.GroupLayout panel_admin_employee_filterLayout = new javax.swing.GroupLayout(panel_admin_employee_filter);
        panel_admin_employee_filter.setLayout(panel_admin_employee_filterLayout);
        panel_admin_employee_filterLayout.setHorizontalGroup(
            panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employee_filterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbBox_filter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_admin_employee_filterLayout.createSequentialGroup()
                        .addGroup(panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton_admin_name)
                            .addComponent(radioButton_filter_ID))
                        .addGap(71, 71, 71)
                        .addGroup(panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton_admin_dateSignIn)
                            .addComponent(radioButton_admin_lastName))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        panel_admin_employee_filterLayout.setVerticalGroup(
            panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employee_filterLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbBox_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_admin_name)
                    .addComponent(radioButton_admin_lastName))
                .addGap(18, 18, 18)
                .addGroup(panel_admin_employee_filterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_filter_ID)
                    .addComponent(radioButton_admin_dateSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_admin_employee_position.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Position", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Jamrul", 0, 13))); // NOI18N

        radioButton_admin_inventory.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_inventory.setText("Inventory");

        radioButton_admin_all.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_all.setSelected(true);
        radioButton_admin_all.setText("All");

        radioButton_admin_sales.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_sales.setText("Sales");

        radioButton_admin_store.setFont(new java.awt.Font("Jamrul", 0, 13)); // NOI18N
        radioButton_admin_store.setText("Store");

        javax.swing.GroupLayout panel_admin_employee_positionLayout = new javax.swing.GroupLayout(panel_admin_employee_position);
        panel_admin_employee_position.setLayout(panel_admin_employee_positionLayout);
        panel_admin_employee_positionLayout.setHorizontalGroup(
            panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_admin_employee_positionLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radioButton_admin_sales)
                    .addComponent(radioButton_admin_store))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButton_admin_inventory)
                    .addComponent(radioButton_admin_all))
                .addGap(37, 37, 37))
        );
        panel_admin_employee_positionLayout.setVerticalGroup(
            panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employee_positionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_admin_sales)
                    .addComponent(radioButton_admin_inventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_admin_employee_positionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButton_admin_store)
                    .addComponent(radioButton_admin_all))
                .addGap(28, 28, 28))
        );

        table_admin_employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CUI", "Name", "Position", "Office", "Hired"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_admin_employees);
        if (table_admin_employees.getColumnModel().getColumnCount() > 0) {
            table_admin_employees.getColumnModel().getColumn(0).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(0).setPreferredWidth(70);
            table_admin_employees.getColumnModel().getColumn(1).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(1).setPreferredWidth(90);
            table_admin_employees.getColumnModel().getColumn(2).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(2).setPreferredWidth(225);
            table_admin_employees.getColumnModel().getColumn(3).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(3).setPreferredWidth(125);
            table_admin_employees.getColumnModel().getColumn(4).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(4).setPreferredWidth(125);
            table_admin_employees.getColumnModel().getColumn(5).setResizable(false);
            table_admin_employees.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/less.png"))); // NOI18N

        jLabel5.setText("UPdate");

        javax.swing.GroupLayout panel_admin_employee_detailLayout = new javax.swing.GroupLayout(panel_admin_employee_detail);
        panel_admin_employee_detail.setLayout(panel_admin_employee_detailLayout);
        panel_admin_employee_detailLayout.setHorizontalGroup(
            panel_admin_employee_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employee_detailLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_admin_employee_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panel_admin_employee_detailLayout.setVerticalGroup(
            panel_admin_employee_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_employee_detailLayout.createSequentialGroup()
                .addGroup(panel_admin_employee_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_admin_employee_detailLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3))
                    .addGroup(panel_admin_employee_detailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        button_inventoryT1_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchPlane.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ClearPlane.png"))); // NOI18N

        javax.swing.GroupLayout tab_admin_employeeLayout = new javax.swing.GroupLayout(tab_admin_employee);
        tab_admin_employee.setLayout(tab_admin_employeeLayout);
        tab_admin_employeeLayout.setHorizontalGroup(
            tab_admin_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_admin_employeeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panel_admin_employeeData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_admin_employee_position, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(panel_admin_employee_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tab_admin_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_inventoryT1_search)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24))
            .addComponent(panel_admin_employee_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab_admin_employeeLayout.setVerticalGroup(
            tab_admin_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_admin_employeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_admin_employeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_admin_employee_position, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tab_admin_employeeLayout.createSequentialGroup()
                        .addComponent(button_inventoryT1_search, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_admin_employeeData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_admin_employee_filter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(panel_admin_employee_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPane_admin_actions.addTab("Employees", tab_admin_employee);

        panel_admin_reportSpecification.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_report_option1.setText("     10 best-selling products");
        lbl_report_option1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option3.setText("     5 products with more profit");
        lbl_report_option3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option4.setText("     3 stores with more sales");
        lbl_report_option4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option7.setText("     3 employees with more incomes");
        lbl_report_option7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option6.setText("     3 employees with more sales");
        lbl_report_option6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option5.setText("     3 stores with more incomes ");
        lbl_report_option5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option9.setText("     5 best-selling products by store");
        lbl_report_option9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option8.setText("     10 products with more incomes");
        lbl_report_option8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option2.setText("     10 generators with most profits");
        lbl_report_option2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_report_option10.setText("     5 products with more profits ");
        lbl_report_option10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 13), new java.awt.Color(255, 153, 153))); // NOI18N

        lbl_admin_topReports.setText("TOP reports");

        javax.swing.GroupLayout panel_admin_reportSpecificationLayout = new javax.swing.GroupLayout(panel_admin_reportSpecification);
        panel_admin_reportSpecification.setLayout(panel_admin_reportSpecificationLayout);
        panel_admin_reportSpecificationLayout.setHorizontalGroup(
            panel_admin_reportSpecificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_report_option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option7, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(lbl_report_option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_report_option10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_admin_reportSpecificationLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbl_admin_topReports)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_admin_reportSpecificationLayout.setVerticalGroup(
            panel_admin_reportSpecificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_reportSpecificationLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbl_admin_topReports)
                .addGap(18, 18, 18)
                .addComponent(lbl_report_option1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_report_option10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_admin_viewReport.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Esto si no es obligatorio, pero podría hacer que se abrieran varias ventanas, para no cargar SOLO un reporte a la vez.");

        javax.swing.GroupLayout panel_admin_viewReportLayout = new javax.swing.GroupLayout(panel_admin_viewReport);
        panel_admin_viewReport.setLayout(panel_admin_viewReportLayout);
        panel_admin_viewReportLayout.setHorizontalGroup(
            panel_admin_viewReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_viewReportLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        panel_admin_viewReportLayout.setVerticalGroup(
            panel_admin_viewReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_admin_viewReportLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(795, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab_admin_reportsLayout = new javax.swing.GroupLayout(tab_admin_reports);
        tab_admin_reports.setLayout(tab_admin_reportsLayout);
        tab_admin_reportsLayout.setHorizontalGroup(
            tab_admin_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_admin_reportsLayout.createSequentialGroup()
                .addComponent(panel_admin_reportSpecification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_admin_viewReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab_admin_reportsLayout.setVerticalGroup(
            tab_admin_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_admin_reportSpecification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_admin_viewReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPane_admin_actions.addTab("Reports", tab_admin_reports);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane_admin_actions)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane_admin_actions)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButton_admin_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButton_admin_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButton_admin_lastNameActionPerformed

    
    //nos vamos a encrgar que si, selecciona all, entonces que se deseleccionen
    //los demás, y si select todos que se select ALL
        //esto último si todavía quieres xd
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_inventoryT1_search;
    private javax.swing.JComboBox<String> cbBox_filter;
    private javax.swing.JComboBox<String> cbBox_store;
    private javax.swing.ButtonGroup group_distincion;
    private javax.swing.ButtonGroup group_filters;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_admin_ID;
    private javax.swing.JLabel lbl_admin_name;
    private javax.swing.JLabel lbl_admin_store;
    private javax.swing.JLabel lbl_admin_topReports;
    private javax.swing.JLabel lbl_report_option1;
    private javax.swing.JLabel lbl_report_option10;
    private javax.swing.JLabel lbl_report_option2;
    private javax.swing.JLabel lbl_report_option3;
    private javax.swing.JLabel lbl_report_option4;
    private javax.swing.JLabel lbl_report_option5;
    private javax.swing.JLabel lbl_report_option6;
    private javax.swing.JLabel lbl_report_option7;
    private javax.swing.JLabel lbl_report_option8;
    private javax.swing.JLabel lbl_report_option9;
    private javax.swing.JPanel panel_admin_employeeData;
    private javax.swing.JPanel panel_admin_employee_detail;
    private javax.swing.JPanel panel_admin_employee_filter;
    private javax.swing.JPanel panel_admin_employee_position;
    private javax.swing.JPanel panel_admin_reportSpecification;
    private javax.swing.JPanel panel_admin_viewReport;
    private javax.swing.JRadioButton radioButton_ID;
    private javax.swing.JRadioButton radioButton_admin_all;
    private javax.swing.JRadioButton radioButton_admin_dateSignIn;
    private javax.swing.JRadioButton radioButton_admin_inventory;
    private javax.swing.JRadioButton radioButton_admin_lastName;
    private javax.swing.JRadioButton radioButton_admin_name;
    private javax.swing.JRadioButton radioButton_admin_sales;
    private javax.swing.JRadioButton radioButton_admin_store;
    private javax.swing.JRadioButton radioButton_filter_ID;
    private javax.swing.JRadioButton radioButton_name;
    private javax.swing.JTabbedPane tabPane_admin_actions;
    private javax.swing.JPanel tab_admin_employee;
    private javax.swing.JPanel tab_admin_reports;
    private javax.swing.JTable table_admin_employees;
    private javax.swing.JTextField txtF_admin_ID;
    private javax.swing.JTextField txtF_admin_name;
    // End of variables declaration//GEN-END:variables
}
