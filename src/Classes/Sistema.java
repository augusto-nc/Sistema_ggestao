package Classes;
import java.util.Scanner;

public class Sistema {

	private static Scanner scan= new Scanner (System.in);
	
	private static Projetos cadastroProjetos[] = new Projetos[50];
	private static Colaboradores cadastroColaboradores[] = new Colaboradores[50];
	private static Publicacao cadastroPublicacao[] = new Publicacao[50];
	private static Professor cadastroProfessores[] = new Professor[25];
	private static int numeroProjetos = 0;
	private static int numeroColaboradores = 0;
	private static int numeroPublicacao = 0;
	private static int numeroProfessores = 0;
	
	
	static Publicacao CadastrarPublicacao(){
		cadastroPublicacao[numeroPublicacao] =  new Publicacao();
		cadastroPublicacao[numeroPublicacao].id = numeroPublicacao;
		
		System.out.println("------- DADOS DA PUBLICAÇÃO -------");
		System.out.print("TÍTULO: ");
		scan.next();
		cadastroPublicacao[numeroPublicacao].titulo = scan.nextLine();
		
		System.out.print("NOME DA CONFERÊNCIA: ");
		scan.next();
		cadastroPublicacao[numeroPublicacao].nomeDaConferencia = scan.nextLine();
		
		System.out.print("ANO DA PUBLICAÇÃO: ");
		cadastroPublicacao[numeroPublicacao].anoPulbicacao = new Data();
		cadastroPublicacao[numeroPublicacao++].anoPulbicacao.ano = scan.nextInt();
		
		int aux = numeroPublicacao -1;
		
		return cadastroPublicacao[aux];
	}
	
	static Professor CadastraProfessor(){
		cadastroProfessores[numeroProfessores] = new Professor();
		cadastroProfessores[numeroProfessores].id = numeroProfessores;
		
		System.out.println("------- DADOS DO PROFESSOR -------\n");
		System.out.print("NOME: ");
		scan.next();
		
		cadastroProfessores[numeroProfessores++].nomeProf = scan.nextLine();
		
		int aux = numeroProfessores - 1;
		
		return cadastroProfessores[aux];
	}
	
	static Colaboradores CadastraColaborador(){
		cadastroColaboradores[numeroColaboradores] = new Colaboradores();
		cadastroColaboradores[numeroColaboradores].id = numeroColaboradores;
		
		System.out.println("------- DADOS DO COLABORADOR -------");
		System.out.print("NOME: ");
		scan.next();
		cadastroColaboradores[numeroColaboradores].nomeColaborador = scan.nextLine();
		
		System.out.print("EMAIL: ");
		scan.next();
		cadastroColaboradores[numeroColaboradores].email = scan.nextLine();
		
		System.out.print("NÍVEL DE COLABORAÇÃO:\n" +
				"1- Aluno de Graduação\n" +
				"2- Aluno de Mestrado\n" +
				"3- Aluno de Doutorado\n" +
				"4- Pesquisador");
		int aux = scan.nextInt();
		cadastroColaboradores[numeroColaboradores++].indexTipo = aux -1;
		
		aux = numeroColaboradores - 1;
		
		return cadastroColaboradores[aux]; 
	}
	
	static void cadastraProjetos(){
		cadastroProjetos[numeroProjetos] = new Projetos();
		cadastroProjetos[numeroProjetos].id = numeroProjetos;
		
		System.out.print("TÍTULO: ");
		scan.nextLine();
		cadastroProjetos[numeroProjetos].titulo = scan.nextLine();
		
		int i = 0;
		do{
			cadastroProjetos[numeroProjetos].orientadores[cadastroProjetos[numeroProjetos].qtdOrientadores] = new Professor();
			cadastroProjetos[numeroProjetos].orientadores[cadastroProjetos[numeroProjetos].qtdOrientadores++] = CadastraProfessor();
			i++;
			if(i!=4){
				int opcao = 0;
				do{
					System.out.print("DESEJA CADASTRAR OUTRO PROFESSOR?\n" +
							"1- sim\n" +
							"2- não\n" +
							"Opção desejada: ");
					opcao = scan.nextInt();
					
					if(opcao == 2) i=5;
				
				}while (opcao<1 || opcao>2);
			}
		}while(i<5);
		
		cadastroProjetos[numeroProjetos].dataInicio = new Data();
		System.out.print("DATA INÍCIO (mm.aaaa): ");
		double temp = scan.nextDouble();
		cadastroProjetos[numeroProjetos].dataInicio.indexMes = (int) temp;
		int temp1 = (int) ((temp - (int)temp)*10000);
		cadastroProjetos[numeroProjetos].dataInicio.ano = temp1;
		
		cadastroProjetos[numeroProjetos].dataTermino = new Data();
		System.out.print("DATA TERMINO (mm.aaaa): ");
		temp = scan.nextDouble();
		cadastroProjetos[numeroProjetos].dataInicio.indexMes = (int) temp;
		temp1 = (int) ((temp - (int)temp)*10000);
		cadastroProjetos[numeroProjetos].dataInicio.ano = temp1;
		
		System.out.print("AGÊNCIA FINANCIADORA: ");
		scan.next();
		cadastroProjetos[numeroProjetos].agenciaFinanciadora = scan.nextLine();
		
		System.out.print("VALOR FINANCIADO: ");
		cadastroProjetos[numeroProjetos].valorFinanciado = scan.nextDouble();
		
		System.out.print("OJETIVO DO PROJETO: ");
		scan.next();
		cadastroProjetos[numeroProjetos].objetivo = scan.nextLine();
		
		System.out.print("DESCRIÇÃO DO PROJETO: ");
		scan.next();
		cadastroProjetos[numeroProjetos].descrição = scan.nextLine();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("------- CADASTRE SEU PROJETO -------");
		cadastraProjetos();

	}

}
