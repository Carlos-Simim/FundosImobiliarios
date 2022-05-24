
public class Carteira {

	private String Proprietario;
	private String DataCriacao;
	private String Descricao;
	private String Corretora;
	private Negociacao negociacoes;
	private int controle;
	
	Carteira (String proprietario, String data, String descricao, String corretora){
		this.Proprietario = proprietario;
		this.DataCriacao = data;
		this.Descricao = descricao;
		this.Corretora = corretora;
		Negociacao descartavel = new Negociacao();
		this.negociacoes = descartavel;
		
	}
	
	void setNegociacao(int quantidade, double valor, int tipo) {
		
		this.negociacoes.quantidade[this.controle] = quantidade;
		this.negociacoes.tipo[this.controle] = tipo;
		this.negociacoes.valorCota[this.controle] = valor;
	
		this.controle = this.controle + 1;
}
	
	double getTotalNegociacoes(int retorno) {
		double totalCompra = 0;
		double totalVenda = 0;
		
		for(int i = 0;i<=this.controle;i++) {
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
