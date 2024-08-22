package com.sh.monitor.service;

import java.io.File;

public interface OcrService {
    public String recognizeText(File imageFile);

    public String recognizeTextFromUrl(String imageUrl);
}
