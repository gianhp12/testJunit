package banco_de_dados;

import venda.Venda;

import java.util.ArrayList;
import java.util.List;

public class BancodeDados {
    public static List<Venda> vendas = new ArrayList<>();

    public static void addVenda(Venda venda) {
        vendas.add(venda);
    }
}
