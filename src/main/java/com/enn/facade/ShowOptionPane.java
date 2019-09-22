package  com.enn.facade;

import javax.swing.*;
import java.awt.*;

/**
 * @author hacker
 */
public class ShowOptionPane {
    public static void main(String[]args){

        Font font = new Font("Dialog",Font.PLAIN,18);
        UIManager.put("Button.font",font);
        UIManager.put("Label.font",font);

        int option;
        do{
            option = JOptionPane.showConfirmDialog(null,"Had enough?","A Stubborn Dialog",JOptionPane.YES_NO_OPTION);
        }while (option == JOptionPane.NO_OPTION);
    }
}
