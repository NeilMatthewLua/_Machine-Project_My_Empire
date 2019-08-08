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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LandInitController implements Initializable {

    //Background
    @FXML private AnchorPane background;

    //Here are the different Labels for the land spaces the player
    //sees on the right side of the screen
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

    //The empty label spaces on the board which take on the text from the labels
    //Above
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

    //The inidivudal clear button that appear when user hovers over a land space
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

    //Label which shows the text of currently selected property
    @FXML private Label currentSelected;
    //Play label when spaces have been filled
    @FXML private Label Play;
    //Label which clears out all land spaces
    @FXML private Label ClearAll;
    //Image of the zoomed land space
    @FXML private ImageView Zoomed;
    @FXML private Label closeZoomed;
    @FXML private Label ownerZoom;
    @FXML private Label footTrafficZoom;
    @FXML private Label playersZoom;

    //The individual anchor panes which hold the labels of the empty spaces
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
    //Contains the empty spaces
    private ArrayList<Label> emptySpaces;
    //Contains the spaces which can be placed on the baord
    private ArrayList<Label> possibleSpaces;
    //Contains the different panes
    private ArrayList<AnchorPane> panes;
    //Contains the clear buttons
    private ArrayList<Label> deleteLabels;
    //Contains the urls of the player avatars
    private ArrayList<String> playerAvatars;
    private String[][] urls = {
            {"Almond Drive","../Images/SmallSpaces/Almond.png","../Images/BigSpaces/Almond.png"},
            {"Kasoy Street","../Images/SmallSpaces/Kasoy.png","../Images/BigSpaces/Kasoy.png"},
            {"Rodeo Drive","../Images/SmallSpaces/Rodeo.png","../Images/BigSpaces/Rodeo.png"},
            {"Orange Street","../Images/SmallSpaces/Orange.png","../Images/BigSpaces/Orange.png"},
            {"Ventura Street","../Images/SmallSpaces/Venture.png","../Images/BigSpaces/Ventura.png"},
            {"Juan Luna","../Images/SmallSpaces/Juan.png","../Images/BigSpaces/Juan.png"},
            {"Ylaya","../Images/SmallSpaces/Ylaya.png","../Images/BigSpaces/Ylaya.png"},
            {"J. Abad Santos","../Images/SmallSpaces/J.png","../Images/BigSpaces/Abad.png"},
            {"Madison","../Images/SmallSpaces/Madison.png","../Images/BigSpaces/Madison.png"},
            {"Annapolis","../Images/SmallSpaces/Annapolis.png","../Images/BigSpaces/Annapolis.png"},
            {"Connecticut","../Images/SmallSpaces/Connecticut.png","../Images/BigSpaces/Connecticut.png"},
            {"Bougainvilla","../Images/SmallSpaces/Bougainvilla.png","../Images/BigSpaces/Bougainvilla.png"},
            {"Dama de Noche","../Images/SmallSpaces/Dama.png","../Images/BigSpaces/Dama.png"},
            {"Acacia","../Images/SmallSpaces/Acacia.png","../Images/BigSpaces/Acacia.png"},
            {"Solar Street","../Images/SmallSpaces/Solar.png","../Images/BigSpaces/Solar.png"},
            {"Galaxy Street","../Images/SmallSpaces/Galaxy.png","../Images/BigSpaces/Galaxy.png"},
            {"9th Street","../Images/SmallSpaces/9th.png","../Images/BigSpaces/9th.png"},
            {"5th Avenue","../Images/SmallSpaces/5th.png","../Images/BigSpaces/5th.png"},
            {"North","../Images/SmallSpaces/North.png","../Images/BigSpaces/North.png"},
            {"South","../Images/SmallSpaces/South.png","../Images/BigSpaces/South.png"},
            {"Metro","../Images/SmallSpaces/Metro.png","../Images/BigSpaces/Metro.png"},
            {"Water","../Images/SmallSpaces/Water.png","../Images/BigSpaces/Water.png"},
            {"Electric","../Images/SmallSpaces/Electric.png","../Images/BigSpaces/Electric.png"},
            {"Luxury Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Luxury.png"},
            {"Income Tax","../Images/SmallSpaces/Tax.png","../Images/BigSpaces/Income.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
            {"Chance","../Images/SmallSpaces/Chance.png","../Images/BigSpaces/Chance.png"},
    };
    //Temporary container of the currently space's text
    private Label current;

    public void setGameBoard(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public void setPlayerAvatars(ArrayList<String> playerAvatars){//Sets the player avatar urls
        this.playerAvatars = new ArrayList<String>();
        for(int i = 0; i < playerAvatars.size();i++){
            this.playerAvatars.add(playerAvatars.get(i));
        }
    }

    //Check if the label clicked can be placed
    public boolean isPlacable(Label label){
        //Checks if the label clicked is a possible space
        for(int i = 0; i < possibleSpaces.size(); i++){
            if(label == possibleSpaces.get(i))
                return true;
        }
        return false;
    }

    //When player hovers over a possible space then bring it to front
    @FXML
    public void hover(MouseEvent e){
        ((Label) e.getSource()).toFront();
    }

    //When hovered off then send it to the back
    @FXML
    public void hoverOff(MouseEvent e){
        ((Label) e.getSource()).toBack();
    }

    //Shows clear button when hovered over a space in the board
    @FXML
    public void hoverPaneIn(MouseEvent e){
        if(!(emptySpaces.get(panes.indexOf(e.getSource())).getText().equalsIgnoreCase("Empty"))){
            deleteLabels.get(panes.indexOf(e.getSource())).setVisible(true);
        }
    }

    //Hides the clear button when hovered away
    @FXML
    public void hoverPaneOut(MouseEvent e){
        if(deleteLabels.get(panes.indexOf(e.getSource())).isVisible())
            deleteLabels.get(panes.indexOf(e.getSource())).setVisible(false);
    }

    //When user clicks a possible space
    @FXML
    public void chooseSpace(MouseEvent e) {
        //Selects current space when left clicked
        if(e.getButton() == MouseButton.PRIMARY){
            if (isPlacable((Label) e.getSource())) {
                current = (Label) e.getSource();
                currentSelected.setText(possibleSpaces.get(possibleSpaces.indexOf(current)).getText());
            }
        }
        //Zooms into the property when right clicked
        else if(e.getButton() == MouseButton.SECONDARY){
            //If no zoomed image is shown
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
            //If a zoomed image is shown then close it
            else{
                closeZoomed(e);
            }
        }
    }

    //Closes zoomed space
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

    //Opens zoomed space
    @FXML
    public void openZoomed(MouseEvent e){
        if(!Zoomed.isVisible()){
            closeZoomed.setVisible(true);
            Zoomed.setVisible(true);
            boolean isFound = true;
            //Loop through the urls to find the appropriate url based on the name
            for(int i = 0; (i < urls.length - 5) && isFound ;i++){
                if(((Label)e.getSource()).getText().equalsIgnoreCase(urls[i][0])){
                    ownerZoom.setVisible(true);
                    isFound = false;
                    //If image to be zoomed is a property then show additional labels
                    if(i <= 17){
                        playersZoom.setVisible(true);
                        playersZoom.setText("" + gameBoard.getPlayers().length);
                        footTrafficZoom.setVisible(true);
                    }
                }
            }
        }
    }

    //Adding spaces to the board or zooming into the spaces on the board
    @FXML
    public void addSpace(MouseEvent e){
        //When left clicked
        if(e.getButton() == MouseButton.PRIMARY){
            //You can only add non-corner spaces
            if(!(((Label)e.getSource()).getText().equalsIgnoreCase("Start") || ((Label)e.getSource()).getText().equalsIgnoreCase("Community") ||
                    ((Label)e.getSource()).getText().equalsIgnoreCase("Jail") || ((Label)e.getSource()).getText().equalsIgnoreCase("Free Parking"))){
                if(current != null && (emptySpaces.get(emptySpaces.indexOf((e.getSource()))).getText().equalsIgnoreCase("Empty"))){
                    ((Label) e.getSource()).setVisible(true);
                    possibleSpaces.get(possibleSpaces.indexOf(current)).setVisible(false);

                    //Set the image of space to selected object
                    Image img = new Image(getClass().getResourceAsStream(urls[possibleSpaces.indexOf(current)][1]));
                    emptySpaces.get(emptySpaces.indexOf((e.getSource()))).
                            setGraphic(new ImageView(img));

                    ClearAll.setVisible(true);

                    //Rename Space to Object placed
                    emptySpaces.get(emptySpaces.indexOf((e.getSource()))).setText(urls[possibleSpaces.indexOf(current)][0]);
                    current = null;
                    currentSelected.setText("Nothing Selected");
                }

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
        //If right click then zoom
        else if(e.getButton() == MouseButton.SECONDARY) {
            //Non-corner spaces
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
            //For the corner spaces
            else{
                //If no image is displayed then show a zoomed image
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
                }
                //If an image is displayed then close the zoom
                else {
                    closeZoomed(e);
                }
            }
        }
    }

    //Assigned to individual clear button to clear their respective tiles
    @FXML
    public void deleteSpace(MouseEvent e){
        //If the chosen space is not empty then clear the land space on that tile
        if(!(emptySpaces.get(deleteLabels.indexOf(e.getSource())).getText().equalsIgnoreCase("Empty"))){
            Image image = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setGraphic(new ImageView(image));
            boolean isFound = true;
            for(int i = 0; i < 28 && isFound; i++){//Deletes space from board and makes it visible in the right side of the screen
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
            //Set it to an empty space again
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setText("Empty");
            boolean isEmptyBoard= true;
            for(int i = 0; i < emptySpaces.size() && isEmptyBoard; i++){//Check if there are empty spaces left
                if(!(emptySpaces.get(i).getText().equalsIgnoreCase("Empty"))){
                    isEmptyBoard = false;
                }
            }
            //Check if board is empty then clear all button is invisible
            if(isEmptyBoard){
                ClearAll.setVisible(false);
            }
            Play.setVisible(false);
            emptySpaces.get(deleteLabels.indexOf(e.getSource())).setText("Empty");
        }
    }


    //Empties all the properties on the board
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

    //Randomizes the positions of the spaces on the board
    @FXML
    public void randomize(MouseEvent e){
        gameBoard.randomizeLand();
        ArrayList<Land> randomizedLand = new ArrayList<Land>(gameBoard.getLand());
        randomizedLand.remove(0);
        randomizedLand.remove(7);
        randomizedLand.remove(14);
        randomizedLand.remove(21);

        //Copy the land from the randomized land into the visual board
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
        //Make a temporary array for unsorted land
        ArrayList<Land> unsortedLand = new ArrayList<>(gameBoard.getLand());
        //Remove the corners
        unsortedLand.remove(0);
        unsortedLand.remove(7);
        unsortedLand.remove(14);
        unsortedLand.remove(21);
        ArrayList<Land> finalLand = new ArrayList<>();

        //Retrieve the land at the spaces on the visual board and add it to the board
        for(int i = 0; i < emptySpaces.size();i++){
            boolean isFound = true;
            for(int j = 0; j < 28 && isFound;j++)
                if(unsortedLand.get(j).getName().equalsIgnoreCase(emptySpaces.get(i).getText())){
                    finalLand.add(unsortedLand.get(j));
                    isFound = false;
                }
        }

        //Lastly, add in the corners
        finalLand.add(0,new Start("Start"));
        finalLand.add(8,new Community("Community Service"));
        finalLand.add(16,new Jail("Jail"));
        finalLand.add(24,new Parking("Free Parking"));
        gameBoard.setLand(finalLand);

        //Load the next FXML
        try {
            Stage stage = (Stage) background.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/View/GamePlay.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            //Pass the playerAvatar urls
            ((GamePlayController) loader.getController()).setPlayerAvatars(playerAvatars);
            //Pass the new GameBoard
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
        //Add the anchorpanes to an arraylist
        panes.add(anchor1);panes.add(anchor2);panes.add(anchor3);panes.add(anchor4);panes.add(anchor5);
        panes.add(anchor6);panes.add(anchor7);panes.add(anchor8);panes.add(anchor9);panes.add(anchor10);
        panes.add(anchor11);panes.add(anchor12);panes.add(anchor13);panes.add(anchor14);panes.add(anchor15);
        panes.add(anchor16);panes.add(anchor17);panes.add(anchor18);panes.add(anchor19);panes.add(anchor20);
        panes.add(anchor21);panes.add(anchor22);panes.add(anchor23);panes.add(anchor24);panes.add(anchor25);
        panes.add(anchor26);panes.add(anchor27);panes.add(anchor28);

        //Add the clickable spaces into an arraylist
        possibleSpaces = new ArrayList<Label>();
        possibleSpaces.add(Almond);possibleSpaces.add(Kasoy);possibleSpaces.add(Rodeo);
        possibleSpaces.add(Orange);possibleSpaces.add(Ventura);possibleSpaces.add(Juan);
        possibleSpaces.add(Ylaya);possibleSpaces.add(Abad);possibleSpaces.add(Madison);
        possibleSpaces.add(Annapolis);possibleSpaces.add(Connecticut);
        possibleSpaces.add(Bougainvilla);possibleSpaces.add(Dama);possibleSpaces.add(Acacia);
        possibleSpaces.add(Solar);possibleSpaces.add(Galaxy);possibleSpaces.add(Ninth);possibleSpaces.add(Fifth);
        possibleSpaces.add(North);possibleSpaces.add(South);possibleSpaces.add(Metro);possibleSpaces.add(Water);possibleSpaces.add(Electric);
        possibleSpaces.add(Luxury);possibleSpaces.add(Income);possibleSpaces.add(Chance1);possibleSpaces.add(Chance2);possibleSpaces.add(Chance3);

        //Add the empty spaces into an array list
        emptySpaces = new ArrayList<Label>();
        emptySpaces.add(empty1);emptySpaces.add(empty2);emptySpaces.add(empty3);emptySpaces.add(empty4);emptySpaces.add(empty5);
        emptySpaces.add(empty6);emptySpaces.add(empty7);emptySpaces.add(empty8);emptySpaces.add(empty9);emptySpaces.add(empty10);
        emptySpaces.add(empty11);emptySpaces.add(empty12);emptySpaces.add(empty13);emptySpaces.add(empty14);emptySpaces.add(empty15);
        emptySpaces.add(empty16);emptySpaces.add(empty17);emptySpaces.add(empty18);emptySpaces.add(empty19);emptySpaces.add(empty20);
        emptySpaces.add(empty21);emptySpaces.add(empty22);emptySpaces.add(empty23);emptySpaces.add(empty24);emptySpaces.add(empty25);
        emptySpaces.add(empty26);emptySpaces.add(empty27);emptySpaces.add(empty28);

        //Set the images to that of an empty space
        for(int i = 0; i < emptySpaces.size(); i++){
            Image image = new Image(getClass().getResourceAsStream("../Images/SmallSpaces/Empty.png"));
            emptySpaces.get(i).setGraphic(new ImageView(image));
        }

        //Add the clear buttons into an array list
        deleteLabels = new ArrayList<Label>();
        deleteLabels.add(delete1);deleteLabels.add(delete2);deleteLabels.add(delete3);deleteLabels.add(delete4);deleteLabels.add(delete5);
        deleteLabels.add(delete6);deleteLabels.add(delete7);deleteLabels.add(delete8);deleteLabels.add(delete9);deleteLabels.add(delete10);
        deleteLabels.add(delete11);deleteLabels.add(delete12);deleteLabels.add(delete13);deleteLabels.add(delete14);deleteLabels.add(delete15);
        deleteLabels.add(delete16);deleteLabels.add(delete17);deleteLabels.add(delete18);deleteLabels.add(delete19);deleteLabels.add(delete20);
        deleteLabels.add(delete21);deleteLabels.add(delete22);deleteLabels.add(delete23);deleteLabels.add(delete24);deleteLabels.add(delete25);
        deleteLabels.add(delete26);deleteLabels.add(delete27);deleteLabels.add(delete28);

        //Initialize the Land objects on the board
        gameBoard.initializeLand();
    }

}
