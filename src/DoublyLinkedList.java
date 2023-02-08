

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
public class DoublyLinkedList extends JFrame
{
    private JPanel contentPane;
    private JTextField element2;
    private Node first;
    private JTextField element1;
    private JTextField displaybox;
    Sound m = new Sound();
    URL s ;
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final DoublyLinkedList frame = new DoublyLinkedList();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public DoublyLinkedList() {
	s = getClass().getResource("dll.wav");
	m.Setmusic(s);
	m.play();
    	setUndecorated(true);
        this.setBackground(new Color(255, 250, 250));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 1000, 660);
        (this.contentPane = new JPanel()).setBackground(new Color(0, 255, 255));
        contentPane.setBackground(new Color(255, 255, 255));
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        this.setLocationRelativeTo(null);
        
        JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT");
        lblNewLabel_1_1.setForeground(Color.RED);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(10, 217, 163, 20);
        contentPane.add(lblNewLabel_1_1);
        
        element1 = new JTextField();
        element1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        	    char c = e.getKeyChar();
        	    if(!Character.isDigit(c)) {
        		e.consume();
        	    }
        	}
        });
        element1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        element1.setBounds(188, 138, 109, 26);
        element1.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(element1);
        final JLabel lblNewLabel_1 = new JLabel("ENTER AN ELEMENT");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 141, 163, 20);
        this.contentPane.add(lblNewLabel_1);
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
        element2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        element2.setHorizontalAlignment(JTextField.CENTER);
        this.element2.setBounds(183, 210, 114, 26);
        this.contentPane.add(this.element2);
        final JButton insertrear = new JButton("INSERT REAR");
        insertrear.setFont(new Font("Times New Roman", Font.BOLD, 16));
        insertrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final int elem = Integer.valueOf(DoublyLinkedList.this.element1.getText());
                final Node newnode = new Node();
                newnode.data = elem;
                newnode.prelink = null;
                newnode.nextlink = null;
                if (DoublyLinkedList.this.first == null) {
                    DoublyLinkedList.access$2(DoublyLinkedList.this, newnode);
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Insertion at rear is successfull");
                    DoublyLinkedList.this.element1.setText("");
                }
                else {
                    Node temp;
                    for (temp = DoublyLinkedList.this.first; temp.nextlink != null; temp = temp.nextlink) {}
                    temp.nextlink = newnode;
                    newnode.prelink = temp;
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Insertion at rear is successfull");
                    DoublyLinkedList.this.element1.setText("");
                }
            }
        });
        insertrear.setForeground(new Color(139, 0, 0));
        insertrear.setBounds(307, 137, 163, 29);
        this.contentPane.add(insertrear);
        final JButton insertfront = new JButton("INSERT FRONT");
        insertfront.setFont(new Font("Times New Roman", Font.BOLD, 16));
        insertfront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final int elem = Integer.valueOf(DoublyLinkedList.this.element2.getText());
                final Node newnode = new Node();
                newnode.data = elem;
                newnode.prelink = null;
                newnode.nextlink = null;
                if (DoublyLinkedList.this.first == null) {
                    DoublyLinkedList.access$2(DoublyLinkedList.this, newnode);
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Insertion at front is successfull");
                    DoublyLinkedList.this.element2.setText("");
                }
                else {
                    newnode.nextlink = DoublyLinkedList.this.first;
                    DoublyLinkedList.this.first.prelink = newnode;
                    DoublyLinkedList.access$2(DoublyLinkedList.this, newnode);
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Insertion at front is successfull");
                    DoublyLinkedList.this.element2.setText("");
                }
            }
        });
        insertfront.setForeground(new Color(139, 0, 0));
        insertfront.setBounds(307, 209, 163, 29);
        this.contentPane.add(insertfront);
        final JButton deleterear = new JButton("DELETE REAR");
        deleterear.setFont(new Font("Times New Roman", Font.BOLD, 16));
        deleterear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (DoublyLinkedList.this.first == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Deletion not possible");
                }
                else if (DoublyLinkedList.this.first.nextlink == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "deleted element is" + DoublyLinkedList.this.first.data);
                    DoublyLinkedList.access$2(DoublyLinkedList.this, null);
                }
                else {
                    Node temp;
                    for (temp = DoublyLinkedList.this.first; temp.nextlink.nextlink != null; temp = temp.nextlink) {}
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Deleted element is" + temp.nextlink.data);
                    temp.nextlink = null;
                }
            }
        });
        deleterear.setForeground(new Color(139, 0, 0));
        deleterear.setBounds(182, 293, 163, 29);
        this.contentPane.add(deleterear);
        final JButton deletefront = new JButton("DELETE FRONT");
        deletefront.setFont(new Font("Times New Roman", Font.BOLD, 16));
        deletefront.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                if (DoublyLinkedList.this.first == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Deletion not possible");
                    DoublyLinkedList.this.displaybox.setText("");
                }
                else if (DoublyLinkedList.this.first.nextlink == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "deleted element is" + DoublyLinkedList.this.first.data);
                    DoublyLinkedList.access$2(DoublyLinkedList.this, null);
                }
                else {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "deleted element is" + DoublyLinkedList.this.first.data);
                    DoublyLinkedList.access$2(DoublyLinkedList.this, DoublyLinkedList.this.first.nextlink);
                    DoublyLinkedList.this.first.prelink = null;
                }
            }
        });
        deletefront.setForeground(new Color(139, 0, 0));
        deletefront.setBounds(182, 364, 163, 29);
        this.contentPane.add(deletefront);
        final JButton displayforward = new JButton(" DISPLAY FORWARD");
        displayforward.setFont(new Font("Times New Roman", Font.BOLD, 16));
        displayforward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                String msg = "";
                if (DoublyLinkedList.this.first == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Display not possible");
                    DoublyLinkedList.this.displaybox.setText("");
                }
                else if (DoublyLinkedList.this.first.nextlink == null) {
                    msg = String.valueOf(msg) + " " + DoublyLinkedList.this.first.data;
                    DoublyLinkedList.this.displaybox.setText(msg);
                }
                else {
                    for (Node temp = DoublyLinkedList.this.first; temp != null; temp = temp.nextlink) {
                        msg = String.valueOf(msg) + " " + temp.data;
                    }
                    DoublyLinkedList.this.displaybox.setText(msg);
                }
            }
        });
        displayforward.setForeground(new Color(139, 0, 0));
        displayforward.setBounds(10, 461, 209, 29);
        this.contentPane.add(displayforward);
        final JButton displayreverse = new JButton("DISPLAY REVERSE");
        displayreverse.setFont(new Font("Times New Roman", Font.BOLD, 16));
        displayreverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                String msg = "";
                if (DoublyLinkedList.this.first == null) {
                    JOptionPane.showMessageDialog(DoublyLinkedList.this.contentPane, "Display not possible");
                    DoublyLinkedList.this.displaybox.setText("");
                }
                else if (DoublyLinkedList.this.first.nextlink == null) {
                    msg = String.valueOf(msg) + " " + DoublyLinkedList.this.first.data;
                    DoublyLinkedList.this.displaybox.setText(msg);
                }
                else {
                    Node temp;
                    for (temp = DoublyLinkedList.this.first; temp.nextlink != null; temp = temp.nextlink) {}
                    while (temp != null) {
                        msg = String.valueOf(msg) + " " + temp.data;
                        temp = temp.prelink;
                    }
                    DoublyLinkedList.this.displaybox.setText(msg);
                }
            }
        });
        displayreverse.setForeground(new Color(139, 0, 0));
        displayreverse.setBounds(261, 461, 209, 29);
        this.contentPane.add(displayreverse);
        
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
        back.setBounds(917, 601, 83, 59);
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
        exit.setBounds(474, 601, 83, 59);
        contentPane.add(exit);
        
        displaybox = new JTextField();
        displaybox.setHorizontalAlignment(JTextField.CENTER);
        displaybox.setFont(new Font("Times New Roman", Font.BOLD, 16));
        displaybox.setColumns(10);
        displaybox.setBounds(125, 511, 291, 29);
        contentPane.add(displaybox);
        
        JLabel bg = new JLabel("");
        Image img11 = new ImageIcon(this.getClass().getResource("dll bg.png")).getImage();
	bg.setIcon(new ImageIcon(img11));
        bg.setBounds(0, 0, 1000, 660);
        contentPane.add(bg);
    }
    
    static /* synthetic */ void access$2(final DoublyLinkedList list, final Node first) {
        list.first = first;
    }
    
    class Node
    {
        Node prelink;
        int data;
        Node nextlink;
    }
}
