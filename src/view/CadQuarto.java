package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


public class CadQuarto extends Application {

    public void start(Stage stage) throws Exception {
        //componentes
        PainelBottons menu = new PainelBottons();
        Sidebar sidebar = new Sidebar();

        //
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(sidebar);

        //imagem
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));
        Image imgPerson = new Image(getClass().getResourceAsStream("/view/resources/img/person.png"));

        //customizar a imagem
        ImageView imagUserPerson = new ImageView(imgPerson);
        imagUserPerson.setFitWidth(20);
        imagUserPerson.setFitHeight(20);

        Label lblTitulo = new Label("Quartos e Reservas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; ");
        HBox tituloBox = new HBox(5, imagUserPerson, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);

        //imagem e custumizar botoes
        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

        //ImageView
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

        //cadastro
        Label lblNome = new Label("Nome: ");
        TextField campoNome = new TextField();
        lblNome.setStyle("-fx-font-weight: bold;");

        Label lblNumero = new Label("Numero: ");
        TextField campoNumero = new TextField();
        lblNome.setStyle("-fx-font-weight: bold;");

        Label lblPreco = new Label("Preço: ");
        TextField campoPreco = criarMascaraCampo("R$ ##.###,##");
        lblNome.setStyle("-fx-font-weight: bold;");

        Label lblDisponivel = new Label("Disponivel: ");
        TextField campoDisponivel = new TextField();
        lblNome.setStyle("-fx-font-weight: bold;");

        GridPane formGrid = new GridPane();
        formGrid.add(lblNome, 0, 0);
        formGrid.add(campoNome, 1, 0);
        formGrid.add(lblNumero, 0, 1);
        formGrid.add(campoNumero, 1, 1);
        formGrid.add(lblPreco, 0, 2);
        formGrid.add(campoPreco, 1, 2);
        formGrid.add(lblDisponivel, 0, 3);
        formGrid.add(campoDisponivel, 1, 3);

        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10,tituloBox,formGrid,menu);
        Scene scene = new Scene(mainPane, 650,500);

        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        stage.getIcons().add(imgIcon);
        stage.setResizable(false);
        stage.setTitle("Grand Hotel");
        stage.setScene(scene);
        stage.show();

    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;


                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }

    public static void main(String...args) {
        launch(args);
    }
}
