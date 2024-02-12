package main;

import negocio.GestorCoches;

public class MainBaja {

	public static void main(String[] args) {
		
		GestorCoches gc = new GestorCoches();
		
		boolean baja = gc.baja(3);
		if(baja) {
			System.out.println("El coche se ha dado de baja");
		}else {
			System.out.println("El coche No se ha dado de baja");
		}
		
	}

}
