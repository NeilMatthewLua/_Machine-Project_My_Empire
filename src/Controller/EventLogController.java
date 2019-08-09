package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Collections;


public class EventLogController {

    @FXML
    private ListView<String> eventList;

    public void initialize(ArrayList<String> events){


        for(int i = 0; i < events.size(); i++){
            eventList.getItems().add(events.get(i));
        }

        eventList.scrollTo(eventList.getItems().size() - 1);

    }
}
