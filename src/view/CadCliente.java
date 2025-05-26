package view; //package viel (classe que, quando executa, interface do usuario

import javafx.application.Application; //Ciclo de vida da aplicação (int), (start), (stop)--> launch())
import javafx.geometry.Pos;
import javafx.scene.Scene; //classe Scere: conteiner que contem os layouts
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe vbox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe stage é a propia janela(incluso barra de opçoes: minimizar, maximixar, fehar)

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.Sidebar;

public class CadCliente extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Sidebar menu = new Sidebar();

        //carregar imagens exemplo
        //Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/img/plus48px.png"));

        //Customização do programa/imagens

        Image imgBtnCad = new Image(getClass().getResourceAsStream("/view/resources/img/plus48px.png"));

        Image imgBtnUp = new Image(getClass().getResourceAsStream("/view/resources/img/update48px.png"));

        Image imgBtnDel = new Image(getClass().getResourceAsStream("/view/resources/img/delete48px.png"));

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logo.png"));

        Image imgPerson = new Image(getClass().getResourceAsStream("/view/resources/img/person.png"));

        //criação de um container principal  chamado mainPane
        BorderPane mainPame = new BorderPane();
        mainPame.setLeft(menu);

        //inserir img em container para manipular tamanho/redimensionamento
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

        ImageView imagUserPerson = new ImageView(imgPerson);
        imagUserPerson.setFitWidth(20);
        imagUserPerson.setFitHeight(20);

        //manipulaçao dos botoes

        //tituto
        Label lblTitulo = new Label("Cadastro de Clientes");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; ");
        HBox tituloBox = new HBox(5, imagUserPerson, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        //tituloBox.setSpacing(5); (segunda forma de separação)

        //parte do cadastro do cliente
        Label pergunteNome = new Label("Nome");
        TextField textNome = new TextField();
        pergunteNome.setStyle("-fx-font-weight: bold;");

        Label pergunteCpf = new Label("Cpf");
        TextField txtCpf = criarMascaraCampo("###.###.###-##");
        pergunteCpf.setStyle("-fx-font-weight: bold;");

        Label pergunteEmail = new Label("Email");
        TextField txtEmail = new TextField();
        pergunteEmail.setStyle("-fx-font-weight: bold;");
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("selecione:");

        HBox selecioneBox = new HBox(10, boxEmail, txtEmail, pergunteEmail);

        //Spinner <Integer> campoQtdeQuarto = new Spinner<>(1,6,1);

        Label pergunteTelefone = new Label("Telefone");
        TextField txtTelefone = criarMascaraCampo("(##) ####-####");
        pergunteTelefone.setStyle("-fx-font-weight: bold;");
        //txtTelefone.setPromptText("*(__)____-____");

        GridPane formGrid = new GridPane(); //grid usa coluna e linha
        formGrid.add(pergunteNome, 0, 0);
        formGrid.add(textNome, 1, 0);
        formGrid.add(pergunteCpf, 0, 1);
        formGrid.add(txtCpf, 1, 1);
        formGrid.add(pergunteEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(selecioneBox, 2, 2);
        formGrid.add(pergunteTelefone, 0, 3);
        formGrid.add(txtTelefone, 1, 3);


        formGrid.setHgap(10); //gap (coluna) de  uma coluna para outra(na horizontal)
        formGrid.setVgap(10); // gap (lacuna) de uma linha para outra(vertical)

        formGrid.setAlignment(Pos.CENTER);

        //parte dos botoes

        Button btnCadastrar = new Button("Cadastrar", icon);
        btnCadastrar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold;");

        Button btnExcluir = new Button("Excluir", iconDel);
        btnExcluir.setStyle("-fx-background-color: transparent; -fx-font-weight:bold ");

        Button btnAtualizar = new Button("Atualizar", iconUp);
        btnAtualizar.setStyle("-fx-background-color: transparent; -fx-font-weight: bold");

        HBox atualizarBox = new HBox(10, btnCadastrar, btnAtualizar, btnExcluir);
        atualizarBox.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10, tituloBox, formGrid, atualizarBox);
        layout.setAlignment(Pos.CENTER);

        mainPame.setCenter(layout); //adicionar nova linha
        Scene scene = new Scene(mainPame, 650, 500);
        stage.setTitle("Grand Hotel");


        stage.getIcons().add(imgIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    //metodo para criar um campo de texto com mascara
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


    public static void main(String[] args) {
        launch(args); //inicializa o javavx

    }
}
