package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // define a classe como elemento raiz do XML
@XmlAccessorType(XmlAccessType.FIELD) // define o tipo de acesso por atributo
public class ListaItens {

	@XmlElement(name = "item") // define o nome de um elemento ou tag do XML
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	// JAX-B requer o uso de construtor sem argumentos
	ListaItens() {
	}

	public List<Item> getItens() {
		return itens;
	}

}
