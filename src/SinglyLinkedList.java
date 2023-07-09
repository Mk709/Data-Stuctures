
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

@SuppressWarnings({ "serial" })
public class SinglyLinkedList extends JFrame
{
    private JPanel contentPane;
    private JTextField element2;
    private JTextField displaybox;
    private Node first;
    private JTextField element1;
    Sound m = new Sound();
    URL s ;

    public static void main(final String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    final SinglyLinkedList frame = new SinglyLinkedList();
		    frame.setVisible(true);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public SinglyLinkedList() {
	s = getClass().getResource("sll.wav");
	m.Setmusic(s);
	m.play();
	setUndecorated(true);
	this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 1000, 660);
	(this.contentPane = new JPanel()).setBackground(new Color(255, 0, 0));
	contentPane.setBackground(new Color(255, 255, 255));
	this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setContentPane(this.contentPane);
	this.contentPane.setLayout(null);
	this.setLocationRelativeTo(null);
	(this.element2 = new JTextField()).setColumns(10);
	element2.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	element2.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
	element2.setHorizontalAlignment(SwingConstants.CENTER);
	this.element2.setBounds(211, 225, 100, 30);
	this.contentPane.add(this.element2);


	final JButton insertrear = new JButton("");
	insertrear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	insertrear.setOpaque(false);
	insertrear.setContentAreaFilled(false);
	insertrear.setBorderPainted(false);
	insertrear.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		final int elem = Integer.valueOf(SinglyLinkedList.this.element1.getText());
		final Node newnode = new Node();
		newnode.data = elem;
		newnode.link = null;
		if (SinglyLinkedList.this.first == null) {
		    SinglyLinkedList.access$2(SinglyLinkedList.this, newnode);
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Insertion at rear is successfull");
		    SinglyLinkedList.this.element1.setText("");
		}
		else {
		    Node temp;
		    for (temp = SinglyLinkedList.this.first; temp.link != null; temp = temp.link) {}
		    temp.link = newnode;
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Insertion at rear is successfull");
		    SinglyLinkedList.this.element1.setText("");
		}
	    }
	});
	insertrear.setFont(new Font("Constantia", 1, 12));
	insertrear.setBounds(330, 154, 150, 40);
	this.contentPane.add(insertrear);


	final JButton insertfront = new JButton("");
	insertfront.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	insertfront.setOpaque(false);
	insertfront.setContentAreaFilled(false);
	insertfront.setBorderPainted(false);
	insertfront.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		final int elem = Integer.valueOf(SinglyLinkedList.this.element2.getText());
		final Node newnode = new Node();
		newnode.data = elem;
		newnode.link = null;
		if (SinglyLinkedList.this.first == null) {
		    SinglyLinkedList.access$2(SinglyLinkedList.this, newnode);
		}
		else {
		    newnode.link = SinglyLinkedList.this.first;
		    SinglyLinkedList.access$2(SinglyLinkedList.this, newnode);
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Insertion at front is successfull");
		    SinglyLinkedList.this.element2.setText("");
		}
	    }
	});
	insertfront.setFont(new Font("Constantia", 1, 12));
	insertfront.setBounds(330, 220, 150, 40);
	this.contentPane.add(insertfront);


	final JButton deleterear = new JButton("");
	deleterear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	deleterear.setOpaque(false);
	deleterear.setContentAreaFilled(false);
	deleterear.setBorderPainted(false);
	deleterear.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (SinglyLinkedList.this.first == null) {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deletion not possible");
		}
		if (SinglyLinkedList.this.first.link == null) {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deleted element is" + SinglyLinkedList.this.first.data);
		    SinglyLinkedList.access$2(SinglyLinkedList.this, null);
		}
		else {
		    Node temp;
		    for (temp = SinglyLinkedList.this.first; temp.link.link != null; temp = temp.link) {}
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deleted element is" + temp.link.data);
		    temp.link = null;
		}
	    }
	});
	deleterear.setFont(new Font("Constantia", 1, 12));
	deleterear.setBounds(172, 332, 150, 40);
	this.contentPane.add(deleterear);


	final JButton deletefront = new JButton("");
	deletefront.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	deletefront.setOpaque(false);
	deletefront.setContentAreaFilled(false);
	deletefront.setBorderPainted(false);
	deletefront.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		if (SinglyLinkedList.this.first == null) {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deletion not possible");
		}
		if (SinglyLinkedList.this.first.link == null) {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deleted element is" + SinglyLinkedList.this.first.data);
		    SinglyLinkedList.access$2(SinglyLinkedList.this, null);
		}
		else {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Deleted element is" + SinglyLinkedList.this.first.data);
		    SinglyLinkedList.access$2(SinglyLinkedList.this, SinglyLinkedList.this.first.link);
		}
	    }
	});
	deletefront.setFont(new Font("Constantia", 1, 12));
	deletefront.setBounds(171, 397, 150, 40);
	this.contentPane.add(deletefront);


	final JButton display = new JButton("");
	display.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	display.setOpaque(false);
	display.setContentAreaFilled(false);
	display.setBorderPainted(false);
	display.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(final ActionEvent arg0) {
		String msg = "";
		if (SinglyLinkedList.this.first == null) {
		    JOptionPane.showMessageDialog(SinglyLinkedList.this.contentPane, "Display not possible");
		    SinglyLinkedList.this.displaybox.setText("");
		}
		if (SinglyLinkedList.this.first.link == null) {
		    msg = String.valueOf(msg) + " " + SinglyLinkedList.this.first.data;
		    SinglyLinkedList.this.displaybox.setText(msg);
		}
		else {
		    for (Node temp = SinglyLinkedList.this.first; temp != null; temp = temp.link) {
			msg = String.valueOf(msg) + " " + temp.data;
		    }
		    SinglyLinkedList.this.displaybox.setText(msg);
		}
	    }
	});
	display.setFont(new Font("Constantia", 1, 12));
	display.setBounds(172, 453, 150, 40);
	this.contentPane.add(display);
	(this.displaybox = new JTextField()).setColumns(10);
	displaybox.setHorizontalAlignment(SwingConstants.CENTER);
	displaybox.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
	this.displaybox.setBounds(81, 519, 335, 30);
	this.contentPane.add(this.displaybox);


	final JButton back = new JButton("");
	back.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
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
	back.setBounds(905, 601, 83, 59);
	this.contentPane.add(back);

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
	exit.setBounds(454, 601, 83, 59);
	contentPane.add(exit);


	element1 = new JTextField();
	element1.setHorizontalAlignment(SwingConstants.CENTER);
	element1.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	element1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
	element1.setBounds(211, 160, 100, 30);
	contentPane.add(element1);

	JLabel bg = new JLabel("");
	Image img11 = new ImageIcon(this.getClass().getResource("sll bg.png")).getImage();
	bg.setIcon(new ImageIcon(img11));
	bg.setIgnoreRepaint(true);
	bg.setBounds(0, 0, 1000, 660);
	contentPane.add(bg);
    }

    static /* synthetic */ void access$2(final SinglyLinkedList list, final Node first) {
	list.first = first;
    }

    class Node
    {
	int data;
	Node link;
    }
}
