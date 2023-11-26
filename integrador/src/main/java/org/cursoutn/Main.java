package org.cursoutn;

import org.cursoutn.packageModel.ClientesModel;

public class Main {
    public static void main(String[] args) {
        saludarAlMundo();
    }

    private static void saludarAlMundo () {
        System.out.println("Hello world!");
        ClientesModel cliente1 = new ClientesModel();
        cliente1.setName("Roberto");
        System.out.println("Hello, " + cliente1.getName()+ "!");
    }
}