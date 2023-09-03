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
    
}
