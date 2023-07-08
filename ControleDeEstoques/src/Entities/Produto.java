package Entities;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Produto {
    private static int lastId = 0;
    private int id;
    private String name;
    private double price;
    private int quant;
    private String FilePath;
    private static File StorageFile;

    public Produto(String name, double price, int quant, String filePath) {
        this.id = getNextId();
        this.name = name;
        this.price = price;
        this.quant = quant;
        this.FilePath = filePath;
        StorageFile = new File(FilePath + "\\Estoque.csv");
    }

    public int getNextId() {
        return ++lastId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuant() {
        return quant;
    }

    public String getFilePath() { return FilePath; }

    public void SalvarNoCSV() {
        String caminhoArquivo = getFilePath() + "\\Estoque.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            File arquivo = new File(caminhoArquivo);

            if (!arquivo.exists()) {
                writer.write("Id;Nome;Preco;Quantidade;Data de Validade");
            }

            writer.write(id + ";" + name + ";" + price + ";" + quant);
            writer.newLine();

            System.out.println("Produto salvo no arquivo CSV.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o produto no arquivo CSV: " + e.getMessage());
        }

    }

    public void LerUltimoId() {
        String caminhoArquivo = getFilePath() + "\\Estoque.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                int id = (fields[0].isEmpty() ? 0 : Integer.parseInt(fields[0]));
                lastId = Math.max(lastId, id);
            }
            System.out.println("Último ID lido do arquivo CSV: " + lastId);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    public static Boolean arquivoExiste(){
        return  StorageFile.exists();
    }
}