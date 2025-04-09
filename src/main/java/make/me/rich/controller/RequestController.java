package make.me.rich.controller;

import make.me.rich.dto.ChatRequestDTO;
import make.me.rich.service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/v1/")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/request")
    public ChatRequestDTO makeRequest(String prompt, String symbol) {
        return requestService.createChatRequest(prompt, symbol);
    }
}
