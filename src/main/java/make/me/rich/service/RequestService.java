package make.me.rich.service;

import make.me.rich.dto.ChatRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class RequestService {


    public RequestService() {
    }

    public ChatRequestDTO createChatRequest(String prompt, String symbol) {
        return new ChatRequestDTO(prompt, symbol);
    }
}
