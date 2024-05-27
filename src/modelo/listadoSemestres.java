/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase listadoSemestres se encarga de gestionar y mostrar información académica relacionada con los semestres.
 * Incluye funcionalidades para calcular un número de inscripción basado en criterios académicos y mostrar las materias
 * por semestre.
 *
 * @version 1.0
 * @author EquipoH
 */
public class listadoSemestres {

    static int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static List<String> get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String numInsc; // Número de inscripción como cadena
    /**
     * Constructor por defecto de listadoSemestres.
     */    
    public listadoSemestres() {
    }
    /**
     * Constructor de listadoSemestres con un número de inscripción específico.
     *
     * @param numInsc Número de inscripción del semestre.
     */
    public listadoSemestres(String numInsc) {
        this.numInsc = numInsc;
    }
    /**
     * Obtiene el número de inscripción.
     *
     * @return Número de inscripción actual.
     */
    public String getNumInsc() {
        return numInsc;
    }
    /**
     * Establece o actualiza el número de inscripción.
     *
     * @param numInsc Nuevo número de inscripción.
     */
    public void setNumInsc(String numInsc) {
        this.numInsc = numInsc;
    }

    /**
     * Muestra las materias correspondientes a un número de semestre dado.
     * Las materias están predefinidas para cada semestre.
     *
     * @param numeroSemestre El número de semestre para el cual se desean ver las materias.
     */
    public void mostrarMateriasPorSemestre(int numeroSemestre) {
        List<List<String>> listadoSemestres = new ArrayList<>();

        // Definición de asignaturas para cada semestre
        listadoSemestres.add(List.of("Algebra", "Calculo y Geometria Analitica", "Quimica", "Fundamentos de fisica", "Fundamentos de Programacion", "Igualdad de genero en Ingenieria"));
        listadoSemestres.add(List.of("Algebra lineal", "Calculo Integral", "Mecanica", "Redaccion y exposicion de temas de ingenieria", "Estructura de Datos y Algoritmos I"));
        listadoSemestres.add(List.of("Probabilidad", "Calculo Vectorial", "Ecuaciones Diferenciales", "Cultura y Comunicacion", "Estructura de Datos y Algoritmos II", "Programacion Orientada a Objetos"));
        listadoSemestres.add(List.of("Fundamentos de Estadistica", "Electricidad y Magnetismo", "Analisis Numerico", "Matematicas Avanzadas", "Estructuras Discretas"));
        listadoSemestres.add(List.of("Estructura y programacion de computadoras", "Dispositivos Electronicos", "Lenguajes formales y automatas", "Senales y sistemas", "Ingenieria en Software"));
        listadoSemestres.add(List.of("Sistemas operativos", "Diseno digital moderno", "Bases de datos", "Circuitos electricos", "Administracion de proyectos de software"));
        listadoSemestres.add(List.of("Finanzas en la ingenieria en computacion", "Diseno digital VLSI", "Inteligencia Artificial", "Compiladores", "Sistemas de comunicaciones", "Introduccion a la economia"));
        listadoSemestres.add(List.of("OPTATIVAS DE CIENCIAS SOCIALES", "Microcomputadoras", "Computacion Grafica", "Etica profesional", "Redes de datos seguras"));
        listadoSemestres.add(List.of("Organizacion y arquitectura de computadoras", "Fundamentos de sistemas embebidos", "Sistemas Distribuidos", "Optativa de campo de profundizacion", "Recursos y necesidades de mexico"));

        if (numeroSemestre >= 1 && numeroSemestre <= listadoSemestres.size()) {
            System.out.println("Asignaturas del Semestre " + numeroSemestre + ": ");
            List<String> materias = listadoSemestres.get(numeroSemestre - 1);
            for (String materia : materias) {
                System.out.println("- " + materia);
            }
        } else {
            System.out.println("Número de semestre no válido.");
        }
    }
    /**
     * Calcula un número de inscripción basado en criterios académicos como materias aprobadas,
     * materias inscritas, créditos totales y calificaciones.
     * Esta función solicita al usuario ingresar los datos necesarios para el cálculo.
     *
     * @return El número de inscripción calculado.
     */    
    public double calcularNumeroInscripcion() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el numero de materias aprobadas: ");
    int materiasAprobadas = scanner.nextInt();

    System.out.print("Ingrese el numero total de materias inscritas: ");
    int materiasInscritas = scanner.nextInt();

    System.out.print("Ingrese el numero total de creditos desde que ingreso a la universidad: ");
    int creditosTotales = scanner.nextInt();

    System.out.print("Ingrese el numero de creditos del alumno: ");
    int creditosAlumno = scanner.nextInt();

    System.out.println("Ingrese la suma todas las calificaciones: ");
    int promedio = scanner.nextInt();

    double escolaridad = ((double) materiasAprobadas / materiasInscritas) * 100;
    double velocidad = ((double) creditosAlumno / creditosTotales) * 100;
    double promedioTotal = ((double) promedio / materiasAprobadas);
    double numeroInscripcion = escolaridad * velocidad;

    System.out.println("Escolaridad: " + escolaridad);
    System.out.println("Velocidad: " + velocidad);
    System.out.println("Promedio actual: " + promedioTotal);
    System.out.println("Numero de inscripcion: " + numeroInscripcion);

    return numeroInscripcion;
}
  
}
    

    
    
    



