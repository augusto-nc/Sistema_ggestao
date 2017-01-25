package Classes;

public class Projetos {
	
	public int id;
	public String titulo;
	public Data dataInicio;
	public Data dataTermino;
	public String agenciaFinanciadora;
	public double valorFinanciado;
	public String objetivo;
	public String descrição;
	public Professor[] orientadores = new Professor[5];
	public int qtdOrientadores;
	public Colaboradores[] colaboradores = new Colaboradores[10];
	public int qtdColaboradores;
	public String[] estadoProjeto = { "Em elaboração, Em andamento, Concluído"};
	public int indexProjeto = 0;
	public boolean permissaoLancar = false;
	public Publicacao[] publicacoes = new Publicacao[10];
	public int qtdPublicacao = 0;
	
}
