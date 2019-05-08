package agenciaviajes.clientemain;

import agenciaviajes.negocio.GestorClientes;
import agenciaviajes.presentacion.GUIClientes;
import agenciaviajes.presentacion.GUIClientesController;
import agenciaviajes.presentacion.GUIClientesVer;
import agenciaviajes.presentacion.GuiEstadisticaGenero;

/**
 * Es el pegamento de la aplición
 *
 * @author Libardo, Julio, Ricardo
 */
public class RunMVC {

    public RunMVC() {
        GestorClientes gestor = new GestorClientes();

        //PRIMERA VISTA
        GUIClientes view1 = new GUIClientes();
        gestor.addView(view1);
        GUIClientesController control = new GUIClientesController(gestor, view1);
        view1.setVisible(true);

        // SEGUNDA VISTA
        GUIClientesVer view2 = new GUIClientesVer();
        gestor.addView(view2);
        view2.setVisible(true);
        
        // Tercera Vista
        GuiEstadisticaGenero view3 = new GuiEstadisticaGenero();
        gestor.addView(view3);
        gestor.notificar(); // Para que se cargue los clientes al cargar la ventana
        view3.setVisible(true);
        

        // Enlaza el action controller de los botones al controlador y fija el comando de acción
        view1.getBtnGrabar().addActionListener(control);
        view1.getBtnGrabar().setActionCommand("GRABAR");

        view1.getBtnEliminar().addActionListener(control);
        view1.getBtnEliminar().setActionCommand("ELIMINAR");

    }
}
