package Atividade4;

import java.util.ArrayList;

public class Conta {
    // atributos
    private String numeroConta;
    private Cliente cliente;
    private double saldo;
    private ArrayList<String> historico;

    // Construtores
    public Conta() {
        historico = new ArrayList<String>();
    }

    public Conta(Cliente cliente,String numeroConta) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = 0.0;
        historico = new ArrayList<String>();
    }

    public Conta(Cliente c, String numeroConta ,double saldo) {
        this.numeroConta = numeroConta;
        this.cliente = c;
        this.saldo = saldo;
        historico = new ArrayList<String>();
    }

    // métodos
    public String getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            historico.add("Depositou R$ " + valor);
        }
    }

    public boolean sacar(double valor) throws SaldoInsuficienteException {
        if (getSaldo() >= valor && valor > 0) {
            setSaldo(getSaldo() - valor);
            historico.add("Sacou R$ " + valor);
            return true;
        }else{
          throw new SaldoInsuficienteException(valor, numeroConta);
        }
    }

    public double consultarSaldo() {
        return getSaldo();
    }

    public void setCliente(Cliente c) {
        this.cliente = c;
    }

    public String mostrarHistorico() {
        String s = "";
        for (int i = 0; i < historico.size(); i++)
            s = s + historico.get(i) + "\n";
        return s;
    }

    @Override
    public String toString(){
        return "Número da conta: " + numeroConta + "\n" +
                "Saldo: " + saldo + "\n";
    }

    public void transferir(Conta c2, double d) throws SaldoInsuficienteException {
        if (sacar(d)) {
            c2.depositar(d);
            historico.add("Transferiu R$ " + d + " para a conta " + c2.getNumeroConta());
        }else{
          throw new SaldoInsuficienteException(d, numeroConta);
        }
    }
}