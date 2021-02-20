package com.demo.demo.service;

import com.demo.demo.object.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
// guardamos la persona cuando hacemos una solicitud: POST  

    public String saveUserDetails(Person person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(person.getName()).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
// obtenemos el usuario: GET

    public Person getUserDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Person person = null;

        if (document.exists()) {
            person = document.toObject(Person.class);
            return person;
        } else {
            return null;
        }
    }

    // modificamos un usuario: PUT
    public String updateUserDetails(Person person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(person.getName()).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();

    }

    // eliminamos un usuario: DELETE
    public String deleteUser(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(name).delete();
        return "Documento con ID " + name + " fue eliminado";
    }
}
