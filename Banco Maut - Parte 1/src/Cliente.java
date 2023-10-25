import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nome;
    String cpf;
    String dataNascimento;
    private Endereco endereco;
    List<Conta> contas;

    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void abrirConta(Conta conta) {
        contas.add(0, conta);
    }
}
