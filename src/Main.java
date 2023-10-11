import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livros> listaLivros = new ArrayList<>();

        System.out.print("Bem vindo ao sistema de Sebo!");


        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livro / 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoLivro;
                    Livros novoLivro = new Livros();
                    Pessoa novoAutor = new Pessoa();

                    System.out.println("Digite o nome do autor: ");
                    novoLivro.nome = scanner.next();

                    System.out.println("Digite o valor: ");
                    novoLivro.preco = Float.parseFloat(scanner.next());

                    System.out.println("Digite a data de Nascimento (dd/MM/aaaa): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLivro.dataNascimento = date;


                    if (periodo.getYears() >5) {
                        System.out.println("A pessoa tem mais de 5 anos");
                    } else {
                        System.out.println("A pessoa tem menos de 5 anos. Retornando menu...");
                        break;
                    }

                    listaLivros.add(novoLivro);

                    System.out.println("Cadastro realizado com sucesso!");

                    break;
                case 2:
                    if (listaLivros.size() > 0) {
                        for (Livros cadaLivro : listaLivros) {
                            System.out.println();
                            System.out.println("Nome: " + cadaLivro.nome);
                            System.out.println("Preço: " + cadaLivro.preco);
                            System.out.println("Data de Nascimento: " + cadaLivro.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();
                        }
                        opcaoLivro = scanner.nextInt();

                    } else {
                        System.out.println("Lista vazia");
                    }

                    break;

            case 0:
                System.out.println("Voltando ao menu anterior");
                break;
            default:

                System.out.println("Opção inválida, por favor digite uma opção válida!");
                break;
        }

        } while (opcao != 0);
    }
}