package phase2;

import java.io.File;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class LoadFx extends Application { // Class Fx for the First screen(Load file).

	private Label lblLoad, lblResult;
	private Button btLoad;
	DistrictFx districtS = new DistrictFx();

	public void start(Stage primaryStage) {

		FileChooser fileChooser = new FileChooser();

		VBox pane = new VBox(20);
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setAlignment(Pos.CENTER);
		lblLoad = new Label("Load the file here (.csv/.txt):");
		lblLoad.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		btLoad = new Button("Load");
		btLoad.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		lblResult = new Label();
		lblResult.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane.getChildren().addAll(lblLoad, btLoad, lblResult);

		Scene scene2 = new Scene(districtS.getPane(), 1100, 600);

		btLoad.setOnAction(e -> {

			System.out.println("Load button clicked !\n"); // This is the fileChooser for the user what will he choose
															// (.csv\.txt).
			fileChooser.setTitle("Open File");
			fileChooser.setInitialDirectory(new File("C:\\"));
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel file", "*.csv"),
					new FileChooser.ExtensionFilter("Text file", "*.txt"));
			File selectedFile = fileChooser.showOpenDialog(primaryStage);

			try {

				Scanner sc = new Scanner(selectedFile);
				sc.nextLine();

				while (sc.hasNextLine()) {

					String row[] = sc.nextLine().split(",");
					String name = row[0];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
					LocalDate date = LocalDate.parse(row[1], formatter);

					int age;
					if (row[2] == "") {

						age = 0;
					} else {

						age = Integer.parseInt(row[2]);
					}
					String location = row[3];
					String district = row[4];
					String gender = row[5];

					if (age != 0) {

						DistrictRecord d = new DistrictRecord(district);
						LocationRecord l = new LocationRecord(location);
						DateRecord r = new DateRecord(date);
						MartyrRecord martyr = new MartyrRecord(name, age, gender);

						districtS.getDistricts().insert(d);

						districtS.getDistricts().find(d).getData().getLocations().insert(l);

						districtS.getDistricts().find(d).getData().getLocations().find(l).getData().getMartyrDate()
								.insert(r);

						districtS.getDistricts().find(d).getData().getLocations().find(l).getData().getMartyrDate()
								.find(r).getData().getMartyrs().insert(martyr);

					}

				}

				cbDistricts(districtS.getDistricts().getRoot());

//------------------------------------------------------------------

				System.out.println("\n");

				districtS.getDistricts().traverseInOrder();   //--------------> to print the data.

				System.out.println("\n");

				traverseInOrderD(districtS.getDistricts().getRoot());



				System.out.println("\n");

//-------------------------------------------------------------------

				lblResult.setText("Load file successfully\n" + selectedFile.getPath());

				System.out.println("District Screen !\n"); // when the user clicked the load button it will transport to
															// the District screen.
				primaryStage.close();

				primaryStage.setTitle("District_Screen");
				primaryStage.setScene(scene2);
				primaryStage.show();

				sc.close();

			} catch (FileNotFoundException ex) {

				ex.printStackTrace();
			}

		});

		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Load martyrs");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);
	}

	private void traverseInOrderD(TNode<DistrictRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderD(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getLocations().traverseInOrder();
			traverseInOrderL(node.getData().getLocations().getRoot());

			if (node.getRight() != null)

				traverseInOrderD(node.getRight());

		}
	}

	private void traverseInOrderL(TNode<LocationRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderL(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getMartyrDate().traverseInOrder();
			traverseInOrderM(node.getData().getMartyrDate().getRoot());

			if (node.getRight() != null)

				traverseInOrderL(node.getRight());

		}
	}

	private void traverseInOrderM(TNode<DateRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderM(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getMartyrs().traverse();
			;

			if (node.getRight() != null)

				traverseInOrderM(node.getRight());

		}
	}

	private void cbDistricts(TNode<DistrictRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				cbDistricts(node.getLeft());

			districtS.getCbDistricts().getItems().add(node.getData().getDistrictName());

			if (node.getRight() != null)

				cbDistricts(node.getRight());

		}
	}
}
