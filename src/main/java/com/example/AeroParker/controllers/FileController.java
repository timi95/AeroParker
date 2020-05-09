package com.example.AeroParker.controllers;

import java.io.IOException;
import java.io.InputStream;

import com.example.AeroParker.models.Site;
import com.example.AeroParker.repositories.SiteRepository;
import com.example.AeroParker.services.CsvUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import antlr.collections.List;

@Controller
public class FileController {
    @Autowired
    private SiteRepository siteRepository;

    // @PostMapping(value = "/upload", consumes = "text/csv")
    // public void uploadSimple(@RequestBody InputStream body) throws IOException {
    //     siteRepository.saveAll(CsvUtils.read(Site.class, body));
    // }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam MultipartFile file) throws IOException {
        // siteRepository.saveAll(CsvUtils.read(Site.class, file.getInputStream()));
        
        // CsvUtils.loadObjectList(Site.class, file.getName());
        for (Site site : CsvUtils.loadObjectList(Site.class, file.getName())) {
            siteRepository.save(site);
        }
        System.out.println( "object list => "+CsvUtils.loadObjectList(Site.class, file.getOriginalFilename()) );
        System.out.println( "File name => "+ file.getOriginalFilename() );

    }
}