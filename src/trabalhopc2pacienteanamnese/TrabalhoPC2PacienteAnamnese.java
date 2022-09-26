package trabalhopc2pacienteanamnese;

import java.util.Random;
import java.util.Scanner;

public class TrabalhoPC2PacienteAnamnese {

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {

        int select;
        Sistema sistema = new Sistema();
        sistema.init();

        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "MENU PRINCIPAL*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("Digite 1 para MENU ATENDENTE ");
        System.out.println("Digite 2 para MENU MÉDICO");
        select = sc.nextInt();
        sc.nextLine();
        switch (select) {

            case 1:

                do {

                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                            + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("Digite 0 para sair: ");
                    System.out.println("Digite 1 para cadastrar um paciente: ");
                    System.out.println("Digite 2 para alterar um paciente: ");
                    System.out.println("Digite 3 para excluir um paciente: ");
                    System.out.println("Digite 4 para buscar um pacientes: ");
                    System.out.println("Digite 5 para listar os pacientes: ");

                    select = sc.nextInt();
                    sc.nextLine();

                    switch (select) {

                        case 0:
                            break;

                        case 1:

                            if (sistema.adicionar(sistema.registrarPac())) {

                                System.out.println("O paciente foi adicionado com sucesso!");
                            } else {

                                System.out.println("Não foi possível cadastrar o paciente");
                            }
                            break;

                        case 2:

                            System.out.println("Qual o número da CNS do paciente? ");

                            long numCNS = sc.nextInt();
                            sc.nextLine();

                            if (sistema.alterar(numCNS, sistema.paciente)) {

                                System.out.println("Paciente alterado com sucesso!");
                            } else {

                                System.out.println("Não foi possível alterar o paciente");
                            }
                            break;

                        case 3:
                            break;

                        case 4:
                            break;

                        case 5:

                            System.out.println("");
                            sistema.listarPac(sistema.paciente);
                            System.out.println("");
                            break;
                    }
                } while (select != 0);
                break;

            case 2:
                System.out.println("Digite 1 para adicionar uma nova anamnese: ");
                System.out.println("Digite 2 para alterar uma anamnese: ");
                System.out.println("Digite 3 para listar anamneses: ");

                select = sc.nextInt();
                sc.nextLine();

                switch (select) {
                    case 1:
                        
                        Anamnese a = new Anamnese();
                        Paciente c = new Paciente();
                        Scanner sc = new Scanner(System.in);
                        
                        System.out.println("Qual o número da CNS do paciente? ");
                        long numCNS2 = sc.nextInt();
                        
                        if (sistema.buscarCNS(numCNS2) != null) {
                            System.out.println("Paciente: " + sistema.buscarCNS(numCNS2).nome);
                            System.out.println("Qual o motivo? ");
                            a.motivo = sc.next();
                            System.out.println("Descreva o relato:");
                            a.relato = sc.next();
                            System.out.println("Qual o diagnóstico?");
                            a.diagnostico = sc.next();
                            a.paciente = sistema.buscarCNS(numCNS2);
                            sistema.AdicionarAnamnese(a);
                            sistema.adicionarAnam(sistema.buscarCNS(numCNS2), a);
                        } else {
                            System.out.println("CNS não encontrada");
                        }
                        break;

                    case 2:
                        Scanner scn = new Scanner(System.in);
                        System.out.println("Qual o nome do paciente? ");
                        String nome = scn.next();
                        if (sistema.buscarNome(nome) != null) {
                            System.out.println("NOME \t" + "NOME DA MÃE \t");
                            System.out.println(sistema.buscarNome(nome).nome + "\t" + sistema.buscarNome(nome).nomeMae);
                            sistema.listarAnam(sistema.buscarNome(nome));

                        } else {
                            System.out.println("erro");
                        }

                        break;

                    case 3:
                        System.out.println("*************Anamneses*****************");
                        sistema.listarTodasAnam();

                }

        }

    }

}
