package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho car;

    @BeforeEach
	public void inicializa() {

		this.car = new Carrinho();

	}

    @DisplayName("Testa se o carrinho est� vazio")
	@Test
	public void testCarrinhoVazio() {

        Assertions.assertEquals(0, this.car.getQtdeItems());

	}

    @DisplayName("Testa a adi��o de um item")
	@Test
	public void testAdicaoItem() {

        Produto prod = new Produto("Produto Teste", 10);
        this.car.addItem(prod);
        Assertions.assertEquals(1, this.car.getQtdeItems());

	}

    @DisplayName("Testa a remo��o de um item")
	@Test
	public void testRemocaoItem() {

        Produto prod = new Produto("Produto Teste", 10);
        this.car.addItem(prod);
        
        try {

            this.car.removeItem(prod);

        } catch (ProdutoNaoEncontradoException e) {

            Assertions.fail(e.getMessage(), e);

        }

        Assertions.assertEquals(0, this.car.getQtdeItems());

	}

    @DisplayName("Testa o esvaziamento do carrinho")
	@Test
	public void testEsvaziarCarrinho() {

        final int QUANTIDADE_ITEMS = 10;

        for (int i = 0; i < QUANTIDADE_ITEMS; i++) {

            Produto prod = new Produto("Produto Teste " + i, 10);
            this.car.addItem(prod);

        }

        this.car.esvazia();
        Assertions.assertEquals(0, this.car.getQtdeItems());

    }

    @DisplayName("Testa a exce��o de produto n�o encontrado")
	@Test
    public void testProdutoNaoEncontrado() {
        
        Produto prod = new Produto("Produto Teste", 10);
        Assertions.assertThrows(ProdutoNaoEncontradoException.class, () -> this.car.removeItem(prod));

    }

    @DisplayName("Testa o valor total dos itens no carrinho")
	@Test
	public void testComparacao() {

        final double PRECO_PRODUTO_A = 24.90;
        final double PRECO_PRODUTO_B = 17.85;
        final double PRECO_PRODUTO_C = 42.50;

        Produto produtoA = new Produto("Produto A", PRECO_PRODUTO_A);
        Produto produtoB = new Produto("Produto B", PRECO_PRODUTO_B);
        Produto produtoC = new Produto("Produto C", PRECO_PRODUTO_C);

        this.car.addItem(produtoA);
        this.car.addItem(produtoB);
        this.car.addItem(produtoC);

        Assertions.assertEquals(PRECO_PRODUTO_A + PRECO_PRODUTO_B + PRECO_PRODUTO_C, this.car.getValorTotal());

	}
    
}
