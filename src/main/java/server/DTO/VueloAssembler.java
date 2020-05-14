package server.DTO;

import java.util.ArrayList;
import java.util.List;

import server.LD.Usuario;
import server.LD.Vuelo;

public class VueloAssembler 
{
	
	public List <VueloDTO> assembleTovueloDTO(List<Vuelo> vuelos)
	{
		List<VueloDTO> vueloDTO = new ArrayList<>();
		for (Vuelo u : vuelos)
		{
			VueloDTO vuDTO= new VueloDTO(u.getAerolinea(), u.getAeropuertoSalida(), 
					u.getAeropuertoDestino(), u.getAsientosLibres(), u.getSalida(), u.getLlegada());
			
			vueloDTO.add(vuDTO);
		}
		System.out.println("* Assembling vuelos to vuelosDTO ...");
		
		return vueloDTO;
		
	}
	
	public List <Vuelo> assembletoVuelo(List<VueloDTO> vueloDTO)
	{
		List<Vuelo> vuelos = new ArrayList<>();
		for (VueloDTO u : vueloDTO)
		{
			Vuelo vu = new Vuelo();
			
			vu.setAerolinea(u.getAerolinea());
			vu.setAeropuertoSalida(u.getAeropuertoSalida());
			vu.setAeropuertoSalida(u.getAeropuertoSalida());
			vu.setAsientosLibres(u.getAsientosLibres());
			vu.setSalida(u.getSalida());
			vu.setLlegada(u.getLlegada());
			
			vuelos.add(vu);
			
		}
		System.out.println("* Assembling usuariosDTO to usuarios ...");
		
		return vuelos;
		
	}

}