package org.cursoutn;

import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.view.ClientesView;

import java.util.ArrayList;
import java.util.List;

//import static org.cursoutn.Main.getEntityManager;
public class MainController {

    public static void mostrarTodos() throws Exception {
        ClienteModel cliente = new ClienteModel("cliente", (long) 1111110.013,  new NotificacionModel(), new ArrayList<ServicioModel>(), new ArrayList<IncidenteModel>());
        ClientesView clientesView = new ClientesView();
        JpaClienteRepository repository = new JpaClienteRepository();
        ClientesController clienteController = new ClientesController(cliente, clientesView);
        clienteController.repository = repository;
        List<ClienteModel> listado = clienteController.repository.obtenerTodosLosClientes();
        System.out.println(listado);
        //clienteController.actualizarView();

    }
    }
