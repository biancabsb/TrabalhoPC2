package trabalhopc2pacienteanamnese;

import java.util.Scanner;

public class Sistema {

    Paciente[] paciente = new Paciente[10];
    Anamnese[] anamnese = new Anamnese[10];
    Anamnese[] pacienteA = new Anamnese[10];

    Paciente registrarPac() {

        Scanner sc = new Scanner(System.in);
        Paciente p = new Paciente();
        Endereco ep = new Endereco();

        System.out.println("Qual o nome do Paciente? ");
        p.nome = sc.nextLine();
        System.out.println("Qual o número de sua CNS? ");
        p.numCNS = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual o nome damãe? ");
        p.nomeMae = sc.nextLine();
        System.out.println("Qual o sexo do paciente? (Digite 1 para MASCULINO 2 para"
                + " FEMININO e 3 para INTERSEXO)");

        int s = sc.nextInt();
        sc.nextLine();

        for (;;) {

            if (s == 1) {

                p.sexo = Sexo.MASCULINO;
                break;
            } else if (s == 2) {

                p.sexo = Sexo.FEMININO;
                break;
            } else if (s == 3) {

                p.sexo = Sexo.INTERSEXO;
                break;
            } else {

            }
        }

        System.out.println("Qual a cidade onde mora? ");
        ep.cidade = sc.nextLine();
        System.out.println("Qual o bairo? ");
        ep.bairro = sc.nextLine();
        System.out.println("Qual a rua? ");
        ep.rua = sc.nextLine();
        System.out.println("Qual o número da residência?");
        ep.numero = sc.nextInt();
        p.endereco = ep;

        sc.close();
        return p;
    }

    boolean verificaExiPac(Paciente p, Paciente[] vetPac) {

        if (p != null) {

            for (int i = 0; i < vetPac.length; i++) {
                if (vetPac[i] != null) {

                    if (p.nome.equals(vetPac[i].nome) && p.nomeMae.equals(vetPac[i].nomeMae)) {

                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean adicionar(Paciente p) {

        if (p != null) {

            for (int i = 0; i < paciente.length; i++) {

                if (paciente[i] == null) {

                    paciente[i] = p;
                    return true;
                }
            }
            aumentarPac(p);
            return true;
        } else {

            return false;
        }
    }

    boolean adicionarAnam(Paciente p, Anamnese a) {

        if (p.vetAnamnese != null) {

            for (int i = 0; i < p.vetAnamnese.length; i++) {

                if (p.vetAnamnese[i] == null) {

                    p.vetAnamnese[i] = a;
                    return true;
                }
            }
            return true;
        } else {

            return false;
        }
    }

    void aumentarPac(Paciente p) {

        Paciente[] aux = new Paciente[paciente.length * 2];

        int i = 0;
        for (; i < paciente.length; i++) {

            aux[i] = paciente[i];
        }
        paciente = aux;
        paciente[i] = p;
    }

    boolean alterar(long numCNS, Paciente[] vetPac) {

        for (int i = 0; i < vetPac.length; i++) {

            if (vetPac[i] != null && numCNS == vetPac[i].numCNS) {

                vetPac[i] = registrarPac();
                return true;
            }
        }
        return false;
    }

    boolean listarPac(Paciente[] vetPac) {

        if (vetPac != null) {

            System.out.println("Nome\t Número CNS\t Nome da mãea\t sexo\t"
                    + " Endereço: Cidade\t Bairro\t Rua\t Número");
            for (int i = 0; i < vetPac.length; i++) {

                if (vetPac[i] != null) {
                    System.out.println(vetPac[i].nome + "\t" + vetPac[i].numCNS + "\t"
                            + vetPac[i].nomeMae + "\t" + vetPac[i].sexo + "\t"
                            + vetPac[i].endereco.cidade + "\t" + vetPac[i].endereco.bairro
                            + "\t" + vetPac[i].endereco.rua + "\t" + vetPac[i].endereco.numero
                            + "\t");
                }
            }
            return true;
        }
        return false;
    }

    void excluir() {

    }

    Paciente buscarCNS(long numCNS) {
        for (int i = 0; i < this.paciente.length; i++) {
            if (this.paciente[i] != null && numCNS == this.paciente[i].numCNS) {
                return this.paciente[i];
            }
        }
        return null;
    }

    boolean AdicionarAnamnese(Anamnese a) {
        if (a != null) {
            for (int i = 0; i < anamnese.length; i++) {
                if (anamnese[i] == null) {
                    anamnese[i] = a;
                    return true;
                }
            }
        }
        return false;
    }

    boolean listarAnam(Paciente p) {
        if (p.vetAnamnese != null) {
            System.out.println("DIAGNÓSTICO: \t \t" + "MOTIVO: \t \t" + "RELATO: ");
            for (int i = 0; i < p.vetAnamnese.length; i++) {
                if (p.vetAnamnese[i] != null) {
                    System.out.println(i + 1 + " " + p.vetAnamnese[i].diagnostico + " \t \t" + p.vetAnamnese[i].motivo + " \t \t" + p.vetAnamnese[i].relato + " ");
                }
            }
            return true;
        }
        return false;
    }

    boolean listarTodasAnam() {

        if (anamnese != null) {
            System.out.println("PACIENTE: \t \t" +"DIAGNÓSTICO: \t \t" + "MOTIVO: \t \t" + "RELATO: ");
            for (int i = 0; i < anamnese.length; i++) {
                if (anamnese[i] != null) {
                    System.out.println(i + 1 + " " +anamnese[i].paciente.nome+ anamnese[i].diagnostico + " \t \t" + anamnese[i].motivo + " \t \t" + anamnese[i].relato + " ");
                }
            }
            return true;
        }
        return false;
    }

    Paciente buscarNome(String nome) {
        for (int i = 0; i < this.paciente.length; i++) {
            if (this.paciente[i] != null && nome.equals(this.paciente[i].nome)) {
                return this.paciente[i];
            }
        }
        return null;
    }

    void alterarAnamnese() {

    }

    void init() {

        Anamnese a1 = new Anamnese();
        Anamnese a2 = new Anamnese();
        Paciente p1 = new Paciente();
        Endereco ep1 = new Endereco();

        p1.numCNS = 164584;
        p1.nome = "Jao";
        p1.nomeMae = "Renata";
        p1.sexo = Sexo.MASCULINO;
        ep1.bairro = "Melo Viana";
        ep1.cidade = "Coronel Fabriciano";
        ep1.rua = "Jasmin";
        ep1.numero = 58;
        p1.endereco = ep1;
        a1.diagnostico = "Gripe";
        a1.motivo = "Tosse";
        a1.relato = "teste";
        a2.diagnostico = "Alerg";
        a2.motivo = "Inchaço";
        a2.relato = "teste";
        p1.vetAnamnese[0] = a1;
        p1.vetAnamnese[1] = a2;

        this.adicionarAnam(p1, a1);
        this.adicionarAnam(p1, a2);
        AdicionarAnamnese(a1);
        AdicionarAnamnese(a2);

        this.adicionar(p1);

        Paciente p2 = new Paciente();
        Endereco ep2 = new Endereco();
        Anamnese a4 = new Anamnese();

        p2.numCNS = 1678454;
        p2.nome = "jao";
        p2.nomeMae = "Barbara";
        p2.sexo = Sexo.MASCULINO;
        ep2.bairro = "Giovanini";
        ep2.cidade = "Coronel Fabriciano";
        ep2.rua = "Paquetá";
        ep2.numero = 69;
        p2.endereco = ep2;
        p2.vetAnamnese[0] = a4;
        a4.diagnostico = "Virose";
        a4.motivo = "Tosse";
        a4.relato = "teste";

        this.adicionarAnam(p2, a4);
        AdicionarAnamnese(a4);
        this.adicionar(p2);

        Paciente p3 = new Paciente();
        Endereco ep3 = new Endereco();
        p3.numCNS = 1278479;
        p3.nome = "Jet";
        p3.nomeMae = "Helena";
        p3.sexo = Sexo.MASCULINO;
        ep3.bairro = "Canaã";
        ep3.cidade = "Ipatinga";
        ep3.rua = "Isaías";
        ep3.numero = 777;
        p3.endereco = ep3;
        this.adicionar(p3);

        Paciente p4 = new Paciente();
        Endereco ep4 = new Endereco();
        p4.numCNS = 2;
        p4.nome = "Augusto";
        p4.nomeMae = "Diana";
        p4.sexo = Sexo.MASCULINO;
        ep4.bairro = "Primavera";
        ep4.cidade = "Timóteo";
        ep4.rua = "Carmélia";
        ep4.numero = 66;
        p4.endereco = ep4;
        this.adicionar(p4);

        Paciente p5 = new Paciente();
        Endereco ep5 = new Endereco();
        p4.numCNS = 2972004;
        p4.nome = "Clara";
        p4.nomeMae = "Ana";
        p4.sexo = Sexo.FEMININO;
        ep4.bairro = "Iguaçu";
        ep4.cidade = "Ipatinga";
        ep4.rua = "Ametista";
        ep4.numero = 13;
        p4.endereco = ep5;
        this.adicionar(p5);

    }
}
