package org.cursoutn.repository;

import org.cursoutn.model.NotificacionModel;

import java.util.List;

public interface NotificacionRepository {

    public List<NotificacionModel> obtenerTodasLasNotificaciones() throws Exception;

    public void guardarNotificacion(NotificacionModel notificacion) throws Exception;

    public NotificacionModel obtenerNotificacionPorId(int id) throws Exception;

    public void actualizarNotificacion(NotificacionModel notificacion) throws Exception;

    public void eliminarNotificacion(NotificacionModel notificacion) throws Exception;
}
