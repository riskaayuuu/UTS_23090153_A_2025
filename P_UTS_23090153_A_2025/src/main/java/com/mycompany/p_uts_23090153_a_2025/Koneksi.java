/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p_uts_23090153_a_2025;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author My Asus
 */
public class Koneksi {

    public static void main(String[] args) {
        try {
            // Ganti URI jika diperlukan, default localhost:27017
            MongoClientURI url = new MongoClientURI("mongodb://localhost:27017");
            MongoClient mongoClient = new MongoClient(url);


            MongoDatabase database = mongoClient.getDatabase("uts_23090153_A_2025");

            System.out.println("Berhasil konek ke database: " + database.getName());

            mongoClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
