package baryshev;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel graphPanel;

    private JCheckBox vertexModeCheckBox;
    private JCheckBox edgeModeCheckBox;
    private JCheckBox addModeCheckBox;
    private JCheckBox delModeCheckBox;

    private JTextField weightField;
    private JTextField answerField;
    private JTextField circuitStartField;
    private JTextField circuitEndField;

    private JButton getAnswerButton;
    private JButton clearButton;

    private JLabel weightLabel;
    private JLabel answerLabel;
    private JLabel circuitStartLabel;
    private JLabel circuitEndLabel;

    private final Canvas canvas = new Canvas();


    public MainFrame() {
        super();

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Resistance calculator");
        setMinimumSize(new Dimension(1500, 800));
        setResizable(false);
        graphPanel.add(canvas, BorderLayout.CENTER);
        edgeModeCheckBox.addActionListener(o -> {
            vertexModeCheckBox.setSelected(false);
            canvas.changeObjectMode(Modes.ObjectModes.EDGE);
        });

        vertexModeCheckBox.addActionListener(o -> {
            edgeModeCheckBox.setSelected(false);
            canvas.changeObjectMode(Modes.ObjectModes.VERTEX);
        });

        weightField.addActionListener(o -> {
            try {
                int weight = Integer.parseInt(o.getActionCommand());
                canvas.setWeight(weight);
            } catch (Exception ignore) {}
        });

        addModeCheckBox.addActionListener(o ->{
            delModeCheckBox.setSelected(false);
            canvas.changeOperationMode(Modes.OperationModes.ADD);
        });

        delModeCheckBox.addActionListener(o ->{
            addModeCheckBox.setSelected(false);
            canvas.changeOperationMode(Modes.OperationModes.DELETE);
        });

        getAnswerButton.addActionListener(o -> {
            int startNode = Integer.parseInt(circuitStartField.getText());
            int endNode = Integer.parseInt(circuitEndField.getText());

            AdjMatrixWeightedGraph graph = canvas.getGraph();

            double answer = Logic.calcCircuitResistance(graph, startNode, endNode);
            if (answer == -1) {
                JOptionPane.showMessageDialog(this, "???????????? ???????? ???? ?????????????? ?? ???????????? ????????",
                        "????????????", JOptionPane.ERROR_MESSAGE);
                return;
            }

            answerField.setText(String.valueOf(answer));
        });

        clearButton.addActionListener(o -> canvas.clearAll());

        pack();
        setVisible(true);
    }

//    private void configureFrame() {
//        setContentPane(mainPanel);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("Resistance calculator");
//        setMinimumSize(new Dimension(1500, 800));
//        setResizable(false);
//    }

//    private void createButtonListeners() {
//        edgeModeCheckBox.addActionListener(o -> {
//            vertexModeCheckBox.setSelected(false);
//            canvas.changeObjectMode(ObjectModes.EDGE);
//        });
//
//        vertexModeCheckBox.addActionListener(o -> {
//            edgeModeCheckBox.setSelected(false);
//            canvas.changeObjectMode(ObjectModes.VERTEX);
//        });
//
//        weightField.addActionListener(o -> {
//            try {
//                int weight = Integer.parseInt(o.getActionCommand());
//                canvas.setWeight(weight);
//            } catch (Exception ignore) {}
//        });
//
//        addModeCheckBox.addActionListener(o ->{
//            delModeCheckBox.setSelected(false);
//            canvas.changeManipulateMode(Modes.ADD);
//        });
//
//        delModeCheckBox.addActionListener(o ->{
//            addModeCheckBox.setSelected(false);
//            canvas.changeManipulateMode(Modes.DELETE);
//        });
//
//        getAnswerButton.addActionListener(o -> {
//            int startNode = Integer.parseInt(circuitStartField.getText());
//            int endNode = Integer.parseInt(circuitEndField.getText());
//
//            AdjMatrixWeightedGraph graph = canvas.getGraph();
//
//            double answer = Logic.calcCircuitResistance(graph, startNode, endNode);
//            if (answer == -1) {
//                JOptionPane.showMessageDialog(this, "???????????? ???????? ???? ?????????????? ?? ???????????? ????????",
//                        "????????????", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            answerField.setText(String.valueOf(answer));
//        });
//
//        clearButton.addActionListener(o -> canvas.clearAll());
//    }
}
