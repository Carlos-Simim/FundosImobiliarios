
public class FundoImobiliario {

	private String Ticker;
	private String Descricao;
	private int Setor;
	private int controle;
	private int controle2;
	private Rendimento rendimentos;
	private Negociacao negociacoes;
	Setor setorId;
	
	FundoImobiliario(String ticker, String descricao, int setor, String data, double valor, int i){
		Rendimento descartavel = new Rendimento();
		this.rendimentos = descartavel;
		Negociacao descartavel2 = new Negociacao();
		this.negociacoes = descartavel2;
		Setor descartavel3 = new Setor();
		this.setorId = descartavel3;
		
		Setor setorId = new Setor(i);
		this.setorId.Setor = setorId.Setor;
		
		
		this.controle = 1;
		this.Ticker = ticker;
		this.Descricao = descricao;
		this.Setor = setor;	
		this.rendimentos.DataPagamento[0] = data;
		this.rendimentos.ValorPago[0] = valor;
		
		
	}
	
	void setRendimento(String data, double valor) {
		this.rendimentos.DataPagamento[this.controle] = data;
		this.rendimentos.ValorPago[this.controle] = valor;
		this.controle = this.controle + 1;
		
	}
	
	void getRendimento() {
		System.out.println("\nInformacoes de " + this.Ticker + ":");

		System.out.println("Descricao: " + this.Descricao);
		
		switch (this.Setor) {
		case 1:
			System.out.println("Setor: Condominio");
			break;
			
		case 2:
			System.out.println("Setor: Imovel para locacao");
			break;
			
		case 3:
			System.out.println("Setor: Praca de alimentacao");
			break;

		default:
			System.out.println("Setor: Outros");
			break;
		}
		
		System.out.println("Rendimentos e datas de pagamento: ");
		
		for (int i = 0; i < 121; i++) {
			
			if(this.rendimentos.DataPagamento[i] != null) {
				System.out.println("R$" + this.rendimentos.ValorPago[i] + " em " + this.rendimentos.DataPagamento[i]);
				
			}	
		}
		
		
		
		
		
		
	}
	
	double getRendimentoAno(int ano) {
		double total = 0;
		
		for(int i=0;i<this.rendimentos.DataPagamento.length;i++) {
			
			if(this.rendimentos.DataPagamento[i] == null) {
				
				return total;
			}

			if (ano == Integer.parseInt(this.rendimentos.DataPagamento[i].substring(6))) {
				total = total + this.rendimentos.ValorPago[i];
	
			}
		}
		
		
		return total;
	}
	
	double getRendimentoMesAno(int mes,int ano) {
		double total = 0;
		
		for(int i=0;i<this.rendimentos.DataPagamento.length;i++) {
			
			if(this.rendimentos.DataPagamento[i] == null) {
				
				return total;
			}
			
			if (ano == Integer.parseInt(this.rendimentos.DataPagamento[i].substring(6))) {
				if (mes == Integer.parseInt(this.rendimentos.DataPagamento[i].substring(3,5))) {
					total = total + this.rendimentos.ValorPago[i];
				}
	
			}
		}
		
		return total;
	}

	
	double getRendimentoPeriodo(int inicio, int fim){
		double total = 0;
		int mesInicio = inicio / 10000;
		int anoInicio = inicio % 10000;
		int mesFim = fim / 10000;
		int anoFim = fim % 10000;
		
		for(int i=0;i<this.rendimentos.DataPagamento.length;i++) {
			if(this.rendimentos.DataPagamento[i] == null) {
				return total;
			}
			
			if(Integer.parseInt(this.rendimentos.DataPagamento[i].substring(6))>=anoInicio) {
				if(Integer.parseInt(this.rendimentos.DataPagamento[i].substring(6))<=anoFim) {
					if(Integer.parseInt(this.rendimentos.DataPagamento[i].substring(3,5))>=mesInicio) {
						if(Integer.parseInt(this.rendimentos.DataPagamento[i].substring(3,5))<=mesFim) {
							total = total + this.rendimentos.ValorPago[i];
						}
					}
				}
			}
		}
		
		
		
		
		return total;
	}


	void setNegociacao(String data, int quantidade, double valor, int tipo) {
			
			this.negociacoes.dataNegociacao[this.controle2] = data;
			this.negociacoes.FII[this.controle2] = this.Ticker;
			this.negociacoes.quantidade[this.controle2] = quantidade;
			this.negociacoes.tipo[this.controle2] = tipo;
			this.negociacoes.valorCota[this.controle2] = valor;
		
			this.controle2 = this.controle2 + 1;
	}
	
	double getTotalNegociacoes(int retorno) {
		double totalCompra = 0;
		double totalVenda = 0;
		
		for(int i = 0;i<=this.controle2;i++) {
			if(this.negociacoes.tipo[i] == 1) {
				totalCompra = totalCompra + this.negociacoes.valorCota[i] * this.negociacoes.quantidade[i];
			}
			if(this.negociacoes.tipo[i] == 2) {
				totalVenda = totalVenda + this.negociacoes.valorCota[i] * this.negociacoes.quantidade[i];
			}
		
		
		}
		if(retorno == 1) {
			return totalCompra;
		}
		if(retorno == 2) {
			return totalVenda;
		}
		
		
		return 0;
	}
	
	
}