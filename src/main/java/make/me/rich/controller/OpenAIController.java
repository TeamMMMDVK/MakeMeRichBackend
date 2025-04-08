package make.me.rich.controller;

import make.me.rich.dto.ChatRequestDTO;
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
    String generation(@RequestBody ChatRequestDTO chatRequestDTO) { //Spring kan kun håndtere én requestbody, så når vi gerne vil
        //sende flere data, så laver vi en DTO med det ønskede
        return  openAIService.getPrompt(chatRequestDTO.getPrompt(), chatRequestDTO.getSymbol());
    }
}
