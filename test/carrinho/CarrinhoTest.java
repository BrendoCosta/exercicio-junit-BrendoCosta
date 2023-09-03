package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    private Carrinho car;

    @BeforeEach
	public void inicializa() {

		this.car = new Carrinho();

	}

    @DisplayName("Testa se o carrinho está vazio")
	@Test
	public void testCarrinhoVazio() {

        Assertions.assertEquals(0, this.car.getQtdeItems());

	}
    
}
