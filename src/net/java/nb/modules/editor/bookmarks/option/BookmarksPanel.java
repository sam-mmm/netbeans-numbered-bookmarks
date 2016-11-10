/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.java.nb.modules.editor.bookmarks.option;

import org.openide.util.NbPreferences;
import java.util.prefs.Preferences;

public final class BookmarksPanel extends javax.swing.JPanel {

    private final BookmarksOptionsPanelController controller;

    BookmarksPanel(BookmarksOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
    // TODO listen to changes in form fields and call controller.changed()
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbDefaultBookmark = new javax.swing.JRadioButton();
        rbNumberedBookmark = new javax.swing.JRadioButton();
        rbBoth = new javax.swing.JRadioButton();

        setLayout(null);

        buttonGroup1.add(rbDefaultBookmark);
        org.openide.awt.Mnemonics.setLocalizedText(rbDefaultBookmark, org.openide.util.NbBundle.getMessage(BookmarksPanel.class, "BookmarksPanel.rbDefaultBookmark.text")); // NOI18N
        add(rbDefaultBookmark);
        rbDefaultBookmark.setBounds(10, 50, 350, 23);

        buttonGroup1.add(rbNumberedBookmark);
        org.openide.awt.Mnemonics.setLocalizedText(rbNumberedBookmark, org.openide.util.NbBundle.getMessage(BookmarksPanel.class, "BookmarksPanel.rbNumberedBookmark.text")); // NOI18N
        add(rbNumberedBookmark);
        rbNumberedBookmark.setBounds(10, 20, 350, 23);

        buttonGroup1.add(rbBoth);
        rbBoth.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rbBoth, org.openide.util.NbBundle.getMessage(BookmarksPanel.class, "BookmarksPanel.rbBoth.text")); // NOI18N
        add(rbBoth);
        rbBoth.setBounds(10, 80, 350, 23);
    }// </editor-fold>//GEN-END:initComponents

    void load() {
        // TODO read settings and initialize GUI
        // Example:        
        // someCheckBox.setSelected(Preferences.userNodeForPackage(BookmarksPanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:
        // someCheckBox.setSelected(NbPreferences.forModule(BookmarksPanel.class).getBoolean("someFlag", false));
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());
        Preferences pref = NbPreferences.forModule(BookmarksPanel.class);        
        String s = pref.get("bookmark_system", "");
        if(s!=null){
        if(s.equalsIgnoreCase("default")){
            rbDefaultBookmark.setSelected(true);
        }else if(s.equalsIgnoreCase("numbered")){
            rbNumberedBookmark.setSelected(true);
        }
        }

    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(BookmarksPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        // NbPreferences.forModule(BookmarksPanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());
        Preferences pref = NbPreferences.forModule(BookmarksPanel.class);
        String s = "";
        if (rbDefaultBookmark.isSelected()) {
            s = "default";
            CustomFileSystem.enableDefaultBookmarkOnly();
        }
        if(rbNumberedBookmark.isSelected()){
            s = "numbered";
            CustomFileSystem.enableNumberedBookmarkOnly();
        }
        if(rbBoth.isSelected()){
            s="both";
            CustomFileSystem.enableBoth();
        }
        pref.put("bookmark_system", s);
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton rbBoth;
    private javax.swing.JRadioButton rbDefaultBookmark;
    private javax.swing.JRadioButton rbNumberedBookmark;
    // End of variables declaration//GEN-END:variables
}
