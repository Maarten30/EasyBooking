package server.Gateway;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import externalServices.Flight_parameters;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Pasajero;
import server.LD.Usuario;
import server.LD.Usuario_Pago;
import server.LD.Vuelo;

public interface itfGateway 
{	
	//Esto equivale a aplicar filtros
	public ArrayList <Vuelo> search_all_flights ();
	public List <Vuelo> search_flights_with_filter (Flight_parameters parametros);
	
	// Servicio externo - Pago
	public String make_Payment (Usuario_Pago usuario_pago);
	public boolean create_User_Pago (Usuario_Pago us);
	public boolean update_currency (Usuario_Pago usuario_pago);
	
	// Servicio externo - Autenticacion
	public boolean log_in (String email, String password);
	public String create_User_Auth (String nombre, String apellido, String email);
	public boolean change_password (String email, String old_password, String new_password);
	public boolean delete_user_Auth (String email, String password);
	
}
