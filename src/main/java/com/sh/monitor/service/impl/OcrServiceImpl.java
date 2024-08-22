package com.sh.monitor.service.impl;

import com.sh.monitor.service.OcrService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OcrServiceImpl implements OcrService {
    @Override
    public String recognizeText(File imageFile) {
        return "";
    }

    @Override
    public String recognizeTextFromUrl(String imageUrl) {
        return "";
    }
}
