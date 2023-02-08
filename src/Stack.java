

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Stack extends JFrame
{
    private JPanel contentPane;
    private int[] s;
    private int size;
    private int top;
    private JTextField sizefield;
    private JTextField element;
    Sound m = new Sound();
    URL su ;
    private JTextField displaybox;

    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    final Stack frame = new Stack();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public Stack() {
	su = getClass().getResource("stack.wav");
	m.Setmusic(su);
	m.play();
	setUndecorated(true);
	this.top = -1;
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(new Color(255, 218, 185));
	contentPane.setBackground(new Color(255, 255, 255));
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);

	displaybox = new JTextField();
	displaybox.setHorizontalAlignment(JTextField.CENTER);
	displaybox.setColumns(10);
	displaybox.setBounds(114, 498, 390, 38);
	contentPane.add(displaybox);


	final JLabel lblNewLabel_1 = new JLabel("ENTER THE STACK SIZE");
	lblNewLabel_1.setBackground(Color.WHITE);
	lblNewLabel_1.setForeground(Color.RED);
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel_1.setBounds(140, 122, 185, 20);
	this.contentPane.add(lblNewLabel_1);
	final JButton stack = new JButton("CREATE STACK");
	stack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stack.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		Stack.access$1(Stack.this, Integer.valueOf(Stack.this.sizefield.getText()));
		Stack.access$3(Stack.this, new int[Stack.this.size]);
		final String message = "Stack of size" + Stack.this.size + " created";
		JOptionPane.showMessageDialog(Stack.this.contentPane, message);
	    }
	});
	stack.setFont(new Font("Times New Roman", Font.BOLD, 16));
	stack.setForeground(Color.BLACK);
	stack.setBounds(413, 160, 163, 43);
	this.contentPane.add(stack);


	final JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT");
	lblNewLabel_1_1.setForeground(Color.RED);
	lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblNewLabel_1_1.setBounds(153, 240, 163, 20);
	this.contentPane.add(lblNewLabel_1_1);
	final JButton push = new JButton("PUSH");
	push.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	push.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (Stack.this.top == Stack.this.size - 1) {
		    JOptionPane.showMessageDialog(Stack.this.contentPane, "Push not possible");
		}
		else {
		    final int elem = Integer.valueOf(Stack.this.element.getText());
		    final Stack this$0 = Stack.this;
		    Stack.access$7(this$0, this$0.top + 1);
		    Stack.this.s[Stack.this.top] = elem;
		    JOptionPane.showMessageDialog(Stack.this.contentPane, "Push successfull");
		    Stack.this.element.setText("");
		}
	    }
	});
	push.setFont(new Font("Times New Roman", Font.BOLD, 16));
	push.setBounds(413, 282, 163, 43);
	this.contentPane.add(push);

	JButton exit = new JButton("");
	exit.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	Image img = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
	exit.setIcon(new ImageIcon(img));
	exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(ABORT);
	    }
	});
	exit.setFont(new Font("Times New Roman", Font.BOLD, 14));
	exit.setBounds(474, 591, 83, 59);
	contentPane.add(exit);

	final JButton pop = new JButton("POP");
	pop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	pop.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (Stack.this.top == -1) {
		    JOptionPane.showMessageDialog(Stack.this.contentPane, "Pop not possible");
		}
		else {
		    JOptionPane.showMessageDialog(Stack.this.contentPane, "Element deleted is" + Stack.this.s[Stack.this.top]);
		    Stack.this.element.setText("");
		    final Stack this$0 = Stack.this;
		    Stack.access$7(this$0, this$0.top - 1);
		}
	    }
	});
	pop.setFont(new Font("Times New Roman", Font.BOLD, 16));
	pop.setBounds(413, 389, 163, 43);
	this.contentPane.add(pop);
	final JButton display = new JButton("DISPLAY");
	display.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	display.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		String msg = "";
		if (Stack.this.top == -1) {
		    Stack.this.displaybox.setText(null);
		    JOptionPane.showMessageDialog(Stack.this.contentPane, "Display not possible");
		}
		else {
		    for (int i = Stack.this.top; i >= 0; --i) {
			msg = String.valueOf(msg) + " " + Stack.this.s[i];
		    }
		    Stack.this.displaybox.setText(msg);
		}
	    }
	});
	display.setFont(new Font("Times New Roman", Font.BOLD, 16));
	display.setBounds(42, 389, 163, 43);
	this.contentPane.add(display);

	final JButton back = new JButton("");
	back.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	back.setOpaque(false);
	back.setContentAreaFilled(false);
	back.setBorderPainted(false);
	Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	back.setIcon(new ImageIcon(img1));
	back.setFont(new Font("Times New Roman", Font.BOLD, 14));
	back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		new Home().setVisible(true);
		frameInit();dispose();
		m.stop();
	    }
	});
	back.setBounds(907, 591, 83, 59);
	this.contentPane.add(back);

	sizefield = new JTextField();
	sizefield.setFont(new Font("Times New Roman", Font.BOLD, 16));
	sizefield.setHorizontalAlignment(JTextField.CENTER);
	sizefield.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	sizefield.setColumns(10);
	sizefield.setBounds(166, 163, 138, 38);
	contentPane.add(sizefield);

	element = new JTextField();
	element.setFont(new Font("Times New Roman", Font.BOLD, 16));
	element.setHorizontalAlignment(JTextField.CENTER);
	element.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});

	element.setColumns(10);
	element.setBounds(166, 285, 139, 38);
	contentPane.add(element);

	JLabel bg = new JLabel("");
	bg.setFont(new Font("Times New Roman", Font.BOLD, 16));
	Image img11 = new ImageIcon(this.getClass().getResource("stack bg.png")).getImage();
	bg.setIcon(new ImageIcon(img11));
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
    }

    static /* synthetic */ void access$1(final Stack stack, final int size) {
	stack.size = size;
    }

    static /* synthetic */ void access$3(final Stack stack, final int[] s) {
	stack.s = s;
    }

    static /* synthetic */ void access$7(final Stack stack, final int top) {
	stack.top = top;
    }
}
