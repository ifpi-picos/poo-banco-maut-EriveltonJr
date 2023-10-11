import java.util.ArrayList;
import java.util.List;

public class Cliente{
    String nome;
    String cpf;
    String dataNascimento;
    String endereço;
    List<Conta> contas;

    public Cliente(String nome, String cpf, String dataNascimento, String endereço){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereço = endereço;
        this.contas = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public String getEndereço(){
        return endereço;
    }

    public List<Conta> getContas(){
        return contas;
    }

    public void abrirConta(Conta conta){
        contas.add(0, conta);
    }
}