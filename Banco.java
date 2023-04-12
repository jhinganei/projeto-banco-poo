public class Banco {

    private Pessoa cliente;
    private String numeroconta;
    private double saldo;

    public Banco(Pessoa cliente, String numeroconta, double saldo) {
        this.cliente = cliente;
        this.numeroconta = numeroconta;
        this.saldo = saldo;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public String getNumeroconta() {
        return numeroconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}
