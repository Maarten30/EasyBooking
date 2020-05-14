package server.LD;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String email;
	private String dni;
	private String nombre;
	private String apellido;
	private String contrasenya;
	
	@Column(name="CODAEROPUERTO")
	private Aeropuerto aeropuerto; // No se como llamarle a esto
	
	private boolean metodoAutorizacion; // Habria que mirar si no es mejor con algo distinto a String
	
	//No lo pondria porque solo hay un metodo de pago
	private boolean metodoPago; //true -> Paypal  false -> Tarjeta
	
	
	@Persistent(mappedBy="usuario")
	private List<Reserva> reservasUsuario; 
	
	public Usuario()
	{}
	
	public Usuario(String email, String contrasenya, String nombre, String apellido, String dni, Aeropuerto aeropuerto, boolean metodoAutorizacion, boolean metodoPago)
	{
		super();
		this.email = email;
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.aeropuerto = aeropuerto;
		this.metodoAutorizacion = metodoAutorizacion;
		this.metodoPago = metodoPago;
		this.reservasUsuario = new ArrayList <Reserva>();
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}


	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}


	public boolean getmetodoAutorizacion() {
		return metodoAutorizacion;
	}


	public void setMetodoAutorizacion(boolean metodoAutorizacion) {
		this.metodoAutorizacion = metodoAutorizacion;
	}


	public boolean getmetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(boolean metodoPago) {
		this.metodoPago = metodoPago;
	}


	public List<Reserva> getReservasUsuario() {
		return reservasUsuario;
	}


	public void setReservasUsuario(List<Reserva> reservasUsuario) {
		this.reservasUsuario = reservasUsuario;
	}
	
	
	
	
}