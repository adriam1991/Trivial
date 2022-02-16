import java.util.*;

public class Main {

    public static final String CULTURILLA_GENERAL = "Culturilla general";
    public static final String GEOGRAFÍA = "Geografía";
    public static final String DIVERSION = "Diversion";
    public static final String LITERATURA_Y_CINE = "Literatura y cine";

    public static void main(String[] args) {


        HashMap<String, List<Question>> mapThemes = createMapThemes();//inicializar
        int count = 0;

        while (count < 5) {

            String theme = askForTheme();
            List<Question> questionsOfTheme = selectTheme(theme, mapThemes);//Hacer funcion de seleccion
            printQuestion(questionsOfTheme);
            String answer = giveAnswer();
            questionsOfTheme.get(0).setIfIsCorrect(compareResult(answer, questionsOfTheme));
            printResult(questionsOfTheme);
            count++;

        }

        /*int totalCorrect = questions.stream()
                .mapToInt(question -> question.getIfIsCorrect() ? 1 : 0)
                .sum();*/

        // System.out.println(totalCorrect);

    }

    private static String askForTheme() {
        System.out.println("Que tema quieres jugar?");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static String askForTheme(List<Question> questions) {
    }

    private static HashMap<String, List<Question>> createMapThemes() {

        HashMap<String, List<Question>> mapThemes = new HashMap<>();

        List<Question> geoQuestions = createListQuestion(GEOGRAFÍA);
        mapThemes.put(GEOGRAFÍA, geoQuestions);

        List<Question> culturQuestions = createListQuestion(CULTURILLA_GENERAL);
        mapThemes.put(CULTURILLA_GENERAL, culturQuestions);

        List<Question> funQuestions = createListQuestion(DIVERSION);
        mapThemes.put(DIVERSION, funQuestions);

        List<Question> literatureFilmsQuestions = createListQuestion(LITERATURA_Y_CINE);
        mapThemes.put(LITERATURA_Y_CINE, literatureFilmsQuestions);


        return mapThemes;

    }

    private static List<Question> selectTheme(String theme, HashMap<String, List<Question>> questions) {

        List<Question> questionsOfTheme = questions.get(theme);
        questions.remove(theme, 0);
        return questionsOfTheme;

    }

    private static boolean compareResult(String answer, List<Question> currentQuestion) {

        return answer.equalsIgnoreCase(currentQuestion.get(0).getAnswer());

    }

    private static void printResult(List<Question> currentQuestion) {
        if (currentQuestion.get(0).getIfIsCorrect()) {
            System.out.println("Correcto");
        } else System.out.println("A ver si estudiamos mas...");
    }

    private static String giveAnswer() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return text;
    }

    private static void printQuestion(List<Question> questionsOfTheme) {
        System.out.println(questionsOfTheme.get(0).getQuestion());
    }

    private static List<Question> createListQuestion(String geografía) {

        List<Question> questions = new ArrayList<>();



        switch (theme) {
            case GEOGRAFÍA:
                questions.add(new Question("Donde nace el rio Ebro?:", "Fontibre", "Geografia"));
                questions.add(new Question("Que rio pasa por París?:", "Sena", "Geografia"));
                questions.add(new Question("Cual es la capital de Japón?:", "Tokio", "Geografia"));
                questions.add(new Question("Que rio pasa por Londres?", "Tamesis", "Geografia"));
                questions.add(new Question("Cual es la capital de Portugal?:", "Lisboa", "Geografia"));
                break;

            case "CULTURILLA_GENERAL" :
                questions.add(new Question("De que color es el caballo blanco de SAntiago?:","Blanco", "Culturilla General"));
                questions.add(new Question("¿Quién escribió La Odisea?","Homero", "Culturilla General"));
                questions.add(new Question("¿Qué tipo de animal es la ballena?","Mamifero", "Culturilla General"));
                questions.add(new Question("¿Qué cantidad de huesos en el cuerpo humano adulto?","206", "Culturilla General"));
                questions.add(new Question("¿Cuándo acabó la II Guerra Mundial?","1945", "Culturilla General"));
                break;
            case "DIVERSION":
                questions.add(new Question("Cuantas caras tiene un dado?:", "Seis caras", "Diversion"));
                questions.add(new Question("Cuantas caras tiene el cubo de rubick?:", "6", "Diversion"));
                questions.add(new Question("¿Qué sube, pero nunca baja?:", "Edad", "Diversion"));
                questions.add(new Question("¿Qué entra duro pero sale blando y suave?:", "Chicle", "Diversion"));

            case "LITERATURA_Y_CINE":
                questions.add(new Question("Quien escribió 100 años de soledad?:", "Garcia Marquez", "Literatura y cine"));
                questions.add(new Question("Quien dirigió el film Indiana Jones?:", "Steven Spilberg", "Literatura y cine"));
                questions.add(new Question("Quien escribió 100 años de soledad?:","Garcia Marquez","Literatura y cine"));
                questions.add(new Question("Quien dirigió el film Indiana Jones?:","Steven Spilberg","Literatura y cine"));
                break;


        }

        return questions;
    }
}
