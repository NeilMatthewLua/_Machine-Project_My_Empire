package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LandInitController implements Initializable {

    @FXML private AnchorPane background;

    @FXML private Label Almond;
    @FXML private Label Kasoy;
    @FXML private Label Rodeo;
    @FXML private Label Orange;
    @FXML private Label Ventura;
    @FXML private Label Juan;
    @FXML private Label Ylaya;
    @FXML private Label Abad;
    @FXML private Label Madison;
    @FXML private Label Annapolis;
    @FXML private Label Connecticut;
    @FXML private Label Bougainvilla;
    @FXML private Label Dama;
    @FXML private Label Acacia;
    @FXML private Label Solar;
    @FXML private Label Galaxy;
    @FXML private Label Ninth;
    @FXML private Label Fifth;

    @FXML private Label North;
    @FXML private Label South;
    @FXML private Label Metro;

    @FXML private Label Water;
    @FXML private Label Electric;

    @FXML private Label Chance1;
    @FXML private Label Chance2;
    @FXML private Label Chance3;

    @FXML private Label Luxury;
    @FXML private Label Income;

    @FXML private Label empty1;
    @FXML private Label empty2;
    @FXML private Label empty3;
    @FXML private Label empty4;
    @FXML private Label empty5;
    @FXML private Label empty6;
    @FXML private Label empty7;
    @FXML private Label empty8;
    @FXML private Label empty9;
    @FXML private Label empty10;
    @FXML private Label empty11;
    @FXML private Label empty12;
    @FXML private Label empty13;
    @FXML private Label empty14;
    @FXML private Label empty15;
    @FXML private Label empty16;
    @FXML private Label empty17;
    @FXML private Label empty18;
    @FXML private Label empty19;
    @FXML private Label empty20;
    @FXML private Label empty21;
    @FXML private Label empty22;
    @FXML private Label empty23;
    @FXML private Label empty24;
    @FXML private Label empty25;
    @FXML private Label empty26;
    @FXML private Label empty27;
    @FXML private Label empty28;

    @FXML private Label delete1;
    @FXML private Label delete2;
    @FXML private Label delete3;
    @FXML private Label delete4;
    @FXML private Label delete5;
    @FXML private Label delete6;
    @FXML private Label delete7;
    @FXML private Label delete8;
    @FXML private Label delete9;
    @FXML private Label delete10;
    @FXML private Label delete11;
    @FXML private Label delete12;
    @FXML private Label delete13;
    @FXML private Label delete14;
    @FXML private Label delete15;
    @FXML private Label delete16;
    @FXML private Label delete17;
    @FXML private Label delete18;
    @FXML private Label delete19;
    @FXML private Label delete20;
    @FXML private Label delete21;
    @FXML private Label delete22;
    @FXML private Label delete23;
    @FXML private Label delete24;
    @FXML private Label delete25;
    @FXML private Label delete26;
    @FXML private Label delete27;
    @FXML private Label delete28;

    @FXML private Label currentSelected;
    @FXML private Label Play;
    @FXML private Label ClearAll;
    @FXML private ImageView Zoomed;
    @FXML private Label closeZoomed;
    @FXML private Label ownerZoom;
    @FXML private Label footTrafficZoom;
    @FXML private Label playersZoom;

    @FXML private AnchorPane anchor1;
    @FXML private AnchorPane anchor2;
    @FXML private AnchorPane anchor3;
    @FXML private AnchorPane anchor4;
    @FXML private AnchorPane anchor5;
    @FXML private AnchorPane anchor6;
    @FXML private AnchorPane anchor7;
    @FXML private AnchorPane anchor8;
    @FXML private AnchorPane anchor9;
    @FXML private AnchorPane anchor10;
    @FXML private AnchorPane anchor11;
    @FXML private AnchorPane anchor12;
    @FXML private AnchorPane anchor13;
    @FXML private AnchorPane anchor14;
    @FXML private AnchorPane anchor15;
    @FXML private AnchorPane anchor16;
    @FXML private AnchorPane anchor17;
    @FXML private AnchorPane anchor18;
    @FXML private AnchorPane anchor19;
    @FXML private AnchorPane anchor20;
    @FXML private AnchorPane anchor21;
    @FXML private AnchorPane anchor22;
    @FXML private AnchorPane anchor23;
    @FXML private AnchorPane anchor24;
    @FXML private AnchorPane anchor25;
    @FXML private AnchorPane anchor26;
    @FXML private AnchorPane anchor27;
    @FXML private AnchorPane anchor28;

    private GameBoard gameBoard;
    private ArrayList<Label> emptySpaces;
    private ArrayList<Label> possibleSpaces;
    private ArrayList<AnchorPane> panes;
    private ArrayList<Label> deleteLabels;

    private String[][] urls = {
            {"Almond Drive","../Images/SmallSpaces/Silver.png","../Images/BigSpaces/Almond.png"},
            {"Kasoy Street","../Images/SmallSpaces/Silver.png","../Images/BigSpaces/Kasoy.png"},
            {"Rodeo Drive","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Rodeo.png"},
            {"Orange Street","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Orange.png"},
            {"Ventura Street","../Images/SmallSpaces/Purple.png","../Images/BigSpaces/Ventura.png"},
            {"Juan Luna","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Juan.png"},
            {"Ylaya","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Ylaya.png"},
            {"J. Abad Santos","../Images/SmallSpaces/Pink.png","../Images/BigSpaces/Abad.png"},
            {"Madison","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Madison.png"},
            {"Annapolis","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Annapolis.png"},
            {"Connecticut","../Images/SmallSpaces/Green.png","../Images/BigSpaces/Connecticut.png"},
            {"Bougainvilla","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Bougainvilla.png"},
            {"Dama de Noche","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Dama.png"},
            {"Acacia","../Images/SmallSpaces/Blue.png","../Images/BigSpaces/Acacia.png"},
            {"Solar Street","../Images/SmallSpaces/Red.png","../Images/BigSpaces/Solar.png"},
            {"Galaxy Street","../Images/SmallSpaces/Red.png","../Images/BigSpaces/Galaxy.png"},
            {"9th Street","../Images/SmallSpaces/Yellow.png","../Images/BigSpaces/9th.png"},
            {"5th Avenue","../Images/SmallSpaces/Yellow.png","../Images/BigSpaces/5th.png"},
            {"North","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/North.png"},
            {"South","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/South.png"},
            {"Metro","../Images/SmallSpaces/Railroad.png","../Images/BigSpaces/Metro.png"},
            {"Water","../Images/SmallSpaces/Utility.png","../Images/BigSpaces/Water.png"},
            {"Electric","../Images/SmallSpaces/Utility.png","../Images/BigSpaces/Electric.png"},
            {"Luxury Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Luxury.png"},
            {"Income Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Income.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
    };
    private Label current;

    public void setGameBoard(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public boolean isPlacable(Label label){//Checks if label is placable
        for(int i = 0; i < possibleSpaces.size(); i++){
            if(label == possibleSpaces.get(i))
                return true;
        }
        return false;
    }

    @FXML
    public void hover(MouseEvent e){
        ((Label) e.getSource()).toFront();
    }

    @FXML
    public void hoverOff(MouseEvent e){
        ((Label) e.getSource()).toBack();
    }

    @FXML
    public void hoverPaneIn(MouseEvent e){
        if(!(emptySpaces.get(panes.indexOf(e.getSource())).getText().equalsIgnoreCase("Empty"))){
            System.out.println(emptySpaces.get(panes.indexOf(e.getSource())).getText());
            deleteLabels.get(panes.indexOf(e.getSource())).setVisible(true);
        }
    }

    @FXML
    public void hoverPaneOut(MouseEvent e){
        if(deleteLabels.get(panes.indexOf(e.getSource())).isVisible())
            deleteLabels.get(panes.indexOf(e.getSource())).setVisible(false);
    }

    @FXML
    public void chooseSpace(MouseEvent e) {
        if(e.getButton() == MouseButton.PRIMARY){
            if (isPlacable((Label) e.getSource())) {
                current = (Label) e.getSource();
                currentSelected.setText(possibleSpaces.get(possibleSpaces.indexOf(current)).getText());
            }
        }
        else if(e.getButton() == MouseButton.SECONDARY){
            if(!Zoomed.isVisible()){
                if(!((Label)e.getSource()).getText().equalsIgnoreCase("Empty")){
                    boolean isFound = true;
                    for(int i = 0; i < possibleSpaces.size(); i++){
                        if(((Label)e.getSource()).getText().equalsIgnoreCase(urls[i][0])){
                            Image ig = new Image(getClass().getResourceAsStream(urls[i][2]));
                            Zoomed.setImage(ig);
                        }
                    }
                }
                else{
                    Image ig = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
                    Zoomed.setImage(ig);
                }
                openZoomed(e);
            }
            else{
                closeZoomed(e);
            }
        }
    }

    @FXML
    public void closeZoomed(MouseEvent e){
        if(Zoomed.isVisible()){
            closeZoomed.setVisible(false);
            Zoomed.setVisible(false);
            ownerZoom.setVisible(false);
            footTrafficZoom.setVisible(false);
            playersZoom.setVisible(false);
        }
    }

    @FXML
    public void openZoomed(MouseEvent e){
        if(!Zoomed.isVisible()){
            closeZoomed.setVisible(true);
            Zoomed.setVisible(true);
            boolean isFound = true;
            for(int i = 0; (i < urls.length - 5) && isFound ;i++){
                if(((Label)e.getSource()).getText().equalsIgnoreCase(urls[i][0])){
                    ownerZoom.setVisible(true);
                    isFound = false;
                    if(i <= 17){
                        playersZoom.setVisible(true);
                        playersZoom.setText("" + gameBoard.getPlayers().length);
                        footTrafficZoom.setVisible(true);
                    }
                }
            }
        }
    }

    @FXML
    public void addSpace(MouseEvent e){
        if(e.getButton() == MouseButton.PRIMARY){
            if(!(((Label)e.getSource()).getText().equalsIgnoreCase("Start") || ((Label)e.getSource()).getText().equalsIgnoreCase("Community") ||
                    ((Label)e.getSource()).getText().equalsIgnoreCase("Jail") || ((Label)e.getSource()).getText().equalsIgnoreCase("Free Parking"))){
                if(current != null && (emptySpaces.get(emptySpaces.indexOf((e.getSource()))).getText().equalsIgnoreCase("Empty"))){
                    ((Label) e.getSource()).setVisible(true);
                    possibleSpaces.get(possibleSpaces.indexOf(current)).setVisible(false);

                    //Set the image of space to selected object
                    Image img = new Image(getClass().getResourceAsStream(urls[possibleSpaces.indexOf(current)][1]));
                    emptySpaces.get(emptySpaces.indexOf((e.getSource()))).
                            setGraphic(new ImageView(img));

                    //Rename Space to Object placed
                    emptySpaces.get(emptySpaces.indexOf((e.getSource()))).setText(urls[possibleSpaces.indexOf(current)][0]);
                    current = null;
                    currentSelected.setText("Nothing Selected");
                    System.out.println(emptySpaces);
                }

                ClearAll.setVisible(true);

                boolean isValid = true;
                for(int i = 0; i < emptySpaces.size() && isValid; i++){//Check if there are empty spaces left
                    if(emptySpaces.get(i).getText().equalsIgnoreCase("Empty")){
                        isValid = false;
                    }
                }
                if(isValid){
                    closeZoomed(e);
                    Play.setVisible(true);
                }
            }
        }
        else if(e.getButton() == MouseButton.SECONDARY) {
            if (!(((Label) e.getSource()).getText().equalsIgnoreCase("Start") || ((Label) e.getSource()).getText().equalsIgnoreCase("Community") ||
                    ((Label) e.getSource()).getText().equalsIgnoreCase("Jail") || ((Label) e.getSource()).getText().equalsIgnoreCase("Free Parking"))) {
                if (!Zoomed.isVisible()) {
                    if (!((Label) e.getSource()).getText().equalsIgnoreCase("Empty")) {
                        boolean isFound = true;
                        for (int i = 0; i < possibleSpaces.size(); i++) {
                            if (((Label) e.getSource()).getText().equalsIgnoreCase(urls[i][0])) {
                                Image ig = new Image(getClass().getResourceAsStream(urls[i][2]));
                                Zoomed.setImage(ig);
                            }
                        }
                    } else {
                        Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Empty.png"));
                        Zoomed.setImage(ig);
                    }
                    openZoomed(e);
                } else {
                    closeZoomed(e);
                }
            }
            else{
                if (!Zoomed.isVisible()) {
                    if(((Label) e.getSource()).getText().equalsIgnoreCase("Start")){
                        Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Start.png"));
                        Zoomed.setImage(ig);
                    }
                    else if(((Label) e.getSource()).getText().equalsIgnoreCase("Community")){
                        Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Community.png"));
                        Zoomed.setImage(ig);
                    }
                    else if(((Label) e.getSource()).getText().equalsIgnoreCase("Jail")){
                        Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/Jail.png"));
                        Zoomed.setImage(ig);
                    }
                    else{
                        Image ig = new Image(getClass().getResourceAsStream("../Images/BigSpaces/FreeParking.png"));
                        Zoomed.setImage(ig);
                    }
                    openZoomed(e);
                } else {
                    closeZoomed(e);
                }
            }
        }
    }

    @FXML
    public void deleteSpace(MouseEvent e){
        if(!(emptySpaces.get(deleteLabels.indexOf(e.getSource())).getText().equalsIgnoreCase("Empty"))){
            Image image = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setGraphic(new ImageView(image));
            boolean isFound = true;
            for(int i = 0; i < 28 && isFound; i++){
                if(emptySpaces.get(deleteLabels.indexOf(e.getSource())).getText().equalsIgnoreCase(possibleSpaces.get(i).getText())){
                    if(emptySpaces.get(deleteLabels.indexOf(e.getSource())).getText().equalsIgnoreCase("Chance")){
                        if(possibleSpaces.get(25).isVisible()){
                            if(possibleSpaces.get(26).isVisible() && isFound){
                                possibleSpaces.get(27).setVisible(true);
                                isFound = false;
                            }
                            else{
                                possibleSpaces.get(26).setVisible(true);
                                isFound = false;
                            }
                        }
                        else{
                            possibleSpaces.get(25).setVisible(true);
                            isFound = false;
                        }
                    }
                    else{
                        possibleSpaces.get(i).setVisible(true);
                        isFound = false;
                    }
                }
            }
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setText("Empty");
            boolean isEmptyBoard= true;
            for(int i = 0; i < emptySpaces.size() && isEmptyBoard; i++){//Check if there are empty spaces left
                if(!(emptySpaces.get(i).getText().equalsIgnoreCase("Empty"))){
                    isEmptyBoard = false;
                }
            }
            if(isEmptyBoard){
                ClearAll.setVisible(false);
            }
            Play.setVisible(false);
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setText("Empty");
        }
    }

    @FXML
    public void clearAll(MouseEvent e){
        for(int i = 0; i < emptySpaces.size(); i++){
            if(!(emptySpaces.get(i).getText().equalsIgnoreCase("Empty"))){
                boolean isFound = true;
                for(int j = 0; j < possibleSpaces.size() && isFound;j++){
                    if(emptySpaces.get(i).getText().equalsIgnoreCase(possibleSpaces.get(j).getText())){
                        Image image = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
                        emptySpaces.get(i).setGraphic(new ImageView(image));

                        if(emptySpaces.get(i).getText().equalsIgnoreCase("Chance")){
                            if(possibleSpaces.get(25).isVisible()){
                                if(possibleSpaces.get(26).isVisible()){
                                    possibleSpaces.get(27).setVisible(true);
                                    isFound = false;
                                }
                                else{
                                    possibleSpaces.get(26).setVisible(true);
                                    isFound = false;
                                }
                            }
                            else{
                                possibleSpaces.get(25).setVisible(true);
                                isFound = false;
                            }
                        }
                        else{
                            possibleSpaces.get(j).setVisible(true);
                        }
                        emptySpaces.get(i).setText("Empty");
                    }
                }
            }
        }
        ClearAll.setVisible(false);
        Play.setVisible(false);
        closeZoomed(e);
    }

    @FXML
    public void randomize(MouseEvent e){
        gameBoard.randomizeLand();
        ArrayList<Land> randomizedLand = new ArrayList<Land>(gameBoard.getLand());
        randomizedLand.remove(0);
        randomizedLand.remove(7);
        randomizedLand.remove(14);
        randomizedLand.remove(21);
        for(int i = 0; i < randomizedLand.size();i++) {
            boolean isFound = true;
            for (int j = 0; j < possibleSpaces.size() && isFound; j++)
                if (possibleSpaces.get(j).getText().equalsIgnoreCase(randomizedLand.get(i).getName())) {
                    if (randomizedLand.get(i).getName().equalsIgnoreCase("Chance")) {
                        if (possibleSpaces.get(25).isVisible()) {
                            possibleSpaces.get(25).setVisible(false);
                            isFound = false;
                        } else {
                            if (possibleSpaces.get(26).isVisible() && isFound) {
                                possibleSpaces.get(26).setVisible(false);
                                isFound = false;
                            } else {
                                possibleSpaces.get(27).setVisible(false);
                                isFound = false;
                            }
                        }
                    } else {
                        possibleSpaces.get(j).setVisible(false);
                        isFound = false;
                    }
                    emptySpaces.get(i).setText(possibleSpaces.get(j).getText());
                    Image image = new Image(getClass().getResourceAsStream(urls[j][1]));
                    emptySpaces.get(i).setGraphic(new ImageView(image));
                }
        }

        ClearAll.setVisible(true);
        Play.setVisible(true);

        closeZoomed(e);
    }

    @FXML
    public void play(MouseEvent e){
        ArrayList<Land> unsortedLand = new ArrayList<>(gameBoard.getLand());
        unsortedLand.remove(0);
        unsortedLand.remove(7);
        unsortedLand.remove(14);
        unsortedLand.remove(21);
        ArrayList<Land> finalLand = new ArrayList<>();
        for(int i = 0; i < emptySpaces.size();i++){
            boolean isFound = true;
            for(int j = 0; j < 28 && isFound;j++)
                if(unsortedLand.get(j).getName().equalsIgnoreCase(emptySpaces.get(i).getText())){
                    finalLand.add(unsortedLand.get(j));
                    isFound = false;
                }
        }
        finalLand.add(0,new Start("Start"));
        finalLand.add(8,new Community("Community Service"));
        finalLand.add(16,new Parking("Free Parking"));
        finalLand.add(24,new Jail("Jail"));
        gameBoard.setLand(finalLand);

        for(int i = 0; i < gameBoard.getLand().size();i++){
            System.out.println(i + 1 +" " + gameBoard.getLand().get(i).getName());
        }
        try {
            Stage stage = (Stage) background.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/GamePlay.fxml")); //Insert your FXML here
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            ((GamePlayController) loader.getController()).setGameBoard(gameBoard);
        }
        catch(IOException event){
            System.out.println("Something happened");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameBoard gameBoard = new GameBoard();
        panes = new ArrayList<AnchorPane>();
        panes.add(anchor1);panes.add(anchor2);panes.add(anchor3);panes.add(anchor4);panes.add(anchor5);
        panes.add(anchor6);panes.add(anchor7);panes.add(anchor8);panes.add(anchor9);panes.add(anchor10);
        panes.add(anchor11);panes.add(anchor12);panes.add(anchor13);panes.add(anchor14);panes.add(anchor15);
        panes.add(anchor16);panes.add(anchor17);panes.add(anchor18);panes.add(anchor19);panes.add(anchor20);
        panes.add(anchor21);panes.add(anchor22);panes.add(anchor23);panes.add(anchor24);panes.add(anchor25);
        panes.add(anchor26);panes.add(anchor27);panes.add(anchor28);

        possibleSpaces = new ArrayList<Label>();
        possibleSpaces.add(Almond);possibleSpaces.add(Kasoy);possibleSpaces.add(Rodeo);
        possibleSpaces.add(Orange);possibleSpaces.add(Ventura);possibleSpaces.add(Juan);
        possibleSpaces.add(Ylaya);possibleSpaces.add(Abad);possibleSpaces.add(Madison);
        possibleSpaces.add(Annapolis);possibleSpaces.add(Connecticut);
        possibleSpaces.add(Bougainvilla);possibleSpaces.add(Dama);possibleSpaces.add(Acacia);
        possibleSpaces.add(Solar);possibleSpaces.add(Galaxy);possibleSpaces.add(Ninth);possibleSpaces.add(Fifth);

        possibleSpaces.add(North);possibleSpaces.add(South);possibleSpaces.add(Metro);possibleSpaces.add(Water);possibleSpaces.add(Electric);
        possibleSpaces.add(Luxury);possibleSpaces.add(Income);possibleSpaces.add(Chance1);possibleSpaces.add(Chance2);possibleSpaces.add(Chance3);

        emptySpaces = new ArrayList<Label>();
        emptySpaces.add(empty1);emptySpaces.add(empty2);emptySpaces.add(empty3);emptySpaces.add(empty4);emptySpaces.add(empty5);
        emptySpaces.add(empty6);emptySpaces.add(empty7);emptySpaces.add(empty8);emptySpaces.add(empty9);emptySpaces.add(empty10);
        emptySpaces.add(empty11);emptySpaces.add(empty12);emptySpaces.add(empty13);emptySpaces.add(empty14);emptySpaces.add(empty15);
        emptySpaces.add(empty16);emptySpaces.add(empty17);emptySpaces.add(empty18);emptySpaces.add(empty19);emptySpaces.add(empty20);
        emptySpaces.add(empty21);emptySpaces.add(empty22);emptySpaces.add(empty23);emptySpaces.add(empty24);emptySpaces.add(empty25);
        emptySpaces.add(empty26);emptySpaces.add(empty27);emptySpaces.add(empty28);

        for(int i = 0; i < emptySpaces.size(); i++){
            Image image = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
            emptySpaces.get(i).setGraphic(new ImageView(image));
        }

        deleteLabels = new ArrayList<Label>();
        deleteLabels.add(delete1);deleteLabels.add(delete2);deleteLabels.add(delete3);deleteLabels.add(delete4);deleteLabels.add(delete5);
        deleteLabels.add(delete6);deleteLabels.add(delete7);deleteLabels.add(delete8);deleteLabels.add(delete9);deleteLabels.add(delete10);
        deleteLabels.add(delete11);deleteLabels.add(delete12);deleteLabels.add(delete13);deleteLabels.add(delete14);deleteLabels.add(delete15);
        deleteLabels.add(delete16);deleteLabels.add(delete17);deleteLabels.add(delete18);deleteLabels.add(delete19);deleteLabels.add(delete20);
        deleteLabels.add(delete21);deleteLabels.add(delete22);deleteLabels.add(delete23);deleteLabels.add(delete24);deleteLabels.add(delete25);
        deleteLabels.add(delete26);deleteLabels.add(delete27);deleteLabels.add(delete28);

        gameBoard.initializeLand();
    }

}
