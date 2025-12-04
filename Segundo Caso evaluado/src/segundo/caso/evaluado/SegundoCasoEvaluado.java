/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundo.caso.evaluado;

import javax.swing.JOptionPane;

/**
 *
 * @author Wilman
 */
public class SegundoCasoEvaluado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int filas = 3;
        int columnas = 4;
        Asientos matriz[][] = new Asientos[filas][columnas];
        matriz[0][0] = new Asientos(Disponibilidad.Libre, "Fila A", "A1", "Primera", 300);
        matriz[1][0] = new Asientos(Disponibilidad.Libre, "Fila B", "B1", "Negocios", 200);
        matriz[2][0] = new Asientos(Disponibilidad.Libre, "Fila C", "B1", "Economica", 300);
        matriz[0][1] = new Asientos(Disponibilidad.Libre, "Fila A", "A2", "Primera", 300);
        matriz[1][1] = new Asientos(Disponibilidad.Libre, "Fila B", "B2", "Negocios", 200);
        matriz[2][1] = new Asientos(Disponibilidad.Libre, "Fila C", "C2", "Economica", 300);
        matriz[0][2] = new Asientos(Disponibilidad.Libre, "Fila A", "A3", "Primera", 300);
        matriz[1][2] = new Asientos(Disponibilidad.Libre, "Fila B", "B3", "Negocios", 200);
        matriz[2][2] = new Asientos(Disponibilidad.Libre, "Fila C", "C3", "Economica", 300);
        matriz[0][3] = new Asientos(Disponibilidad.Libre, "Fila A", "A4", "Primera", 300);
        matriz[1][3] = new Asientos(Disponibilidad.Libre, "Fila B", "B4", "Negocios", 200);
        matriz[2][3] = new Asientos(Disponibilidad.Libre, "Fila C", "C4", "Economica", 300);
        menu(matriz, filas, columnas);

    }

    public static void menu(Asientos matriz[][], int filas, int columnas) {
        boolean ciclo = true;
        while (ciclo == true) {
            String opcion = JOptionPane.showInputDialog("                *****MENU*****  \n \n Porfavor digite que desea realizar? \n1. mostrar asientos \n2. reservar asientos \n3. consultar estado asiento \n4. ver resumen general de ventas\n5. Salir");
            if (opcion.equals("1")) {
                mostrarMatriz(matriz, filas, columnas);
            }
            if (opcion.equals("2")) {
                reservarAsiento(matriz, filas, columnas);

            }
            if (opcion.equals("3")) {
                ConsultarAsiento(matriz, filas, columnas);

            }
            if (opcion.equals("4")) {
                Resumen(matriz, filas, columnas);

            }
            if (opcion.equals("5")) {
                ciclo = false;
            }
        }

    }

    public static void mostrarMatriz(Asientos matriz[][], int filas, int columnas) {
        String resultado = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado += matriz[i][j].getLetra() + "  ";
                resultado += matriz[i][j].getCodigoAsiento() + "  ";
                resultado += matriz[i][j].getDisponibilidad() + "  ";
                resultado += matriz[i][j].getClase() + "  ";
                resultado += matriz[i][j].getPrecio() + "  |";
            }
            resultado += "\n" + "_______________________________________________________________________________________________________________________________";
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void reservarAsiento(Asientos matriz[][], int filas, int columnas) {
        String frecuencia = JOptionPane.showInputDialog("El cliente es un cliente frecuente?");

        String asiento = JOptionPane.showInputDialog("Digite que asiento desea reservar");
        boolean noExiste = false;
        boolean siExiste = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j].getCodigoAsiento().equals(asiento)) {
                    matriz[i][j].setNombreCliente(JOptionPane.showInputDialog("Digite el nombre del cliente"));
                    matriz[i][j].setNumeroPasaporteCliente(JOptionPane.showInputDialog("Digite el pasaporte del cliente"));
                    matriz[i][j].setNacionalidadlCiente(JOptionPane.showInputDialog("Digite la nacionalidad del cliente"));
                    matriz[i][j].setDisponibilidad(Disponibilidad.Ocupado);
                    siExiste = true;
                    noExiste = false;
                }
                if (siExiste == false) {
                    if (asiento != matriz[i][j].getCodigoAsiento()) {
                        noExiste = true;
                    }
                }
            }
        }
        if (noExiste == true) {
            JOptionPane.showMessageDialog(null, "el asiento no existe");
        }
        if (frecuencia.toLowerCase().equals("si")) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j].getClase().equals("Economica") && matriz[i][j].getCodigoAsiento().equals(asiento)) {
                        double descuento = matriz[i][j].getPrecio() * 0.10;
                        double precioAplicado = matriz[i][j].getPrecio() - descuento;
                        matriz[i][j].setPrecio(precioAplicado);
                    }
                    if (matriz[i][j].getClase().equals("Negocios") && matriz[i][j].getCodigoAsiento().equals(asiento)) {
                        double descuento = matriz[i][j].getPrecio() * 0.15;
                        double precioAplicado = matriz[i][j].getPrecio() - descuento;
                        matriz[i][j].setPrecio(precioAplicado);
                    }
                    if (matriz[i][j].getClase().equals("Primera") && matriz[i][j].getCodigoAsiento().equals(asiento)) {
                        double descuento = matriz[i][j].getPrecio() * 0.18;
                        double precioAplicado = matriz[i][j].getPrecio() - descuento;
                        matriz[i][j].setPrecio(precioAplicado);
                    }
                }

            }

        }
    }

    public static void ConsultarAsiento(Asientos matriz[][], int filas, int columnas) {
        String consulta = JOptionPane.showInputDialog("Digite que haciendo desea consultar?");
        String resultado = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j].getCodigoAsiento().equals(consulta)) {
                    if ("Ocupado".equals(matriz[i][j].getDisponibilidad().toString())) {
                        resultado += "El asiento esta ocupado por:" + "\n";
                        resultado += "Nombre: " + matriz[i][j].getNombreCliente() + "\n";
                        resultado += "Pasaporte: " + matriz[i][j].getNumeroPasaporteCliente() + "\n";
                        resultado += "Nacionalidad: " + matriz[i][j].getNacionalidadlCiente() + "\n";
                        JOptionPane.showMessageDialog(null, resultado);

                    }
                    if ("Libre".equals(matriz[i][j].getDisponibilidad().toString())) {
                        resultado += "El asiento esta libre";
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                }
            }

        }
    }

    public static void Resumen(Asientos matriz[][], int fila, int columna) {
        double sumatoria = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if ("Ocupado".equals(matriz[i][j].getDisponibilidad().toString())) {
                    sumatoria += matriz[i][j].getPrecio();
                }
            }
        }
        JOptionPane.showMessageDialog(null, sumatoria);

    }


}


