package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    public ListView trackList;
    public Button playButton;
    public Button nextTrackButton;
    public Button randomButton;
    public TextField trackOutTF;
    public Button showTrackButton;

    ObservableList<String> tracks = FXCollections.observableArrayList("Track 1", "Track 2", "Track 3", "Track 4", "Track 5");

    

    public void playTrack(ActionEvent actionEvent) {

    }

    public void nextTrack(ActionEvent actionEvent) {

    }

    public void nextRandom(ActionEvent actionEvent) {

    }
}
