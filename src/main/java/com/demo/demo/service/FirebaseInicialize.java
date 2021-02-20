package com.demo.demo.service;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@Service
public class FirebaseInicialize {

    @PostConstruct
    public void Inicialize() {
        try{
        FileInputStream serviceAccount
                = new FileInputStream("./servicio.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }   
}
