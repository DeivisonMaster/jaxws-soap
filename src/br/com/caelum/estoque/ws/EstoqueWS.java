package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.modelo.usuario.Usuario;

@WebService
public class EstoqueWS {
	
	private ItemDao dao = new ItemDao();
	private static int contador = 0;
	
	
	@WebMethod(operationName = "TodosOsItens") // define um novo para o metodo
	@WebResult(name = "itens")	// renderiza nome para retorno do metodo
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros){
		contador++;
		System.out.println("Chamando getItens" + contador);
		
		List<Filtro> listaFiltros = filtros.getLista();
		List<Item> lista = dao.todosItens(listaFiltros);
		
		return new ListaItens(lista);
	}
	
	
	@WebMethod(operationName = "CadastrarItem")
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) 
			TokenUsuario tokenUsuario, @WebParam(name = "item") Item item) 
					throws AutorizacaoException {
		
		System.out.println("Cadastrando item " + item + ", " + "Token " + tokenUsuario);
		
		boolean isValido = new TokenDao().ehValido(tokenUsuario);
		
		if(!isValido) {
			throw new AutorizacaoException("Autorizacao falhou");
		}
		
		new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);
		
		return item;
	}
}











