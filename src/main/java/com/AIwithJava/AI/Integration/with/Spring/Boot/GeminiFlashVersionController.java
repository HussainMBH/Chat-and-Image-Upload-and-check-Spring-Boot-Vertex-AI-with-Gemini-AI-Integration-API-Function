package com.AIwithJava.AI.Integration.with.Spring.Boot;

import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/geminiVersion")
@RequiredArgsConstructor
public class GeminiFlashVersionController {
    private final GenerativeModel generativeModel;

    @PostMapping
    public String file(@RequestParam("file") MultipartFile file, @RequestParam String question) throws IOException {
        GenerateContentResponse generateContentResponse = this.generativeModel.generateContent(
                ContentMaker.fromMultiModalData(
                        PartMaker.fromMimeTypeAndData(file.getContentType(), file.getBytes()), question
                )
        );
        return ResponseHandler.getText(generateContentResponse);
    }
}
