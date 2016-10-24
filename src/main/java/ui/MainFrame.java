package ui;

import service.MatchService;
import service.MatchServiceImpl;
import utils.Constants;
import utils.ParsedDataSingleton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JLabel textPaneInput;
    private JLabel textPanePattern;
    private JRadioButton firstModRB;
    private JRadioButton secondModRB;
    private JRadioButton thirdModRB;
    private JButton actionButton;
    private JLabel textField;
    private ParsedDataSingleton PSD = ParsedDataSingleton.getInstance();
    private Integer modType = 1;

    public MainFrame() {
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        contentPane.setLayout(gbl_contentPane);

        textPaneInput = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 2;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(textPaneInput, gbc_lblNewLabel);

        textPanePattern = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 6;
        gbc_lblNewLabel_1.gridy = 0;
        contentPane.add(textPanePattern, gbc_lblNewLabel_1);

        firstModRB = new JRadioButton("Mod 1", true);
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 2;
        gbc_rdbtnNewRadioButton.gridy = 1;
        contentPane.add(firstModRB, gbc_rdbtnNewRadioButton);

        secondModRB = new JRadioButton("Mod 2");
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton_1.gridx = 4;
        gbc_rdbtnNewRadioButton_1.gridy = 1;
        contentPane.add(secondModRB, gbc_rdbtnNewRadioButton_1);

        thirdModRB = new JRadioButton("Mod 3");
        GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton_2.gridx = 6;
        gbc_rdbtnNewRadioButton_2.gridy = 1;
        contentPane.add(thirdModRB, gbc_rdbtnNewRadioButton_2);

        actionButton = new JButton("Action");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 3;
        contentPane.add(actionButton, gbc_btnNewButton);

        textField = new JLabel();
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 4;
        gbc_lblNewLabel_2.gridy = 5;
        contentPane.add(textField, gbc_lblNewLabel_2);

        textPaneInput.setText(Constants.replacer(PSD.getInputData().toString()));
        textPanePattern.setText(Constants.replacer(PSD.getPatternsData().toString()));
    }

    public void showRadioButton() {
        firstModRB.setMnemonic(KeyEvent.VK_C);
        secondModRB.setMnemonic(KeyEvent.VK_M);
        thirdModRB.setMnemonic(KeyEvent.VK_P);

        firstModRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModType(1);
            }
        });

        secondModRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModType(2);
            }
        });

        thirdModRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setModType(3);
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(firstModRB);
        group.add(secondModRB);
        group.add(thirdModRB);
    }

    public void buttonHandle() {
        actionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MatchService matchService = new MatchServiceImpl();
                if (getModType() == 1) {
                    matchService.containsMod();
                }
                if (getModType() == 2) {
                    matchService.EqualMod();
                }
                if (getModType() == 3) {
                    matchService.DefinedEditDistanceMod();
                }
                textField.setText(Constants.replacer(PSD.getResultData().toString()));
            }
        });
    }

    public Integer getModType() {
        return modType;
    }

    public void setModType(Integer modType) {
        this.modType = modType;
    }
}
