package ejercicio1;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import javafx.scene.transform.Scale;

public class Ejercicio1 {
	
	static Scanner sc = new Scanner(System.in);
	static Hashtable<String,ArrayList> expediente = new Hashtable<String, ArrayList>();
	
	public static void main(String[] args) {
		String menu;
		
		do {
			System.out.println("Escribe el valor que corresponda: ");
			System.out.println("1. Crear alumno");
			System.out.println("2. Anadir nota a alumno");
			System.out.println("3. Listar alumno + media");
			System.out.println("4. Salir del programa");
			
			menu = sc.nextLine();
			switch (menu) {
				case "1":
					anadirPersona();
					break;
				case "2":
					anadirNota();
					break;
				case "3":
					listarNotasYNotaMedia();
					break;
				case "4":
					System.out.println("Saliendo del programa...");;
					break;
				default:
					System.out.println("Numero no valido \n");
					break;
			}
		
		} while (!menu.equals("4"));
		
	}
	
	public static void anadirNota() {
		String name = getNombre();
		ArrayList<Double> notas = getNotas(name);
		double nota;
			
		do {
			System.out.print("Escribe una nota entre 0 y 10: ");
			nota = Double.parseDouble(sc.nextLine());
		} while (nota < 0 || nota > 10);
		notas.add(nota);
		expediente.put(name, notas);
		
		System.out.println("Nota añadida :) \n");
	}
	
	
	public static void listarNotasYNotaMedia() {
		String name = getNombre();
		ArrayList<Double> notas = getNotas(name);
		double total = 0;
		
		System.out.print("Las notas de " + name + ": ");
		for (double nota: notas) {
			total += nota;
			System.out.print(nota + ", ");
		}
		System.out.println();
		System.out.println("La media de las notas es: " + (total / notas.size()) + "\n");
	}
	
	
	public static void anadirPersona() {
		System.out.print("Escribe el nombre del alumno:");
		String name = sc.nextLine();
		ArrayList<Double> notas = new ArrayList<>();
		
		expediente.put(name, notas);
		System.out.println("Persona creada. \n");
	}
	
	
	private static String getNombre() {
		String name; 
		
		do {
			System.out.print("Escribe el nombre de un alumno:");
			name = sc.nextLine();
		} while (!expediente.containsKey(name));
		return name;
	}
	
	
	private static ArrayList getNotas(String name) {
		return expediente.get(name);
	}
}
