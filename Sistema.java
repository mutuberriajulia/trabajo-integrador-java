import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Sistema {
    public static void main(String[] args) {
        String origen = "provincias.csv";
        ArrayList<Provincia> provincias = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(origen))) {
            String linea;
            bufferedReader.readLine();
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(",");

                Provincia provincia = new Provincia(datos[0], datos[1], datos[2]);
                provincias.add(provincia);
            }

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
            String nombre;
            boolean encontrado;
            switch (numero) {
                case 1:
                    System.out.println("Ingrese el nombre de la provincia: ");
                    String clima = "";
                    nombre = scanner.nextLine().toUpperCase();
                    encontrado = false;
                    for (Provincia p : provincias) {
                        if (p.getNombre().toUpperCase().equals(nombre)) {
                            clima = p.getClima();
                            System.out.println("El clima actual es " + clima);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El dato ingresado no se encontro");
                    } else {
                        System.out.println("Desea almacenar el clima en un archivo csv? (S/N)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                                    "resultados/climaSolicitado.csv"))) {
                                writer.write(clima);
                            } catch (Exception e) {
                                System.out.println("Error al leer el archivo: " + e.getMessage());
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la provincia: ");
                    String capital = "";
                    nombre = scanner.nextLine().toUpperCase();
                    encontrado = false;
                    for (Provincia p : provincias) {
                        if (p.getNombre().toUpperCase().equals(nombre)) {
                            capital = p.getCapital();
                            System.out.println("La capital es " + capital);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El dato ingresado no se encontro");
                    } else {
                        System.out.println("Desea almacenar la capital en un archivo csv? (S/N)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                                    "resultados/capitalSolicitada.csv"))) {
                                writer.write(capital);
                            } catch (Exception e) {
                                System.out.println("Error al leer el archivo: " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Provincias:");
                    if (provincias.isEmpty()) {
                        System.out.println("No hay provincias registradas.");
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