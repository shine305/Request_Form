package jp.ac.ccmc.form_sample;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/contact")
public class FormController {
    private Map<String, String> radioSeat;
    private Map<String, String> selectAddress;

    public FormController() {
        radioSeat = new LinkedHashMap<>();
        radioSeat.put("A Seat", "A席");
        radioSeat.put("B Seat", "B席");
        radioSeat.put("other", "その他");

        selectAddress = new LinkedHashMap<>();
        selectAddress.put("Tokyo", "東京都");
        selectAddress.put("Saitama", "埼玉県");
        selectAddress.put("Chiba", "千葉県");
        selectAddress.put("Kanagawa", "神奈川県");
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "contact";
    }

    @GetMapping("/message")
    public String showMessageForm(Model model, UserMessage userMessage) {
        model.addAttribute("radioSeat", radioSeat);
        model.addAttribute("selectAddress", selectAddress);
        model.addAttribute("message", userMessage);
        return "form/message-form";
    }

    @PostMapping("/message")
    public String postMessageForm(Model model, UserMessage userMessage, RedirectAttributes redirectAttributes) {
        if (userMessage.getBody().isEmpty()) {
            redirectAttributes.addFlashAttribute("note", "caution");
            redirectAttributes.addFlashAttribute("userMessage", userMessage);
            return "redirect:./message";
        }
        model.addAttribute("radioSeat", radioSeat);
        model.addAttribute("selectAddress", selectAddress);
        model.addAttribute("message", userMessage);
        return "form/message-result";
    }

    @GetMapping("/request")
    public String showRequestForm(Model model, UserRequest userRequest) {
        model.addAttribute("radioSeat", radioSeat);
        model.addAttribute("selectAddress", selectAddress);
        model.addAttribute("request", userRequest);
        return "form/request-form";
    }
    
    @PostMapping("/request")
    public String postRequestForm(Model model, UserRequest userRequest, RedirectAttributes redirectAttributes) {
        if (userRequest.getBody().isEmpty()) {
            redirectAttributes.addFlashAttribute("note", "caution");
            redirectAttributes.addFlashAttribute("userRequest", userRequest);
            return "redirect:./request";
        }
        model.addAttribute("radioSeat", radioSeat);
        model.addAttribute("selectAddress", selectAddress);
        model.addAttribute("request", userRequest);
        return "form/request-result";
    }

}