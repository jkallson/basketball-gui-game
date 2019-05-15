package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;


public class MänguAbi extends Application {
    public String tiim1Vise;
    public String tiim2Vise;


    public void setTiim1Vise(String tiim1Vise) {
        this.tiim1Vise = tiim1Vise;
    }

    public void setTiim2Vise(String tiim2Vise) {
        this.tiim2Vise = tiim2Vise;
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    ArrayList<String> Eelis_List = new ArrayList<>(1);
    ArrayList<String> Tiimide_nimed = new ArrayList<>(2);
    ArrayList<String> Tiimide_mangijad = new ArrayList<>(2);
    ArrayList<String> tiim1valitudMängijad = new ArrayList<>();
    ArrayList<String> tiim2valitudMängijad = new ArrayList<>();
    ArrayList<String> tiim1Mängijad;
    ArrayList<String> tiim2Mängijad;
    ArrayList<String> tiim1AlgViisikList;
    ArrayList<String> tiim2AlgViisikList;
    ArrayList<String> tiim1VahetusMängijad;
    ArrayList<String> tiim2VahetusMängijad;
    ArrayList<List> tiim1MängijadViskeProtsendiga;
    ArrayList<List> tiim2MängijadViskeProtsendiga;


    @Override
    public void start(Stage peaLava) throws InterruptedException {
        Tiimide_nimed.add("Lakers.txt");
        Tiimide_nimed.add("Bulls.txt");
        Tiimide_mangijad.add("0,1,2,3,4");
        Tiimide_mangijad.add("0,1,2,3,4");
        Eelis_List.add("0,0");

        Image image = new Image("file:lebron.jpg");
        ImageView pilt = new ImageView(image);


        Group juur = new Group();
        Scene stseen1 = new Scene(juur, 500, 500, Color.SNOW);

        TextArea textArea = new TextArea("Tere tulemast mängu NBA BB simulator! \n"+ "Antud mängus saate valida 4 tiimi vahel: " +
                "Lakers, Maverics,Thunder ning Bulls.\n Head mängu!!");
        textArea.setLayoutX(0);
        textArea.setLayoutY(0);
        textArea.setMaxSize(500,100);

        Button tiimid = new Button();
        tiimid.setText("Tiimide valik");
        tiimid.setLayoutY(100);
        tiimid.setLayoutX(200);

        Button mangijad = new Button();
        mangijad.setText("Mängijate valik");
        mangijad.setPrefSize(100,20);
        mangijad.setLayoutX(190);
        mangijad.setLayoutY(130);

        Button sulgemine = new Button();
        sulgemine.setText("Sulgemine");
        sulgemine.setPrefSize(100,20);
        sulgemine.setLayoutX(190);
        sulgemine.setLayoutY(400);

        Button eelis = new Button();
        eelis.setText("Väljaku eelis");
        eelis.setLayoutX(200);
        eelis.setLayoutY(160);

        Button Start = new Button();
        Start.setStyle("-fx-font-size:40");
        Start.setText("Mängima!");
        Start.setLayoutY(200);
        Start.setLayoutX(120);

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

                Button sulge = new Button();
                sulge.setText("Sulge aken");

                sulge.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        kast.hide();
                    }
                });


                kastV.getChildren().addAll(Esimene_sisestus,Teine_sisestus,sulge);
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
                Scene dialogScene = new Scene(kastV, 1000, 300);
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

                Button sulge = new Button();
                sulge.setText("Sulge aken");

                sulge.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        kast.hide();
                    }
                });


                kastV.getChildren().addAll(Esimesed_mangijad,Teised_mangijad,sulge);
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

                Button sulge = new Button();
                sulge.setText("Sulge aken");

                sulge.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        kast.hide();
                    }
                });

                kastV.getChildren().addAll(eelis,sulge);
                kast.setTitle("Mängijate valik");
                kast.setScene(dialogScene);
                kast.show();
            }
        });


        Start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    String[] jupid = Eelis_List.get(0).split(",");
                    if(NimedeKontroll(Tiimide_nimed.get(0)) && NimedeKontroll(Tiimide_nimed.get(1)) && ArvudeKontroll(Tiimide_mangijad.get(0)) && ArvudeKontroll(Tiimide_mangijad.get(1)) && EeliseKontroll(jupid[0]) && EeliseKontroll(jupid[1])) {
                        Stage asd = new Stage();
                        VBox sisu = new VBox(20);


                        failiSisseLugeja tiimid = new failiSisseLugeja(Tiimide_nimed.get(0), Tiimide_nimed.get(1));
                        tiimid.tiimiListid(Tiimide_nimed.get(0), Tiimide_nimed.get(1));
                        tiim1Mängijad = tiimid.getTiim1MängijateList();
                        tiim2Mängijad = tiimid.getTiim2MängijateList();
                        algViisikuValimine algViisik = new algViisikuValimine(tiim1Mängijad, tiim2Mängijad, Tiimide_mangijad.get(0), Tiimide_mangijad.get(1));

                        algViisik.tiim1Starters();
                        algViisik.tiim2Starters();

                        tiim1AlgViisikList = algViisik.getTiim1algViisik();
                        tiim1VahetusMängijad = algViisik.getTiim1VahetusMängijad();

                        tiim2AlgViisikList = algViisik.getTiim2algViisik();
                        tiim2VahetusMängijad = algViisik.getTiim2VahetusMängijad();

                        tiim1MängijadViskeProtsendiga = tiimid.getTiim1List();
                        tiim2MängijadViskeProtsendiga = tiimid.getTiim2List();
                        try {
                            mäng();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Viga sisendis!");
                        alert.setHeaderText("Viga sisendis!");
                        alert.setContentText("Sisesta kõik uuesti korrektselt ning proovi uuesti! ");
                        alert.showAndWait();
                    }

            }
        });
        sulgemine.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                ButtonType jah = new ButtonType("Jah",ButtonBar.ButtonData.YES);
                ButtonType ei = new ButtonType("Ei",ButtonBar.ButtonData.NO);
                Alert küsimus = new Alert(Alert.AlertType.CONFIRMATION,"Kas tõesti soovite lahkuda?" , jah, ei);
                küsimus.setTitle("Sulgemine");
                küsimus.setHeaderText("Kinnitus");


                Optional<ButtonType> tulemus = küsimus.showAndWait();
                if(tulemus.orElse(ei)==jah){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Sulgemine");
                    a.setHeaderText("Aitäh, et mängisite meie loodud mängu!");
                    a.show();
                    peaLava.hide();
                }
                else if(tulemus.orElse(jah)==ei){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Sulgemine");
                    a.setHeaderText("Juhhei!!!!!!!!");
                    a.show();
                }
            }
        });

        juur.getChildren().addAll(pilt, tiimid, sulgemine, mangijad, eelis, Start, textArea);


        peaLava.setTitle("NBA BB simulator");
        peaLava.setScene(stseen1);
        peaLava.show();

    }
    public void mäng() throws InterruptedException {
        Mäng liveMäng = new Mäng(tiim1Mängijad,tiim1AlgViisikList,tiim1VahetusMängijad,tiim1MängijadViskeProtsendiga,tiim2Mängijad,tiim2AlgViisikList,tiim2VahetusMängijad,tiim2MängijadViskeProtsendiga,Tiimide_nimed.get(0).replace(".txt",""),Tiimide_nimed.get(1).replace(".txt",""),0,0);
        liveMäng.liveMäng();
    }

    public void kuvamine(Stage kuvamine){
        kuvamine.setTitle("Mäng");
        kuvamine.show();
    }

    public boolean NimedeKontroll(String abc){
        boolean abacus = false;
        List<String> tiimid = Arrays.asList("Lakers.txt","Bulls.txt","Thunder.txt","Mavericks.txt");
        for (int i = 0; i <tiimid.size() ; i++) {
            if(abc.equals(tiimid.get(i))){
                abacus = true;
            }
        }
        return abacus;
    }

    public boolean ArvudeKontroll(String abacus){
        boolean abi = true;
        String[] jupid = abacus.split(",");
        for (int i = 0; i <jupid.length ; i++) {
            int vemps = Integer.parseInt(jupid[i]);
            if(vemps > 9 || vemps < 0){
                abi = false;
            }
        }
        return abi;
    }

    public boolean EeliseKontroll(String abacus){
        boolean abi = true;
        String[] jupid = abacus.split(",");
        for (int i = 0; i <jupid.length ; i++) {
            int vemps = Integer.parseInt(jupid[i]);
            if(vemps > 10 || vemps < 0){
                abi = false;
            }
        }
        return abi;
    }
}
