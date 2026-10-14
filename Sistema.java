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
                case 2:
                case 3:
                case 4:
                default:
                    System.out.println("El valor ingresado es incorrecto, por favor ingresar nuevamente...");
                    break;
            }
        } while (numero != 4);
        scanner.close();
    }
}