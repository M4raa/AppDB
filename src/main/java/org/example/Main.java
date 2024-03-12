package org.example;

import javax.tools.JavaCompiler;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static java.sql.Connection con;
    public static void main(String[] args) throws SQLException{
        String host = "jdbc:sqlite:src/main/resources/network";
        con = java.sql.DriverManager.getConnection( host );
        Scanner sc = new Scanner(System.in);
        String usuario,userLog;
        printMenu();
        if (sc.nextInt()==0){
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
            System.out.println("¡Cerrado con exito!");
        } else {
            printLogin();
        }
        usuario=sc.next();
        System.out.println(usuario);
        Statement st = con.createStatement();
        try {
        ResultSet rs = st.executeQuery("SELECT Usuario FROM Usuarios");
        } catch (SQLException e){
            printErrorLog();
        }
        switch (sc.nextInt()){
            case 0:
                System.out.println("Cerrado con éxito");
                break;
            case 1:
                pr
            case 2:
        }
    }
    private static void printNewUser(){
        printArt();
        Usuario mara = new Usuario("David","Mara");
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO USUARIOS (usuario, nombre) values (?, ?)");
            st.setString(1, mara.getNombre());
            st.setString(2, mara.getUsuario());
            st.executeUpdate();

        }catch (SQLException e){

        }

    }private static void printErrorLog(){
        printArt();
        System.out.println("Usuario no encontrado, introduce otro usuario o crea uno nuevo.");
        System.out.println("\u001b[36m0: Exit | 1: Nuevo Usuario | 2: Reintentar\u001B[0m");
        System.out.println("\u001B[33m_____________________________________\u001B[0m");
        System.out.println("-->");
    }
    private static void printAfterLog(){
        printArt();
        System.out.println("¡Login exitoso!");
        System.out.println("\u001b[36m0: Exit | 1: New Post | 2: Comentar\u001B[0m");
        System.out.println("\u001B[33m_____________________________________\u001B[0m");
        System.out.println("-->");
    }
    private static void printMenu(){
        printArt();
        System.out.println("\u001b[36m0: Exit | 1: Login\u001B[0m");
        System.out.println("\u001B[33m_____________________________________\u001B[0m");
        System.out.println("-->");
    }
    private static void printLogin(){
        printArt();
        System.out.println("\u001b[36mNombre de ususario:\u001B[0m");
        System.out.println("-->");
    }
    private static void printArt(){
        String arteAscii = "" +
                "\u001B[33m                      _____  ____ \n" +
                "    /\\               |  __ \\|  _ \\  \n" +
                "   /  \\   _ __  _ __ | |  | | |_) | \n" +
                "  / /\\ \\ | '_ \\| '_ \\| |  | |  _ <  \n" +
                " / ____ \\| |_) | |_) | |__| | |_) | \n" +
                "/_/    \\_\\ .__/| .__/|_____/|____/  \n" +
                "         | |   | |                  \n" +
                "         |_|   |_|                  \n"+
                "_____________________________________\u001B[0m";
        System.out.println(arteAscii);
    }


}