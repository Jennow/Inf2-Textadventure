/**
 * Created by Markus Alpers on 20.10.2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Textadventure extends Application 
{

    private int aktuellerAbschnitt;
    private String[] abschnitte;
    private String[][] beschriftungen;
    private int[][] naechsterAbschnitt;
    private Text beschreibung;
    private Button button1;
    private Button button2;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Textadventure");

        int abenteuerlaenge = 12;
        aktuellerAbschnitt = 0;

        abschnitte = new String[abenteuerlaenge];
        beschriftungen = new String[abenteuerlaenge][2];
        naechsterAbschnitt = new int[abenteuerlaenge][2];

        // 0: Eingesperrt (Startpunkt)
        abschnitte[0] = "Nach dem Volleyball-Training, als du mal wieder als letztes die Umkleidekabine verlässt, bemerkst du, dass die Eingangstür der Sporthalle schon abgeschlossen wurde. ";
        beschriftungen[0][0] = "Ich schreie so laut ich kann. Vielleicht hört mich noch jemand.";
        naechsterAbschnitt[0][0] = 1;
        beschriftungen[0][1] = "Ich mache mich auf die Suche nach einem anderen Weg nach draußen.";
        naechsterAbschnitt[0][1] = 2;

        // 1: Nach Hilfe gerufen
        abschnitte[1] = "Du siehst durch ein Fenster nach draußen. Dort läuft eine dunkle Gestalt herum. Sie trägt eine Clownsmaske und hat einen Baseballschläger in der Hand.";
        beschriftungen[1][0] = "Ich ducke mich schnell und hoffe, dass sie mich nicht gesehen hat.";
        naechsterAbschnitt[1][0] = 3;
        beschriftungen[1][1] = "Ich klopfe ans Fenster und hoffe, dass der freundliche Clown mir vielleicht helfen kann. ";
        naechsterAbschnitt[1][1] = 4;

        // 2: Nach Ausweg gesucht
        abschnitte[2] = "Du siehst ein offenes Fenster an der Hallendecke. Doch es ist viel zu weit oben.";
        beschriftungen[2][0] = "Ich baue mir aus Sportgeräten einen provisorischen Aufstieg. ";
        naechsterAbschnitt[2][0] = 5;
        beschriftungen[2][1] = "Ich suche weiter nach einem Ausgang, der leichter zu erreichen ist. ";
        naechsterAbschnitt[2][1] = 6;

        // 3: Vor Clown versteckt
        abschnitte[3] = "Der Clown bleibt kurz stehen und sieht sich um. Dann geht er weiter, er scheint dich nicht bemerkt zu haben. Was jetzt?";
        beschriftungen[3][0] = "Ich verstecke mich in einer sicheren Ecke und warte, bis am nächsten Morgen die Halle wieder aufgeschlossen wird. ";
        naechsterAbschnitt[3][0] = 7;
        beschriftungen[3][1] = "Ich laufe durch die Sporthalle und suche nach einem Ausgang.";
        naechsterAbschnitt[3][1] = 2;

        // 4: Den Clown Aufmerksam gemacht
        abschnitte[4] = "Der Clown kommt ans Fenster und mustert dich blutrünstig. Dann schlägt er das Fenster ein. Der Alarm geht los, aber das scheint ihm egal zu sein. Er rennt auf dich zu.";
        beschriftungen[4][0] = "Ich renne weg.";
        naechsterAbschnitt[4][0] = 2;
        beschriftungen[4][1] = "Ich bleibe stehen und bedanke mich bei dem Clown für die Hilfe.";
        naechsterAbschnitt[4][1] = 10;

        // 5: Der Provisorische Aufstieg
        abschnitte[5] = "Der Turm wackelt und du bekommst Angst, zu fallen und dir das Genick zu brechen.";
        beschriftungen[5][0] = "Ich klettere weiter.";
        naechsterAbschnitt[5][0] = 8;
        beschriftungen[5][1] = "Ich steige wieder runter. Es muss einen anderen Weg geben.";
        naechsterAbschnitt[5][1] = 9;

        // 6: Weitersuchen
        abschnitte[6] = "Du siehst eine Gestalt an der Torwand stehen. Ist das der Clown von vorhin? Wie ist er hier reingekommen?";
        beschriftungen[6][0] = "Ich renne weg und verstecke mich so gut ich kann.";
        naechsterAbschnitt[6][0] = 7;
        beschriftungen[6][1] = "Ich gehe auf die Gestalt zu, denn es kann unmöglich der Clown sein.";
        naechsterAbschnitt[6][1] = 10;

        //Der nächste Morgen
        abschnitte[7] = "  Als die ersten Sonnenstrahlen erscheinen, schöpfst du Hoffnung, dass der Alptraum vorbei ist.";
        beschriftungen[7][0] = "Aufstehen und am Eingang auf den Hausmeister warten.";
        naechsterAbschnitt[7][0] = 9;
        beschriftungen[7][1] = "Lieber noch etwas warten. Sicher ist sicher. ";
        naechsterAbschnitt[7][1] = 11;

        // 8: Absturz (Schlechtes Ende)
        abschnitte[8] = "Es kommt wie es kommen musste: Der Turm ist zu instabil, du fällst und brichst dir das Genick. Alles nur, weil du beim Umziehen so trödeln musstest..";
        beschriftungen[8][0] = "Nochmal versuchen.";
        naechsterAbschnitt[8][0] = 0;
        beschriftungen[8][1] = "Spiel beenden.";
        naechsterAbschnitt[8][1] = 0 ;// ENDE

        // 9: Der bessere Ausweg (Gutes Ende)
        abschnitte[9] = "Du bemerkst,als du aus Frust an ihr rüttelst, dass die Eingangstür doch garnicht abgeschlossen war, sondern nur etwas geklemmt hat. Du gehst erleichtert nachhause.";
        beschriftungen[9][0] = "Dann bis nächste Woche!";
        naechsterAbschnitt[9][0] = 0;
        beschriftungen[9][1] = "Ich gehe nie wieder Volleyball spielen! ";
        naechsterAbschnitt[9][1] = 0;// ENDE
        
        // 10: Bei Clown bedankt (Schlechtes Ende)
        abschnitte[10] = "Der Clown meinte es leider nicht gut mit dir. Du bist nun sein Gefangener und musst jeden Tag seine schlechten Witze ertragen.";
        beschriftungen[10][0] = "Nochmal versuchen.";
        naechsterAbschnitt[10][0] = 0;
        beschriftungen[10][1] = "Spiel beenden.";
        naechsterAbschnitt[10][1] = 0;// ENDE
        
        // 11: Zu lange gewartet (Schlechtes Ende)
        abschnitte[11] = "Der Clown ist nicht so dumm, wie er aussieht. Er hat dein Versteck gefunden, du bist nun sein Gefangener und musst jeden Tag seine schlechten Witze ertragen.";
        beschriftungen[11][0] = "Nochmal versuchen.";
        naechsterAbschnitt[11][0] = 0;
        beschriftungen[11][1] = "Spiel beenden.";
        naechsterAbschnitt[11][1] = 0;// ENDE

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1200, 400);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Kleines Textadventure");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        beschreibung = new Text(abschnitte[aktuellerAbschnitt]);
        grid.add(beschreibung, 0, 1, 2, 2);

        button1 = new Button(beschriftungen[aktuellerAbschnitt][0]);
        grid.add(button1, 0, 3);
        grid.setHalignment(button1, HPos.RIGHT);

        button2 = new Button(beschriftungen[aktuellerAbschnitt][1]);
        grid.add(button2, 1, 3);
        grid.setHalignment(button2, HPos.LEFT);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][0];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][1];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        primaryStage.show();
    }

    private void rewriteEntries(int abschnnitt){
        beschreibung.setText(abschnitte[aktuellerAbschnitt]);
        button1.setText(beschriftungen[aktuellerAbschnitt][0]);
        button2.setText(beschriftungen[aktuellerAbschnitt][1]);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/**
 * Grundsätzlich nötig:
 * Textanzeige
 * Buttons für Auswahl der Antwort
 *
 * Texte aus Array von Abschnitten
 * Dazu Array mit Anzahl Buttons zum Abschnitt
 * Dazu Array mit Texten für jeden der Buttons
 */