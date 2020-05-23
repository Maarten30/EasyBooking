package client.Controller;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.LP.InicioSesion_Registro;
import client.ServiceLocator.ServiceLocator;
import server.Fachada.itfFachada;
import server.LD.Aeropuerto;
import server.LD.Pasajero;

public class Controller {

	
	private ServiceLocator rsl = null;
	private itfFachada fachada;
	
	
	
	public Controller(String [] args) throws RemoteException
	{
		rsl = new ServiceLocator();
		rsl.setService(args);
		fachada = rsl.getService();
		
		InicioSesion_Registro frame = new InicioSesion_Registro(this);
		frame.setVisible(true);
	}

	
	public String registroUsuario(String nombre, String apellido, String email) throws RemoteException
	{
		System.out.println("Entra en el Controller");
		String contrasenya = "";

		contrasenya = fachada.registroUsuario(nombre, apellido, email);
		
		return contrasenya;
	}
	
	public void iniciarSesion (String email, String contrasenya) throws RemoteException
	{
		System.out.println("Llega al controller de Iniciar Sesion");
		fachada.iniciarSesion(email, contrasenya);
	}
	
	public void buscarVuelo(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida, Date llegada) throws RemoteException
	{
		fachada.buscarVuelo(aero_origen, aero_dest, num_pasajeros, precio, salida, llegada);
	}
	
	public boolean eliminarUsuario(String email, String contrasenya) throws RemoteException
	{
		return fachada.eliminarUsuario(email, contrasenya);
	}
	
	public boolean cambiarContrasenya(String email, String contrasenya_antigua, String contrasenya_nueva) throws RemoteException
	{
		return fachada.cambiarContrasenya(email, contrasenya_antigua, contrasenya_nueva);
	}
	/**
	 * Este metodo deberia tener el conjunto de filtros y aplicarlos a la lista de vuelos que conseguimos con buscarVuelo. Realmente este metodo no tiene
	 * que utilizar servicios externos, porque aplicamos los filtros sobre la lista que ya hemos recogido. Asi que no tendra que pasar mas alla del servicelocator
	 * @param aero_origen
	 * @param aero_dest
	 * @param num_pasajeros
	 * @param precio
	 * @param salida
	 * @param llegada
	 * @throws RemoteException 
	 */
	public void aplicarFiltro(String aero_origen, String aero_dest, int num_pasajeros, double precio, Date salida) throws RemoteException 
	{
		fachada.aplicarFiltro(aero_origen, aero_dest, num_pasajeros, precio, salida);
	}
	
	public void createReserva(String aero_origen, String aero_destino, ArrayList<Pasajero> pasajeros, Date salida, Date llegada) throws RemoteException
	{
		fachada.createReserva(aero_origen, aero_destino, pasajeros, salida, llegada);
	}
	
	public void eliminarReserva(String cod_reserva, String cod_pago) throws RemoteException
	{
		fachada.eliminarReserva(cod_reserva, cod_pago);
	}
	
	public void realizarPago(double precio, String cod_reserva, String email) throws RemoteException
	{
		fachada.realizarPago(precio, cod_reserva, email);
	}
	
	public void cerrarSesion ()
	{

	}
}
