import banco_de_dados.BancodeDados;
import compra.Compra;
import compra.Item;
import modelos.RegistradoraModelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class RegistradoraTeste {

    @Test
    public void deveRegistrarAVendaNoBancoDeDados(){
        // Arrange -> Entrada
        var pastelDeCarne = Item.builder().nome("Pastel de Carne").valor(new BigDecimal("7.00")).build();
        var pastelDeFlango = Item.builder().nome("Pastel de Flango").valor(new BigDecimal("6.50")).build();

        List<Item> listaDeItens = Arrays.asList(pastelDeCarne,pastelDeFlango);

        var compra = Compra.builder().itens(listaDeItens).build();

        var registradora = RegistradoraModelo.construirCenario().compra(compra).valorRecebido(new BigDecimal("13.50")).build();
        // Act -> -> Ação

        registradora.efetivarVenda();
        //Assert -> Resultado

        Assertions.assertEquals(1, BancodeDados.vendas.size());
        Assertions.assertEquals(new BigDecimal("13.50"), BancodeDados.vendas.get(0).getTotalCompra());

    }
}
