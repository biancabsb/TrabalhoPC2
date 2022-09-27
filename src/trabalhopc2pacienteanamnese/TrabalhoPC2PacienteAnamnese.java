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
                            + "MEU ATENDENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                    System.out.println("Digite 0 para sair: ");
                    System.out.println("Digite 1 para cadastrar um paciente: ");
                    System.out.println("Digite 2 para alterar um paciente: ");
                    System.out.println("Digite 3 para excluir um paciente: ");
                    System.out.println("Digite 4 para buscar um pacientes: ");
                    System.out.println("Digite 5 para listar os pacientes: ");
                    System.out.println("Digite -1 para voltar ao menu principal: ");

                    select = sc.nextInt();
                    sc.nextLine();

                    switch (select) {

                        case -1:
                            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                    + "MENU PRINCIPAL*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                            System.out.println("Digite 1 para MENU ATENDENTE ");
                            System.out.println("Digite 2 para MENU MÉDICO");
                            select = sc.nextInt();
                            sc.nextLine();
                            break;
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
                do {

                    System.out.println("Digite 0 para sair ");
                    System.out.println("Digite 1 para ADICIONAR UMA NOVA ANAMNESE ");
                    System.out.println("Digite 2 para ALTERAR UMA ANAMNESE ");
                    System.out.println("Digite 3 para LISTAR ANAMNESE ");
                    System.out.println("Digite -1 para voltar ao menu principal: ");

                    select = sc.nextInt();
                    sc.nextLine();

                    switch (select) {
                        case -1:
                            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                    + "MENU PRINCIPAL*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                            System.out.println("Digite 1 para MENU ATENDENTE ");
                            System.out.println("Digite 2 para MENU MÉDICO");
                            select = sc.nextInt();
                            sc.nextLine();
                            break;
                        case 1:

                            Anamnese a = new Anamnese();
                            Paciente c = new Paciente();
                            Scanner sc = new Scanner(System.in);

                            System.out.println("NÚMERO DA CNSS DO PACIENTE:  ");
                            long numCNS2 = sc.nextInt();

                            if (sistema.buscarCNS(numCNS2) != null) {
                                System.out.println("");
                                System.out.println("PACIENTE: " + sistema.buscarCNS(numCNS2).nome);
                                System.out.println("");
                                System.out.println("RELATO DO PACIENTE:");
                                a.relato = sc.next();
                                System.out.println("MOTIVO: ");
                                a.motivo = sc.next();
                                System.out.println("DIAGNOÓSTICO");
                                a.diagnostico = sc.next();
                                a.paciente = sistema.buscarCNS(numCNS2);
                                sistema.AdicionarAnamnese(a);
                                a.paciente = sistema.buscarCNS(numCNS2);
                                System.out.println("*=*=*=* ANAMNESE ALTERADA COM SUCESSO *=*=*=*");
                            } else {
                                System.out.println("CNS NÃO ENCONTRADA");
                            }

                            break;

                        case 2:
                            Scanner scn = new Scanner(System.in);
                            System.out.println("NOME DO PACIENTE:  ");
                            String nome = scn.next();
                            Anamnese[] nomess = new Anamnese[10];

                            if (sistema.buscarNomeAnam(nome) != null) {
                                System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                nomess = sistema.buscarNomeAnam(nome);
                                int j = 0;
                                for (int i = 0; i < sistema.buscarNomeAnam(nome).length; i++) {
                                    if (nomess[i] != null) {
                                        System.out.println(i + "\t" + nomess[i].paciente.nome + "\t" + nomess[i].paciente.nomeMae);
                                        j = +1;
                                    }
                                }
                            } else {
                                System.out.println("PACIENTE NÃO ENCONTRADO");
                            }
                           
                            
                                System.out.println("DIGITE O ID DO PACIENTE QUE DESJA ALTERAR ANAMNESE ");
                                int escolha = scn.nextInt();
                                int x = sistema.identificarID(escolha, nomess);
                                System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                System.out.println(x + "\t" + nomess[x].paciente.nome + "\t" + nomess[x].paciente.nomeMae);
                                System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                nomess[x].diagnostico = null;
                                nomess[x].motivo = null;
                                nomess[x].relato = null;
                                Scanner scc = new Scanner(System.in);
                                System.out.println("MOTIVO: ");
                                nomess[x].motivo = scc.next();
                                System.out.println("RELATO DO PACIENTE: ");
                                nomess[x].relato = scc.next();
                                System.out.println("DIAGNÓSTICO");
                                nomess[x].diagnostico = scc.next();
                                sistema.AdicionarAnamnese(nomess[x]);
                                System.out.println("*=*=*=* ANAMNESE ALTERADA COM SUCESSO *=*=*=*\n");

                            

                            break;

                        case 3:
                            System.out.println("*=*=*=*=*=*=* ANAMNESES *=*=*=*=*=*=*");
                            sistema.listarTodasAnam();
                            System.out.println("");
                            break;
                    }

                } while (select != 0);

        }

    }
}
