import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static String nomeS; 
    static String indirizzoS;
    public static void main(String[] args) throws Exception {
        //---------- creiamo scuola------
        String testo="";
        int numc=0;
        leggiFileScuola("scuola.txt");
        Scuola newScuola = new Scuola(nomeS,indirizzoS);
        newScuola.salvaFileScuola(nomeS,indirizzoS);
        
        testo = newScuola.infoScuola();
        System.out.println(testo);
        newScuola.leggiFileCorsi("corsi.txt");
        

        // popolare la lista dal file con i corsi preesistenti:
        // provo a leggere il file, se esiste, popolo la lista
        // stampo elenco
        // creo altri corsi
        // salvo nel file
        Corso cnew = new Corso("CSS","mario rossi");
        newScuola.aggiungiCorso(cnew);
        cnew = new Corso("ENGLISH","Jon gotti");
        newScuola.aggiungiCorso(cnew);
        cnew = new Corso("Ruby","Giorgio Billia");
        newScuola.aggiungiCorso(cnew);

        testo = newScuola.infoScuola();
        System.out.println(testo);

        newScuola.salvaFileCorsi("corsi.txt");
        testo = leggiFile("corsi.txt");
        System.out.println(testo);

        numc = newScuola.leggiFileCorsi("corsi.txt");

        System.out.println("numero corsi caricati:" + numc);
        

    }
    static String leggiFile(String nomeFile){
    String tx="";
        //C:\Users\luca lorenzo guerrin\Documents\_javavs\GestioneFileOggetti
        String pathfile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
        try {
            File myObj = new File(pathfile);
            Scanner myReader = new Scanner(myObj);
            int num=1;
            while (myReader.hasNextLine()) {
              tx  += num + " " + myReader.nextLine()+ "\n";
              num++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return tx;
    }   
    static void leggiFileScuola(String nomeFile) {
        String pathFile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
        try {
            File myObj = new File(pathFile);
            Scanner lettore = new Scanner(myObj);
            nomeS = lettore.nextLine();
            indirizzoS = lettore.nextLine();
        } catch (FileNotFoundException e) {    
            Scanner lettore = new Scanner(System.in);
            System.out.print("Inserisca il nome della scuola: ");
            nomeS = lettore.nextLine();
            System.out.print("Inserisca l'indirizzo della scuola: ");
            indirizzoS = lettore.nextLine();
        }

    }  
}
