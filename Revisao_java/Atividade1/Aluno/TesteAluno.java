package Aluno;

/*public class TesteAluno {
  public static void main(String arg[]) {

    Aluno a1, a2;
    a1 = new Aluno();
    a2 = new Aluno();
    a1.setNome("Fulano");
    a2.setNome("ciclano");
    System.out.println("Aluno 1 " + a1.getNome());

    System.out.println("Aluno 2 " + a2.getNome());
  }
}*/

import javax.swing.JOptionPane;

public class TesteAluno {
  public static void main(String arg[]) {
    Aluno a1, a2;
    a1 = new Aluno();
    String nomeAluno, matriculaAluno, cpfAluno, dataNascimento;
    nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno");
    matriculaAluno = JOptionPane.showInputDialog("Digite a matricula do aluno");

    cpfAluno = JOptionPane.showInputDialog("Digite o CPF do aluno");
    dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento do aluno");

    a1.setNome(nomeAluno);
    a1.setMatricula(matriculaAluno);
    a1.setCPF(cpfAluno);
    a1.setDataNascimento(dataNascimento);
    JOptionPane.showMessageDialog(null, "Nome: " + a1.getNome() + "\n"
        + "Maticula: " + a1.getMatricula() + "\n"
        + "CPF: " + a1.getClass() + "\n"
        + "Data de nascimento: " + a1.getDataNascimento(),
        "Dados de aluno", JOptionPane.PLAIN_MESSAGE);
  }
}