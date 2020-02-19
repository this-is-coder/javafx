package MusicPlayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.Random;

public class MusicPlayerController {
    public ListView<String> trackListView = new ListView<>();
    public Button playTrackButton;
    public Button nextTrackButton;
    public Button randomTrackButton;
    public TextField trackOutputTF;
    public Button stopTrackButton;

    public int trackIndexCounter = 0;
    public Button addTrackButton;
    public TextField inputTrackTF;

    private ObservableList<String> trackList;


    public void initialize(){

        trackList = FXCollections.observableArrayList();
        trackList.add("Track 1");
        trackList.add("Track 2");
        trackList.add("Track 3");
        trackList.add("Track 4");
        trackList.add("Track 5");
        trackList.add("Track 6");
        trackList.add("Track 7");
        trackList.add("Track 8");

        trackListView.setItems(trackList);
    }

    public boolean playTrack(ActionEvent actionEvent) {
        int trackIndex = trackListView.getSelectionModel().getSelectedIndex();
        if (trackIndex == -1){
            return false;
        }
        String selectedTrack = trackListView.getSelectionModel().getSelectedItem();
        trackOutputTF.setText(selectedTrack + " is playing");
        return true;
    }

    public void stopTrack(ActionEvent actionEvent) {
        trackOutputTF.setText("No track is playing");
    }

    public boolean nextTrack(ActionEvent actionEvent) {
        if (trackListView.getSelectionModel().getSelectedIndex() == -1){
            trackOutputTF.setText("Select a track to play");
            return false;
        }
        if (trackIndexCounter == 0){
            int nextTrackIndex = trackListView.getSelectionModel().getSelectedIndex() + 1;
            trackIndexCounter = nextTrackIndex;
            String nextTrack = trackList.get(nextTrackIndex);
            trackOutputTF.setText(nextTrack + " is playing");
            return true;
        }
        else{
            trackIndexCounter++;
            int nextTrackIndex = trackIndexCounter;
            String nextTrack = trackList.get(nextTrackIndex);
            trackOutputTF.setText(nextTrack + " is playing");
            return true;
        }

    }

    public boolean randomTrack(ActionEvent actionEvent) {
        Random randomNum = new Random();
        int trackIndex = randomNum.nextInt(trackList.size() -1);
        String selectedTrack = trackList.get(trackIndex);
        trackOutputTF.setText(selectedTrack + " is playing");
        return true;
    }

    public boolean addTrack(ActionEvent actionEvent) {
        String newTrackName = inputTrackTF.getText();
        if (newTrackName.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.NONE, "Input a new Track name", ButtonType.OK);
            alert.setTitle("Input Error");
            alert.setHeaderText("No Track Inputted");
            alert.showAndWait();
            return false;
        }
        trackList.add(newTrackName);
        inputTrackTF.setText("");
        return true;
    }
}
