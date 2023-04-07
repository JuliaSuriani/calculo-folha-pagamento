import java.util.Scanner;
//author: Júlia Suriani

class Main {
  public static void main(String[] args) {
    double inss, fgts, irrf = 0;
    String nome, cargo, cpf = "";
    double salarioBase, salarioFinal, horasTrab, jornadaSem, jornadaMensal, salarioHora  = 0;
    double vt, va, periculosidade, insalubridade = 0;
    double adicional, beneficio, desconto = 0;
    int diasTrab = 0;
    Scanner scan = new Scanner(System.in);

    System.out.println("Insira o nome do funcionário:");
    nome = scan.next();

    System.out.println("Insira o CPF do funcionário:");
    cpf = scan.next();

    System.out.println("Insira o cargo do funcionário:");
    cargo = scan.next();

    System.out.println("Insira o salário base do funcionário:");
    salarioBase = scan.nextDouble();

    System.out.println("Insira as hora diárias a serem trabalhadas:");
    horasTrab = scan.nextDouble();

    System.out.println("Insira os dias a serem trabalhados por semana:");
    diasTrab = scan.nextInt();

    //calculo de salario hora 
    jornadaSem = horasTrab * diasTrab;
    jornadaMensal = jornadaSem * 4;
    salarioHora = salarioBase / jornadaMensal;
    
    //calculo de insalubridade = 40%
    var temp1 = " ";
    System.out.println("O funcionário recebe por insalubridade? (Responda apenas com sim ou nao)");
    temp1 = scan.next();

    if (temp1 == "sim") {
      insalubridade = salarioBase * 0.4;

    } else {
      insalubridade = 0;
    }

    //calculo de periculosidade = 30%
    var temp2 = " ";
    System.out.println("O funcionário recebe por periculosidade? (Responda apenas com sim ou nao)");
    temp2 = scan.next();

    if (temp2 == "sim") {
      periculosidade = salarioBase * 0.3;

    } else {
      periculosidade = 0;
    }
    
  //calculo de beneficios (VA & VT)
    va = salarioBase * 0.2;
    vt = salarioBase * 0.06;

  //calculo do INSS
    if (salarioBase <= 1302.00) {
      inss = salarioBase * 0.075;      
    } else if (salarioBase >= 1302.01 && salarioBase <= 2571.29) {
      inss = salarioBase * 0.09;
    } else if ( salarioBase >= 2571.30 && salarioBase <= 3856.94){
      inss = salarioBase * 0.12;
    } else if ( salarioBase >= 3856.95 && salarioBase <= 7507.49){
      inss = salarioBase * 0.14;
    } 
  //calculo do FGTS 8%
  fgts = salarioBase * 0.08; 

  //calculo do IRRF
   if (salarioBase <= 1903.98) {
      irrf = 0;      
    } else if (salarioBase >= 1903.99 && salarioBase <= 2826.65) {
      irrf = salarioBase * 0.075;
    } else if ( salarioBase >= 2826.66 && salarioBase <= 3751.05){
      irrf = salarioBase * 0.15;
    } else if ( salarioBase >= 3751.06 && salarioBase <= 4664.68){
      irrf = salarioBase * 0.225;
    } else if ( salarioBase >= 4664.69){
      irrf = salarioBase * 0.275;
    }
    //calculos para o salario liquido
    adicional = insalubridade + periculosidade;
    beneficio = va + vt;
    desconto =  inss + fgts + irrf;
    salarioFinal = salarioBase + adicional - beneficio - desconto;

    //relatorio
    System.out.println("Folha de pagamento");
    System.out.format("Dados do Funcionário: %d\n", nome);
    System.out.format("Cargo:%d || CPF:%d\n", cargo, cpf);
    System.out.println("Salario bruto:" +salarioBase);
    System.out.println("Adicionais:" + adicional);
    System.out.format("- Periculosidade: %d  - Insalubridade: %d\n", periculosidade, insalubridade);
    System.out.println("Benefícios:" + beneficio);
    System.out.format("- Vale alimentação:%d  - Vale transporte:%d\n", va, vt);
    System.out.println("Descontos:" + desconto);
    System.out.format("- INSS: %d - FGTS:%d - IRRF:%d\n", inss, fgts, irrf);
    System.out.println("Salário líquido:" +salarioFinal);

  }
}