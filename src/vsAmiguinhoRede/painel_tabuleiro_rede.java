package vsAmiguinhoRede;

import Indice.Botoes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Indice.Botoes;
/**
 * Created by marcos on 18/06/16.
 */
public class painel_tabuleiro_rede extends JPanel implements ActionListener {

    Botoes b = new Botoes();

    public JLabel lb_player1 = new JLabel();
    public JLabel lb_player2 = new JLabel();


    //label para a quantidade de pecas
    public JLabel lb_player1_quant_pc = new JLabel();
    public JLabel lb_player2_quant_pc = new JLabel();

    //label para a quantidade de pontos
    public JLabel lb_player1_quant_pontos = new JLabel();
    public JLabel lb_player2_quant_pontos = new JLabel();


    private int [][]matriz = new int[8][8];
    private int i,j;
    private boolean []vetor =new boolean [32];

    private int jd1 = 2;
    private int jd1_rainha = 20;

    private int jd2 = 3;
    private int jd2_rainha = 30;

    private int lvelha;
    private int cvelha;
    private int anterior;
    private int v_nulo = 0;

    //variaveis para valores ao final da partida
    private int pt1 = 0;
    private int pt2 = 0;


    private int atacante = 10;
    private int vitima = 5;
    private int casaFinal = 100;

    private boolean vez_de_jogar = true; //jogador jd1 start - false quando for a vez do outro
    private boolean so_ataque = false;
    private boolean tem_ganhador = false;


    //icones para indicar a vez

    ImageIcon seta = new ImageIcon(getClass().getResource("../imagens/mdi/seta_verde.png"));
    ImageIcon carregar = new ImageIcon(getClass().getResource("../imagens/loading.gif"));

    public JLabel jogador1_vez = new JLabel(seta);
    public  JLabel jogador2_vez = new JLabel(carregar);

    public painel_tabuleiro_rede(){

        setVisible(true);
        setLayout(new GridLayout(8,8));
        setBackground(new Color(28,195,28));

        addBotoes();


        inicializaMatriz();
        inicializa_vetor();
        System.out.println("");
        por_pecas();
        System.out.println("");

        Addclique();

        mudar_label_jogador();
        quant_pecas();

    } //construtor

    private void addBotoes(){
        add(b.bt1);
        add(b.bt2);
        add(b.bt3);
        add(b.bt4);
        add(b.bt5);
        add(b.bt6);
        add(b.bt7);
        add(b.bt8);


        add(b.bt9);
        add(b.bt10);
        add(b.bt11);
        add(b.bt12);
        add(b.bt13);
        add(b.bt14);
        add(b.bt15);
        add(b.bt16);


        add(b.bt17);
        add(b.bt18);
        add(b.bt19);
        add(b.bt20);
        add(b.bt21);
        add(b.bt22);
        add(b.bt23);
        add(b.bt24);


        add(b.bt25);
        add(b.bt26);
        add(b.bt27);
        add(b.bt28);
        add(b.bt29);
        add(b.bt30);
        add(b.bt31);
        add(b.bt32);


        add(b.bt33);
        add(b.bt34);
        add(b.bt35);
        add(b.bt36);
        add(b.bt37);
        add(b.bt38);
        add(b.bt39);
        add(b.bt40);


        add(b.bt41);
        add(b.bt42);
        add(b.bt43);
        add(b.bt44);
        add(b.bt45);
        add(b.bt46);
        add(b.bt47);
        add(b.bt48);


        add(b.bt49);
        add(b.bt50);
        add(b.bt51);
        add(b.bt52);
        add(b.bt53);
        add(b.bt54);
        add(b.bt55);
        add(b.bt56);


        add(b.bt57);
        add(b.bt58);
        add(b.bt59);
        add(b.bt60);
        add(b.bt61);
        add(b.bt62);
        add(b.bt63);
        add(b.bt64);

    }

    private void Addclique(){
        b.bt1.addActionListener(this);
        b.bt3.addActionListener(this);
        b.bt5.addActionListener(this);
        b.bt7.addActionListener(this);

        b.bt10.addActionListener(this);
        b.bt12.addActionListener(this);
        b.bt14.addActionListener(this);
        b.bt16.addActionListener(this);

        b.bt17.addActionListener(this);
        b.bt19.addActionListener(this);
        b.bt21.addActionListener(this);
        b.bt23.addActionListener(this);

        b.bt26.addActionListener(this);
        b.bt28.addActionListener(this);
        b.bt30.addActionListener(this);
        b.bt32.addActionListener(this);

        b.bt33.addActionListener(this);
        b.bt35.addActionListener(this);
        b.bt37.addActionListener(this);
        b.bt39.addActionListener(this);

        b.bt42.addActionListener(this);
        b.bt44.addActionListener(this);
        b.bt46.addActionListener(this);
        b.bt48.addActionListener(this);

        b.bt49.addActionListener(this);
        b.bt51.addActionListener(this);
        b.bt53.addActionListener(this);
        b.bt55.addActionListener(this);

        b.bt58.addActionListener(this);
        b.bt60.addActionListener(this);
        b.bt62.addActionListener(this);
        b.bt64.addActionListener(this);
    }

    public void inicializa_vetor(){
        for(i=0;i<32;i++){
            vetor[i] = false;
        }
    }

    public void imprimirVetor(){
        for(i=0;i<32;i++){
            System.out.println("I : "+i+" = "+vetor[i]);
        }
    }

    public void inicializaMatriz(){
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                matriz[i][j] = 0;
            }
        }

        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(i%2 == 0){
                    if(j%2==0){
                        matriz[i][j] = 1;
                    }
                }

                if(i%2!=0){
                    if(j%2!=0){
                        matriz[i][j] = 1;
                    }
                }


            }
        }
        ImprimirMatriz();
        System.out.printf("\n");
    }//fim da inicializacao

    public void ImprimirMatriz(){
        for(i=0;i<8;i++){
            System.out.printf("\n");
            for(j=0;j<8;j++){
                System.out.printf(" %d ",matriz[i][j]);
            }
        }
    }//fim do imprimir

    private void por_pecas(){
        for(i=0;i<3;i++){
            for(j=0;j<8;j++){
                if(i%2 == 0){
                    if(j%2==0){
                        matriz[i][j] = jd1;
                    }
                }

                if(i%2!=0){
                    if(j%2!=0){
                        matriz[i][j] = jd1;
                    }
                }


            }
        }

        for(i=5;i<8;i++){
            for(j=0;j<8;j++){
                if(i%2 == 0){
                    if(j%2==0){
                        matriz[i][j] = jd2;
                    }
                }

                if(i%2!=0){
                    if(j%2!=0){
                        matriz[i][j] = jd2;
                    }
                }


            }
        }


        ImprimirMatriz();
    }//por pecas

    public void Status_pecas(int linha,int coluna,int v){ //update dama

        //mostra as casas validas para jogar  e boolean a casa que pode ir


        if(so_ataque == false) {

            if (jd1 == v) { //2
                if (coluna != 0 && linha != 7 && matriz[linha + 1][coluna - 1] == 1) {
                    System.out.println("Posicao Válida a esquerda");
                    marcar_casas_validas(linha + 1, coluna - 1);

                }
                if (coluna != 7 && linha != 7 && matriz[linha + 1][coluna + 1] == 1) {
                    System.out.println("Posicao Válida a direita");
                    marcar_casas_validas(linha + 1, coluna + 1);
                }

            }

            if (jd2 == v) { //3
                if (coluna != 0 && linha != 0 && matriz[linha - 1][coluna - 1] == 1) {
                    System.out.println("Posicao Válida a esquerda");
                    marcar_casas_validas(linha - 1, coluna - 1);
                }
                if (coluna != 7 && linha != 0 && matriz[linha - 1][coluna + 1] == 1) {
                    System.out.println("Posicao Válida a direita");
                    marcar_casas_validas(linha - 1, coluna + 1);
                }
            }

            if (jd1_rainha == v) { // 20

                //fazer comdicao para ver todas as casas que a rainha pode jogar
                verifica_esquerda_baixo(linha, coluna);

                verifica_direita_baixo(linha, coluna);

                verifica_esquerda_cima(linha, coluna);

                verifica_direita_cima(linha, coluna);

            }

            if (jd2_rainha == v) { // 30  = condicao para ver as possiveis casas validas para jogar

                verifica_esquerda_baixo(linha, coluna);

                verifica_direita_baixo(linha, coluna);

                verifica_esquerda_cima(linha, coluna);

                verifica_direita_cima(linha, coluna);
            }
        }
        else{
            System.out.println("Tem Uma pedra que obrigatoriamente tem que comer");
        }

    }

    //verifica a esquerda para baixo se pode mover
    private void verifica_esquerda_baixo(int linha, int coluna){
        System.out.println("cs1 Linha : "+linha+" Coluna : "+coluna);
        int i = linha,j = coluna;
        try {
            do {//posicao valida  a esquerda para baixo
                i += 1;
                j -= 1;
                if (i <= 7 && j >= 0 && matriz[i][j] == 1) {
                    System.out.println("Casa cs1 : i :" + i + " j : " + j);
                    marcar_casas_validas(i, j);
                }
            } while (matriz[i][j] == 1);
        }catch (Exception erro){System.out.println("Fora do fluxo while");}
    }


    //verifica direita para baixo se pode mover
    private void verifica_direita_baixo(int linha, int coluna){
        System.out.println("cs2 Linha : "+linha+" Coluna : "+coluna);
        int i = linha, j = coluna;
        try {
            do {//posicao valida a direira para baixo
                i += 1;
                j += 1;
                if (i <= 7 && j <= 7 && matriz[i][j] == 1) {
                    System.out.println("Casa cs2 : i :" + i + " j : " + j);
                    marcar_casas_validas(i, j);
                }
            } while (matriz[i][j] == 1);
        }catch (Exception erro){System.out.println("Fora do fluxo while");}
    }


    //verifica esquerda para cima se pode mover
    private void verifica_esquerda_cima(int linha, int coluna){
        System.out.println("cs3 Linha : "+linha+" Coluna : "+coluna);
        int i = linha, j = coluna;
        try {
            do {//posicao valida a esquerda para cima
                i -= 1;
                j -= 1;
                if (i >= 0 && j >= 0 && matriz[i][j] == 1) {
                    System.out.println("Casa cs3 : i :" + i + " j : " + j);
                    marcar_casas_validas(i, j);
                }
            } while (matriz[i][j] == 1);
        }catch (Exception erro){System.out.println("Fora do fluxo while");}
    }


    //verifica direita para cima se pode mover
    private void verifica_direita_cima(int linha, int coluna){
        System.out.println("cs4 Linha : "+linha+" Coluna : "+coluna);
        int i = linha, j = coluna;
        try{
            do {//posicao valida a direita para cima
                i -=1;
                j +=1;
                if(i >= 0 && j <= 7 && matriz[i][j] == 1){
                    System.out.println("Casa cs4 : i :"+i+" j : "+j);
                    marcar_casas_validas(i,j);
                }
            }while(matriz[i][j] == 1);
        }catch (Exception erro){System.out.println("Fora do fluxo while");}
    }

    //funcao para habilitar a vez de quem joga

    private void trocar_vez(int linha,int coluna,int vez){

        //so posso comer de novo se eu tiver acabado de comer uma peca


        if(vez == 100){
            if(vez_de_jogar){
                vez_de_jogar = false;
            }
            else{
                vez_de_jogar = true;
            }
        }

        else if(verificar_comer_de_novo(linha,coluna,vez) == true){
            System.out.println("DEtectado que essa pedra pode comer ainda.......");
            if(vez == 2 || vez == 20){
                vez_de_jogar = true;
                System.out.println("Jogador 2 pode comer de novo so atque = true\n");
            }
            else if(vez == 3 || vez == 30){
                vez_de_jogar = false;
                System.out.println("Jogador 3 pode comer de novo so atque = true\n");
            }
            else{
                System.out.println("Vez nao achada.. condicao mais pra irrelevante\n");
                so_ataque = false;
            }
        }
        else{
            if(vez_de_jogar){
                vez_de_jogar = false;
            }
            else{
                vez_de_jogar = true;
            }
        }

        System.out.println("Valor da vez : "+vez_de_jogar);
        System.out.println("Valor do atque : "+so_ataque);
        atualizar_tabuleiro();
    }





    //primeira linha de botoes ok

    public void botao1(){
        if( matriz[0][0] == 2 && vez_de_jogar){ //tingir e habilitar botao de ir
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,0,2);
            verificarAtaque(0,0,2);
            lvelha = 0;
            cvelha = 0;
            anterior = 2;
        }

        if( matriz[0][0] == 20 && vez_de_jogar){ //tingir e habilitar botao de ir !!!!!!!!!!!!!!!!!!!
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,0,20);
            verificarAtaque(0,0,20);
            lvelha = 0;
            cvelha = 0;
            anterior = 20;
        }

        if( matriz[0][0] == 3 && !vez_de_jogar){ //tingir e habilitar botao de ir
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,0,3);
            verificarAtaque(0,0,3);
            lvelha = 0;
            cvelha = 0;
            anterior = 3;
        }

        if( matriz[0][0] == 30 && !vez_de_jogar){ //tingir e habilitar botao de ir !!!!!!!!!!!!!!!!!!!
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,0,30);
            verificarAtaque(0,0,30);
            lvelha = 0;
            cvelha = 0;
            anterior = 30;
        }


        if(b.getVetor(0) == true){ //comer a peca

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 0){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(0,0,2);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(0,0,2);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 0){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(0,0,3);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(0,0,3);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,0,0,jd1_rainha);
                fim_jogada(0,0,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,0,0,jd2_rainha);
                fim_jogada(0,0,jd2_rainha);
            }



            atualizar_tabuleiro();
        }


        if(vetor[0] == true){ //movimento para a proxima casa
            if(anterior == 3){
                matriz[lvelha][cvelha] = 1;
                matriz[0][0] = 30;
                fim_jogada(0,0,100);
                atualizar_tabuleiro();
            }
            else {
                matriz[lvelha][cvelha] = 1;
                matriz[0][0] = anterior;
                fim_jogada(0,0,100);
                atualizar_tabuleiro();
            }
        }
    } //dama - ok
    public void botao3(){
        if( matriz[0][2] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,2,2);
            verificarAtaque(0,2,2);
            lvelha = 0;
            cvelha = 2;
            anterior = 2;
        }
        if( matriz[0][2] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,2,20);
            verificarAtaque(0,2,20);
            lvelha = 0;
            cvelha = 2;
            anterior = 20;
        }
        if( matriz[0][2] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,2,3);
            verificarAtaque(0,2,3);
            lvelha = 0;
            cvelha = 2;
            anterior = 3;
        }
        if( matriz[0][2] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,2,30);
            verificarAtaque(0,2,30);
            lvelha = 0;
            cvelha = 2;
            anterior = 30;
        }
        if(b.getVetor(1) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 2){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(0,2,2);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(0,2,2);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 2){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(0,2,3);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(0,2,3);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,0,2,jd1_rainha);
                fim_jogada(0,2,20);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,0,2,jd2_rainha);
                fim_jogada(0,2,30);
            }

            atualizar_tabuleiro();
        }
        if(vetor[1] == true){
            if(anterior == 3){
                matriz[lvelha][cvelha] = 1;
                matriz[0][2] = 30;
                fim_jogada(0,0,100);
                atualizar_tabuleiro();
            }
            else {
                matriz[lvelha][cvelha] = 1;
                matriz[0][2] = anterior;
                fim_jogada(0,0,100);
                atualizar_tabuleiro();
            }
        }
    } //dama - ok

    public void botao5(){
        if( matriz[0][4] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,4,2);
            verificarAtaque(0,4,2);
            lvelha = 0;
            cvelha = 4;
            anterior = 2;
        }
        if( matriz[0][4] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,4,20);
            verificarAtaque(0,4,20);
            lvelha = 0;
            cvelha = 4;
            anterior = 20;
        }
        if( matriz[0][4] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,4,3);
            verificarAtaque(0,4,3);
            lvelha = 0;
            cvelha = 4;
            anterior = 3;
        }
        if( matriz[0][4] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,4,30);
            verificarAtaque(0,4,30);
            lvelha = 0;
            cvelha = 4;
            anterior = 30;
        }

        if(b.getVetor(2) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 4){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(0,4,jd1);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(0,4,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 4){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(0,4,jd2);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(0,4,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,0,4,jd1_rainha);
                fim_jogada(0,4,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,0,4,jd2_rainha);
                fim_jogada(0,4,jd2_rainha);
            }


            atualizar_tabuleiro();
        }


        if(vetor[2] == true){
            if(anterior == 3){
                matriz[lvelha][cvelha] = 1;
                matriz[0][4] = 30;
                fim_jogada(0,4,100);
                atualizar_tabuleiro();
            }
            else {
                matriz[lvelha][cvelha] = 1;
                matriz[0][4] = anterior;
                fim_jogada(0,4,100);
                atualizar_tabuleiro();
            }
        }
    } //dama - ok
    public void botao7(){
        if( matriz[0][6] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,6,2);
            verificarAtaque(0,6,2);
            lvelha = 0;
            cvelha = 6;
            anterior = 2;
        }
        if( matriz[0][6] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,6,20);
            verificarAtaque(0,6,20);
            lvelha = 0;
            cvelha = 6;
            anterior = 20;
        }
        if( matriz[0][6] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,6,3);
            verificarAtaque(0,6,3);
            lvelha = 0;
            cvelha = 6;
            anterior = 3;
        }
        if( matriz[0][6] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(0,6,30);
            verificarAtaque(0,6,30);
            lvelha = 0;
            cvelha = 6;
            anterior = 30;
        } //jogadas ok

        if(b.getVetor(3) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 6){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(0,6,jd1);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(0,6,jd1);
                }
            }


            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 6){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(0,6,jd2);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(0,6,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,0,6,jd1_rainha);
                fim_jogada(0,6,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,0,6,jd2_rainha);
                fim_jogada(0,6,jd2_rainha);
            }

            System.out.println("Anterior : "+anterior);

            atualizar_tabuleiro();
        }

        if(vetor[3] == true){
            if(anterior == 3){
                matriz[lvelha][cvelha] = 1;
                matriz[0][6] = 30;
                fim_jogada(0,0,100);
                atualizar_tabuleiro();
            }
            else {
                matriz[lvelha][cvelha] = 1;
                matriz[0][6] = anterior;
                fim_jogada(0,6,100);
                atualizar_tabuleiro();
            }
        }
    } //dama - ok 3.0

    //segunda linha de botoes ok f

    public void botao10(){
        if( matriz[1][1] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,1,2);
            verificarAtaque(1,1,2);
            lvelha = 1;
            cvelha = 1;
            anterior = 2;
        }
        if( matriz[1][1] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,1,20);
            verificarAtaque(1,1,20);
            lvelha = 1;
            cvelha = 1;
            anterior = 20;
        }
        if( matriz[1][1] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,1,3);
            verificarAtaque(1,1,3);
            lvelha = 1;
            cvelha = 1;
            anterior = 3;
        }
        if( matriz[1][1] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,1,30);
            verificarAtaque(1,1,30);
            lvelha = 1;
            cvelha = 1;
            anterior = 30;
        }

        if(b.getVetor(4) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 1){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(1,1,jd1);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(1,1,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 1){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(1,1,jd2);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(1,1,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,1,1,jd1_rainha);
                fim_jogada(1,1,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,1,1,jd2_rainha);
                fim_jogada(1,1,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[4] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[1][1] = anterior;
            fim_jogada(1,1,100);
            atualizar_tabuleiro();
        }
    } //dama - ok 3.0
    public void botao12(){
        if( matriz[1][3] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,3,2);
            verificarAtaque(1,3,2);
            lvelha = 1;
            cvelha = 3;
            anterior = 2;
        }
        if( matriz[1][3] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,3,20);
            verificarAtaque(1,3,20);
            lvelha = 1;
            cvelha = 3;
            anterior = 20;
        }
        if( matriz[1][3] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,3,3);
            verificarAtaque(1,3,3);
            lvelha = 1;
            cvelha = 3;
            anterior = 3;
        }

        if( matriz[1][3] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,3,30);
            verificarAtaque(1,3,30);
            lvelha = 1;
            cvelha = 3;
            anterior = 30;
        }

        if(b.getVetor(5) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 3){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(1,3,jd1);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(1,3,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 3){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(1,3,jd2);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(1,3,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,1,3,jd1_rainha);
                fim_jogada(1,3,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,1,3,jd2_rainha);
                fim_jogada(1,3,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[5] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[1][3] = anterior;
            fim_jogada(1,3,100);
            atualizar_tabuleiro();
        }
    } //dama - ok 3.0

    public void botao14(){
        if( matriz[1][5] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,5,2);
            verificarAtaque(1,5,2);
            lvelha = 1;
            cvelha = 5;
            anterior = 2;
        }
        if( matriz[1][5] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,5,20);
            verificarAtaque(1,5,20);
            lvelha = 1;
            cvelha = 5;
            anterior = 20;
        }
        if( matriz[1][5] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,5,3);
            verificarAtaque(1,5,3);
            lvelha = 1;
            cvelha = 5;
            anterior = 3;
        }

        if( matriz[1][5] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,5,30);
            verificarAtaque(1,5,30);
            lvelha = 1;
            cvelha = 5;
            anterior = 30;
        }

        if(b.getVetor(6) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 5){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(1,5,jd1);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(1,5,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 5){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(1,5,jd2);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(1,5,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,1,5,jd1_rainha);
                fim_jogada(1,5,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,1,5,jd2_rainha);
                fim_jogada(1,5,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[6] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[1][5] = anterior;
            fim_jogada(1,5,100);
            atualizar_tabuleiro();
        }
    } //dama - ok 3.0
    public void botao16(){
        if( matriz[1][7] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,7,2);
            verificarAtaque(1,7,2);
            lvelha = 1;
            cvelha = 7;
            anterior = 2;
        }
        if( matriz[1][7] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,7,20);
            verificarAtaque(1,7,20);
            lvelha = 1;
            cvelha = 7;
            anterior = 20;
        }
        if( matriz[1][7] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,7,3);
            verificarAtaque(1,7,3);
            lvelha = 1;
            cvelha = 7;
            anterior = 3;
        }
        if( matriz[1][7] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(1,7,30);
            verificarAtaque(1,7,30);
            lvelha = 1;
            cvelha = 7;
            anterior = 30;
        }
        if(b.getVetor(7) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 7){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(1,7,jd1);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(1,7,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 7){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(1,7,jd2);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(1,7,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,1,7,jd1_rainha);
                fim_jogada(1,7,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,1,7,jd2_rainha);
                fim_jogada(1,7,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[7] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[1][7] = anterior;
            fim_jogada(1,7,100);
            atualizar_tabuleiro();
        }
    } //dama - ok - ok dama comer 3.0

    //terceira linha de botoes ok f

    public void botao17(){
        if( matriz[2][0] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,0,2);
            verificarAtaque(2,0,2);
            lvelha = 2;
            cvelha = 0;
            anterior = 2;
        }
        if( matriz[2][0] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,0,20);
            verificarAtaque(2,0,20);
            lvelha = 2;
            cvelha = 0;
            anterior = 20;
        }
        if( matriz[2][0] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,0,3);
            verificarAtaque(2,0,3);
            lvelha = 2;
            cvelha = 0;
            anterior = 3;
        }
        if( matriz[2][0] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,0,30);
            verificarAtaque(2,0,30);
            lvelha = 2;
            cvelha = 0;
            anterior = 30;
        }

        if(b.getVetor(8) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 0){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(2,0,jd1);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(2,0,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 0){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(2,0,jd2);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(2,0,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,2,0,jd1_rainha);
                fim_jogada(2,0,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,2,0,jd2_rainha);
                fim_jogada(2,0,jd2_rainha);
            }


            atualizar_tabuleiro();
        }
        if(vetor[8] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[2][0] = anterior;
            fim_jogada(2,0,100);
            atualizar_tabuleiro();

        }
    } //dama - ok 3.0
    public void botao19(){
        if( matriz[2][2] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,2,2);
            verificarAtaque(2,2,2);
            lvelha = 2;
            cvelha = 2;
            anterior = 2;
        }
        if( matriz[2][2] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,2,20);
            verificarAtaque(2,2,20);
            lvelha = 2;
            cvelha = 2;
            anterior = 20;
        }
        if( matriz[2][2] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,2,3);
            verificarAtaque(2,2,3);
            lvelha = 2;
            cvelha = 2;
            anterior = 3;
        }
        if( matriz[2][2] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,2,30);
            verificarAtaque(2,2,30);
            lvelha = 2;
            cvelha = 2;
            anterior = 30;
        }

        if(b.getVetor(9) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 2){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(2,2,jd1);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(2,2,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 2){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(2,2,jd2);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(2,2,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,2,2,jd1_rainha);
                fim_jogada(2,2,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,2,2,jd2_rainha);
                fim_jogada(2,2,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[9] == true){

            matriz[lvelha][cvelha] = 1;
            matriz[2][2] = anterior;
            fim_jogada(2,2,100);
            atualizar_tabuleiro();
        }
    } //dama - ok

    public void botao21(){
        if( matriz[2][4] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,4,2);
            verificarAtaque(2,4,2);
            lvelha = 2;
            cvelha = 4;
            anterior = 2;
        }
        if( matriz[2][4] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,4,20);
            verificarAtaque(2,4,20);
            lvelha = 2;
            cvelha = 4;
            anterior = 20;
        }
        if( matriz[2][4] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,4,3);
            verificarAtaque(2,4,3);
            lvelha = 2;
            cvelha = 4;
            anterior = 3;
        }
        if( matriz[2][4] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,4,30);
            verificarAtaque(2,4,30);
            lvelha = 2;
            cvelha = 4;
            anterior = 30;
        }
        if(b.getVetor(10) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 4){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(2,4,jd1);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(2,4,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 4){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(2,4,jd2);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(2,4,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,2,4,jd1_rainha);
                fim_jogada(2,4,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,2,4,jd2_rainha);
                fim_jogada(2,4,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[10] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[2][4] = anterior;
            fim_jogada(2,4,100);
            atualizar_tabuleiro();
        }
    } //dama - ok
    public void botao23(){
        if( matriz[2][6] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,6,2);
            verificarAtaque(2,6,2);
            lvelha = 2;
            cvelha = 6;
            anterior = 2;
        }
        if( matriz[2][6] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,6,20);
            verificarAtaque(2,6,20);
            lvelha = 2;
            cvelha = 6;
            anterior = 20;
        }
        if( matriz[2][6] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,6,3);
            verificarAtaque(2,6,3);
            lvelha = 2;
            cvelha = 6;
            anterior = 3;
        }
        if( matriz[2][6] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(2,6,30);
            verificarAtaque(2,6,30);
            lvelha = 2;
            cvelha = 6;
            anterior = 30;
        }
        if(b.getVetor(11) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 6){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(2,6,jd1);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(2,6,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 6){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(2,6,jd2);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(2,6,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,2,6,jd1_rainha);
                fim_jogada(2,6,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,2,6,jd2_rainha);
                fim_jogada(2,6,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[11] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[2][6] = anterior;
            fim_jogada(2,6,100);
            atualizar_tabuleiro();
        }
    } //dama - ok - ok dama ja come 3.0

    //quarta linha de botoes ok

    public void botao26(){
        if( matriz[3][1] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,1,2);
            verificarAtaque(3,1,2);
            lvelha = 3;
            cvelha = 1;
            anterior = 2;
        }
        if( matriz[3][1] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,1,20);
            verificarAtaque(3,1,20);
            lvelha = 3;
            cvelha = 1;
            anterior = 20;
        }
        if( matriz[3][1] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,1,3);
            verificarAtaque(3,1,3);
            lvelha = 3;
            cvelha = 1;
            anterior = 3;
        }
        if( matriz[3][1] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,1,30);
            verificarAtaque(3,1,30);
            lvelha = 3;
            cvelha = 1;
            anterior = 30;
        }
        if(b.getVetor(12) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 1){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(3,1,jd1);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(3,1,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 1){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(3,1,jd2);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(3,1,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,3,1,jd1_rainha);
                fim_jogada(3,1,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,3,1,jd2_rainha);
                fim_jogada(3,1,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[12] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[3][1] = anterior;
            fim_jogada(3,1,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0
    public void botao28(){
        if( matriz[3][3] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,3,2);
            verificarAtaque(3,3,2);
            lvelha = 3;
            cvelha = 3;
            anterior = 2;
        }
        if( matriz[3][3] == 20 && vez_de_jogar) {
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,3,20);
            verificarAtaque(3,3,20);
            lvelha = 3;
            cvelha = 3;
            anterior = 20;
        }
        if( matriz[3][3] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,3,3);
            verificarAtaque(3,3,3);
            lvelha = 3;
            cvelha = 3;
            anterior = 3;
        }
        if( matriz[3][3] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,3,30);
            verificarAtaque(3,3,30);
            lvelha = 3;
            cvelha = 3;
            anterior = 30;
        }


        if(b.getVetor(13) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 3){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(3,3,jd1);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(3,3,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 3){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(3,3,jd2);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(3,3,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,3,3,jd1_rainha);
                fim_jogada(3,3,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,3,3,jd2_rainha);
                fim_jogada(3,3,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[13] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[3][3] = anterior;
            fim_jogada(3,3,100);
            atualizar_tabuleiro();
        }
    } //dama ok

    public void botao30(){
        if( matriz[3][5] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,5,2);
            verificarAtaque(3,5,2);
            lvelha = 3;
            cvelha = 5;
            anterior = 2;
        }
        if( matriz[3][5] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,5,20);
            verificarAtaque(3,5,20);
            lvelha = 3;
            cvelha = 5;
            anterior = 20;
        }
        if( matriz[3][5] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,5,3);
            verificarAtaque(3,5,3);
            lvelha = 3;
            cvelha = 5;
            anterior = 3;
        }
        if( matriz[3][5] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,5,30);
            verificarAtaque(3,5,30);
            lvelha = 3;
            cvelha = 5;
            anterior = 30;
        }
        if(b.getVetor(14) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 5){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(3,5,jd1);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(3,5,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 5){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(3,5,jd2);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(3,5,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,3,5,jd1_rainha);
                fim_jogada(3,5,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,3,5,jd2_rainha);
                fim_jogada(3,5,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[14] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[3][5] = anterior;
            fim_jogada(3,5,100);
            atualizar_tabuleiro();
        }
    } //dama - ok
    public void botao32(){
        if( matriz[3][7] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,7,2);
            verificarAtaque(3,7,2);
            lvelha = 3;
            cvelha = 7;
            anterior = 2;
        }
        if( matriz[3][7] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,7,20);
            verificarAtaque(3,7,20);
            lvelha = 3;
            cvelha = 7;
            anterior = 20;
        }
        if( matriz[3][7] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,7,3);
            verificarAtaque(3,7,3);
            lvelha = 3;
            cvelha = 7;
            anterior = 3;
        }
        if( matriz[3][7] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(3,7,30);
            verificarAtaque(3,7,30);
            lvelha = 3;
            cvelha = 7;
            anterior = 30;
        }
        if(b.getVetor(15) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 7){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(3,7,jd1);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(3,7,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 7){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(3,7,jd2);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(3,7,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,3,7,jd1_rainha);
                fim_jogada(3,7,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,3,7,jd2_rainha);
                fim_jogada(3,7,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[15] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[3][7] = anterior;
            fim_jogada(3,7,100);
            atualizar_tabuleiro();
        }
    } //dama - ok - dma come jah 3.0

    //5 - quinta linha de botoes ok

    public void botao33(){
        if( matriz[4][0] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,0,2);
            verificarAtaque(4,0,2);
            lvelha = 4;
            cvelha = 0;
            anterior = 2;
        }
        if( matriz[4][0] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,0,20);
            verificarAtaque(4,0,20);
            lvelha = 4;
            cvelha = 0;
            anterior = 20;
        }
        if( matriz[4][0] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,0,3);
            verificarAtaque(4,0,3);
            lvelha = 4;
            cvelha = 0;
            anterior = 3;
        }
        if( matriz[4][0] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,0,30);
            verificarAtaque(4,0,30);
            lvelha = 4;
            cvelha = 0;
            anterior = 30;
        }
        if(b.getVetor(16) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 0){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(4,0,jd1);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(4,0,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 0){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(4,0,jd2);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(4,0,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,4,0,jd1_rainha);
                fim_jogada(4,0,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,4,0,jd2_rainha);
                fim_jogada(4,0,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[16] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[4][0] = anterior;
            fim_jogada(4,0,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0
    public void botao35(){
        if( matriz[4][2] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,2,2);
            verificarAtaque(4,2,2);
            lvelha = 4;
            cvelha = 2;
            anterior = 2;
        }
        if( matriz[4][2] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,2,20);
            verificarAtaque(4,2,20);
            lvelha = 4;
            cvelha = 2;
            anterior = 20;
        }
        if( matriz[4][2] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,2,3);
            verificarAtaque(4,2,3);
            lvelha = 4;
            cvelha = 2;
            anterior = 3;
        }
        if( matriz[4][2] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,2,30);
            verificarAtaque(4,2,30);
            lvelha = 4;
            cvelha = 2;
            anterior = 30;
        }
        if(b.getVetor(17) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 2){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(4,2,jd1);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(4,2,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 2){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(4,2,jd2);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(4,2,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,4,2,jd1_rainha);
                fim_jogada(4,2,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,4,2,jd2_rainha);
                fim_jogada(4,2,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[17] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[4][2] = anterior;
            fim_jogada(4,2,100);
            atualizar_tabuleiro();
        }
    } //dama ok

    public void botao37(){
        if( matriz[4][4] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,4,2);
            verificarAtaque(4,4,2);
            lvelha = 4;
            cvelha = 4;
            anterior = 2;
        }
        if( matriz[4][4] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,4,20);
            verificarAtaque(4,4,20);
            lvelha = 4;
            cvelha = 4;
            anterior = 20;
        }
        if( matriz[4][4] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,4,3);
            verificarAtaque(4,4,3);
            lvelha = 4;
            cvelha = 4;
            anterior = 3;
        }
        if( matriz[4][4] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,4,30);
            verificarAtaque(4,4,30);
            lvelha = 4;
            cvelha = 4;
            anterior = 30;
        }
        if(b.getVetor(18) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 4){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(4,4,jd1);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(4,4,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 4){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(4,4,jd2);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(4,4,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,4,4,jd1_rainha);
                fim_jogada(4,4,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,4,4,jd2_rainha);
                fim_jogada(4,4,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[18] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[4][4] = anterior;
            fim_jogada(4,4,100);
            atualizar_tabuleiro();
        }
    } //dama ok
    public void botao39(){
        if( matriz[4][6] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,6,2);
            verificarAtaque(4,6,2);
            lvelha = 4;
            cvelha = 6;
            anterior = 2;
        }
        if( matriz[4][6] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,6,20);
            verificarAtaque(4,6,20);
            lvelha = 4;
            cvelha = 6;
            anterior = 20;
        }
        if( matriz[4][6] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,6,3);
            verificarAtaque(4,6,3);
            lvelha = 4;
            cvelha = 6;
            anterior = 3;
        }
        if( matriz[4][6] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(4,6,30);
            verificarAtaque(4,6,30);
            lvelha = 4;
            cvelha = 6;
            anterior = 30;
        }
        if(b.getVetor(19) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 6){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(4,6,jd1);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(4,6,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 6){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(4,6,jd2);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(4,6,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,4,6,jd1_rainha);
                fim_jogada(4,6,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,4,6,jd2_rainha);
                fim_jogada(4,6,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[19] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[4][6] = anterior;
            fim_jogada(4,6,100);
            atualizar_tabuleiro();
        }
    } //dama ok - 3.0 dma ja come

    //6 - sexta linha de botoes ok

    public void botao42(){
        if( matriz[5][1] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,1,2);
            verificarAtaque(5,1,2);
            lvelha = 5;
            cvelha = 1;
            anterior = 2;
        }
        if( matriz[5][1] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,1,20);
            verificarAtaque(5,1,20);
            lvelha = 5;
            cvelha = 1;
            anterior = 20;
        }

        if( matriz[5][1] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,1,3);
            verificarAtaque(5,1,3);
            lvelha = 5;
            cvelha = 1;
            anterior = 3;
        }
        if( matriz[5][1] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,1,30);
            verificarAtaque(5,1,30);
            lvelha = 5;
            cvelha = 1;
            anterior = 30;
        }
        if(b.getVetor(20) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 1){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(5,1,jd1);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(5,1,jd1); //----------------bug
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 1){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(5,1,jd2);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(5,1,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,5,1,jd1_rainha);
                fim_jogada(5,1,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,5,1,jd2_rainha);
                fim_jogada(5,1,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[20] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[5][1] = anterior;
            fim_jogada(5,1,100);
            atualizar_tabuleiro();
        }
    }  //dama ok 3.0
    public void botao44(){
        if( matriz[5][3] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,3,2);
            verificarAtaque(5,3,2);
            lvelha = 5;
            cvelha = 3;
            anterior = 2;
        }
        if( matriz[5][3] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,3,20);
            verificarAtaque(5,3,20);
            lvelha = 5;
            cvelha = 3;
            anterior = 20;
        }

        if( matriz[5][3] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,3,3);
            verificarAtaque(5,3,3);
            lvelha = 5;
            cvelha = 3;
            anterior = 3;
        }

        if( matriz[5][3] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,3,30);
            verificarAtaque(5,3,30);
            lvelha = 5;
            cvelha = 3;
            anterior = 30;
        }
        if(b.getVetor(21) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 3){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(5,3,jd1);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(5,3,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 3){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(5,3,jd2);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(5,3,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,5,3,jd1_rainha);
                fim_jogada(5,3,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,5,3,jd2_rainha);
                fim_jogada(5,3,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[21] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[5][3] = anterior;
            fim_jogada(5,3,100);
            atualizar_tabuleiro();
        }
    }  //dama ok 3.0

    public void botao46(){
        if( matriz[5][5] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,5,2);
            verificarAtaque(5,5,2);
            lvelha = 5;
            cvelha = 5;
            anterior = 2;
        }
        if( matriz[5][5] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,5,20);
            verificarAtaque(5,5,20);
            lvelha = 5;
            cvelha = 5;
            anterior = 20;
        }

        if( matriz[5][5] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,5,3);
            verificarAtaque(5,5,3);
            lvelha = 5;
            cvelha = 5;
            anterior = 3;
        }
        if( matriz[5][5] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,5,30);
            verificarAtaque(5,5,30);
            lvelha = 5;
            cvelha = 5;
            anterior = 30;
        }
        if(b.getVetor(22) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 5){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(5,5,jd1);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(5,5,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 5){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(5,5,jd2);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(5,5,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,5,5,jd1_rainha);
                fim_jogada(5,5,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,5,5,jd2_rainha);
                fim_jogada(5,5,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[22] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[5][5] = anterior;
            fim_jogada(5,5,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0
    public void botao48(){
        if( matriz[5][7] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,7,2);
            verificarAtaque(5,7,2);
            lvelha = 5;
            cvelha = 7;
            anterior = 2;
        }
        if( matriz[5][7] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,7,20);
            verificarAtaque(5,7,20);
            lvelha = 5;
            cvelha = 7;
            anterior = 20;
        }

        if( matriz[5][7] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,7,3);
            verificarAtaque(5,7,3);
            lvelha = 5;
            cvelha = 7;
            anterior = 3;
        }
        if( matriz[5][7] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(5,7,30);
            verificarAtaque(5,7,30);
            lvelha = 5;
            cvelha = 7;
            anterior = 30;
        }

        if(b.getVetor(23) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 7){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(5,7,jd1);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(5,7,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 7){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(5,7,jd2);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(5,7,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,5,7,jd1_rainha);
                fim_jogada(5,7,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,5,7,jd2_rainha);
                fim_jogada(5,7,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[23] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[5][7] = anterior;
            fim_jogada(5,7,100);
            atualizar_tabuleiro();
        }
    } //dama ok - dma ja come 3.0

    //7 - setima linha de botoes ok

    public void botao49(){
        if( matriz[6][0] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,0,2);
            verificarAtaque(6,0,2);
            lvelha = 6;
            cvelha = 0;
            anterior = 2;
        }
        if( matriz[6][0] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,0,20);
            verificarAtaque(6,0,20);
            lvelha = 6;
            cvelha = 0;
            anterior = 20;
        }

        if( matriz[6][0] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,0,3);
            verificarAtaque(6,0,3);
            lvelha = 6;
            cvelha = 0;
            anterior = 3;
        }
        if( matriz[6][0] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,0,30);
            verificarAtaque(6,0,30);
            lvelha = 6;
            cvelha = 0;
            anterior = 30;
        }

        if(b.getVetor(24) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 0){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(6,0,jd1);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(6,0,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 0){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(6,0,jd2);
                }
                if(cvelha > 0){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(6,0,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,6,0,jd1_rainha);
                fim_jogada(6,0,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,6,0,jd2_rainha);
                fim_jogada(6,0,jd1_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[24] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[6][0] = anterior;
            fim_jogada(6,0,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0
    public void botao51(){
        if( matriz[6][2] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,2,2);
            verificarAtaque(6,2,2);
            lvelha = 6;
            cvelha = 2;
            anterior = 2;
        }
        if( matriz[6][2] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,2,20);
            verificarAtaque(6,2,20);
            lvelha = 6;
            cvelha = 2;
            anterior = 20;
        }

        if( matriz[6][2] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,2,3);
            verificarAtaque(6,2,3);
            lvelha = 6;
            cvelha = 2;
            anterior = 3;
        }

        if( matriz[6][2] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,2,30);
            verificarAtaque(6,2,30);
            lvelha = 6;
            cvelha = 2;
            anterior = 30;
        }

        if(b.getVetor(25) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 2){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(6,2,jd1);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(6,2,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 2){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(6,2,jd2);
                }
                if(cvelha > 2){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(6,2,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,6,2,jd1_rainha);
                fim_jogada(6,2,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,6,2,jd2_rainha);
                fim_jogada(6,2,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[25] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[6][2] = anterior;
            fim_jogada(6,2,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0

    public void botao53(){
        if( matriz[6][4] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,4,2);
            verificarAtaque(6,4,2);
            lvelha = 6;
            cvelha = 4;
            anterior = 2;
        }
        if( matriz[6][4] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,4,20);
            verificarAtaque(6,4,20);
            lvelha = 6;
            cvelha = 4;
            anterior = 20;
        }

        if( matriz[6][4] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,4,3);
            verificarAtaque(6,4,3);
            lvelha = 6;
            cvelha = 4;
            anterior = 3;
        }
        if( matriz[6][4] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,4,30);
            verificarAtaque(6,4,30);
            lvelha = 6;
            cvelha = 4;
            anterior = 30;
        }

        if(b.getVetor(26) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 4){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(6,4,jd1);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(6,4,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 4){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(6,4,jd2);
                }
                if(cvelha > 4){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(6,4,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,6,4,jd1_rainha);
                fim_jogada(6,4,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,6,4,jd2_rainha);
                fim_jogada(6,4,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[26] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[6][4] = anterior;
            fim_jogada(6,4,100);
            atualizar_tabuleiro();
        }
    } //dama ok 3.0
    public void botao55(){
        if( matriz[6][6] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,6,2);
            verificarAtaque(6,6,2);
            lvelha = 6;
            cvelha = 6;
            anterior = 2;
        }
        if( matriz[6][6] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,6,20);
            verificarAtaque(6,6,20);
            lvelha = 6;
            cvelha = 6;
            anterior = 20;
        }

        if( matriz[6][6] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,6,3);
            verificarAtaque(6,6,3);
            lvelha = 6;
            cvelha = 6;
            anterior = 3;
        }

        if( matriz[6][6] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(6,6,30);
            verificarAtaque(6,6,30);
            lvelha = 6;
            cvelha = 6;
            anterior = 30;
        }

        if(b.getVetor(27) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 6){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(6,6,jd1);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(6,6,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 6){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(6,6,jd2);
                }
                if(cvelha > 6){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(6,6,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,6,6,jd1_rainha);
                fim_jogada(6,6,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,6,6,jd2_rainha);
                fim_jogada(6,6,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[27] == true){
            matriz[lvelha][cvelha] = 1;
            matriz[6][6] = anterior;
            fim_jogada(6,6,100);
            atualizar_tabuleiro();
        }
    } //dama ok - dama ok 3.0

    //8 - oitava linha de botoes ok

    public void botao58(){
        if( matriz[7][1] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,1,2);
            verificarAtaque(7,1,2);
            lvelha = 7;
            cvelha = 1;
            anterior = 2;
        }

        if( matriz[7][1] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,1,20);
            verificarAtaque(7,1,20);
            lvelha = 7;
            cvelha = 1;
            anterior = 20;
        }

        if( matriz[7][1] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,1,3);
            verificarAtaque(7,1,3);
            lvelha = 7;
            cvelha = 1;
            anterior = 3;
        }

        if( matriz[7][1] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,1,30);
            verificarAtaque(7,1,30);
            lvelha = 7;
            cvelha = 1;
            anterior = 30;
        }

        if(b.getVetor(28) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 1){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(7,1,jd1);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(7,1,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 1){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(7,1,jd2);
                }
                if(cvelha > 1){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(7,1,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,7,1,jd1_rainha);
                fim_jogada(7,1,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,7,1,jd2_rainha);
                fim_jogada(7,1,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[28] == true){
            if(anterior == 2){
                matriz[lvelha][cvelha] = 1;
                matriz[7][1] = 20;
                fim_jogada(7,1,100);
                atualizar_tabuleiro();
            }
            else {
                matriz[lvelha][cvelha] = 1;
                matriz[7][1] = anterior;
                fim_jogada(7,1,100);
                atualizar_tabuleiro();
            }
        }
    } //dama ok 3.0
    public void botao60(){
        if( matriz[7][3] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,3,2);
            verificarAtaque(7,3,2);
            lvelha = 7;
            cvelha = 3;
            anterior = 2;
        }

        if( matriz[7][3] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,3,20);
            verificarAtaque(7,3,20);
            lvelha = 7;
            cvelha = 3;
            anterior = 20;
        }

        if( matriz[7][3] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,3,3);
            verificarAtaque(7,3,3);
            lvelha = 7;
            cvelha = 3;
            anterior = 3;
        }

        if( matriz[7][3] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,3,30);
            verificarAtaque(7,3,30);
            lvelha = 7;
            cvelha = 3;
            anterior = 30;
        }

        if(b.getVetor(29) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 3){ //vai para dir
                    come_dir_baixo(lvelha,cvelha);fim_jogada(7,3,jd1);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(7,3,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 3){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(7,3,jd2);
                }
                if(cvelha > 3){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(7,3,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,7,3,jd1_rainha);
                fim_jogada(7,3,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,7,3,jd2_rainha);
                fim_jogada(7,3,jd2_rainha);
            }

            atualizar_tabuleiro();
        }
        if(vetor[29] == true){
            if(anterior == 2){
                matriz[lvelha][cvelha] = 1;
                matriz[7][3] = 20;
                fim_jogada(7,3,100);
                atualizar_tabuleiro();
            }else {
                matriz[lvelha][cvelha] = 1;
                matriz[7][3] = anterior;
                fim_jogada(7,3,100);
                atualizar_tabuleiro();
            }
        }
    } //dama ok 3.0

    public void botao62(){
        if( matriz[7][5] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,5,2);
            verificarAtaque(7,5,2);
            lvelha = 7;
            cvelha = 5;
            anterior = 2;
        }

        if( matriz[7][5] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,5,20);
            verificarAtaque(7,5,20);
            lvelha = 7;
            cvelha = 5;
            anterior = 20;
        }

        if( matriz[7][5] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,5,3);
            verificarAtaque(7,5,3);
            lvelha = 7;
            cvelha = 5;
            anterior = 3;
        }

        if( matriz[7][5] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,5,30);
            verificarAtaque(7,5,30);
            lvelha = 7;
            cvelha = 5;
            anterior = 30;
        }

        if(b.getVetor(30) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 5){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(7,5,jd1);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(7,5,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 5){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(7,5,jd2);
                }
                if(cvelha > 5){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(7,5,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,7,5,jd1_rainha);
                fim_jogada(7,5,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,7,5,jd2_rainha);
                fim_jogada(7,5,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

        if(vetor[30] == true){
            if(anterior == 2){
                matriz[lvelha][cvelha] = 1;
                matriz[7][5] = 20;
                fim_jogada(7,5,100);
                atualizar_tabuleiro();
            }else {
                matriz[lvelha][cvelha] = 1;
                matriz[7][5] = anterior;
                fim_jogada(7,5,100);
                atualizar_tabuleiro();
            }
        }
    } //dama ok 3.0
    public void botao64(){

        if( matriz[7][7] == 2 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,7,2);
            verificarAtaque(7,7,2);
            lvelha = 7;
            cvelha = 7;
            anterior = 2;
        }

        if( matriz[7][7] == 20 && vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,7,20);
            verificarAtaque(7,7,20);
            lvelha = 7;
            cvelha = 7;
            anterior = 20;
        }

        if( matriz[7][7] == 3 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,7,3);
            verificarAtaque(7,7,3);
            lvelha = 7;
            cvelha = 7;
            anterior = 3;
        }
        if( matriz[7][7] == 30 && !vez_de_jogar){
            inicializa_vetor();
            b.zerarVetor();
            Status_pecas(7,7,30);
            verificarAtaque(7,7,30);
            lvelha = 7;
            cvelha = 7;
            anterior = 30;
        }
        if(b.getVetor(31) == true){

            if(anterior == jd1){ //for baixo -- ignora linha -- jd1
                if(cvelha < 7){ //vai para dir
                    come_dir_baixo(lvelha,cvelha); fim_jogada(7,7,jd1);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_baixo(lvelha,cvelha); fim_jogada(7,7,jd1);
                }
            }

            if(anterior == jd2){ //for cima -- ignora linha -- jd2
                if(cvelha < 7){ //vai para dir
                    come_dir_cima(lvelha,cvelha); fim_jogada(7,7,jd2);
                }
                if(cvelha > 7){ //vai para esq
                    come_esq_cima(lvelha,cvelha); fim_jogada(7,7,jd2);
                }
            }

            if(anterior == jd1_rainha){
                direcao_ataque(lvelha,cvelha,7,7,jd1_rainha);
                fim_jogada(7,7,jd1_rainha);
            }

            if(anterior == jd2_rainha){
                direcao_ataque(lvelha,cvelha,7,7,jd2_rainha);
                fim_jogada(7,7,jd2_rainha);
            }

            atualizar_tabuleiro();
        }

//parte do botao que faz todo o movimento da peca
        if(vetor[31] == true){
            if(anterior == 2){
                matriz[lvelha][cvelha] = 1;
                matriz[7][7] = 20;
                fim_jogada(7,7,100);
                atualizar_tabuleiro();
            }else {
                matriz[lvelha][cvelha] = 1;
                matriz[7][7] = anterior;
                fim_jogada(7,7,100);
                atualizar_tabuleiro();
            }
        }
    } //dama ok - dma ja come 3.0


    @Override
    public void actionPerformed(ActionEvent e) {


        b.tingir_pretas();

//********** linha 0

        if (e.getSource() == b.bt1) {
            System.out.println("Clicado bt1");
            botao1();
        }

        if (e.getSource() == b.bt3) {
            System.out.println("Clicado bt3");
            botao3();
        }

        if (e.getSource() == b.bt5) {
            System.out.println("Clicado bt5");
            botao5();
        }

        if (e.getSource() == b.bt7) {
            System.out.println("Clicado bt7");
            botao7();
        }
//********** linha 1
        if (e.getSource() == b.bt10) {
            System.out.println("Clicado bt10");
            botao10();
        }

        if (e.getSource() == b.bt12) {
            System.out.println("Clicado bt12");
            botao12();
        }

        if (e.getSource() == b.bt14) {
            System.out.println("Clicado bt14");
            botao14();
        }

        if (e.getSource() == b.bt16) {
            System.out.println("Clicado bt16");
            botao16();
        }

        //********** linha 2

        if (e.getSource() == b.bt17) {
            System.out.println("Clicado bt17");
            botao17();
        }

        if (e.getSource() == b.bt19) {
            System.out.println("Clicado bt19");
            botao19();
        }

        if (e.getSource() == b.bt21) {
            System.out.println("Clicado bt21");
            botao21();
        }

        if (e.getSource() == b.bt23) {
            System.out.println("Clicado bt23");
            botao23();
        }

//********** linha 3 - linhas sem botoes inicialmente

        if (e.getSource() == b.bt26) {
            System.out.println("Clicado bt26");
            botao26();
        }

        if (e.getSource() == b.bt28) {
            System.out.println("Clicado bt28");
            botao28();
        }

        if (e.getSource() == b.bt30) {
            System.out.println("Clicado bt30");
            botao30();
        }

        if (e.getSource() == b.bt32) {
            System.out.println("Clicado bt32");
            botao32();
        }

//********** linha 4

        if (e.getSource() == b.bt33) {
            System.out.println("Clicado bt33");
            botao33();
        }

        if (e.getSource() == b.bt35) {
            System.out.println("Clicado bt35");
            botao35();
        }

        if (e.getSource() == b.bt37) {
            System.out.println("Clicado bt37");
            botao37();
        }

        if (e.getSource() == b.bt39) {
            System.out.println("Clicado bt39");
            botao39();
        }

        //********** linha 5

        if (e.getSource() == b.bt42) {
            System.out.println("Clicado bt42");
            botao42();
        }

        if (e.getSource() == b.bt44) {
            System.out.println("Clicado bt44");
            botao44();

        }

        if (e.getSource() == b.bt46) {
            System.out.println("Clicado bt46");
            botao46();
        }

        if (e.getSource() == b.bt48) {
            System.out.println("Clicado bt48");
            botao48();
        }

        //********** linha 6

        if (e.getSource() == b.bt49) {
            System.out.print("\nClicado bt49\n");
            botao49();
        }

        if (e.getSource() == b.bt51) {
            System.out.print("\nClicado bt51");
            botao51();
        }

        if (e.getSource() == b.bt53) {
            System.out.print("\nClicado bt53");
            botao53();
        }

        if (e.getSource() == b.bt55) {
            System.out.print("\nClicado bt55");
            botao55();
        }
        //********** linha 7

        if (e.getSource() == b.bt58) {
            System.out.print("\nClicado bt58");
            botao58();
        }

        if (e.getSource() == b.bt60) {
            System.out.print("\nClicado bt60");
            botao60();
        }

        if (e.getSource() == b.bt62) {
            System.out.print("\nClicado bt62");
            botao62();
        }

        if (e.getSource() == b.bt64) {
            System.out.print("\nClicado bt64");
            botao64();
        }
        mudar_label_jogador();
        quant_pecas();
        imprimirVetor();
        ImprimirMatriz();
        System.out.println("");

    }

    private void marcar_casas_validas(int linha, int coluna){

//linha 0
        if(linha == 0 && coluna == 0){
            b.bt1.setBackground(new Color(50,100,100));
            vetor[0] = true;//habilitando so o botao para ser movido
        }
        if(linha == 0 && coluna == 2){
            b.bt3.setBackground(new Color(50,100,100));
            vetor[1] = true;
        }
        if(linha == 0 && coluna == 4){
            b.bt5.setBackground(new Color(50,100,100));
            vetor[2] = true;
        }
        if(linha == 0 && coluna == 6){
            b.bt7.setBackground(new Color(50,100,100));
            vetor[3] = true;
        }
//linha 1
        if(linha == 1 && coluna == 1){
            b.bt10.setBackground(new Color(50,100,100));
            vetor[4] = true;
        }
        if(linha == 1 && coluna == 3){
            b.bt12.setBackground(new Color(50,100,100));
            vetor[5] = true;
        }
        if(linha == 1 && coluna == 5){
            b.bt14.setBackground(new Color(50,100,100));
            vetor[6] = true;
        }
        if(linha == 1 && coluna == 7){
            b.bt16.setBackground(new Color(50,100,100));
            vetor[7] = true;
        }
//linha 2
        if(linha == 2 && coluna == 0){
            b.bt17.setBackground(new Color(50,100,100));
            vetor[8] = true;
        }
        if(linha == 2 && coluna == 2){
            b.bt19.setBackground(new Color(50,100,100));
            vetor[9] = true;
        }
        if(linha == 2 && coluna == 4){
            b.bt21.setBackground(new Color(50,100,100));
            vetor[10] = true;
        }
        if(linha == 2 && coluna == 6){
            b.bt23.setBackground(new Color(50,100,100));
            vetor[11] = true;
        }
//linha 3
        if(linha == 3 && coluna == 1){
            b.bt26.setBackground(new Color(50,100,100));
            vetor[12] = true;
        }
        if(linha == 3 && coluna == 3){
            b.bt28.setBackground(new Color(50,100,100));
            vetor[13] = true;
        }
        if(linha == 3 && coluna == 5){
            b.bt30.setBackground(new Color(50,100,100));
            vetor[14] = true;
        }
        if(linha == 3 && coluna == 7){
            b.bt32.setBackground(new Color(50,100,100));
            vetor[15] = true;
        }
//linha 4
        if(linha == 4 && coluna == 0){
            b.bt33.setBackground(new Color(50,100,100));
            vetor[16] = true;
        }
        if(linha == 4 && coluna == 2){
            b.bt35.setBackground(new Color(50,100,100));
            vetor[17] = true;
        }
        if(linha == 4 && coluna == 4){
            b.bt37.setBackground(new Color(50,100,100));
            vetor[18] = true;
        }
        if(linha == 4 && coluna == 6){
            b.bt39.setBackground(new Color(50,100,100));
            vetor[19] = true;
        }
//linha 5
        if(linha == 5 && coluna == 1){
            b.bt42.setBackground(new Color(50,100,100));
            vetor[20] = true;
        }
        if(linha == 5 && coluna == 3){
            b.bt44.setBackground(new Color(50,100,100));
            vetor[21] = true;
        }
        if(linha == 5 && coluna == 5){
            b.bt46.setBackground(new Color(50,100,100));
            vetor[22] = true;
        }
        if(linha == 5 && coluna == 7){
            b.bt48.setBackground(new Color(50,100,100));
            vetor[23] = true;
        }
//linha 6
        if(linha == 6 && coluna == 0){
            b.bt49.setBackground(new Color(50,100,100));
            vetor[24] = true;
        }
        if(linha == 6 && coluna == 2){
            b.bt51.setBackground(new Color(50,100,100));
            vetor[25] = true;
        }
        if(linha == 6 && coluna == 4){
            b.bt53.setBackground(new Color(50,100,100));
            vetor[26] = true;
        }
        if(linha == 6 && coluna == 6){
            b.bt55.setBackground(new Color(50,100,100));
            vetor[27] = true;
        }
//linha 7
        if(linha == 7 && coluna == 1){
            b.bt58.setBackground(new Color(50,100,100));
            vetor[28] = true;
        }
        if(linha == 7 && coluna == 3){
            b.bt60.setBackground(new Color(50,100,100));
            vetor[29] = true;
        }
        if(linha == 7 && coluna == 5){
            b.bt62.setBackground(new Color(50,100,100));
            vetor[30] = true;
        }
        if(linha == 7 && coluna == 7){
            b.bt64.setBackground(new Color(50,100,100));
            vetor[31] = true;
        }

    }

    //jogador = 2

    private void come_esq_baixo(int linha,int coluna){

        if(linha+2 == 7 && matriz[linha][coluna] == 2){
            //virou rainha comendo
            matriz[linha+2][coluna-2] = 20;
            matriz[linha+1][coluna-1] = 1;
            matriz[linha][coluna] = 1;
        }else{
            matriz[linha+2][coluna-2] = 2;
            matriz[linha+1][coluna-1] = 1;
            matriz[linha][coluna] = 1;
            verificarAtaque(linha+2,coluna-2,jd1);
        }
    }
    private void come_dir_baixo(int linha,int coluna){
        if(linha+2 == 7 && matriz[linha][coluna] == 2){
            matriz[linha + 2][coluna + 2] = 20;
            matriz[linha + 1][coluna + 1] = 1;
            matriz[linha][coluna] = 1;
            //virou rainha comendo
        }else {
            matriz[linha + 2][coluna + 2] = 2;
            matriz[linha + 1][coluna + 1] = 1;
            matriz[linha][coluna] = 1;
            verificarAtaque(linha + 2, coluna + 2, jd1);
        }
    }

    //jogador = 3

    private void come_esq_cima(int linha,int coluna){
        if((linha-2) == 0 && matriz[linha][coluna] == 3){
            //virou rainha comendo
            matriz[linha-1][coluna-1] = 1;
            matriz[linha][coluna] = 1;
            matriz[linha-2][coluna-2] = 30;
        }
        else {
            matriz[linha - 1][coluna - 1] = 1;
            matriz[linha][coluna] = 1;
            matriz[linha - 2][coluna - 2] = 3;
            verificarAtaque(linha - 2, coluna - 2, jd2);
        }
    }
    private void come_dir_cima(int linha, int coluna){
        if((linha-2) == 0 && matriz[linha][coluna] == 3){
            //virou raninha comendo
            matriz[linha-1][coluna+1] = 1;
            matriz[linha][coluna] = 1;
            matriz[linha-2][coluna+2] = 30;
        }
        else{
            matriz[linha - 1][coluna + 1] = 1;
            matriz[linha][coluna] = 1;
            matriz[linha - 2][coluna + 2] = 3;
            verificarAtaque(linha - 2, coluna + 2, jd2);
        }
    }


    private void verificarAtaque(int linha, int coluna, int vez){

        atualizar_tabuleiro();

        if(vez == jd1){
            if(coluna !=0 && linha !=7 && matriz[linha+1][coluna-1] == jd2 || coluna !=0 && linha !=7 && matriz[linha+1][coluna-1] == jd2_rainha){
                if(coluna !=1 && linha !=6 && matriz[linha+2][coluna-2] == 1){
                    //colorir e validar casas
                    b.tingirAtaque(b.procurar_peca(linha,coluna),atacante);
                    b.tingirAtaque(b.procurar_peca(linha+1,coluna-1),vitima);
                    b.tingirAtaque(b.procurar_peca(linha+2,coluna-2),casaFinal);
                    System.out.println("Podeira Ser Realizado um Ataque HUM a esquerda!");

                }
            }
            if(coluna != 7 && linha != 7 && matriz[linha+1][coluna+1] == jd2 || coluna != 7 && linha != 7 && matriz[linha+1][coluna+1] == jd2_rainha ){
                if(coluna != 6 && linha !=6 && matriz[linha+2][coluna+2] == 1){
                    System.out.println("Podeira Ser Realizado um Ataque HUM a direita");
                    //colorir e validar casas
                    b.tingirAtaque(b.procurar_peca(linha,coluna),atacante);
                    b.tingirAtaque(b.procurar_peca(linha+1,coluna+1),vitima);
                    b.tingirAtaque(b.procurar_peca(linha+2,coluna+2),casaFinal);
                }
            }
        }


        if(vez == jd2){
            if(coluna !=0 && linha !=0 && matriz[linha-1][coluna-1] == jd1 || coluna !=0 && linha !=0 && matriz[linha-1][coluna-1] == jd1_rainha ){
                if(coluna !=1 && linha != 1 && matriz[linha-2][coluna-2] == 1){
                    //ataque+=1;
                    //tingir um ataque
                    b.tingirAtaque(b.procurar_peca(linha,coluna),atacante);
                    b.tingirAtaque(b.procurar_peca(linha-1,coluna-1),vitima);
                    b.tingirAtaque(b.procurar_peca(linha-2,coluna-2),casaFinal);
                }
            }

            if(coluna != 7 && linha != 0 && matriz[linha-1][coluna+1] == jd1 || coluna != 7 && linha != 0 && matriz[linha-1][coluna+1] == jd1_rainha){
                if(coluna != 6 && linha != 1 && matriz[linha-2][coluna+2] == 1){
                    // ataque+=1;
                    //tingir um ataque
                    b.tingirAtaque(b.procurar_peca(linha,coluna),atacante);
                    b.tingirAtaque(b.procurar_peca(linha-1,coluna+1),vitima);
                    b.tingirAtaque(b.procurar_peca(linha-2,coluna+2),casaFinal);
                }
            }
        }

        if(vez == jd1_rainha){
            //verifica um ataque da rainha vermelha - 20
            verifica_ataque_esquerda_baixo(linha,coluna,jd1_rainha);
            verifica_ataque_direita_baixo(linha,coluna,jd1_rainha);
            verifica_ataque_esquerda_cima(linha,coluna,jd1_rainha);
            verifica_ataque_direita_cima(linha,coluna,jd1_rainha);
        }

        if(vez ==  jd2_rainha){
            //verifica um ataque da rainha vermelha - 30
            verifica_ataque_esquerda_baixo(linha,coluna,jd2_rainha);
            verifica_ataque_direita_baixo(linha,coluna,jd2_rainha);
            verifica_ataque_esquerda_cima(linha,coluna,jd2_rainha);
            verifica_ataque_direita_cima(linha,coluna,jd2_rainha);
        }
    }

    //verifica a esquerda para baixo se pode mover
    private void verifica_ataque_esquerda_baixo(int linha, int coluna, int jogador){

        //JOGADOR 20

        if(jogador == 20) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at1 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para baixo
                    i += 1;
                    j -= 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }


                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }
                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30 ) {
                        acabar_loop = true;


                        if(matriz[i+1][j-1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i+1;
                        int jj = j-1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 && sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100);
                                System.out.println("Dentro do segundo while");
                            }
                            ii += 1;
                            jj -= 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 2 || matriz[i][j] != 20 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20

        //JOGADOR 30

        if(jogador == 30) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at1 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para baixo
                    i += 1;
                    j -= 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }

                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }

                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20) {
                        System.out.println("Encontrado inimigo : "+matriz[i][j]);
                        acabar_loop = true;

                        // if(matriz[i+1][j-1] == 3 || matriz[i+1][j-1] == 30){
                        //amigo encontrado apos inimigo - movimento nao valido.. sair
                        //   sair_loop = true;
                        // }

                        if(matriz[i+1][j-1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i+1;
                        int jj = j-1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 &&sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100); //tingindo a casa final
                                System.out.println("Dentro do segundo while");
                            }
                            ii += 1;
                            jj -= 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 3 || matriz[i][j] != 30 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20
    }

    //verifica direita para baixo se pode mover
    private void verifica_ataque_direita_baixo(int linha, int coluna,int jogador){
        //JOGADOR 20

        if(jogador == 20) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at2 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a direita para baixo
                    i += 1;
                    j += 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }


                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }
                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30 ) {
                        acabar_loop = true;

                        // if(matriz[i+1][j+1] == 2 || matriz[i+1][j+1] == 20){
                        //amigo encontrado apos inimigo - movimento nao valido.. sair
                        //   sair_loop = true;
                        //}


                        if(matriz[i+1][j+1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i+1;
                        int jj = j+1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1  && sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100);
                                System.out.println("Dentro do segundo while");
                            }
                            ii += 1;
                            jj += 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 2 || matriz[i][j] != 20 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20

        //JOGADOR 30

        if(jogador == 30) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at1 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a direita para baixo
                    i += 1;
                    j += 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }

                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }

                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20) {
                        System.out.println("Encontrado inimigo : "+matriz[i][j]);
                        acabar_loop = true;

                        if(matriz[i+1][j+1] == 3 || matriz[i+1][j+1] == 30){
                            //amigo encontrado apos inimigo - movimento nao valido.. sair
                            sair_loop = true;
                        }

                        if(matriz[i+1][j+1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i+1;
                        int jj = j+1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 && sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100); //tingindo a casa final
                                System.out.println("Dentro do segundo while");
                            }
                            ii += 1;
                            jj += 1;
                        }
                    }

                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 3 || matriz[i][j] != 30 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogad
    }

    //verifica esquerda para cima se pode mover
    private void verifica_ataque_esquerda_cima(int linha, int coluna,int jogador){
        //JOGADOR 20

        if(jogador == 20) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at3 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para cima
                    i -= 1;
                    j -= 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }


                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }
                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30 ) {
                        acabar_loop = true;


                        if(matriz[i-1][j-1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i-1;
                        int jj = j-1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 && sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100);
                                System.out.println("Dentro do segundo while");
                            }
                            ii -= 1;
                            jj -= 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 2 || matriz[i][j] != 20 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20

        //JOGADOR 30

        if(jogador == 30) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at3 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para baixo
                    i -= 1;
                    j -= 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }

                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }

                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20) {
                        System.out.println("Encontrado inimigo : "+matriz[i][j]);
                        acabar_loop = true;

                        // if(matriz[i+1][j-1] == 3 || matriz[i+1][j-1] == 30){
                        //amigo encontrado apos inimigo - movimento nao valido.. sair
                        //   sair_loop = true;
                        // }

                        if(matriz[i-1][j-1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i-1;
                        int jj = j-1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 &&sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100); //tingindo a casa final
                                System.out.println("Dentro do segundo while");
                            }
                            ii -= 1;
                            jj -= 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 3 || matriz[i][j] != 30 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20le");}
    }

    //verifica direita para cima se pode mover
    private void verifica_ataque_direita_cima(int linha, int coluna, int jogador){
        //JOGADOR 20

        if(jogador == 20) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at1 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para baixo
                    i -= 1;
                    j += 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }


                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }
                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30 ) {
                        acabar_loop = true;


                        if(matriz[i-1][j+1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i-1;
                        int jj = j+1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 && sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100);
                                System.out.println("Dentro do segundo while");
                            }
                            ii -= 1;
                            jj += 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 2 || matriz[i][j] != 20 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20

        //JOGADOR 30

        if(jogador == 30) {
            boolean acabar_loop = false;
            boolean sair_loop =  false;
            System.out.println("at1 Linha : " + linha + " Coluna : " + coluna);
            int i = linha, j = coluna;
            try {
                do {//posicao valida  a esquerda para baixo
                    i -= 1;
                    j += 1;

                    if(i <= 7 && j >= 0 && matriz[i][j] == 3 || matriz[i][j] == 30){
                        acabar_loop = true;
                        System.out.println("Stop... Encontrado amigo barrando a passagem!");
                    }

                    if (i <= 7 && j >= 0 && matriz[i][j] == 1 && !acabar_loop) {
                        System.out.println("Casa  cs1 tingida : i :" + i + " j : " + j);
                        marcar_casas_validas(i, j); //tingindo as casas que eu posso andar
                    }

                    //verificando a existencia d inimigo
                    if (acabar_loop == false && i <= 7 && j >= 0 && matriz[i][j] == 2 || matriz[i][j] == 20) {
                        System.out.println("Encontrado inimigo : "+matriz[i][j]);
                        acabar_loop = true;

                        // if(matriz[i+1][j-1] == 3 || matriz[i+1][j-1] == 30){
                        //amigo encontrado apos inimigo - movimento nao valido.. sair
                        //   sair_loop = true;
                        // }

                        if(matriz[i+1][j+1] == 1){
                            //so vai tingir se tiver uma casa livre depois da inimiga
                            b.tingirAtaque(b.procurar_peca(i,j),5); //tingir a casa que ta sendo atacada
                        }
                        else{
                            sair_loop = true;
                        }

                        int ii = i-1;
                        int jj = j+1;

                        while(ii <= 7 && jj >= 0 && matriz[ii][jj] == 1 &&sair_loop == false){
                            if(matriz[ii][jj] == 1){
                                //posicao valida apos achar inimigo
                                b.tingirAtaque(b.procurar_peca(ii,jj),100); //tingindo a casa final
                                System.out.println("Dentro do segundo while");
                            }
                            ii -= 1;
                            jj += 1;
                        }
                    }
                    System.out.println("Dentro do primeiro while");
                } while (matriz[i][j] != 3 || matriz[i][j] != 30 || i <= 7 || j >= 0);
            } catch (Exception erro) {
                System.out.println("Fora do fluxo while");
            }
        }//fim jogador 1 // 2 || 20
    }

    //implemetacao do ataque da DAMA

    //ataque de DAMA esquerda para baixo

    private void dama_ataque_esquerda_baixo(int linha_velha, int coluna_velha, int linhaFinal, int colunaFinal,int j_atacante){
        boolean encontrou = false;

        matriz[linha_velha][coluna_velha] = 1;
        int i = linha_velha+1;
        int j = coluna_velha-1;

        while(i != linhaFinal && j != colunaFinal && encontrou == false){
            if(matriz[i][j] != 1){
                matriz[i][j] = 1;
                encontrou = true;
            }
            i+=1;
            j-=1;
        }
        matriz[linhaFinal][colunaFinal] = j_atacante;
    }

    //ataque de DAMA direita para baixo

    private void dama_ataque_direita_baixo(int linha_velha, int coluna_velha, int linhaFinal, int colunaFinal,int j_atacante){
        boolean encontrou = false;

        matriz[linha_velha][coluna_velha] = 1;
        int i = linha_velha+1;
        int j = coluna_velha+1;

        while(i != linhaFinal && j != colunaFinal && encontrou == false){
            if(matriz[i][j] != 1){
                matriz[i][j] = 1;
                encontrou = true;
            }
            i+=1;
            j+=1;
        }
        matriz[linhaFinal][colunaFinal] = j_atacante;
    }

    //ataque de DAMA esquerda para cima

    private void dama_ataque_esquerda_cima(int linha_velha, int coluna_velha, int linhaFinal, int colunaFinal,int j_atacante){
        boolean encontrou = false;

        matriz[linha_velha][coluna_velha] = 1;
        int i = linha_velha-1;
        int j = coluna_velha-1;

        while(i != linhaFinal && j != colunaFinal && encontrou == false){
            if(matriz[i][j] != 1){
                matriz[i][j] = 1;
                encontrou = true;
            }
            i-=1;
            j-=1;
        }
        matriz[linhaFinal][colunaFinal] = j_atacante;
    }

    //ataque de DAMA direita para cima

    private void dama_ataque_direita_cima(int linha_velha, int coluna_velha, int linhaFinal, int colunaFinal,int j_atacante){
        boolean encontrou = false;

        matriz[linha_velha][coluna_velha] = 1;
        int i = linha_velha-1;
        int j = coluna_velha+1;

        while(i != linhaFinal && j != colunaFinal && encontrou == false){
            if(matriz[i][j] != 1){
                matriz[i][j] = 1;
                encontrou = true;
            }
            i-=1;
            j+=1;
        }
        matriz[linhaFinal][colunaFinal] = j_atacante;
    }


    //procura a direcao que a jogada vai ser relaizada

    private void direcao_ataque(int linha_velha, int coluna_velha, int linhaFinal, int colunaFinal, int jogador){

        // movimento de esquerda para baixo
        if(linhaFinal > linha_velha && colunaFinal < coluna_velha){
            System.out.println("Possibilidade de ataque a esquerda para baixo...");
            dama_ataque_esquerda_baixo(linha_velha,coluna_velha,linhaFinal,colunaFinal,jogador);
        }

        // movimento de direita para baixo
        if(linhaFinal > linha_velha && colunaFinal > coluna_velha){
            System.out.println("Possibilidade de ataque a direita para baixo...");
            dama_ataque_direita_baixo(linha_velha,coluna_velha,linhaFinal,colunaFinal,jogador);
        }

        // movimento de esquerda para cima
        if(linhaFinal < linha_velha && colunaFinal < coluna_velha){
            System.out.println("Possibilidade de ataque a esquerda para cima...");
            dama_ataque_esquerda_cima(linha_velha,coluna_velha,linhaFinal,colunaFinal,jogador);
        }

        // movimento de direita para cima
        if(linhaFinal < linha_velha && colunaFinal > coluna_velha){
            System.out.println("Possibilidade de ataque a direita para cima...");
            dama_ataque_direita_cima(linha_velha,coluna_velha,linhaFinal,colunaFinal,jogador);
        }

    }


    public void reiniciar_tabuleiro(){
        inicializaMatriz();
        por_pecas();
        atualizar_tabuleiro();
        vez_de_jogar = true;
        so_ataque = false;
        tem_ganhador = false;
        lb_player1_quant_pc.setText("Quantidade de Pecas : 12");
        lb_player2_quant_pc.setText("Quantidade de Pecas : 12");
    }


    public void fim_jogada(int linha,int coluna,int vez){
        trocar_vez(linha,coluna,vez);
    }


    public int quant_pecas(int peca){
        int quantidade = 0;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == peca){
                    quantidade++;
                }
            }
        }
        return quantidade;
    }

    private void atualizar_tabuleiro(){

        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == 0){
                    //atribuir ao botao fundo branco
                }
                if(matriz[i][j] == 1){
                    //tirar o icone do botao
                    b.removerIcone(b.procurar_peca(i,j));
                }
                if(matriz[i][j] == 2){
                    //setar icone azul no botao
                    b.setarIcone(b.procurar_peca(i,j),jd1);
                }
                if(matriz[i][j] == 3){
                    //setar icone vermelho no botao
                    b.setarIcone(b.procurar_peca(i,j),jd2);
                }
                //setando as rainhas

                if(matriz[i][j] == 20){
                    //setar icone azul no botao para rainha
                    b.setarIcone_rainha(b.procurar_peca(i,j),jd1_rainha);
                }
                if(matriz[i][j] == 30){
                    //setar icone vermelho no botao para rainha
                    b.setarIcone_rainha(b.procurar_peca(i,j),jd2_rainha);
                }
            }
            verificarGanhador();
        }

        mudar_label_jogador();

        //b.tingir_pretas();
        lvelha = -1;
        cvelha = -1;

    }


    public void mudar_label_jogador(){
        if(vez_de_jogar){
            jogador1_vez.setIcon(seta);
            jogador2_vez.setIcon(null);
        }
        else{
            jogador1_vez.setIcon(null);
            jogador2_vez.setIcon(seta);

        }

    }


    private void verificarGanhador(){

        //verificar a quantidade de pecas que faltam

        int jogador1 = 0;
        int jogador2 = 0;

        if(tem_ganhador == false){

            jogador1 = quantidade_jd1() + quantidade_jd1_rainha();
            jogador2 = quantidade_jd2() + quantidade_jd2_rainha();

            if(jogador1 == 0){
                JOptionPane.showMessageDialog(null,"Jogador 2 Ganhou");
                pt2 += 3;
                tem_ganhador = true;
            }

            if(jogador2 == 0){
                JOptionPane.showMessageDialog(null,"Jogador 1 Ganhou");
                pt1 += 3;
                tem_ganhador = true;
            }

            else{
                System.out.println("Restam os 2 jogadores Ainda");
            }
        }else{
            System.out.println("O jogo Ja possui Ganhador");
        }

    }


    private int quantidade_jd1(){
        int contador = 0;
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == jd1){
                    contador++;
                }
            }
        }
        return contador;
    }

    private int quantidade_jd2(){
        int contador = 0;
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == jd2){
                    contador++;
                }
            }
        }
        return contador;
    }

    private int quantidade_jd1_rainha(){
        int contador = 0;
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == jd1_rainha){
                    contador++;
                }
            }
        }
        return contador;
    }

    private int quantidade_jd2_rainha(){
        int contador = 0;
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                if(matriz[i][j] == jd2_rainha){
                    contador++;
                }
            }
        }
        return contador;
    }



    //retorna verdadeiro se tiver alguma possibilidade de ataque

    private boolean busca_esquerda_baixo(int linha, int coluna, int vez){
        int i = linha+1;
        int j = coluna-1;
        boolean nao_joga = false;
        so_ataque = false;

        if(vez == 2){
            try {
                if (linha < 7 && coluna > 0 && matriz[i][j] == 30 || linha != 7 && coluna != 0 && matriz[i][j] == 3) {
                    if (matriz[i + 1][j - 1] == 1 && linha <= 7 && coluna >= 0) {
                        System.out.println("Peao " + vez + " pode comer mais uma : " + matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 3 && nao_joga == true){
            try {
                if (linha < 7 && coluna > 0 && matriz[i][j] == 20 || linha < 7 && coluna > 0 && matriz[i][j] == 2) {
                    if (matriz[i + 1][j - 1] == 1 && linha <= 7 && coluna >= 0) {
                        System.out.println("Peao " + vez + " pode comer mais uma : " + matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 20){
            try{
                while(linha < 7 && coluna > 0){
                    if(linha < 7 && coluna > 0 && matriz[i][j] == 30 || linha < 7 && coluna > 0 && matriz[i][j] == 3){
                        if( matriz[i+1][j-1] == 1 && linha <= 7 && coluna >= 0){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i+=1;
                    j-=1;
                }
            }catch (Exception erro){}
        }

        if(vez == 30){
            try{
                while(linha < 7 && coluna > 0){
                    if(linha < 7 && coluna > 0 && matriz[i][j] == 20 || linha < 7 && coluna > 0 && matriz[i][j] == 2){
                        if( matriz[i+1][j-1] == 1 && linha <= 7 && coluna >= 0){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            so_ataque = true;
                            return true;
                        }
                    }
                    i+=1;
                    j-=1;
                }
            }catch (Exception erro){}
        }
        else{
            System.out.println("So ataque dasabilitado");
            so_ataque = false;
        }
        return false;
    }

    //fantando observacao nos demais - ok

    private boolean busca_direita_baixo(int linha, int coluna, int vez){
        int i = linha+1;
        int j = coluna+1;
        boolean nao_joga = false;

        if(vez == 2){
            try{
                if(linha < 7 && coluna < 7 && matriz[i][j] == 30 || linha < 7 && coluna < 7 && matriz[i][j] == 3){
                    if(matriz[i+1][j+1] == 1 && linha <= 7 && coluna <= 7){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        //fantando para baixo - ok

        if(vez == 3 && nao_joga == true){
            try{
                if(linha < 7 && coluna < 7 && matriz[i][j] == 20 || linha < 7 && coluna < 7 && matriz[i][j] == 2){
                    if(matriz[i+1][j+1] == 1 && linha <= 7 && coluna <= 7){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 20){
            try{
                while(linha < 7 && coluna < 7){
                    if(linha < 7 && coluna < 7 && matriz[i][j] == 30 || linha < 7 && coluna < 7 && matriz[i][j] == 3){
                        if( matriz[i+1][j+1] == 1 && linha <= 7 && coluna <= 7){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i+=1;
                    j+=1;
                }
            }catch (Exception erro){}
        }

        if(vez == 30){
            try{
                while(linha < 7 && coluna < 7){
                    if(linha < 7 && coluna < 7 && matriz[i][j] == 20 || linha < 7 && coluna < 7 && matriz[i][j] == 2){
                        if( matriz[i+1][j+1] == 1 && linha <= 7 && coluna <= 7){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i+=1;
                    j+=1;
                }
            }catch (Exception erro){}
        }
        else{
            System.out.println("So ataque habilitado");
            so_ataque = false;
        }

        return false;
    } //listo!

    //fantando aki agr

    private boolean busca_esquerda_cima(int linha, int coluna, int vez){
        int i = linha-1;
        int j = coluna-1;
        boolean nao_joga = false;

        if(vez == 2 && nao_joga == true){
            try{
                if(linha > 0 && coluna > 0 && matriz[i][j] == 30 || linha > 0 && coluna > 0 && matriz[i][j] == 3){
                    if(matriz[i-1][j-1] == 1 && linha >= 0 && coluna >= 0){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }

                }
            }catch (Exception erro){}
        }

        if(vez == 3){
            try{
                if(linha > 0 && coluna > 0 && matriz[i][j] == 20 || linha > 0 && coluna > 0 && matriz[i][j] == 2){
                    if(matriz[i-1][j-1] == 1 && linha >= 0 && coluna >= 0){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 20){
            try{
                while(linha > 0 && coluna > 0){
                    if(linha > 0 && coluna > 0 && matriz[i][j] == 30 || linha > 0 && coluna > 0 && matriz[i][j] == 3){
                        if( matriz[i-1][j-1] == 1 && linha >= 0 && coluna >= 0){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i-=1;
                    j-=1;
                }
            }catch (Exception erro){}
        }


        if(vez == 30){
            try{
                while(linha > 0 && coluna > 0){
                    if(linha > 0 && coluna > 0 && matriz[i][j] == 20 || linha > 0 && coluna > 0 && matriz[i][j] == 2){
                        if( matriz[i-1][j-1] == 1 && linha >= 0 && coluna >= 0){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i-=1;
                    j-=1;
                }
            }catch (Exception erro){}
        }
        else{
            System.out.println("So ataque desabilitado");
            so_ataque = false;
        }

        return false;
    }


    private boolean busca_direita_cima(int linha, int coluna, int vez){
        int i = linha-1;
        int j = coluna+1;
        boolean nao_joga = false;

        if(vez == 2 && nao_joga == true){
            try{
                if(linha > 0 && coluna < 7 && matriz[i][j] == 30 || linha > 0 && coluna < 7 && matriz[i][j] == 3){
                    if(matriz[i-1][j+1] == 1 && linha >= 0 && coluna <= 7){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 3){
            try{
                if(linha > 0 && coluna < 7 && matriz[i][j] == 20 || linha > 0 && coluna < 7 && matriz[i][j] == 2){
                    if(matriz[i-1][j+1] == 1 && linha >= 0 && coluna <= 7){
                        System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                        System.out.println("So ataque habilitado");
                        so_ataque = true;
                        return true;
                    }
                }
            }catch (Exception erro){}
        }

        if(vez == 20){
            try{
                while(linha > 0 && coluna < 7){
                    if(linha > 0 && coluna < 7 && matriz[i][j] == 30 || linha > 0 && coluna < 7 && matriz[i][j] == 3){
                        if( matriz[i-1][j+1] == 1 && linha >= 0 && coluna <= 7){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i-=1;
                    j+=1;
                }
            }catch (Exception erro){}
        }

        if(vez == 30){
            try{
                while(linha > 0 && coluna < 7){
                    if(linha > 0 && coluna < 7 && matriz[i][j] == 20 || linha > 0 && coluna < 7 && matriz[i][j] == 2){
                        if( matriz[i-1][j+1] == 1 && linha >= 0 && coluna <= 7){
                            System.out.println("Peao "+vez+" pode comer mais uma : "+matriz[i][j]);
                            System.out.println("So ataque habilitado");
                            so_ataque = true;
                            return true;
                        }
                    }
                    i-=1;
                    j+=1;
                }
            }catch (Exception erro){}
        }
        else{
            System.out.println("So ataque desabilitado");
            so_ataque = false;
        }

        return false;
    }


    private boolean verificar_comer_de_novo(int linha, int coluna, int vez){

        // reservar uma fase da srint para correcao do bug de qualquer peca poder jpgar na vez de comer


        //verificar se jd1 pode comer de novo

        if(vez == jd1){
            System.out.println("vez de Jd1");
            if(busca_esquerda_baixo(linha,coluna,jd1) == true){
                System.out.println("jd1 tem mais uma possibilidade de comer a esquerda para baixo");
                return true;
            }
            if(busca_direita_baixo(linha,coluna,jd1) == true){
                System.out.println("jd1 tem mais uma possibilidade de comer a direita para baixo");
                return true;
            }
            if(busca_esquerda_cima(linha,coluna,jd1) == true){
                System.out.println("jd1 tem mais uma possibilidade de comer a esquerda para cima");
                return true;
            }
            if(busca_direita_cima(linha,coluna,jd1) == true){
                System.out.println("jd1 tem mais uma possibilidade de comer a direita para cima");
                return true;
            }
            return false;
        }

        //verificar se jd2 pode comer de novo

        if(vez == jd2){
            if(busca_esquerda_baixo(linha,coluna,jd2) == true){
                System.out.println("jd2 tem mais uma possibilidade de comer a esquerda para baixo");
                return true;
            }
            if(busca_direita_baixo(linha,coluna,jd2) == true){
                System.out.println("jd2 tem mais uma possibilidade de comer a direita para baixo");
                return true;
            }
            if(busca_esquerda_cima(linha,coluna,jd2) == true){
                System.out.println("jd2 tem mais uma possibilidade de comer a esquerda para cima");
                return true;
            }
            if(busca_direita_cima(linha,coluna,jd2) == true){
                System.out.println("jd2 tem mais uma possibilidade de comer a direita para cima");
                return true;
            }
            return false;
        }

        //verificar se a dama jd1_rainha pode comer de novo

        if(vez == jd1_rainha){
            if(busca_esquerda_baixo(linha,coluna,jd1_rainha) == true){
                System.out.println("jd1_rainha tem mais uma possibilidade de comer a esquerda para baixo");
                return true;
            }
            if(busca_direita_baixo(linha,coluna,jd1_rainha) == true){
                System.out.println("jd1_rainha tem mais uma possibilidade de comer a direita para baixo");
                return true;
            }
            if(busca_esquerda_cima(linha,coluna,jd1_rainha) == true){
                System.out.println("jd1_rainha tem mais uma possibilidade de comer a esquerda para cima");
                return true;
            }
            if(busca_direita_cima(linha,coluna,jd1_rainha) == true){
                System.out.println("jd1_rainha tem mais uma possibilidade de comer a direita para cima");
                return true;
            }
            return false;

        }

        //verificar se a dama jd2_rainha pode comer de novo

        if(vez == jd2_rainha){
            if(busca_esquerda_baixo(linha,coluna,jd2_rainha) == true){
                System.out.println("jd2_rainha tem mais uma possibilidade de comer a esquerda para baixo");
                return true;
            }
            if(busca_direita_baixo(linha,coluna,jd2_rainha) == true){
                System.out.println("jd2_rainha tem mais uma possibilidade de comer a direita para baixo");
                return true;
            }
            if(busca_esquerda_cima(linha,coluna,jd2_rainha) == true){
                System.out.println("jd2_rainha tem mais uma possibilidade de comer a esquerda para cima");
                return true;
            }
            if(busca_direita_cima(linha,coluna,jd2_rainha) == true){
                System.out.println("jd2_rainha tem mais uma possibilidade de comer a direita para cima");
                return true;
            }
            return false;
        }
        return false;
    }


    public void quant_pecas(){
        int jogador1 = 0;
        int jogador2 = 0;
        jogador1 = quantidade_jd1() + quantidade_jd1_rainha();
        jogador2 = quantidade_jd2() + quantidade_jd2_rainha();
        lb_player1_quant_pc.setText("Quantidade de Pecas : "+jogador1);
        lb_player2_quant_pc.setText("Quantidade de Pecas : "+jogador2);
        lb_player1_quant_pontos.setText("Pontos : "+pt1);
        lb_player2_quant_pontos.setText("Pontos : "+pt2);
    }


}

