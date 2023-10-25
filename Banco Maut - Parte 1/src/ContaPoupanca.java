public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, double saldo, Cliente cliente, String senha, String endereco) {
        super(numero,numero, saldo, cliente, senha, endereco);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo Insuficiente.");
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Valor depositado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
}
