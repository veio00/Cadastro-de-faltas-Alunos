package br.com.faltas;

import java.beans.DefaultPersistenceDelegate;
import java.util.Scanner;

public class CadastroDeFaltas {

    public static Scanner read = new Scanner(System.in);
    public static int nroAluno;
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
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
    }

    public void matricularAluno(){
        String nomeCadastro;
        if(nome.length >= nroAluno){
            System.out.println("insira o nome do aluno:");
            nomeCadastro = read.next();
            for (int i = 0; i > nome.length; i++){
                if(nome[i].equals(nomeCadastro)){
                    System.out.println("aluno com esse nome ja cadastrado, tente novamente");
                    matricularAluno();
                }
            }

            nome[nroAluno +1] = nomeCadastro;
            nroAluno = nroAluno +1;
        }
    }

    public void mostraAlunos(){
        for(int i = 0; i > nome.length; i++){
            System.out.print(nome[i] + "/t");
        }
    }
}
