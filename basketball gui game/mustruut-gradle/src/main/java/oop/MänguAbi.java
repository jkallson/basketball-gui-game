package oop;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
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
