class MyPasswordApp  {
    public MyPasswordApp() {
        setTitle("Password Generator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        themeToggleButton = new JButton("🌙 Switch to Light Theme");
        themeToggleButton.setFocusPainted(false);
        themeToggleButton.addActionListener(e -> toggleTheme());
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        mainPanel.add(themeToggleButton, gbc);
        JLabel title = new JLabel("Stylish Password Generator");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridy = 1;
        mainPanel.add(title, gbc);
        gbc.gridwidth = 1; gbc.gridy = 2; gbc.gridx = 0;
        JLabel lengthLabel = new JLabel("Password Length:");
        mainPanel.add(lengthLabel, gbc);
        lengthSpinner = new JSpinner(new SpinnerNumberModel(12, 4, 32, 1));
        lengthSpinner.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        mainPanel.add(lengthSpinner, gbc);
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel baseLabel = new JLabel("Enter Base Word:");
        mainPanel.add(baseLabel, gbc);
        baseWordField = new JTextField(15);
        baseWordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        mainPanel.add(baseWordField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        customWordCheck = createCheckBox("Use custom word in password");
        mainPanel.add(customWordCheck, gbc);
        gbc.gridy = 5;
        upperCaseCheck = createCheckBox("Include Uppercase (A-Z)");
        mainPanel.add(upperCaseCheck, gbc);
        gbc.gridy = 6;
        lowerCaseCheck = createCheckBox("Include Lowercase (a-z)");
        mainPanel.add(lowerCaseCheck, gbc);
        gbc.gridy = 7;
        numberCheck = createCheckBox("Include Numbers (0-9)");
        mainPanel.add(numberCheck, gbc);
        gbc.gridy = 8;
        symbolCheck = createCheckBox("Include Symbols (!@#$)");
        mainPanel.add(symbolCheck, gbc);
        generateButton = new JButton("Generate Password");
        generateButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        generateButton.addActionListener(this);
        gbc.gridy = 9;
        mainPanel.add(generateButton, gbc);
        passwordField = new JTextField(25);
        passwordField.setFont(new Font("Courier New", Font.BOLD, 16));
        passwordField.setEditable(false);
        gbc.gridy = 10; gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(passwordField, gbc);
        gbc.fill = GridBagConstraints.NONE;
        copyButton = new JButton("Copy to Clipboard");
        copyButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        copyButton.addActionListener(e -> {
            StringSelection selection = new StringSelection(passwordField.getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            JOptionPane.showMessageDialog(this, "Password copied to clipboard!");
        });
        gbc.gridy = 11;
        mainPanel.add(copyButton, gbc);

        strengthLabel = new JLabel(" ");
        strengthLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
        gbc.gridy = 12;
        mainPanel.add(strengthLabel, gbc);

        historyButton = new JButton("Show History");
        historyButton.addActionListener(e -> showHistory());
        gbc.gridy = 13;
        mainPanel.add(historyButton, gbc);

        applyTheme();
        add(mainPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        System.out.println("Hello!!!");
    }
}
