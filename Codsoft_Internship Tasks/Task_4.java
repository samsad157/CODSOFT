import java.util.*;

class Quiz {
    private List<Question> questions;
    private int score;
    private int totalTime;

    public Quiz(List<Question> questions, int totalTime) {
        this.questions = questions;
        this.score = 0;
        this.totalTime = totalTime;
    }

    public void startQuiz() {
        for (Question question : questions) {
            displayQuestion(question);
            int timeRemaining = totalTime;
            while (timeRemaining > 0) {
                System.out.println("Time remaining: " + timeRemaining + " seconds");
                System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
                Scanner scanner = new Scanner(System.in);
                int userAnswer = scanner.nextInt();
                if (userAnswer == question.getCorrectAnswer()) {
                    score++;
                    System.out.println("Correct!");
                    break;
                } else {
                    System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeRemaining--;
            }
            System.out.println();
        }
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getText());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public int getScore() {
        return score;
    }
}

class Question {
    private String text;
    private List<String> options;
    private int correctAnswer;

    public Question(String text, List<String> options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Task_4 {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", Arrays.asList("Mumbai", "Delhi", "Kolkata", "Chennai"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Mars", "Venus", "Jupiter", "Saturn"), 1));
        questions.add(new Question("Who painted the Mona Lisa?", Arrays.asList("Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"), 1));

        Quiz quiz = new Quiz(questions, 30); // Set the total time for the quiz to 30 seconds
        quiz.startQuiz();

        System.out.println("Your final score is: " + quiz.getScore());
    }
}