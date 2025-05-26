package view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PainelBottons extends HBox {
    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public  Button btnExcluir = new Button("Excluir");

    public PainelBottons() {
    //carregar a imagem
        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));


    //customizar
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


        btnCadastrar.setGraphic(icon);
        btnCadastrar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");

        btnAtualizar.setGraphic(iconUp);
        btnAtualizar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");

        btnExcluir.setGraphic(iconDel);
        btnExcluir.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");
        setAlignment(Pos.CENTER);


        //estalização dos botoes
        String styleButton = "-fx-background-color: transparent;" + "fx-border-color: transparent;" + "-fx-graphic-text-gap: 10px;" + "-fx-alignment: center;" + "-fx-cursor:hand;";
        //+ "-fx-cursor:hand;"; // todos componentes que fazem parte do menu
        btnCadastrar.setStyle(styleButton);
        btnAtualizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);

        //objetivo: ao passar o mause, trocar o fundo do botão para uma cor que desejar
        btnCadastrar.setOnMouseEntered(evento ->
                btnCadastrar.setStyle(styleButton.replace("transparent", "#B0F0EC")));
        btnCadastrar.setOnMouseExited(evento -> btnCadastrar.setStyle(styleButton));

        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "#ACFC93")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));

        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "#F097A0")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));

        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir );


    }

}
