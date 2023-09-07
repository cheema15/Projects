import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.JTextArea;

public class Game {

    JFrame gamewindow;
    Container con;
    JPanel titleNamePanel, startButtonPanel, firstTextPanel, optionButtonPanel, healthPanel;
    JLabel titleNameLabel, healthLabel, healthLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, option1, option2, option3, option4;
    JTextArea firstTextArea;
    int playerHealth, jokerHealth, gothamKey;
    String weapon, position;
    TitleScreenStart tsStart = new TitleScreenStart();
    optionHandler optionHandler = new optionHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        gamewindow = new JFrame();
        gamewindow.setSize(800, 800);
        gamewindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamewindow.getContentPane().setBackground(Color.BLACK);
        gamewindow.setLayout(null);
        gamewindow.setVisible(true);
        con = gamewindow.getContentPane();
//The panel for the title! This will show the games tile and include the start Button!
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("Batmans Quest");
        titleNameLabel.setForeground(Color.YELLOW);
        titleNameLabel.setFont(titleFont);
//start button panel to make the button to go to next page
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.YELLOW);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsStart);
        startButton.setFocusPainted(false);

//adds to the panel so that the output is shown on the panel
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    //new page which starts the game!
    public void makeGameScreen() {
        //don't show the start button and the text from title page
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        //creates the panel to start the first question of the game
        firstTextPanel = new JPanel();
        firstTextPanel.setBounds(100, 100, 600, 250);
        firstTextPanel.setBackground(Color.BLACK);
        con.add(firstTextPanel);


        firstTextArea = new JTextArea("");
        firstTextArea.setBounds(100, 100, 600, 250);
        firstTextArea.setBackground(Color.BLACK);
        firstTextArea.setForeground(Color.YELLOW);
        firstTextArea.setFont(normalFont);
        firstTextArea.setLineWrap(true);
        firstTextPanel.add(firstTextArea);
        //creates the buttons for the options
        optionButtonPanel = new JPanel();
        optionButtonPanel.setBounds(150, 350, 500, 150);
        optionButtonPanel.setBackground(Color.BLACK);
        optionButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(optionButtonPanel);
        //creates what is on each button and adds button to the panel
        option1 = new JButton("option 1");
        option1.setBackground(Color.BLACK);
        option1.setForeground(Color.YELLOW);
        option1.setFont(normalFont);
        optionButtonPanel.add(option1);
        option1.setFocusPainted(false);
        option1.addActionListener(optionHandler);
        option1.setActionCommand("option1");

        option2 = new JButton("option 2");
        option2.setBackground(Color.BLACK);
        option2.setForeground(Color.YELLOW);
        option2.setFont(normalFont);
        optionButtonPanel.add(option2);
        option2.setFocusPainted(false);
        option2.addActionListener(optionHandler);
        option2.setActionCommand("option2");

        option3 = new JButton("option 3");
        option3.setBackground(Color.BLACK);
        option3.setForeground(Color.YELLOW);
        option3.setFont(normalFont);
        optionButtonPanel.add(option3);
        option3.setFocusPainted(false);
        option3.addActionListener(optionHandler);
        option3.setActionCommand("option3");

        option4 = new JButton("option 4");
        option4.setBackground(Color.BLACK);
        option4.setForeground(Color.YELLOW);
        option4.setFont(normalFont);
        optionButtonPanel.add(option4);
        option4.setFocusPainted(false);
        option4.addActionListener(optionHandler);
        option4.setActionCommand("option4");

        //panel to add the health and the weapon in use!
        healthPanel = new JPanel();
        healthPanel.setBounds(100, 15, 600, 50);
        healthPanel.setBackground(Color.BLACK);
        healthPanel.setForeground(Color.YELLOW);
        healthPanel.setLayout(new GridLayout(1, 4));
        con.add(healthPanel);

        //labels for the health and the weapons
        healthLabel = new JLabel("Hp: ");
        healthLabel.setFont(normalFont);
        healthLabel.setForeground(Color.YELLOW);
        healthPanel.add(healthLabel);
        healthLabelNumber = new JLabel();
        healthLabelNumber.setFont(normalFont);
        healthLabelNumber.setForeground(Color.YELLOW);
        healthPanel.add(healthLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.YELLOW);
        healthPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.YELLOW);
        healthPanel.add(weaponLabelName);

        healthSetup();
    }
    public void directions(){
        position = "directions";
        firstTextArea.setText("The object of the game is to take batman through Gotham to look for the Joker! When you find the Joker take back what he took from gotham and \nreturn it to the Gotham police station!");
        option1.setText("Continue...");
        option2.setText("");
        option3.setText("");
        option4.setText("");
    }

    public void healthSetup() {
        playerHealth = 20;
        jokerHealth = 30;
        weapon = "Grappler";
        weaponLabelName.setText(weapon);
        healthLabelNumber.setText("" + playerHealth);

        gothamGate();
    }

    public void gothamGate() {
        position = "gothamGate";
        firstTextArea.setText("You're in Gotham in front of the entrance gate!\nA Gotham police officer is standing in front of \nyou. \n\n What will you do? ");
        option1.setText("Talk to the officer");
        option2.setText("Use the Grappler");
        option3.setText("Look around for someone else");
        option4.setText("Go somewhere else!");
    }

    public void speakOfficer() {
        position = "speakOfficer";
        firstTextArea.setText("Gotham officer:\n Hey Batman have you captured the Joker yet?");
        option1.setText("No I should look for him now");
        option2.setText("");
        option3.setText("");
        option4.setText("");
    }

    public void useGrappler() {
        position = "useGrappler";
        firstTextArea.setText("Gotham officer:\n Hey batman don't be dumb I can arrest you too \nyou know.\n The gotham officer could have hit you back and you could have lost health. Be careful when you use your weapon!");
        option1.setText("I am sorry I used it by mistake");
        option2.setText("Whatever you say!");
        option3.setText("");
        option4.setText("");
    }

    public void lookSomewhere() {
        position = "lookSomewhere";
        firstTextArea.setText("You look around but there is no one else around!");
        option1.setText("Back to square one again!");
        option2.setText("");
        option3.setText("");
        option4.setText("");

    }

    public void letsGo() {
        position = "letsGo";
        firstTextArea.setText("You have left and now in front of you is the \nGotham bridge.On the right is a abandoned \nbuilding On your left is your Batmobile! \nWhere do you wanna go? ");
        option1.setText("The bridge");
        option2.setText("The batmobile");
        option3.setText("The abandoned Building");
        option4.setText("Back to the officer");
    }
    public void theBridge(){
        position = "theBridge";
        firstTextArea.setText(" You arrive in front of the bridge. There is a sign it reads LEAVING GOTHAM COME BACK \nSOON! As you walk to the bridge you notice that the bridge is on lockdown so the joker must still be in Gotham somewhere! \nWhere should I go next? ");
        option1.setText("The Batmobile");
        option2.setText("The abandonded Building");
        option3.setText("Back to the officer");
        option4.setText("");
    }
    public void batMobile(){
        position = "batMobile";
        firstTextArea.setText(" You walk up to the batmobile you open the \ntrunk and get a new weapon the Stungun! And \nyou also change into a better quality suit sent by \nOracle which gives you 5 more HP. \nWhere will you go next?");
    playerHealth = playerHealth + 5;
    healthLabelNumber.setText("" + playerHealth);
        weapon = "Stungun";
    weaponLabelName.setText(weapon);
        option1.setText("The abandonded Building");
        option2.setText("The bridge");
        option3.setText("Back to the officer");
        option4.setText("");

    }
    public void abandonedBuilding(){
        position = "abandonedBuilding";
        firstTextArea.setText("You go to the abandoned building and there is a \nstreet gang! When they see you they all runaway! You walk into the building and there you find the joker! \nWhat will you do?");
        option1.setText("Fight");
        option2.setText("Run");
        option3.setText("");
        option4.setText("");
    }
    public void fight(){
        position = "fight";
        firstTextArea.setText("Joker HP:"+ jokerHealth +  "\n\nNow what will you do?");
        option1.setText("Use weapon and Fight");
        option2.setText("Run");
        option3.setText("");
        option4.setText("");
    }
    public void batmanFights() {
        position = "batmanFights";

        int batmanDamage = 0;

        if (weapon.equals("Grappler")) {
            batmanDamage = new java.util.Random().nextInt(4);
        }
        else if (weapon.equals("Stungun")){
            batmanDamage = new java.util.Random().nextInt(7);
        }
        firstTextArea.setText(" You hit the joker and gave "+ batmanDamage + " damage!");
        jokerHealth = jokerHealth - batmanDamage;

    }
    public void jokerAttack(){
        position = "jokerAttack";

        int jokerDamage = 0;
        jokerDamage = new java.util.Random().nextInt(4);
        firstTextArea.setText(" The joker hit you back and gave you "+ jokerDamage +" damage!");
   playerHealth = playerHealth - jokerDamage;
   healthLabelNumber.setText(""+playerHealth);
        option1.setText("Use weapon and Fight");
        option2.setText("Run");
        option3.setText("");
        option4.setText("");
    }
    public void  winGame(){
    position = "Win";
    firstTextArea.setText("You have defeated the Joker\n The The joker fell to the ground you search \nthough his cloths and find the key \nto gotham that everyone has been looking for!");
    gothamKey = 1;
        option1.setText("Go back outside!");
        option2.setText("");
        option3.setText("");
        option4.setText("");
    }
    public void lostGame(){
        position= "lost";
        firstTextArea.setText("You are dead\n\n GAME OVER");

        option1.setText("");
        option2.setText("");
        option3.setText("");
        option4.setText("");
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
    }
    public void finish(){
        position = "ending";
        firstTextArea.setText("Officer: Wow batman you got the joker and \nthe key to Gotham that everyone is looking for!  \nGood job Batman you saved the City of Gotham!\n\n THE  END!");
        option1.setText("");
        option2.setText("");
        option3.setText("");
        option4.setText("");
        option1.setVisible(false);
        option2.setVisible(false);
        option3.setVisible(false);
        option4.setVisible(false);
    }

        //creates the action to go from title screen to new page with question
    public class TitleScreenStart implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            makeGameScreen();
            directions();
        }

    }

        public class optionHandler implements ActionListener {

            public void actionPerformed(ActionEvent event) {

                String yourAnswer = event.getActionCommand();


                switch (position) {
                    case "directions":
                        switch(yourAnswer){
                            case "option1":
                                gothamGate();break;
                        }
                        break;
                    case "gothamGate":
                        switch (yourAnswer) {
                            case "option1":
                                if(gothamKey ==1){
                                    finish();
                                }
                                else {
                                    speakOfficer();
                                }
                                break;
                            case "option2":
                                useGrappler();
                                break;
                            case "option3":
                                lookSomewhere();
                                break;
                            case "option4":
                                letsGo();
                                break;

                        }
                        break;

                    case "speakOfficer":
                        switch (yourAnswer) {
                            case "option1":
                                gothamGate();
                                break;
                            case "option2":
                                gothamGate();
                            case "option3":
                                gothamGate();
                            case "option4":
                                gothamGate();
                        }
                        break;
                    case "useGrappler":
                    case "lookSomewhere":
                        switch (yourAnswer) {
                            case "option1":
                                gothamGate();
                            case "option2":
                                gothamGate();
                            case "option3":
                                gothamGate();
                            case "option4":
                                gothamGate();
                        }
                        break;
                    case "letsGo":
                        switch (yourAnswer) {
                            case "option1":
                                theBridge();
                                break;
                            case "option2":
                                batMobile();
                                break;
                            case "option3":
                                abandonedBuilding();
                                break;
                            case "option4":
                                gothamGate();
                                break;

                        }
                        break;

                    case "theBridge":
                        switch (yourAnswer) {
                            case "option1":
                                batMobile();
                                break;
                            case "option2":
                                abandonedBuilding();
                                break;
                            case "option3":
                                gothamGate();
                                break;
                            case "option4":
                                break;
                        }
                        break;
                    case "batMobile":
                        switch (yourAnswer) {
                            case "option1":
                                abandonedBuilding();
                                break;
                            case "option2":
                                theBridge();
                                break;
                            case "option3":
                                gothamGate();
                                break;
                            case "option4":
                                break;

                        }
                        break;
                    case "abandonedBuilding":
                        switch (yourAnswer) {
                            case "option1":
                                fight();
                                break;
                            case "option2":
                                letsGo();
                                break;
                        }
                    case "fight":
                        switch (yourAnswer) {
                            case "option1":
                                batmanFights();
                                break;
                            case "option2":
                                letsGo();
                                break;
                        }
                        break;
                    case "batmanFights":
                        switch (yourAnswer) {
                            case "option1":
                                if (jokerHealth < 1) {
                                    winGame();
                                }
                                else {
                                    jokerAttack();
                                }
                                break;
                        }
                        break;
                    case "jokerAttack":
                        switch (yourAnswer) {
                            case "option1":
                                if (playerHealth<1) {
                                    lostGame();
                                }
                                else {
                                    fight();
                                }
                                break;
                        }
                        break;
                    case"Win":
                        switch(yourAnswer){
                            case"option1":
                                letsGo();
                        }
                        break;
                }
            }
        }
    }





