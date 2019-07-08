package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

@WebService
public class EstoqueWS {
	
	private ItemDao dao = new ItemDao();
	private static int contador = 0;
	
	
	@WebMethod(operationName = "todosOsItens") // define um novo para o metodo
	@WebResult(name = "itens")	// renderiza nome para retorno do metodo
	public ListaItens getItens(){
		contador++;
		System.out.println("Chamando getItens" + contador);
		
		List<Item> lista = dao.todosItens();
		return new ListaItens(lista);
	}
}
