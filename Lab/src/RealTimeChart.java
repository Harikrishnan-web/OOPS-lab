import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.Random;

public class RealTimeChart extends Application {
    XYChart.Series<Number,Number> series=new XYChart.Series<>();
    int x=0;
    boolean updating=true;

    public void start(Stage s) {
        NumberAxis xa=new NumberAxis();
        NumberAxis ya=new NumberAxis();
        LineChart<Number,Number> chart=new LineChart<>(xa,ya);
        chart.getData().add(series);
        Timeline t=new Timeline(new KeyFrame(Duration.seconds(1),e->{
            if(updating){
                double y=new Random().nextDouble()*100;
                series.getData().add(new XYChart.Data<>(x++,y));
            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        s.setScene(new Scene(chart,600,400));
        s.setTitle("Real-Time Data Visualization");
        s.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
