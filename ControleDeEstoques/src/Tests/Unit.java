package Tests;

import Entities.Produto;
import Entities.ProdutoComValidade;
import org.junit.Assert;
import org.junit.Test;

public class Unit {

    @Test
    public void UnitTest1()
    {
        var produto = new Produto("Maçã", 5.75, 10, "C:\temp");

        Assert.assertEquals(produto.getName(), "Maçã");
        Assert.assertEquals(produto.getPrice(), 5.75f, 1);
        Assert.assertEquals(produto.getQuant(), 10);
    }

    @Test
    public void UnitTest2()
    {
        var produto = new ProdutoComValidade("Maçã", 5.75, 10, "C:\temp", "01/01/2022");

        Assert.assertEquals(produto.getName(), "Maçã");
        Assert.assertEquals(produto.getPrice(), 5.75f, 1);
        Assert.assertEquals(produto.getQuant(), 10);
        Assert.assertEquals(produto.getDataValidade(), "01/01/2022");
    }

    @Test
    public void UnitTest3()
    {
        var produto = new Produto("Maçã", 5.75, 10, "C:\temp");

        var ultimoIdAntes = produto.getNextId();

        produto.SalvarNoCSV();

        Assert.assertNotSame(ultimoIdAntes, produto.getNextId());
        Assert.assertEquals(ultimoIdAntes, produto.getId());
    }
}
