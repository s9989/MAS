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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProjectPage extends AbstractView implements ObjectInjectable
{
    Project project;

    public ProjectPage()
    {
        super();

        elementsPosition = 170;

        addTitle("Nowy projekt");

        addInput("Nazwa projektu", "projectName", false);
        addInput("Data rozpoczęcia", "projectDateFrom", false);
        addInput("Data zakończenia", "projectDateTo", false);

        elementsPosition = 370;

        addSubtitle("Nowy Etap");
        addInput("Nazwa", "stageName", true);
        addInput("Koszt", "stageCost", true);

        JButton miniButton = generateButton("Dodaj etap", ColorBase.light, ColorBase.success);
        miniButton.setFont(new Font("Tahoma", Font.BOLD, 10));
        miniButton.setBounds(LEFT_PANEL_WIDTH + RIGHT_PANEL_WIDTH - MARGIN - BUTTON_WIDTH, elementsPosition, BUTTON_WIDTH, 24);
        contentPane.add(miniButton);

        miniButton.addActionListener(new ActionListener() {

            private String getInputValue(ActionEvent e, String inputName)
            {
                JPanel contentPane = (JPanel) ((JButton) e.getSource()).getClientProperty("contentPane");
                JTextField textField = (JTextField) contentPane.getClientProperty(inputName);

                return textField.getText();
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = getInputValue(e, "stageName");
                try {
                    int cost = Integer.valueOf(getInputValue(e, "stageCost"));

                    project.addStage(name, cost);
                } catch (NumberFormatException ex) {
                    // do nothing
                }

                redrawStages();
            }
        });

        elementsPosition = 520;

        addSubtitle("Etapy:");
        redrawStages();

        JButton leftButton = leftButton("Anuluj");

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.switchPage("homepage");
            }
        });

        JButton rightButton = rightButton("Zapisz");

        rightButton.addActionListener(new ActionListener() {

            private String getInputValue(ActionEvent e, String inputName)
            {
                JPanel contentPane = (JPanel) ((JButton) e.getSource()).getClientProperty("contentPane");
                JTextField textField = (JTextField) contentPane.getClientProperty(inputName);

                return textField.getText();
            }

            private void clearInput(ActionEvent e, String inputName)
            {
                JPanel contentPane = (JPanel) ((JButton) e.getSource()).getClientProperty("contentPane");
                JTextField textField = (JTextField) contentPane.getClientProperty(inputName);

                textField.setText("");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = getInputValue(e, "projectName");
                String dateFrom = getInputValue(e, "projectDateFrom");
                String dateTo = getInputValue(e, "projectDateTo");

                if (name.length() == 0) {
                    return;
                }

                project.setName(name);
                project.setStartAt(Initialize.getDateFromString(dateFrom));
                project.setEndAt(Initialize.getDateFromString(dateTo));

                Main.saveProject();

                clearInput(e, "projectName");
                clearInput(e, "projectDateFrom");
                clearInput(e, "projectDateTo");

                clearInput(e, "stageName");
                clearInput(e, "stageCost");

                Main.switchPage("homepage");
            }
        });

        base();
    }

    @Override
    public void setObject(Object object)
    {
        if (null == object) {
            project = new Project("");
        }

        if (object instanceof Project) {
            project = (Project) object;
        }
    }

    public void redraw()
    {
        JTextField projectName = (JTextField) contentPane.getClientProperty("projectName");
        JTextField projectDateFrom = (JTextField) contentPane.getClientProperty("projectDateFrom");
        JTextField projectDateTo = (JTextField) contentPane.getClientProperty("projectDateTo");
        JTextField stageName = (JTextField) contentPane.getClientProperty("stageName");
        JTextField stageCost = (JTextField) contentPane.getClientProperty("stageCost");

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        projectName.setText(project.getName());

        if (null != project.getStartAt()) {
            projectDateFrom.setText(dateFormat.format(project.getStartAt()));
        } else {
            projectDateFrom.setText("");
        }

        if (null != project.getEndAt()) {
            projectDateTo.setText(dateFormat.format(project.getEndAt()));
        } else {
            projectDateTo.setText("");
        }

        stageName.setText("");
        stageCost.setText("");

        redrawStages();
    }

    /**
     * Metoda generuje listę etapów projektu lub usuwa starą i tworzy jeszcze raz
     */
    public void redrawStages()
    {
        JPanel stagesPanel = (JPanel) contentPane.getClientProperty("stagesPanel");

        if (null == stagesPanel) {
            stagesPanel = new JPanel();
            stagesPanel.setLayout(null);
            stagesPanel.setBounds(LEFT_PANEL_WIDTH + MARGIN, elementsPosition, RIGHT_PANEL_WIDTH - MARGIN * 2, 240);
            stagesPanel.setOpaque(false);

            contentPane.add(stagesPanel);
            contentPane.putClientProperty("stagesPanel", stagesPanel);

        } else {
            stagesPanel.removeAll();
        }

        if (null == project) {
            return;
        }

        /** Nazwy */
        elementsPosition = 0;

        try {
            ArrayList<String> stages = project.getStageNames();

            for (String s : stages) {
                addPosition(s, true, stagesPanel);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        /** Koszta */
        elementsPosition = 0;

        try {
            ArrayList<String> stages = project.getStageNames();

            for (String s : stages) {
                addRightPosition(String.valueOf(project.getStageCost(s)), true, stagesPanel);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        /** Przyciski do usuwania etapów */
        elementsPosition = 0;

        try {
            ArrayList<String> stages = project.getStageNames();

            for (String s : stages) {
                JLabel label = addRemoveButton("×", true, stagesPanel);

                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            project.removeStage(s);

                            redrawStages();
                        } catch (Exception ex) {
                            // do nothing
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setForeground(ColorBase.hover);
                        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setForeground(ColorBase.cancel);
                        label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        stagesPanel.repaint();
        stagesPanel.revalidate();
    }

}
