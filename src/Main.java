import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Question> questions = createListQuestion();
        HashMap<String,List<Question>> mapThemes = createMapThemes();




        for (Question currentQuestion:questions) {
            String theme = askForTheme(questions);
            List<Question> questionsOfTheme = selectTheme(theme,questions);
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

    private static HashMap<String, List<Question>> createMapThemes() {
        HashMap<String,List<Question>> mapThemes = new HashMap<>();

        List<Question> artQuestions = createListQuestion("Geografía");

        mapThemes.put("Art",artQuestions);



    }

    private static List<Question> selectTheme(String theme, List<Question> questions) {

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

    private static List<Question> createListQuestion(String theme) {
        List<Question> questions = new ArrayList<>();

        switch (theme) {
            case "Geografía" :
                questions.add(new Question("Donde nace el rio Ebro?:","Fontibre","Geografia"));
                questions.add(new Question("Que rio pasa por París?:","Sena","Geografia"));
                questions.add(new Question("Cual es la capital de Japón?:","Tokio","Geografia"));
                questions.add(new Question("Que rio pasa por Londres?", "Tamesis","Geografia"));
                questions.add(new Question("Cual es la capital de Portugal?:","Lisboa","Geografia"));
                break;
            case "Culturilla General" :
                questions.add( new Question("De que color es el caballo blanco de SAntiago?:","Blanco", "Culturilla General"));
                questions.add(new Question("¿Quién escribió La Odisea?","Homero", "Culturilla General"));
                questions.add(new Question("¿Qué tipo de animal es la ballena?","Mamifero", "Culturilla General"));
                questions.add(new Question("¿Qué cantidad de huesos en el cuerpo humano adulto?","206", "Culturilla General"));
                questions.add(new Question("¿Cuándo acabó la II Guerra Mundial?","1945", "Culturilla General"));
                break;
            case "Diversion" :
                questions.add(new Question("Cuantas caras tiene un dado?:","Seis caras", "Diversion"));
                questions.add(new Question("Cuantas caras tiene el cubo de rubick?:","6","Diversion"));
                questions.add(new Question("¿Qué sube, pero nunca baja?:","Edad","Diversion"));
                questions.add(new Question("¿Qué entra duro pero sale blando y suave?:","Chicle","Diversion"));
                break;
            case "Literatura y cine":
                questions.add(new Question("Quien escribió 100 años de soledad?:","Garcia Marquez","Literatura y cine"));
                questions.add(new Question("Quien dirigió el film Indiana Jones?:","Steven Spilberg","Literatura y cine"));
                break;



        }

        return questions;
    }
}
