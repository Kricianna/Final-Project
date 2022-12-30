import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
	
	private String[] questions = {
			/**
			 * A string that holds the questions
			 */
			"Which series does Sunburned Heart belongs?",
			"Who are the main characters in A Call To Your Arms?",
			"Which series does Heartless belongs?",
			"Which series does Shelter in Your Fingertips belongs?",
			"Which book title doesn't belong to Costa Leona Series?",
			"Who are the main characters in Tripped?",
			"What is the real name of Jonaxx?",
			"Which book title doesn't belong to Azucarera Series?",
			"What book first published under MPress?",
			"What book first published under Pop Fiction?"
	};
	private String[][] choices = {
			/**
			 * A string to hold the choices
			 */
			{"Costa Leona","Arts of Seduction","Montefalco","Alegria Girls"},
			{"Ryla & Roscoe","Leandro & Charlotta","Uriel & Lucianna","Raica & Real"},
			{"Elizalde Brothers","Arts of Seduction","Montefalco","Alegria Girls"},
			{"Costa Leona","Arts of Seduction","Rara Avis","Alegria Girls"},
			{"Kissing the Dust","After the Chains","Chase & Hearts","Sands of Time"},
			{"Knoxx & Entice","Riguel & Lilienne","Fourth & Freya","Wade & Reina"},
			{"Jonah Marie","Janah Mae","Jona May","Jonah Mae"},
			{"Love in the Dark","Hold Me Close","Against the Heart","Getting To You"},
			{"Worthless","Mapapansin Kaya","Heartless","Baka Sakali"},
			{"Worthless","Mapapansin Kaya","Every Beast Needs a Beauty","Baka Sakali"}
	};
	private char[] answers = {
			/**
			 * A string to hold the answers
			 */
			'A','D','A','C','C','B','D','A','C','B'
	};
	char choice;
	char answer;
	int index;
	int correctChoice =0;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;
	/**
	 * Declaration of Variables
	 */
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	JTextField numberRight = new JTextField();
	JTextField percentage = new JTextField();
	JTextField quizName = new JTextField();
	/**
	 * Initialization or creating the objects
	 */
	Timer timer = new Timer(1000, new ActionListener() {
		/**
		 * Timer for next questions
		 * Displaying the time and the answer if the time ended
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeft.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
	});
	public Quiz() {
		/**
		 * constructor
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.getContentPane().setBackground(new Color(255,204,204));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,700,50);
		textfield.setBackground(new Color(255,255,255));
		textfield.setForeground(new Color(155,0,76));
		textfield.setFont(new Font("Segoe Print",Font.BOLD,35));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
	
		textarea.setBounds(0,50,700,40);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(255,250,250));
		textarea.setForeground(new Color(255,102,178));
		textarea.setFont(new Font("Perpetua",Font.BOLD,30));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);

		buttonA.setBounds(10,100,100,100);
		buttonA.setFont(new Font("Monospaced",Font.BOLD,30));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(10,200,100,100);
		buttonB.setFont(new Font("Monospaced",Font.BOLD,30));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(10,300,100,100);
		buttonC.setFont(new Font("Monospaced",Font.BOLD,30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(10,400,100,100);
		buttonD.setFont(new Font("Monospaced",Font.BOLD,30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answerLabelA.setBounds(125,100,500,100);
		answerLabelA.setBackground(new Color(255,204,204));
		answerLabelA.setForeground(new Color(255,0,127));
		answerLabelA.setFont(new Font("Pristina",Font.PLAIN,40));
		
		answerLabelB.setBounds(125,200,500,100);
		answerLabelB.setBackground(new Color(255,204,204));
		answerLabelB.setForeground(new Color(255,0,127));
		answerLabelB.setFont(new Font("Pristina",Font.PLAIN,40));
		
		answerLabelC.setBounds(125,300,500,100);
		answerLabelC.setBackground(new Color(255,204,204));
		answerLabelC.setForeground(new Color(255,0,127));
		answerLabelC.setFont(new Font("Pristina",Font.PLAIN,40));
		
		answerLabelD.setBounds(125,400,500,100);
		answerLabelD.setBackground(new Color(255,204,204));
		answerLabelD.setForeground(new Color(255,0,127));
		answerLabelD.setFont(new Font("Pristina",Font.PLAIN,40));
		
		secondsLeft.setBounds(550,550,100,100);
		secondsLeft.setBackground(new Color(255,204,204));
		secondsLeft.setForeground(new Color(51,0,25));
		secondsLeft.setFont(new Font("Stencil",Font.BOLD,50));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		timeLabel.setBounds(500,500,200,25);
		timeLabel.setBackground(new Color(255,204,204));
		timeLabel.setForeground(new Color(0,0,0));
		timeLabel.setFont(new Font("Comic Sans MS",Font.ITALIC,25));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText("Time Left:");
		
		numberRight.setBounds(225,225,200,100);
		numberRight.setBackground(new Color(255,51,153));
		numberRight.setForeground(new Color(255,255,255));
		numberRight.setFont(new Font("Snap ITC",Font.BOLD,100));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(255,51,153));
		percentage.setForeground(new Color(255,255,255));
		percentage.setFont(new Font("Snap ITC",Font.BOLD,100));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
	
		quizName.setBounds(0,600,400,50);
		quizName.setBackground(new Color(255,204,204));
		quizName.setForeground(new Color(255,0,127));
		quizName.setFont(new Font("Segoe Script",Font.BOLD,30));
		quizName.setHorizontalAlignment(JTextField.CENTER);
		quizName.setText("Jonaxx Stories Quiz");
		

		frame.add(textarea);
		frame.add(textfield);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);		
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(answerLabelD);		
		frame.add(timeLabel);
		frame.add(secondsLeft);
		frame.add(quizName);
		frame.setVisible(true);
		/**
		 * to display the labels and buttons in the frame
		 */
		nextQuestion();
	}
	public void nextQuestion() {
		/**
		 * assigning total number of questions to index
		 */
		if(index>=totalQuestions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answerLabelA.setText(choices[index][0]);
			answerLabelB.setText(choices[index][1]);
			answerLabelC.setText(choices[index][2]);
			answerLabelD.setText(choices[index][3]);
			timer.start();
			/**
			 * Assigning the choices in labels or letter choices
			 */
		}
	}
	/**
	 * @Override
	 */
	public void actionPerformed(ActionEvent e) {
		/**
		 * Where buttons be performed
		 */
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		/**
		 * disabling the buttons
		 */
		if(e.getSource()==buttonA) {
			answer= 'A';
			if(answer == answers[index]) {
				correctChoice++;
			}
		}
		if(e.getSource()==buttonB) {
			answer= 'B';
			if(answer == answers[index]) {
				correctChoice++;
			}
		}
		if(e.getSource()==buttonC) {
			answer= 'C';
			if(answer == answers[index]) {
				correctChoice++;
			}
		}
		if(e.getSource()==buttonD) {
			answer= 'D';
			if(answer == answers[index]) {
				correctChoice++;
			}
			/**
			 * Determining which button is clicked
			 * Checking if it is the correct answer
			 * Assigning point in correct choice for true if statement
			 */
		}
		displayAnswer();
	}
	public void displayAnswer() {
		/**
		 * To display the correct answer
		 */
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		/**
		 * disabling the buttons
		 */
		if(answers[index]!= 'A')
			answerLabelA.setForeground(new Color(255,0,0));
		if(answers[index]!= 'B')
			answerLabelB.setForeground(new Color(255,0,0));
		if(answers[index]!= 'C')
			answerLabelC.setForeground(new Color(255,0,0));
		if(answers[index]!= 'D')
			answerLabelD.setForeground(new Color(255,0,0));
		/**
		 * Turning  the  wrong answers to red
		 */
		Timer pause = new Timer(1000, new ActionListener() {
			/**
			 * Pausing the timer for the next question
			 */		
			@Override
			public void actionPerformed(ActionEvent e) {
				answerLabelA.setForeground(new Color(255,0,127));
				answerLabelB.setForeground(new Color(255,0,127));
				answerLabelC.setForeground(new Color(255,0,127));
				answerLabelD.setForeground(new Color(255,0,127));
				/**
				 * Turning the answers back to its original color after the pause of the timer
				 */
				answer = ' ';
				seconds=10;
				secondsLeft.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
				/**
				 * enabling the buttons for the next question
				 * setting the seconds to 10 and displaying it
				 */	
			}
		});
		pause.setRepeats(false);
		pause.start();
		/**
		 * start the timer
		 * repeats the timer only ones
		 */
	}
	public void results() {
		/**
		 * To display the final score
		 */
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		/**
		 * disabling the buttons
		 */
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		buttonC.setVisible(false);
		buttonD.setVisible(false);
		timeLabel.setVisible(false);
		secondsLeft.setVisible(false);
		/**
		 * hiding the buttons
		 */
		result =(int)((correctChoice/(double)totalQuestions)*100);
		/**
		 * solving for the results
		 */
		if(correctChoice > 8) {
			textfield.setText("CONGRATS! You are a true JSL!");
		}else if(correctChoice > 5) {
			textfield.setText("Acceptable");
		}else {
			textfield.setText("Read more Jonaxx Stories!");
		}
		/**
		 * Assigning different text for different correct choices
		 */
		textarea.setText("Score");
		answerLabelA.setText(" ");
		answerLabelB.setText(" ");
		answerLabelC.setText(" ");
		answerLabelD.setText(" ");
		/**
		 * Assigning the labels clear
		 */
		numberRight.setText("("+correctChoice+"/"+totalQuestions+")");
		percentage.setText(result+"%");
		numberRight.setFont(new Font("Serif",Font.BOLD,30));
		percentage.setFont(new Font("Century Gothic",Font.PLAIN,30));
		/**
		 * Solving for the results 
		 */
		frame.add(percentage);
		frame.add(numberRight);
		/**
		 * display the labels in the frame
		 */
	}
}