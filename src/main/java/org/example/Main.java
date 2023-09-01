package org.example;

import java.util.Scanner;

class Especialista {
    String nombre;
    String cedula;
    String especialidad;
    double salario;
    String fechaIngreso;

    Double horasTrabajadas;

}
class MenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        final int MAX_ESPECIALISTAS = 100;
        Especialista[] especialistas = new Especialista[100];
        int numEspecialistas = 0;

        do {
            System.out.println("Bienvenido al sistema de gestión");
            System.out.println("\u001B[36m 1. Administrador  \u001B[0m");
            System.out.println("\u001B[36m 2. Especialista  \u001B[0m");
            System.out.println("\u001B[36m 3. Paciente \u001B[0m");
            System.out.println("\u001B[36m 0. Salir  \u001B[0m");
            System.out.print("Seleccione su rol: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                    System.out.println("Bienvenido, Administrador");
                    int opcionAdmin;
                    do {

                        System.out.println("\u001B[32m Menú de Administrador  \u001B[0m");
                        System.out.println("\u001B[35m 1. Registrar Especialista  \u001B[0m");
                        System.out.println("\u001B[35m 2. Ver Información de Especialistas  \u001B[0m");
                        System.out.println("\u001B[35m 3. Buscar Especialista  \u001B[0m");
                        System.out.println("\u001B[35m 4. Eliminar Especialista  \u001B[0m");
                        System.out.println("\u001B[35m 0. Volver al Menú Principal  \u001B[0m");
                        System.out.print("Seleccione una opción: ");

                        opcionAdmin = scanner.nextInt();

                        switch (opcionAdmin) {
                            case 1:
                                if (numEspecialistas < MAX_ESPECIALISTAS) {
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                    System.out.println("\u001B[31m Ingrese los detalles del especialista:  \u001B[0m");
                                    Especialista nuevoEspecialista = new Especialista();
                                    scanner.nextLine();
                                    System.out.print("\u001B[34m Digita el Nombre Completo: \u001B[0m");
                                    nuevoEspecialista.nombre = scanner.nextLine();
                                    System.out.print("\u001B[34m Cédula: \u001B[0m");
                                    nuevoEspecialista.cedula = scanner.nextLine();
                                    System.out.print("\u001B[34m Especialidad:  \u001B[0m");
                                    nuevoEspecialista.especialidad = scanner.nextLine();
                                    System.out.print("\u001B[34m Salario: \u001B[0m");
                                    nuevoEspecialista.salario = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("\u001B[34m Fecha de ingreso: \u001B[0m");
                                    nuevoEspecialista.fechaIngreso = scanner.nextLine();

                                    especialistas[numEspecialistas] = nuevoEspecialista;
                                    numEspecialistas++;
                                    System.out.println("\u001B[31m Especialista registrado con éxito.  \u001B[0m");
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                } else {
                                    System.out.println("No se pueden registrar más especialistas. Límite alcanzado.");
                                }
                                break;

                            case 2:
                                System.out.println("Información de Especialistas:");
                                Boolean bandera=false;

                                for (int i = 0; i < numEspecialistas; i++) {
                                    if (especialistas[i] == null) {

                                        bandera=false;
                                    }else{
                                        System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                        System.out.println("\u001B[32m Especialista #  \u001B[0m" + (i + 1));
                                        System.out.println("\u001B[34m  Nombre Completo: \u001B[0m" + especialistas[i].nombre);
                                        System.out.println("\u001B[34m Cédula: \u001B[0m" + especialistas[i].cedula);
                                        System.out.println("\u001B[34m Especialidad:  \u001B[0m" + especialistas[i].especialidad);
                                        System.out.println("\u001B[34m Salario: \u001B[0m" + especialistas[i].salario);
                                        System.out.println("\u001B[34m Fecha de ingreso: \u001B[0m" + especialistas[i].fechaIngreso);

                                        bandera=true;
                                    }

                                }

                                if (bandera==false) {

                                    System.out.println("aun no tenemos especialistas");
                                }
                                break;

                            case 3:
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                scanner.nextLine();
                                System.out.print("\u001B[34m Ingrese la cédula del especialista a buscar: \u001B[0m ");
                                String cedulaBusqueda = scanner.nextLine();
                                boolean encontrado = false;


                                for (int i = 0; i < numEspecialistas; i++) {
                                    if (especialistas[i].cedula.equals(cedulaBusqueda)) {
                                        System.out.println("Especialista encontrado:");
                                        System.out.println("Nombre: "+ especialistas[i].nombre);
                                        System.out.println("Cédula: " + especialistas[i].cedula);
                                        System.out.println("Especialidad: " + especialistas[i].especialidad);
                                        System.out.println("Salario: " + especialistas[i].salario);
                                        System.out.println("Fecha de ingreso: " + especialistas[i].fechaIngreso);
                                        System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                        encontrado = true;
                                        break;
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("Especialista no encontrado.");
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                }
                                break;

                            case 4:
                                scanner.nextLine();
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                System.out.print("\u001B[34m Ingrese la cédula del especialista a eliminar: \u001B[0m ");
                                String cedulaEliminar = scanner.nextLine();
                                boolean eliminado = false;

                                for (int i = 0; i < numEspecialistas; i++) {
                                    if (especialistas[i].cedula.equals(cedulaEliminar)) {

                                        for (int j = i; j < numEspecialistas - 1; j++) {
                                            especialistas[j] = especialistas[j + 1];
                                        }
                                        numEspecialistas--;
                                        eliminado = true;
                                        System.out.println("\u001B[31m Especialista eliminado con éxito. \u001B[0m");
                                        System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                        break;
                                    }
                                }

                                if (!eliminado) {
                                    System.out.println("Especialista no encontrado para eliminar.");
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                }
                                break;

                            case 0:
                                System.out.println("Volviendo al Menú Principal.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");

                                break;

                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                break;
                        }
                    } while (opcionAdmin != 0);
                    break;

                case 2:
                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                    System.out.println("Bienvenido, Especialista");
                    int opcionEspecialista;
                    do {
                        System.out.println("\u001B[32m Menú de Especialista \u001B[0m");
                        System.out.println("\u001B[35m1. Ingresar Horas Trabajadas\u001B[0m");
                        System.out.println("\u001B[35m2. Consultar Salario\u001B[0m");
                        System.out.println("\u001B[35m3. Consultar Base de Datos de Especialistas\u001B[0m");
                        System.out.println("\u001B[35m0. Volver al Menú Principal\u001B[0m");
                        System.out.print("Seleccione una opción: ");
                        opcionEspecialista = scanner.nextInt();

                        switch (opcionEspecialista) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                System.out.print("\u001B[34mIngrese la cédula del especialista:\u001B[0m ");
                                String cedulaEspecialista = scanner.nextLine();

                                boolean encontrado = false;
                                for (int i = 0; i < numEspecialistas; i++) {
                                    if (especialistas[i].cedula.equals(cedulaEspecialista)) {
                                        System.out.print("Ingrese el número de horas trabajadas: ");
                                        especialistas[i].horasTrabajadas = scanner.nextDouble();
                                        System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                        encontrado = true;
                                        break;
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("Especialista no encontrado.");
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                }
                                break;

                            case 2:
                                scanner.nextLine();
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                System.out.print("\u001B[34mIngrese su número de cédula: \u001B[34m ");
                                String cedulaConsulta = scanner.nextLine();

                                double salarioInicial = 0;
                                for (int indice = 0; indice < numEspecialistas; indice++) {
                                    if (especialistas[indice].cedula.equals(cedulaConsulta)) {
                                        salarioInicial = especialistas[indice].salario * especialistas[indice].horasTrabajadas;
                                        double retencion = salarioInicial * 0.04;
                                        double salarioTotal = salarioInicial - retencion;
                                        System.out.println("Salario Inicial: " + salarioInicial);
                                        System.out.println("Retención (4%): " + retencion);
                                        System.out.println("Salario Total: " + salarioTotal);
                                        System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                        break;
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                System.out.println("Base de Datos de Especialistas:");
                                for (int i = 0; i < numEspecialistas; i++) {
                                    System.out.println("\u001B[34mEspecialista # \u001B[0m" + (i + 1));
                                    System.out.println("\u001B[34m Nombre: \u001B[0m" + especialistas[i].nombre);
                                    System.out.println("\u001B[34m Cédula: \u001B[0m " + especialistas[i].cedula);
                                    System.out.println("\u001B[34m Especialidad: \u001B[0m" + especialistas[i].especialidad);
                                    System.out.println("\u001B[34m Fecha de ingreso: \u001B[0m " + especialistas[i].fechaIngreso);
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                }
                                break;

                            case 0:
                                System.out.println("Volviendo al Menú Principal.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                break;

                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                break;
                        }
                    } while (opcionEspecialista != 0);
                    break;
                case 3:
                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                    System.out.println("Bienvenido, Paciente");
                    int opcionPaciente;
                    do {
                        System.out.println("\u001B[32m Menú de Pacientes sura \u001B[0m");
                        System.out.println("\u001B[35m1. Ver infromacion de los especialistas \u001B[0m");
                        System.out.println("\u001B[35m0. Volver al Menú Principal\u001B[0m");
                        opcionPaciente = scanner.nextInt();
                        switch (opcionPaciente) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                System.out.println("Base de Datos de Especialistas:");
                                for (int i = 0; i < numEspecialistas; i++) {
                                    System.out.println("\u001B[34mEspecialista # \u001B[0m" + (i + 1));
                                    System.out.println("\u001B[34m Nombre: \u001B[0m" + especialistas[i].nombre);
                                    System.out.println("\u001B[34m Cédula: \u001B[0m " + especialistas[i].cedula);
                                    System.out.println("\u001B[34m Especialidad: \u001B[0m" + especialistas[i].especialidad);
                                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al Menú Principal.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                                System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                                break;
                        }

                    } while (opcionPaciente != 0);
                    break;

                case 0:
                    System.out.println("Fue un placer atenderte, ¡te llevaremos en nuestros corazones!");
                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    System.out.println("\u001B[31m ------------------------------ \u001B[0m");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}