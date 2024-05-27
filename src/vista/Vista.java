/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;

/**
 * La clase Vista gestiona la interacción con el usuario a través de la consola.
 * Proporciona métodos para mostrar menús, recoger datos de entrada y mostrar mensajes al usuario.
 *
 * @version 1.0
 */
public class Vista {
    private Scanner scanner;
    
    /**
     * Constructor de la clase Vista.
     * Inicializa un objeto Scanner para leer la entrada del usuario.
     */
    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal y devuelve la opción seleccionada por el usuario.
     *
     * @return int que representa la opción seleccionada por el usuario.
     */    
    public int mostrarMenuPrincipal() {
        System.out.println("\n*** Menu de Opciones | By Omninet ***");
        System.out.println("1. Eliminar datos de un alumno");
        System.out.println("2. Modificar datos de un alumno");
        System.out.println("3. Registrar un nuevo alumno");
        System.out.println("4. Leer alumnos");
        System.out.println("5. Calcular numero de inscripcion");
        System.out.println("6. Ver semestres de la carrera");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }

    /**
     * Pide al usuario un dato y lo retorna.
     *
     * @param mensaje El mensaje a mostrar al usuario para pedir el dato.
     * @return String que contiene el dato introducido por el usuario.
     */    
    // Métodos para pedir datos al usuario
    public String pedirDato(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine(); // Limpiar buffer del scanner
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje al usuario.
     *
     * @param mensaje El mensaje a mostrar.
     */    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Pide al usuario un número entero y lo retorna.
     *
     * @param mensaje El mensaje a mostrar al usuario para pedir el número.
     * @return int que representa el número entero introducido por el usuario.
     */    
    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Muestra los datos de un alumno.
     *
     * @param datos String que contiene los datos del alumno a mostrar.
     */    
    public void mostrarDatosAlumno(String datos) {
        System.out.println("Datos del alumno: " + datos);
    }

    /**
     * Muestra una línea de texto.
     *
     * @param linea La línea de texto a mostrar.
     */    
    public void mostrarLinea(String linea) {
        System.out.println(linea);
    }

    /**
     * Muestra un mensaje de error.
     *
     * @param mensaje El mensaje de error a mostrar.
     */
    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    /**
     * Muestra los detalles de una excepción.
     *
     * @param ex La excepción cuyos detalles deben mostrarse.
     */
    public void mostrarExcepcion(Exception ex) {
        ex.printStackTrace();
    }

    /**
     * Pide al usuario el nombre del alumno y lo retorna.
     *
     * @return String que contiene el nombre del alumno introducido por el usuario.
     */    
    // Métodos específicos para recoger y modificar datos del alumno
    public String pedirNombreAlumno() {
        return pedirDato("Ingrese el nombre del nuevo alumno: ");
    }

    /**
     * Pide al usuario el número de cuenta del alumno y lo retorna.
     *
     * @return String que contiene el número de cuenta del alumno introducido por el usuario.
     */    
    public String pedirNumeroCuentaAlumno() {
        return pedirDato("Ingrese el numero de cuenta del alumno: ");
    }

    /**
     * Pide al usuario la edad del alumno y la retorna.
     *
     * @return String que contiene la edad del alumno introducida por el usuario.
     */    
    public String pedirEdadAlumno() {
        return pedirDato("Ingrese la edad del nuevo alumno: ");
    }

    /**
     * Pide al usuario la dirección del alumno y la retorna.
     *
     * @return String que contiene la dirección del alumno introducida por el usuario.
     */ 
    public String pedirDireccionAlumno() {
        return pedirDato("Ingrese la direccion del nuevo alumno: ");
    }

    /**
     * Pide al usuario el semestre del alumno y lo retorna.
     *
     * @return String que contiene el semestre del alumno introducido por el usuario.
     */   
    public String pedirSemestreAlumno() {
        return pedirDato("Ingrese el semestre del nuevo alumno: ");
    }

    /**
     * Pide al usuario el número de inscripción del alumno y lo retorna.
     *
     * @return String que contiene el número de inscripción del alumno introducido por el usuario.
     */    
    public String pedirNumeroInscripcionAlumno() {
        return pedirDato("Ingrese el numero de inscripcion del nuevo alumno: ");
    }

    /**
     * Método aún no implementado para mostrar un error específico cuando no se encuentra un archivo.
     * Actualmente, arroja una excepción de operación no soportada.
     */
    public void mostrarErrorArchivoNoEncontrado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

