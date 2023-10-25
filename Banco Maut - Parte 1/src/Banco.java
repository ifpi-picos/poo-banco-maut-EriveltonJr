import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private int proximoNumeroConta;

    public Banco() {
        contas = new ArrayList<>();
        proximoNumeroConta = 1; 
    }

    public Conta criarContaPoupanca(String nomeCliente, String cpfCliente, String dataNascimentoCliente, Endereco endereco, String senha) {
        String numeroConta = gerarNumeroContaUnico();
        Cliente cliente = new Cliente(cpfCliente, dataNascimentoCliente, numeroConta, endereco);
        ContaPoupanca contaPoupanca = new ContaPoupanca(numeroConta, 1000.0, cliente, senha, endereco);
        contas.add(contaPoupanca);
        return contaPoupanca;
    }    

    public Conta criarContaCorrente(String nomeCliente, String cpfCliente, String dataNascimentoCliente, Endereco endereco, String senha) {
        String numeroConta = gerarNumeroContaUnico();
        Cliente cliente = new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, endereco);
        ContaCorrente contaCorrente = new ContaCorrente(numeroConta, proximoNumeroConta, cliente, proximoNumeroConta, senha, endereco);
        contas.add(contaCorrente);
        return contaCorrente;
    }

    public Conta acessarConta(String numeroConta, String senha) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta) && conta.getSenha().equals(senha)) {
                return conta;
            }
        }
        return null;
    }

    public Conta getConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    private String gerarNumeroContaUnico() {
        String numeroConta = String.format("%03d", proximoNumeroConta);
        proximoNumeroConta++;
        return numeroConta;
    }
}