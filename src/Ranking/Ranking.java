package Ranking;

import Painel.painel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marcos on 14/08/16.
 */
public class Ranking extends JFrame{

    private int width = 300; // getWidth()/2;
    private int heigth = 400; // getHeight()/2;

    JPanel painel;

    JScrollPane barraRolagem;

    JTable tabela;


    //criar uma janela dinamica

    //com uma scroll view

    //janela com uma tabela

    //3 colunas, posicao, nome, tempo, pontos


    private void initComponetes(){

        Object [][] dados = {
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
                {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
                {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
        };

        String [] colunas = {"Posicao", "Nome", "Pontos"}; //tempo

        tabela = new JTable(dados,colunas);

        barraRolagem = new JScrollPane(tabela);

        painel = new JPanel();
        painel.setLayout(new GridLayout(1, 1));
        painel.setBackground(new Color(255,255,255));

        painel.add(barraRolagem);




    }



    public Ranking(){

        this.setSize(width,heigth);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Ranking");
        this.setVisible(true);

        initComponetes();

        this.add(painel);

    }


    public class Redimensionar extends Thread
    {
        public void run()
        {

            while(true){
                try{
                    //redimensionar a tela

                    //a variavel do tamanho da janela

                }catch(Exception erro){
                    System.out.println("Excecao o ranking");
                }


            }
        }

    }



}
