import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;

public class MediaFX extends Application {
    MediaPlayer player;

    public void start(Stage s) {
        try {
            String path = new File("sample.mp3").toURI().toString();
            Media m = new Media(path);
            player = new MediaPlayer(m);
        } catch(Exception e) {
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Cannot load file");
            a.show();
        }

        Button play=new Button("Play");
        Button pause=new Button("Pause");
        Button stop=new Button("Stop");

        play.setOnAction(e-> {
            try{ player.play(); }
            catch(Exception ex){}
        });
        pause.setOnAction(e-> {
            try{ player.pause(); }
            catch(Exception ex){}
        });
        stop.setOnAction(e-> {
            try{ player.stop(); }
            catch(Exception ex){}
        });

        HBox h=new HBox(10,play,pause,stop);
        s.setScene(new Scene(h,300,100));
        s.setTitle("JavaFX Media Player");
        s.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
