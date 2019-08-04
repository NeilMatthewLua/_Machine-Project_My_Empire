package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;


public class EventLog {

    @FXML
    private ListView eventList;

    public void initialize(ArrayList<String> events){

        for(int i = 0; i < events.size(); i++){
            eventList.getItems().add(events.get(i));
        }

        eventList.scrollTo(eventList.getItems().size() - 1);

    }
}