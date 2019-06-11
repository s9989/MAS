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
        lblWelcome.setForeground(new Color(112,128,144));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblWelcome.setBounds(86, 166, 170, 143);
        contentPane.add(lblWelcome);

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

    public void screen1()
    {
        JLabel lbl = new JLabel("Nazwa");
        lbl.setForeground(new Color(48,48,48));
        lbl.setBackground(new Color(255, 255, 255));
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl.setBounds(400, 200, 180, 36);
        lbl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lbl.setOpaque(true);
        contentPane.add(lbl);

        JTextField textField = new JTextField();
        textField.setForeground(new Color(48, 48, 48));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        textField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(218,165, 32)));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textField.setBounds(600, 200, 400, 36);
//        textField.setOpaque(false);
        textField.setColumns(10);
        contentPane.add(textField);
    }



}
