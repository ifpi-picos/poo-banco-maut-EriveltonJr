// aqui deveria ser uma interface com um único método "enviaNotificacao"
public class Notificacao {
    public void enviarNotificacaoPorEmail(String mensagem) {
        System.out.println("Notificação por email enviada: " + mensagem);
    }

    public void enviarNotificacaoPorSMS(String mensagem) {
        System.out.println("Notificação por SMS enviada: " + mensagem);
    }
}
