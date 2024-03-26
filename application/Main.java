package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		Mylist<Martyr> martyr = new Mylist<>(16);

		Button fileopen = new Button("click to chose File");
		Label lablel1 = new Label();
		VBox v1 = new VBox();
		v1.getChildren().addAll(fileopen, lablel1);
		v1.setAlignment(Pos.CENTER);
		v1.setSpacing(20);
		fileopen.setPrefWidth(200);
		StackPane s1 = new StackPane();
		s1.getChildren().add(v1);

		fileopen.setOnAction(e -> {
			lablel1.setText("");
			boolean m = true;
			FileChooser filechoser = new FileChooser();
			File file = filechoser.showOpenDialog(primaryStage);
			if (!file.getName().equals("data.csv")) {

				lablel1.setText("sorry the file anvalid");
				return;
			}
			try (Scanner input = new Scanner(file)) {
				input.nextLine();
				while (input.hasNext()) {
					String[] part = input.nextLine().trim().split(",");
					if (part.length < 5) {
						continue;
					}
					try {
						Integer.parseInt(part[1].trim());
					} catch (Exception er) {
						continue;
					}

					Martyr martyr1 = new Martyr(part[0].trim().replaceAll(" ", "_"), Integer.parseInt(part[1].trim()),
							part[2].trim().replaceAll(" ", "_"), part[3].trim(), part[4].trim().charAt(0));
					martyr.add(martyr1);

				}
				martyr.traverse();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			VBox v2 = new VBox();
			Button button1 = new Button("insert a new martyr");
			button1.setPrefWidth(200);
			Button button2 = new Button("delete a martyr");
			Button button3 = new Button("search for a specific martyr");
			Button button4 = new Button("display the number of martyrs");
			button2.setPrefWidth(200);
			button3.setPrefWidth(200);
			button4.setPrefWidth(200);
			v2.getChildren().addAll(button1, button2, button3, button4);
			v2.setAlignment(Pos.CENTER);
			v2.setSpacing(20);

			Scene scene2 = new Scene(v2, 400, 400);
			primaryStage.setScene(scene2);
			button1.setOnAction(e1 -> {
				TextField t1 = new TextField();
				Button add = new Button("add");
				HBox h1 = new HBox();
				h1.setSpacing(10);
				h1.setAlignment(Pos.CENTER);
				h1.getChildren().addAll(t1, add);
				VBox vadd = new VBox();
				Button back = new Button("Back");
				vadd.setAlignment(Pos.CENTER);
				Label labeladd = new Label();
				vadd.getChildren().addAll(h1, labeladd, back);
				vadd.setSpacing(20);
				Scene scene3 = new Scene(vadd, 400, 400);
				primaryStage.setScene(scene3);
				back.setOnAction(e2 -> {
					primaryStage.setScene(scene2);

				});

				add.setOnAction(e3 -> {
					String[] part2 = t1.getText().trim().split(",");

					
					
					
					if (part2.length < 5) {
						labeladd.setText("the data is nanvalid");
						return;
					}
					
					try {

						Integer.parseInt(part2[1].trim());
					} catch (Exception er) {
						labeladd.setText("the data is nanvalid");
						return;
					}
					if(Integer.parseInt(part2[1].trim())>130||Integer.parseInt(part2[1].trim())<0)
					{
						labeladd.setText("add age valed");
						t1.setText("");
						return ;
					}
					Martyr martyr2 = new Martyr(part2[0].trim().replaceAll(" ", "_"), Integer.parseInt(part2[1].trim()),
							part2[2].trim().replaceAll(" ", "_"), part2[3].trim(),
							part2[4].toUpperCase().trim().charAt(0));
					martyr.add(martyr2);
					labeladd.setText("the add is succssifly");

					t1.setText("");

				});

			});
			button2.setOnAction(e3 -> {

				TextField t2 = new TextField();
				Button delet = new Button("Delet by name");
				HBox h2 = new HBox();
				h2.setSpacing(10);
				h2.setAlignment(Pos.CENTER);
				h2.getChildren().addAll(t2, delet);
				VBox vdelet = new VBox();
				Button back1 = new Button("Back");
				vdelet.setAlignment(Pos.CENTER);
				Label labeldelet = new Label();
				vdelet.getChildren().addAll(h2, labeldelet, back1);
				vdelet.setSpacing(20);
				Scene scene4 = new Scene(vdelet, 400, 400);
				primaryStage.setScene(scene4);
				back1.setOnAction(e2 -> {
					primaryStage.setScene(scene2);

				});
				delet.setOnAction(e4 -> {
					labeldelet.setText("");

					String name = t2.getText().replaceAll(" ", "_").trim();
					if (name.equals("")) {
						labeldelet.setText("please enter the name");
						return;

					}
					for (int i = 0; i < martyr.size(); i++) {
						if (name.toLowerCase().equals(martyr.get(i).name.toLowerCase())) {
							martyr.delete(martyr.get(i));
							labeldelet.setText("the delet is succssifly");
							martyr.traverse();
							t2.setText("");
							return;

						}

					}
					t2.setText("");

				});

			});
			button3.setOnAction(e4 -> {
				TextField t2 = new TextField();
				Button search = new Button("search by name");
				HBox h2 = new HBox();
				h2.setSpacing(10);
				h2.setAlignment(Pos.CENTER);
				h2.getChildren().addAll(t2, search);
				VBox vdelet = new VBox();
				Button back1 = new Button("Back");
				vdelet.setAlignment(Pos.CENTER);
				Label labelsearch = new Label();
				vdelet.getChildren().addAll(h2, labelsearch, back1);
				vdelet.setSpacing(20);
				Scene scene4 = new Scene(vdelet, 400, 400);
				primaryStage.setScene(scene4);
				back1.setOnAction(e2 -> {
					primaryStage.setScene(scene2);

				});

				search.setOnAction(e5 -> {

					labelsearch.setText("");

					String name = t2.getText().replaceAll(" ", "_").trim();
					if (name.equals("")) {
						labelsearch.setText("please enter the name");
						return;

					}
					for (int i = 0; i < martyr.size(); i++) {
						if (name.toLowerCase().equals(martyr.get(i).name.toLowerCase())) {

							labelsearch.setText(martyr.get(i).toString());

							t2.setText("");
							return;

						}

					}

					t2.setText("");
				});

			});
			button4.setOnAction(e5 -> {

				ComboBox<String> como = new ComboBox<>();
				como.getItems().addAll("age", "gender", "Date");
				TextField t2 = new TextField();
				Button number = new Button("Enter the data");
				HBox h2 = new HBox();
				h2.setSpacing(10);
				h2.setAlignment(Pos.CENTER);
				h2.getChildren().addAll(t2, number, como);
				VBox vdelet = new VBox();
				Button back1 = new Button("Back");
				vdelet.setAlignment(Pos.CENTER);
				Label labelsearch = new Label();
				vdelet.getChildren().addAll(h2, labelsearch, back1);
				vdelet.setSpacing(20);
				Scene scene4 = new Scene(vdelet, 400, 400);
				primaryStage.setScene(scene4);
				back1.setOnAction(e2 -> {
					primaryStage.setScene(scene2);

				});
				number.setOnAction(e6 -> {
					String data = t2.getText().trim();
					int number1 = 0;

					if (data.equals("")) {
						labelsearch.setText("please enter the data");
						return;

					}
					if (como.getValue() == null) {
						labelsearch.setText("please enter any choser");
						return;
					}
					switch (como.getValue()) {
					case "age":

						try {
							Integer.parseInt(data);
						} catch (Exception e2) {

							labelsearch.setText("please enter valid data");
							return;

						}

						for (int i = 0; i < martyr.size(); i++) {

							if (martyr.get(i).age == Integer.parseInt(data)) {
								number1++;

							}

						}

						labelsearch.setText(number1 + "");
						break;

					case "gender":
						if (data == "" || data.trim().length() > 1) {
							labelsearch.setText("please enter valid data");
							return;
						}

						for (int i = 0; i < martyr.size(); i++) {

							if (martyr.get(i).gender == data.trim().toUpperCase().charAt(0)) {
								number1++;

							}

						}

						labelsearch.setText(number1 + "");
						t2.setText("");
						break;

					default:

						if (data == "") {
							labelsearch.setText("please enter valid data");
							return;
						}

						for (int i = 0; i < martyr.size(); i++) {

							if (martyr.get(i).DateOfdeath.equals(data.trim())) {
								number1++;

							}

						}

						labelsearch.setText(number1 + "");

						break;
					}

				});

			});

		});

		Scene scene = new Scene(s1, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
