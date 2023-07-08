import Entities.Produto;
import Entities.ProdutoComValidade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produto produto;
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema da frutífera.\n\n\n\n");
        System.out.println("Informe o caminho da pasta do arquivo de estoques. Caso exista, informe sua pasta: ");
        String filePath = sc.nextLine();
        System.out.println("Você deseja adicionar algum produto?" +
                "\n1 - Sim" +
                "\n2 - Não");
        int optStartProgram = sc.nextInt();
        
        while (true) {
            if (optStartProgram == 1) {

                for (int i = 0; i < 25; i++) {
                    System.out.println("\n");
                }


                System.out.println("Deseja criar um produto comum ou alimentício?" +
                        "\n1 - Comum" +
                        "\n2 - Alimentício");
                int optCreateObj = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o nome do produto: ");

                String objectName = sc.nextLine();

                System.out.println("Digite o valor do produto: ");
                double objectValue = sc.nextDouble();

                System.out.println("Digite a quantidade de produtos a serem adicionadas: ");
                int objectQuantity = sc.nextInt();


                if (optCreateObj == 2) {
                    System.out.println("Digite a data de validade: ");
                    String expirationDate = sc.nextLine();
                    produto = new ProdutoComValidade(objectName, objectValue, objectQuantity, filePath ,expirationDate);
                } else {
                    produto = new Produto(objectName, objectValue, objectQuantity, filePath);
                }

                produto.LerUltimoId();
                produto.SalvarNoCSV();

                System.out.println("Deseja continuar?" +
                        "\n1 - Sim" +
                        "\n2 - Não");
                int optBreak = sc.nextInt();
                if (optBreak != 1){break;}
            }
        }
        System.out.println("Agradecemos a confiança ☻");
    }
}



