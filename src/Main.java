import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Question> questions = createListQuestion();

        for (Question currentQuestion:questions) {
            String theme = askForTheme(questions);
            selectTheme(theme,questions);
            printQuestion(currentQuestion);
            String answer = giveAnswer();
            currentQuestion.setIfIsCorrect(compareResult(answer,currentQuestion));
            printResult(currentQuestion);


        }

        int totalCorrect = questions.stream()
                .mapToInt(question -> question.getIfIsCorrect() ? 1 : 0)
                .sum();

        System.out.println(totalCorrect);

    }

    private static boolean compareResult(String answer, Question currentQuestion) {


        return answer.equalsIgnoreCase(currentQuestion.getAnswer());


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

        Question question1 = new Question("Cual es la capital de Portugal?:","Lisboa","Geografia");
        Question question2 = new Question("Cuantas caras tiene un dado?:","Seis caras", "Diversion");
        Question question3 = new Question("De que color es el caballo blanco de SAntiago?:","Blanco", "Culturilla General");
        Question question16 = new Question("¿Quién escribió La Odisea?","Homero", "Culturilla General");
        Question question17 = new Question("¿Qué tipo de animal es la ballena?","Mamifero", "Culturilla General");
        Question question18 = new Question("¿Qué cantidad de huesos en el cuerpo humano adulto?","206", "Culturilla General");
        Question question19 = new Question("¿Cuándo acabó la II Guerra Mundial?","1945", "Culturilla General");
        Question question4 = new Question("Quien escribió 100 años de soledad?:","Garcia Marquez","Literatura y cine");
        Question question5 = new Question("Quien dirigió el film Indiana Jones?:","Steven Spilberg","Literatura y cine");
        Question question11 = new Question("¿Qué cosa se mantiene siempre en el suelo y en las paredes pero nunca se ensucia?:","Sombra","Diversion");
        Question question12 = new Question("¿Qué sube, pero nunca baja?:","Edad","Diversion");
        Question question13 = new Question("¿Qué entra duro pero sale blando y suave?:","Chicle","Diversion");
        Question question6 = new Question("Donde nace el rio Ebro?:","Fontibre","Geografia");
        Question question7 = new Question("Que rio pasa por París?:","Sena","Geografia");
        Question question8 = new Question("Cual es la capital de Japón?:","Tokio","Geografia");
        Question question9= new Question("Que rio pasa por Londres?", "Tamesis","Geografia");
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question11);
        questions.add(question12);
        questions.add(question13);
        questions.add(question16);
        questions.add(question17);
        questions.add(question18);
        questions.add(question19);

        return questions;
    }
}
