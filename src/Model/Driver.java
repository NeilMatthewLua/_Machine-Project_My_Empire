package Model;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Driver{
    public static void main(String[]args){
        GameBoard gameboard = new GameBoard();
        Player p = new Player("bob");
        gameboard.printCards();
    }
}


//public class Driver extends Application {
//
//    private static Stage guiStage;
//
//    public Stage getStage(){return guiStage;}
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        guiStage = primaryStage;
//        Parent root = FXMLLoader.load(getClass().getResource("/ViewInit.fxml"));
//        primaryStage.setTitle("Welcome to My Empire");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


    //1. Adds button to a scene with a layout
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Title of the window");
//
//        button = new Button();
//        button.setText("Click Me");
//        //button.setOnAction(EventHandler<ActionEvent>);
//        //Better to have the parameter in a different class
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//
//        Scene scene = new Scene(layout, 300,250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    //2. Adds buttons to travel between two scenes
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        Label label1 = new Label("1");
//        //Button 1
//        Button button1 = new Button("Go to Scene 2");
//        button1.setOnAction(e -> window.setScene(scene2));//Lambda expression
//
//        //Layout 1 - children are laid out in vertical column
//        VBox layout1 = new VBox(20);//20 pixels apart vertical stack
//        layout1.getChildren().addAll(label1,button1);
//        scene1 = new Scene(layout1, 200,200);
//
//        //Button 2
//        Button button2 = new Button("Go to Scene 1");
//        button2.setOnAction(e -> window.setScene(scene1));
//
//        //Layout 2
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().add(button2);
//        scene2 = new Scene(layout2,600,300);
//
//        window.setScene(scene1);
//        window.setTitle("Title Here");
//        window.show();
//    }

    //3. Alert Box class
//public class AlertBox{
//        public static void display(String title, String Message){
//            Stage window = new Stage();
//
//            //Blocks events to other windows
//            window.initModality(Modality.APPLICATION_MODAL);
//            window.setTitle(title);
//            window.setMinWidth(250);
//
//            Label label = new Label();
//            label.setText(Message);
//            Button closeButton = new Button("Close this window");
//            closeButton.setOnAction(e-> window.close());
//
//            VBox layout = new VBox(10);
//            layout.getChildren().addAll(label, closeButton);
//            layout.setAlignment(Pos.CENTER);
//
//            //Display window and wait for it to be closed before returning
//            Scene scene = new Scene(layout);
//            window.setScene(scene);
//            window.showAndWait();
//        }
//    }

    //4. Confirm Box class
//    public class AlertBox{
//        static boolean answer;
//
//        public static boolean display(String title, String Message){
//            Stage window = new Stage();
//            window.initModality(Modality.APPLICATION_MODAL);
//            window.setTitle(title);
//            window.setMinWidth(250);
//            Label label = new Label();
//            label.setText(Message);
//
//            Button yesButton = new Button("Yes");
//            Button noButton = new Button("No");
//
//            yesButton.setOnAction(e-> {
//                answer = true;
//                window.close();
//            });
//
//            noButton.setOnAction(e-> {
//                answer = false;
//                window.close();
//            });
//
//            VBox layout = new VBox(10);
//            layout.getChildren().addAll(label, yesButton,noButton);
//            layout.setAlignment(Pos.CENTER);
//
//            //Display window and wait for it to be closed before returning
//            Scene scene = new Scene(layout);
//            window.setScene(scene);
//            window.showAndWait();
//
//            return answer; //Then save that result somewhere
//        }
//    }

    // 5. Embedding layouts
//public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        window.setTitle("Window");
//
//        HBox topMenu = new HBox();
//        Button buttonA = new Button("File");
//        Button buttonB = new Button("Edit");
//        topMenu.getChildren().addAll(buttonA, buttonB);
//
//        VBox leftMenu = new VBox();
//        Button buttonC = new Button("D");
//        Button buttonD = new Button("E");
//        leftMenu.getChildren().addAll(buttonD, buttonD);
//
//    BorderPane borderPane = new BorderPane();
//    borderPane.setTop(topMenu);
//    borderPane.setLeft(leftMenu);
//
//    Scene scene = new Scene(borderPane, 300,250);
//    window.setScene(scene);
//    window.show();
//}

    //6. GridPane
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        window.setTitle("Grid Pane");
//
//        GridPane grid = new GridPane();
//        //Padding around the window
//        grid.setPadding(new Insets(10,10,10,10));
//        //Vertical gap between elements
//        grid.setVgap(8);
//        //Horizontal gap between elements
//        grid.setHgap(10);
//
//        //Name Label
//        Label nameLabel = new Label("Username:");
//        //setConstraints position where you want to add it
//        GridPane.setConstraints(nameLabel,0,0);
//
//        //Name input
//        TextField nameInput = new TextField("Default");
//        GridPane.setConstraints(nameInput,1,0);
//
//        //Pass label
//        Label passLabel = new Label("Password:");
//        GridPane.setConstraints(passLabel,0,1);
//
//        //PassInput
//        TextField passInput = new TextField();
//        passInput.setPromptText("password");//Grey input text
//        GridPane.setConstraints(passInput,1,1);
//
//        Button loginButton = new Button("Log in");
//        GridPane.setConstraints(loginButton,1,2);
//
//        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);
//
//        Scene scene = new Scene(grid, 300, 200);
//        window.setScene(scene);
//
//        window.show();
//    }
    //7. Extracting input from text field
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        window.setTitle("Input validation");
//        //You can get the data in the textfield using .getText()
//        TextField nameInput = new TextField();
//        button = new Button("Click me");
//        button.setOnAction(e -> System.out.print(nameInput.getText()));
//
//        VBox layout = new VBox(10);
//        layout.setPadding(new Insets(20,20,20,20));
//        layout.getChildren().addAll(nameInput,button);
//
//        Scene scene = new Scene(layout, 300, 250);
//        window.setScene(scene);
//        window.show();
//    }
    //8. Checkboxes
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        window.setTitle("CheckBox Example");
//
//        //CheckBoxes
//        CheckBox box1 = new CheckBox("Bacon");
//        CheckBox box2 = new CheckBox("Tuna");
//        box2.setSelected(true);//Makes it so that box2 is checked by default
//
//        button = new Button("Click me");
//        button.setOnAction(e -> );
//
//        VBox layout = new VBox(10);
//        layout.setPadding(new Insets(20,20,20,20));
//        layout.getChildren().addAll(box1,box2,button);
//
//        Scene scene = new Scene(layout, 300, 250);
//        window.setScene(scene);
//        window.show();
//    }
    //9. ComboBox (one item at a time w/ a question) and ListView (Many possible choices)
    //TreeView Makes smaller dropdowns in a larger one
    //Menu used for adding smth similar to File, edit, etc. in top of intellij

