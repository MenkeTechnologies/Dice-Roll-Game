import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by jacobmenke on 4/8/16.
 */
public class mp6 extends JFrame {

    private JPanel playerPanel;
    private JPanel computerPanel;
    private JPanel buttonPanel;
    private JLabel outcomeLabel;
    private JLabel playerLabel;
    private JLabel computerLabel;
    private JButton button;


    JGraphicDie[] JplayerDice = new JGraphicDie[5];
    JGraphicDie[] JcomputerDice = new JGraphicDie[5];

    public mp6() {
        super("MP6");
        setLayout(new BorderLayout());
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel biggerPanel = new JPanel();
        biggerPanel.setLayout(new GridLayout(3, 1));

        playerPanel = new JPanel();
        biggerPanel.add(playerPanel);

        playerLabel = new JLabel("Player Dice");

        playerPanel.add(playerLabel);
        playerPanel.setLayout(new GridLayout(1,6));

        computerPanel = new JPanel();

        biggerPanel.add(computerPanel);
        computerLabel = new JLabel("Computer Dice");

        computerPanel.add(computerLabel);
        computerPanel.setLayout(new GridLayout(1,6));


        buttonPanel = new JPanel();
        biggerPanel.add(buttonPanel);

        outcomeLabel = new JLabel("Click the button to roll");
        JButton button = new JButton("ClickMe");
        button.setBackground(Color.white);

        buttonPanel.setLayout(new GridLayout(2,1));
        buttonPanel.add(button);
        buttonPanel.add(outcomeLabel);
        add(biggerPanel, BorderLayout.CENTER);

        event e = new event();



        button.addActionListener(e);

    }


    public int getHighestKind(JGraphicDie[] dice) {
        int temp = 0;


        int[] counters = new int[6];
        for (int j = 0; j < counters.length; j++) {
            counters[j] = 0;
        }

        for (int i = 0; i < dice.length; i++) {
            switch (dice[i].newDie.getDieValue()) {
                case 1:
                    counters[0]++;
                    break;
                case 2:
                    counters[1]++;
                    break;
                case 3:
                    counters[2]++;
                    break;
                case 4:
                    counters[3]++;
                    break;
                case 5:
                    counters[4]++;
                    ;
                    break;
                case 6:
                    counters[5]++;
                    break;
            }


        }

        for (int j = 0; j < counters.length; j++) {


            if (counters[j] > temp) {
                temp = counters[j];
            }
        }

        return temp;
    }


    public static void main(String[] args) {
        mp6 gui = new mp6();
        gui.setVisible(true);

    }

    class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String buttonString = e.getActionCommand();
            if (buttonString.equals("ClickMe")){



                for (int i = 0; i < JplayerDice.length; i++) {

                    if (JplayerDice[i]!= null){
                        playerPanel.remove(JplayerDice[i]);
                    }
                    JplayerDice[i] = new JGraphicDie();

                    playerPanel.add(JplayerDice[i]);
                    System.out.println("Players's Die " + (i + 1) + " has a value of " + JplayerDice[i].newDie.getDieValue());
                }

                for (int i = 0; i < JcomputerDice.length; i++) {
                    if (JcomputerDice[i]!= null){
                        computerPanel.remove(JcomputerDice[i]);
                    }
                    JcomputerDice[i] = new JGraphicDie();
                    computerPanel.add(JcomputerDice[i]);
                    System.out.println("Computer's Die " + (i + 1) + " has a value of " + JcomputerDice[i].newDie.getDieValue());
                }

                int playerOutcome = getHighestKind(JplayerDice);
                int computerOutcome = getHighestKind(JcomputerDice);

                System.out.println("Player has " + playerOutcome + " of a kind.");
                System.out.println("Computer has " + computerOutcome + " of a kind.");
                if (playerOutcome > computerOutcome) {
                    System.out.println("Player wins.");
                } else if (playerOutcome == computerOutcome) {
                    System.out.println("Tie.");
                } else {
                    System.out.println("Computer wins.");
                }

        String message = "Player has " + playerOutcome + " of a kind and Computer has " + computerOutcome + " of a kind.  ";
            if (playerOutcome > computerOutcome) {
                message += "Player wins.";
            } else if (playerOutcome == computerOutcome) {
                message +="Tie.";
            } else {
               message += "Computer wins.";
            }

                outcomeLabel.setText(message);

            }




        }
    }

}
