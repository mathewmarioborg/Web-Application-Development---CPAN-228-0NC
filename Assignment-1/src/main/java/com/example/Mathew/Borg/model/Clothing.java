package com.example.Mathew.Borg.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Builder
public class Clothing {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Brand brandForm;
    @Min(2021)
    private int yearOfCreation;
    @Min(1000)
    private double price;

    public enum Brand {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR("Dior");

        private String title;

        private Brand(String title) {this.title = title;}

        public String getTitle(){return title;}
    }
}
