public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numero, double saldo, Cliente cliente, String senha,
            Endereco endereco) {
        super(numero, numero, saldo, cliente, senha, endereco);
    }

    @Override
    public boolean sacar(double valor) {
        // o saque deve cobrar uma taxa de 5%
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
        // o depósito deveria render 10%
        if (valor > 0) {
            saldo += valor;
            System.out.println("Valor depositado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
}
