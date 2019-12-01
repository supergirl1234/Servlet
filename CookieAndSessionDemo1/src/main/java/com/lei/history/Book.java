package com.lei.history;

import java.io.Serializable;

public class Book  implements Serializable {
    private String id;
    private String name;
    private String price;
    private String description;

    public Book() {

    }

       public Book(String id, String name, String price, String description) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.description = description;
        }

        public String getId () {
            return id;
        }

        public void setId (String id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getPrice () {
            return price;
        }

        public void setPrice (String price){
            this.price = price;
        }

        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }
    }
