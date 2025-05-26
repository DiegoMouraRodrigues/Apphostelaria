package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CadLogin extends Application {
    private boolean senhaVisivel = false;

    public void start(Stage stage) throws Exception {

        //componetes utilizado para senha no javaFX
        PasswordField password = new PasswordField();


        //icones email e olhos
        Image imagemEmail = new Image(getClass().getResourceAsStream("/view/resources/img/icone_email.png"));
        Image imagemOlho = new Image(getClass().getResourceAsStream("/view/resources/img/icone_olho.png"));
        Image imagemOlhoFechado = new Image(getClass().getResourceAsStream("/view/resources/img/olho_fechado.png"));



        Image imagemHotel = new Image(getClass().getResourceAsStream("/view/resources/img/Hotel.jpg"));
        ImageView imgHotel = new ImageView(imagemHotel);
        imgHotel.setFitHeight(600);
        imgHotel.setFitWidth(500);


        BorderPane mainPame = new BorderPane();
        mainPame.setLeft(imgHotel);

        BorderPane.setAlignment(imgHotel, Pos.CENTER);

        //logo
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));

        //tituto
        Image imgPerson = new Image(getClass().getResourceAsStream("/view/resources/img/person.png"));
        ImageView imagUserPerson = new ImageView(imgPerson);

        imagUserPerson.setFitWidth(20);
        imagUserPerson.setFitHeight(20);

        Label lblTitulo = new Label("Faça seu login");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; ");
        HBox tituloBox = new HBox(5,imagUserPerson,lblTitulo );
        tituloBox.setAlignment(Pos.CENTER);

        //login e senha e botoes
        Label lblNome = new Label();
        TextField txtNome = new TextField();
        txtNome.setPromptText("Digite seu Email"); //faz aparecer o nome mais ele nao é setado
        lblNome.setStyle("-fx-font-weight: bold;");


        Label lblSenha = new Label();
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua Senha"); //faz aparecer o nome mais ele nao é setado
        lblSenha.setStyle("-fx-font-weight: bold;");



        Button btnLogin = new Button("login");
        btnLogin.setStyle("-fxfont-size: 18px;" +
                "-fx-background-radius: 30;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" +
                "-fx-background-color:  #86a7ea;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 6 60 6;" +
                "-fx-border-color: transparent;" +
                "-fx-border-width: 1;");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblSenha, 0, 1);
        formGrid.add(txtSenha, 1, 1);
        formGrid.add(btnLogin, 1, 2);

        formGrid.setHgap(10); //coluna
        formGrid.setVgap(10); //largura

        formGrid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(tituloBox,formGrid);
        Scene scene = new Scene(mainPame, 950,590);

        layout.setAlignment(Pos.CENTER);
        mainPame.setCenter(layout);

        stage.getIcons().add(imgIcon);
        stage.setResizable(false);
        stage.setTitle("Grand Hotel");
        stage.setScene(scene);
        stage.show();



    }
    public static void main(String[] args) {
        launch(args);
    }
}
