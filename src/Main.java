
/**
 * Created by marcos on 02/06/16.
 */

/*
* O jogo tem que conter a possibilidade de 2 jogadores jogar um contra o outro e também contra a máquina,
 * os jogadores tem que logar antes de iniciar a partida,
  * os nomes dos jogadores terão que ficar visível durante a partida nos cantos superiores (esquerdo e direito),
   * terá que ser feito um ranking dos melhores jogadores (mostrando os 5 melhores).
   *
Obs.: Os alunos terão que fazer reuso da inteligência utilizada no ultimo trabalho e também do ranking.
Obs.: Uma vitoria vale 3 pontos, um empate 1 e uma derrota 0 pontos (pontos esse que devem ser utilizados
 para montar o ranking).
Obs.: Toda vez que um jogador terminar seu turno de jogada o jogo deve avisar de quem é a próxima vez.
*
* */

//ranking @ time @ sair @ reiniciar @  home

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import save.GerenciadorDados;
import MoverJanela.MoveWindow;
import vsAmiguinhoRede.Escolha;


/*
* Classe que iniciar o jogo , a tela de logar com o nome dos jogadores
* e as opçoes de jogabilidade
* */


public class Main extends JFrame implements ActionListener{

    //DECLARACOES

    private JPanel contentPane;

    GerenciadorDados salvar; //instancia para salvar os dados
    MoveWindow mvjanela; //instancia para mover a janela

    //recuperando imagens

    ImageIcon icone_humano_azul = new ImageIcon(getClass().getResource("imagens/icon_player_hum_azul.png"));

    ImageIcon icone_humano_vermelho = new ImageIcon(getClass().getResource("imagens/icon_player_hum_red.png"));
    ImageIcon icone_maquina_vermelho = new ImageIcon(getClass().getResource("imagens/icon_player_cpu_red.png"));
    ImageIcon icone_humano_rede_vermelho = new ImageIcon(getClass().getResource("imagens/icon_player_hum_red_rede.png"));

    ImageIcon icone_titulo = new ImageIcon(getClass().getResource("imagens/nome1.png"));
    ImageIcon background = new ImageIcon(getClass().getResource("imagens/fundo_new.png"));

    //ImageIcon icone_play = new ImageIcon(getClass().getResource("imagens/play.png"));
    //ImageIcon icone_play_select = new ImageIcon(getClass().getResource("imagens/playx.png"));

    ImageIcon cb_on = new ImageIcon(getClass().getResource("imagens/check_box/check_box_on.png"));
    ImageIcon cb_off = new ImageIcon(getClass().getResource("imagens/check_box/check_box_off.png"));
    ImageIcon cb_off_des = new ImageIcon(getClass().getResource("imagens/check_box/check_box_off_des.png"));

    //componente para entrada de texto

    private JTextField textField;
    private JTextField textField_1;

    //opcao para que comeca o jogo - no caso a maquina vc humano
    private boolean opcao_player;
    private boolean rede;

    //fundo
    JLabel lb_fundo = new JLabel(background);

    //botoes para o check box
    JLabel cb_play_play = new JLabel(cb_on);
    JLabel cb_play_maquina = new JLabel(cb_off);
    JLabel cb_play_rede = new JLabel(cb_off);

    JLabel lb_play_play;
    JLabel lb_play_maquina;
    JLabel lb_play_rede;

    private boolean xplay = true;
    private boolean xmaquina = false;
    private boolean xrede = false;

    //label dos jogadores
    JLabel lbl_humano;
    JLabel lb_maquina;


    //botao para sair
    JButton salir;
    //botao para iniciar
    JButton start;


    //funcao que inicar a aaplicaçao

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //componentes do check box para opcoes de jogar

    private void componetes_check_box(){
        cb_play_play.setBounds(280,190,25,25);
        lb_play_play.setBounds(310,190,200,25);

        cb_play_maquina.setBounds(280,230,25,25);
        lb_play_maquina.setBounds(310,230,200,25);

        cb_play_rede.setBounds(280,270,25,25);
        lb_play_rede.setBounds(310,270,200,25);
    }

    private void initComponetes(){
        opcao_player = true;
        rede = false;

        lb_play_play = new JLabel("  VS PLAYER");
        lb_play_play.setForeground(new Color(1,1,1));

        lb_play_maquina = new JLabel("  VS MÁQUINA");
        lb_play_maquina.setForeground(new Color(1,1,1));

        lb_play_rede = new JLabel("  VS PLAYER - REDE");
        lb_play_rede.setForeground(new Color(1,1,1));
    }


    //construtor - contem as configurações do jogo

    public Main() {

        initComponetes();

        setUndecorated(true);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        mvjanela = new MoveWindow(this); //instancia para retirar as botoes do sistemas na janela
        addMouseMotionListener(mvjanela);



        lbl_humano = new JLabel(icone_humano_azul);
        lbl_humano.setBounds(40, 150, 200, 200); //icone inicial do jogador da esquerda
        contentPane.add(lbl_humano);

        lb_maquina = new JLabel(icone_humano_vermelho);
        lb_maquina.setBounds(500, 150, 200, 200); //icone inicial do jogador da direita
        contentPane.add(lb_maquina);


        //botao para startar o game

        start = new JButton("START");
        start.setBounds(580,450,100,30);
        start.setBackground(new Color(100,129,255));
        start.setForeground(new Color(255,255,233));
        contentPane.add(start);
        start.addActionListener(this);

        //label para titulo da aplicação

        JLabel lb_titulo = new JLabel(icone_titulo);
        lb_titulo.setBounds(220, 0, 300,150);
        contentPane.add(lb_titulo);

        //componetes check box

        componetes_check_box();
        contentPane.add(cb_play_play);
        contentPane.add(lb_play_play);

        contentPane.add(cb_play_maquina);
        contentPane.add(lb_play_maquina);

        contentPane.add(cb_play_rede);
        contentPane.add(lb_play_rede);


        //label name player 1

        JLabel lbl_name_player1 = new JLabel("NAME");
        lbl_name_player1.setBounds(20, 375, 100, 30); //label de nome for jogador da esquerda
        contentPane.add(lbl_name_player1);

        //label name player 2

        JLabel lb_name_player2 = new JLabel("NAME"); //label de nome for jogador da direita
        lb_name_player2.setBounds(480, 375, 100, 30);
        contentPane.add(lb_name_player2);

        textField = new JTextField("Player 1"); //campo de texto para jogador esq
        textField.setBounds(65, 380, 200, 22);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField("Player 2"); //campo de texto para jogador dir
        textField_1.setBounds(530, 380, 200, 22);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        //informaçoes sobre o label do desenvolvedor

        JLabel lblNewLabel_2 = new JLabel("Nig creations");
        lblNewLabel_2.setBounds(330, 460, 150, 30);
        contentPane.add(lblNewLabel_2);

        salir = new JButton("SAIR");
        salir.setBounds(100,450,100,30);
        salir.setBackground(new Color(100,129,255));
        salir.setForeground(new Color(255,255,233));

        contentPane.add(salir);
        salir.addActionListener(this);
        lb_fundo.setBounds(0,0,750,500);
        contentPane.add(lb_fundo);


        //botao de alternar de player vs player

        cb_play_play.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                marcar_caixa(true,false,false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!xplay){
                    cb_play_play.setIcon(cb_off_des);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!xplay){
                    cb_play_play.setIcon(cb_off);
                }
            }
        });

        //botao de player vs maquina

        cb_play_maquina.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                marcar_caixa(false,true,false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!xmaquina){
                    cb_play_maquina.setIcon(cb_off_des);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!xmaquina){
                    cb_play_maquina.setIcon(cb_off);
                }
            }
        });

        //botao de vs player pela rede

        cb_play_rede.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                marcar_caixa(false,false,true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(!xrede){
                    cb_play_rede.setIcon(cb_off_des);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(!xrede){
                    cb_play_rede.setIcon(cb_off);
                }
            }
        });

    }

    private void marcar_caixa(boolean xp,boolean xm, boolean xr){

        //icone do jogador vs jogador selecionado
        if(xp){
            cb_play_play.setIcon(cb_on);
            cb_play_maquina.setIcon(cb_off);
            cb_play_rede.setIcon(cb_off);
            lb_maquina.setIcon(icone_humano_vermelho);
            textField_1.setText("Player 2");

            xplay = true;
            xmaquina = false;
            xrede = false;
        }

        //icone do jogador vs maquina selecionado

        if(xm){
            cb_play_play.setIcon(cb_off);
            cb_play_maquina.setIcon(cb_on);
            cb_play_rede.setIcon(cb_off);
            lb_maquina.setIcon(icone_maquina_vermelho);
            textField_1.setText("Máquina");

            xplay = false;
            xmaquina = true;
            xrede = false;
        }

        //icone do jogador vs jogador - REDE - selecionado

        if(xr){

            cb_play_play.setIcon(cb_off);
            cb_play_maquina.setIcon(cb_off);
            cb_play_rede.setIcon(cb_on);
            lb_maquina.setIcon(icone_humano_rede_vermelho);
            textField_1.setText("Player 2");

            xplay = false;
            xmaquina = false;
            xrede = true;
        }

    }


    //funcao que salva o nome dos jogadores em um arquivo

    private boolean valida_campos(String nomej){
        int quant=0;
        int tamanho = nomej.length();

        System.out.println("Nome  esq: "+nomej+" Tamanho : "+tamanho);

        for (int i =0;i<tamanho;i++){
            char l = nomej.charAt(i);
            if(nomej.trim().equals("")){
                quant++;
            }
        }

        System.out.println("Valor de q = "+quant);

        if(tamanho == 0){
            return false;
        }

        else {

            if (quant == tamanho) {
                System.out.println("Possui todos os campos Vazios");
                return false;
            } else {
                return true;
            }
        }
    }

    //escrevendo nome, pontos, tempo e classificação de cada jogador

    private void carregarSave() {

        if (valida_campos(textField.getText())) {
            System.out.println("Nome do Jogador da esquerda válido");
        }
        else {
            System.out.println("Nome do Jogador da esquerda inválido********************");
        }

        if (valida_campos(textField_1.getText())) {
            System.out.println("Nome do Jogador da direita válido");
        }
        else {
            System.out.println("Nome do Jogador da direita inválido**********************");
        }

        if(valida_campos(textField.getText()) && valida_campos(textField_1.getText())) {

            String nomejog1 = textField.getText();
            String nomejog2 = textField_1.getText();
            System.out.println("Nome do Arquivo : " + nomejog1);
            System.out.println("Nome do Arquivo : " + nomejog2);

            //    System.out.println("Nome ja existente no player 1");


            try {
                salvar = new GerenciadorDados();
                System.out.println("Instaciado com sucesso");
            } catch (Exception erro) {
                System.out.println("Ma saida em Laucher");
            }
            salvar.escrever(nomejog1,0);

            try {
                salvar.salvar();
                System.out.println("Salvo com sucesso!");
            }catch (Exception erro){
                System.out.println("Nao salvo sa informações");
            }
        }

    }

    //funcao para fechar os botoes
    private void fecharJanelaAtual()
    {
        super.dispose();
    }

    @Override // acao para os botoes
    public void actionPerformed(ActionEvent e) {

        //acao do botao sair

        if(e.getSource() == salir){
            System.exit(0);
        }

        //acao do botao start

        if(e.getSource() == start){
            if(xplay){
                //opção de jogabilidade de jogador x jogador
                System.out.println("Iniciando o game");
                carregarSave();
                /*
                futuramente nao precisara mais passar o nome dos jogadores por parâmetro
                o nome sera lido no arquivo
                * */
                if(valida_campos(textField.getText()) && valida_campos(textField_1.getText())) {
                    new game_main_humano(textField.getText(),textField_1.getText());
                    fecharJanelaAtual();
                }
                else{
                    System.out.println("Sem informação no Campo");
                    JOptionPane.showMessageDialog(null,"Infome o Nome dos Jogadores");
                }

            }

            if(xmaquina){
                //jogabilidade com a maquina
                System.out.println("Ainda Nao implemtado player vc Maquina");
                JOptionPane.showMessageDialog(null,"Em Implementação...");
            }


            if(xrede){
                //jogabilidade jogador na rede
                new Escolha();
                fecharJanelaAtual();
                System.out.println("Ainda Nao implemtado player vc player pela rede");
                //#include<true.h>
            }
        }
    }
}