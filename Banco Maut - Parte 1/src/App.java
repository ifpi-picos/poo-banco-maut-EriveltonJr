import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("Erivelton", "123456789", "05/04/2004", "Rua B, 123");
        Conta conta = new Conta("001", "123456", 2000.1, cliente);
        boolean continuar = true;

        while (continuar){
            System.out.println("/nMenu:");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Exibir Extrato");
            System.out.println("0 - Sair");

            System.out.println("Escolha uma opcção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor que será depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito feito com sucesso.");
                    break;
                default:
                    break;
            }
        }
    }
}
