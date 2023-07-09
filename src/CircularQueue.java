


import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CircularQueue extends JFrame
{
    private JPanel contentPane;
    private JTextField element;
    private JTextField displaybox;
    private int[] cq;
    private int size;
    private int r;
    private int f;
    private int count;
    private JTextField sizefield;
    URL s;
    Sound su = new Sound();

    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    final CircularQueue frame = new CircularQueue();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public CircularQueue() {
	s = getClass().getResource("cqueue.wav");
	su.Setmusic(s);
	su.play();
	setUndecorated(true);
	this.r = -1;
	this.f = 0;
	this.count = 0;
	this.setBackground(UIManager.getColor("Button.shadow"));
	this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(new Color(255, 255, 0));
	contentPane.setBackground(new Color(255, 255, 255));
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);

	JButton exit = new JButton("");
	exit.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		frameInit();dispose();
	    }
	});
	Image img = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
	exit.setIcon(new ImageIcon(img));
	exit.setBounds(488, 590, 74, 59);
	contentPane.add(exit);
	final JLabel lblNewLabel = new JLabel("ENTER QUEUE SIZE");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setBackground(new Color(255, 255, 255));
	lblNewLabel.setBounds(74, 223, 170, 21);
	this.contentPane.add(lblNewLabel);
	final JButton createqueue = new JButton("CREATE QUEUE");
	createqueue.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		CircularQueue.access$1(CircularQueue.this, Integer.valueOf(CircularQueue.this.sizefield.getText()));
		CircularQueue.access$3(CircularQueue.this, new int[CircularQueue.this.size]);
		final String message = "Circular queue of size" + CircularQueue.this.size + "created";
		JOptionPane.showMessageDialog(CircularQueue.this.contentPane, message);
	    }
	});
	createqueue.setFont(new Font("Times New Roman", Font.BOLD, 18));
	createqueue.setBounds(158, 280, 181, 29);
	this.contentPane.add(createqueue);
	final JLabel lblEnterAnElement = new JLabel("ENTER AN ELEMENT");
	lblEnterAnElement.setForeground(new Color(255, 255, 255));
	lblEnterAnElement.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblEnterAnElement.setBackground(Color.WHITE);
	lblEnterAnElement.setBounds(158, 338, 189, 21);
	this.contentPane.add(lblEnterAnElement);
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
	this.element.setBounds(158, 387, 189, 40);
	element.setHorizontalAlignment(SwingConstants.CENTER);
	this.contentPane.add(this.element);
	final JButton insert = new JButton("INSERT");
	insert.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (CircularQueue.this.count == CircularQueue.this.size) {
		    JOptionPane.showMessageDialog(CircularQueue.this.contentPane, " Insertion not possible");
		}
		else {
		    final int elem = Integer.valueOf(CircularQueue.this.element.getText());
		    CircularQueue.access$8(CircularQueue.this, (CircularQueue.this.r + 1) % CircularQueue.this.size);
		    CircularQueue.this.cq[CircularQueue.this.r] = elem;
		    final CircularQueue this$0 = CircularQueue.this;
		    CircularQueue.access$10(this$0, this$0.count + 1);
		    final String message = "Insertion successfull";
		    JOptionPane.showMessageDialog(CircularQueue.this.contentPane, message);
		    CircularQueue.this.element.setText("");
		}
	    }
	});
	insert.setFont(new Font("Times New Roman", Font.BOLD, 18));
	insert.setBounds(74, 465, 109, 29);
	this.contentPane.add(insert);
	final JButton delete = new JButton("DELETE");
	delete.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (CircularQueue.this.count == 0) {
		    JOptionPane.showMessageDialog(CircularQueue.this.contentPane, " Deletion not possible");
		}
		else {
		    JOptionPane.showMessageDialog(CircularQueue.this.contentPane, " Element deleted is" + CircularQueue.this.cq[CircularQueue.this.f]);
		    CircularQueue.access$12(CircularQueue.this, (CircularQueue.this.f + 1) % CircularQueue.this.size);
		    final CircularQueue this$0 = CircularQueue.this;
		    CircularQueue.access$10(this$0, this$0.count - 1);
		    CircularQueue.this.element.setText("");
		}
	    }
	});
	delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
	delete.setBounds(205, 465, 109, 29);
	this.contentPane.add(delete);
	final JButton display = new JButton("DISPLAY");
	display.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		String msg = "";
		int f1 = CircularQueue.this.f;
		if (CircularQueue.this.count == 0) {
		    JOptionPane.showMessageDialog(CircularQueue.this.contentPane, "Display not possible");
		}
		else {
		    for (int i = 1; i <= CircularQueue.this.count; ++i) {
			msg = String.valueOf(msg) + " " + CircularQueue.this.cq[f1];
			f1 = (f1 + 1) % CircularQueue.this.size;
		    }
		    CircularQueue.this.displaybox.setText(msg);
		}
	    }
	});
	display.setFont(new Font("Times New Roman", Font.BOLD, 18));
	display.setBounds(335, 465, 118, 29);
	this.contentPane.add(display);
	(this.displaybox = new JTextField()).setColumns(10);
	displaybox.setFont(new Font("Times New Roman", Font.BOLD, 18));
	displaybox.setHorizontalAlignment(SwingConstants.CENTER);
	this.displaybox.setBounds(73, 524, 380, 40);
	this.contentPane.add(this.displaybox);
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
		su.stop();
		new Home().setVisible(true);
		frameInit();dispose();
	    }
	});
	back.setBounds(907, 590, 83, 59);
	this.contentPane.add(back);

	sizefield = new JTextField();
	sizefield.setHorizontalAlignment(SwingConstants.CENTER);
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
	sizefield.setBounds(292, 214, 161, 40);
	contentPane.add(sizefield);

	JLabel bg = new JLabel("");
	Image img2 = new ImageIcon(this.getClass().getResource("/cqueue bg.png")).getImage();
	bg.setIcon(new ImageIcon(img2));
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
    }

    static /* synthetic */ void access$1(final CircularQueue circularQueue, final int size) {
	circularQueue.size = size;
    }

    static /* synthetic */ void access$3(final CircularQueue circularQueue, final int[] cq) {
	circularQueue.cq = cq;
    }

    static /* synthetic */ void access$8(final CircularQueue circularQueue, final int r) {
	circularQueue.r = r;
    }

    static /* synthetic */ void access$10(final CircularQueue circularQueue, final int count) {
	circularQueue.count = count;
    }

    static /* synthetic */ void access$12(final CircularQueue circularQueue, final int f) {
	circularQueue.f = f;
    }
}
