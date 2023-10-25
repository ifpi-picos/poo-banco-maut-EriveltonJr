import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private int proximoNumeroConta;

    public Banco() {
        contas = new ArrayList<>();
        proximoNumeroConta = 1; 
    }

    public Conta criarConta(Cliente cliente, String senha, Endereco enderecoCliente) {
        String numeroConta = gerarNumeroContaUnico();
        Conta conta = new Conta(numeroConta, senha, 1000.0, cliente, senha, enderecoCliente);
        contas.add(conta);
        return conta;
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