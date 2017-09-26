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

/*
 * GrantPrivilegesDialog.java
 *
 * Created on 16.12.2008, 20:32:59
 */
package org.netbeans.modules.nativeexecution.ui;

import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.netbeans.modules.nativeexecution.spi.support.GrantPrivilegesProvider;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.NbBundle;

public class GrantPrivilegesDialog extends javax.swing.JPanel implements GrantPrivilegesProvider{

    private volatile boolean res;

    /** Creates new form GrantPrivilegesDialog */
    public GrantPrivilegesDialog() {
        initComponents();
    }

    public void clearPassword() {
        suPasswordField.setText(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        suLoginLabel = new javax.swing.JLabel();
        suPasswordLabel = new javax.swing.JLabel();
        suLoginField = new javax.swing.JTextField();
        suPasswordField = new javax.swing.JPasswordField();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(GrantPrivilegesDialog.class, "GrantPrivilegesDialog.jLabel1.text")); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        suLoginLabel.setText(org.openide.util.NbBundle.getMessage(GrantPrivilegesDialog.class, "GrantPrivilegesDialog.suLoginLabel.text")); // NOI18N

        suPasswordLabel.setText(org.openide.util.NbBundle.getMessage(GrantPrivilegesDialog.class, "GrantPrivilegesDialog.suPasswordLabel.text")); // NOI18N

        suLoginField.setText(org.openide.util.NbBundle.getMessage(GrantPrivilegesDialog.class, "GrantPrivilegesDialog.suLoginField.text")); // NOI18N

        suPasswordField.setText(org.openide.util.NbBundle.getMessage(GrantPrivilegesDialog.class, "GrantPrivilegesDialog.suPasswordField.text")); // NOI18N
        suPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hdlPasswordFieldFocus(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suLoginLabel)
                            .addComponent(suPasswordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(suLoginField, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suLoginLabel)
                    .addComponent(suLoginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suPasswordLabel)
                    .addComponent(suPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hdlPasswordFieldFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hdlPasswordFieldFocus
        suPasswordField.selectAll();
    }//GEN-LAST:event_hdlPasswordFieldFocus

    public boolean askPassword() {
        suPasswordField.setText(null);

        final DialogDescriptor dd = new DialogDescriptor(this,
                loc("GrantPrivilegesDialog.title"), true, // NOI18N
                new Object[]{
                    DialogDescriptor.OK_OPTION,
                    DialogDescriptor.CANCEL_OPTION
                }, DialogDescriptor.OK_OPTION,
                DialogDescriptor.DEFAULT_ALIGN, null, null);
        res = false;
        
        Dialog dialog = DialogDisplayer.getDefault().createDialog(dd);
        dialog.addWindowFocusListener(new WindowAdapter() {

            @Override
            public void windowGainedFocus(WindowEvent e) {
                suPasswordField.requestFocusInWindow();
            }
        });
        
        try {
            dialog.setVisible(true);
        } catch (Throwable th) {
            if (!(th.getCause() instanceof InterruptedException)) {
                throw new RuntimeException(th);
            }
            dd.setValue(DialogDescriptor.CANCEL_OPTION);
        } finally {
            dialog.dispose();
        }
        
        res = dd.getValue() == DialogDescriptor.OK_OPTION;
        
        return res;
    }

    public char[] getPassword() {
        return suPasswordField.getPassword();
    }

    public String getUser() {
        return String.valueOf(suLoginField.getText());
    }

    private static String loc(String key, Object... params) {
        return NbBundle.getMessage(GrantPrivilegesDialog.class, key, params);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField suLoginField;
    private javax.swing.JLabel suLoginLabel;
    private javax.swing.JPasswordField suPasswordField;
    private javax.swing.JLabel suPasswordLabel;
    // End of variables declaration//GEN-END:variables
}