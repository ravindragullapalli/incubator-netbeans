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

package org.netbeans.license;

import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit;
import org.openide.util.NbBundle;

/**
 * This class displays license during first start of IDE.
 *
 * @author  Marek Slama
 */
final class LicensePanel extends javax.swing.JPanel {

    /** Creates new form LicensePanel */
    public LicensePanel(URL url) {
        this.url = url;
        initComponents();
        initAccessibility();
        try {
            jEditorPane1.setPage(url);
        } catch (IOException exc) {
            //Problem with locating file
            System.err.println("Exception: " + exc.getMessage()); //NOI18N
            exc.printStackTrace();
        }
        ActionMap actionMap = jEditorPane1.getActionMap();
        actionMap.put(DefaultEditorKit.upAction, new ScrollAction(-1));
        actionMap.put(DefaultEditorKit.downAction, new ScrollAction(1));
    }
    
    private void initAccessibility() {
        this.getAccessibleContext().setAccessibleName
        (bundle.getString("ACSN_LicensePanel"));
        this.getAccessibleContext().setAccessibleDescription
        (bundle.getString("ACSD_LicensePanel"));
        
        jEditorPane1.getAccessibleContext().setAccessibleName
        (bundle.getString("ACSN_EditorPane"));
        jEditorPane1.getAccessibleContext().setAccessibleDescription
        (bundle.getString("ACSD_EditorPane"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextAreaTop = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTextAreaBottom = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 0, 11));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jTextAreaTop.setBackground(getBackground());
        jTextAreaTop.setColumns(20);
        jTextAreaTop.setEditable(false);
        jTextAreaTop.setFont(new java.awt.Font("Dialog", 1, 12));
        jTextAreaTop.setLineWrap(true);
        jTextAreaTop.setRows(1);
        jTextAreaTop.setText(bundle.getString("MSG_LicenseDlgLabelTop"));
        jTextAreaTop.setWrapStyleWord(true);
        jTextAreaTop.setFocusable(false);
        jTextAreaTop.setMargin(new java.awt.Insets(0, 0, 2, 0));
        jTextAreaTop.setRequestFocusEnabled(false);
        add(jTextAreaTop);

        jEditorPane1.setEditable(false);
        jEditorPane1.setPreferredSize(new java.awt.Dimension(500, 500));
        jScrollPane1.setViewportView(jEditorPane1);

        add(jScrollPane1);

        jTextAreaBottom.setBackground(getBackground());
        jTextAreaBottom.setColumns(20);
        jTextAreaBottom.setEditable(false);
        jTextAreaBottom.setFont(new java.awt.Font("Dialog", 1, 12));
        jTextAreaBottom.setLineWrap(true);
        jTextAreaBottom.setRows(2);
        jTextAreaBottom.setText(bundle.getString("MSG_LicenseDlgLabelBottom"));
        jTextAreaBottom.setWrapStyleWord(true);
        jTextAreaBottom.setFocusable(false);
        jTextAreaBottom.setRequestFocusEnabled(false);
        add(jTextAreaBottom);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaBottom;
    private javax.swing.JTextArea jTextAreaTop;
    // End of variables declaration//GEN-END:variables
    private URL url;
    private static final ResourceBundle bundle = NbBundle.getBundle(LicensePanel.class);

    /**
     * An action to scroll the browser content up or down.
     */
    private class ScrollAction extends AbstractAction {
        int direction;

        public ScrollAction(int direction) {
            this.direction = direction;
        }

        public void actionPerformed(java.awt.event.ActionEvent e) {
            Rectangle r = jEditorPane1.getVisibleRect();
            int increment = jEditorPane1.getScrollableUnitIncrement(r, SwingConstants.VERTICAL, direction);
            r.y += (increment * direction);
            jEditorPane1.scrollRectToVisible(r);
        }
    }
}