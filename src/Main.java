import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Question> questions = createListQuestion();



        for (Question currentQuestion:questions) {

            printQuestion(currentQuestion);
            String answer = giveAnswer();
            currentQuestion.setIfIsCorrect(compareResult(answer,currentQuestion));
            printResult(currentQuestion);

        }

    }

    private static void printResult(Question currentQuestion) {
        if (currentQuestion.getIfIsCorrect()){
            System.out.println("Correcto");
        }else System.out.println("A ver si estudiamos mas...");
    }

    private static String giveAnswer() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return text;
    }

    private static void printQuestion(Question currentQuestion) {
        System.out.println(currentQuestion.getQuestion());
    }

    private static List<Question> createListQuestion() {
        List<Question> questions = new ArrayList<>();

        Question question1 = new Question("Cual es la capital de Portugal?:","Lisboa");
        Question question2 = new Question("Cuantas caras tiene un dado?:","Seis caras");
        Question question3 = new Question("De que color es el caballo blanco de SAntiago?:","Blanco");
        Question question4 = new Question("Quien escribió 100 años de soledad?:","Garcia Marquez");
        Question question5 = new Question("Quien dirigió el film Indiana Jones?:","Steven Spilberg");


        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        return questions;
    }
}
