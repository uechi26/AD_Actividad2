package main;

import entidad.Coche;
import negocio.GestorCoches;

public class MainModificar {

	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setId(1);
		coche.setMarca("Peugeot");
		coche.setModelo("308");
		coche.setAnyoFabri("2005");
		coche.setKm(100000);
		
		GestorCoches gc = new GestorCoches();
		
		boolean modificar = gc.modificar(coche);
		if(modificar) {
			System.out.println("El coche se ha modificado");
		}else {
			System.out.println("El coche No se ha modificado");
		}
		
		
	}

}
