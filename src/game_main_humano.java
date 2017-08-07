import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Indice.indice;
import save.GerenciadorDados;
import util.Util;
import vsHumano.Painel_tabuleiro;
import Painel.painel;
import save.GerenciadorDados;

import Ranking.Ranking;

/**
 * Created by marcos on 02/06/16.
 * http://www.tecmundo.com.br/video-game-e-jogos/106138-reboot-continuacao-entenda-melhor-kratos-novo-god-of-war.htm?utm_source=facebook.com&utm_medium=referral&utm_campaign=thumb
 */


/*
* Classe que eh a tela do jogabilidade,
*
*  */

public class game_main_humano extends JFrame implements ActionListener{

    //DECLARAÇOES

    private JPanel contentPane;
    RodarTempo r = new RodarTempo();
    Util u = new Util();

    public int segundos;
    public int minutos;

    JPanel painelGeral = new JPanel();

    JPanel painel_info_player; //painel para a exibir informações sobre os jogadores
    JLabel total_pecas;
    JLabel pecas_normais;
    JLabel pecas_rainha;

    //imagens para representar o jogador

    //ImageIcon fundo = new ImageIcon(getClass().getResource("imagens/fundo_jogo.jpeg"));
    //ImageIcon fundo = new ImageIcon(getClass().getResource("imagens/fundo_new.png"));
    JLabel background = new JLabel();

    ImageIcon j1 = new ImageIcon(getClass().getResource("imagens/icon_player_hum_azul.png"));
    ImageIcon j2 = new ImageIcon(getClass().getResource("imagens/icon_player_hum_red.png"));

    JLabel jogador1_esq = new JLabel(j1);
    JLabel jogador2_dir = new JLabel(j2);



    private int quant_total_pecas;
    private int quant_pecas_normais;
    private int quant_pecas_rainhas;

    GerenciadorDados save = new GerenciadorDados();

    Painel_tabuleiro p = new Painel_tabuleiro();
    indice l_cord = new indice(1);
    indice c_cord = new indice(0);

    JButton bt_home = new JButton();
    JButton bt_ranking = new JButton();
    JButton bt_reiniciar = new JButton();
    JButton bt_sair = new JButton();
    JButton bt_tempo = new JButton();


    private int c1=60,c2 = 179,c3 = 130;

    //configuracao do painel do tabuleiro

    public void addPainelGeral(){

        c_cord.setBounds(60,10,500,30); c_cord.setBackground(new Color(179,179,179));
        p.setBounds(50, 50, 500, 500);
        l_cord.setBounds(20,50,30,500); l_cord.setBackground(new Color(179,179,179));

        painelGeral.add(l_cord);
        painelGeral.add(c_cord);
        painelGeral.add(p);
        painelGeral.setBounds(10,10,600,600);
        painelGeral.setBackground(new Color(179,179,179));
        painelGeral.setVisible(true);
        painelGeral.setLayout(null);
    }

    //contrututor da classe

    public game_main_humano(String nome1,String nome2){

        //propriedades das janelas
        setResizable(false);
        setBounds(100, 0, 1200, 650);
        setVisible(true);
        addPainelGeral();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(c1,c2,c3));
        painelGeral.setBounds(300, 80, 600, 550);
        //getContentPane().add(painelGeral);
        int background_width =  1200;
        int background_heigth =  650;
        background.setBounds(0,0,background_width,background_heigth);
        background.setIcon(u.redimensionar_icone("imagens/background_madeira.png", background_width, background_heigth));
        add(painelGeral);


        //menu info dos jogadores da esquerda
        painel_info_player = new painel();
        //painel_info_player.setLayout(null);
        //painel_info_player.add(total_pecas);
        //painel_info_player.add(pecas_normais);
        //painel_info_player.add(pecas_rainha);
        config_elementos_menu_info(2,20);

        //painel dos jogadores esquerda
        painel p1 = new painel();
        p1.setBounds(20,80,250,550);
        p1.setLayout(null);
        add(p1);

        p.lb_player1.setBounds(15,10,230,50);
        jogador1_esq.setBounds(25,70,200,200);
        p.jogador1_vez.setBounds(75,300,100,100);
        p.lb_player1_quant_pc.setBounds(30,450,200,30);
        p.lb_player1_quant_pontos.setBounds(60,470,200,30);

        p.lb_player1.setText(nome1);
        p.lb_player1.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        p.lb_player1.setBackground(new Color(70,216,80));
        p1.add(jogador1_esq);
        p1.add(p.lb_player1);
        p1.add(p.jogador1_vez);
        p1.add(p.lb_player1_quant_pc);
        p1.add(p.lb_player1_quant_pontos);


        //painel dos jogadores  direita
        painel p2 = new painel();
        p2.setLayout(null);
        p2.setBounds(930,80,250,550);
        add(p2);
        p.lb_player2.setBounds(15,10,230,50);
        jogador2_dir.setBounds(25,70,200,200);
        p.jogador2_vez.setBounds(75,300,100,100);
        p.lb_player2_quant_pc.setBounds(30,450,200,30);
        p.lb_player2_quant_pontos.setBounds(60,470,200,30);


        p.lb_player2.setText(nome2);
        p.lb_player2.setFont(new Font("Sans Serif", Font.PLAIN, 20));

        p2.add(jogador2_dir);
        p2.add(p.lb_player2);
        p2.add(p.jogador2_vez);
        p2.add(p.lb_player2_quant_pc);
        p2.add(p.lb_player2_quant_pontos);

        //painel onde contem o titulo da aplicação
        painel menu_titulo = new painel();
        menu_titulo.setBounds(200,0,800,30);
        JLabel titulo = new JLabel("DAMAS");
        menu_titulo.add(titulo);

         //painel no menu que contem os botoes
        painel menu_botoes = new painel();
        menu_botoes.setLayout(new GridLayout());
        menu_botoes.setBounds(200,30,800,40);
        config_elementos_menu();
        menu_botoes.add(bt_home);
        menu_botoes.add(bt_ranking);
        menu_botoes.add(bt_tempo);
        menu_botoes.add(bt_reiniciar);
        menu_botoes.add(bt_sair);

        //painel onde mostrara o titulo do jogo e os botoes
        painel menu = new painel();
        menu.setBounds(200,0,800,70);
        add(menu_titulo);
        add(menu_botoes);
        menu.setLayout(new GridLayout(2,5));
        add(background);

        addAcaoButton();
        r.start();
    }


    private void config_elementos_menu_info(int comun,int rainha){
        total_pecas = new JLabel();
        pecas_normais = new JLabel();
        pecas_rainha = new JLabel();

        total_pecas.setText("Total peças : "+p.quant_pecas(comun)+p.quant_pecas(rainha));
        pecas_normais.setText("Peças Comuns : "+p.quant_pecas(comun));
        pecas_rainha.setText("Peças Rainhas : "+p.quant_pecas(rainha));

    }

    private void config_elementos_menu(){
        bt_home.setText("HOME");
        bt_home.setForeground(new Color(c1,c2,c3));
        bt_ranking.setText("RANKING");
        bt_ranking.setForeground(new Color(c1,c2,c3));
        bt_tempo.setText(" TIME  00:00 ");
        bt_tempo.setForeground(new Color(c1,c2,c3));
        bt_reiniciar.setText("REINICIAR");
        bt_reiniciar.setForeground(new Color(c1,c2,c3));
        bt_sair.setText("SAIR");
        bt_sair.setForeground(new Color(c1,c2,c3));
    }

    private void addAcaoButton(){
        bt_home.addActionListener(this);
        bt_reiniciar.addActionListener(this);
        bt_ranking.addActionListener(this);
        bt_sair.addActionListener(this);
    }


    //acao para os botoes
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() ==  bt_home){
            //chamar a tela inicial
            Main l = new Main();
            l.main(null);
            super.dispose();
        }

        if(e.getSource() ==  bt_ranking){
            //chamar a tela de ranking
            Ranking r = new Ranking();
        }

        if(e.getSource() ==  bt_reiniciar){
            //reiniciar a matriz
           p.reiniciar_tabuleiro();
            minutos = 0;
           segundos = 0;

        }

        if(e.getSource() ==  bt_sair){
            //sair da aplicação
            System.exit(0);
        }
    }

    public class RodarTempo extends Thread
    {
        public void run()
        {

            while(true){
                try{
                    Thread.sleep(1000);
                }catch(Exception erro){}

                segundos++;

                if(segundos < 10){
                    bt_tempo.setText("Tempo  0"+minutos+":0"+segundos+" ");
                }
                else if(segundos > 9 && segundos < 60){
                    bt_tempo.setText("Tempo  0"+minutos+":"+segundos+" ");
                }
                else if(segundos == 60){
                    minutos++;
                    segundos = 0;
                    bt_tempo.setText("Tempo  0"+minutos+":0"+segundos+" ");

                }
            }
        }

    }
}
