public class Question {

    private boolean isCorrect;
    private String question;
    private String answer;
    private String theme;

    public Question(String question, String answer, String theme) {

        this.question = question;
        this.answer = answer;
        this.theme = theme;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getIfIsCorrect() {
        return isCorrect;
    }

    public void setIfIsCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
