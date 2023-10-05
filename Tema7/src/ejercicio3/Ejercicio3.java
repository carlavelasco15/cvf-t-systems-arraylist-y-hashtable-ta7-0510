package ejercicio3;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio3 {

	static Hashtable<String, Double[]> productos = new Hashtable<>(); 
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		populateDatabase();
		String message = "Elige una opción: \n1. Añadir producto \n2. Añadir cantidad\n3. Ver un articulo \n4. Listar todos los productos\n5. Salir del programa\n";
		String option;
		
		do {
			option = JOptionPane.showInputDialog(message);	

			switch (option) {
				case "1":
					//añadir producto
					anadirArticulo();
					break;
				case "2":
					//anadir cantidad
					anadirCantidad();
					break;
				case "3":
					//ver un articulo
					printInfoProduct();
					break;
				case "4":
					//listar toda la info
					printInfoProducts();
					break;
				case "5":
					System.out.println("Saliendo del programa...");;
					break;
				default:
					System.out.println("Numero no valido \n");
					break;
			}
		} while (!option.equals("5"));

	}
	
	
	public static String getName() {
		String name;
		do {
			name = JOptionPane.showInputDialog("Introudce el nombre del producto: ");
		} while (!isInHashtable(name));
		return name;
	}
	
	
	public static boolean isInHashtable(String name) {
		return productos.containsKey(name);
	}
	
	
	public static Double[] getData(String name) {
		return productos.get(name);
	}
	
	
	public static void anadirArticulo() {
		//ask for name
		String name = "";
		
		do {
			if (isInHashtable(name))
				JOptionPane.showMessageDialog(null, "Ese nombre y aexiste en la ddbb");
			name = JOptionPane.showInputDialog("Pon el nombre del producto que quieras anadir");
		} while (isInHashtable(name));
		
		
		// ask for price
		Double[] dataProduct = {0.0, 0.0};
		double input;	
		do {
			input = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad (precio): "));			
		} while (input <= 0);
		
		dataProduct[0] = input;
		
		
		// ask for stock
		do {
			input = Math.floor(Double.parseDouble(JOptionPane.showInputDialog("introduce la cantidad (stock):")));			
		} while (input <= 0);
		
		dataProduct[1] = input;
		productos.put(name, dataProduct);
		JOptionPane.showMessageDialog(null, "Producto añadido :D");
	}
	
	
	public static void anadirCantidad() {
		String name = getName();
		Double[] dataProduct = getData(name);
		double input;
		String message = "Stock actual " + dataProduct[1] + ".Introduce la nueva cantidad (total): ";
		do {
			input = Math.floor(Double.parseDouble(JOptionPane.showInputDialog(message)));			
		} while (input <= 0);
		
		dataProduct[1] = input;
		productos.put(name, dataProduct);
		JOptionPane.showMessageDialog(null, "Se ha cambiado la cantidad correctamente :D");
	}
	
	
	public static void printInfoProduct() {	
		String name = getName();
		Double[] dataProduct = getData(name);
		
		String nameOutput = "Nombre producto:  " + name + ".\n";
		String priceOutput = "Price producto:  " + dataProduct[0] + ".\n";
		String stockOutput = "Stock producto:  " + dataProduct[1] + ".\n";
		JOptionPane.showMessageDialog(null, nameOutput + priceOutput + stockOutput);
	}

	
	public static void printInfoProducts() {
		String nameOutput;
		String priceOutput;
		String stockOutput;
        for (Map.Entry<String, Double[]> entry : productos.entrySet()) {
            String nombreProducto = entry.getKey();
            Double[] datosProducto = entry.getValue();
            
            nameOutput = "Nombre del Producto: " + nombreProducto + "\n";
            priceOutput = "Precio: " + datosProducto[0] + "\n";
            stockOutput = "Stock: " + datosProducto[1] + "\n";
            JOptionPane.showMessageDialog(null, nameOutput + priceOutput + stockOutput);
        }
    }
		
	
	public static void populateDatabase() {
		String [] products = {"Ordenador", "Microfono", "Auriculares", "Altavoces", "Taza", "Banana", "Pelota", "Tamagochi", "Reloj", "Gafas"};
		double [] prices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		double [] stocks = {10, 9, 8, 7, 6, 5, 4 , 3 , 2 , 1};
		
		for (int i = 0; i < 10; i++) 
			productos.put(products[i], new Double[]{prices[i], stocks[i]});
	}

}
