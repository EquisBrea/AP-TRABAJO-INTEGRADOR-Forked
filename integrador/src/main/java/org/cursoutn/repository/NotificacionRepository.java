package org.cursoutn.repository;

import org.cursoutn.model.NotificacionModel;

import java.util.List;

public interface NotificacionRepository {

    public List<NotificacionModel> obtenerTodasLasNotificaciones();

    public void guardarNotificacion(NotificacionModel notificacion);

    public NotificacionModel obtenerNotificacionPorId(int id);

    public void actualizarNotificacion(NotificacionModel notificacion);

    public void eliminarNotificacion(NotificacionModel notificacion);
}
