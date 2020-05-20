package server.Main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.Fachada.FachadaAero;
import server.Fachada.FachadaAuth;
import server.Fachada.FachadaPago;
import server.Fachada.itfFachadaAero;
import server.Fachada.itfFachadaAuth;
import server.Fachada.itfFachadaPago;

public class Main 
{
	private static Registry registry;
	private static itfFachadaAuth fachadaAuth;
	private static itfFachadaPago fachadaPago;
	private static itfFachadaAero fachadaAero;
	
	public static void main(String [] args) throws RemoteException 
	{
		String ip= "127.0.0.1";
		String port = "1099";
		String serviceName = "easybooking";
		
		fachadaAuth = new FachadaAuth();
		fachadaPago = new FachadaPago();
		fachadaAero = new FachadaAero();
	
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		try {
			registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" + port + "/" + serviceName;
			registry.rebind(name, fachadaPago);
			registry.rebind(name, fachadaAuth);
			registry.rebind(name, fachadaAero);

		} 
		catch (Exception e) {
			System.err.println("- Exception running the client: " + e.getMessage() );
			e.printStackTrace();
		} 
		
//		Aeropuerto aero1 = new Aeropuerto("321", "Loiu");
//		Aeropuerto aero2 = new Aeropuerto("654", "Biarritz");
//		
//		Aerolinea aerol1 = new Aerolinea("Iberia", "IB");
//		Aerolinea aerol2 = new Aerolinea("Koninklijke Luchtvaart Maatschappij", "KLM");
//				
//		Vuelo vuelo1 = new Vuelo(1234, aerol1, aero1, aero2, 100, 70, 1233131231, 1231231312);
//		
//		Usuario user1 = new Usuario("ibone2@hotmail.com", "ibone", "urquiola", "73425341L", aero2);
//		Usuario user2 = new Usuario("maite2@gmail.com", "maite", "llorente", "54637218K", aero2);
//		Usuario user3 = new Usuario("maarten2@gmail.com", "maarten", "handels", "76548392W", aero2);
//		
//		ArrayList<Pasajero> pasajeros = new ArrayList <Pasajero>();
//		
//		Pasajero pas1 = new Pasajero("Maarten", "Handels", "72345634K");
//		Pasajero pas2 = new Pasajero("Laura", "Llorente", "73035427Y");
//		Pasajero pas3 = new Pasajero("Gabriela", "Garaizabal", "73542711T");
//		
//		pasajeros.add(pas1);
//		pasajeros.add(pas2);
//		pasajeros.add(pas3);
//		
//		Reserva res1 = new Reserva(user1, "Res02", "Pag01", pasajeros, true, vuelo1);
//		Reserva res2 = new Reserva(user2, "Res03", "Pag02", pasajeros, false, vuelo1);
//		
////		user1.getReservasUsuario().add(res1);
//		
//		
//		
//		
//		Aeropuerto arrayAeropuertos[]= { aero1, aero2 };
//		Aerolinea arrayAerolineas[]= { aerol1, aerol2 };
//		Pasajero arrayPasajeros[]= { pas1, pas2, pas3 };
//		Usuario arrayUsuarios[]= { user1, user2, user3 };
//		Reserva arrayReservas[]= { res2 };
//		
//		
//		GestorBD gestor = new GestorBD();
//		
////		gestor.guardarElementos(arrayAeropuertos);
////		gestor.guardarElementos(arrayAerolineas);
////		gestor.guardarElementos(arrayPasajeros);
//		gestor.guardarElementos(arrayUsuarios);
//		gestor.guardarElementos(arrayReservas);
//		
//		
////		gestor.buscarModificarCodAeropuerto(aero1, "567");
//		
//		// gestor.eliminarAeropuerto(aero1);
//		// gestor.eliminarAeropuerto(aero2);
//		
//		// gestor.eliminarObjeto(pas1);
//	
//		
//		gestor.cerrarBD();
//		
//		
//		
//		
//		
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
//		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//
//		// Persistence Manager
//		PersistenceManager pm = null;
//
//		//Transaction to group DB operations
//		Transaction tx = null;		
//		
//		//INSERT
//		try 
//		{
//			System.out.println("- Guardar objetos en la BD");			
//			
//			//Get the Persistence Manager
//			pm = pmf.getPersistenceManager();
//
//			//Obtain the current transaction
//			tx = pm.currentTransaction();		
//
//			//Start the transaction
//			tx.begin();
//			
//			pm.makePersistent(aero1);
//			pm.makePersistent(aero2);
//			
//			pm.makePersistent(user1);
//			pm.makePersistent(user2);
//			pm.makePersistent(user3);
//			
//			pm.makePersistent(pas1);
//			pm.makePersistent(pas2);
//			pm.makePersistent(pas3);
//			
//			pm.makePersistent(res1);
//	
//			
//			//End the transaction
//			tx.commit();			
//			
//			System.out.println("Los objetos se han guardado satisfactoriamente");
//			System.out.println("");
//		}
//
//		catch (Exception ex) 
//		{
//			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
//			ex.printStackTrace();
//		}
//
//		finally 
//		{
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//			
//			if (pm != null && !pm.isClosed()) 
//			{
//				pm.close();
//				// ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
//			}
//		}
//		
//		//SELECT
//		try {
//			
//			System.out.println("- Seleccionar datos de BD");	
//			
//			pm = pmf.getPersistenceManager();
//			tx = pm.currentTransaction();
//			tx.begin();
//				
//	        Usuario usuario1 = pm.getObjectById(Usuario.class, "maarten2@gmail.com");
//			        		        
//	        System.out.println("El usuario buscado es " + usuario1.getEmail());
//	        System.out.println("");
//			        
//	        tx.commit();
//					        
//	    }catch (Exception ex)
//		{
//			System.err.println(" $ Error updating the DB: " + ex.getMessage());
//			ex.printStackTrace();
//		} finally {
//	    	
//	    	if (tx != null && tx.isActive()) 
//			{
//				tx.rollback();
//			}
//			
//			if (pm != null && !pm.isClosed()) 
//			{
//				pm.close();
//			}
//	    }
//		
//		//UPDATE
//		try {
//			
//			System.out.println("- Actuailzar datos de la BD");	
//			
//			pm = pmf.getPersistenceManager();
//			tx = pm.currentTransaction();
//			tx.begin();
//				
//	        Usuario usuario2 = pm.getObjectById(Usuario.class, "ibone2@hotmail.com");
//	        
//	        usuario2.setEmail("ibone2@gmail.com");
//	        
//	        System.out.println("Se ha cambiado el email de Ibone" + usuario2.getEmail());
//	        System.out.println("");
//	        
//	        tx.commit();
//		        
//	    }catch (Exception ex)
//		{
//			System.err.println(" $ Error updating the DB: " + ex.getMessage());
//			ex.printStackTrace();
//		} finally {
//	    	
//	    	if (tx != null && tx.isActive()) 
//			{
//				tx.rollback();
//			}
//			
//			if (pm != null && !pm.isClosed()) 
//			{
//				pm.close();
//			}
//	    }
//		
//		//DELETE
//		try
//		{
//			System.out.println("- Limpiar la BD");		
//			pm = pmf.getPersistenceManager();
//			tx = pm.currentTransaction();
//			tx.begin();
//			
//			//Delete users from DB
//			Query<Aerolinea> query1 = pm.newQuery(Aerolinea.class);
//			
//			// query1.deletePersistentAll();
//			
//			@SuppressWarnings("unchecked")
//			List<Aerolinea> aerolineas = (List<Aerolinea>) query1.execute();
//			
//			for (Aerolinea a: aerolineas)
//			{
//				System.out.println(a.getCodAerolinea());
//				aerolineas.remove(a);
//			}
//			
//			aerolineas.removeAll(aerolineas);
//			
////			
////			Usuario usuario = pm.getObjectById(Usuario.class,
////		            "ibone2@hotmail.com");
////			
////			System.out.println("El metodo de pago es " + usuario.getmetodoPago());
////			
////			pm.deletePersistent(usuario);
////			System.out.println(" Usuarios eliminados ");
////			
////			// Query<Aeropuerto> query2 = pm.newQuery(Aeropuerto.class);
////			// pm.deletePersistent(query2);
////			
////			System.out.println(" Aeropuertos eliminados ");
////			
////			Query<Pasajero> query3 = pm.newQuery(Pasajero.class);
////			System.out.println(" Pasajeros eliminados ");
////			
////			Query<Aerolinea> query4 = pm.newQuery(Aerolinea.class);
////			System.out.println(" Aerolineas eliminadas ");
////			
////			Query<Reserva> query5 = pm.newQuery(Reserva.class);
////			System.out.println(" Reservas eliminadas ");
////			
//			//End the transaction
//			tx.commit();
//		}
//
//		catch (Exception ex)
//		{
//			System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
//			ex.printStackTrace();
//		}
//
//		finally
//		{
//			if (tx != null && tx.isActive()) 
//			{
//				tx.rollback();
//			}
//			
//			if (pm != null && !pm.isClosed()) 
//			{
//				pm.close();
//			}
//		}	
	}
	
}
