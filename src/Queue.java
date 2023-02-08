
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
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Queue extends JFrame
{
    private JPanel contentPane;
    private JTextField element;
    private int[] q;
    private int size;
    private int r;
    private int f;
    private JTextField displaybox;
    private JTextField sizefield;
    Sound m = new Sound();
    URL s ;

    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    final Queue frame = new Queue();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public Queue() {
	s = getClass().getResource("queue.wav");
	m.Setmusic(s);
	m.play();
	setUndecorated(true);
	this.r = -1;
	this.f = 0;
	this.setBackground(Color.WHITE);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(new Color(255, 255, 0));
	contentPane.setBackground(new Color(255, 255, 255));
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);

	sizefield = new JTextField();
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
	sizefield.setFont(new Font("Times New Roman", Font.BOLD, 18));
	sizefield.setBounds(229, 215, 122, 28);
	contentPane.add(sizefield);
	final JLabel lblNewLabel = new JLabel("ENTER QUEUE SIZE");
	lblNewLabel.setForeground(new Color(139, 0, 0));
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel.setBounds(27, 158, 170, 21);
	this.contentPane.add(lblNewLabel);
	final JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT");
	lblEnterAnElement.setForeground(new Color(139, 0, 0));
	lblEnterAnElement.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblEnterAnElement.setBounds(25, 218, 181, 21);
	this.contentPane.add(lblEnterAnElement);
	final JButton btnNewButton = new JButton("CREATE QUEUE");
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		Queue.access$1(Queue.this, Integer.valueOf(Queue.this.sizefield.getText()));
		Queue.access$3(Queue.this, new int[Queue.this.size]);
		final String message = "Queue of size " + Queue.this.size + " created";
		JOptionPane.showMessageDialog(Queue.this.contentPane, message);
	    }
	});
	btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.setBounds(380, 154, 183, 29);
	this.contentPane.add(btnNewButton);
	(this.element = new JTextField()).setColumns(10);
	element.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	element.setFont(new Font("Times New Roman", Font.BOLD, 18));
	element.setHorizontalAlignment(JTextField.CENTER);
	this.element.setBounds(228, 154, 122, 28);;
	this.contentPane.add(this.element);
	final JButton insert = new JButton("INSERT");
	insert.setBackground(Color.WHITE);
	insert.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (Queue.this.r == Queue.this.size - 1) {
		    JOptionPane.showMessageDialog(Queue.this.contentPane, "Insertion not possible");
		}
		else {
		    final int elem = Integer.valueOf(Queue.this.element.getText());
		    final Queue this$0 = Queue.this;
		    Queue.access$7(this$0, this$0.r + 1);
		    Queue.this.q[Queue.this.r] = elem;
		    JOptionPane.showMessageDialog(Queue.this.contentPane, "Element inserted successfully");
		    Queue.this.element.setText("");
		}
	    }
	});
	insert.setFont(new Font("Times New Roman", Font.BOLD, 18));
	insert.setBounds(413, 215, 117, 28);
	this.contentPane.add(insert);
	final JButton delete = new JButton("DELETE");
	delete.setBackground(Color.WHITE);
	delete.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (Queue.this.r == -1 || Queue.this.f > Queue.this.r) {
		    JOptionPane.showMessageDialog(Queue.this.contentPane, "Deletion not possible");
		}
		else {
		    final String message = "Element deleted is:" + Queue.this.q[Queue.this.f];
		    JOptionPane.showMessageDialog(Queue.this.contentPane, message);
		    Queue.this.element.setText("");
		    final Queue this$0 = Queue.this;
		    Queue.access$10(this$0, this$0.f + 1);
		}
	    }
	});
	delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
	delete.setBounds(233, 287, 117, 28);
	this.contentPane.add(delete);
	final JButton display = new JButton("DISPLAY");
	display.setBackground(Color.WHITE);
	display.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		String msg = "";
		if (Queue.this.r == -1 || Queue.this.f > Queue.this.r) {
		    JOptionPane.showMessageDialog(Queue.this.contentPane, "Display not possible");
		}
		else {
		    for (int i = Queue.this.f; i <= Queue.this.r; ++i) {
			msg = String.valueOf(msg) + " " + Queue.this.q[i];
		    }
		    Queue.this.displaybox.setText(msg);
		}
	    }
	});
	display.setFont(new Font("Times New Roman", Font.BOLD, 18));
	display.setBounds(416, 288, 117, 28);
	this.contentPane.add(display);
	(this.displaybox = new JTextField()).setColumns(10);
	displaybox.setFont(new Font("Times New Roman", Font.BOLD, 18));
	displaybox.setHorizontalAlignment(JTextField.CENTER);
	this.displaybox.setBounds(183, 462, 380, 28);
	this.contentPane.add(this.displaybox);

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

	final JButton back = new JButton("");
	back.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	back.setOpaque(false);
	back.setContentAreaFilled(false);
	back.setBorderPainted(false);
	Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	back.setIcon(new ImageIcon(img1));
	back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		new Home().setVisible(true);
		frameInit();dispose();
		m.stop();
	    }
	});
	back.setBounds(912, 596, 83, 59);
	this.contentPane.add(back);

	JLabel bg = new JLabel("");
	Image img11 = new ImageIcon(this.getClass().getResource("queue bg.png")).getImage();
	bg.setIcon(new ImageIcon(img11));
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
    }

    static /* synthetic */ void access$1(final Queue queue, final int size) {
	queue.size = size;
    }

    static /* synthetic */ void access$3(final Queue queue, final int[] q) {
	queue.q = q;
    }

    static /* synthetic */ void access$7(final Queue queue, final int r) {
	queue.r = r;
    }

    static /* synthetic */ void access$10(final Queue queue, final int f) {
	queue.f = f;
    }
}
