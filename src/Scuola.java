import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scuola {
    private String nomeScuola;
    private String indirizzoScuola;
    private ArrayList<Corso> elencoCorsi = new ArrayList<Corso>();
    //---------------------------------costruttose----------
    Scuola(String nomeScuola,String indirizzoScuola) {
        this.indirizzoScuola = indirizzoScuola;
        this.nomeScuola = nomeScuola; 
    }
    Scuola(String nomeScuola) {
        indirizzoScuola = "";
        this.nomeScuola = nomeScuola; 
    }
    Scuola() {
        indirizzoScuola = "indirizzo x";
        nomeScuola = "scuola x"; 
    }
//----------------getter e setter----------------------------
    public String getNomeScuola() {
        return nomeScuola;
    }
    public String getIndirizzoScuola() {
        return indirizzoScuola;
    }
    public void setNomeScuola(String nomeScuola) {
        this.nomeScuola = nomeScuola;
    }
    public void setIndirizzoScuola(String indirizzoScuola) {
        this.indirizzoScuola = indirizzoScuola;
    }

//--------------------------------------metodi----------------

    public String infoScuola() {
        String ris = "";
        ris += "nome della scuola: " + nomeScuola + "\n";
        ris += "indirizzo della scuola: " + indirizzoScuola + "\n";
        ris += "№ corsi presenti: " + elencoCorsi.size() + "\n";
        ris += stampaCorsi();
        return ris;
    }
    //-------------------------------------
    String stampaCorsi() {
        
        String rigaCorsi = "";
        for(Corso c : elencoCorsi) {
            rigaCorsi += "Nome corso: " + c.nomeCorso + " - Docente: " + c.docente + "\n";
        }
        return rigaCorsi;
    }
    //---------------------------------------
    public void aggiungiCorso(Corso newCorso) {
        elencoCorsi.add(newCorso);
    }
    //------------------------------------------
    void salvaFileCorsi(String nomeFile) {
        String pathFile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
        String rigaFileCorsi = "";
        for(Corso c : elencoCorsi) {
            rigaFileCorsi += c.nomeCorso + ";" + c.docente + "\n";
        }
        try {
            FileWriter lettore = new FileWriter(pathFile);
            lettore.write(rigaFileCorsi);
            lettore.close();
        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //---------------------------------------
    
    void salvaFileScuola(String nomeScuola, String indirizzoScuola) {
        String pathFile = System.getProperty("user.dir") + "\\dati\\scuola.txt";
        try {
            FileWriter lettore = new FileWriter(pathFile);
            lettore.write(nomeScuola+"\n"+indirizzoScuola+"\n");
            lettore.close();
        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    //-------------------------------------------
    int leggiFileCorsi(String nomeFile) {
        int numCorsi = 0; 
        String pathFile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
        elencoCorsi.clear();
        try {
            File myObj = new File(pathFile);
            Scanner lettore = new Scanner(myObj);
            
            while(lettore.hasNextLine()) {
                String rigaFile = lettore.nextLine();
                try {
                    String[] arrRigaFile = rigaFile.split(";");
                    Corso newCorso = new Corso(arrRigaFile[0], arrRigaFile[1]);
                    elencoCorsi.add(newCorso);
                } catch (Exception e) {
                    System.out.println("An error formato file occurred.");
                    e.printStackTrace();
                }    
            }
            lettore.close();
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        numCorsi = elencoCorsi.size();
        return numCorsi;
    }
}
