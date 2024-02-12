package presentacion;

import java.awt.Menu;
import java.util.Scanner;

import entidad.Coche;
import negocio.GestorCoches;
import persistencia.CocheDaoMySql;

public class VistaCoche {
	
		Scanner sc = new Scanner(System.in);
		int opcion, id;
		Coche coche;
	
		GestorCoches gc = new GestorCoches();
		CocheDaoMySql cdms = new CocheDaoMySql();
		
		
		do {
			opcion = menu();
						
			switch (opcion) {
			case 1:
				gc.alta(coche);
				altaCoche();
				break;
			case 2:
				bajaCoche();
				break;
			case 3:
				modificarCoche();
				break;
			case 4:
				obtenerCoche();
				break;
			case 5:
				listarCoche();
				break;
			default:
				break;
			}
			
		}while (opcion!=6);
		

		
		public void altaCoche() {
			Coche coche = pedirDatosCoche();
			
		}
		
		
		private Coche pedirDatosCoche() {
			String matricula = pedirDato("matricula");
			String marca = pedirDato("marca");
			String modelo = pedirDato("modelo");
			String anyoFabri = pedirDato("anyo fabricacion");
			String sKm = pedirDato("kilometros");
			int dKm = Integer.parseInt(sKm);
			
			Coche coche = new Coche();
			coche.setMarca(marca);
			coche.setModelo(modelo);
			coche.setAnyoFabri(AnyoFabri);
			coche.setKm(dKm);
			
			return coche;
		}

		private String pedirDato(String string) {
			
			System.out.println("Introduzca: " + string);
			String cadena = sc.next();
			return cadena;
		}		
		
		
		private int menu(){
			System.out.println("¡¡¡¡¡Bienvenidos a nuestro programa!!!!!");
			System.out.println("----------------------------------------");			
			System.out.println("Que deseas hacer?, marca una opcion --->");
			System.out.println("----------------------------------------");			
			System.out.println("1. Añadir nuevo coche");
			System.out.println("2. Borrar coche por ID");
			System.out.println("3. Consulta coche por ID");
			System.out.println("4. Modificar coche por ID");
			System.out.println("5. Listado de coches");
			System.out.println("6. Terminar el programa");
			int option = sc.nextInt();
			return option;
		}
}
