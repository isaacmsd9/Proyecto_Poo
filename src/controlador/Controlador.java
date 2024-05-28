/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.listadoSemestres;

/**
 * La clase Controlador se encarga de manejar la interacción con el usuario a través de un menú de consola.
 * Esta clase permite realizar operaciones como registrar, modificar, eliminar y leer datos de alumnos, 
 * y gestionar información sobre los semestres de una carrera.
 *
 * @version 1.0
 * @author EquipoH
 */
public class Controlador {

    /**
     * Método principal que ejecuta el menú de la aplicación. 
     * Ofrece opciones para manejar información de alumnos y semestres.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        listadoSemestres listadoSemestres = new listadoSemestres();

        do {
            System.out.println("\n*** Menu de Opciones | By RedsScorpionSoftware ***");
            System.out.println("1. Eliminar datos de un alumno");
            System.out.println("2. Modificar datos de un alumno");
            System.out.println("3. Registrar un nuevo alumno");
            System.out.println("4. Leer alumnos");
            System.out.println("5. Calcular numero de inscripcion");
            System.out.println("6. Ver semestres de la carrera");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt

            switch (opcion) {
                case 1:
                    eliminarDatosAlumno();
                    break;
                case 2:
                    modificarDatosAlumno();
                    break;
                case 3:
                    registrarNuevoAlumno();
                    break;
                case 4:
                    leerAlumnos();
                    ;
                    break;
                case 5:
                    double numeroInscripcion = listadoSemestres.calcularNumeroInscripcion();
                    System.out.println("Numero de inscripción calculado: " + numeroInscripcion);
                    break;
                case 6:
                    System.out.print("Ingrese el numero de semestre que desea consultar (1-9): ");
                    int numeroSemestreConsulta = scanner.nextInt();
                    listadoSemestres.mostrarMateriasPorSemestre(numeroSemestreConsulta);
                    break;
                case 7:
                    System.out.println("Saliendo del programa. Hasta luego");
                    break;
                    
               
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 7);

        scanner.close();
    }
    
    /**
     * Modifica los datos de un alumno existente. 
     * Permite al usuario cambiar información como nombre, número de cuenta, edad, dirección, semestre y número de inscripción.
     */
   private static void modificarDatosAlumno() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el numero de cuenta del alumno que desea modificar: ");
    String numeroCuentaBuscar = scanner.nextLine().trim();

    // Crear una lista temporal para almacenar los datos modificados
    StringBuilder nuevaListaAlumnos = new StringBuilder();

    try (BufferedReader br = new BufferedReader(new FileReader("pooProyectoFinal.csv"))) {
        String linea;
        boolean alumnoEncontrado = false;

        while ((linea = br.readLine()) != null) {
            if (linea.contains("Num. de Cuenta: " + numeroCuentaBuscar)) {
                // Mostrar los datos actuales del alumno
                System.out.println("Datos actuales del alumno: " + linea);

                // Realizar modificaciones en los datos del alumno
                // Modificar el nombre
                System.out.print("Ingrese el nuevo nombre del alumno: ");
                String nuevoNombre = scanner.nextLine();
                linea = linea.replaceFirst("Nombre: [^\t]+", "Nombre: " + nuevoNombre);

                // Modificar el número de cuenta
                System.out.print("Ingrese el nuevo numero de cuenta del alumno: ");
                String nuevoNumeroCuenta = scanner.nextLine();
                linea = linea.replaceFirst("Num\\. de Cuenta: [^\t]+", "Num. de Cuenta: " + nuevoNumeroCuenta);

                // Modificar la edad
                System.out.print("Ingrese la nueva edad del alumno: ");
                String nuevaEdad = scanner.nextLine();
                linea = linea.replaceFirst(" Edad: [^\t]+", " Edad: " + nuevaEdad);

                // Modificar la dirección
                System.out.print("Ingrese la nueva direccion del alumno: ");
                String nuevaDireccion = scanner.nextLine();
                linea = linea.replaceFirst(" Direccion: [^\t]+", " Direccion: " + nuevaDireccion);

                // Modificar el semestre
                System.out.print("Ingrese el nuevo semestre del alumno: ");
                String nuevoSemestre = scanner.nextLine();
                linea = linea.replaceFirst(" Semestre: [^\t]+", " Semestre: " + nuevoSemestre);

                // Modificar el número de inscripción
                System.out.print("Ingrese el nuevo numero de inscripcion del alumno: ");
                String nuevoNumInscripcion = scanner.nextLine();
                linea = linea.replaceFirst(" Num. Inscripcion: [^\t]+", " Num. Inscripcion: " + nuevoNumInscripcion);

                System.out.println("Datos modificados del alumno: " + linea);
                alumnoEncontrado = true;
            }

            // Agregar la línea actual a la lista temporal
            nuevaListaAlumnos.append(linea).append("\n");
        }

        if (!alumnoEncontrado) {
            System.out.println("No se encontró un alumno con el número de cuenta proporcionado.");
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    // Escribir la nueva lista de alumnos al archivo
    try (PrintWriter impresoraDeArchivos = new PrintWriter(new BufferedWriter(new FileWriter("pooProyectoFinal.csv")))) {
        impresoraDeArchivos.print(nuevaListaAlumnos);
        System.out.println("Datos del alumno modificados y guardados en el archivo.");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

       /**
     * Este método elimina los datos de un alumno del archivo CSV.
     * Primero, pide al usuario que ingrese el número de cuenta del alumno que desea eliminar.
     * Luego, lee todas las líneas del archivo CSV y las agrega a una lista, excepto la línea que contiene el número de cuenta del alumno.
     * Finalmente, escribe todas las líneas de la lista de nuevo al archivo CSV, efectivamente eliminando la línea del alumno.
     * Si el alumno no se encuentra en el archivo, se muestra un mensaje indicando que el alumno no existe.
     * Si ocurre un error al acceder al archivo, se muestra un mensaje de error.
     */
    private static void eliminarDatosAlumno() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de cuenta del alumno que desea eliminar: ");
        String numeroCuenta = scanner.nextLine();

        // Crear una lista para almacenar las líneas del archivo que no se eliminarán
        List<String> alumnos = new ArrayList<>();
        boolean alumnoEncontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader("pooProyectoFinal.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Si la línea no contiene el número de cuenta del alumno a eliminar, se agrega a la lista
                if (!linea.contains(numeroCuenta)) {
                    alumnos.add(linea);
                } else {
                    alumnoEncontrado = true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (!alumnoEncontrado) {
            System.out.println("No se encontró un alumno con el número de cuenta proporcionado.");
            return;
        }

        // Escribir todas las líneas de la lista de nuevo al archivo, efectivamente eliminando la línea del alumno
        try (PrintWriter pw = new PrintWriter(new FileWriter("pooProyectoFinal.csv"))) {
            for (String alumno : alumnos) {
                pw.println(alumno);
            }
            // Confirmar que los datos del alumno se eliminaron correctamente
            System.out.println("Los datos del alumno con el numero de cuenta " + numeroCuenta + " se eliminaron correctamente.");
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo acceder al archivo porque está siendo utilizado por otro proceso. Por favor, cierra el archivo en cualquier otro programa y vuelve a intentarlo.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Lee y muestra los datos de los alumnos desde un archivo CSV.
     * Imprime en consola la información de cada alumno registrada en el archivo.
     */
    private static void leerAlumnos() {
        System.out.println("Lectura del archivo");
        try (BufferedReader br = new BufferedReader(new FileReader("pooProyectoFinal.csv"))) {
            System.out.println("El texto del archivo es: ");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            // Manejar el caso de archivo vacío o no encontrado
            if (ex instanceof FileNotFoundException) {
                System.out.println("El archivo no se encuentra o está vacío.");
            } else {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Registra un nuevo alumno en el sistema.
     * Pide al usuario ingresar información como nombre, número de cuenta, edad, dirección, semestre y número de inscripción.
     * Esta información se almacena en un archivo CSV.
     */    
    private static void registrarNuevoAlumno() {
    Scanner scanner = new Scanner(System.in);

    // Solicitar los datos del nuevo alumno
    System.out.print("Ingrese el nombre del nuevo alumno: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese el numero de cuenta del nuevo alumno: ");
    String numeroCuenta = scanner.nextLine();

    System.out.print("Ingrese la edad del nuevo alumno: ");
    String edad = scanner.nextLine();

    System.out.print("Ingrese la direccion del nuevo alumno: ");
    String direccion = scanner.nextLine();

    System.out.print("Ingrese el semestre del nuevo alumno: ");
    String semestre = scanner.nextLine();

    System.out.print("Ingrese el numero de inscripcion del nuevo alumno: ");
    String numInscripcion = scanner.nextLine();

    // Crear una cadena con el formato del archivo CSV
    String nuevoAlumno = String.format("Alumno[Nombre: %s\t Num. de Cuenta: %s\t Edad: %s\t Direccion: %s\t Semestre: %s\t Num. Inscripcion: %s]",
            nombre, numeroCuenta, edad, direccion, semestre, numInscripcion);

    // Escribir el nuevo alumno en el archivo CSV
    try (PrintWriter impresoraDeArchivos = new PrintWriter(new BufferedWriter(new FileWriter("pooProyectoFinal.csv", true)))) {
        impresoraDeArchivos.println(nuevoAlumno);
        System.out.println("Nuevo alumno registrado y guardado en el archivo.");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
/**
 * Muestra la información de los semestres de la carrera.
 * Incluye detalles como las materias ofrecidas en cada semestre.
 */
    private static void verSemestresCarrera() {
    listadoSemestres listado = new listadoSemestres();
    
    // Hay 10 semestres en la carrera
    for (int i = 1; i <= 9; i++) {
        System.out.println("Semestre " + i + ":");
        listado.mostrarMateriasPorSemestre(i);
        System.out.println();
    }   
    }

}
 