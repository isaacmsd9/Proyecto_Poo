/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase Alumno representa a un estudiante y maneja operaciones relacionadas con su información académica.
 * Cada instancia de Alumno almacena detalles como el nombre completo, edad, semestre, dirección, créditos aprobados,
 * y otras métricas relacionadas con su desempeño académico.
 *
 * Funciones Principales:
 * - Representar la información académica de un estudiante.
 * - Generar automáticamente algunos datos del estudiante como nombre, edad, semestre y dirección.
 * - Calcular métricas académicas como escolaridad, velocidad de aprobación y promedio total.
 *
 * @version 1.0
 * @author EquipoH
 */
public class Alumno {
    // Atributos de la clase Alumno
    private String nombreComp; // Nombre completo del alumno

    /**
     *
     */
    public final int edad; // Edad del alumno, final indica que no cambia después de la inicialización
    private int semestre; // Semestre actual del alumno
    private String direccion; // Dirección del alumno
    private int creditosAprobados; // Total de créditos aprobados por el alumno
    private int contadorAprobadas; // Contador de materias aprobadas
    private int[] creditosAsignaturas; // Arreglo de créditos de las asignaturas
    private int creditosTotales; // Total de créditos inscritos
    private int materiasTotales; // Total de materias inscritas
    private int suma; // Suma total de las calificaciones para calcular promedio
    double escolaridad; // Porcentaje de escolaridad del alumno
    double velocidad; // Velocidad de aprobación de créditos
    double promedioTotal; // Promedio total de calificaciones
    int numeroInscripcion; // Número de inscripción basado en el rendimiento académico
    private String numeroCuenta; // Número de cuenta del alumno

    /**
     * Constructor para inicializar un objeto Alumno con valores predeterminados o aleatorios.
     */
    public Alumno() {
        this.edad = new Random().nextInt(10) + 18; // Asigna una edad aleatoria entre 18 y 27
        // Inicialización de otros atributos con valores por defecto
        creditosAprobados = 0;
        contadorAprobadas = 0;
        creditosTotales = 0;
        materiasTotales = 0;
        suma = 0;
        escolaridad = 0;
        velocidad = 0;
        promedioTotal = 0;
        numeroInscripcion = 0;
    }

    
    // Métodos Getters y Setters para los atributos

    /**
     * Obtiene el nombre completo del alumno.
     *
     * @return El nombre completo del alumno.
     */
    public String getNombreComp() {
        return nombreComp;
    }

    /**
     * Asigna un nombre completo al alumno generado automáticamente.
     */
    public void setNombreComp() {
        this.nombreComp = generarNombreComp();
    }

    /**
     * Obtiene la edad del alumno.
     *
     * @return La edad del alumno.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el semestre actual del alumno.
     *
     * @return El semestre actual del alumno.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Asigna el semestre del alumno calculándolo en base a su edad.
     */
    public void setSemestre() {
        this.semestre = calcularSemestre();
    }

    /**
     * Obtiene la dirección del alumno.
     *
     * @return La dirección del alumno.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna una dirección al alumno generada automáticamente.
     */
    public void setDireccion() {
        this.direccion = generarDireccion();
    }

    /**
     * Obtiene el número de cuenta del alumno.
     *
     * @return El número de cuenta del alumno.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de cuenta del alumno.
     *
     * @param numeroCuenta El número de cuenta a establecer.
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
        
        
    
    // Métodos privados para generar datos aleatorios

    /**
     * Genera un nombre completo para el alumno combinando nombres y apellidos aleatorios.
     *
     * @return El nombre completo generado.
     */
    private String generarNombreComp() {
        List<String> nombres = archivo("Nombres.txt");
        List<String> apellidos = archivo("Apellidos.txt");

        String nombre = nombreRandom(nombres);
        Random numAleatorio = new Random();
        int num = numAleatorio.nextInt() + 50;
        for (int n = 2; n < num; n++) {
            if (num % n == 0) {
                break;
            }else{
                nombre += "" + nombreRandom(nombres);
                break;
            }
        }
        String apellidoP = nombreRandom(apellidos);
        String apellidoM = nombreRandom(apellidos);

        return nombre + " " + apellidoP + " " + apellidoM;
    }

    /**
     * Selecciona un nombre aleatorio de una lista de nombres.
     *
     * @param listaNombres Lista de nombres entre los cuales elegir.
     * @return Un nombre seleccionado aleatoriamente de la lista.
     */
    private String nombreRandom(List<String> lista) {
        String[] nombres = lista.get(0).split(","); 
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }

    /**
     * Genera una dirección aleatoria para el alumno.
     *
     * @return La dirección generada.
     */
    private String generarDireccion() {
        List<String> direcciones = archivo("Direcciones.txt");

        if (direcciones.isEmpty()) {
            System.out.println("No hay direcciones");
            return ""; 
        } else {
            return direccionRandom(direcciones);
        }
    }

    /**
     * Selecciona una dirección aleatoria de una lista de direcciones.
     *
     * @param listaDirecciones Lista de direcciones entre las cuales elegir.
     * @return Una dirección seleccionada aleatoriamente de la lista.
     */
    private String direccionRandom(List<String> listaDirecciones) {
        Random random = new Random();
        String direccionRandom = listaDirecciones.get(random.nextInt(listaDirecciones.size()));
        return direccionRandom.trim();
    }

    /**
     * Lee un archivo y devuelve una lista de líneas del archivo.
     *
     * @param nombreArchivo El nombre del archivo a leer.
     * @return Una lista de líneas del archivo.
     */
    private List<String> archivo(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get(nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Archivo no leido: " + e.getMessage());
        }
        return lineas;
    }

    /**
     * Calcula el semestre actual del alumno basado en su edad.
     *
     * @return El semestre calculado.
     */
    public int calcularSemestre() {
        int semestre;

        semestre = switch (edad) {
            case 18, 19 -> (int) (Math.random() * 3) + 1;
            case 20, 21 -> (int) (Math.random() * 4) + 2;
            case 22, 23 -> (int) (Math.random() * 4) + 4;
            default -> (int) (Math.random() * 4) + 7;
        };

        return semestre;
    }
    
    
   

    
    /**
     * Genera calificaciones para el alumno junto con sus créditos.
     * La lógica y los créditos varían según el semestre del alumno.
     *
     * @param numCalificaciones Número de calificaciones a generar.
     * @param valorMinimo Valor mínimo para la generación aleatoria de calificaciones.
     * @param valorMaximo Valor máximo para la generación aleatoria de calificaciones.
     * @return El número de inscripción calculado en base a las calificaciones y créditos.
     */
    public int generarCalificacionesConCreditos(int numCalificaciones, double valorMinimo, double valorMaximo) {
        Random random = new Random();
        double[] calificaciones = new double[numCalificaciones];
        //AsignadorCalificaciones asignador = new AsignadorCalificaciones();

        // Asignar calificaciones para el semestre 1
        /*double[] calificacionesSemestre1 = asignador.generarCalificacionesConCreditos(5, 5,10);
        asignador.mostrarCalificaciones("Semestre 1", calificacionesSemestre1);
        
        */
        
        int numero = semestre;

        // El cálculo varía según el semestre del alumno
        switch (numero) {
            case 1 -> {
                // Lógica específica para el semestre 1          
                creditosAsignaturas = new int[]{8, 12, 10, 6, 10};
                
                
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }
                
            case 2 -> {
                // Lógica específica para el semestre 2
                creditosAsignaturas = new int[]{8, 8, 12, 6, 10};
                creditosAprobados = 46;
                contadorAprobadas = 5;
                creditosTotales = 46;
                materiasTotales = 5;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                
                //----------------------------------------------------//
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }
                
             
            case 3 -> {
                // Lógica específica para el semestre 3
                creditosAsignaturas = new int[]{8, 8, 8, 2, 10};
                creditosAprobados = 90;
                contadorAprobadas = 10;
                creditosTotales = 90;
                materiasTotales = 10;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                
                //-----------------------------------------------//
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 4 -> {
                // Lógica específica para el semestre 4
                creditosAsignaturas = new int[]{8, 10, 8, 8, 8};
                creditosAprobados = 126;
                contadorAprobadas = 15;
                creditosTotales = 126;
                materiasTotales = 15;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                
                //--------------------------------//
                
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 5 -> {
                // Lógica específica para el semestre 5
                creditosAsignaturas = new int[]{8, 10, 8, 8, 8};
                creditosAprobados = 168;
                contadorAprobadas = 20;
                creditosTotales = 168;
                materiasTotales = 20;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                //----------------------------------------------------------//
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 6 -> {
                // Lógica específica para el semestre 6
                creditosAsignaturas = new int[]{8, 10, 14, 8, 8};
                creditosAprobados = 210;
                contadorAprobadas = 25;
                creditosTotales = 210;
                materiasTotales = 25;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                //---------------------------------------------------//
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 7 -> {
                // Lógica específica para el semestre 7
                creditosAsignaturas = new int[]{6, 8, 8, 8, 8};
                creditosAprobados = 258;
                contadorAprobadas = 30;
                creditosTotales = 258;
                materiasTotales = 30;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                //------------------------------------------------------------//
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 8 -> {
                // Lógica específica para el semestre 8
                creditosAsignaturas = new int[]{6, 8, 10, 6, 14};
                creditosAprobados = 296;
                contadorAprobadas = 35;
                creditosTotales = 296;
                materiasTotales = 35;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                //----------------------------------------------//
                
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 9 -> {
                // Lógica específica para el semestre 9
                creditosAsignaturas = new int[]{8, 8, 8, 8, 8};
                creditosAprobados = 340;
                contadorAprobadas = 40;
                creditosTotales = 340;
                materiasTotales = 40;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                //-----------------------------------------------//
                
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;
                    }
                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            case 10 -> {
                // Lógica específica para el semestre 10
                creditosAsignaturas = new int[]{10, 8, 14, 12, 14};
                creditosAprobados = 380;
                contadorAprobadas = 45;
                creditosTotales = 380;
                materiasTotales = 45;
                promedioTotal = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);
                
                
                
                //---------------------------------------------------//
                
                for (int i = 0; i < numCalificaciones; i++) {
                    // Generar calificación aleatoria en el rango de valorMinimo a valorMaximo
                    calificaciones[i] = valorMinimo + random.nextDouble() * (valorMaximo - valorMinimo);

                    // Verificar si la calificación es aprobatoria (por ejemplo, mayor o igual a 60)
                    if (calificaciones[i] >= 6) {
                        creditosAprobados = creditosAprobados + creditosAsignaturas[i];
                        contadorAprobadas += 1;

                    }

                    creditosTotales = creditosTotales + creditosAsignaturas[i];
                    materiasTotales += 1 ;
                    suma += calificaciones[i];  
                    
                }
                escolaridad = ((double) contadorAprobadas / materiasTotales) * 100;
                
                velocidad = ((double) creditosAprobados / creditosTotales) * 100;
                
                promedioTotal = ((double) (promedioTotal + (suma / 5))/2);
                
                numeroInscripcion = ((int)(100000-(promedioTotal*escolaridad * velocidad))/100);
            }

            default -> {
            }
        }
        return numeroInscripcion;
    }

    /*
    Método comentado `mostrarCalificaciones` que podría usarse para imprimir las calificaciones del alumno
    public int mostrarCalificaciones(String semestre, double[] calificaciones) {
        // Código para imprimir las calificaciones...
    }
    */

    /**
     * Proporciona una representación en cadena del objeto Alumno, incluyendo información relevante.
     *
     * @return Una cadena que representa al objeto Alumno con sus datos más importantes.
     */
    @Override
    public String toString() {
        return "Alumno[" + "Nombre: " + nombreComp +", Num. de Cuenta: "+numeroCuenta+ ", Edad: " + edad +  ", Direccion: " + direccion + ", Semestre: " + semestre + ", Num. Inscripcion: "+ numeroInscripcion+']';
    }
}