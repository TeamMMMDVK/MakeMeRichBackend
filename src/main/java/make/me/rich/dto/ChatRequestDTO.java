package make.me.rich.dto;

public class ChatRequestDTO {

    private String prompt;
    private String symbol;

    // Getters og setters
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

