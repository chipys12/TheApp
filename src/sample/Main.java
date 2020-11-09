package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.AlertBox;

public class Main extends Application {
    Stage window;
    Account mujUcet = new Account( "", 1000, 100, 100);
    TableView<Account> table;
    FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("BankingApp");

        //name column
        TableColumn<Account, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        /*first deposit
        TableColumn<Account, int> firstDepositColumn = new TableColumn<>("first deposit");
        firstDepositColumn.setMinWidth(200);
        firstDepositColumn.setCellValueFactory(new PropertyValueFactory<>("firstBalance"));

        //deposit
        TableColumn<Account, String> depositColumn = new TableColumn<>("deposit");
        depositColumn.setMinWidth(200);
        depositColumn.setCellValueFactory(new PropertyValueFactory<>("deposit")); */

        table = new TableView<>();
        table.setItems(getAccount());
        table.getColumns().addAll(nameColumn);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene sceneWelcome = new Scene(grid, 600, 600);

        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        grid1.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene sceneHomePage = new Scene(grid1, 600, 600);

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        grid2.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene sceneDeposit = new Scene(grid2, 600, 600);

        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
        grid3.setHgap(10);
        grid3.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene sceneCheckBalance = new Scene(grid3, 600, 600);

        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10, 10, 10, 10));
        grid4.setVgap(8);
        grid4.setHgap(10);
        grid4.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene sceneWithdraw = new Scene(grid4, 600, 600);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
        Scene seznam = new Scene(vBox);

        Label welcome = new Label("Vítejte v aplikaci BankingApp. Pro pokračování stiskněte Pokračovat.");
        GridPane.setConstraints(welcome, 0, 0);
        Button pokracovat = new Button("Pokračovat");
        GridPane.setConstraints(pokracovat, 1, 3);
        Label name = new Label("Přihlašovací jméno:");
        GridPane.setConstraints(name, 0, 1);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 1);
        PasswordField passInput = new PasswordField();
        Label pass = new Label("Přihlašovací heslo:");
        GridPane.setConstraints(pass, 0, 2);
        GridPane.setConstraints(passInput, 1, 2);
        nameInput.setPromptText("Vaše jméno");
        passInput.setPromptText("Vaše heslo");
        pokracovat.setOnAction(e ->{
            isInt(nameInput, nameInput.getText());
            if (nameInput.getText().equals("Honza") && passInput.getText().equals("Heslo123")){
                System.out.println("Přihlášení proběhlo úspěšně!");
                AlertBox.display("Success","Přihlášení proběhlo úspěšně!");
                window.setScene(sceneHomePage);
            }else {
                AlertBox.display("Chyba!", "Chybné přihlášení.");
            }
        });
        mujUcet.uvitani();
        grid.getChildren().addAll(welcome, nameInput, passInput,pokracovat, pass, name);

        Label menu = new Label("Zde v menu si můžete ověřit stav účtu, vložit nebo si vybrat peníze.");
        GridPane.setConstraints(menu, 0, 0);
        Button checkBalance = new Button("Stav účtu");
        GridPane.setConstraints(checkBalance, 1, 1);
        Button deposit = new Button("Vložit peníze");
        GridPane.setConstraints(deposit, 1, 2);
        Button withdraw = new Button("Vybrat peníze");
        GridPane.setConstraints(withdraw, 1, 3);
        checkBalance.setOnAction(e -> {
            window.setScene(sceneCheckBalance);
            mujUcet.checkBalance();
        });
        deposit.setOnAction(e -> window.setScene(sceneDeposit));
        withdraw.setOnAction(e -> {
            window.setScene(sceneWithdraw);
            mujUcet.withdrawMoney();
        });
        Label ucet = new Label("Na účtě máte " + mujUcet.balance);
        GridPane.setConstraints(ucet, 3, 0);
        Button seznamUctu = new Button("Seznam uctu");
        GridPane.setConstraints(seznamUctu, 5, 5);
        seznamUctu.setOnAction(e -> window.setScene(seznam));
        grid1.getChildren().addAll(menu, checkBalance, deposit, withdraw, ucet, seznamUctu);

        Label stavUctu = new Label("Stav vašeho účtu je " + mujUcet.balance + "Kč.");
        GridPane.setConstraints(stavUctu, 2, 2);
        Button backToMenu1 = new Button("Zpět");
        GridPane.setConstraints(stavUctu, 8, 10);
        backToMenu1.setOnAction(e -> window.setScene(sceneHomePage));
        Label jmeno = new Label("Vaše jméno: " + mujUcet.getName());
        GridPane.setConstraints(jmeno,2, 1 );

        grid3.getChildren().addAll(stavUctu, backToMenu1, jmeno);

        Label depositLabel = new Label("Opravdu si chcete vložit peníze?");
        GridPane.setConstraints(depositLabel, 2, 1);
        Button vlozit = new Button("Vložit");
        GridPane.setConstraints(vlozit, 2, 2);
        Button backToMenu2 = new Button("Zpět");
        GridPane.setConstraints(backToMenu2, 8, 10);
        backToMenu2.setOnAction(e -> window.setScene(sceneHomePage));
        vlozit.setOnAction(e -> {
            boolean result = ConfirmBox.display("Alert", "jsi si jistej?");
            if (result) {
                window.setScene(sceneHomePage);
                mujUcet.depositMoney();
            } else {
                window.setScene(sceneDeposit);
            }
            System.out.println(result);
        });
        grid2.getChildren().addAll(depositLabel, vlozit, backToMenu2);

        Label withdrawLabel = new Label("Váš aktuální zůstatek na účtuje " + mujUcet.actualValue() + "Kč. Vyberte si kolik si chcete vybrat.");
        GridPane.setConstraints(withdrawLabel, 1, 1);
        Button option1 = new Button("100Kč");
        GridPane.setConstraints(option1, 2, 1);
        option1.setOnAction(e -> {
            window.setScene(sceneHomePage);
            mujUcet.newWithdraw(100);
            AlertBox.display("Info", "Právě jste vybrali 100Kč.");
        });
        Button option2 = new Button("500Kč");
        GridPane.setConstraints(option2, 2, 2);
        option2.setOnAction(e -> {
            mujUcet.newWithdraw(500);
            AlertBox.display("Info", "Právě jste vybrali 500Kč.");
            window.setScene(sceneHomePage);
        });
        Button option3 = new Button("1000Kč");
        GridPane.setConstraints(option3, 2, 3);
        option3.setOnAction(e -> {
            window.setScene(sceneHomePage);
            mujUcet.newWithdraw(1000);
            AlertBox.display("Info", "Právě jste vybrali 1000Kč.");
        });
        Button backToMenu3 = new Button("Zpět");
        GridPane.setConstraints(backToMenu3, 10, 10);
        backToMenu3.setOnAction(e -> window.setScene(sceneHomePage));
        grid4.getChildren().addAll(withdrawLabel, option1, option2, option3, backToMenu3);

        window.setScene(sceneWelcome);
        window.show();
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("Je vám: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }
    public ObservableList<Account> getAccount(){
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        accounts.add(new Account("Honza", 1000, 100, 1000));
        accounts.add(new Account("David", 5000, 300, 10));
        accounts.add(new Account("Petr", 100, 200, 300));
        accounts.add(new Account("Klára", 2000, 50, 50));
        accounts.add(new Account("Retard", 5000, 10, 200));
        return accounts;
    }
}