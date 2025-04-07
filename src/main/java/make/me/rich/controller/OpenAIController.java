package make.me.rich.controller;

import make.me.rich.service.OpenAIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class OpenAIController {
    private final OpenAIService openAIService;

    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/ai")
    String generation(@RequestBody String prompt) {
        return  openAIService.getPrompt(prompt);
    }
}
