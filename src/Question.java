public class Question {

    private boolean isCorrect;
    private String question;

    public Question(boolean isCorrect, String question) {
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
