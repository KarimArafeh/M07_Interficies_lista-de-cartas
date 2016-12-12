package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{



    public ListView lv_cartas;
    ArrayList<Card> cards;
    ArrayList<String> cartasNoms = new ArrayList<>();
    /*
    public ObservableList<String> items = FXCollections.observableArrayList (
            "Single", "Double", "Suite", "Family App");
   */

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        CardAPI api = new CardAPI();
        try {
            cards = api.getAllCards();
        } catch (IOException e) {
            e.printStackTrace();
        }
/*

        for(int i = 0; i<=cards.size(); i++)
        {
            if(cards!=null)
            {

            }
        }
        */


        for (Card carta: cards) {
            cartasNoms.add(carta.getName());
        }
        ObservableList lista= FXCollections.observableArrayList(cartasNoms);
        lv_cartas.setItems(lista);


    }
}
