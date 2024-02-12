package main;

import entidad.Coche;
import negocio.GestorCoches;

public class MainAlta {

	public static void main(String[] args) {
		Coche coche = new Coche();
		coche.setMarca("Opel");
		coche.setModelo("Zafira");
		coche.setAnyoFabri("2000");
		coche.setKm(200000);
		
		GestorCoches gc = new GestorCoches();
		
		boolean alta = gc.alta(coche);
		if(alta) {
			System.out.println("El coche se ha dado de ALTA");
		}else {
			System.out.println("El coche No se ha dado de alta");
		}

	}

}
