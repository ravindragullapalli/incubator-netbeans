/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.java.j2semodule.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.spi.project.ui.support.ProjectChooser;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;

/**
 *
 * @author  Petr Hrebejk
 */

public class PanelProjectLocationVisual extends SettingsPanel implements DocumentListener {
    
    public static final String PROP_PROJECT_NAME = "projectName";      //NOI18N
    public static final String PROP_PROJECT_LOCATION = "projectLocation";      //NOI18N
    
    private PanelConfigureProject panel;
        
    public PanelProjectLocationVisual(PanelConfigureProject panel) {
        initComponents();
        this.panel = panel;
        // Register listener on the textFields to make the automatic updates
        projectNameTextField.getDocument().addDocumentListener( this );
        projectLocationTextField.getDocument().addDocumentListener( this );        
    }
    
    
    public String getProjectName () {
        return this.projectNameTextField.getText ();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        projectLocationLabel = new javax.swing.JLabel();
        projectLocationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        createdFolderLabel = new javax.swing.JLabel();
        createdFolderTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        projectNameLabel.setLabelFor(projectNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(projectNameLabel, org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "LBL_NWP1_ProjectName_Label")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(projectNameLabel, gridBagConstraints);
        projectNameLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSN_projectNameLabel")); // NOI18N
        projectNameLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSD_projectNameLabel")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 0);
        add(projectNameTextField, gridBagConstraints);

        projectLocationLabel.setLabelFor(projectLocationTextField);
        org.openide.awt.Mnemonics.setLocalizedText(projectLocationLabel, org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "LBL_NWP1_ProjectLocation_Label")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(projectLocationLabel, gridBagConstraints);
        projectLocationLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSN_projectLocationLabel")); // NOI18N
        projectLocationLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSD_projectLocationLabel")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 5, 0);
        add(projectLocationTextField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "LBL_NWP1_BrowseLocation_Button")); // NOI18N
        browseButton.setActionCommand("BROWSE");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseLocationAction(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 5, 0);
        add(browseButton, gridBagConstraints);
        browseButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSN_browseButton")); // NOI18N
        browseButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSD_browseButton")); // NOI18N

        createdFolderLabel.setLabelFor(createdFolderTextField);
        org.openide.awt.Mnemonics.setLocalizedText(createdFolderLabel, org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "LBL_NWP1_CreatedProjectFolder_Lablel")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(createdFolderLabel, gridBagConstraints);
        createdFolderLabel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSN_createdFolderLabel")); // NOI18N
        createdFolderLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(PanelProjectLocationVisual.class).getString("ACSD_createdFolderLabel")); // NOI18N

        createdFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(createdFolderTextField, gridBagConstraints);

        getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "ACSN_PanelProjectLocationVisual")); // NOI18N
        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(PanelProjectLocationVisual.class, "ACSD_PanelProjectLocationVisual")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void browseLocationAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseLocationAction
        String command = evt.getActionCommand();        
        if ( "BROWSE".equals( command ) ) { // NOI18N                
            JFileChooser chooser = new JFileChooser ();
            FileUtil.preventFileChooserSymlinkTraversal(chooser, null);
            chooser.setDialogTitle(NbBundle.getMessage(PanelProjectLocationVisual.class,"LBL_NWP1_SelectProjectLocation"));
            chooser.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
            String path = this.projectLocationTextField.getText();
            if (path.length() > 0) {
                File f = new File (path);
                if (f.exists ()) {
                    chooser.setSelectedFile(f);
                }
            }
            if ( JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) { //NOI18N
                File projectDir = chooser.getSelectedFile();
                projectLocationTextField.setText( FileUtil.normalizeFile(projectDir).getAbsolutePath() );
            }            
            panel.fireChangeEvent();
        }
    }//GEN-LAST:event_browseLocationAction
    
    
    public void addNotify() {
        super.addNotify();
        //same problem as in 31086, initial focus on Cancel button
        projectNameTextField.requestFocus();
    }
    
    boolean valid( WizardDescriptor wizardDescriptor ) {
        
        if (isIllegalName(projectNameTextField.getText())) {      //NOI18N
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE,
            NbBundle.getMessage(PanelProjectLocationVisual.class,"MSG_IllegalProjectName"));
            return false; // Display name not specified
        }
        File f = new File (projectLocationTextField.getText()).getAbsoluteFile();
        if (getCanonicalFile (f)==null) {
            String message = NbBundle.getMessage (PanelProjectLocationVisual.class,"MSG_IllegalProjectLocation");
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
            return false;
        }
        // not allow to create project on unix root folder, see #82339
        File cfl = getCanonicalFile(new File(createdFolderTextField.getText()));
        if (Utilities.isUnix() && cfl != null && cfl.getParentFile().getParent() == null) {
            String message = NbBundle.getMessage (PanelProjectLocationVisual.class,"MSG_ProjectInRootNotSupported");
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
            return false;
        }
        
        final File destFolder = new File( createdFolderTextField.getText() ).getAbsoluteFile();
        if (getCanonicalFile (destFolder) == null) {
            String message = NbBundle.getMessage (PanelProjectLocationVisual.class,"MSG_IllegalProjectLocation");
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
            return false;
        }

        File projLoc = FileUtil.normalizeFile(destFolder);
        while (projLoc != null && !projLoc.exists()) {
            projLoc = projLoc.getParentFile();
        }
        if (projLoc == null || !projLoc.canWrite()) {
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE,
            NbBundle.getMessage(PanelProjectLocationVisual.class,"MSG_ProjectFolderReadOnly"));
            return false;
        }

        if (FileUtil.toFileObject(projLoc) == null) {
            String message = NbBundle.getMessage (PanelProjectLocationVisual.class,"MSG_IllegalProjectLocation");
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, message);
            return false;
        }
        
        File[] kids = destFolder.listFiles();
        if ( destFolder.exists() && kids != null && kids.length > 0) {
            // Folder exists and is not empty
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE,
            NbBundle.getMessage(PanelProjectLocationVisual.class,"MSG_ProjectFolderExists"));
            return false;
        }

        Project prj = null;
        boolean foundButBroken = false;
        try {
            prj = ProjectManager.getDefault().findProject(FileUtil.toFileObject(FileUtil.normalizeFile(destFolder)));
        } catch (IOException ex) {
            foundButBroken = true;
        } catch (IllegalArgumentException ex) {
            // we have passed non-folder - should be already handled
        }
        if (prj != null || foundButBroken) {
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE,
                NbBundle.getMessage(PanelProjectLocationVisual.class, "MSG_ProjectMightAlreadyExists"));
            return false;
        }

        return true;
    }
    
    void store( WizardDescriptor d ) {        
        
        String name = projectNameTextField.getText().trim();
        String folder = createdFolderTextField.getText().trim();
        
        d.putProperty( /*XXX Define somewhere */ "projdir", new File( folder )); // NOI18N
        d.putProperty( /*XXX Define somewhere */ "name", name ); // NOI18N
    }
    
    void read (WizardDescriptor settings) {
        File projectLocation = (File) settings.getProperty ("projdir");  //NOI18N
        if (projectLocation == null || projectLocation.getParentFile() == null ||
            (projectLocation.getParentFile().exists() && !projectLocation.getParentFile().isDirectory ())) {
            projectLocation = ProjectChooser.getProjectsFolder();
        }
        else {
            projectLocation = projectLocation.getParentFile();
        }
        this.projectLocationTextField.setText (projectLocation.getAbsolutePath());
        
        String projectName = (String) settings.getProperty ("name"); //NOI18N
        if (projectName == null) {
            int baseCount = WizardSettings.getNewProjectCount() + 1;
            String formatter = NbBundle.getMessage(PanelProjectLocationVisual.class, "TXT_JavaModuleApplication");
            while ((projectName=validFreeProjectName(projectLocation, formatter, baseCount))==null)
                baseCount++;                
            settings.putProperty (NewJ2SEModularProjectWizardIterator.PROP_NAME_INDEX, new Integer(baseCount));
        }
        this.projectNameTextField.setText (projectName);                
        this.projectNameTextField.selectAll();
    }
        
    void validate (WizardDescriptor d) throws WizardValidationException {
        // nothing to validate
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel createdFolderLabel;
    private javax.swing.JTextField createdFolderTextField;
    private javax.swing.JLabel projectLocationLabel;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    // End of variables declaration//GEN-END:variables
    
    
    // Private methods ---------------------------------------------------------
    
    private static JFileChooser createChooser() {
        JFileChooser chooser = new JFileChooser();
        FileUtil.preventFileChooserSymlinkTraversal(chooser, null);
        chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        chooser.setAcceptAllFileFilterUsed( false );
        chooser.setName( "Select Project Directory" ); // XXX // NOI18N
        return chooser;
    }
    
    private String validFreeProjectName (final File parentFolder, final String formater, final int index) {
        String name = MessageFormat.format (formater, new Object[]{new Integer (index)});                
        File file = new File (parentFolder, name);
        return file.exists() ? null : name;
    }

    // Implementation of DocumentListener --------------------------------------
    
    public void changedUpdate( DocumentEvent e ) {
        updateTexts( e );
        if (this.projectNameTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_NAME,null,this.projectNameTextField.getText());
        }
        if (this.projectLocationTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
        }
    }
    
    public void insertUpdate( DocumentEvent e ) {
        updateTexts( e );
        if (this.projectNameTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_NAME,null,this.projectNameTextField.getText());
        }
        if (this.projectLocationTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
        }
    }
    
    public void removeUpdate( DocumentEvent e ) {
        updateTexts( e );
        if (this.projectNameTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_NAME,null,this.projectNameTextField.getText());
        }
        if (this.projectLocationTextField.getDocument() == e.getDocument()) {
            firePropertyChange (PROP_PROJECT_LOCATION,null,this.projectLocationTextField.getText());
        }
    }
    
    
    /** Handles changes in the Project name and project directory
     */
    private void updateTexts( DocumentEvent e ) {
        Document doc = e.getDocument();
        if ( doc == projectNameTextField.getDocument() || doc == projectLocationTextField.getDocument() ) {
            // Change in the project name
            String projectName = projectNameTextField.getText();
            String projectFolder = projectLocationTextField.getText();
            String projFolderPath = FileUtil.normalizeFile(new File(projectFolder)).getAbsolutePath();
            if (projFolderPath.endsWith(File.separator)) {
                createdFolderTextField.setText(projFolderPath + projectName);
            } else {
                createdFolderTextField.setText(projFolderPath + File.separator + projectName);
            }
        }                
        panel.fireChangeEvent(); // Notify that the panel changed        
    }

    static File getCanonicalFile(File file) {
        try {
            return file.getCanonicalFile();
        } catch (IOException e) {
            return null;
        }
    }
    
    static boolean isIllegalName(final String name) {
        return name.length() == 0      || 
            name.indexOf('/')  >= 0 ||        //NOI18N
            name.indexOf('\\') >= 0 ||        //NOI18N
            name.indexOf(':')  >= 0 ||        //NOI18N
            name.indexOf("\"") >= 0 ||        //NOI18N
            name.indexOf('<')  >= 0 ||        //NOI18N
            name.indexOf('>')  >= 0;          //NOI18N
    }

}