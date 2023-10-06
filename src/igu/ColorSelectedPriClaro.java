package igu;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

//clase para cambiar el color de lo selecionado en el combo principal modo claro
//funciona igual para el modo oscuro y scundarias
class ColorSelectedPriClaro extends DefaultListCellRenderer {// esta extencion hace que podamos usar herramientas para modificar el estilo 
	//dela seleccion del combo
	
    @Override
    //metodo para seleccionar el componente del combo "getListCellRendererComponent" esto es para obtener un elemento del combo
    //y dale un comportamiento
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Cambiamos el color de fondo de los elementos en la lista desplegable
        list.setSelectionBackground(new Color(51, 51, 70));
        //Cambia el color de la letra
        list.setSelectionForeground(new Color(255, 255, 255));

        return component;
    }
}