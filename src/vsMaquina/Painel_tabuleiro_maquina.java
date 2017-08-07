package vsMaquina;

import javax.swing.*;

/**
 * Created by marcos on 03/06/16.
 */
public class Painel_tabuleiro_maquina {

    private int [][]matriz = new int[8][8];
    private int i,j;

    private int jd1 = 2;
    private int jd1_rainha = 20;

    private int jd2 = 3;
    private int jd2_rainha = 30;

    //implementacao de jogadas da maquina

    private void cpu_jogada(){

        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == jd2){
                    // verificarAtaque(i,j,jd2);
                    //verificarAtaque as posssibilidades de
                    // ataque : defesa : aleatorio
                    //ataque tem prioridade 1 - ve se tem como comer quem ataca
                    //defesa tem prioridade 2 - ou movimenta a peca que esta sob ataque ou movimenta a outa para ajudar
                    //aleatorio nao tem prioridade -- caso nao esteja sob ataque ou defesa
                }
            }
        }
    }

    private void cpu_movimento(){}

    private void cpu_ataque(int linha, int coluna){
        if(coluna !=0 && linha !=0 && matriz[linha-1][coluna-1] == jd1){
            if(coluna !=1 && linha != 1 && matriz[linha-2][coluna-2] == 1){
                //come_esq_cima(linha,coluna);
            }
        }

        if(coluna != 7 && linha != 0 && matriz[linha-1][coluna+1] == jd1){
            if(coluna != 6 && linha != 1 && matriz[linha-2][coluna+2] == 1){

                //tingir um ataque
                //come_dir_cima(linha,coluna);

            }

        }
    }

    private void cpu_defesa(int linha, int coluna){
        if(linha == 0){
            JOptionPane.showMessageDialog(null,"Dama de CPU");
        }

        //possivel ATAQUE


        if(linha !=7 &&  coluna !=7 && matriz[linha+1][coluna+1] == 1){
            if(matriz[linha-1][coluna-1] == jd1){
                //esta sob ATAQUE  a esquerda pra cima
                //Melhor sair logo ou posicionar uma peca anterior para proteger
            }
        }

        if(linha != 7 && coluna !=0 && matriz[linha+1][coluna-1] == 1){
            if(matriz[linha-1][coluna+1] == jd1){
                //esta sob ATAQUE  a direita pra cima
                //Melhor sair logo ou posicionar uma peca anterior para proteger
            }
        }

        //verificando se tem alguma ameaca a frente

        if(linha != 0 && coluna !=0 && matriz[linha-1][coluna-1] == 1){ //verificando ameaca a esquerda
            if(linha != 1 && coluna != 1 && matriz[linha-2][coluna-2] == 2){
                //uma ameca a frente a esquerda -- nao jogar
            }
            else{
                //pode fazer uma jogada simples - add ao vetor de possibilidades - pri menor
                //private void addpecastrue();
            }
        }

        if(linha != 0 && coluna !=7 && matriz[linha-1][coluna+1] == 1){ //verificando ameaca a direita
            //cpu pode jogar para a diretia
            if(linha != 1 && coluna !=6 && matriz[linha-2][coluna+2] == 2){
                //uma ameaca a frente -- nao jogar
            }
        }


    } //--

    private void cpu_aleatorio(){} //--



}
