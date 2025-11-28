package ejercicio2;
import java.util.Random;
import javax.swing.JOptionPane;
public class Usuario {
    private String titular;
    private long numero_cuenta;
    private double saldo;
    private boolean estaBloqueada;

    public Usuario(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        Random aleatorio = new Random();
        numero_cuenta = Math.abs(aleatorio.nextLong());
        this.estaBloqueada = false;
    }

    public String getTitular() {
        return titular;
    }

    public boolean estaBloqueada() {
        return estaBloqueada;
    }

    public void setEstaBloqueada(boolean estado) {
        this.estaBloqueada = estado;
    }

    public static void setRetiros(Usuario cliente, double cantidad) {
        if (cliente.estaBloqueada()) {
            JOptionPane.showMessageDialog(null, "Operacion denegada: La cuenta esta bloqueada");
            return;
        }

        if (cliente.saldo >= cantidad && cantidad > 0) {
            cliente.saldo -= cantidad;
        } else if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "El monto a retirar debe ser positivo.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente. Saldo actual: $" + cliente.saldo);
        }
    }

    public static void setTransferencia(Usuario titu1, Usuario titu2, double cantidad) {
        if (titu1.estaBloqueada()) {
            JOptionPane.showMessageDialog(null, "Operación denegada: La cuenta origen está bloqueada.");
            return;
        }

        if (titu1.saldo >= cantidad && cantidad > 0) {
            titu1.saldo -= cantidad;
            titu2.saldo += cantidad;
        } else if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "El monto a transferir debe ser positivo.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para transferir.");
        }
    }

    public String getDatosCuenta() {
        String estado;
        // Se usa la sintaxis simple ternaria (?), que es la que tenías y es concisa.
        estado = this.estaBloqueada() ? "BLOQUEADA" : "ACTIVA";
        
        return "Titular: " + titular 
             + "\nNumero de cuenta: " + numero_cuenta 
             + "\nSaldo: $" + saldo
             + "\nEstado: " + estado;
    }
}