package br.com.faltas;

import java.beans.DefaultPersistenceDelegate;
import java.util.Scanner;

public class CadastroDeFaltas {

    public static Scanner read = new Scanner(System.in);
    public static int nroAluno=0;
    public static int nrofaltas;
    public static String[] nome;

    public static void main(String[] args) {
        boolean menu = false;
        int escolha;
        int maxAlun;


        System.out.println("insira o numero de alunos");
        maxAlun = read.nextInt();

        nome = new String[maxAlun];
        int[][] faltas = new int[maxAlun][2];
        int[] total = new int[maxAlun];

        while (!menu){

            System.out.println(
                    "1- Matricular aluno na disciplina\n" +
                    "2- Cadastrar faltas\n" +
                    "3- Exibir faltas de um aluno\n" +
                    "4- Exibir relatório \n" +
                    "5- Sair"
            );

            escolha = read.nextInt();
            if(escolha > 0 && escolha < 6){
                switch (escolha){
                    case 1:
                        matricularAluno();
                        break;
                    case 2:
                        if(nroAluno > 0) {
                            System.out.println(" Apatir de agora nao sera amis possivel inserir alunos" +
                                    "Selicione o Bimestre das faltas \n" +
                                    "1- Primeiro semestre\n" +
                                    "2- Segundo semestre\n"
                            );
                            int bimestre = read.nextInt();
                            cadastraFalta(nome, faltas,nroAluno, bimestre);
                            calculaTotalFaltas(faltas,total,nroAluno);
                        }else {
                            System.out.println(" nao ha alunos cadastrados por favor ir na opcao 1 antes de inserir as faltas ");
                        }

                        break;
                    case 3:
                        boolean achado= false;
                        System.out.println("Digite o nome do aluno");
                        String procura = read.next();
                        for (int i = 0; i < nroAluno; i++){

                            if (nome[i].equals(procura)) {
                                achado = true;
                                for(int ii = 0; ii < 2; ii++) {
                                    System.out.println("No " + (ii+1)+ " bimestre faltou "+ faltas[i][ii] + " vezes");

                                }
                                System.out.println("total de faltas: "+ total[i]);

                            }
                            break;
                        }
                        if (achado == false)
                            System.out.println( "nome inexistente");
                        break;
                    case 4:
                        mostraAlunos(faltas, total);

                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public static void matricularAluno(){
        String nomeCadastro;
        boolean cadastrou = false;
        if(nome.length > nroAluno && nrofaltas == 0){

            while (!cadastrou) {
                System.out.println("insira o nome do aluno:");
                nomeCadastro = read.next();
                if (pesquisaAluno(nomeCadastro) == true) {
                    System.out.println("aluno com esse nome ja cadastrado, tente novamente");

                }else {
                    nome[nroAluno] = nomeCadastro;
                    cadastrou = true;
                    nroAluno = nroAluno + 1;
                    System.out.println("cadastro realizado com sucesso");
                    return;
                }
            }
        }else{
            if(nrofaltas > 0){
                System.out.println("ha faltas ja lancadas por favor tente comecar o processo novamente");
            }else {
                System.out.println("Numero maximo de alunos foi atingido");
            }

        }
    }
    public static boolean pesquisaAluno(String nomeCadastro){
        String valida;
        for (int i = 0; i < nome.length; i++) {
            valida = nome[i];
            if ( valida == nomeCadastro && nome[i].equals(nomeCadastro)) {
                return true;
            }
        }
        return false;
    }
    public static void mostraAlunos(int[][] faltas, int total[]){
        String exibirBonitinho;
        System.out.println("Vetor nome");
        for(int i = 0; i < nome.length; i++){
            System.out.println(nome[i]);
        }
        System.out.println("Matriz faltas");
        for(int i = 0; i < faltas[0].length; i++){
            for(int ii = 0; ii < 2; ii++){
                System.out.print(faltas[i][ii] +"\t");
            }
            System.out.println("");
        }
        System.out.println(" Vetor total");
        for(int i = 0; i < total.length; i++){
            System.out.println(total[i]);
        }

        System.out.println("Por extenso");
        for(int i = 0; i < nome.length; i++){

            exibirBonitinho ="O aluno " + nome[i] + " teve " + faltas[i][0] +
                    " faltas no primeiro bimestre e " +faltas[i][1] +
                    " faltas no segundo semestre com total de " + total[i] + " faltas no semestre";

            System.out.println(exibirBonitinho);
        }
        System.out.println(" Alunos com mais de 10 faltas:");
        for(int i = 0; i < nome.length; i++){
            if(total [i] > 10){
                System.out.println(nome[i]);
            }
        }
    }
    public static int[][] cadastraFalta(String[] nome, int[][] faltas, int nroAluno, int bimestre){
        System.out.println("insira as falta de: ");
        switch (bimestre){
            case 1:
                for(int i = 0; i < nroAluno; i++){
                    System.out.print(nome[i]+":  ");
                    faltas[i][0]= read.nextInt();
                    System.out.println("");
                }
                break;
            case 2:
                for(int i = 0; i < nroAluno; i++){
                    System.out.print(nome[i]+":  ");
                    faltas[i][1]= read.nextInt();
                    System.out.println("");
                }
                break;
        }

    return faltas;
    }
    public static void calculaTotalFaltas(int[][] faltas, int[] total, int nroAluno){
        for(int i = 0; i < nroAluno; i++){
            total[i] = faltas[i][0] +  faltas[i][1];
        }
    }
}
