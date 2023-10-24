import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Conta {
    private String agencia;
    private String numero;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacao;

    public Conta(String agencia, String numero, double saldo, Cliente cliente){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacao = new ArrayList<>();
    }

    public String getAgencia(){
        return agencia;
    }

    public String getNumero(){
        return numero;
    }

    public Double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public List<Transacao> getTransacao(){
        return transacao;
    }

    public void depositar(double valor){
        if(valor > 0 && saldo >= valor){
        saldo += valor;
        Transacao novaTransacao = new Transacao(new Date(), "Depósito", valor);
        transacao.add(novaTransacao);
        System.out.println(("Valor depositado com sucesso."));
        }else{
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && saldo >= valor){
            saldo -= valor;
            Transacao novaTransacao = new Transacao(new Date(), "Saque", valor);
            transacao.add(novaTransacao);
            System.out.println("Valor sacado com sucesso.");
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void transferir(Conta alvo, double valor){
        if(valor > 0 && saldo >= valor){
            saldo -= valor;
            alvo.depositar(valor);
            Transacao novaTransacao = new Transacao(new Date(), "Transferência para conta " + alvo.getNumero(), valor);
            transacao.add(novaTransacao);
            System.out.println("Tranferência realizada com sucesso.");
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }
        
    public void mostrarExtrato(){
        System.out.println("Extrato da conta " + numero);
        for (Transacao transacao : transacao){
            System.out.println(transacao.getData() + " - " + transacao.getDescricao() + ": " + transacao.getValor());
        }
    }
}