package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Cliente");
    public Button btnFuncionario = new Button("Funcionario");
    public  Button btnQuarto = new Button("Quarto");
    public Button btnReserva = new Button("Reserva");
    public Button btnRelatorio = new Button("Relatorio");

    public Sidebar() {
        //carregar imagem
        Image iconCliente = new Image(getClass().getResourceAsStream("/view/resources/img/icon-cliente.png"));
        Image iconFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/icon-funcionario.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream("/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/icon-relatorio.png"));

        //carregamento da fonte
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/LeagueSpartan-Regular.ttf"), 14);
        Font fonteNecrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/LeagueSpartan-bold.ttf"),15);

        //obejto para manipular dimensões da imagem ja carregadas
        ImageView viewIconCliente  = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(20); //altura
        viewIconCliente.setFitWidth(20); //largura

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20); // altura
        viewIconFuncionario.setFitWidth(20); // largura

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20); //altura
        viewIconQuarto.setFitWidth(20);  //largura

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(20); //altura
        viewIconReserva.setFitWidth(20);  //largura

        ImageView viewIconRelatorio = new ImageView(iconRelatorio);
        viewIconRelatorio.setFitHeight(20); //altura
        viewIconRelatorio.setFitWidth(20);  //largura

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorio);



        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #a87e08;");

        lblMenu.setFont(Font.font (fonteNecrito.getFamily(), 30));

        //estalização dos botoes
        String styleButton = "-fx-background-color: transparent;" + "fx-border-color: transparent;" + "-fx-graphic-text-gap: 10px;" + "-fx-alignment: center;" + "-fx-cursor:hand;";
        //+ "-fx-cursor:hand;"; // todos componentes que fazem parte do menu
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        //objetivo: ao passar o mause, trocar o fundo do botão para uma cor que desejar
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#d6c388ff")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#d6c388ff")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#d6c388ff")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#d6c388ff")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#d6c388ff")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        //espaçamento externo(margem) do componentes label ate o botão
        setMargin(lblMenu, new Insets(0, 0, 20, 0));

        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px; -fx-spacing: 10px");
             getChildren().addAll(lblMenu, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio); //getchildren so pode ser usado quando ta usando a extends
    }
}
