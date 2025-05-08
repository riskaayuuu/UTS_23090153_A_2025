/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p_uts_23090153_a_2025;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;


/**
 *
 * @author My Asus
 */
public class CRUD_23090153_A_2025 {
    public static void main(String[] args) {
        // Membuat koneksi ke MongoDB lokal
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Mengakses database
        MongoDatabase database = mongoClient.getDatabase("uts_23090153_A_2025");

        // Mengakses collection
        MongoCollection<Document> collection = database.getCollection("coll_23090153_A_2025");

        // -------- CREATE --------
        Document doc1 = new Document("nama produk", "Moisturizer Wardah Brightening")
                .append("kategori", "Moisturizer")
                .append("stok produk", "8");

        Document doc2 = new Document("nama produk", "Sunscreen SkinAqua spf50")
                .append("kategori", "Sunscreen")
                .append("stok produk", "4");

        Document doc3 = new Document("nama produk", "Lipstint Hanasui ")
                .append("kategori", "Lip Produk")
                .append("stok produk", "18");
        
        Document doc4 = new Document("nama produk", "Toner Emina ")
                .append("kategori", "Toner")
                .append("stok produk", "2");

        collection.insertOne(doc1);
        collection.insertOne(doc2);
        collection.insertOne(doc3);
        collection.insertOne(doc4);
        System.out.println("=== CREATE: Data berhasil ditambahkan ===\n");

        // -------- READ --------
        System.out.println("=== READ: Menampilkan seluruh data ===");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        // -------- UPDATE --------
        Bson filter = eq("nama produk", "Toner Emina");
        Bson update = new Document("$set", new Document("nama produk", "Toner Skintifik Update"));
        collection.updateOne(filter, update);
        System.out.println("\n=== UPDATE: Data berhasil diubah ===");

        // -------- DELETE --------
        collection.deleteOne(eq("kategori", "Toner"));
        System.out.println("\n=== DELETE: Data dengan kategori Lip Produk telah dihapus ===");

        // -------- SEARCH --------
        System.out.println("\n=== SEARCH: Cari dokumen dengan 'Toner Emina' ===");
        for (Document doc : collection.find(regex("nama produk", "Toner Emina"))) {
            System.out.println(doc.toJson());
        }


        // Tutup koneksi
        mongoClient.close();
    }
}
