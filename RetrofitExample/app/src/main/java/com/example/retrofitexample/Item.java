package com.example.retrofitexample;

public class Item {
    private int cod_item;
    private String nr_item;
    private String ean_item;
    private String desc_item;
    private int quantidade;
    private Double valor;
    private String situacao;
    private String status_del_lgo;
    private int fk_categoria_item_servico_cod_ctsvo;

    public String getNr_item() {
        return nr_item;
    }

    public String getEan_item() {
        return ean_item;
    }

    public String getDesc_item() {
        return desc_item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public String getSituacao() {
        return situacao;
    }
}
