package Atividade3;

public class Principal {
  public static void main(String[] args) {
    PessoaFisica pf = new PessoaFisica("Joao", "Rua 1", "1234-5678", "123.456.789-00");
    PessoaJuridica pj = new PessoaJuridica("Empresa", "Rua 2", "8765-4321", "12.345.678/0001-99");
    System.out.println(pf+ "\n");
    System.out.println(pf.getTipo() + "\n");
    System.out.println(pj + "\n");
    System.out.println(pj.getTipo() + "\n");
  }
}
