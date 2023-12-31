import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    private Notificacao notificacao;
    private Endereco endereco; // conta não tem entedereço, quem tem endereço é cliente.
    private String senha;
    private String agencia;
    private String numero;
    double saldo; // deveria ser private
    private Cliente cliente;
    private List<Transacao> transacoes;

    public Conta(String agencia, String numero, double saldo, Cliente cliente, String senha,
            Endereco endereco) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
        this.senha = senha;
        this.endereco = endereco;
        this.notificacao = new Notificacao();
    }

    public void enviarNotificacaoPorEmail(String mensagem) {
        notificacao.enviarNotificacaoPorEmail(mensagem);
    }

    public void enviarNotificacaoPorSMS(String mensagem) {
        notificacao.enviarNotificacaoPorSMS(mensagem);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void mostrarInformacoesConta() {
        System.out.println("Informações da conta:");
        System.out.println("Agência: " + agencia);
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("Nome do cliente: " + cliente.getNome());
        System.out.println("CPF do cliente: " + cliente.getCpf());
        System.out.println("Endereço do cliente: " + endereco);
    }

    public String getSenha() {
        return senha;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            Transacao novaTransacao = new Transacao(new Date(), "Depósito", valor);
            transacoes.add(novaTransacao);
            System.out.println("Valor depositado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            Transacao novaTransacao = new Transacao(new Date(), "Saque", valor);
            transacoes.add(novaTransacao);
            System.out.println("Valor sacado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo Insuficiente.");
            return false;
        }
    }

    public boolean transferir(Conta alvo, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            alvo.depositar(valor);
            Transacao novaTransacao = new Transacao(new Date(),
                    "Transferência para conta " + alvo.getNumero(), valor);
            transacoes.add(novaTransacao);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else {
            System.out.println("Saldo Insuficiente.");
            return false;
        }
    }
}
