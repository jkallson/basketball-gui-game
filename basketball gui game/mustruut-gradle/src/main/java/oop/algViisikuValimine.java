package oop;

import java.util.ArrayList;

public class algViisikuValimine {
    //listid, kuhu lisan tiim1 algviisiku ja vahetusmängijad
    private ArrayList<String> tiim1Mängijad = new ArrayList<>();
    private ArrayList<String> tiim1algViisik = new ArrayList<>();
    private ArrayList<String> tiim1VahetusMängijad = new ArrayList<>();

    //listid, kuhu lisan tiim2 algviisiku ja vahetusmängijad
    private ArrayList<String> tiim2Mängijad = new ArrayList<>();
    private ArrayList<String> tiim2algViisik = new ArrayList<>();
    private ArrayList<String> tiim2VahetusMängijad = new ArrayList<>();

    //algviisiku mängijate indeksid
    private String tiim1Indeksid;
    private String tiim2Indeksid;

    public ArrayList<String> getTiim1algViisik() {
        return tiim1algViisik;
    }

    public ArrayList<String> getTiim1VahetusMängijad() {
        return tiim1VahetusMängijad;
    }

    public ArrayList<String> getTiim2algViisik() {
        return tiim2algViisik;
    }

    public ArrayList<String> getTiim2VahetusMängijad() {
        return tiim2VahetusMängijad;
    }

    //konstruktor algviisiku loomiseks
    public algViisikuValimine(ArrayList<String> tiim1Mängijad, ArrayList<String> tiim2Mängijad,String tiim1Indeksid,String tiim2Indeksid) {
        this.tiim1Mängijad = tiim1Mängijad;
        this.tiim2Mängijad = tiim2Mängijad;
        this.tiim1Indeksid = tiim1Indeksid;
        this.tiim2Indeksid = tiim2Indeksid;
    }
    //funktsioon, kus määran ära tiim1 algrivistuse ning pingipoisid
    public void tiim1Starters(){
        String[] tiim1SoovitudMängijad = tiim1Indeksid.split(",");
        for (int i = 0; i < tiim1Mängijad.size(); i++) {
            if(i<tiim1SoovitudMängijad.length){
                String mängija = tiim1Mängijad.get(Integer.parseInt(tiim1SoovitudMängijad[i]));
                tiim1algViisik.add(mängija);
            }

            if(!tiim1Indeksid.contains(Integer.toString(i))){
                String vahetusMängija = tiim1Mängijad.get(i);
                tiim1VahetusMängijad.add(vahetusMängija);
            }
        }
    }
    //funktsioon, kus määran ära tiim2 algrivistuse ning pingipoisid
    public void tiim2Starters(){
        String[] tiim2SoovitudMängijad = tiim2Indeksid.split(",");
        for (int i = 0; i < tiim2Mängijad.size(); i++) {
            if(i<tiim2SoovitudMängijad.length){
                String mängija = tiim2Mängijad.get(Integer.parseInt(tiim2SoovitudMängijad[i]));
                tiim2algViisik.add(mängija);
            }

            if(!tiim2Indeksid.contains(Integer.toString(i))){
                String vahetusMängija = tiim2Mängijad.get(i);
                tiim2VahetusMängijad.add(vahetusMängija);
            }
        }

    }
}
