//package util;
//
//public class SrtParser {
//
//}
package com.example.transcript_tagging_system.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.multipart.MultipartFile;

import com.example.transcript_tagging_system.model.Segment;

public class SrtParser {

    public static List<Segment> parseSrtFile(MultipartFile file) throws IOException {
        List<Segment> segments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}:\\d{2},\\d{3}) --> (\\d{2}:\\d{2}:\\d{2},\\d{3})");

            Segment segment = null;
            StringBuilder text = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.matches("\\d+")) {
                    if (segment != null) {
                        segment.setText(text.toString().trim());
                        segments.add(segment);
                    }
                    segment = new Segment();
                    segment.setSegmentNumber(Integer.parseInt(line));
                    text.setLength(0);
                } else {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches() && segment != null) {
                        segment.setStartTime(matcher.group(1));
                        segment.setEndTime(matcher.group(2));
                    } else if (segment != null) {
                        text.append(line).append("\n");
                    }
                }
            }
            if (segment != null) {
                segment.setText(text.toString().trim());
                segments.add(segment);
            }
        }
        return segments;
    }
}
