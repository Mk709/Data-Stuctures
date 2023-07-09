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
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({ "serial", "unused" })
public class Array extends JFrame
{
    private JPanel contentPane;
    private JTextField displaybox;
    private int[] arr;
    private JTextField length;
    private JTextField insertposition;
    private JTextField deleteposition;
    private JTextField element;
    Sound m = new Sound();
    URL s ;
    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    final Array frame = new Array();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public Array() {
	s = getClass().getResource("array.wav");
	m.Setmusic(s);
	m.play();
	setUndecorated(true);
	setType(Type.UTILITY);
	this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(new Color(0, 255, 255));
	contentPane.setBackground(new Color(255, 255, 255));
	this.contentPane.setForeground(new Color(230, 230, 250));
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);

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
	exit.setBounds(461, 591, 83, 59);
	contentPane.add(exit);

	JLabel lblNewLabel_3_1 = new JLabel("DELETE POSITION");
	lblNewLabel_3_1.setForeground(new Color(52, 166, 200));
	lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel_3_1.setBounds(63, 292, 176, 21);
	contentPane.add(lblNewLabel_3_1);

	deleteposition = new JTextField();
	deleteposition.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	deleteposition.setFont(new Font("Times New Roman", Font.BOLD, 18));
	deleteposition.setColumns(10);
	deleteposition.setHorizontalAlignment(SwingConstants.CENTER);
	deleteposition.setBounds(63, 337, 176, 36);
	contentPane.add(deleteposition);

	element = new JTextField();
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
	element.setColumns(10);
	element.setHorizontalAlignment(SwingConstants.CENTER);
	element.setBounds(63, 220, 176, 36);
	contentPane.add(element);
	final JLabel lblNewLabel = new JLabel("ENTER ARRAY LENGTH");
	lblNewLabel.setForeground(new Color(52, 166, 200));
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel.setBounds(43, 74, 224, 21);
	this.contentPane.add(lblNewLabel);
	final JButton create_array = new JButton("CREATE ARRAY");
	create_array.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		final int len = Integer.valueOf(Array.this.length.getText());
		Array.access$1(Array.this, new int[len]);
		final String message = "Array of length " + len + " created";
		JOptionPane.showMessageDialog(Array.this.contentPane, message);
	    }
	});
	create_array.setFont(new Font("Times New Roman", Font.BOLD, 18));
	create_array.setBounds(736, 70, 190, 29);
	this.contentPane.add(create_array);
	final JLabel lblNewLabel_1 = new JLabel("INSERT AN INTEGER ELEMENT");
	lblNewLabel_1.setForeground(new Color(52, 166, 200));
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel_1.setBounds(10, 188, 286, 21);
	this.contentPane.add(lblNewLabel_1);

	final JButton insert = new JButton("INSERT");
	insert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	insert.addActionListener(new ActionListener() {

	    public void actionPerformed(final ActionEvent arg0) {
		int elem = Integer.valueOf(Array.this.element.getText());
		int pos = Integer.valueOf(Array.this.insertposition.getText());
		Array.this.arr[pos] = elem;
		final String message = "Element inserted at position" + pos;
		JOptionPane.showMessageDialog(Array.this.contentPane, message);
		Array.this.element.setText("");
		Array.this.insertposition.setText("");
	    }
	});
	insert.setFont(new Font("Times New Roman", Font.BOLD, 18));
	insert.setBounds(763, 165, 152, 66);
	this.contentPane.add(insert);


	final JLabel lblNewLabel_3 = new JLabel("POSITION");
	lblNewLabel_3.setForeground(new Color(255, 255, 255));
	lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel_3.setBounds(427, 188, 87, 21);
	this.contentPane.add(lblNewLabel_3);
	final JButton delete = new JButton("DELETE");
	delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	delete.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		final int pos = Integer.valueOf(Array.this.deleteposition.getText());
		Array.this.arr[pos] = 0;
		final String message = "Element deleted at position" + pos;
		JOptionPane.showMessageDialog(Array.this.contentPane, message);
		Array.this.deleteposition.setText("");
	    }
	});
	delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
	delete.setBounds(763, 269, 152, 66);
	this.contentPane.add(delete);
	final JButton display = new JButton("DISPLAY");
	display.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	display.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		String msg = "";
		for (int i = 0; i <= Array.this.arr.length - 1; ++i) {
		    msg = String.valueOf(msg) + " " + Array.this.arr[i];
		}
		Array.this.displaybox.setText(msg);
	    }
	});
	display.setFont(new Font("Times New Roman", Font.BOLD, 18));
	display.setBounds(763, 370, 152, 66);
	this.contentPane.add(display);
	(this.displaybox = new JTextField()).setBackground(new Color(240, 230, 140));
	displaybox.setFont(new Font("Times New Roman", Font.BOLD, 18));
	displaybox.setHorizontalAlignment(SwingConstants.CENTER);
	this.displaybox.setBounds(320, 555, 360, 36);
	this.contentPane.add(this.displaybox);
	this.displaybox.setColumns(10);


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

	length = new JTextField();
	length.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	length.setFont(new Font("Times New Roman", Font.BOLD, 18));
	length.setHorizontalAlignment(SwingConstants.CENTER);
	length.setBounds(63, 109, 176, 36);
	contentPane.add(length);
	length.setColumns(10);

	insertposition = new JTextField();
	insertposition.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	insertposition.setFont(new Font("Times New Roman", Font.BOLD, 18));
	insertposition.setHorizontalAlignment(SwingConstants.CENTER);
	insertposition.setColumns(10);
	insertposition.setBounds(381, 220, 176, 36);
	contentPane.add(insertposition);

	JLabel bg = new JLabel("");
	Image img2 = new ImageIcon(this.getClass().getResource("/arraybg.png")).getImage();
	bg.setIcon(new ImageIcon(img2));
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
    }

    static /* synthetic */ void access$1(final Array array, final int[] arr) {
	array.arr = arr;
    }
}
