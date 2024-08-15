package org.example.factory;

public class ProdutoFactory {

    public static Produto getInstance(TipoProdutoEnum tipoProdutoEnum){

        switch (tipoProdutoEnum){
            case FISICO:
                ProdutoFisico produtoFisico = new ProdutoFisico();
                produtoFisico.setPossuiDimensoes(true);
                return produtoFisico;
            case DIGITAL:
                ProdutoDigital produtoDigital = new ProdutoDigital();
                produtoDigital.setPossuiDimensoes(false);
                return produtoDigital;
            default:
                throw new IllegalArgumentException("Tipo de Produto Não disponivel");
        }

    }
}
