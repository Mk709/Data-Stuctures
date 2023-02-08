

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Dimension;

@SuppressWarnings({ "serial", "unused" })
public class Home extends JFrame
{
    private JPanel contentPane;
    URL s;
    Sound su = new Sound();
    int count = 0;
    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {

		try {
		    final Home frame = new Home();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
    public void music() {
	if(count == 0) {
	    s = getClass().getResource("home.wav");
	    su.Setmusic(s);

	}
    }

    public Home() {
	music();
	setUndecorated(true);
	this.setDefaultCloseOperation(3);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(Color.BLACK);
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);

	JButton exit = new JButton("");
	Image img = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
	exit.setIcon(new ImageIcon(img));
	exit.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(ABORT); 
	    }
	});
	
	JLabel com = new JLabel("PRESS HERE");
	com.setFont(new Font("Orbitron", Font.BOLD, 12));
	com.setForeground(Color.WHITE);
	com.setBounds(278, 622, 90, 12);
	contentPane.add(com);
	exit.setFont(new Font("Times New Roman", Font.BOLD, 16));
	exit.setBackground(new Color(26, 26, 26));
	exit.setForeground(Color.ORANGE);
	exit.setBounds(10, 552, 83, 59);
	contentPane.add(exit);

	JButton musicbt = new JButton("");
	Image img8 = new ImageIcon(this.getClass().getResource("/music on.png")).getImage();
	musicbt.setIcon(new ImageIcon(img8));
	musicbt.setOpaque(false);
	musicbt.setContentAreaFilled(false);
	musicbt.setBorderPainted(false);
	musicbt.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(count == 0) {
		    su.Setmusic(s);
		    su.play();
		    count++;
		    Image img = new ImageIcon(this.getClass().getResource("/music off.png")).getImage();
		    musicbt.setIcon(new ImageIcon(img));
		    musicbt.setOpaque(false);
		    musicbt.setContentAreaFilled(false);
		    musicbt.setBorderPainted(false);
		    com.setText(null);
		}
		else if(count == 1) {
		    su.stop();
		    Image img = new ImageIcon(this.getClass().getResource("/music on.png")).getImage();
		    musicbt.setIcon(new ImageIcon(img));
		    musicbt.setOpaque(false);
		    musicbt.setContentAreaFilled(false);
		    musicbt.setBorderPainted(false);
		    count = 0;
		    com.setText("PRESS HERE");
		}
	    }
	});
	musicbt.setBounds(278, 552, 83, 59);
	contentPane.add(musicbt);

	JLabel by = new JLabel("by Manoj");
	by.setForeground(new Color(147, 225, 204));
	by.setFont(new Font("Ink Free", Font.PLAIN, 18));
	by.setBounds(893, 622, 83, 27);
	contentPane.add(by);

	final JButton array = new JButton("");
	Image img1 = new ImageIcon(this.getClass().getResource("/array.png")).getImage();
	array.setIcon(null);
	array.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	array.setOpaque(false);
	array.setContentAreaFilled(false);
	array.setBorderPainted(false);
	array.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new Array().setVisible(true);
		frameInit();dispose();
	    }
	});
	array.setBackground(Color.WHITE);
	array.setForeground(new Color(0, 0, 128));
	array.setFont(new Font("Times New Roman", Font.BOLD, 16));
	array.setBounds(218, 114, 178, 53);
	this.contentPane.add(array);

	final JButton stack = new JButton("");
	stack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Image img3 = new ImageIcon(this.getClass().getResource("/stack.png")).getImage();
	stack.setOpaque(false);
	stack.setContentAreaFilled(false);
	stack.setBorderPainted(false);
	stack.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new Stack().setVisible(true);
		frameInit();dispose();
	    }
	});
	stack.setBackground(Color.WHITE);
	stack.setForeground(Color.RED);
	stack.setFont(new Font("Times New Roman", Font.BOLD, 16));
	stack.setBounds(218, 176, 178, 53);
	this.contentPane.add(stack);


	final JButton queue = new JButton("");
	queue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Image img4 = new ImageIcon(this.getClass().getResource("/queue.png")).getImage();
	queue.setOpaque(false);
	queue.setContentAreaFilled(false);
	queue.setBorderPainted(false);
	queue.setIcon(null);
	queue.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new Queue().setVisible(true);
		frameInit();dispose();
	    }
	});
	queue.setForeground(new Color(0, 0, 128));
	queue.setBackground(new Color(26, 26, 26));
	queue.setFont(new Font("Times New Roman", Font.BOLD, 16));
	queue.setBounds(218, 235, 178, 53);
	this.contentPane.add(queue);


	final JButton cqueue = new JButton("");
	cqueue.setMaximumSize(new Dimension(34, 9));
	Image img2 = new ImageIcon(this.getClass().getResource("/cqueue.png")).getImage();
	cqueue.setOpaque(false);
	cqueue.setContentAreaFilled(false);
	cqueue.setBorderPainted(false);
	cqueue.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	cqueue.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new CircularQueue().setVisible(true);
		frameInit();dispose();
	    }
	});
	cqueue.setForeground(new Color(0, 0, 128));
	cqueue.setBackground(new Color(51, 52, 117));
	cqueue.setFont(new Font("Times New Roman", Font.BOLD, 16));
	cqueue.setBounds(218, 297, 178, 53);
	this.contentPane.add(cqueue);


	final JButton sll = new JButton("");
	sll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Image img5= new ImageIcon(this.getClass().getResource("/sll.png")).getImage();
	sll.setOpaque(false);
	sll.setContentAreaFilled(false);
	sll.setBorderPainted(false);
	sll.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new SinglyLinkedList().setVisible(true);
		frameInit();dispose();

	    }
	});
	sll.setFont(new Font("Times New Roman", Font.BOLD, 16));
	sll.setBackground(new Color(4, 66, 65));
	sll.setForeground(Color.RED);
	sll.setBounds(218, 359, 178, 53);
	this.contentPane.add(sll);


	final JButton dll = new JButton("");
	Image img6 = new ImageIcon(this.getClass().getResource("/dll.png")).getImage();
	dll.setOpaque(false);
	dll.setContentAreaFilled(false);
	dll.setBorderPainted(false);
	dll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	dll.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		su.stop();
		new DoublyLinkedList().setVisible(true);
		frameInit();dispose();
	    }
	});
	dll.setForeground(Color.RED);
	dll.setFont(new Font("Times New Roman", Font.BOLD, 15));
	dll.setBackground(new Color(51, 52, 117));
	dll.setBounds(218, 421, 178, 53);
	this.contentPane.add(dll);

	JLabel bg = new JLabel("");
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
	Image img7 = new ImageIcon(this.getClass().getResource("/home bg.png")).getImage();
	bg.setIcon(new ImageIcon(img7));
    }
}
