package Entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ProdutoComValidade extends Produto {
    private String dataValidade;

    public ProdutoComValidade(String name, double price, int quant, String filePath, String dataValidade) {
        super(name, price, quant, filePath);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public void SalvarNoCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(), true))) {
            writer.write(getId() + ";" + getName() + ";" + getPrice() + ";" + getQuant() + ";" + dataValidade);
            writer.newLine();
            System.out.println("Produto com validade salvo no arquivo CSV.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o produto com validade no arquivo CSV: " + e.getMessage());
        }
    }
}
