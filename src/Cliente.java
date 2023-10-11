public class Cliente {
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
        this.contas = newArrayList<>();
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

    public List<Conta> getContas(){
        return contas;
    }

    public void abrirConta(Conta conta){
        contas.add(conta);
    }
}