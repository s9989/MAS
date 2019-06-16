package view;

import lib.ColorBase;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* klasa abstrakcyjna */
abstract public class AbstractView extends JFrame
{
    protected JPanel contentPane;
    int elementsPosition = 0;

    /* atrybut klasowy */
    static final int LEFT_PANEL_WIDTH = 350;
    static final int MARGIN = 50;
    static final int RIGHT_PANEL_WIDTH = 850;
    static final int HEIGHT = 800;

    static final int BUTTON_WIDTH = 140;
    static final int BUTTON_HEIGHT = 32;

    static final int LABEL_WIDTH = 180;
    static final int INPUT_WIDTH = 544;

    static final int REMOVE_BUTTON_WIDTH = 20;

    protected AbstractView()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(600, 300, LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH, HEIGHT);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

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

    /**
     * Przesuwanie okna
     */
    protected class FrameDragListener extends MouseAdapter {

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

    protected void base()
    {
        JLabel close = new JLabel("×");
        close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        close.setForeground(new Color(56, 56, 56));
        close.setHorizontalAlignment(SwingConstants.CENTER);
        close.setBounds(1152, 0, 48,48);
        close.setFont(new Font("Arial", Font.PLAIN, 36));
        contentPane.add(close);

        JLabel lblWelcome = new JLabel("<html>ArchOrganizer</html>");
        lblWelcome.setForeground(ColorBase.font);
        lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 36));
        lblWelcome.setBounds(LEFT_PANEL_WIDTH + MARGIN, 40, 400, 73);
        contentPane.add(lblWelcome);

        int logoWidth = 173;
        int logoHeight = 150;

        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon(this.getClass().getResource("/logo.png")));
        logo.setBounds(LEFT_PANEL_WIDTH / 2 - logoWidth / 2, MARGIN,logoWidth, logoHeight);
        logo.setOpaque(false);
//        logo.setBackground(new ColorBase(0, 0, 0));
        contentPane.add(logo);

        JLabel lblLeft = new JLabel("");
        lblLeft.setBackground(new Color(255, 255, 255));
        lblLeft.setOpaque(true);
        lblLeft.setBounds(0,0,LEFT_PANEL_WIDTH, HEIGHT);
        contentPane.add(lblLeft);

        JLabel background = new JLabel("");
        background.setHorizontalAlignment(SwingConstants.CENTER);
        background.setIcon(new ImageIcon(this.getClass().getResource("/ao_bg.jpg")));
        background.setBounds(0, 0,LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH, HEIGHT);
        background.setOpaque(true);
        background.setBackground(new Color(0, 0, 0));
        contentPane.add(background);

    }

    /**
     * Metoda wywoływana przy zmianie okien, rysuje na nowo elementy specyficzne dla danego okna
     */
    abstract public void redraw();

    /**
     * Dodaje tytuł do strony
     *
     * @param title tytuł
     */
    protected void addTitle(String title)
    {
        JLabel label = new JLabel(title);
        label.setForeground(ColorBase.font);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label.setBounds(LEFT_PANEL_WIDTH + MARGIN, elementsPosition - 50, RIGHT_PANEL_WIDTH - MARGIN * 2, 40);
        label.setBorder(new MatteBorder(0, 0, 1, 0, ColorBase.dark));
        contentPane.add(label);
    }

    /**
     * Dodaje podtytuł do strony
     *
     * @param subtitle tytuł
     */
    protected void addSubtitle(String subtitle)
    {
        JLabel label = new JLabel(subtitle);
        label.setForeground(ColorBase.font);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(LEFT_PANEL_WIDTH + MARGIN, elementsPosition - 40, RIGHT_PANEL_WIDTH - MARGIN * 2, 30);
        label.setBorder(new MatteBorder(0, 0, 1, 0, ColorBase.dark));
        contentPane.add(label);
    }

    /**
     * Dodaje pole tekstowe z etykietą
     *
     * @param label etykieta
     * @param inputName nazwa pola tekstowego
     * @param small czy pole ma być mniejsze
     */
    protected void addInput(String label, String inputName, boolean small)
    {
        JLabel lbl = new JLabel(label);
        lbl.setForeground(new Color(48,48,48));
        lbl.setBackground(new Color(255, 255, 255));
        lbl.setBounds(LEFT_PANEL_WIDTH + MARGIN, elementsPosition, LABEL_WIDTH, (small) ? 24 : 36);
        lbl.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        lbl.setOpaque(true);
        lbl.setFont(new Font("Tahoma", Font.PLAIN, (small) ? 12 : 16));
        contentPane.add(lbl);

        JTextField textField = new JTextField();
        textField.setForeground(new Color(48, 48, 48));
//        textField.setBorder(new MatteBorder(0, 0, 2, 0, new ColorBase(218,165, 32)));
        textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        textField.setBounds(LEFT_PANEL_WIDTH + MARGIN + LABEL_WIDTH + MARGIN / 2, elementsPosition, INPUT_WIDTH, (small) ? 24 : 36);
//        textField.setOpaque(false);
        textField.setColumns(10);
        textField.setFont(new Font("Tahoma", Font.PLAIN, (small) ? 12 : 16));
        contentPane.add(textField);
        contentPane.putClientProperty(inputName, textField);

        elementsPosition += (small) ? 35 : 50;
    }

    /**
     * Dodaje pozycję (sktór)
     *
     * @param text wartość pozycji
     */
    protected void addPosition(String text)
    {
        addPosition(text, false);
    }

    /* przeciążanie */
    /**
     * Dodaje pozycję (sktór)
     *
     * @param text wartość pozycji
     */
    protected void addPosition(String text, boolean small)
    {
        addPosition(text, small, contentPane);
    }

    /**
     * Dodaje pozycję (sktór)
     *
     * @param text wartość pozycji
     * @param small czy mniejsza pozycja
     */
    protected void addRightPosition(String text, boolean small)
    {
        addRightPosition(text, small, contentPane);
    }

    /**
     * Pomocnicza metoda generująca podstawy pozycji
     *
     * @param text tekst
     * @param small czy mniejsza pozycja
     * @return JLabel wygenerowany element
     */
    private JLabel generatePosition(String text, boolean small)
    {
        JLabel label = new JLabel(text);
        label.setForeground(ColorBase.font);
        label.setFont(new Font("Tahoma", Font.PLAIN, (small) ? 18 : 24));

        return label;
    }

    /**
     * Dodaje pozycję
     *
     * @param text tekst
     * @param small czy mniejsza pozycja
     * @param targetPanel docelowy element
     * @return JLabel wygenerowana pozycja
     */
    protected JLabel addPosition(String text, boolean small, JPanel targetPanel)
    {
        JLabel label = generatePosition(text, small);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        int x = (targetPanel.equals(contentPane)) ? LEFT_PANEL_WIDTH + MARGIN : 0;
        label.setBounds(x, elementsPosition, RIGHT_PANEL_WIDTH - MARGIN * 2, 30);
        targetPanel.add(label);

        elementsPosition += (small) ? 35 : 50;

        return label;
    }

    /**
     * Dodaje pozycję z wyrównaniem do prawej strony
     *
     * @param text tekst
     * @param small czy mniejsza pozycja
     * @param targetPanel docelowy element
     * @return JLabel wygenerowana pozycja
     */
    protected JLabel addRightPosition(String text, boolean small, JPanel targetPanel)
    {
        JLabel label = generatePosition(text, small);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        int x = (targetPanel.equals(contentPane)) ? LEFT_PANEL_WIDTH + MARGIN : 0;
        label.setBounds(x, elementsPosition, RIGHT_PANEL_WIDTH - MARGIN * 2 - REMOVE_BUTTON_WIDTH, 30);
        targetPanel.add(label);

        elementsPosition += (small) ? 35 : 50;

        return label;
    }

    /**
     * Dodaje mały przycisk z prawej strony do usunięcia pozycji
     *
     * @param text tekst przycisku
     * @param small czy mniejsza pozycja
     * @param targetPanel docelowy element
     * @return JLabel wygenerowany przycisk
     */
    protected JLabel addRemoveButton(String text, boolean small, JPanel targetPanel)
    {
        JLabel label = generatePosition(text, small);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        int x = (targetPanel.equals(contentPane)) ? LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH - MARGIN - REMOVE_BUTTON_WIDTH: RIGHT_PANEL_WIDTH - MARGIN * 2 - REMOVE_BUTTON_WIDTH;
        label.setBounds(x, elementsPosition, REMOVE_BUTTON_WIDTH, 30);
        label.setForeground(ColorBase.cancel);
        targetPanel.add(label);
        elementsPosition += (small) ? 35 : 50;

        return label;
    }

    /**
     * Generuje podstawowy przycisk
     *
     * @param label etykieta
     * @param foreground kolor tekstu
     * @param background kolor tła
     * @return JButton wygenerowany element
     */
    protected JButton generateButton(String label, Color foreground, Color background)
    {
        JButton button = new JButton(label);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setForeground(foreground);
        button.setBackground(background);
        button.setBorder(new EmptyBorder(0,0,0,0));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFocusPainted(false);
        button.putClientProperty("contentPane", contentPane);

        return button;
    }

    /**
     * Dodaje przycisk po lewej stronie
     *
     * @param label etykieta
     * @return JButton dodany przycisk
     */
    protected JButton leftButton(String label)
    {
        JButton button = generateButton(label, ColorBase.light, ColorBase.cancel);
        button.setBounds(LEFT_PANEL_WIDTH + MARGIN, HEIGHT - MARGIN - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(button);

        return button;
    }

    /**
     * Dodaje przycisk po prawej stronie
     *
     * @param label etykieta
     * @return JButton dodany przycisk
     */
    protected JButton rightButton(String label)
    {
        JButton button = generateButton(label, ColorBase.light, ColorBase.success);
        button.setBounds(LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH - MARGIN - BUTTON_WIDTH, HEIGHT - MARGIN - BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(button);

        return button;
    }
}
