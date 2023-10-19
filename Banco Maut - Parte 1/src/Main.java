import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Cliente cliente = new Cliente("Erivelton", "123456789", "05/04/2004", "Rua B, 123");
            Conta conta = new Conta("001", "123456", 2000.1, cliente);
            boolean continuar = true;

            while (continuar){
                System.out.println("Menu:");
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
                    case 3:
                        System.out.println("Digite o valor que será sacado: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso.");
                        break;
                    case 4:
                        System.out.println("Digite o número da conta alvo: ");
                        String numeroAlvo = scanner.next();
                        System.out.println("Digite o valor que será transferido: ");
                        double valorDaTransferencia = scanner.nextDouble();
                        Conta contaAlvo = null;

                        for(Conta c: cliente.getContas()){
                            if(c.getNumero().equals(numeroAlvo)){
                                contaAlvo = c;
                                break;
                            }
                        }
                        if (contaAlvo != null) {
                            conta.transferir(contaAlvo, valorDaTransferencia);
                            System.out.println("Tranferência realizada com sucesso.");
                        }else {
                            System.out.println("Conta alvo não encontrada.");
                        }
                        break;

                        case 5:
                            conta.mostrarExtrato();
                            break;
                        case 0:
                            continuar = false;
                            System.out.println("Encerrando Programa.");
                            break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções citadas.");
                        break;
                }
            }
        }
    }
}