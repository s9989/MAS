package view;

import lib.ColorBase;
import main.Initialize;
import main.Main;
import model.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class HomePage extends AbstractView
{
    public HomePage()
    {
        super();

        elementsPosition = 170;

        addTitle("Projekty:");

        redraw();

        JButton rightButton = rightButton("Dodaj projekt");

        rightButton.addActionListener(new ActionListener() {
            /* przesłanianie */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchPage("project");
            }
        });

        base();
    }

    /**
     * Metoda tworzy listę projektów lub jeśli istnieje, usuwa i tworzy ją na nowo
     */
    public void redraw()
    {
        try {
            Initialize.load();
        } catch (Exception e) {
            System.out.println("Fatal error while loading extend:");
            e.printStackTrace();
            return;
        }

        JPanel editable = (JPanel) contentPane.getClientProperty("editable");

        if (null == editable) {
            editable = new JPanel();
            editable.setLayout(null);
            editable.setBounds(LEFT_PANEL_WIDTH + MARGIN, elementsPosition, RIGHT_PANEL_WIDTH - MARGIN * 2, 465);
            editable.setOpaque(false);

            contentPane.add(editable);
            contentPane.putClientProperty("editable", editable);

        } else {
            editable.removeAll();
        }

        elementsPosition = 0;

        try {
            ArrayList projects = (ArrayList) Project.getExtent(Project.class);

            for (Object o : projects) {
                Project project = (Project) o;
                JLabel label = addPosition(project.getName(), false, editable);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Main.switchPage("project", project);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setForeground(ColorBase.hover);
                        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setForeground(ColorBase.font);
                        label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
