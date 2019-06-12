import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame
{

    private JPanel contentPane;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Gui gui = new Gui();
                    gui.screen1();
                    gui.base();
                    gui.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Gui()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(2024, 100, 1200, 675);
        setBackground(new Color(123,0,0));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0,0,0)));

        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        setUndecorated(true);
    }

    private void base()
    {
        JLabel close = new JLabel("×");
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        close.setForeground(new Color(56, 56, 56));
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.setBounds(1152, 0, 48,48);
        close.setFont(new Font("Arial", Font.PLAIN, 36));
        contentPane.add(close);

        JLabel lblWelcome = new JLabel("<html>ArchOrganizer</html>");
        lblWelcome.setForeground(new Color(21, 21, 31));
        lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblWelcome.setBounds(400, 90, 400, 143);
        contentPane.add(lblWelcome);

        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon(Gui.class.getResource("/logo.png")));
        logo.setBounds(88, 50,173, 150);
        logo.setOpaque(false);
//        logo.setBackground(new Color(0, 0, 0));
        contentPane.add(logo);

        JLabel lblLeft = new JLabel("");
        lblLeft.setBackground(new Color(255, 255, 255));
        lblLeft.setOpaque(true);
        lblLeft.setBounds(0,0,350,675);
        contentPane.add(lblLeft);

        JLabel circle = new JLabel("");
        circle.setHorizontalAlignment(SwingConstants.CENTER);
        circle.setIcon(new ImageIcon(Gui.class.getResource("/yorha.jpg")));
        circle.setBounds(0, 0,1200, 675);
        circle.setOpaque(true);
        circle.setBackground(new Color(0, 0, 0));
        contentPane.add(circle);

    }

    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }

    public void screen1()
    {
        JLabel lblWelcome = new JLabel("<html>Nowy projekt</html>");
        lblWelcome.setForeground(new Color(21, 21, 31));
        lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblWelcome.setBounds(400, 200, 400, 40);
        contentPane.add(lblWelcome);

        JLabel lbl = new JLabel("Nazwa");
        lbl.setForeground(new Color(48,48,48));
        lbl.setBackground(new Color(255, 255, 255));
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl.setBounds(400, 250, 180, 36);
        lbl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbl.setOpaque(true);
        contentPane.add(lbl);

        JTextField textField = new JTextField();
        textField.setForeground(new Color(48, 48, 48));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        textField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(218,165, 32)));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField.setBounds(600, 250, 400, 36);
//        textField.setOpaque(false);
        textField.setColumns(10);
        contentPane.add(textField);

        JLabel lbl2 = new JLabel("Data rozpoczęcia");
        lbl2.setForeground(new Color(48,48,48));
        lbl2.setBackground(new Color(255, 255, 255));
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl2.setBounds(400, 300, 180, 36);
        lbl2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbl2.setOpaque(true);
        contentPane.add(lbl2);

        JTextField textField2 = new JTextField();
        textField2.setForeground(new Color(48, 48, 48));
        textField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        textField2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(218,165, 32)));
        textField2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField2.setBounds(600, 300, 400, 36);
//        textField2.setOpaque(false);
        textField2.setColumns(10);
        contentPane.add(textField2);

        JLabel lbl3 = new JLabel("Data zakończenia");
        lbl3.setForeground(new Color(48,48,48));
        lbl3.setBackground(new Color(255, 255, 255));
        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl3.setBounds(400, 350, 180, 36);
        lbl3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbl3.setOpaque(true);
        contentPane.add(lbl3);

        JTextField textField3 = new JTextField();
        textField3.setForeground(new Color(48, 48, 48));
        textField3.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        textField3.setBorder(new MatteBorder(0, 0, 2, 0, new Color(218,165, 32)));
        textField3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField3.setBounds(600, 350, 400, 36);
//        textField3.setOpaque(false);
        textField3.setColumns(10);
        contentPane.add(textField3);

    }



}
