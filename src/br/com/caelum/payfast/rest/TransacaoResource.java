package br.com.caelum.payfast.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.caelum.payfast.modelo.Transacao;

@Path("/transacoes")
@Singleton
public class TransacaoResource {
	
	private Map<String, Transacao> repositorio = new HashMap<>();
	
	public TransacaoResource() {
		Transacao transacao = new Transacao();
		transacao.setData("DATA");
		transacao.setNumero("0001");
		transacao.setTitular("Cesar");
		transacao.setValor(new BigDecimal("59.9"));
		repositorio.put(transacao.getNumero(), transacao);
	}
	
	@GET
	@Path("/{numero}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Transacao buscaTransacao(@PathParam("numero") String numero){
		return repositorio.get(numero);
	}
	
}
