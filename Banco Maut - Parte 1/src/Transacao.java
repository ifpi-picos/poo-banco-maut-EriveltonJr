import java.util.Date;
public class Transacao {
    private Date data;
    private String descricao;
    private double valor;

    public Transacao(Date data, String descricao, double valor){
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Date getData(){
        return data;
    }

    public String getDescricao(){
        return descricao;
    }

    public double getValor(){
        return valor;
    }
}