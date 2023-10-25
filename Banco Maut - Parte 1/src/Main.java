import java.util.Scanner;

public abstract class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        boolean continuar = true;

            while (continuar){
                System.out.println("Banco Maut");
                System.out.println("1 - Criar conta");
                System.out.println("2 - Acessar conta");
                System.out.println("0 - Sair");

                System.out.println("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Insira o seu nome: ");
                        String nomeCliente = scanner.nextLine();
                        System.out.println("Insira o seu Cpf: ");
                        String cpfCliente = scanner.nextLine();
                        System.out.println("Digite sua data de nascimento: ");
                        String dataNascimentoCliente = scanner.nextLine();
                        System.out.println("Insira o seu Endereço: ");
                        String enderecoCliente = scanner.nextLine();
                        System.out.println("Crie uma senha para acessar sua conta: ");
                        String senhaCliente = scanner.nextLine();

                        Cliente cliente = new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, enderecoCliente);
                        Conta conta = banco.criarConta(cliente, senhaCliente, enderecoCliente);
                        System.out.println("Conta criada com sucesso! Sua conta é : " + conta.getNumero());
                        break;
                    case 2:
                        System.out.println("Digite o número da sua conta: ");
                        String numeroConta = scanner.nextLine();
                        System.out.println("Digite sua senha: ");
                        String senha = scanner.nextLine();

                        Conta contaAcessada = banco.acessarConta(numeroConta, senha);
                        if (contaAcessada != null) {
                            boolean menuConta = true;
                            while(menuConta){
                                System.out.println("Olá, " + contaAcessada.getCliente().getNome() + "!");
                                System.out.println("Escolha uma opção:");
                                System.out.println("1 - Ver saldo:");
                                System.out.println("2 - Depositar");
                                System.out.println("3 - Sacar");
                                System.out.println("4 - Transferir:");
                                System.out.println("5 - Mostrar informações da conta");
                                System.out.println("0 -  Voltar");

                                int opcaoConta = scanner.nextInt();
                                scanner.nextLine();
                                

                                switch (opcaoConta) {
                                    case 1:
                                        System.out.println("Saldo : R$" + contaAcessada.getSaldo());
                                        break;
                                    case 2:
                                        System.out.println("Digite o valor do depósito: ");
                                        double valorDeposito = scanner.nextDouble();
                                        scanner.nextLine();
                                        contaAcessada.depositar(valorDeposito);
                                        System.out.println("Depósito realizado com sucesso!");
                                        break;
                                    case 3:
                                    System.out.println("Digite o valor do saque: ");
                                    double valorSaque = scanner.nextDouble();
                                    scanner.nextLine();
                                    if (contaAcessada.sacar(valorSaque)) {
                                        System.out.println("Saque realizado com sucesso!");
                                    } else {
                                        System.out.println("Saldo insuficiente para realizar o saque.");
                                    }
                                    break;
                                    case 4:
                                        System.out.println("Digite o número da conta de destino: ");
                                        String numeroContaDestino = scanner.nextLine();
                                        System.out.println("Digite o valor da transferência: ");
                                        double valorDaTransferencia = scanner.nextDouble();
                                        scanner.nextLine();
                                        Conta contaDestino = banco.getConta(numeroContaDestino);

                                        if (contaDestino != null) {
                                            if(contaAcessada.transferir(contaDestino, valorDaTransferencia)){
                                                System.out.println("Transferência realizada com sucesso!");
                                            }else{
                                                System.out.println("Saldo insuficiente para realizar a transferência.");
                                            }
                                            
                                        } else {
                                            System.out.println("Conta de destino não encontrada.");
                                        }
                                        break;
                                    case 5:
                                        contaAcessada.mostrarInformacoesConta();
                                        menuConta = false;
                                        break;
                                    case 0:
                                        menuConta = false;
                                        break;
                                    default:
                                        System.out.println("Opção Inválida. Por favor, escolha uma opção válida.");
                                        break;
                                }
                            }
                        } else{
                            System.out.println("Conta não encontrada ou senha incorreta.");
                        }
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("Obrigado por ser cliente do Banco Maut. Até breve!");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções citadas.");
                        break;
                }
            }

            scanner.close();
        }
    }