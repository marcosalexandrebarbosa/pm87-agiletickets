package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA (0.05, 0.1, null) {
		@Override
		public BigDecimal calcula(Integer quantidade) {
			BigDecimal preco;
			
			return null;
		}
	}, SHOW (0.05, 0.1, null) {
		@Override
		public BigDecimal calcula(Integer quantidade) {
			// TODO Auto-generated method stub
			return null;
		}
	}, TEATRO (null, null, null) {
		@Override
		public BigDecimal calcula(Integer quantidade) {
			// TODO Auto-generated method stub
			return null;
		}
	}, BALLET (0.5, 0.2, 0.1) {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco;
			preco = verificaQuantidadeDeIngressoECalculaPreco(sessao);
			preco = verificaQuantidadeDeIngressoECalculaPreco(sessao, preco);
			return preco;
		}

		@Override
		public BigDecimal calcula(Integer quantidade) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}, ORQUESTRA (0.5, 0.2, 0.1) {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco;
			preco = verificaQuantidadeDeIngressoECalculaPreco(sessao);
			preco = verificaQuantidadeDeIngressoECalculaPreco(sessao, preco);
			return preco;
		}

		@Override
		public BigDecimal calcula(Integer quantidade) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	Double porcentagemLimite;
	Double taxaComum;
	Double taxaEspetaculoLongo;
	
	private TipoDeEspetaculo(Double porcentagemLimite, Double taxaComum, Double taxaEspetaculoLongo) {
		this.porcentagemLimite = porcentagemLimite;
		this.taxaComum = taxaComum;
		this.taxaEspetaculoLongo = taxaEspetaculoLongo;
	}

	public BigDecimal calcula(Sessao sessao) {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract BigDecimal calcula(Integer quantidade);
	
	public BigDecimal verificaQuantidadeDeIngressoECalculaPreco(Sessao sessao) {
		BigDecimal preco;
		if ((sessao.getTotalIngressos() - sessao.getIngressosReservados() / sessao.getTotalIngressos().doubleValue() <= porcentagemLimite)) {
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(taxaComum)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}
	
	public BigDecimal verificaQuantidadeDeIngressoECalculaPreco(Sessao sessao, BigDecimal precoAtual) {
		if(sessao.getDuracaoEmMinutos() > 60) {
			precoAtual = precoAtual.add(sessao.getPreco().multiply(BigDecimal.valueOf(taxaEspetaculoLongo)));
		}
		return precoAtual;
	}
	
}
