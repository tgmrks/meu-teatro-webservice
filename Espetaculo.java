package br.com.meuteatrows;


public class Espetaculo {
	
	private int id_usuario;
	private int id_t;
	private int id_e;
	private String titulo;
	private String descricao;
	private String classificacao;
	private String data_hora; 
	private byte[] imagem;
	private String entrada;
	private String link_externo;
//	private String data_cadastro;
//	private int ativo;
	private int dia;
	private int mes;
	private int ano;
	private String hora;
	
	
	
	public int getId_e() {
		return id_e;
	}
	public void setId_e(int id_e) {
		this.id_e = id_e;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
//	public String getData_cadastro() {
//		return data_cadastro;
//	}
//	public void setData_cadastro(String data_cadastro) {
//		this.data_cadastro = data_cadastro;
//	}
//	public int getAtivo() {
//		return ativo;
//	}
//	public void setAtivo(int ativo) {
//		this.ativo = ativo;
//	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData_hora() {
		return data_hora;
	}
	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getLink_externo() {
		return link_externo;
	}
	public void setLink_externo(String link_externo) {
		this.link_externo = link_externo;
	}
	public int getId_t() {
		return id_t;
	}
	public void setId_t(int id_t) {
		this.id_t = id_t;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	
}

