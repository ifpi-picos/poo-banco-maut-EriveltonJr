import java.util.ArrayList;
import java.util.List;
public class Conta {

    private boolean saldoInsuficiente(double valor){
        return saldo >= valor;
    }

    private String agencia;
    private String numero;
    private double saldo;
    private Cliente cliente;
    private List<String> transacao;

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

    public List<String> getTransacao(){
        return transacao;
    }

    public void depositar(double valor){
        saldo += valor;
        transacao.add("Depósito: +" + valor);
    }

    public void sacar(double valor){
        if(saldoInsuficiente(valor)){
            saldo -= valor;
            transacao.add("Saque: -" + valor);
        }else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void tranferir(Conta alvo, double valor){
        if(saldoInsuficiente(valor)){
            saldo -= valor;
            alvo.depositar(valor);
            transacao.add("Tranferir para conta :"+ alvo.getNumero() + valor);
        }else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    public void mostrarExtrato(){
        System.out.println("Extrato da conta " + numero);
        for (String transacao : transacao){
            System.out.println(transacao);
        }
    }
}