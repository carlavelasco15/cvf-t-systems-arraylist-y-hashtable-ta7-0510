package ejercicio2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ejercicio2 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Double> compra = new ArrayList<Double>();

	public static void main(String[] args) {
		String input;
		Double price;
		Double pagado;
		
		do {	
			System.out.print("Precio del producto (0 para salir): ");
			input = sc.nextLine();
			price = Double.parseDouble(input);
			if (price > 0) {
				compra.add(price);
				System.out.println("Producto añadido!");
			}
		} while (!input.equals("0"));
		System.out.println("Saliendo del programa:");
		
		printPrecioTotalSinIva();
		printPrecioTotalConIva();
		listarSinIva();
		listarConIva();
		
		double totalAPagar = getTotalIva();
		do {
			System.out.print("Cantidad que quieres pagar: ");
			pagado = Double.parseDouble(sc.nextLine());
		} while (pagado < totalAPagar);
		double resto =  pagado - totalAPagar; 
		System.out.println("Cambio a devolver: " + resto);

	}
	
	public static double getTotal() {
		double precioTotalSinIva = 0;
		for (int i = 0; i < compra.size(); i++) {
			precioTotalSinIva += compra.get(i);
		}
		return precioTotalSinIva;
	}
	
	public static double getTotalIva() {
		double totalSinIva = getTotal();
		return (totalSinIva * 1.21);
	}
	
	public static void printPrecioTotalSinIva() {
		System.out.println("Precio sin iva: " + getTotal());
	}
	
	public static void printPrecioTotalConIva() {
		System.out.println("Precio con iva: " + getTotalIva());
	}
	
	public static void listarSinIva() {
		System.out.print("Lista de precios sin iva: ");
		for (int i = 0; i < compra.size(); i++) {
			System.out.print(compra.get(i) + ", ");
		}
		System.out.println();
	}
	
	public static void listarConIva() {
		System.out.print("Lista de precios con iva: ");
		for (int i = 0; i < compra.size(); i++) {
			System.out.print((compra.get(i) * 1.21) + ", ");
		}
		System.out.println();
	}

}
