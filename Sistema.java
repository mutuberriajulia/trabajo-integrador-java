import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

public class Sistema {
    public static void main(String[] args) {
        String origen = "provincias.csv";
        ArrayList<Provincia> provincias = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(origen); // Lector del csv
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;
            while (bufferedReader.readLine() != null) {
                linea = bufferedReader.readLine();
                String[] datos = linea.split(",");
                Provincia provincia = new Provincia(datos[0], datos[1], datos[2]);
                provincias.add(provincia);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.println("1. Buscar clima actual de una provincia");
            System.out.println("2. Buscar capital de una provincia");
            System.out.println("3. Mostrar informacion de todas las provincias");
            System.out.println("4. Salir del Menu");
            numero = scanner.nextInt();
            scanner.nextLine();

            switch (numero) {
                case 1:
                    System.out.println("Ingrese el nombre de la provincia: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    boolean encontrado = false;
                    for (Provincia p : provincias) {
                        if (p.getNombre().toUpperCase().equals(nombre)) {
                            System.out.println("El clima actual es " + p.getClima());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El dato ingresado no se encontro");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la provincia: ");
                    String nombre = scanner.nextLine().toUpperCase();
                    boolean encontrado = false;
                    for (Provincia p : provincias) {
                        if (p.getNombre().toUpperCase().equals(nombre)) {
                            System.out.println("La capital es " + p.getCapital());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El dato ingresado no se encontro");
                    }
                    break;
                case 3:
                    System.out.println("Provincias:");
                    if (provincias.isEmpty()) {
                        System.out.println("No hay provincias registradas.")
                    } else {
                        for (Provincia p : provincias) {
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Clima: " + p.getClima());
                        System.out.println("Capital: " + p.getCapital());
                        System.out.println("--------------------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("El valor ingresado es incorrecto, por favor ingresar nuevamente...");
                    break;
            }
        } while (numero != 4);
        scanner.close();
    }
}