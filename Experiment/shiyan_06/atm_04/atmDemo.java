package Experiment.shiyan_06.atm_04;

import javax.swing.*;
public class atmDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           ATMSystem  atmSystem = new ATMSystem();
            atmSystem.setVisible(true);
        });
    }
}
