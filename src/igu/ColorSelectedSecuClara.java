package igu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

class ColorSelectedSecuClara extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Cambiamos el color de fondo de los elementos en la lista desplegable
        list.setSelectionBackground(new Color(83, 83, 115));
        list.setSelectionForeground(new Color(255, 255, 255));
        return component;
    }
}