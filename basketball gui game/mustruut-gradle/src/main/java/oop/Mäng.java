package oop;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import  javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Mäng {
    private ArrayList<String> tiim1Mängijad;
    private ArrayList<String> tiim1algViisik;
    private ArrayList<String> tiim1VahetusMängijad;
    private ArrayList<List> tiim1MängijadViskeProtsendiga;

    private ArrayList<String> tiim2Mängijad;
    private ArrayList<String> tiim2algViisik;
    private ArrayList<String> tiim2VahetusMängijad;
    private ArrayList<List> tiim2MängijadViskeProtsendiga;

    private String tiim1;
    private String tiim2;

    //Koduväljaku boonuse lisa
    private int tiim1Eelis;
    private int tiim2Eelis;


    MänguAbi mänguabi = new MänguAbi();

    public Mäng(ArrayList<String> tiim1Mängijad, ArrayList<String> tiim1algViisik, ArrayList<String> tiim1VahetusMängijad, ArrayList<List> tiim1MängijadViskeProtsendiga, ArrayList<String> tiim2Mängijad, ArrayList<String> tiim2algViisik, ArrayList<String> tiim2VahetusMängijad, ArrayList<List> tiim2MängijadViskeProtsendiga, String tiim1, String tiim2, int tiim1Eelis, int tiim2Eelis) {
        this.tiim1Mängijad = tiim1Mängijad;
        this.tiim1algViisik = tiim1algViisik;
        this.tiim1VahetusMängijad = tiim1VahetusMängijad;
        this.tiim1MängijadViskeProtsendiga = tiim1MängijadViskeProtsendiga;
        this.tiim2Mängijad = tiim2Mängijad;
        this.tiim2algViisik = tiim2algViisik;
        this.tiim2VahetusMängijad = tiim2VahetusMängijad;
        this.tiim2MängijadViskeProtsendiga = tiim2MängijadViskeProtsendiga;
        this.tiim1 = tiim1;
        this.tiim2 = tiim2;
        this.tiim1Eelis = tiim1Eelis;
        this.tiim2Eelis = tiim2Eelis;
    }

    //antud meetod jooksutab mängu
    public void liveMäng() throws InterruptedException {
        ArrayList<String> mängulaused = new ArrayList<>();
        Stage mäng = new Stage();
        int tiim1Skoor = 0;
        int tiim2Skoor = 0;
        Map<String,Integer> parimad1 = new HashMap<>();
        Map<String,Integer> parimad2 = new HashMap<>();
        int veerandAjad = 0;
        Random tiimideIndex = new Random();
        //for tsükkel visete sooritamiseks
        for (int i = 0; i < 92; i++) {
            //int viskaja valimiseks
            int viskaja1 = tiimideIndex.nextInt(5);
            //eelnevalt saadud intiga moodustan viskaja stringi
            String valitudViskaja1 = tiim1algViisik.get(viskaja1);
            //int viskaja tabavuse leidmiseks
            int viskaja1Tabavus = tiimideIndex.nextInt(100 - tiim1Eelis) + tiim1Eelis;
            //int, mille abil leian, kas viskaja viskab kahest või kolmest
            int viskaja1ViskeKaugus = tiimideIndex.nextInt(2) + 1;

            //analoogne nagu eelpool
            int viskaja2 = tiimideIndex.nextInt(5);
            String valitudViskaja2 = tiim2algViisik.get(viskaja2);
            int viskaja2Tabavus = tiimideIndex.nextInt(100- tiim2Eelis)+tiim2Eelis;
            int viskaja2ViskeKaugus = tiimideIndex.nextInt(2) + 1;

            //väsimus
            /*for (int j = 0; j < tiim1MängijadViskeProtsendiga.size() ; j++) {
                String a = (String) tiim1MängijadViskeProtsendiga.get(j).get(3);
                int b = Integer.parseInt(a)-1;
                String c = Integer.toString(b);
                tiim1MängijadViskeProtsendiga.get(j).set(3, c);
                if (b == 60) {
                    System.out.println("\u001B[31;1m" + tiim1MängijadViskeProtsendiga.get(j).get(0) + " on veidi väsinud. (-2% visketabamus)" + "\u001B[0m");
                    String väsimus1a = (String) tiim1MängijadViskeProtsendiga.get(j).get(2);
                    int väsimus1b = Integer.parseInt(väsimus1a)-2;
                    String väsimus1c = Integer.toString(väsimus1b);
                    tiim1MängijadViskeProtsendiga.get(j).set(2, väsimus1c);
                    String väsimus12a = (String) tiim1MängijadViskeProtsendiga.get(j).get(1);
                    int väsimus12b = Integer.parseInt(väsimus12a)-2;
                    String väsimus12c = Integer.toString(väsimus12b);
                    tiim1MängijadViskeProtsendiga.get(j).set(1, väsimus12c);
                }
                if (b == 40) {
                    System.out.println("\u001B[31;1m" + tiim1MängijadViskeProtsendiga.get(j).get(0) + " on üsna väsinud. (-4% visketabamus)" + "\u001B[0m");
                    String väsimus1a = (String) tiim1MängijadViskeProtsendiga.get(j).get(2);
                    int väsimus1b = Integer.parseInt(väsimus1a)-2;
                    String väsimus1c = Integer.toString(väsimus1b);
                    tiim1MängijadViskeProtsendiga.get(j).set(2, väsimus1c);
                    String väsimus12a = (String) tiim1MängijadViskeProtsendiga.get(j).get(1);
                    int väsimus12b = Integer.parseInt(väsimus12a)-2;
                    String väsimus12c = Integer.toString(väsimus12b);
                    tiim1MängijadViskeProtsendiga.get(j).set(1, väsimus12c);
                }
                if (b == 20) {
                    System.out.println("\u001B[31;1m" + tiim1MängijadViskeProtsendiga.get(j).get(0) + " on väga väsinud. Soovib vahetust. (-6% visketabamus)" + "\u001B[0m");
                    String väsimus1a = (String) tiim1MängijadViskeProtsendiga.get(j).get(2);
                    int väsimus1b = Integer.parseInt(väsimus1a)-2;
                    String väsimus1c = Integer.toString(väsimus1b);
                    tiim1MängijadViskeProtsendiga.get(j).set(2, väsimus1c);
                    String väsimus12a = (String) tiim1MängijadViskeProtsendiga.get(j).get(1);
                    int väsimus12b = Integer.parseInt(väsimus12a)-2;
                    String väsimus12c = Integer.toString(väsimus12b);
                    tiim1MängijadViskeProtsendiga.get(j).set(1, väsimus12c);

                }
            }


            //veerandajad
            /*if(i == 23 || i == 46 || i == 69){
                veerandAjad++;
                System.out.println();
                System.out.println(veerandAjad+". veerandaja lõpp. Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);
                System.out.println(tiim1 + "i mängijate statistika: " + Arrays.toString(parimad1.entrySet().toArray()));
                System.out.println(tiim2 + "i mängijate statistika: " + Arrays.toString(parimad2.entrySet().toArray()));
                System.out.println();
                Scanner vahetuste_alustus = new Scanner(System.in);
                System.out.println("Vahetuste tegemiseks kirjutage \"vahetused\". (Kui ei soovi vahetusi teha vajuta ENTER)");
                String vahetused = vahetuste_alustus.nextLine();
                if(vahetused.equals("vahetused")) {
                    System.out.println("Vahetus esimesse tiimi: ");
                    System.out.println("Hetkel mängivad: "+tiim1algViisik);
                    System.out.println("Vahetusmängijad on: "+ tiim1VahetusMängijad);
                    Scanner mangija = new Scanner(System.in);
                    System.out.println("Kirjuta mängija indeks keda tahad välja vahetada ja kellega asendada ja tema indeks, eralda komaga. NT: (2,2,0,1)");
                    System.out.println("Kui siia tiimi ei soovi vahetust teha vajuta ENTER.");
                    String mangijad = mangija.nextLine();
                    String[] jupid = mangijad.split(",");
                    if(mangijad.equals("")) {
                        System.out.println("Vahetusi esimesse tiimi ei tehtud! ");
                    }
                    else{
                        for (int j = 0; j < jupid.length; j = j + 2) {
                            tiim1VahetusMängijad.add(tiim1algViisik.get(Integer.parseInt(jupid[j])));
                            tiim1algViisik.set(Integer.parseInt(jupid[j]), tiim1VahetusMängijad.get(Integer.parseInt(jupid[j + 1])));
                            tiim1VahetusMängijad.remove(Integer.parseInt(jupid[j + 1]));
                            System.out.println("Vahetus on tehtud!");
                        }
                    }
                    System.out.println("Vahetus teise tiimi: ");
                    System.out.println("Hetkel mängivad: "+tiim2algViisik);
                    System.out.println("Vahetusmängijad on: "+ tiim2VahetusMängijad);
                    Scanner mangija2 = new Scanner(System.in);
                    System.out.println("Kirjuta mängija indeks keda tahad välja vahetada ja kellega asendada ja tema indeks, eralda komaga. NT: (2,2,0,1)");
                    System.out.println("Kui siia tiimi ei soovi vahetust teha vajuta ENTER.");
                    String mangijad2 = mangija2.nextLine();
                    String[] jupid2 = mangijad2.split(",");
                    if(mangijad2.equals("")) {
                        System.out.println("Vahetusi teise tiimi ei tehtud! ");
                    }
                    else {
                        for (int h = 0; h < jupid2.length; h = h + 2) {
                            tiim2VahetusMängijad.add(tiim2algViisik.get(Integer.parseInt(jupid2[h])));
                            tiim2algViisik.set(Integer.parseInt(jupid2[h]), tiim2VahetusMängijad.get(Integer.parseInt(jupid2[h + 1])));
                            tiim2VahetusMängijad.remove(Integer.parseInt(jupid2[h]));
                            System.out.println("Vahetus on tehtud!");
                        }
                    }

                }
                Scanner Jätka = new Scanner(System.in);
                System.out.println("Jätkamiseks vajuta ENTER");
                String jätkamine = Jätka.nextLine();
                System.out.println("Järgmine veerandaeg!");
                TimeUnit.SECONDS.sleep(2);
            }*/



            //for tsükkel esimese tiimi viske sooritamiseks

            for (int j = 0; j < tiim1MängijadViskeProtsendiga.size(); j++) {
                //ketran for-i senikaua, kuniks leiab sobiva mängija
                if (tiim1MängijadViskeProtsendiga.get(j).contains(valitudViskaja1)) {
                    List<String> mängija = tiim1MängijadViskeProtsendiga.get(j);
                    if (viskaja1ViskeKaugus == 1) {
                        if (viskaja1Tabavus < Integer.parseInt(mängija.get(viskaja1ViskeKaugus))) {
                            tiim1Skoor += 3;

                            mängulaused.add(valitudViskaja1 + " viskas kolmest. Vise tabab! Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                            if (parimad1.containsKey(valitudViskaja1)) {
                                parimad1.put(valitudViskaja1, parimad1.get(valitudViskaja1)+3);
                            }
                            else {
                                parimad1.put(valitudViskaja1, 3);
                            }
                        } else {

                            mängulaused.add(valitudViskaja1 + " viskas kolmest. Vise ei taba... Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                        }
                    } else if (viskaja1ViskeKaugus == 2) {
                        if (viskaja1Tabavus < Integer.parseInt(mängija.get(viskaja1ViskeKaugus))) {
                            tiim1Skoor += 2;

                            mängulaused.add(valitudViskaja1 + " viskas kahest. Vise tabab! Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);


                            if (parimad1.containsKey(valitudViskaja1)) {
                                parimad1.put(valitudViskaja1, parimad1.get(valitudViskaja1)+2);
                            }
                            else {
                                parimad1.put(valitudViskaja1, 2);
                            }
                        } else {

                            mängulaused.add(valitudViskaja1 + " viskas kahest. Vise ei taba... Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                        }
                    }

                    break;
                }
            }

            //for tsükkel teise tiimi viske sooritamiseks
            for (int k = 0; k < tiim2MängijadViskeProtsendiga.size(); k++) {
                //ketran for-i senikaua, kuniks leiab sobiva mängija
                if (tiim2MängijadViskeProtsendiga.get(k).contains(valitudViskaja2)) {
                    List<String> mängija = tiim2MängijadViskeProtsendiga.get(k);
                    if (viskaja2ViskeKaugus == 1) {
                        if (viskaja2Tabavus < Integer.parseInt(mängija.get(viskaja2ViskeKaugus))) {
                            tiim2Skoor += 3;

                            mängulaused.add(valitudViskaja2 + " viskas kolmest. Vise tabab! Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                            if (parimad2.containsKey(valitudViskaja2)) {
                                parimad2.put(valitudViskaja2, parimad2.get(valitudViskaja2)+3);
                            }
                            else {
                                parimad2.put(valitudViskaja2, 3);
                            }
                        } else {

                            mängulaused.add(valitudViskaja2 + " viskas kolmest. Vise ei taba... Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                        }
                    } else if (viskaja2ViskeKaugus == 2) {
                        if (viskaja2Tabavus < Integer.parseInt(mängija.get(viskaja2ViskeKaugus))) {
                            tiim2Skoor += 2;

                            mängulaused.add(valitudViskaja2 + " viskas kahest. Vise tabab! Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                            if (parimad2.containsKey(valitudViskaja2)) {
                                parimad2.put(valitudViskaja2, parimad2.get(valitudViskaja2)+2);
                            }
                            else {
                                parimad2.put(valitudViskaja2, 2);
                            }
                        } else {

                            mängulaused.add(valitudViskaja2 + " viskas kahest. Vise ei taba... Skoor: " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);

                        }
                    }
                    break;
                }
            }
        }
        if (tiim1Skoor > tiim2Skoor) {
            mängulaused.add("Mängu parim mängija oli: " + parimad1.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey() + ", ");
            mängulaused.add(parimad1.get(parimad1.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey()) + " punktiga.");
        }
        else {
            mängulaused.add("Mängu parim mängija oli: " + parimad2.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey() + ", ");
            mängulaused.add(parimad2.get(parimad2.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey()) + " punktiga.");
        }

        mängulaused.add("Mäng läbi! Lõppseis:  " + tiim1 + " " + tiim1Skoor + ":" + tiim2Skoor + " " + tiim2);
        Stage lava = new Stage();
        VBox halal = new VBox();
        TextArea abacus = new TextArea();
        halal.getChildren().add(abacus);
        Scene stseen = new Scene(halal,500,200);

        abacus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Logifail.txt"));

                    for (int i = 0; i < mängulaused.size(); i++) {
                        abacus.setText(abacus.getText()+"\n" + mängulaused.get(i));
                        writer.write(mängulaused.get(i)+"\n");
                    }
                    writer.close();
                }
                catch (IOException e){
                    System.out.println(e);
                }
            }
        });


        lava.setScene(stseen);
        lava.show();

    }
}
