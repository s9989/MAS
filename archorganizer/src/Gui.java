import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame
{

    private JPanel contentPane;
    int elementsPosition = 0;

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
        setBounds(600, 300, 1200, 675);
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
        lblWelcome.setBounds(400, 40, 400, 73);
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

    private void addTitle(String title)
    {
        JLabel label = new JLabel(title);
        label.setForeground(new Color(21, 21, 31));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label.setBounds(400, elementsPosition - 50, 400, 40);
        contentPane.add(label);
    }

    private void addSubtitle(String title)
    {
        JLabel label = new JLabel(title);
        label.setForeground(new Color(21, 21, 31));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(400, elementsPosition - 40, 400, 40);
        contentPane.add(label);
    }

    private void addInput(String label, boolean small)
    {
        JLabel lbl = new JLabel(label);
        lbl.setForeground(new Color(48,48,48));
        lbl.setBackground(new Color(255, 255, 255));
        lbl.setBounds(400, elementsPosition, 180, (small) ? 24 : 36);
        lbl.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        lbl.setOpaque(true);
        lbl.setFont(new Font("Tahoma", Font.PLAIN, (small) ? 12 : 16));
        contentPane.add(lbl);

        JTextField textField = new JTextField();
        textField.setForeground(new Color(48, 48, 48));
//        textField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(218,165, 32)));
        textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField.setBounds(600, elementsPosition, 400, (small) ? 24 : 36);
//        textField.setOpaque(false);
        textField.setColumns(10);
        textField.setFont(new Font("Tahoma", Font.PLAIN, (small) ? 12 : 16));
        contentPane.add(textField);

        elementsPosition += (small) ? 35 : 50;
    }

    private void leftButton(String label)
    {
        JButton button = new JButton(label);
        button.setBounds(400, 600, 140, 32);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(new Color(147, 23, 0));
        button.setBorder(new EmptyBorder(0,0,0,0));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(button);
    }

    private void rightButton(String label)
    {
        JButton button = new JButton(label);
        button.setBounds(1020, 600, 140, 32);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(new Color(29, 163, 16));
        button.setBorder(new EmptyBorder(0,0,0,0));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(button);
    }

    public void screen1()
    {
        elementsPosition = 170;

        addTitle("Nowy projekt");

        addInput("Nazwa projektu", false);
        addInput("Data rozpoczęcia", false);
        addInput("Data zakończenia", false);

        elementsPosition = 370;

        addSubtitle("Nowy Etap");
        addInput("Nazwa", true);
        addInput("Typ", true);

        elementsPosition = 480;

        addSubtitle("Etapy:");

        leftButton("Anuluj");
        rightButton("Dodaj");
    }

    public void screen2()
    {
        elementsPosition = 170;

        addTitle("Projekty:");


    }


}
