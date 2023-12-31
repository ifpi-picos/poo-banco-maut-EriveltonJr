public class ContaCorrente extends Conta {

    // está faltando o atributo de limiteChequeEspecial
    public ContaCorrente(String numero, double saldo, Cliente cliente, double limiteChequeEspecial,
            String senha, Endereco endereco) {
        super(numero, numero, saldo, cliente, senha, endereco);
    }

    @Override
    public boolean transferir(Conta alvo, double valor) {
        double taxaTransferencia = calcularTaxaTransferencia(valor);
        if (saldo >= (valor + taxaTransferencia)) {
            saldo -= (valor + taxaTransferencia);
            alvo.depositar(valor);
            return true;
        } else {
            System.out.println("Saldo Insuficiente.");
            return false;
        }
    }

    private double calcularTaxaTransferencia(double valor) {
        return 0;
    }
}
