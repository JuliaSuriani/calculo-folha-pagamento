import java.util.Scanner;

class Main {
  static final int vt = 0.06; // vale transporte desconto de 6%
  static final int va = 0.2; // vale alimentação desconto de 20%

  public static void main(String[] args) {
    string nome, cargo, cpf = " ";
    float salarioBase, salarioFinal = 0;
    float inss, fgts, irrf, periculosidade, insalubridade = 0;
    Scanner scan = new Scanner(System.in);

    System.out.println("Insira o nome do funcinário:");
    nome = scan.next();

    System.out.println("Insira o CPF do funcinário:");
    cpf = scan.next();

    System.out.println("Insira o salário base do funcinário:");
    salarioBase = scan.nextFloat();

    System.out.println("O funcionário recebe por insalubridade?");
    cpf = scan.next();

  }
}