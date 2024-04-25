package Atividade4;

public class TesteException {
  public static void main(String[] args) {
    Conta c1, c2;
    Cliente cli = new PessoaFisica("Joao", "Rua A", "422-000", "9876543");

    c1 = new Conta(cli, "1234-6", 200.00);
    c2 = new Conta(cli, "3219-0", 170.00);
    try {
      c1.transferir(c2, 250.00);

    } catch (SaldoInsuficienteException sie) {
      System.out.println(sie.getMessage());
      System.out.print("Conta: "+ sie.getNumero()+ "/ Saldo disponível" + sie.getSaldo() + "\n");
    }
  }
}
