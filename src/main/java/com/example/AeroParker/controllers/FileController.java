package com.example.AeroParker.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import com.example.AeroParker.dto.SiteDTO;
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
    @Autowired
    private CsvUtils csvUtil;

    // @PostMapping(value = "/upload", consumes = "text/csv")
    // public void uploadSimple(@RequestBody InputStream body) throws IOException {
    //     siteRepository.saveAll(CsvUtils.read(Site.class, body));
    // }

    @PostConstruct
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void populateSitesWithLocalCSV() {
        System.out.println(" \n Populating Sites with local CSV");
        File dest = new File("src/Sites.csv");
        csvUtil.openFile(dest);
        
        for (String siteValue : csvUtil.readFileReturnList()) {
            Site site = new Site();
            site.setName(siteValue);
            siteRepository.save(site);
        }

        csvUtil.closeFile();
   
    }

}