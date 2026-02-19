
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author SD10058954
 */
public class SimpleHelp {

    /**
     * Scans Help document and displays it
     */
    public static void show() {
        try {

            Scanner scFile = new Scanner(new File("Help.txt"));
            String output = "";
            while (scFile.hasNext()) {
                String data = scFile.nextLine();
                output = output + data + "\n";
            }
            JOptionPane.showMessageDialog(null, output);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

}
