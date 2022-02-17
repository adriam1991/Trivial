import java.util.*;

public class Main {

    public static final String GENERAL_CULTUR = "Culturilla general";
    public static final String GEOGRAPY = "Geografía";
    public static final String FUNNY = "Diversion";
    public static final String LITERATUR_AND_CINEMA = "Literatura y cine";
    public static final int MAX_POINT = 5;
    public static final int PLAY = 1;
    public static final int WIN = 2;
    public static final int LOSE = 3;

    public static void main(String[] args) {

        HashMap<String, List<Question>> mapThemes = createMapThemes();
        int playing = PLAY;

        while (playing == PLAY) {
            String theme = askForTheme();
            playQuestion(mapThemes, theme);
            playing = continuePlaying(mapThemes);
        }
        printFinalGame();
    }

    private static void playQuestion(HashMap<String, List<Question>> mapThemes, String theme) {
        List<Question> questionsOfTheme = selectTheme(theme, mapThemes);
        printQuestion(questionsOfTheme);
        String answer = giveAnswer();
        questionsOfTheme.get(0).setIfIsCorrect(compareResult(answer, questionsOfTheme));
        printResult(questionsOfTheme);
        mapThemes.get(theme).remove(0);
    }

    private static int countCorrectAnswer(HashMap<String, List<Question>> mapThemes) {
        int count = 0;

        for (String theme : mapThemes.keySet()) {

            for (Question currentQuestion : mapThemes.get(theme)) {

                if (currentQuestion.getIfIsCorrect()) {

                    count++;
                }
            }
        }

        return count;
    }

    private static int continuePlaying(HashMap<String, List<Question>> mapThemes) {

        if (countCorrectAnswer(mapThemes) >= MAX_POINT) {

            return WIN;

        }
        if (runOutOfQuestions(mapThemes)) {


            return LOSE;

        }

        return PLAY;
    }

    private static boolean runOutOfQuestions(HashMap<String, List<Question>> mapThemes) {


    }


    private static String askForTheme() {
        System.out.println("Dime un tema entre estos: " + GENERAL_CULTUR + GEOGRAPY + FUNNY + LITERATUR_AND_CINEMA);
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static HashMap<String, List<Question>> createMapThemes() {

        HashMap<String, List<Question>> mapThemes = new HashMap<>();

        List<Question> geoQuestions = createListQuestion(GEOGRAPY);
        mapThemes.put(GEOGRAPY, geoQuestions);

        List<Question> culturQuestions = createListQuestion(GENERAL_CULTUR);
        mapThemes.put(GENERAL_CULTUR, culturQuestions);

        List<Question> funQuestions = createListQuestion(FUNNY);
        mapThemes.put(FUNNY, funQuestions);

        List<Question> literatureFilmsQuestions = createListQuestion(LITERATUR_AND_CINEMA);
        mapThemes.put(LITERATUR_AND_CINEMA, literatureFilmsQuestions);


        return mapThemes;

    }

    private static List<Question> selectTheme(String theme, HashMap<String, List<Question>> questions) {

        List<Question> questionsOfTheme = questions.get(theme);
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

    private static List<Question> createListQuestion(String theme) {

        List<Question> questions = new ArrayList<>();


        switch (theme) {
            case GEOGRAPY:
                questions.add(new Question("Donde nace el rio Ebro?:", "Fontibre", "Geografia"));
                questions.add(new Question("Que rio pasa por París?:", "Sena", "Geografia"));
                questions.add(new Question("Cual es la capital de Japón?:", "Tokio", "Geografia"));
                questions.add(new Question("Que rio pasa por Londres?", "Tamesis", "Geografia"));
                questions.add(new Question("Cual es la capital de Portugal?:", "Lisboa", "Geografia"));
                break;

            case GENERAL_CULTUR:
                questions.add(new Question("De que color es el caballo blanco de SAntiago?:", "Blanco", "Culturilla General"));
                questions.add(new Question("¿Quién escribió La Odisea?", "Homero", "Culturilla General"));
                questions.add(new Question("¿Qué tipo de animal es la ballena?", "Mamifero", "Culturilla General"));
                questions.add(new Question("¿Qué cantidad de huesos en el cuerpo humano adulto?", "206", "Culturilla General"));
                questions.add(new Question("¿Cuándo acabó la II Guerra Mundial?", "1945", "Culturilla General"));
                break;
            case FUNNY:
                questions.add(new Question("Cuantas caras tiene un dado?:", "Seis caras", "Diversion"));
                questions.add(new Question("Cuantas caras tiene el cubo de rubick?:", "6", "Diversion"));
                questions.add(new Question("¿Qué sube, pero nunca baja?:", "Edad", "Diversion"));
                questions.add(new Question("¿Qué entra duro pero sale blando y suave?:", "Chicle", "Diversion"));

            case LITERATUR_AND_CINEMA:
                questions.add(new Question("Quien escribió 100 años de soledad?:", "Garcia Marquez", "Literatura y cine"));
                questions.add(new Question("Quien dirigió el film Indiana Jones?:", "Steven Spilberg", "Literatura y cine"));
                questions.add(new Question("Quien escribió 100 años de soledad?:", "Garcia Marquez", "Literatura y cine"));
                questions.add(new Question("Quien dirigió el film Indiana Jones?:", "Steven Spilberg", "Literatura y cine"));
                break;


        }

        return questions;
    }
}
