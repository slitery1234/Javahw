import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.lang.*;

public class GUI extends JFrame implements KeyListener, ItemListener {

    private JTextArea promptBox, typeBox;
    private ButtonGroup bgroup;
    private java.util.List<JButton> buttons;
    private String words, prompt, typedText;

    public GUI() {
        this.setLayout(null);
        setVisible(true);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        words = "~1234567890-+QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,.? ";
        
        prompt = "Type some text using your keyboard. The keys you press will be hightlighted and the text will be displayed.\nNote: Clicking the buttons with your mouse will not perform any action.";
        typedText = "";
        bgroup = new ButtonGroup();
        promptBox = new JTextArea(prompt);
        typeBox = new JTextArea(typedText);
        buttons = new ArrayList<JButton>();

        promptBox.setSize(760, 50);
        promptBox.setLocation(10, 10);
        promptBox.setFocusable(false);
        promptBox.setBackground(null);
        promptBox.setLineWrap(true);
        promptBox.setWrapStyleWord(true);

        typeBox.setSize(760, 150);
        typeBox.setLocation(10, 60);
        typeBox.setFocusable(false);
        typeBox.setLineWrap(true);
        typeBox.setWrapStyleWord(true);
        typeBox.setCaretPosition(0);
        typeBox.getCaret().setVisible(true);

        Container pane = getContentPane();
        pane.add(promptBox);
        pane.add(typeBox);
        addButtons();
        addOtherButtons();

        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void addButtons() {
        for (int i = 0; i < words.length()-1; ++i) {
            buttons.add(new JButton(Character.toString(words.charAt(i))));
            buttons.get(i).setSize(50, 50);
            
            if (i <= 12) {
                buttons.get(i).setLocation(10 + 50*i, 250);
            }
            else if (i >= 13 && i <= 25) {
                buttons.get(i).setLocation(85 + 50*(i-13), 300);
            }
            else if (i >= 26 && i <= 36) {
                buttons.get(i).setLocation(85 + 50*(i-26), 350);
            }
            else if (i >= 37 && i <= 46) {
                buttons.get(i).setLocation(110 + 50*(i-37), 400);
            }
            
            this.getContentPane().add(buttons.get(i));
            buttons.get(i).setFocusable(false);
        }
    }
    public void addOtherButtons() {
    	// 47
    	JButton backspace = new JButton("Backspace");
    	buttons.add(backspace);
    	backspace.setSize(100, 50);
    	backspace.setLocation(660, 250);
        this.getContentPane().add(backspace);
        // 48
    	JButton tab = new JButton("Tab");
    	buttons.add(tab);
    	tab.setSize(75, 50);
    	tab.setLocation(10, 300);
        this.getContentPane().add(tab);
        // 49
    	JButton caps = new JButton("Caps");
    	buttons.add(caps);
    	caps.setSize(75, 50);
    	caps.setLocation(10, 350);
        this.getContentPane().add(caps);
        // 50
    	JButton enter = new JButton("Enter");
    	buttons.add(enter);
    	enter.setSize(100, 50);
    	enter.setLocation(635, 350);
        this.getContentPane().add(enter);
        // 51
    	JButton shift = new JButton("Shift");
    	buttons.add(shift);
    	shift.setSize(100, 50);
    	shift.setLocation(10, 400);
        this.getContentPane().add(shift);
        // 52
        JButton spacebar = new JButton();
        buttons.add(spacebar);
        spacebar.setSize(450, 50);
        spacebar.setLocation(100, 450);
        this.getContentPane().add(spacebar);
        // 53
        JButton up = new JButton("^");
        buttons.add(up);
        up.setSize(50, 50);
        up.setLocation(635, 400);
        this.getContentPane().add(up);
        // 54
        JButton left = new JButton("<");
        buttons.add(left);
        left.setSize(50, 50);
        left.setLocation(585, 450);
        this.getContentPane().add(left);
        // 55
        JButton down = new JButton("v");
        buttons.add(down);
        down.setSize(50, 50);
        down.setLocation(635, 450);
        this.getContentPane().add(down);
        // 56
        JButton right = new JButton(">");
        buttons.add(right);
        right.setSize(50, 50);
        right.setLocation(685, 450);
        this.getContentPane().add(right);
    }


    @Override
    public void keyPressed (KeyEvent e) {
        int i = words.indexOf(Character.toUpperCase(e.getKeyChar()));
        if(e.getKeyChar() == '`') {
        	i = words.indexOf('~');
        }
        else if(e.getKeyChar() == '_') {
        	i = words.indexOf('-');
        }
        else if(e.getKeyChar() == '=') {
        	i = words.indexOf('+');
        }
        else if(e.getKeyChar() == '{') {
        	i = words.indexOf('[');
        }
        else if(e.getKeyChar() == '}') {
        	i = words.indexOf(']');
        }
        else if(e.getKeyChar() == '|') {
        	i = words.indexOf('\\');
        }
        else if(e.getKeyChar() == ':') {
        	i = words.indexOf(';');
        }
        else if(e.getKeyChar() == '"') {
        	i = words.indexOf('\'');
        }
        else if(e.getKeyChar() == '<') {
        	i = words.indexOf(',');
        }
        else if(e.getKeyChar() == '>') {
        	i = words.indexOf('.');
        }
        else if(e.getKeyChar() == '/') {
        	i = words.indexOf('?');
        }
        else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        	i = 47;
        }
        else if(e.getKeyCode() == KeyEvent.VK_TAB) {
        	i = 48;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_CAPS_LOCK ) {
        	i = 49;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_ENTER) {
        	i = 50;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_SHIFT) {
        	i = 51;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_SPACE) {
        	i = 52;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_UP) {
        	i = 53;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_LEFT) {
        	i = 54;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_DOWN) {
        	i = 55;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_RIGHT) {
        	i = 56;
        }
        if(i == -1)
        	System.err.println("DON'T PRESS THIS. I CAN'T DO THIS");
        else
        	buttons.get(i).setBackground(Color.lightGray);
        if(i <= 46) {
        	if(typedText == null || typedText == "" ){
                char c = e.getKeyChar();
                typedText = Character.toString(c);
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else if(typeBox.getCaretPosition() == typedText.length()){
                typedText += e.getKeyChar();
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else {
        		int temp = typeBox.getCaretPosition();
        		typedText = typedText.substring(0,temp) + e.getKeyChar() + typedText.substring(temp,typedText.length());
                typeBox.setText(typedText);
                typeBox.setCaretPosition(temp+1);
        	}
        }
        else if(i == 47){
        	if(typeBox.getCaretPosition() == 0){
        		// DO NOTHING
        		System.err.println("DON'T KEEP PRESSING. IT'S USELESS!");
            }
        	else if(typeBox.getCaretPosition() == typedText.length()){
                typedText = typedText.substring(0,typedText.length()-1);
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else {
        		int temp = typeBox.getCaretPosition();
        		typedText = typedText.substring(0,temp-1) + typedText.substring(temp,typedText.length());
                typeBox.setText(typedText);
                typeBox.setCaretPosition(temp-1);
        	}
        }
        else if(i == 48){
        	if(typedText == null || typedText == "" ){
                typedText = "  ";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else if(typeBox.getCaretPosition() == typedText.length()){
                typedText += "  ";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else {
        		int temp = typeBox.getCaretPosition();
        		typedText = typedText.substring(0,temp) + "  " + typedText.substring(temp,typedText.length());
                typeBox.setText(typedText);
                typeBox.setCaretPosition(temp+2);
        	}
        }
        else if(i == 49){
        	// DO NOTHING
        	// MAYBE CHANGE BUTTON NAME
        	// BUT I CAN'T DEAL WITH THIS
        }
        else if(i == 50){
        	if(typedText == null || typedText == "" ){
                typedText = "\n";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else if(typeBox.getCaretPosition() == typedText.length()){
                typedText += "\n";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else {
        		int temp = typeBox.getCaretPosition();
        		typedText = typedText.substring(0,temp) + "\n" + typedText.substring(temp,typedText.length());
                typeBox.setText(typedText);
                typeBox.setCaretPosition(temp+1);
        	}
        }
        else if(i == 51){
        	// DO NOTHING
        	// I DON'T KNOW WHAT I SHOULD DO
        }
        else if(i == 52){
        	if(typedText == null || typedText == "" ){
                typedText = " ";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else if(typeBox.getCaretPosition() == typedText.length()){
                typedText += " ";
                typeBox.setText(typedText);
                typeBox.setCaretPosition(typedText.length());
            }
        	else {
        		int temp = typeBox.getCaretPosition();
        		typedText = typedText.substring(0,temp) + " " + typedText.substring(temp,typedText.length());
                typeBox.setText(typedText);
                typeBox.setCaretPosition(temp+1);
        	}
        }
        else if(i == 53 || i == 55){
        	// DO NOTHING
        	// I CAN'T DEAL WITH THIS
        }
        else if(i == 54){
        	if(typeBox.getCaretPosition() > 0)
        		typeBox.setCaretPosition(typeBox.getCaretPosition() -1);
        	else
        		System.err.println("DON'T KEEP PRESSING. IT'S USELESS!");
        }
        else if(i == 56){
        	if(typeBox.getCaretPosition() < typedText.length())
        		typeBox.setCaretPosition(typeBox.getCaretPosition() +1);
        	else
        		System.err.println("DON'T KEEP PRESSING. IT'S USELESS!");
        }
    }


    @Override
    public void keyReleased (KeyEvent e) {
        int i = words.indexOf(Character.toUpperCase(e.getKeyChar()));
        if(e.getKeyChar() == '`') {
        	i = words.indexOf('~');
        }
        else if(e.getKeyChar() == '_') {
        	i = words.indexOf('-');
        }
        else if(e.getKeyChar() == '=') {
        	i = words.indexOf('+');
        }
        else if(e.getKeyChar() == '{') {
        	i = words.indexOf('[');
        }
        else if(e.getKeyChar() == '}') {
        	i = words.indexOf(']');
        }
        else if(e.getKeyChar() == '|') {
        	i = words.indexOf('\\');
        }
        else if(e.getKeyChar() == ':') {
        	i = words.indexOf(';');
        }
        else if(e.getKeyChar() == '"') {
        	i = words.indexOf('\'');
        }
        else if(e.getKeyChar() == '<') {
        	i = words.indexOf(',');
        }
        else if(e.getKeyChar() == '>') {
        	i = words.indexOf('.');
        }
        else if(e.getKeyChar() == '/') {
        	i = words.indexOf('?');
        }
        else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        	i = 47;
        }
        else if(e.getKeyCode() == KeyEvent.VK_TAB) {
        	i = 48;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_CAPS_LOCK ) {
        	i = 49;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_ENTER) {
        	i = 50;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_SHIFT) {
        	i = 51;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_SPACE) {
        	i = 52;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_UP) {
        	i = 53;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_LEFT) {
        	i = 54;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_DOWN) {
        	i = 55;
        }
        else if(e.getKeyCode() == KeyEvent.	VK_RIGHT) {
        	i = 56;
        }

        if(i == -1)
        	System.err.println("DON'T PRESS THIS. I CAN'T DO THIS");
        else
        	buttons.get(i).setBackground(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }



    public void itemStateChanged(ItemEvent e) {
        
    }
}





