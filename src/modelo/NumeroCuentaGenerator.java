/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * La clase NumeroCuentaGenerator se encarga de generar números de cuenta únicos para alumnos.
 * Utiliza un contador estático para mantener la unicidad de cada número generado. Los números
 * de cuenta se basan en el año de ingreso del alumno y un contador secuencial.
 *
 * Funciones Principales:
 * - Generar un número de cuenta único para cada alumno.
 * - Asegurar que cada número de cuenta sea único utilizando un contador estático.
 *
 * @version 1.0
 * @author EquipoH
 */
public class NumeroCuentaGenerator {

    private static int contador = 0; // Contador estático para la unicidad de los números de cuenta

    /**
     * Genera un número de cuenta único para un alumno basándose en el año de ingreso.
     * El número de cuenta se forma combinando una base derivada del año de ingreso y un contador
     * que incrementa con cada llamada a este método, garantizando así números únicos.
     *
     * @param anioIngreso Año en el que el alumno ingresó a la universidad.
     * @return Número de cuenta generado, compuesto por el año de ingreso y un contador único.
     */
    public static String generarNumeroCuenta(int anioIngreso) {
        int anioBase = (anioIngreso + 1) % 100; // Obtiene los últimos dos dígitos del año
        String base = "3" + String.format("%02d", anioBase); // Forma la base del número de cuenta

        contador++; // Incrementa el contador para mantener la unicidad

        // Combina la base con el contador para formar el número de cuenta completo
        return base + String.format("%04d", contador);
    }
}

