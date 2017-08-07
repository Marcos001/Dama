package Indice;

/**
 * Created by marcos on 02/06/16.
 */
        import javax.swing.*;
        import java.awt.*;

/**
 * Created by marcos on 22/05/16.
 */
public class indice extends JPanel{

    JLabel
            i0 = new JLabel(" 0 "),
            i1 = new JLabel(" 1 "),
            i2 = new JLabel(" 2 "),
            i3 = new JLabel(" 3 "),

    i4 = new JLabel(" 4 "),
            i5 = new JLabel(" 5 "),
            i6 = new JLabel(" 6 "),
            i7 = new JLabel(" 7 ");


    public void tamanhoLabel(){

        int l1 = 1;
        int l2 = 1;
        int l3 = 1;

        i0.setSize(50,50); i0.setForeground(new Color(l1,l2,l3));
        i1.setSize(50,50); i1.setForeground(new Color(l1,l2,l3));
        i2.setSize(50,50); i2.setForeground(new Color(l1,l2,l3));
        i3.setSize(50,50); i3.setForeground(new Color(l1,l2,l3));

        i4.setSize(50,50); i4.setForeground(new Color(l1,l2,l3));
        i5.setSize(50,50); i5.setForeground(new Color(l1,l2,l3));
        i6.setSize(50,50); i6.setForeground(new Color(l1,l2,l3));
        i7.setSize(50,50); i7.setForeground(new Color(l1,l2,l3));
    }


    public indice(int layout){

        int linha = 1;
        int coluna = 0;

        if(layout == linha){
            this.setLayout(new GridLayout(8,1));
        }
        if(layout == coluna){
            this.setLayout(new GridLayout(1,8));
        }

        this.setVisible(true);
        this.tamanhoLabel();

        this.add(i0);
        this.add(i1);
        this.add(i2);
        this.add(i3);

        this.add(i4);
        this.add(i5);
        this.add(i6);
        this.add(i7);

    }


}