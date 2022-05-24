
public class Teste {

	public static void main(String[] args) {
		
		int i = 1;
		//Inicia 2 FIIs com: Ticker, Descrição, setor (int), data e valor
		FundoImobiliario f1 = new FundoImobiliario("KNRI11","Kinea Renda Imobiliaria",3, "01/01/2021",0.77, i);
		i++;
		FundoImobiliario f2 = new FundoImobiliario("MNCMV1","Minha casa minha vida",1, "01/01/2021",0.69, i);
		i++;
		//Setor armazenado como uma definição em N° inteiro.
		
		//seta rendimentos nos 2 objetos na próxima posição do vetor
		f1.setRendimento("01/02/2022",0.89);
		f2.setRendimento("01/02/2022",0.56);
		f1.setRendimento("01/03/2022",0.49);
		f2.setRendimento("01/03/2022",0.32);
		
		
		//printa todos os rendimentos dos FIIs | print feito dentro do método por ter vários retornos e 
		//por acessar atributos privados.
		f1.getRendimento();
		f2.getRendimento();
		
		//Printa o total dos rendimentos distribuídos por um FII em um determinado ANO.
		System.out.println("\nRendimentos distribuidos por KNRI11 em 2021: R$" + f1.getRendimentoAno(2021));
		System.out.println("Rendimentos distribuidos por KNRI11 em 2022: R$" + f1.getRendimentoAno(2022));
		System.out.println("Rendimentos distribuidos por MNCMV1 em 2021: R$" + f2.getRendimentoAno(2021));
		System.out.println("Rendimentos distribuidos por MNCMV1 em 2022: R$" + f2.getRendimentoAno(2022));
		
		//Printa o total dos rendimentos distribuídos por um FII em um determinado MÊS/ANO.
		System.out.println("\nRendimentos distribuidos por KNRI11 em Janeiro de 2021: R$" + f1.getRendimentoMesAno(01,2021));
		System.out.println("Rendimentos distribuidos por KNRI11 em Fevereiro de 2021: R$" + f1.getRendimentoMesAno(02,2021));
		System.out.println("Rendimentos distribuidos por KNRI11 em Fevereiro de 2022: R$" + f1.getRendimentoMesAno(02,2022));
		System.out.println("Rendimentos distribuidos por MNCMV1 em Fevereiro de 2022: R$" + f2.getRendimentoMesAno(02,2022));
		
		//Printa o total dos rendimentos distribuídos por um FII em um determinado PERÍODO.
		//Formato dos argumentos passados é mêsano; ou seja: julho de 2022 seria 72022
		System.out.println("\nRendimentos distribuidos por KNRI11 de 01/2021 ate 02/2022: R$" + f1.getRendimentoPeriodo(12021,22022));
		System.out.println("Rendimentos distribuidos por MNCMV1 de 02/2022 ate 03/2022: R$" + f2.getRendimentoPeriodo(22022,32022));
		
		//Método para calcular o valor total de um determinado negócio de compra ou venda de FII.
		//Data, quantidade, valor, tipo		
		f1.setNegociacao("01/05/2021", 4, 266, 1);
		f1.setNegociacao("01/06/2021", 7, 40, 2);
		f1.setNegociacao("01/09/2021", 2, 31, 1);
		f2.setNegociacao("01/05/2021", 4, 266, 1);
		f2.setNegociacao("01/06/2021", 7, 40, 2);
		f2.setNegociacao("01/09/2021", 2, 31, 1);  //Setei os valores iguais só pra testar com + de 1 objeto
		System.out.println("\nValor total das compras de KNRI11: R$"+ f1.getTotalNegociacoes(1));
		System.out.println("Valor total das vendas de KNRI11: R$"+ f1.getTotalNegociacoes(2));
		System.out.println("\nValor total das compras de MNCMV1: R$"+ f2.getTotalNegociacoes(1));
		System.out.println("Valor total das vendas de MNCMV1: R$"+ f2.getTotalNegociacoes(2)); //parametro 1 para Compra, 2 para venda.
		
		//Classe carteira e suas operações
		Carteira c1 = new Carteira("Carlos", "23/05/2022", "Carteira Banco do Brasil", "Banco do Brasil");
		c1.setNegociacao(5, 157, 1);
		c1.setNegociacao(3, 191, 1);		
		c1.setNegociacao(7, 200, 2);
		c1.setNegociacao(7, 256, 2);
		System.out.println("\nTotal de compras de c1: " + c1.getTotalNegociacoes(1));
		System.out.println("Total de vendas de c1: " + c1.getTotalNegociacoes(2));
		
		System.out.println("\nResultado liquido da carteira c1: R$" + (c1.getTotalNegociacoes(2) - c1.getTotalNegociacoes(1)));
		if((c1.getTotalNegociacoes(2) - c1.getTotalNegociacoes(1))<0) {
			System.out.println("A carteira c1 teve prejuizo.");
		}
		if((c1.getTotalNegociacoes(2) - c1.getTotalNegociacoes(1))>0) {
			System.out.println("A carteira c1 teve lucro.");
		}
		if((c1.getTotalNegociacoes(2) - c1.getTotalNegociacoes(1))==0) {
			System.out.println("A carteira c1 nao teve lucro nem prejuizo.");
		}
		
		//Classe setor com UID com "S" + se auto-incrementa por 1 número.
		//Eu não fiz uma classe setor separada antes porque não vi sentido, já que os setores de um investimento não variam.
		//Vou fazer uma a parte pra não atrapalhar o funcionamento do programa e implementar o Id.
		System.out.println("\nSetor em formato de ID de f1: " + f1.setorId.Setor);
		System.out.println("Setor em formato de ID de f2: " + f2.setorId.Setor);
		


	}


	
}
