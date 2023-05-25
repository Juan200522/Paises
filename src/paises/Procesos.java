package paises;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {

	public void iniciar() {
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Registrar pais\n";
		menu+="2. Registrar ciudades\n";
		menu+="3. consultar ciudades por pais\n";
		menu+="4. consultar ciudad\n";
		menu+="5. Salir\n";
		menu+="Ingrese una opcion:\n";

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			Menu(opc);
			
		} while (opc!=10);
	}
	HashMap<String, ArrayList> cAndC = new HashMap<String, ArrayList>();
	
	public void Menu(int opc) {
		
		switch (opc) {
		case 1:
			 addCountry();
			 break;
		case 2:
			addCity();
		 	break;
		case 3:
			getCitiesForcountries();
		 	break;
		case 4:
			getCities();
			break;
		case 5:
			System.out.println("Chao!");
			break;
		
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
	
	}
	public void addCountry() {
		String country = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		ArrayList<String> cities = new ArrayList<String>();
		cAndC.put(country, cities);
		System.out.println(cAndC);
	}
	
	public void addCity() {
		int valid;
		String country = JOptionPane.showInputDialog("Ingrese el pais donde desea registrar la ciudad");
		if(cAndC.containsKey(country)) {
			String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			cAndC.get(country).add(city);
			
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				addCountry();
			}else {
				addCity();
			}
		}
		System.out.println(cAndC);
		
	}
	
	public void getCitiesForcountries(){
		int valid;
		String country = JOptionPane.showInputDialog("Ingrese el pais donde desea consultar las ciudades");
		if(cAndC.containsKey(country)) {
			System.out.println("Ciudades de "+ country + ":");
			 for (int i = 0; i < cAndC.get(country).size(); i++) {
				System.out.println(cAndC.get(country).get(i));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El pais no se encuentra registrado");
			valid = JOptionPane.showConfirmDialog(null, "¿Desea registrar el pais?");
			if(valid == 0) {
				addCountry();
			}else {
				addCity();
			}
		}
	}
	
	public void getCities() {
	    String city = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea consultar");
	    boolean found = false;
	    for (String country : cAndC.keySet()) {
	        if (cAndC.get(country).contains(city)) {
	            System.out.println(city + " pertenece a " + country);
	            found = true;
	        }
	    }
	    if (!found) {
	        System.out.println(city + " no se encuentra registrada en ningún país");
	    }
	}
}
