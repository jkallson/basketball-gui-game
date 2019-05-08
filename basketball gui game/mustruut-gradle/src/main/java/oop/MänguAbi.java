package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MänguAbi extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage peaLava) throws Exception {
        ArrayList<String> Eelis_List = new ArrayList<>(1);
        ArrayList<String> Tiimide_nimed = new ArrayList<>(2);
        ArrayList<String> Tiimide_mangijad = new ArrayList<>(2);
        Tiimide_nimed.add("Lakers.txt");
        Tiimide_nimed.add("Bulls.txt");
        Tiimide_mangijad.add("0,1,2,3,4");
        Tiimide_mangijad.add("0,1,2,3,4");
        Eelis_List.add("0,0");


        Group juur = new Group();
        Scene stseen1 = new Scene(juur, 500, 500, Color.SNOW);

        Button tiimid = new Button();
        tiimid.setText("Tiimide valik");
        tiimid.setLayoutY(0);
        tiimid.setLayoutX(0);

        Button mangijad = new Button();
        mangijad.setText("Mängijate valik");
        mangijad.setLayoutX(0);
        mangijad.setLayoutY(30);

        Button eelis = new Button();
        eelis.setText("Väljaku eelis");
        eelis.setLayoutY(60);

        Button Start = new Button();
        Start.setStyle("-fx-font-size:40");
        Start.setText("Mängima!");
        Start.setLayoutY(250);
        Start.setLayoutX(50);

        tiimid.setOnMouseClicked(new EventHandler<MouseEvent>()  {

            @Override
            public void handle(MouseEvent event){
                Stage kast = new Stage();
                VBox kastV = new VBox(20);
                kastV.getChildren().add(new Text(" Tiimid valikus: Lakers,Bulls,Mavericks,Thunder. Default Lakers vs Bulls\n Kustuta, kirjuta tiim, vajuta ENTER. \n Kustuta, kirjuta teine tiim vajuta ENTER"));
                Scene dialogScene = new Scene(kastV, 500, 200);
                TextField Esimene_sisestus = new TextField();
                Esimene_sisestus.setText("Esimene tiim");
                Esimene_sisestus.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {

                        if (event.getCode() == KeyCode.ENTER) {
                            Tiimide_nimed.set(0,Esimene_sisestus.getText()+".txt");
                            Esimene_sisestus.setText("Esimene tiim valitud");
                        }
                    }
                });

                TextField Teine_sisestus = new TextField();
                Teine_sisestus.setText("Teine tiim");
                Teine_sisestus.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {

                        if (event.getCode() == KeyCode.ENTER) {
                            Tiimide_nimed.set(1,Teine_sisestus.getText()+".txt");
                            Teine_sisestus.setText("Teine tiim valitud");
                        }
                    }
                });



                kastV.getChildren().addAll(Esimene_sisestus,Teine_sisestus);
                kast.setTitle("Tiimide valik");
                kast.setScene(dialogScene);
                kast.show();
            }

        });

        mangijad.setOnMouseClicked(new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent event) {

                failiSisseLugeja Meeskonnad = new failiSisseLugeja(Tiimide_nimed.get(0), Tiimide_nimed.get(1));
                Meeskonnad.tiimiListid(Tiimide_nimed.get(0), Tiimide_nimed.get(1));
                ArrayList<String> tiim1Mängijad = Meeskonnad.getTiim1MängijateList();
                ArrayList<String> tiim2Mängijad = Meeskonnad.getTiim2MängijateList();

                Stage kast = new Stage();
                VBox kastV = new VBox(20);
                kastV.getChildren().add(new Text(" Vali mängijad, kirjuta kasti nende indeks nt: 0,1,2,3,4. Default Lakers vs Bulls"));
                Scene dialogScene = new Scene(kastV, 1000, 200);
                kastV.getChildren().add(new Text(" Esimese tiimi mängijad: "+tiim1Mängijad));
                TextField Esimesed_mangijad = new TextField();
                Esimesed_mangijad.setText("Sisesta esimese tiimi mängijad");
                Esimesed_mangijad.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            Tiimide_mangijad.set(0,Esimesed_mangijad.getText());
                            Esimesed_mangijad.setText("Esimene tiim valitud");
                        }
                    }
                });

                kastV.getChildren().add(new Text(" Teise tiimi mängijad: "+tiim2Mängijad));
                TextField Teised_mangijad = new TextField();
                Teised_mangijad.setText("Sisesta teise tiimi mängijad");
                Teised_mangijad.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            Tiimide_mangijad.set(1,Teised_mangijad.getText());
                            Teised_mangijad.setText("Teine tiim valitud");
                        }
                    }
                });

                kastV.getChildren().addAll(Esimesed_mangijad,Teised_mangijad);
                kast.setTitle("Mängijate valik");
                kast.setScene(dialogScene);
                kast.show();
            }
        });

        eelis.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage kast = new Stage();
                VBox kastV = new VBox(20);
                kastV.getChildren().add(new Text(" Vali koduväljaku eelis protsentides, nt: 5,0 "));
                Scene dialogScene = new Scene(kastV, 500, 200);
                TextField eelis = new TextField();
                eelis.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER) {
                            Eelis_List.set(0,eelis.getText());
                            eelis.setText("Eelis valitud.");
                        }
                    }
                });
                kastV.getChildren().addAll(eelis);
                kast.setTitle("Mängijate valik");
                kast.setScene(dialogScene);
                kast.show();
            }
        });


        juur.getChildren().addAll(tiimid,mangijad,eelis,Start);


        peaLava.setTitle("NBA BB simulator");
        peaLava.setScene(stseen1);
        peaLava.show();


        /*System.out.println("Tere tulemast projekti bb simulator. Tiimid valikus: Lakers,Bulls,Mavericks,Thunder.");
        //küsin kasutajalt soovitud tiimide nimed
        Scanner scan = new Scanner(System.in);
        System.out.println("Sisesta esimese tiimi nimi: ");
        String tiim1 = scan.nextLine()+".txt";
        System.out.println("Sisesta teise tiimi nimi: ");
        String tiim2 = scan.nextLine()+".txt";
        //loon listid soovitud tiimidest
        failiSisseLugeja tiimid = new failiSisseLugeja(tiim1,tiim2);
        tiimid.tiimiListid(tiim1,tiim2);

        ArrayList<String> tiim1Mängijad = tiimid.getTiim1MängijateList();
        ArrayList<String> tiim2Mängijad = tiimid.getTiim2MängijateList();

        System.out.println("Esimese tiimi mängijad on: "+tiim1Mängijad);
        System.out.println("Teise tiimi mängijad on: "+tiim2Mängijad);

        //küsin kasutajalt soovitud algviisikuid
        System.out.println("Sisesta esimese tiimi algviisik(index ja koma vahele nt: 0,2): ");
        String tiim1AlgViisik = scan.nextLine();
        System.out.println("Sisesta teise tiimi algviisik(index ja koma vahele nt: 0,2): ");
        String tiim2AlgViisik = scan.nextLine();

        algViisikuValimine algViisik = new algViisikuValimine(tiim1Mängijad,tiim2Mängijad,tiim1AlgViisik,tiim2AlgViisik);
        //antud meetodite abil määran algviisiku ja vahetusmängijad
        algViisik.tiim1Starters();
        algViisik.tiim2Starters();
        //loon listid, kus hoian tiim1 algviisikut ja vahetusmängijaid
        ArrayList<String> tiim1AlgViisikList = algViisik.getTiim1algViisik();
        ArrayList<String> tiim1VahetusMängijad = algViisik.getTiim1VahetusMängijad();
        //loon listid, kus hoian tiim2 algviisikut ja vahetusmängijaid
        ArrayList<String> tiim2AlgViisikList = algViisik.getTiim2algViisik();
        ArrayList<String> tiim2VahetusMängijad = algViisik.getTiim2VahetusMängijad();
        //loon listid, kus hoian tiim1 ja tiim2 kõiki mängijaid koos viseteprotsendiga
        ArrayList<List> tiim1MängijadViskeProtsendiga = tiimid.getTiim1List();
        ArrayList<List> tiim2MängijadViskeProtsendiga = tiimid.getTiim2List();

        Scanner eelis = new Scanner(System.in);
        System.out.println("Soovil sisesta koduväljaku boonus 10% piires. NT: (5,0)");
        String eelised = eelis.nextLine();
        String[] jupatsid = eelised.split(",");

        int tiim1Eelis = 0;
        int tiim2Eelis = 0;

        if(Integer.parseInt(jupatsid[0]) <= 10){
            tiim1Eelis = Integer.parseInt(jupatsid[0]);
        }

        if(Integer.parseInt(jupatsid[1]) <= 10){
            tiim2Eelis = Integer.parseInt(jupatsid[1]);
        }


        System.out.println("Esimese tiimi algviisik on "+tiim1AlgViisikList);
        System.out.println("Esimese tiimi vahetusmängijad on "+tiim1VahetusMängijad);

        System.out.println("Teise tiimi algviisik on "+tiim2AlgViisikList);
        System.out.println("Teise tiimi vahetusmängijad on "+tiim2VahetusMängijad);
        System.out.println("Head mängu!!!!!!!!!!!!");

        //loon mängu
        Mäng mäng = new Mäng(tiim1Mängijad,tiim1AlgViisikList,tiim1VahetusMängijad,tiim1MängijadViskeProtsendiga,tiim2Mängijad,tiim2AlgViisikList,tiim2VahetusMängijad,tiim2MängijadViskeProtsendiga,tiim1.replace(".txt",""),tiim2.replace(".txt",""),tiim1Eelis,tiim2Eelis);
        mäng.liveMäng();

        // tekstivälja loomine ja lisamine piiripaanile (üles)
        */

    }
}
