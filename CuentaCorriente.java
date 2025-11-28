package ejercicio2;

import javax.swing.JOptionPane;

public class CuentaCorriente {

    public static void main(String[] args) {
        double monto;
        String seleccion;
        
        Usuario cuenta1 = new Usuario("Juan Perez", 22000.00);
        Usuario cuenta2 = new Usuario("Diana Prince", 17800.00);

        JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de Cuentas Corrientes!");
        do {
            String menu = "¿Qué operación desea realizar? \n\n"
                        + "1 = Consultar datos de cuenta \n"
                        + "2 = Retiros\n"
                        + "3 = Transferencias\n"
                        + "4 = Bloquear/Desbloquear Cuenta\n\n"
                        + "Escriba 'SALIR' para terminar";
            seleccion = JOptionPane.showInputDialog(null, menu);
            if (seleccion == null || seleccion.equalsIgnoreCase("SALIR")) {
                break;
            }
            try {
                switch (seleccion) {
                    case "1": 
                        String inputCuentas = "Seleccione cuenta:\n1 - Juan Perez\n2 - Diana Prince";
                        String cuenStr = JOptionPane.showInputDialog(null, inputCuentas);
                        
                        if (cuenStr == null) break;
                        int cuen = Integer.parseInt(cuenStr);
                        String datosCuenta;
                        
                        if (cuen == 1) {
                            datosCuenta = cuenta1.getDatosCuenta();
                        } else if (cuen == 2) {
                            datosCuenta = cuenta2.getDatosCuenta();
                        } else {
                            datosCuenta = "Cuenta no existente";
                        }
                        JOptionPane.showMessageDialog(null, datosCuenta);
                        break;
                    
                    case "2": 
                        String inputRetiroCuenta = "Seleccione cuenta para retirar:\n1 - Juan Perez\n2 - Diana Prince";
                        String retiroCuenStr = JOptionPane.showInputDialog(null, inputRetiroCuenta);
                        
                        if (retiroCuenStr == null) break; 
                        int retiroCuen = Integer.parseInt(retiroCuenStr);
                        
                        String montoStr = JOptionPane.showInputDialog(null, "Monto a retirar: ");
                        if (montoStr == null) break;
                        monto = Double.parseDouble(montoStr);
                        
                        if (retiroCuen == 1) {
                            Usuario.setRetiros(cuenta1, monto);
                            JOptionPane.showMessageDialog(null, "Retiro realizado. Nuevo estado:\n" + cuenta1.getDatosCuenta());
                        } else if (retiroCuen == 2) {
                            Usuario.setRetiros(cuenta2, monto);
                            JOptionPane.showMessageDialog(null, "Retiro realizado. Nuevo estado:\n" + cuenta2.getDatosCuenta());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cuenta seleccionada no existe");
                        }
                        break;
                    
                    case "3": 
                        String inputOrigen = "Seleccione cuenta ORIGEN:\n1 - Juan Perez\n2 - Diana Prince";
                        String origenStr = JOptionPane.showInputDialog(null, inputOrigen);

                        if (origenStr == null) break; 
                        int origen = Integer.parseInt(origenStr);

                        String inputDestino = "Seleccione cuenta DESTINO:\n1 - Juan Perez\n2 - Diana Prince";
                        String destinoStr = JOptionPane.showInputDialog(null, inputDestino);

                        if (destinoStr == null) break; 
                        int destino = Integer.parseInt(destinoStr);

                        if (origen == destino) {
                            JOptionPane.showMessageDialog(null, "No puede transferir a la misma cuenta");
                            break;
                        }

                        String montoStrT = JOptionPane.showInputDialog(null, "Monto a transferir: ");
                        if (montoStrT == null) break; 
                        monto = Double.parseDouble(montoStrT);

                        Usuario cuentaOrigen = (origen == 1) ? cuenta1 : cuenta2;
                        Usuario cuentaDestino = (destino == 1) ? cuenta1 : cuenta2;

                        if (origen < 1 || origen > 2 || destino < 1 || destino > 2) {
                            JOptionPane.showMessageDialog(null, "Cuenta seleccionada no existe");
                            break;
                        }

                        Usuario.setTransferencia(cuentaOrigen, cuentaDestino, monto);

                        String resultadoT = "Transferencia realizada.\n\n"
                                          + "Cuenta Origen:\n" + cuentaOrigen.getDatosCuenta() 
                                          + "\n\nCuenta Destino:\n" + cuentaDestino.getDatosCuenta();

                        JOptionPane.showMessageDialog(null, resultadoT);
                        break;
                    
                    case "4": 
                        String inputBloqueoCuenta = "Seleccione cuenta para Bloquear/Desbloquear:\n1 - Juan Perez\n2 - Diana Prince";
                        String bloqueoCuenStr = JOptionPane.showInputDialog(null, inputBloqueoCuenta);
                        
                        if (bloqueoCuenStr == null) break; 
                        int bloqueoCuen = Integer.parseInt(bloqueoCuenStr);
                        
                        Usuario cuentaModificar = null;
                        if (bloqueoCuen == 1) {
                            cuentaModificar = cuenta1;
                        } else if (bloqueoCuen == 2) {
                            cuentaModificar = cuenta2;
                        } else {
                            JOptionPane.showMessageDialog(null, "La cuenta seleccionada no existe");
                            break;
                        }
                        
                        boolean estadoActual = cuentaModificar.estaBloqueada();
                        boolean nuevoEstado = !estadoActual;
                        cuentaModificar.setEstaBloqueada(nuevoEstado);                         
                        String accion = nuevoEstado ? "BLOQUEADA" : "DESBLOQUEADA";
                        
                        JOptionPane.showMessageDialog(null, "Cuenta de " + cuentaModificar.getTitular() + " ha sido " + accion );
                        JOptionPane.showMessageDialog(null, cuentaModificar.getDatosCuenta());
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida. Intente de nuevo");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada invalida. Ingrese numeros validos");
            }
            
        } while (true); 
        JOptionPane.showMessageDialog(null, "Programa finalizado ¡Gracias!");
    }
}