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
        System.out.print("Digite aqui: ");
       

        select = sc.nextInt();
        sc.nextLine();
         System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        switch (select) {

            case 1:

                do {

                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=" 
                            + "MENU ATENDENTE *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                    System.out.println("Digite 0 para sair");
                    System.out.println("Digite 1 para CADASTRAR UM PACIENTE");
                    System.out.println("Digite 2 para ALTERAR UM PACIENTE");
                    System.out.println("Digite 3 para EXCLUIR UM PACIENTE");
                    System.out.println("Digite 4 para BUSCAR UM PACIENTE");
                    System.out.println("Digite 5 para LISTAR OS PACIENTES");
                    System.out.print("Digite aqui: ");

                    select = sc.nextInt();
                    sc.nextLine();
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                            + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                    switch (select) {

                        case 0:
                            break;

                        case 1:
                            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                    + "CADASTRO DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                            if (sistema.adicionar(sistema.registrarPac())) {

                                System.out.println("O paciente foi adicionado com sucesso!");
                            } else {

                                System.out.println("Não foi possível cadastrar o paciente");
                            }
                            break;

                        case 2:
                            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                    + "ALTERAR PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                            System.out.println("Qual o nome do paciente? ");
                            String nome = sc.nextLine();
                            System.out.println("Qual o nome da mãe desse paciente?");
                            String nomeM = sc.nextLine();

                            if (sistema.alterar(nome, nomeM)) {

                                System.out.println("Paciente alterado com sucesso!");
                            } else {

                                System.out.println("!!!! Não foi possível alterar o paciente !!!!");
                            }
                            break;

                        case 3:
                            System.out.println("Qual o nome do paciente a ser excluido? ");
                            String nomee = sc.nextLine();
                            System.out.println("Qual o nome da mãe do paciente? ");
                            String nomeMe = sc.nextLine();

                            if (sistema.excluirPac(nomee, nomeMe)) {

                                System.out.println("O paciente foi excluido com sucesso!");
                            } else {

                                System.out.println("!!!! Não foi possível excluir o paciente !!!!");
                            }

                            break;

                        case 4:
                            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                                    + "BUSCA DE PACIENTE*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
                            System.out.println("Qual o nome do paciente a ser buscado? ");
                            String nomeB = sc.nextLine();
                            System.out.println("Qual o ome da Mãe? ");
                            String nomeMB = sc.nextLine();
                            if (sistema.buscarPac(nomeB, nomeMB)) {
                                System.out.println("O paciente existe!");
                            } else {
                                System.out.println("!! Paciente não encontrado !!");
                            }
                            break;

                        case 5:

                            System.out.println("");
                            sistema.listarPac();
                            System.out.println("");
                            break;
                    }
                } while (select != 0);

                break;

            case 2:
                do {
                    
                    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=" 
                            + "MENU MEDICO *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

                    System.out.println("Digite 0 para sair ");
                    System.out.println("Digite 1 para ADICIONAR UMA NOVA ANAMNESE ");
                    System.out.println("Digite 2 para ALTERAR UMA ANAMNESE ");
                    System.out.println("Digite 3 para LISTAR ANAMNESES ");
                    System.out.println("Digite 4 para BUSCAR UMA ANAMNESE ");
                    System.out.println("Digite -1 para voltar ao menu principal: ");
                    System.out.print("Digite aqui: ");
                   

                    select = sc.nextInt();
                    sc.nextLine();
                     System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                            + "*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
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

                            System.out.print("NÚMERO DA CNSS DO PACIENTE:  ");
                            long numCNS2 = sc.nextInt();

                            if (sistema.buscarCNS(numCNS2) != null) {
                                System.out.println("");
                                System.out.println("PACIENTE: " + sistema.buscarCNS(numCNS2).nome);
                                System.out.println("");
                                System.out.println("RELATO DO PACIENTE:");
                                a.relato = sc.next();
                                sc.nextLine();
                                System.out.println("MOTIVO: ");
                                a.motivo = sc.next();
                                sc.nextLine();
                                System.out.println("DIAGNOÓSTICO DA DO CASO");
                                a.diagnostico = sc.next();
                                sc.nextLine();
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

                            System.out.println("DIGITE O ID DA ANAMNESE QUE DESJA ALTERAR ANAMNESE ");
                            int escolha = scn.nextInt();
                            int x = sistema.identificarID(escolha, nomess);
                           
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
                    
                    case 4:
                            Scanner sd= new Scanner(System.in);
                            System.out.println("NOME DO PACIENTE:  ");
                            String nomee = sd.next();
                            Anamnese[] nomesss = new Anamnese[10];

                            if (sistema.buscarNomeAnam(nomee) != null) {
                                System.out.println("ID " + "\t" + "NOME \t" + "NOME DA MÃE \t");
                                nomesss = sistema.buscarNomeAnam(nomee);
                                int j = 0;
                                for (int i = 0; i < sistema.buscarNomeAnam(nomee).length; i++) {
                                    if (nomesss[i] != null) {
                                        System.out.println(i + "\t" + nomesss[i].paciente.nome + "\t" + nomesss[i].paciente.nomeMae);
                                        j = +1;
                                    }
                                }
                            } else {
                                System.out.println("PACIENTE NÃO ENCONTRADO");
                            }
                            break;
                    }
                } while (select != 0);

        }

    }
}
