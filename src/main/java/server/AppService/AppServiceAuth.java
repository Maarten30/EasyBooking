package server.AppService;

import java.rmi.RemoteException;
import java.util.List;

import server.DAO.DAO;
import server.DTO.UsuarioAssembler;
import server.DTO.UsuarioDTO;
import server.Gateway.Gateway;
import server.LD.Aeropuerto;
import server.LD.Usuario;

public class AppServiceAuth {
	
	private Gateway gateway;
	private DAO dao;
	
//	public String registroUsuario(String nombre, String apellido, String email, String dni, Aeropuerto aero) throws RemoteException
	public String registroUsuario(String nombre, String apellido, String email) throws RemoteException
	{
		System.out.println("Entra en el AppService");
		
		String contrasenya = gateway.create_User_Auth(nombre, apellido, email);
		
		System.out.println("Pasa la llamada del gateway");
		
//		Usuario nuevo_usuario = new Usuario(email, nombre, apellido, dni, aero);
//		dao.guardarElemto(nuevo_usuario);
		
		return contrasenya;
		
	}
	
	public void iniciarSesion (String email, String contrasenya) throws RemoteException
	{
		System.out.println("Llega al appservice");
		gateway.log_in(email, contrasenya);
	}
	public void cerrarSesion (String email)throws RemoteException
	{
		
	}
	public List <Usuario> getUsuarios()
	{
		return null;
	}
	public boolean eliminarUsuario(String email, String password )
	{
		return gateway.delete_user(email, password);
		//FALTA ELIMINAR DE DAO
	}
	public boolean cambiarContrasenya(String email, String password_antigua, String password_nueva )
	{
		return gateway.change_password(email, password_antigua, password_nueva);
		//FALTA CAMBIAR EN DAO
	}
}
