package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.components.PainelBottons;
import view.components.Sidebar;

public class CadUsuario extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        PainelBottons menu = new PainelBottons();
        Sidebar sidebar = new Sidebar();

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);

        //carregar imagem
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));
        Image imgPerson = new Image(getClass().getResourceAsStream("/view/resources/img/person.png"));

        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

        //customizar a imagem
        ImageView imagUserPerson = new ImageView(imgPerson);
        imagUserPerson.setFitWidth(20);
        imagUserPerson.setFitHeight(20);

        ImageView icon = new ImageView(imgBtnCad);
        icon.setFitWidth(20); // definição largura
        icon.setFitHeight(20); // definição altura
        //icon.setOpacity(0.5); // definição de opacidade/transferencia 0.0(visivel)  1.0(opaco)

        ImageView iconUp = new ImageView(imgBtnUp);
        iconUp.setFitWidth(20); // definição largura
        iconUp.setFitHeight(20); // definição altura

        ImageView iconDel = new ImageView(imgBtnDel);
        iconDel.setFitWidth(20); // definição largura
        iconDel.setFitHeight(20); // definição altura


        //tituto
        Label lblTitulo = new Label("Cadastro de funcionario");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; ");
        HBox tituloBox = new HBox(5, imagUserPerson, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);

        //cadastro
        Label lblNome = new Label("nome: ");
        TextField txtNome = new TextField();
        lblNome.setStyle("-fx-font-weight: bold;");

        Label lblEmail = new Label("email: ");
        TextField txtEmail = new TextField();
        lblEmail.setStyle("-fx-font-weight: bold;");

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("selecione:");

        HBox selecioneBox = new HBox(10, boxEmail, txtEmail, lblEmail);

        Label lblSenha = new Label("senha: ");
        TextField txtSenha = new TextField();
        lblSenha.setStyle("-fx-font-weight: bold;");

        Label lblCargo = new Label("cargo: ");
        TextField txtCargo = new TextField();
        lblCargo.setStyle("-fx-font-weight: bold;");

        ComboBox<String> boxCargo = new ComboBox<>();
        boxCargo.getItems().addAll("Chef de cozinha","Recepcionista","Camareira");
        boxCargo.setPromptText("selecione:");

        HBox selecioneBoxCargo = new HBox(10, boxCargo, txtCargo, lblCargo);


        GridPane formGrid = new GridPane();
        formGrid.add(lblNome , 0, 0);
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(txtEmail, 1, 1);
        formGrid.add(selecioneBox, 3, 1);
        formGrid.add(lblSenha, 0, 2);
        formGrid.add(txtSenha, 1, 2);
        formGrid.add(lblCargo, 0, 3);
        formGrid.add(txtCargo, 1, 3);
        formGrid.add(selecioneBoxCargo, 3, 3);

        formGrid.setHgap(10); //gap (coluna) de boa uma coluna para outra(na horizontal)
        formGrid.setVgap(10); // gap (lacuna) de uma linha para outra(vertical)

        formGrid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloBox,formGrid, menu);
        Scene scene = new Scene(mainPane, 650,500);

        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);


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
