import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class BankFrame extends JFrame implements ActionListener{
	private JLabel accountBalanceLabel;			// Label for account balance
	private JTextField accountBalanceField;		// Field for account balance
	private JLabel amountLabel;					// Label for amount to deposit/withdraw
	private JTextField amountField;				// Field for amount to deposit/withdraw
	private JPanel bankBalance;					// Displays bank balance
	private JButton deposit; 					// Triggers deposit
	private JButton withdraw;					// Triggers withdraw
	
	
	/*
	 * Constructor creates GUI components and adds GUI components
	 * using a GridBagLayout
	 */
	BankFrame(){
		// Used to specify GUI component layout
		GridBagConstraints positionConst = null;
		
		// Set frame's title
		setTitle("Bank Account Balance");
		
		// Set account balance title
		accountBalanceLabel = new JLabel("Account Balance:");
		
		accountBalanceField = new JTextField(15);
		accountBalanceField.setEditable(false);
		accountBalanceField.setText("0");
		
		amountLabel = new JLabel("Enter Amount: ");
		
		amountField = new JTextField(15);
		amountField.setEditable(true);
		amountField.setText("0");
		
		// Create buttons
		deposit = new JButton("Deposit");
		deposit.addActionListener(this);
		
		withdraw = new JButton("Withdraw");
		withdraw.addActionListener(this);
		
		// Use a GridBagLayout
		setLayout(new GridBagLayout());
		positionConst = new GridBagConstraints();
		
		// Specify component's grid location
		positionConst.gridx = 0;
		positionConst.gridy = 0;
		
		// 10 pixels of padding around component (top, left, bottom, right)
		positionConst.insets = new Insets(10, 10, 10, 10);
				
		// Add component using the specified constraints
		add(amountLabel, positionConst);
		
		positionConst.gridx = 1;
		positionConst.gridy = 0;
		positionConst.insets = new Insets(10, 10, 10, 10);
		add(amountField, positionConst);
		
		positionConst.gridx = 0;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		positionConst.anchor = GridBagConstraints.LINE_END;
		add(deposit, positionConst);
		
		positionConst.gridx = 1;
		positionConst.gridy = 1;
		positionConst.insets = new Insets(10, 10, 10, 10);
		positionConst.anchor = GridBagConstraints.LINE_START;
		add(withdraw, positionConst);
		
		// Adding account balance to JPanel
		bankBalance = new JPanel();
		bankBalance.add(accountBalanceLabel);
		bankBalance.add(accountBalanceField);
		
		positionConst.gridx = 0;
		positionConst.gridy = 2;
		positionConst.insets = new Insets(10, 10, 10, 10);
		positionConst.gridwidth = 2;						// Need to expand JPanel to 2 columns to avoid distortion
		add(bankBalance, positionConst);
	}

	
	/*
	 * Method is automatically called when an event 
	 * occurs (e.g, button is pressed)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();		// Returns the object that triggered the event (the clicked button)
		String userInput;						// User specified amount
		String balance;							// Account Balance
		int amount;								// Amount
		int totBalance;							// balance
		
		// Get user's specified amount
		userInput = amountField.getText();
		
		balance = accountBalanceField.getText();
		
		// Convert from String to Integer
		amount = Integer.parseInt(userInput);
		
		totBalance = Integer.parseInt(balance);
		
		if (source == deposit) {
			accountBalanceField.setText(Integer.toString(amount + totBalance));
		}
		
		else if (source == withdraw) {
			accountBalanceField.setText(Integer.toString(totBalance - amount));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankFrame myFrame = new BankFrame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);		
	}

}


/*
Things we need: 

1. Obtain bank account balance
2. Display balance within JPanel once button is clicked
3. Deposit and Withdraw Funds
4. Display remaining account balance

Ensure application includes the following: 
1. JPanel
2. JButton
3. ActionListener
*/